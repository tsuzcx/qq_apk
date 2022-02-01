package com.tencent.mm.al;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class l
{
  private static long iOB;
  private b.a gmA;
  public dvm iOA;
  private int iOu;
  private com.tencent.mm.modelgeo.d iOv;
  private int iOw;
  private int iOx;
  private boolean iOy;
  private MStorageEx.IOnStorageChange iOz;
  private String userName;
  
  static
  {
    AppMethodBeat.i(176144);
    iOB = 0L;
    AppMethodBeat.o(176144);
  }
  
  protected l()
  {
    AppMethodBeat.i(124090);
    this.userName = null;
    this.iOu = 0;
    this.iOw = 2;
    this.iOx = 10;
    this.iOy = false;
    this.iOz = new MStorageEx.IOnStorageChange()
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
          l.this.Ns(l.a(l.this));
          ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().remove(l.c(l.this));
        }
        AppMethodBeat.o(124086);
      }
    };
    this.gmA = new b.a()
    {
      long lastReportTime = 0L;
      
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(124087);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(124087);
          return true;
        }
        Log.i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        if (Util.nowSecond() >= this.lastReportTime + l.d(l.this))
        {
          l.a(l.this, l.a(l.this), paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2);
          this.lastReportTime = Util.nowSecond();
        }
        if (l.b(l.this) == 2) {
          l.this.aZU();
        }
        if (!l.e(l.this))
        {
          l.f(l.this);
          o.a(2013, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        }
        AppMethodBeat.o(124087);
        return true;
      }
    };
    this.iOx = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqK().aj("BrandService", "continueLocationReportInterval"), 5);
    if (this.iOx < this.iOw) {
      this.iOx = this.iOw;
    }
    Log.i("MicroMsg.ReportLocation", "reportLocation interval %d", new Object[] { Integer.valueOf(this.iOx) });
    AppMethodBeat.o(124090);
  }
  
  public static void Nq(String paramString)
  {
    AppMethodBeat.i(176139);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176139);
      return;
    }
    if (g.Nh(paramString)) {
      ag.bat().a(paramString, null, 0, null);
    }
    AppMethodBeat.o(176139);
  }
  
  public static void Nr(String paramString)
  {
    AppMethodBeat.i(176140);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176140);
      return;
    }
    if (g.Nh(paramString)) {
      ag.bat().a(paramString, null);
    }
    AppMethodBeat.o(176140);
  }
  
  public static void S(ca paramca)
  {
    AppMethodBeat.i(212171);
    b.a(paramca, iOB);
    AppMethodBeat.o(212171);
  }
  
  public static void a(dvm paramdvm, String paramString)
  {
    AppMethodBeat.i(124093);
    if ((paramdvm == null) || (paramdvm.MWA <= 0))
    {
      AppMethodBeat.o(124093);
      return;
    }
    int i = Math.min(paramdvm.MWA, 30);
    paramdvm.MWD = 0;
    paramdvm.MWE = 0;
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().H(paramString, i, 0L);
    while (paramString.moveToNext())
    {
      Object localObject = new ca();
      ((ca)localObject).convertFrom(paramString);
      if (((eo)localObject).field_isSend != 1) {
        if (((ca)localObject).gDj())
        {
          paramdvm.MWE += 1;
        }
        else
        {
          localObject = bp.Ky(((eo)localObject).fqK);
          if ((localObject != null) && (((bp.b)localObject).iEp == 3)) {
            paramdvm.MWD += 1;
          }
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(124093);
  }
  
  public static void a(as paramas, ca paramca, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(176141);
    iOB = paramLong;
    b.a(paramas, paramca, paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(176141);
  }
  
  private static void a(String paramString, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    AppMethodBeat.i(124097);
    a(paramString, 11, paramInt1, paramFloat1, paramFloat2, paramInt2, null);
    AppMethodBeat.o(124097);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, LinkedList<aam> paramLinkedList)
  {
    AppMethodBeat.i(212170);
    a(paramString, 11, paramInt2, paramFloat1, paramFloat2, paramInt3, null, 0, null, null);
    AppMethodBeat.o(212170);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, LinkedList<aam> paramLinkedList, int paramInt4, dvm paramdvm, dws paramdws)
  {
    AppMethodBeat.i(124099);
    if (paramInt2 == 3) {}
    for (String str = "<event></event>";; str = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) }))
    {
      Log.i("MicroMsg.ReportLocation", "doScene, info: %s", new Object[] { str });
      com.tencent.mm.kernel.g.aAg().hqi.a(new w(paramString, paramInt1, str, paramLinkedList, paramInt4, paramdvm, paramdws), 0);
      AppMethodBeat.o(124099);
      return;
    }
  }
  
  public static void a(String paramString, dws paramdws, int paramInt)
  {
    AppMethodBeat.i(124094);
    a(paramString, paramInt, 0, 0.0F, 0.0F, 0, null, 0, null, paramdws);
    AppMethodBeat.o(124094);
  }
  
  public static void c(ca paramca, long paramLong)
  {
    AppMethodBeat.i(258698);
    b.a(paramca, paramLong);
    AppMethodBeat.o(258698);
  }
  
  public final void Np(String paramString)
  {
    AppMethodBeat.i(212169);
    a(paramString, 14, 0, 0.0F, 0.0F, 0, null, 0, this.iOA, null);
    AppMethodBeat.o(212169);
  }
  
  public final void Ns(String paramString)
  {
    AppMethodBeat.i(124095);
    Log.i("MicroMsg.ReportLocation", "Start report");
    this.userName = paramString;
    Object localObject = g.fJ(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(124095);
      return;
    }
    if (this.iOu != 0) {
      aZU();
    }
    this.iOu = 0;
    if (((com.tencent.mm.api.c)localObject).Uz())
    {
      Log.i("MicroMsg.ReportLocation", "need update contact %s", new Object[] { paramString });
      com.tencent.mm.aj.c.Mf(paramString);
    }
    c.b localb = ((com.tencent.mm.api.c)localObject).cG(false);
    if (localb == null)
    {
      AppMethodBeat.o(124095);
      return;
    }
    if ((localb.UB()) && (((com.tencent.mm.api.c)localObject).Uy()))
    {
      this.iOv = com.tencent.mm.modelgeo.d.bca();
      localObject = ((com.tencent.mm.api.c)localObject).cG(false);
      boolean bool;
      if (((c.b)localObject).dhz != null)
      {
        if (Util.getInt(((c.b)localObject).dhz.optString("ReportLocationType"), 0) == 2)
        {
          bool = true;
          ((c.b)localObject).dhN = bool;
        }
      }
      else {
        if (!((c.b)localObject).dhN) {
          break label218;
        }
      }
      label218:
      for (int i = 3;; i = 2)
      {
        this.iOu = i;
        if ((!com.tencent.mm.modelgeo.d.bcc()) && (!com.tencent.mm.modelgeo.d.bcd())) {
          break label223;
        }
        this.iOv.a(this.gmA, true);
        AppMethodBeat.o(124095);
        return;
        bool = false;
        break;
      }
      label223:
      a(paramString, 2, 0.0F, 0.0F, 0);
      AppMethodBeat.o(124095);
      return;
    }
    if ((localb.UB()) && (!((com.tencent.mm.api.c)localObject).Uy())) {
      a(paramString, 1, 0.0F, 0.0F, 0);
    }
    AppMethodBeat.o(124095);
  }
  
  public final void a(final String paramString, final dvm paramdvm)
  {
    AppMethodBeat.i(124092);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124089);
        l.a(paramdvm, paramString);
        l.a(paramString, 12, null, 0, paramdvm);
        AppMethodBeat.o(124089);
      }
    });
    AppMethodBeat.o(124092);
  }
  
  public final void a(final String paramString, final ca paramca, final int paramInt, final dvm paramdvm)
  {
    AppMethodBeat.i(124091);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124088);
        l.a(paramdvm, paramString);
        if ((paramca == null) || (!paramca.gAt()))
        {
          l.a(paramString, 10, null, paramInt, paramdvm);
          AppMethodBeat.o(124088);
          return;
        }
        LinkedList localLinkedList = new LinkedList();
        Object localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramca.field_msgId, paramca.field_content);
        if ((localObject1 == null) || (Util.isNullOrNil(((u)localObject1).iAd)))
        {
          l.a(paramString, 10, null, paramInt, paramdvm);
          AppMethodBeat.o(124088);
          return;
        }
        localObject1 = ((u)localObject1).iAd.iterator();
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
              aam localaam = new aam();
              localaam.iAQ = Util.getLong(str, 0L);
              localaam.idx = Util.getInt((String)localObject2, 0);
              localaam.dNI = localv.iAv;
              localaam.path = localv.weappPath;
              localLinkedList.add(localaam);
            }
            catch (UnsupportedOperationException localUnsupportedOperationException)
            {
              Log.w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", new Object[] { localUnsupportedOperationException.getMessage() });
            }
          }
        }
        l.a(paramString, 10, localLinkedList, paramInt, paramdvm);
        AppMethodBeat.o(124088);
      }
    });
    AppMethodBeat.o(124091);
  }
  
  public final void aZU()
  {
    AppMethodBeat.i(124096);
    Log.i("MicroMsg.ReportLocation", "Stop report");
    this.iOu = 0;
    if (this.iOv != null) {
      this.iOv.c(this.gmA);
    }
    if (com.tencent.mm.kernel.g.aAf().azp()) {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().remove(this.iOz);
    }
    AppMethodBeat.o(124096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.al.l
 * JD-Core Version:    0.7.0.1
 */