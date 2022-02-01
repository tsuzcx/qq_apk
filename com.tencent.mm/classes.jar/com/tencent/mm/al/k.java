package com.tencent.mm.al;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.u;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.cwb;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.protocal.protobuf.wv;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class k
{
  private static final com.tencent.mm.b.f<Long, Long> hxZ;
  private b.a fnd;
  private int hxS;
  private d hxT;
  private int hxU;
  private int hxV;
  private boolean hxW;
  private n.b hxX;
  public cwb hxY;
  private String userName;
  
  static
  {
    AppMethodBeat.i(176144);
    hxZ = new com.tencent.mm.b.h(20);
    AppMethodBeat.o(176144);
  }
  
  protected k()
  {
    AppMethodBeat.i(124090);
    this.userName = null;
    this.hxS = 0;
    this.hxU = 2;
    this.hxV = 10;
    this.hxW = false;
    this.hxX = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(124086);
        if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String)))
        {
          ac.i("MicroMsg.ReportLocation", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousn, paramAnonymousObject });
          AppMethodBeat.o(124086);
          return;
        }
        if ((k.a(k.this).equals((String)paramAnonymousObject)) && (k.b(k.this) == 1))
        {
          ac.i("MicroMsg.ReportLocation", "contactStgUpdate, %s", new Object[] { k.a(k.this) });
          k.this.Bd(k.a(k.this));
          ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().b(k.c(k.this));
        }
        AppMethodBeat.o(124086);
      }
    };
    this.fnd = new b.a()
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
        ac.i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        if (bs.aNx() >= this.lastReportTime + k.d(k.this))
        {
          k.a(k.a(k.this), paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2);
          this.lastReportTime = bs.aNx();
        }
        if (k.b(k.this) == 2) {
          k.this.aCJ();
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
    this.hxV = bs.getInt(((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZZ().ag("BrandService", "continueLocationReportInterval"), 5);
    if (this.hxV < this.hxU) {
      this.hxV = this.hxU;
    }
    ac.i("MicroMsg.ReportLocation", "reportLocation interval %d", new Object[] { Integer.valueOf(this.hxV) });
    AppMethodBeat.o(124090);
  }
  
  public static void Bb(String paramString)
  {
    AppMethodBeat.i(176139);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176139);
      return;
    }
    if (f.AS(paramString)) {
      af.aDh().a(paramString, null, 0, null);
    }
    AppMethodBeat.o(176139);
  }
  
  public static void Bc(String paramString)
  {
    AppMethodBeat.i(176140);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176140);
      return;
    }
    if (f.AS(paramString)) {
      af.aDh().a(paramString, null);
    }
    AppMethodBeat.o(176140);
  }
  
  public static void a(cwb paramcwb, String paramString)
  {
    AppMethodBeat.i(124093);
    if ((paramcwb == null) || (paramcwb.FGG <= 0))
    {
      AppMethodBeat.o(124093);
      return;
    }
    int i = Math.min(paramcwb.FGG, 30);
    paramcwb.FGJ = 0;
    paramcwb.FGK = 0;
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().n(paramString, i, 0L);
    while (paramString.moveToNext())
    {
      Object localObject = new bo();
      ((bo)localObject).convertFrom(paramString);
      if (((dy)localObject).field_isSend != 1) {
        if (((bo)localObject).fbz())
        {
          paramcwb.FGK += 1;
        }
        else
        {
          localObject = bi.yr(((dy)localObject).eul);
          if ((localObject != null) && (((bi.b)localObject).hov == 3)) {
            paramcwb.FGJ += 1;
          }
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(124093);
  }
  
  public static void a(final ai paramai, bo parambo, final int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(176141);
    long l = System.currentTimeMillis();
    if ((hxZ.get(Long.valueOf(parambo.field_msgId)) != null) && (l - ((Long)hxZ.get(Long.valueOf(parambo.field_msgId))).longValue() < 1000L))
    {
      AppMethodBeat.o(176141);
      return;
    }
    hxZ.put(Long.valueOf(parambo.field_msgId), Long.valueOf(l));
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176138);
        Object localObject1 = "";
        int i;
        if (this.hmq.isText()) {
          i = 1;
        }
        for (;;)
        {
          if (i <= 0)
          {
            AppMethodBeat.o(176138);
            return;
            if (this.hmq.eZm())
            {
              i = 2;
            }
            else if (this.hmq.eZj())
            {
              localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(this.hmq.field_msgId, this.hmq.field_content);
              if ((localObject1 == null) || (bs.gY(((u)localObject1).hkS))) {
                break label343;
              }
            }
          }
        }
        label343:
        for (localObject1 = ((com.tencent.mm.ah.v)((u)localObject1).hkS.get(0)).url;; localObject1 = "")
        {
          i = 3;
          break;
          if (this.hmq.crt())
          {
            i = 5;
            break;
          }
          if ((this.hmq.cKN()) && (this.hmq.field_content != null))
          {
            Object localObject2 = k.b.vA(this.hmq.field_content);
            if ((localObject2 != null) && ((33 == ((k.b)localObject2).type) || (36 == ((k.b)localObject2).type)))
            {
              localObject1 = ((k.b)localObject2).url;
              i = 4;
              break;
              localObject2 = "";
              if (!bs.isNullOrNil((String)localObject1)) {
                localObject2 = x.aId((String)localObject1);
              }
              int j = paramInt2;
              int k = paramInt1;
              int m = k.G(this.hmq);
              com.tencent.mm.plugin.report.service.h.wUl.f(19202, new Object[] { paramai.field_username, Integer.valueOf(i), localObject2, Integer.valueOf(1), Integer.valueOf(j - k - 1), Long.valueOf(this.hmq.field_createTime), Long.valueOf(paramLong), Integer.valueOf(m) });
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
  
  public static void a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, LinkedList<wv> paramLinkedList, int paramInt4, cwb paramcwb, cxh paramcxh)
  {
    AppMethodBeat.i(124099);
    if (paramInt2 == 3) {}
    for (String str = "<event></event>";; str = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) }))
    {
      ac.i("MicroMsg.ReportLocation", "doScene, info: %s", new Object[] { str });
      g.agQ().ghe.a(new v(paramString, paramInt1, str, paramLinkedList, paramInt4, paramcwb, paramcxh), 0);
      AppMethodBeat.o(124099);
      return;
    }
  }
  
  public static void a(String paramString, cxh paramcxh, int paramInt)
  {
    AppMethodBeat.i(124094);
    a(paramString, paramInt, 0, 0.0F, 0.0F, 0, null, 0, null, paramcxh);
    AppMethodBeat.o(124094);
  }
  
  private static void b(String paramString, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    AppMethodBeat.i(124098);
    a(paramString, 11, paramInt1, paramFloat1, paramFloat2, paramInt2, null, 0, null, null);
    AppMethodBeat.o(124098);
  }
  
  public final void Ba(String paramString)
  {
    AppMethodBeat.i(209531);
    a(paramString, 14, 0, 0.0F, 0.0F, 0, null, 0, this.hxY, null);
    AppMethodBeat.o(209531);
  }
  
  public final void Bd(String paramString)
  {
    AppMethodBeat.i(124095);
    ac.i("MicroMsg.ReportLocation", "Start report");
    this.userName = paramString;
    Object localObject = f.dX(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(124095);
      return;
    }
    if (this.hxS != 0) {
      aCJ();
    }
    this.hxS = 0;
    if (((com.tencent.mm.api.c)localObject).IH())
    {
      ac.i("MicroMsg.ReportLocation", "need update contact %s", new Object[] { paramString });
      com.tencent.mm.aj.c.zU(paramString);
    }
    c.b localb = ((com.tencent.mm.api.c)localObject).bV(false);
    if (localb == null)
    {
      AppMethodBeat.o(124095);
      return;
    }
    if ((localb.IJ()) && (((com.tencent.mm.api.c)localObject).IG()))
    {
      this.hxT = d.aEL();
      localObject = ((com.tencent.mm.api.c)localObject).bV(false);
      boolean bool;
      if (((c.b)localObject).cFq != null)
      {
        if (bs.getInt(((c.b)localObject).cFq.optString("ReportLocationType"), 0) == 2)
        {
          bool = true;
          ((c.b)localObject).cFE = bool;
        }
      }
      else {
        if (!((c.b)localObject).cFE) {
          break label218;
        }
      }
      label218:
      for (int i = 3;; i = 2)
      {
        this.hxS = i;
        if ((!d.aEM()) && (!d.aEN())) {
          break label223;
        }
        this.hxT.a(this.fnd, true);
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
    if ((localb.IJ()) && (!((com.tencent.mm.api.c)localObject).IG())) {
      a(paramString, 1, 0.0F, 0.0F, 0);
    }
    AppMethodBeat.o(124095);
  }
  
  public final void a(final String paramString, final cwb paramcwb)
  {
    AppMethodBeat.i(124092);
    com.tencent.e.h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124089);
        k.a(paramcwb, paramString);
        k.a(paramString, 12, null, 0, paramcwb);
        AppMethodBeat.o(124089);
      }
    });
    AppMethodBeat.o(124092);
  }
  
  public final void a(final String paramString, final bo parambo, final int paramInt, final cwb paramcwb)
  {
    AppMethodBeat.i(124091);
    com.tencent.e.h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124088);
        k.a(paramcwb, paramString);
        if ((parambo == null) || (!parambo.eZj()))
        {
          k.a(paramString, 10, null, paramInt, paramcwb);
          AppMethodBeat.o(124088);
          return;
        }
        LinkedList localLinkedList = new LinkedList();
        Object localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambo.field_msgId, parambo.field_content);
        if ((localObject1 == null) || (bs.gY(((u)localObject1).hkS)))
        {
          k.a(paramString, 10, null, paramInt, paramcwb);
          AppMethodBeat.o(124088);
          return;
        }
        localObject1 = ((u)localObject1).hkS.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          com.tencent.mm.ah.v localv = (com.tencent.mm.ah.v)((Iterator)localObject1).next();
          String str = localv.url;
          if (!bs.isNullOrNil(str))
          {
            Object localObject2 = Uri.parse(str);
            try
            {
              str = ((Uri)localObject2).getQueryParameter("mid");
              localObject2 = ((Uri)localObject2).getQueryParameter("idx");
              wv localwv = new wv();
              localwv.hlF = bs.getLong(str, 0L);
              localwv.idx = bs.getInt((String)localObject2, 0);
              localwv.djj = localv.hlm;
              localwv.path = localv.hlj;
              localLinkedList.add(localwv);
            }
            catch (UnsupportedOperationException localUnsupportedOperationException)
            {
              ac.w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", new Object[] { localUnsupportedOperationException.getMessage() });
            }
          }
        }
        k.a(paramString, 10, localLinkedList, paramInt, paramcwb);
        AppMethodBeat.o(124088);
      }
    });
    AppMethodBeat.o(124091);
  }
  
  public final void aCJ()
  {
    AppMethodBeat.i(124096);
    ac.i("MicroMsg.ReportLocation", "Stop report");
    this.hxS = 0;
    if (this.hxT != null) {
      this.hxT.c(this.fnd);
    }
    if (g.agP().afY()) {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().b(this.hxX);
    }
    AppMethodBeat.o(124096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.k
 * JD-Core Version:    0.7.0.1
 */