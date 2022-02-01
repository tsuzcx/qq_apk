package com.tencent.mm.am;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.al.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.b.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.yu;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class l
{
  private static final f<Long, Long> hQu;
  private b.a fFl;
  private int hQn;
  private d hQo;
  private int hQp;
  private int hQq;
  private boolean hQr;
  private n.b hQs;
  public dbo hQt;
  private String userName;
  
  static
  {
    AppMethodBeat.i(176144);
    hQu = new com.tencent.mm.b.h(20);
    AppMethodBeat.o(176144);
  }
  
  protected l()
  {
    AppMethodBeat.i(124090);
    this.userName = null;
    this.hQn = 0;
    this.hQp = 2;
    this.hQq = 10;
    this.hQr = false;
    this.hQs = new n.b()
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
        if ((l.a(l.this).equals((String)paramAnonymousObject)) && (l.b(l.this) == 1))
        {
          ad.i("MicroMsg.ReportLocation", "contactStgUpdate, %s", new Object[] { l.a(l.this) });
          l.this.Ec(l.a(l.this));
          ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().b(l.c(l.this));
        }
        AppMethodBeat.o(124086);
      }
    };
    this.fFl = new b.a()
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
        if (bt.aQJ() >= this.lastReportTime + l.d(l.this))
        {
          l.a(l.a(l.this), paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2);
          this.lastReportTime = bt.aQJ();
        }
        if (l.b(l.this) == 2) {
          l.this.aFM();
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
    this.hQq = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acB().ah("BrandService", "continueLocationReportInterval"), 5);
    if (this.hQq < this.hQp) {
      this.hQq = this.hQp;
    }
    ad.i("MicroMsg.ReportLocation", "reportLocation interval %d", new Object[] { Integer.valueOf(this.hQq) });
    AppMethodBeat.o(124090);
  }
  
  public static void Ea(String paramString)
  {
    AppMethodBeat.i(176139);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176139);
      return;
    }
    if (g.DR(paramString)) {
      ag.aGk().a(paramString, null, 0, null);
    }
    AppMethodBeat.o(176139);
  }
  
  public static void Eb(String paramString)
  {
    AppMethodBeat.i(176140);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176140);
      return;
    }
    if (g.DR(paramString)) {
      ag.aGk().a(paramString, null);
    }
    AppMethodBeat.o(176140);
  }
  
  public static void I(bu parambu)
  {
    AppMethodBeat.i(207181);
    b.b(parambu, null);
    AppMethodBeat.o(207181);
  }
  
  public static void a(dbo paramdbo, String paramString)
  {
    AppMethodBeat.i(124093);
    if ((paramdbo == null) || (paramdbo.Hrp <= 0))
    {
      AppMethodBeat.o(124093);
      return;
    }
    int i = Math.min(paramdbo.Hrp, 30);
    paramdbo.Hrs = 0;
    paramdbo.Hrt = 0;
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().J(paramString, i, 0L);
    while (paramString.moveToNext())
    {
      Object localObject = new bu();
      ((bu)localObject).convertFrom(paramString);
      if (((ei)localObject).field_isSend != 1) {
        if (((bu)localObject).frC())
        {
          paramdbo.Hrt += 1;
        }
        else
        {
          localObject = bj.Bq(((ei)localObject).eLs);
          if ((localObject != null) && (((bj.b)localObject).hGN == 3)) {
            paramdbo.Hrs += 1;
          }
        }
      }
    }
    paramString.close();
    AppMethodBeat.o(124093);
  }
  
  public static void a(final am paramam, bu parambu, final int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(176141);
    long l = System.currentTimeMillis();
    if ((hQu.get(Long.valueOf(parambu.field_msgId)) != null) && (l - ((Long)hQu.get(Long.valueOf(parambu.field_msgId))).longValue() < 1000L))
    {
      AppMethodBeat.o(176141);
      return;
    }
    hQu.put(Long.valueOf(parambu.field_msgId), Long.valueOf(l));
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176138);
        Object localObject1 = "";
        int i;
        if (this.hED.isText()) {
          i = 1;
        }
        for (;;)
        {
          if (i <= 0)
          {
            AppMethodBeat.o(176138);
            return;
            if (this.hED.fpi())
            {
              i = 2;
            }
            else if (this.hED.fpd())
            {
              localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(this.hED.field_msgId, this.hED.field_content);
              if ((localObject1 == null) || (bt.hj(((u)localObject1).hDb))) {
                break label343;
              }
            }
          }
        }
        label343:
        for (localObject1 = ((v)((u)localObject1).hDb.get(0)).url;; localObject1 = "")
        {
          i = 3;
          break;
          if (this.hED.cxf())
          {
            i = 5;
            break;
          }
          if ((this.hED.cTc()) && (this.hED.field_content != null))
          {
            Object localObject2 = k.b.yr(this.hED.field_content);
            if ((localObject2 != null) && ((33 == ((k.b)localObject2).type) || (36 == ((k.b)localObject2).type)))
            {
              localObject1 = ((k.b)localObject2).url;
              i = 4;
              break;
              localObject2 = "";
              if (!bt.isNullOrNil((String)localObject1)) {
                localObject2 = x.aNF((String)localObject1);
              }
              int j = paramInt2;
              int k = paramInt1;
              int m = l.J(this.hED);
              com.tencent.mm.plugin.report.service.g.yhR.f(19202, new Object[] { paramam.field_username, Integer.valueOf(i), localObject2, Integer.valueOf(1), Integer.valueOf(j - k - 1), Long.valueOf(this.hED.field_createTime), Long.valueOf(paramLong), Integer.valueOf(m) });
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
  
  public static void a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, LinkedList<yu> paramLinkedList, int paramInt4, dbo paramdbo, dcu paramdcu)
  {
    AppMethodBeat.i(124099);
    if (paramInt2 == 3) {}
    for (String str = "<event></event>";; str = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt3) }))
    {
      ad.i("MicroMsg.ReportLocation", "doScene, info: %s", new Object[] { str });
      com.tencent.mm.kernel.g.ajB().gAO.a(new w(paramString, paramInt1, str, paramLinkedList, paramInt4, paramdbo, paramdcu), 0);
      AppMethodBeat.o(124099);
      return;
    }
  }
  
  public static void a(String paramString, dcu paramdcu, int paramInt)
  {
    AppMethodBeat.i(124094);
    a(paramString, paramInt, 0, 0.0F, 0.0F, 0, null, 0, null, paramdcu);
    AppMethodBeat.o(124094);
  }
  
  public static void b(bu parambu, k.b paramb)
  {
    AppMethodBeat.i(221608);
    b.b(parambu, paramb);
    AppMethodBeat.o(221608);
  }
  
  private static void b(String paramString, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    AppMethodBeat.i(124098);
    a(paramString, 11, paramInt1, paramFloat1, paramFloat2, paramInt2, null, 0, null, null);
    AppMethodBeat.o(124098);
  }
  
  public final void DZ(String paramString)
  {
    AppMethodBeat.i(207180);
    a(paramString, 14, 0, 0.0F, 0.0F, 0, null, 0, this.hQt, null);
    AppMethodBeat.o(207180);
  }
  
  public final void Ec(String paramString)
  {
    AppMethodBeat.i(124095);
    ad.i("MicroMsg.ReportLocation", "Start report");
    this.userName = paramString;
    Object localObject = g.eS(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(124095);
      return;
    }
    if (this.hQn != 0) {
      aFM();
    }
    this.hQn = 0;
    if (((com.tencent.mm.api.c)localObject).Kh())
    {
      ad.i("MicroMsg.ReportLocation", "need update contact %s", new Object[] { paramString });
      com.tencent.mm.ak.c.CT(paramString);
    }
    c.b localb = ((com.tencent.mm.api.c)localObject).bX(false);
    if (localb == null)
    {
      AppMethodBeat.o(124095);
      return;
    }
    if ((localb.Kj()) && (((com.tencent.mm.api.c)localObject).Kg()))
    {
      this.hQo = d.aHQ();
      localObject = ((com.tencent.mm.api.c)localObject).bX(false);
      boolean bool;
      if (((c.b)localObject).cQv != null)
      {
        if (bt.getInt(((c.b)localObject).cQv.optString("ReportLocationType"), 0) == 2)
        {
          bool = true;
          ((c.b)localObject).cQJ = bool;
        }
      }
      else {
        if (!((c.b)localObject).cQJ) {
          break label218;
        }
      }
      label218:
      for (int i = 3;; i = 2)
      {
        this.hQn = i;
        if ((!d.aHR()) && (!d.aHS())) {
          break label223;
        }
        this.hQo.a(this.fFl, true);
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
    if ((localb.Kj()) && (!((com.tencent.mm.api.c)localObject).Kg())) {
      a(paramString, 1, 0.0F, 0.0F, 0);
    }
    AppMethodBeat.o(124095);
  }
  
  public final void a(final String paramString, final dbo paramdbo)
  {
    AppMethodBeat.i(124092);
    com.tencent.e.h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124089);
        l.a(paramdbo, paramString);
        l.a(paramString, 12, null, 0, paramdbo);
        AppMethodBeat.o(124089);
      }
    });
    AppMethodBeat.o(124092);
  }
  
  public final void a(final String paramString, final bu parambu, final int paramInt, final dbo paramdbo)
  {
    AppMethodBeat.i(124091);
    com.tencent.e.h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124088);
        l.a(paramdbo, paramString);
        if ((parambu == null) || (!parambu.fpd()))
        {
          l.a(paramString, 10, null, paramInt, paramdbo);
          AppMethodBeat.o(124088);
          return;
        }
        LinkedList localLinkedList = new LinkedList();
        Object localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambu.field_msgId, parambu.field_content);
        if ((localObject1 == null) || (bt.hj(((u)localObject1).hDb)))
        {
          l.a(paramString, 10, null, paramInt, paramdbo);
          AppMethodBeat.o(124088);
          return;
        }
        localObject1 = ((u)localObject1).hDb.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          v localv = (v)((Iterator)localObject1).next();
          String str = localv.url;
          if (!bt.isNullOrNil(str))
          {
            Object localObject2 = Uri.parse(str);
            try
            {
              str = ((Uri)localObject2).getQueryParameter("mid");
              localObject2 = ((Uri)localObject2).getQueryParameter("idx");
              yu localyu = new yu();
              localyu.hDP = bt.getLong(str, 0L);
              localyu.idx = bt.getInt((String)localObject2, 0);
              localyu.duW = localv.hDv;
              localyu.path = localv.hDs;
              localLinkedList.add(localyu);
            }
            catch (UnsupportedOperationException localUnsupportedOperationException)
            {
              ad.w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", new Object[] { localUnsupportedOperationException.getMessage() });
            }
          }
        }
        l.a(paramString, 10, localLinkedList, paramInt, paramdbo);
        AppMethodBeat.o(124088);
      }
    });
    AppMethodBeat.o(124091);
  }
  
  public final void aFM()
  {
    AppMethodBeat.i(124096);
    ad.i("MicroMsg.ReportLocation", "Stop report");
    this.hQn = 0;
    if (this.hQo != null) {
      this.hQo.c(this.fFl);
    }
    if (com.tencent.mm.kernel.g.ajA().aiK()) {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().b(this.hQs);
    }
    AppMethodBeat.o(124096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.l
 * JD-Core Version:    0.7.0.1
 */