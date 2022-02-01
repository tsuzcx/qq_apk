package com.tencent.mm.am;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.u;
import com.tencent.mm.al.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.cqu;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.wk;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class k
{
  private static final com.tencent.mm.b.f<Long, Long> gXA;
  private b.a fjJ;
  private int gXt;
  private d gXu;
  private int gXv;
  private int gXw;
  private boolean gXx;
  private n.b gXy;
  public cqu gXz;
  private String userName;
  
  static
  {
    AppMethodBeat.i(176144);
    gXA = new com.tencent.mm.b.h(20);
    AppMethodBeat.o(176144);
  }
  
  protected k()
  {
    AppMethodBeat.i(124090);
    this.userName = null;
    this.gXt = 0;
    this.gXv = 2;
    this.gXw = 10;
    this.gXx = false;
    this.gXy = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(124086);
        if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String)))
        {
          ad.i("MicroMsg.ReportLocation", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousn, paramAnonymousObject });
          AppMethodBeat.o(124086);
          return;
        }
        if ((k.a(k.this).equals((String)paramAnonymousObject)) && (k.b(k.this) == 1))
        {
          ad.i("MicroMsg.ReportLocation", "contactStgUpdate, %s", new Object[] { k.a(k.this) });
          k.this.wX(k.a(k.this));
          ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().b(k.c(k.this));
        }
        AppMethodBeat.o(124086);
      }
    };
    this.fjJ = new b.a()
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
        ad.i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        if (bt.aGK() >= this.lastReportTime + k.d(k.this))
        {
          k.a(k.a(k.this), paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2);
          this.lastReportTime = bt.aGK();
        }
        if (k.b(k.this) == 2) {
          k.this.avR();
        }
        if (!k.e(k.this))
        {
          k.f(k.this);
          o.a(2013, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        }
        AppMethodBeat.o(124087);
        return true;
      }
    };
    this.gXw = bt.getInt(((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Ze().ad("BrandService", "continueLocationReportInterval"), 5);
    if (this.gXw < this.gXv) {
      this.gXw = this.gXv;
    }
    ad.i("MicroMsg.ReportLocation", "reportLocation interval %d", new Object[] { Integer.valueOf(this.gXw) });
    AppMethodBeat.o(124090);
  }
  
  public static void a(cqu paramcqu, String paramString)
  {
    AppMethodBeat.i(124093);
    if ((paramcqu == null) || (paramcqu.EjI <= 0))
    {
      AppMethodBeat.o(124093);
      return;
    }
    int i = Math.min(paramcqu.EjI, 30);
    paramcqu.EjL = 0;
    paramcqu.EjM = 0;
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().n(paramString, i, 0L);
    while (paramString.moveToNext())
    {
      Object localObject = new bl();
      ((bl)localObject).convertFrom(paramString);
      if (((du)localObject).field_isSend != 1) {
        if (((bl)localObject).eLV())
        {
          paramcqu.EjM += 1;
        }
        else
        {
          localObject = bi.ul(((du)localObject).esh);
          if ((localObject != null) && (((bi.b)localObject).gNV == 3)) {
            paramcqu.EjL += 1;
          }
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(124093);
  }
  
  public static void a(final com.tencent.mm.storage.af paramaf, bl parambl, final int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(176141);
    long l = System.currentTimeMillis();
    if ((gXA.get(Long.valueOf(parambl.field_msgId)) != null) && (l - ((Long)gXA.get(Long.valueOf(parambl.field_msgId))).longValue() < 1000L))
    {
      AppMethodBeat.o(176141);
      return;
    }
    gXA.put(Long.valueOf(parambl.field_msgId), Long.valueOf(l));
    com.tencent.e.h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176138);
        Object localObject1 = "";
        int i;
        if (this.gLQ.isText()) {
          i = 1;
        }
        for (;;)
        {
          if (i <= 0)
          {
            AppMethodBeat.o(176138);
            return;
            if (this.gLQ.eJO())
            {
              i = 2;
            }
            else if (this.gLQ.eJL())
            {
              localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(this.gLQ.field_msgId, this.gLQ.field_content);
              if ((localObject1 == null) || (bt.gL(((u)localObject1).gKs))) {
                break label343;
              }
            }
          }
        }
        label343:
        for (localObject1 = ((com.tencent.mm.ai.v)((u)localObject1).gKs.get(0)).url;; localObject1 = "")
        {
          i = 3;
          break;
          if (this.gLQ.cjM())
          {
            i = 5;
            break;
          }
          if ((this.gLQ.cxB()) && (this.gLQ.field_content != null))
          {
            Object localObject2 = k.b.rx(this.gLQ.field_content);
            if ((localObject2 != null) && ((33 == ((k.b)localObject2).type) || (36 == ((k.b)localObject2).type)))
            {
              localObject1 = ((k.b)localObject2).url;
              i = 4;
              break;
              localObject2 = "";
              if (!bt.isNullOrNil((String)localObject1)) {
                localObject2 = x.aCL((String)localObject1);
              }
              int j = paramInt2;
              int k = paramInt1;
              int m = k.G(this.gLQ);
              com.tencent.mm.plugin.report.service.h.vKh.f(19202, new Object[] { paramaf.field_username, Integer.valueOf(i), localObject2, Integer.valueOf(1), Integer.valueOf(j - k - 1), Long.valueOf(this.gLQ.field_createTime), Long.valueOf(paramLong), Integer.valueOf(m) });
              AppMethodBeat.o(176138);
              return;
            }
          }
          i = 0;
          break;
        }
      }
    }, "BizServicesReportThread");
    AppMethodBeat.o(176141);
  }
  
  private static void a(String paramString, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    AppMethodBeat.i(124097);
    b(paramString, paramInt1, paramFloat1, paramFloat2, paramInt2);
    AppMethodBeat.o(124097);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, LinkedList<wk> paramLinkedList, int paramInt4, cqu paramcqu, cry paramcry)
  {
    AppMethodBeat.i(124099);
    if (paramInt2 == 3) {}
    for (String str = "<event></event>";; str = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) }))
    {
      ad.i("MicroMsg.ReportLocation", "doScene, info: %s", new Object[] { str });
      g.afA().gcy.a(new v(paramString, paramInt1, str, paramLinkedList, paramInt4, paramcqu, paramcry), 0);
      AppMethodBeat.o(124099);
      return;
    }
  }
  
  public static void a(String paramString, cry paramcry, int paramInt)
  {
    AppMethodBeat.i(124094);
    a(paramString, paramInt, 0, 0.0F, 0.0F, 0, null, 0, null, paramcry);
    AppMethodBeat.o(124094);
  }
  
  private static void b(String paramString, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    AppMethodBeat.i(124098);
    a(paramString, 11, paramInt1, paramFloat1, paramFloat2, paramInt2, null, 0, null, null);
    AppMethodBeat.o(124098);
  }
  
  public static void wV(String paramString)
  {
    AppMethodBeat.i(176139);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176139);
      return;
    }
    if (f.wM(paramString)) {
      af.awp().a(paramString, null, 0, null);
    }
    AppMethodBeat.o(176139);
  }
  
  public static void wW(String paramString)
  {
    AppMethodBeat.i(176140);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176140);
      return;
    }
    if (f.wM(paramString)) {
      af.awp().a(paramString, null);
    }
    AppMethodBeat.o(176140);
  }
  
  public final void a(final String paramString, final cqu paramcqu)
  {
    AppMethodBeat.i(124092);
    com.tencent.e.h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124089);
        k.a(paramcqu, paramString);
        k.a(paramString, 12, null, 0, paramcqu);
        AppMethodBeat.o(124089);
      }
    });
    AppMethodBeat.o(124092);
  }
  
  public final void a(final String paramString, final bl parambl, final int paramInt, final cqu paramcqu)
  {
    AppMethodBeat.i(124091);
    com.tencent.e.h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124088);
        k.a(paramcqu, paramString);
        if ((parambl == null) || (!parambl.eJL()))
        {
          k.a(paramString, 10, null, paramInt, paramcqu);
          AppMethodBeat.o(124088);
          return;
        }
        LinkedList localLinkedList = new LinkedList();
        Object localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambl.field_msgId, parambl.field_content);
        if ((localObject1 == null) || (bt.gL(((u)localObject1).gKs)))
        {
          k.a(paramString, 10, null, paramInt, paramcqu);
          AppMethodBeat.o(124088);
          return;
        }
        localObject1 = ((u)localObject1).gKs.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          com.tencent.mm.ai.v localv = (com.tencent.mm.ai.v)((Iterator)localObject1).next();
          String str = localv.url;
          if (!bt.isNullOrNil(str))
          {
            Object localObject2 = Uri.parse(str);
            try
            {
              str = ((Uri)localObject2).getQueryParameter("mid");
              localObject2 = ((Uri)localObject2).getQueryParameter("idx");
              wk localwk = new wk();
              localwk.gLf = bt.getLong(str, 0L);
              localwk.idx = bt.getInt((String)localObject2, 0);
              localwk.dlB = localv.gKM;
              localwk.path = localv.gKJ;
              localLinkedList.add(localwk);
            }
            catch (UnsupportedOperationException localUnsupportedOperationException)
            {
              ad.w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", new Object[] { localUnsupportedOperationException.getMessage() });
            }
          }
        }
        k.a(paramString, 10, localLinkedList, paramInt, paramcqu);
        AppMethodBeat.o(124088);
      }
    });
    AppMethodBeat.o(124091);
  }
  
  public final void avR()
  {
    AppMethodBeat.i(124096);
    ad.i("MicroMsg.ReportLocation", "Stop report");
    this.gXt = 0;
    if (this.gXu != null) {
      this.gXu.c(this.fjJ);
    }
    if (g.afz().aeI()) {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().b(this.gXy);
    }
    AppMethodBeat.o(124096);
  }
  
  public final void wU(String paramString)
  {
    AppMethodBeat.i(191055);
    a(paramString, 14, 0, 0.0F, 0.0F, 0, null, 0, this.gXz, null);
    AppMethodBeat.o(191055);
  }
  
  public final void wX(String paramString)
  {
    AppMethodBeat.i(124095);
    ad.i("MicroMsg.ReportLocation", "Start report");
    this.userName = paramString;
    Object localObject = f.ei(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(124095);
      return;
    }
    if (this.gXt != 0) {
      avR();
    }
    this.gXt = 0;
    if (((com.tencent.mm.api.c)localObject).IY())
    {
      ad.i("MicroMsg.ReportLocation", "need update contact %s", new Object[] { paramString });
      com.tencent.mm.ak.c.vO(paramString);
    }
    c.b localb = ((com.tencent.mm.api.c)localObject).bU(false);
    if (localb == null)
    {
      AppMethodBeat.o(124095);
      return;
    }
    if ((localb.Ja()) && (((com.tencent.mm.api.c)localObject).IX()))
    {
      this.gXu = d.axT();
      localObject = ((com.tencent.mm.api.c)localObject).bU(false);
      boolean bool;
      if (((c.b)localObject).cIj != null)
      {
        if (bt.getInt(((c.b)localObject).cIj.optString("ReportLocationType"), 0) == 2)
        {
          bool = true;
          ((c.b)localObject).cIx = bool;
        }
      }
      else {
        if (!((c.b)localObject).cIx) {
          break label218;
        }
      }
      label218:
      for (int i = 3;; i = 2)
      {
        this.gXt = i;
        if ((!d.axU()) && (!d.axV())) {
          break label223;
        }
        this.gXu.a(this.fjJ, true);
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
    if ((localb.Ja()) && (!((com.tencent.mm.api.c)localObject).IX())) {
      a(paramString, 1, 0.0F, 0.0F, 0);
    }
    AppMethodBeat.o(124095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.k
 * JD-Core Version:    0.7.0.1
 */