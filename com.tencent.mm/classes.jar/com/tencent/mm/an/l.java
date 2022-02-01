package com.tencent.mm.an;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.api.c.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.protocal.protobuf.ezh;
import com.tencent.mm.protocal.protobuf.fas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class l
{
  private static long owx;
  private b.a lsF;
  private int owq;
  private com.tencent.mm.modelgeo.d owr;
  private int ows;
  private int owt;
  private boolean owu;
  private MStorageEx.IOnStorageChange owv;
  public ezh oww;
  private String userName;
  
  static
  {
    AppMethodBeat.i(176144);
    owx = 0L;
    AppMethodBeat.o(176144);
  }
  
  protected l()
  {
    AppMethodBeat.i(124090);
    this.userName = null;
    this.owq = 0;
    this.ows = 2;
    this.owt = 10;
    this.owu = false;
    this.owv = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(124086);
        if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String)))
        {
          Log.i("MicroMsg.ReportLocation", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousMStorageEx, paramAnonymousObject });
          AppMethodBeat.o(124086);
          return;
        }
        if ((l.a(l.this).equals((String)paramAnonymousObject)) && (l.b(l.this) == 1))
        {
          Log.i("MicroMsg.ReportLocation", "contactStgUpdate, %s", new Object[] { l.a(l.this) });
          l.this.MN(l.a(l.this));
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().remove(l.c(l.this));
        }
        AppMethodBeat.o(124086);
      }
    };
    this.lsF = new b.a()
    {
      long lastReportTime = 0L;
      
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(239423);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(239423);
          return true;
        }
        Log.i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        if (Util.nowSecond() >= this.lastReportTime + l.d(l.this))
        {
          l.a(l.this, l.a(l.this), paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2);
          this.lastReportTime = Util.nowSecond();
        }
        if (l.b(l.this) == 2) {
          l.this.bGU();
        }
        if (!l.e(l.this))
        {
          l.f(l.this);
          com.tencent.mm.modelstat.n.a(2013, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        }
        AppMethodBeat.o(239423);
        return true;
      }
    };
    this.owt = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRD().at("BrandService", "continueLocationReportInterval"), 5);
    if (this.owt < this.ows) {
      this.owt = this.ows;
    }
    Log.i("MicroMsg.ReportLocation", "reportLocation interval %d", new Object[] { Integer.valueOf(this.owt) });
    AppMethodBeat.o(124090);
  }
  
  public static void ML(String paramString)
  {
    AppMethodBeat.i(176139);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176139);
      return;
    }
    if (g.MC(paramString)) {
      af.bHs().a(paramString, null, 0, null);
    }
    AppMethodBeat.o(176139);
  }
  
  public static void MM(String paramString)
  {
    AppMethodBeat.i(176140);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176140);
      return;
    }
    if (g.MC(paramString)) {
      af.bHs().a(paramString, null);
    }
    AppMethodBeat.o(176140);
  }
  
  public static void a(ezh paramezh, String paramString)
  {
    AppMethodBeat.i(124093);
    if ((paramezh == null) || (paramezh.abAu <= 0))
    {
      AppMethodBeat.o(124093);
      return;
    }
    int i = Math.min(paramezh.abAu, 30);
    paramezh.abAx = 0;
    paramezh.abAy = 0;
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().J(paramString, i, 0L);
    while (paramString.moveToNext())
    {
      Object localObject = new cc();
      ((cc)localObject).convertFrom(paramString);
      if (((fi)localObject).field_isSend != 1) {
        if (((cc)localObject).jbz())
        {
          paramezh.abAy += 1;
        }
        else
        {
          localObject = br.JP(((fi)localObject).jUr);
          if ((localObject != null) && (((br.b)localObject).olP == 3)) {
            paramezh.abAx += 1;
          }
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(124093);
  }
  
  public static void a(au paramau, cc paramcc, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(176141);
    owx = paramLong;
    b.a(paramau, paramcc, paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(176141);
  }
  
  private static void a(String paramString, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    AppMethodBeat.i(124097);
    a(paramString, 11, paramInt1, paramFloat1, paramFloat2, paramInt2, null);
    AppMethodBeat.o(124097);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, LinkedList<acr> paramLinkedList)
  {
    AppMethodBeat.i(239452);
    a(paramString, 11, paramInt2, paramFloat1, paramFloat2, paramInt3, null, 0, null, null);
    AppMethodBeat.o(239452);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, LinkedList<acr> paramLinkedList, int paramInt4, ezh paramezh, fas paramfas)
  {
    AppMethodBeat.i(124099);
    if (paramInt2 == 3) {}
    for (String str = "<event></event>";; str = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) }))
    {
      Log.i("MicroMsg.ReportLocation", "doScene, info: %s", new Object[] { str });
      com.tencent.mm.kernel.h.baD().mCm.a(new w(paramString, paramInt1, str, paramLinkedList, paramInt4, paramezh, paramfas), 0);
      AppMethodBeat.o(124099);
      return;
    }
  }
  
  public static void a(String paramString, fas paramfas, int paramInt)
  {
    AppMethodBeat.i(124094);
    a(paramString, paramInt, 0, 0.0F, 0.0F, 0, null, 0, null, paramfas);
    AppMethodBeat.o(124094);
  }
  
  public static void ad(cc paramcc)
  {
    AppMethodBeat.i(239460);
    b.a(paramcc, owx);
    AppMethodBeat.o(239460);
  }
  
  public static void c(cc paramcc, long paramLong)
  {
    AppMethodBeat.i(369576);
    b.a(paramcc, paramLong);
    AppMethodBeat.o(369576);
  }
  
  public final void MK(String paramString)
  {
    AppMethodBeat.i(239476);
    a(paramString, 14, 0, 0.0F, 0.0F, 0, null, 0, this.oww, null);
    AppMethodBeat.o(239476);
  }
  
  public final void MN(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(124095);
    Log.i("MicroMsg.ReportLocation", "Start report");
    this.userName = paramString;
    Object localObject = g.hU(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(124095);
      return;
    }
    if (this.owq != 0) {
      bGU();
    }
    this.owq = 0;
    if (((com.tencent.mm.api.c)localObject).aAJ())
    {
      Log.i("MicroMsg.ReportLocation", "need update contact %s", new Object[] { paramString });
      com.tencent.mm.modelavatar.d.LA(paramString);
    }
    c.b localb = ((com.tencent.mm.api.c)localObject).dO(false);
    if (localb == null)
    {
      AppMethodBeat.o(124095);
      return;
    }
    if ((localb.aAL()) && (((com.tencent.mm.api.c)localObject).aAI()))
    {
      this.owr = com.tencent.mm.modelgeo.d.bJl();
      localObject = ((com.tencent.mm.api.c)localObject).dO(false);
      int i;
      if (((c.b)localObject).hcG != null)
      {
        if (Util.getInt(((c.b)localObject).hcG.optString("ReportLocationType"), 0) == 2)
        {
          bool1 = true;
          ((c.b)localObject).hcU = bool1;
        }
      }
      else
      {
        if (!((c.b)localObject).hcU) {
          break label245;
        }
        i = 3;
        label180:
        this.owq = i;
        if ((!com.tencent.mm.modelgeo.d.bJm()) && (!com.tencent.mm.modelgeo.d.bJn())) {
          break label255;
        }
        paramString = this.owr;
        localObject = this.lsF;
        if (this.owq != 2) {
          break label250;
        }
      }
      label245:
      label250:
      for (boolean bool1 = bool2;; bool1 = true)
      {
        paramString.a((b.a)localObject, true, bool1);
        com.tencent.mm.plugin.report.service.l.kK(3, 10);
        AppMethodBeat.o(124095);
        return;
        bool1 = false;
        break;
        i = 2;
        break label180;
      }
      label255:
      a(paramString, 2, 0.0F, 0.0F, 0);
      AppMethodBeat.o(124095);
      return;
    }
    if ((localb.aAL()) && (!((com.tencent.mm.api.c)localObject).aAI())) {
      a(paramString, 1, 0.0F, 0.0F, 0);
    }
    AppMethodBeat.o(124095);
  }
  
  public final void a(final String paramString, final ezh paramezh)
  {
    AppMethodBeat.i(124092);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124089);
        l.a(paramezh, paramString);
        l.a(paramString, 12, null, 0, paramezh);
        AppMethodBeat.o(124089);
      }
    });
    AppMethodBeat.o(124092);
  }
  
  public final void a(final String paramString, final cc paramcc, final int paramInt, final ezh paramezh)
  {
    AppMethodBeat.i(124091);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124088);
        l.a(paramezh, paramString);
        if ((paramcc == null) || (!paramcc.iYe()))
        {
          l.a(paramString, 10, null, paramInt, paramezh);
          AppMethodBeat.o(124088);
          return;
        }
        LinkedList localLinkedList = new LinkedList();
        Object localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramcc.field_msgId, paramcc.field_content);
        if ((localObject1 == null) || (Util.isNullOrNil(((u)localObject1).nUC)))
        {
          l.a(paramString, 10, null, paramInt, paramezh);
          AppMethodBeat.o(124088);
          return;
        }
        localObject1 = ((u)localObject1).nUC.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          v localv = (v)((Iterator)localObject1).next();
          String str = localv.url;
          if (!Util.isNullOrNil(str))
          {
            Object localObject2 = Uri.parse(str);
            try
            {
              str = ((Uri)localObject2).getQueryParameter("mid");
              localObject2 = ((Uri)localObject2).getQueryParameter("idx");
              acr localacr = new acr();
              localacr.nVr = Util.getLong(str, 0L);
              localacr.idx = Util.getInt((String)localObject2, 0);
              localacr.appid = localv.nUV;
              localacr.path = localv.nUS;
              localLinkedList.add(localacr);
            }
            catch (UnsupportedOperationException localUnsupportedOperationException)
            {
              Log.w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", new Object[] { localUnsupportedOperationException.getMessage() });
            }
          }
        }
        l.a(paramString, 10, localLinkedList, paramInt, paramezh);
        AppMethodBeat.o(124088);
      }
    });
    AppMethodBeat.o(124091);
  }
  
  public final void bGU()
  {
    AppMethodBeat.i(124096);
    Log.i("MicroMsg.ReportLocation", "Stop report");
    this.owq = 0;
    if (this.owr != null) {
      this.owr.a(this.lsF);
    }
    if (com.tencent.mm.kernel.h.baC().aZN()) {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().remove(this.owv);
    }
    AppMethodBeat.o(124096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.l
 * JD-Core Version:    0.7.0.1
 */