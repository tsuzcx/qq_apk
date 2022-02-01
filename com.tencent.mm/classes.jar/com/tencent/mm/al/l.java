package com.tencent.mm.al;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.b.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.dci;
import com.tencent.mm.protocal.protobuf.ddo;
import com.tencent.mm.protocal.protobuf.yx;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class l
{
  private static final f<Long, Long> hTm;
  private b.a fHp;
  private int hTf;
  private d hTg;
  private int hTh;
  private int hTi;
  private boolean hTj;
  private n.b hTk;
  public dci hTl;
  private String userName;
  
  static
  {
    AppMethodBeat.i(176144);
    hTm = new com.tencent.mm.b.h(20);
    AppMethodBeat.o(176144);
  }
  
  protected l()
  {
    AppMethodBeat.i(124090);
    this.userName = null;
    this.hTf = 0;
    this.hTh = 2;
    this.hTi = 10;
    this.hTj = false;
    this.hTk = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(124086);
        if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof String)))
        {
          ae.i("MicroMsg.ReportLocation", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousn, paramAnonymousObject });
          AppMethodBeat.o(124086);
          return;
        }
        if ((l.a(l.this).equals((String)paramAnonymousObject)) && (l.b(l.this) == 1))
        {
          ae.i("MicroMsg.ReportLocation", "contactStgUpdate, %s", new Object[] { l.a(l.this) });
          l.this.EE(l.a(l.this));
          ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().b(l.c(l.this));
        }
        AppMethodBeat.o(124086);
      }
    };
    this.fHp = new b.a()
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
        ae.i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
        if (bu.aRi() >= this.lastReportTime + l.d(l.this))
        {
          l.a(l.a(l.this), paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2);
          this.lastReportTime = bu.aRi();
        }
        if (l.b(l.this) == 2) {
          l.this.aGc();
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
    this.hTi = bu.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acM().ah("BrandService", "continueLocationReportInterval"), 5);
    if (this.hTi < this.hTh) {
      this.hTi = this.hTh;
    }
    ae.i("MicroMsg.ReportLocation", "reportLocation interval %d", new Object[] { Integer.valueOf(this.hTi) });
    AppMethodBeat.o(124090);
  }
  
  public static void EC(String paramString)
  {
    AppMethodBeat.i(176139);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176139);
      return;
    }
    if (g.Et(paramString)) {
      ag.aGA().a(paramString, null, 0, null);
    }
    AppMethodBeat.o(176139);
  }
  
  public static void ED(String paramString)
  {
    AppMethodBeat.i(176140);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176140);
      return;
    }
    if (g.Et(paramString)) {
      ag.aGA().a(paramString, null);
    }
    AppMethodBeat.o(176140);
  }
  
  public static void I(bv parambv)
  {
    AppMethodBeat.i(188879);
    b.b(parambv, null);
    AppMethodBeat.o(188879);
  }
  
  public static void a(dci paramdci, String paramString)
  {
    AppMethodBeat.i(124093);
    if ((paramdci == null) || (paramdci.HKR <= 0))
    {
      AppMethodBeat.o(124093);
      return;
    }
    int i = Math.min(paramdci.HKR, 30);
    paramdci.HKU = 0;
    paramdci.HKV = 0;
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().I(paramString, i, 0L);
    while (paramString.moveToNext())
    {
      Object localObject = new bv();
      ((bv)localObject).convertFrom(paramString);
      if (((ei)localObject).field_isSend != 1) {
        if (((bv)localObject).fvC())
        {
          paramdci.HKV += 1;
        }
        else
        {
          localObject = bl.BS(((ei)localObject).eNd);
          if ((localObject != null) && (((bl.b)localObject).hJF == 3)) {
            paramdci.HKU += 1;
          }
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(124093);
  }
  
  public static void a(final an paraman, bv parambv, final int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(176141);
    long l = System.currentTimeMillis();
    if ((hTm.get(Long.valueOf(parambv.field_msgId)) != null) && (l - ((Long)hTm.get(Long.valueOf(parambv.field_msgId))).longValue() < 1000L))
    {
      AppMethodBeat.o(176141);
      return;
    }
    hTm.put(Long.valueOf(parambv.field_msgId), Long.valueOf(l));
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176138);
        Object localObject1 = "";
        int i;
        if (this.hHv.isText()) {
          i = 1;
        }
        for (;;)
        {
          if (i <= 0)
          {
            AppMethodBeat.o(176138);
            return;
            if (this.hHv.ftg())
            {
              i = 2;
            }
            else if (this.hHv.fta())
            {
              localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(this.hHv.field_msgId, this.hHv.field_content);
              if ((localObject1 == null) || (bu.ht(((u)localObject1).hFT))) {
                break label343;
              }
            }
          }
        }
        label343:
        for (localObject1 = ((v)((u)localObject1).hFT.get(0)).url;; localObject1 = "")
        {
          i = 3;
          break;
          if (this.hHv.cyG())
          {
            i = 5;
            break;
          }
          if ((this.hHv.cVH()) && (this.hHv.field_content != null))
          {
            Object localObject2 = k.b.zb(this.hHv.field_content);
            if ((localObject2 != null) && ((33 == ((k.b)localObject2).type) || (36 == ((k.b)localObject2).type)))
            {
              localObject1 = ((k.b)localObject2).url;
              i = 4;
              break;
              localObject2 = "";
              if (!bu.isNullOrNil((String)localObject1)) {
                localObject2 = x.aPc((String)localObject1);
              }
              int j = paramInt2;
              int k = paramInt1;
              int m = l.J(this.hHv);
              com.tencent.mm.plugin.report.service.g.yxI.f(19202, new Object[] { paraman.field_username, Integer.valueOf(i), localObject2, Integer.valueOf(1), Integer.valueOf(j - k - 1), Long.valueOf(this.hHv.field_createTime), Long.valueOf(paramLong), Integer.valueOf(m) });
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
  
  public static void a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, LinkedList<yx> paramLinkedList, int paramInt4, dci paramdci, ddo paramddo)
  {
    AppMethodBeat.i(124099);
    if (paramInt2 == 3) {}
    for (String str = "<event></event>";; str = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) }))
    {
      ae.i("MicroMsg.ReportLocation", "doScene, info: %s", new Object[] { str });
      com.tencent.mm.kernel.g.ajQ().gDv.a(new w(paramString, paramInt1, str, paramLinkedList, paramInt4, paramdci, paramddo), 0);
      AppMethodBeat.o(124099);
      return;
    }
  }
  
  public static void a(String paramString, ddo paramddo, int paramInt)
  {
    AppMethodBeat.i(124094);
    a(paramString, paramInt, 0, 0.0F, 0.0F, 0, null, 0, null, paramddo);
    AppMethodBeat.o(124094);
  }
  
  public static void b(bv parambv, k.b paramb)
  {
    AppMethodBeat.i(224209);
    b.b(parambv, paramb);
    AppMethodBeat.o(224209);
  }
  
  private static void b(String paramString, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    AppMethodBeat.i(124098);
    a(paramString, 11, paramInt1, paramFloat1, paramFloat2, paramInt2, null, 0, null, null);
    AppMethodBeat.o(124098);
  }
  
  public final void EB(String paramString)
  {
    AppMethodBeat.i(188878);
    a(paramString, 14, 0, 0.0F, 0.0F, 0, null, 0, this.hTl, null);
    AppMethodBeat.o(188878);
  }
  
  public final void EE(String paramString)
  {
    AppMethodBeat.i(124095);
    ae.i("MicroMsg.ReportLocation", "Start report");
    this.userName = paramString;
    Object localObject = g.eX(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(124095);
      return;
    }
    if (this.hTf != 0) {
      aGc();
    }
    this.hTf = 0;
    if (((com.tencent.mm.api.c)localObject).Kp())
    {
      ae.i("MicroMsg.ReportLocation", "need update contact %s", new Object[] { paramString });
      com.tencent.mm.aj.c.Dv(paramString);
    }
    c.b localb = ((com.tencent.mm.api.c)localObject).bX(false);
    if (localb == null)
    {
      AppMethodBeat.o(124095);
      return;
    }
    if ((localb.Kr()) && (((com.tencent.mm.api.c)localObject).Ko()))
    {
      this.hTg = d.aIh();
      localObject = ((com.tencent.mm.api.c)localObject).bX(false);
      boolean bool;
      if (((c.b)localObject).cRf != null)
      {
        if (bu.getInt(((c.b)localObject).cRf.optString("ReportLocationType"), 0) == 2)
        {
          bool = true;
          ((c.b)localObject).cRt = bool;
        }
      }
      else {
        if (!((c.b)localObject).cRt) {
          break label218;
        }
      }
      label218:
      for (int i = 3;; i = 2)
      {
        this.hTf = i;
        if ((!d.aIi()) && (!d.aIj())) {
          break label223;
        }
        this.hTg.a(this.fHp, true);
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
    if ((localb.Kr()) && (!((com.tencent.mm.api.c)localObject).Ko())) {
      a(paramString, 1, 0.0F, 0.0F, 0);
    }
    AppMethodBeat.o(124095);
  }
  
  public final void a(final String paramString, final dci paramdci)
  {
    AppMethodBeat.i(124092);
    com.tencent.e.h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124089);
        l.a(paramdci, paramString);
        l.a(paramString, 12, null, 0, paramdci);
        AppMethodBeat.o(124089);
      }
    });
    AppMethodBeat.o(124092);
  }
  
  public final void a(final String paramString, final bv parambv, final int paramInt, final dci paramdci)
  {
    AppMethodBeat.i(124091);
    com.tencent.e.h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124088);
        l.a(paramdci, paramString);
        if ((parambv == null) || (!parambv.fta()))
        {
          l.a(paramString, 10, null, paramInt, paramdci);
          AppMethodBeat.o(124088);
          return;
        }
        LinkedList localLinkedList = new LinkedList();
        Object localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambv.field_msgId, parambv.field_content);
        if ((localObject1 == null) || (bu.ht(((u)localObject1).hFT)))
        {
          l.a(paramString, 10, null, paramInt, paramdci);
          AppMethodBeat.o(124088);
          return;
        }
        localObject1 = ((u)localObject1).hFT.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          v localv = (v)((Iterator)localObject1).next();
          String str = localv.url;
          if (!bu.isNullOrNil(str))
          {
            Object localObject2 = Uri.parse(str);
            try
            {
              str = ((Uri)localObject2).getQueryParameter("mid");
              localObject2 = ((Uri)localObject2).getQueryParameter("idx");
              yx localyx = new yx();
              localyx.hGH = bu.getLong(str, 0L);
              localyx.idx = bu.getInt((String)localObject2, 0);
              localyx.dwb = localv.hGn;
              localyx.path = localv.hGk;
              localLinkedList.add(localyx);
            }
            catch (UnsupportedOperationException localUnsupportedOperationException)
            {
              ae.w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", new Object[] { localUnsupportedOperationException.getMessage() });
            }
          }
        }
        l.a(paramString, 10, localLinkedList, paramInt, paramdci);
        AppMethodBeat.o(124088);
      }
    });
    AppMethodBeat.o(124091);
  }
  
  public final void aGc()
  {
    AppMethodBeat.i(124096);
    ae.i("MicroMsg.ReportLocation", "Stop report");
    this.hTf = 0;
    if (this.hTg != null) {
      this.hTg.c(this.fHp);
    }
    if (com.tencent.mm.kernel.g.ajP().aiZ()) {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().b(this.hTk);
    }
    AppMethodBeat.o(124096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.l
 * JD-Core Version:    0.7.0.1
 */