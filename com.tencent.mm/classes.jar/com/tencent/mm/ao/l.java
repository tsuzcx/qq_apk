package com.tencent.mm.ao;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.an.t;
import com.tencent.mm.api.c.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.protocal.protobuf.egs;
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
  private static long lER;
  private b.a iQJ;
  private int lEK;
  private com.tencent.mm.modelgeo.d lEL;
  private int lEM;
  private int lEN;
  private boolean lEO;
  private MStorageEx.IOnStorageChange lEP;
  public efo lEQ;
  private String userName;
  
  static
  {
    AppMethodBeat.i(176144);
    lER = 0L;
    AppMethodBeat.o(176144);
  }
  
  protected l()
  {
    AppMethodBeat.i(124090);
    this.userName = null;
    this.lEK = 0;
    this.lEM = 2;
    this.lEN = 10;
    this.lEO = false;
    this.lEP = new MStorageEx.IOnStorageChange()
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
          l.this.UO(l.a(l.this));
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().remove(l.c(l.this));
        }
        AppMethodBeat.o(124086);
      }
    };
    this.iQJ = new b.a()
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
          l.this.bjk();
        }
        if (!l.e(l.this))
        {
          l.f(l.this);
          com.tencent.mm.modelstat.n.a(2013, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        }
        AppMethodBeat.o(124087);
        return true;
      }
    };
    this.lEN = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axd().ao("BrandService", "continueLocationReportInterval"), 5);
    if (this.lEN < this.lEM) {
      this.lEN = this.lEM;
    }
    Log.i("MicroMsg.ReportLocation", "reportLocation interval %d", new Object[] { Integer.valueOf(this.lEN) });
    AppMethodBeat.o(124090);
  }
  
  public static void UM(String paramString)
  {
    AppMethodBeat.i(176139);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176139);
      return;
    }
    if (g.UD(paramString)) {
      af.bjH().a(paramString, null, 0, null);
    }
    AppMethodBeat.o(176139);
  }
  
  public static void UN(String paramString)
  {
    AppMethodBeat.i(176140);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176140);
      return;
    }
    if (g.UD(paramString)) {
      af.bjH().a(paramString, null);
    }
    AppMethodBeat.o(176140);
  }
  
  public static void Y(ca paramca)
  {
    AppMethodBeat.i(205276);
    b.a(paramca, lER);
    AppMethodBeat.o(205276);
  }
  
  public static void a(efo paramefo, String paramString)
  {
    AppMethodBeat.i(124093);
    if ((paramefo == null) || (paramefo.UiV <= 0))
    {
      AppMethodBeat.o(124093);
      return;
    }
    int i = Math.min(paramefo.UiV, 30);
    paramefo.UiY = 0;
    paramefo.UiZ = 0;
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().I(paramString, i, 0L);
    while (paramString.moveToNext())
    {
      Object localObject = new ca();
      ((ca)localObject).convertFrom(paramString);
      if (((et)localObject).field_isSend != 1) {
        if (((ca)localObject).hzw())
        {
          paramefo.UiZ += 1;
        }
        else
        {
          localObject = bq.RR(((et)localObject).hxy);
          if ((localObject != null) && (((bq.b)localObject).luq == 3)) {
            paramefo.UiY += 1;
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
    lER = paramLong;
    b.a(paramas, paramca, paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(176141);
  }
  
  private static void a(String paramString, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    AppMethodBeat.i(124097);
    a(paramString, 11, paramInt1, paramFloat1, paramFloat2, paramInt2, null);
    AppMethodBeat.o(124097);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, LinkedList<aar> paramLinkedList)
  {
    AppMethodBeat.i(205270);
    a(paramString, 11, paramInt2, paramFloat1, paramFloat2, paramInt3, null, 0, null, null);
    AppMethodBeat.o(205270);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, LinkedList<aar> paramLinkedList, int paramInt4, efo paramefo, egs paramegs)
  {
    AppMethodBeat.i(124099);
    if (paramInt2 == 3) {}
    for (String str = "<event></event>";; str = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) }))
    {
      Log.i("MicroMsg.ReportLocation", "doScene, info: %s", new Object[] { str });
      com.tencent.mm.kernel.h.aHF().kcd.a(new w(paramString, paramInt1, str, paramLinkedList, paramInt4, paramefo, paramegs), 0);
      AppMethodBeat.o(124099);
      return;
    }
  }
  
  public static void a(String paramString, egs paramegs, int paramInt)
  {
    AppMethodBeat.i(124094);
    a(paramString, paramInt, 0, 0.0F, 0.0F, 0, null, 0, null, paramegs);
    AppMethodBeat.o(124094);
  }
  
  public static void c(ca paramca, long paramLong)
  {
    AppMethodBeat.i(292807);
    b.a(paramca, paramLong);
    AppMethodBeat.o(292807);
  }
  
  public final void UL(String paramString)
  {
    AppMethodBeat.i(205265);
    a(paramString, 14, 0, 0.0F, 0.0F, 0, null, 0, this.lEQ, null);
    AppMethodBeat.o(205265);
  }
  
  public final void UO(String paramString)
  {
    AppMethodBeat.i(124095);
    Log.i("MicroMsg.ReportLocation", "Start report");
    this.userName = paramString;
    Object localObject = g.gu(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(124095);
      return;
    }
    if (this.lEK != 0) {
      bjk();
    }
    this.lEK = 0;
    if (((com.tencent.mm.api.c)localObject).YR())
    {
      Log.i("MicroMsg.ReportLocation", "need update contact %s", new Object[] { paramString });
      com.tencent.mm.am.d.TA(paramString);
    }
    c.b localb = ((com.tencent.mm.api.c)localObject).dc(false);
    if (localb == null)
    {
      AppMethodBeat.o(124095);
      return;
    }
    if ((localb.YT()) && (((com.tencent.mm.api.c)localObject).YQ()))
    {
      this.lEL = com.tencent.mm.modelgeo.d.blq();
      localObject = ((com.tencent.mm.api.c)localObject).dc(false);
      boolean bool;
      if (((c.b)localObject).eZg != null)
      {
        if (Util.getInt(((c.b)localObject).eZg.optString("ReportLocationType"), 0) == 2)
        {
          bool = true;
          ((c.b)localObject).eZu = bool;
        }
      }
      else {
        if (!((c.b)localObject).eZu) {
          break label218;
        }
      }
      label218:
      for (int i = 3;; i = 2)
      {
        this.lEK = i;
        if ((!com.tencent.mm.modelgeo.d.blr()) && (!com.tencent.mm.modelgeo.d.bls())) {
          break label223;
        }
        this.lEL.a(this.iQJ, true);
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
    if ((localb.YT()) && (!((com.tencent.mm.api.c)localObject).YQ())) {
      a(paramString, 1, 0.0F, 0.0F, 0);
    }
    AppMethodBeat.o(124095);
  }
  
  public final void a(final String paramString, final efo paramefo)
  {
    AppMethodBeat.i(124092);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124089);
        l.a(paramefo, paramString);
        l.a(paramString, 12, null, 0, paramefo);
        AppMethodBeat.o(124089);
      }
    });
    AppMethodBeat.o(124092);
  }
  
  public final void a(final String paramString, final ca paramca, final int paramInt, final efo paramefo)
  {
    AppMethodBeat.i(124091);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124088);
        l.a(paramefo, paramString);
        if ((paramca == null) || (!paramca.hwA()))
        {
          l.a(paramString, 10, null, paramInt, paramefo);
          AppMethodBeat.o(124088);
          return;
        }
        LinkedList localLinkedList = new LinkedList();
        Object localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramca.field_msgId, paramca.field_content);
        if ((localObject1 == null) || (Util.isNullOrNil(((u)localObject1).lpz)))
        {
          l.a(paramString, 10, null, paramInt, paramefo);
          AppMethodBeat.o(124088);
          return;
        }
        localObject1 = ((u)localObject1).lpz.iterator();
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
              aar localaar = new aar();
              localaar.lqo = Util.getLong(str, 0L);
              localaar.idx = Util.getInt((String)localObject2, 0);
              localaar.appid = localv.lpT;
              localaar.path = localv.lpQ;
              localLinkedList.add(localaar);
            }
            catch (UnsupportedOperationException localUnsupportedOperationException)
            {
              Log.w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", new Object[] { localUnsupportedOperationException.getMessage() });
            }
          }
        }
        l.a(paramString, 10, localLinkedList, paramInt, paramefo);
        AppMethodBeat.o(124088);
      }
    });
    AppMethodBeat.o(124091);
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(124096);
    Log.i("MicroMsg.ReportLocation", "Stop report");
    this.lEK = 0;
    if (this.lEL != null) {
      this.lEL.b(this.iQJ);
    }
    if (com.tencent.mm.kernel.h.aHE().aGM()) {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().remove(this.lEP);
    }
    AppMethodBeat.o(124096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.l
 * JD-Core Version:    0.7.0.1
 */