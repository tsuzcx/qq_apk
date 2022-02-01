package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.n;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.ak.t;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.k;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkp;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.eqv;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.aa.5;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.o;

public final class f
{
  public int dEb;
  public int psq;
  public int psr;
  public long pss;
  public com.tencent.mm.plugin.brandservice.ui.timeline.a.b pst;
  c<String, b> psu;
  public HashMap<String, Boolean> psv;
  a psw;
  
  public f(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194918);
    this.psu = new c();
    this.psv = new HashMap();
    this.dEb = paramInt;
    this.pss = paramLong;
    AppMethodBeat.o(194918);
  }
  
  private void a(b paramb, int paramInt, com.tencent.mm.storage.z paramz)
  {
    int i = 0;
    AppMethodBeat.i(194920);
    paramb.KVo = System.currentTimeMillis();
    paramb.KUO = ((int)(paramb.KVo / 1000L));
    paramb.pos = paramInt;
    paramb.fQY = paramz.field_bizClientMsgId;
    paramb.KUG = 1;
    paramb.KUN = 0;
    paramb.KUP = ((int)(paramz.field_createTime / 1000L));
    if (paramz.gAs())
    {
      paramInt = 3;
      paramb.KUR = paramInt;
      if (!this.psv.containsKey(paramz.getId())) {
        break label167;
      }
    }
    label167:
    for (paramInt = i;; paramInt = 1)
    {
      paramb.KUX = paramInt;
      paramb.KVe = paramz.field_rankSessionId;
      paramb.weight = ((int)paramz.gAp());
      AppMethodBeat.o(194920);
      return;
      if (paramz.gAo() == com.tencent.mm.al.ag.ban().gAS())
      {
        paramInt = 0;
        break;
      }
      if (System.currentTimeMillis() - paramz.field_createTime <= 86400000L)
      {
        paramInt = 1;
        break;
      }
      paramInt = 2;
      break;
    }
  }
  
  private static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(5936);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if ((paramString != null) && (paramString.arE()))
    {
      paramb.KUM = 1;
      paramb.KUQ = 1;
      AppMethodBeat.o(5936);
      return;
    }
    paramb.KUM = 0;
    paramb.KUQ = 0;
    AppMethodBeat.o(5936);
  }
  
  public static void a(ege paramege)
  {
    AppMethodBeat.i(194923);
    if (paramege.Nga != null) {
      com.tencent.mm.plugin.report.service.h.CyF.a(21064, new Object[] { Long.valueOf(System.currentTimeMillis()), paramege.Nga.KUk, Long.valueOf(paramege.MOC), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(paramege.style), paramege.Nga.KUo });
    }
    AppMethodBeat.o(194923);
  }
  
  private void a(final com.tencent.mm.storage.z paramz, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(5939);
    com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        long l1 = 0L;
        AppMethodBeat.i(5933);
        long l3 = l1;
        long l2;
        if (paramz.gAt())
        {
          l2 = l1;
          l3 = l1;
        }
        for (;;)
        {
          try
          {
            Object localObject = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramz.field_msgId, paramz.field_content);
            if (localObject == null) {
              break label259;
            }
            l2 = l1;
            l3 = l1;
            if (Util.isNullOrNil(((u)localObject).iAd)) {
              break label259;
            }
            l2 = l1;
            l3 = l1;
            localObject = (v)((u)localObject).iAd.get(paramInt1);
            l2 = l1;
            l3 = l1;
            if (Util.isNullOrNil(((v)localObject).url)) {
              break label259;
            }
            l2 = l1;
            l3 = l1;
            localObject = Uri.parse(((v)localObject).url);
            l2 = l1;
            l3 = l1;
            l1 = Util.getLong(((Uri)localObject).getQueryParameter("mid"), 0L);
            l2 = l1;
            l3 = l1;
            i = Util.getInt(((Uri)localObject).getQueryParameter("idx"), 0);
          }
          catch (UnsupportedOperationException localUnsupportedOperationException)
          {
            Log.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
            i = 0;
            l1 = l2;
            continue;
          }
          catch (Exception localException)
          {
            Log.w("MicroMsg.BizTimeLineReport", "reportBizTimelineOp exp %s", new Object[] { localException.getMessage() });
          }
          f.this.a(paramz.field_talker, l1, i, paramInt2, paramInt3);
          AppMethodBeat.o(5933);
          return;
          int i = 0;
          l1 = l3;
          continue;
          label259:
          i = 0;
        }
      }
    }, 0L);
    AppMethodBeat.o(5939);
  }
  
  private void d(com.tencent.mm.storage.z paramz, int paramInt)
  {
    AppMethodBeat.i(194921);
    ege localege = paramz.gAD();
    Object localObject2;
    int j;
    int i;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    if ((localege != null) && ((localege.style == 101) || (localege.style == 102) || (localege.style == 103)))
    {
      localObject2 = localege.Nga;
      if ((localObject2 == null) || (Util.isNullOrNil(((ale)localObject2).KUf)))
      {
        AppMethodBeat.o(194921);
        return;
      }
      j = 0;
      i = 0;
      if (j < ((ale)localObject2).KUf.size())
      {
        if (((pj)((ale)localObject2).KUf.get(j)).KHa != 0) {
          break label1567;
        }
        localObject1 = (pi)((pj)((ale)localObject2).KUf.get(j)).KWy.get(0);
        localObject3 = (b)this.psu.get(paramz.getId() + "_" + j);
        if (localObject3 == null)
        {
          localObject3 = new b();
          this.psu.put(paramz.getId() + "_" + j, localObject3);
          ((b)localObject3).KUC = ((pj)((ale)localObject2).KUf.get(j)).UserName;
          if ((localObject1 != null) && ((((pi)localObject1).KHa & 0x1) == 0))
          {
            localObject4 = ((pi)localObject1).KSj;
            if (Util.isNullOrNil((String)localObject4)) {}
          }
        }
      }
    }
    label1567:
    for (;;)
    {
      try
      {
        localObject4 = Uri.parse((String)localObject4);
        int k = Util.getInt(((Uri)localObject4).getQueryParameter("idx"), 0);
        long l1 = Util.getLong(((Uri)localObject4).getQueryParameter("mid"), 0L);
        ((b)localObject3).KUF.add(Integer.valueOf(k));
        ((b)localObject3).dFm = l1;
        ((b)localObject3).KUT = l1;
        ((b)localObject3).KVg = ((pi)localObject1).KWv;
        ((b)localObject3).KVh = ((pi)localObject1).KWw;
        a((b)localObject3, paramInt, paramz);
        k = 3;
        if (localege.style == 103) {
          k = 7;
        }
        ((b)localObject3).nHh = k;
        if (((pi)localObject1).xLi != null) {
          ((b)localObject3).KVc = com.tencent.mm.pluginsdk.ui.tools.z.bfG(((pi)localObject1).xLi);
        }
        if (localege != null) {
          ((b)localObject3).KVb = localege.MOC;
        }
        ((b)localObject3).KUU = j;
        if (localObject1 != null) {
          ((b)localObject3).KIJ = ((pi)localObject1).iAb;
        }
        if (paramz.NQn != null)
        {
          k = paramz.NQn.style;
          ((b)localObject3).style = k;
          if (paramz.NQn == null) {
            continue;
          }
          localObject1 = paramz.NQn.event;
          ((b)localObject3).event = ((String)localObject1);
          if ((paramz.NQn != null) && (paramz.NQn.Nga != null))
          {
            ((b)localObject3).eaO = paramz.NQn.Nga.KUk;
            ((b)localObject3).KVf = paramz.NQn.Nga.KUo;
          }
          if ((localege.style == 102) || (localege.style == 103))
          {
            ((b)localObject3).KVk = localege.Nga.Luk;
            ((b)localObject3).KVj = localege.Nga.Luj;
          }
          ((b)localObject3).pTd = localege.Nga.Lug;
          if ((i == 0) && (localege.Nga != null)) {
            com.tencent.mm.plugin.report.service.h.CyF.a(21064, new Object[] { Long.valueOf(System.currentTimeMillis()), localege.Nga.KUk, Long.valueOf(localege.MOC), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(localege.style), localege.Nga.KUo });
          }
          i = 1;
          j += 1;
          break;
        }
        k = 0;
        continue;
        localObject1 = "";
        continue;
        ((b)localObject3).KUG += 1;
        ((b)localObject3).pos = paramInt;
        ((b)localObject3).KUO = ((int)(System.currentTimeMillis() / 1000L));
        continue;
        AppMethodBeat.o(194921);
        return;
        if ((localege != null) && (localege.style == 1001) && (localege.Ngc != null))
        {
          if (paramz.gAu())
          {
            localObject1 = (b)this.psu.get(paramz.getId() + "_0");
            if (localObject1 == null)
            {
              localObject1 = new b();
              this.psu.put(paramz.getId() + "_0", localObject1);
              ((b)localObject1).KUp = localege.dSJ;
              a((b)localObject1, paramInt, paramz);
              ((b)localObject1).nHh = 5;
              if (localege != null) {
                ((b)localObject1).KVb = localege.MOC;
              }
              ((b)localObject1).style = 1001;
              localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
              com.tencent.mm.plugin.webcanvas.l.LV(74L);
              localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
              l1 = System.currentTimeMillis();
              localObject3 = localege.Ngc.cardId;
              long l2 = localege.MOC;
              paramInt = localege.style;
              if (localege.Nga == null) {
                continue;
              }
              localObject1 = localege.Nga.KUo;
              ((com.tencent.mm.plugin.report.service.h)localObject2).a(21064, new Object[] { Long.valueOf(l1), localObject3, Long.valueOf(l2), Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(paramInt), localObject1 });
              Log.i("MicroMsg.BizTimeLineReport", "onExposeRecCanvasMsg %d", new Object[] { Long.valueOf(paramz.field_msgId) });
            }
          }
          else
          {
            AppMethodBeat.o(194921);
            return;
          }
          ((b)localObject1).KUG += 1;
          ((b)localObject1).pos = paramInt;
          ((b)localObject1).KUO = ((int)(System.currentTimeMillis() / 1000L));
          continue;
          localObject1 = "";
          continue;
        }
        localObject1 = paramz.gAC();
        if ((localObject1 == null) || (((efz)localObject1).KWy == null) || (((efz)localObject1).KWy.size() <= 0))
        {
          Log.w("MicroMsg.BizTimeLineReport", "recCard is null");
          AppMethodBeat.o(194921);
          return;
        }
        k = ((efz)localObject1).KWy.size();
        i = 0;
        if (i < k)
        {
          localObject2 = (ega)((efz)localObject1).KWy.get(i);
          localObject3 = (b)this.psu.get(paramz.getId() + "_" + i);
          if (localObject3 == null)
          {
            localObject3 = new b();
            this.psu.put(paramz.getId() + "_" + i, localObject3);
            ((b)localObject3).KUC = paramz.field_talker;
            if ((localObject2 != null) && ((((ega)localObject2).KHa & 0x1) == 0))
            {
              localObject4 = ((ega)((efz)localObject1).KWy.get(i)).KSj;
              if (Util.isNullOrNil((String)localObject4)) {}
            }
          }
        }
        try
        {
          localObject4 = Uri.parse((String)localObject4);
          j = Util.getInt(((Uri)localObject4).getQueryParameter("idx"), 0);
          l1 = Util.getLong(((Uri)localObject4).getQueryParameter("mid"), 0L);
          ((b)localObject3).KUF.add(Integer.valueOf(j));
          ((b)localObject3).dFm = l1;
          ((b)localObject3).KUT = l1;
          if (localObject2 != null) {
            ((b)localObject3).KIJ = ((ega)localObject2).iAb;
          }
          a((b)localObject3, paramInt, paramz);
          ((b)localObject3).nHh = 1;
          if (((efz)localObject1).NfT != null) {
            ((b)localObject3).KVc = com.tencent.mm.pluginsdk.ui.tools.z.bfG(((efz)localObject1).NfT.NfV);
          }
          if (localege != null) {
            ((b)localObject3).KVb = localege.MOC;
          }
          ((b)localObject3).KUU = i;
          if (paramz.NQn != null)
          {
            j = paramz.NQn.style;
            ((b)localObject3).style = j;
            ((b)localObject3).pTd = ((efz)localObject1).Lug;
            i += 1;
          }
          else
          {
            j = 0;
            continue;
            ((b)localObject3).KUG += 1;
            ((b)localObject3).pos = paramInt;
            ((b)localObject3).KUO = ((int)(System.currentTimeMillis() / 1000L));
            continue;
            AppMethodBeat.o(194921);
            return;
          }
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2) {}
    }
  }
  
  private void e(com.tencent.mm.storage.z paramz, int paramInt)
  {
    AppMethodBeat.i(194922);
    if ((!paramz.gAs()) || (paramz.NQr == null) || (Util.isNullOrNil(paramz.NQr.MOG)))
    {
      AppMethodBeat.o(194922);
      return;
    }
    dkr localdkr = paramz.NQr;
    int k = localdkr.MOG.size();
    int i = 0;
    for (;;)
    {
      Object localObject1;
      b localb;
      Object localObject2;
      if (i < k)
      {
        localObject1 = (dlb)localdkr.MOG.get(i);
        localb = (b)this.psu.get(paramz.getId() + "_" + i);
        if (localb == null)
        {
          localb = new b();
          this.psu.put(paramz.getId() + "_" + i, localb);
          a(localb, paramInt, paramz);
          localb.nHh = af.G(paramz);
          localb.KVp = paramz.NQm;
          localb.style = localdkr.KUh;
          localb.KVh = ((dlb)localObject1).KWw;
          localb.KIJ = ((dlb)localObject1).MOY.iAb;
          localb.KUU = i;
          localb.KUC = ((dlb)localObject1).MOX.UserName;
          localb.eaO = localdkr.KUk;
          localObject2 = ((dlb)localObject1).MOY.KSj;
          if (Util.isNullOrNil((String)localObject2)) {}
        }
      }
      try
      {
        localObject2 = Uri.parse((String)localObject2);
        int j = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
        long l = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
        localb.KUF.add(Integer.valueOf(j));
        localb.dFm = l;
        localb.KUT = l;
        label337:
        if (localdkr.KUh == 2002)
        {
          localb.KVk = localdkr.Luk;
          localb.KVj = localdkr.Luj;
          label368:
          if (localdkr.KUh != 2002) {
            break label468;
          }
          localb.KVc = com.tencent.mm.pluginsdk.ui.tools.z.bfG(localdkr.MOI);
          if ((i != 0) || (!com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(localdkr))) {
            break label546;
          }
          j = 1;
          localb.KUZ = j;
          localb.pTd = ((dlb)localObject1).MOX.oUJ;
          localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
          com.tencent.mm.plugin.webcanvas.l.LV(74L);
        }
        for (;;)
        {
          label392:
          label407:
          i += 1;
          break;
          localb.KVk = ((dlb)localObject1).Luk;
          localb.KVj = ((dlb)localObject1).Luj;
          break label368;
          label468:
          if (localdkr.KUh != 2001) {
            break label392;
          }
          localb.KVc = com.tencent.mm.pluginsdk.ui.tools.z.bfG(((dlb)localObject1).MOI);
          if ((((dlb)localObject1).MOY.iAb != 5) || (i != 0) || (!com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(localdkr)) || (((dlb)localObject1).MOY.Mjm == null)) {
            break label392;
          }
          localb.psI = ((dlb)localObject1).MOY.Mjm.KSu;
          break label392;
          label546:
          j = 0;
          break label407;
          localb.KUG += 1;
          localb.pos = paramInt;
          localb.KUO = ((int)(System.currentTimeMillis() / 1000L));
        }
        AppMethodBeat.o(194922);
        return;
      }
      catch (Exception localException)
      {
        break label337;
      }
    }
  }
  
  private static int f(com.tencent.mm.storage.z paramz)
  {
    AppMethodBeat.i(194926);
    if (paramz.isText())
    {
      AppMethodBeat.o(194926);
      return 1;
    }
    if (paramz.gAz())
    {
      AppMethodBeat.o(194926);
      return 2;
    }
    if (paramz.gAy())
    {
      AppMethodBeat.o(194926);
      return 3;
    }
    AppMethodBeat.o(194926);
    return -1;
  }
  
  public final void Dg(int paramInt)
  {
    AppMethodBeat.i(5940);
    a("", 0L, 0, paramInt, -1);
    AppMethodBeat.o(5940);
  }
  
  public final void a(com.tencent.mm.plugin.brandservice.ui.timeline.a.b paramb)
  {
    this.pst = paramb;
  }
  
  public final void a(final com.tencent.mm.storage.z paramz, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194924);
    if (paramz == null)
    {
      AppMethodBeat.o(194924);
      return;
    }
    b localb2 = (b)this.psu.get(paramz.getId() + "_" + paramInt1);
    final b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = localb2;
      if (this.pst != null)
      {
        c(paramz, paramInt1);
        this.pst.cnl();
        localb1 = (b)this.psu.get(paramz.getId() + "_" + paramInt1);
      }
    }
    if (localb1 != null)
    {
      localb1.KUY = 1;
      Log.d("MicroMsg.BizTimeLineReport", "onClick %d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5930);
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(localb1);
          if (!Util.isNullOrNil(localb1.psI))
          {
            f.b localb = localb1;
            MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
            localb.KVl = MPVideoPreviewMgr.aiL(localb1.psI);
            localb = localb1;
            localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
            localb.KVm = MPVideoPreviewMgr.aiM(localb1.psI);
          }
          Log.i("MicroMsg.BizTimeLineReport", "reportOnClick %s.", new Object[] { paramz.getId() });
          g.aAg().hqi.a(new k(localLinkedList, f.this.psq, f.this.psr, f.this.dEb, f.this.pss, 1, 1), 0);
          AppMethodBeat.o(5930);
        }
      }, 0L);
    }
    if ((!paramz.gAu()) && (!paramz.gAs())) {
      a(paramz, paramInt1, 11, paramInt2);
    }
    AppMethodBeat.o(194924);
  }
  
  public final void a(com.tencent.mm.storage.z paramz, boolean paramBoolean)
  {
    AppMethodBeat.i(5937);
    paramz = (b)this.psu.get(paramz.getId());
    if (paramz == null)
    {
      AppMethodBeat.o(5937);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramz.KTM = i;
      AppMethodBeat.o(5937);
      return;
    }
  }
  
  public final void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5941);
    a(paramString, paramLong, paramInt1, paramInt2, paramInt3, 0L, false, 0);
    AppMethodBeat.o(5941);
  }
  
  public final void a(String paramString, long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(194930);
    int i = paramInt3;
    if (paramInt3 <= 0) {
      i = (int)(System.currentTimeMillis() / 1000L);
    }
    if (paramBoolean) {}
    for (paramInt3 = 1;; paramInt3 = 0)
    {
      as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
      int j = paramInt3;
      if (!paramBoolean)
      {
        j = paramInt3;
        if (localas != null)
        {
          j = paramInt3;
          if (!c.oR(localas.field_type)) {
            j = 3;
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(15721, new Object[] { paramString, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.dEb), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), "", Integer.valueOf(j), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(194930);
      return;
    }
  }
  
  public final void a(String paramString1, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString2, int paramInt3, String paramString3, String paramString4, String paramString5, int paramInt4, int paramInt5, String paramString6)
  {
    AppMethodBeat.i(194932);
    int j = (int)(System.currentTimeMillis() / 1000L);
    int i = 3;
    if (paramInt5 == 103) {
      i = 7;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(15721, new Object[] { paramString1, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(this.dEb), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), paramString2, Integer.valueOf(i), Integer.valueOf(paramInt3), paramString3, paramString4, paramString5, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString6 });
    AppMethodBeat.o(194932);
  }
  
  public final void a(String paramString1, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(194934);
    int j = (int)(System.currentTimeMillis() / 1000L);
    int i = 3;
    if (paramInt3 == 103) {
      i = 7;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(15721, new Object[] { paramString1, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(this.dEb), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), paramString2, Integer.valueOf(i), Integer.valueOf(0), paramString3, paramString4, paramString5, Integer.valueOf(0), Integer.valueOf(paramInt3), paramString6, paramString7, paramString8 });
    AppMethodBeat.o(194934);
  }
  
  public final void a(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(194933);
    int i = (int)(System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.report.service.h.CyF.a(15721, new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(16), Integer.valueOf(i), Integer.valueOf(this.dEb), Integer.valueOf(paramInt1), Long.valueOf(0L), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(0), "", "", paramString3, Integer.valueOf(0), Integer.valueOf(paramInt2), paramString4 });
    AppMethodBeat.o(194933);
  }
  
  public final void b(com.tencent.mm.storage.z paramz, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194925);
    if ((!paramz.gAs()) && (!paramz.gAu()))
    {
      AppMethodBeat.o(194925);
      return;
    }
    b localb = (b)this.psu.get(paramz.getId() + "_" + paramInt1);
    if (localb == null)
    {
      Log.i("MicroMsg.BizTimeLineReport", "onClickTag fail sessionItem is null");
      AppMethodBeat.o(194925);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localb);
    if (!Util.isNullOrNil(localb.psI))
    {
      MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
      localb.KVl = MPVideoPreviewMgr.aiL(localb.psI);
      localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
      localb.KVm = MPVideoPreviewMgr.aiM(localb.psI);
    }
    Log.i("MicroMsg.BizTimeLineReport", "reportOnClick %s.", new Object[] { paramz.getId() });
    if (24 == paramInt2) {}
    for (paramInt1 = 2;; paramInt1 = 3)
    {
      g.aAg().hqi.a(new k(localLinkedList, this.psq, this.psr, this.dEb, this.pss, 1, paramInt1), 0);
      AppMethodBeat.o(194925);
      return;
    }
  }
  
  public final void c(com.tencent.mm.storage.z paramz, int paramInt)
  {
    int k = 1;
    int j = 1;
    int i = 0;
    AppMethodBeat.i(5935);
    if (paramz == null)
    {
      AppMethodBeat.o(5935);
      return;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramz.gAt()) {
      if (paramz.gAt())
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramz.field_msgId, paramz.field_content);
        if ((localObject1 == null) || (Util.isNullOrNil(((u)localObject1).iAd)))
        {
          AppMethodBeat.o(5935);
          return;
        }
        try
        {
          i = ((u)localObject1).iAd.size();
          if ((i <= 2) || (paramz.field_isExpand)) {
            break label1519;
          }
          i = 2;
        }
        catch (UnsupportedOperationException paramz)
        {
          for (;;)
          {
            Object localObject4;
            Log.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { paramz.getMessage() });
            AppMethodBeat.o(5935);
            return;
            ((b)localObject3).KUH = 0;
          }
        }
        catch (Exception paramz)
        {
          Log.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { paramz.getMessage() });
        }
        if (j >= i) {
          break label824;
        }
        localObject2 = (v)((u)localObject1).iAd.get(j);
        if (localObject2 == null) {
          break label1525;
        }
        localObject3 = (b)this.psu.get(paramz.getId() + "_" + j);
        if (localObject3 != null) {
          break label730;
        }
        localObject3 = new b();
        this.psu.put(paramz.getId() + "_" + j, localObject3);
        ((b)localObject3).KUC = paramz.field_talker;
        a((b)localObject3, paramInt, paramz);
        ((b)localObject3).KUI = 0;
        ((b)localObject3).KUK = 0;
        ((b)localObject3).KUL = 0;
        ((b)localObject3).KTM = 0;
        ((b)localObject3).ybm = ((v)localObject2).type;
        if (!Util.isNullOrNil(((v)localObject2).url))
        {
          localObject4 = ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahw(((v)localObject2).url);
          if (localObject4 != null)
          {
            if (((com.tencent.mm.ag.p)localObject4).izZ == null) {
              break label1513;
            }
            k = ((com.tencent.mm.ag.p)localObject4).izZ.izT;
            label336:
            ((b)localObject3).KUS = ("1_" + k + ";");
            ((b)localObject3).KVn = ((com.tencent.mm.ag.p)localObject4).iAa;
          }
        }
        ((b)localObject3).KUU = j;
        if (!paramz.field_isExpand) {
          break label1534;
        }
        k = 1;
        label392:
        ((b)localObject3).KUV = k;
        if ((j != 0) || (!paramz.NQj)) {
          break label1540;
        }
        k = 1;
        label414:
        ((b)localObject3).KUZ = k;
        if (!paramz.NQk) {
          break label1546;
        }
      }
    }
    label1540:
    label1546:
    for (k = 1;; k = 0)
    {
      ((b)localObject3).KVa = k;
      ((b)localObject3).KVd = ((v)localObject2).iwf;
      ((b)localObject3).KIJ = ((v)localObject2).type;
      ((b)localObject3).KVe = paramz.field_rankSessionId;
      a((b)localObject3, paramz.field_talker);
      long l;
      if (!Util.isNullOrNil(((v)localObject2).url))
      {
        localObject4 = Uri.parse(((v)localObject2).url);
        k = Util.getInt(((Uri)localObject4).getQueryParameter("idx"), 0);
        l = Util.getLong(((Uri)localObject4).getQueryParameter("mid"), 0L);
        ((b)localObject3).KUF.add(Integer.valueOf(k));
        ((b)localObject3).dFm = l;
        ((b)localObject3).KUT = l;
      }
      if (paramz.field_isExpand)
      {
        ((b)localObject3).KUH = 2;
        localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramz.field_talker);
        if ((localObject4 == null) || (c.oR(((ax)localObject4).field_type))) {
          break label724;
        }
      }
      label724:
      for (k = 2;; k = 0)
      {
        ((b)localObject3).nHh = k;
        if (((v)localObject2).type != 5) {
          break label1525;
        }
        ((b)localObject3).psI = ((v)localObject2).vid;
        break label1525;
        if (((u)localObject1).iAd.size() > 2)
        {
          ((b)localObject3).KUH = 1;
          break;
        }
        AppMethodBeat.o(5935);
        return;
      }
      label730:
      if ((j == 0) && (paramz.NQj))
      {
        k = 1;
        ((b)localObject3).KUZ = k;
        if (!paramz.NQk) {
          break label818;
        }
      }
      label818:
      for (k = 1;; k = 0)
      {
        ((b)localObject3).KVa = k;
        ((b)localObject3).KUG += 1;
        ((b)localObject3).pos = paramInt;
        ((b)localObject3).KUO = ((int)(System.currentTimeMillis() / 1000L));
        a((b)localObject3, paramz.field_talker);
        break label1525;
        k = 0;
        break;
      }
      label824:
      AppMethodBeat.o(5935);
      return;
      if (paramz.gAu())
      {
        d(paramz, paramInt);
        AppMethodBeat.o(5935);
        return;
      }
      if (paramz.gAv())
      {
        if (paramz.gAv())
        {
          localObject1 = (b)this.psu.get(paramz.getId());
          if (localObject1 == null)
          {
            l = System.currentTimeMillis();
            localObject2 = new b();
            this.psu.put(paramz.getId(), localObject2);
            ((b)localObject2).KUC = paramz.field_talker;
            a((b)localObject2, paramInt, paramz);
            ((b)localObject2).ybm = f(paramz);
            a((b)localObject2, paramz.field_talker);
            ((b)localObject2).nHh = af.G(paramz);
            localObject1 = paramz.gAG();
            ((b)localObject2).aid = ((String)localObject1);
            ((b)localObject2).traceid = paramz.getTraceId();
            localObject3 = r.NPl;
            if (r.biK((String)localObject1)) {}
            for (paramInt = 1;; paramInt = 0)
            {
              ((b)localObject2).KVi = paramInt;
              localObject2 = MultiProcessMMKV.getSingleMMKV("biz_timeline_ad");
              if (!Util.isEqual((String)localObject1, ((MultiProcessMMKV)localObject2).decodeString("BizLastExposeAdAId")))
              {
                ((MultiProcessMMKV)localObject2).encode("BizLastExposeAdTime", l);
                ((MultiProcessMMKV)localObject2).encode("BizLastExposeAdAId", (String)localObject1);
              }
              localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
              com.tencent.mm.plugin.webcanvas.l.LV(69L);
              localObject1 = new com.tencent.mm.storage.p();
              ((com.tencent.mm.storage.p)localObject1).field_aId = paramz.gAG();
              ((com.tencent.mm.storage.p)localObject1).field_msgId = paramz.field_msgId;
              ((com.tencent.mm.storage.p)localObject1).field_exposeTime = l;
              com.tencent.mm.al.ag.bao().a((com.tencent.mm.storage.p)localObject1);
              AppMethodBeat.o(5935);
              return;
            }
          }
          ((b)localObject1).KUG += 1;
          ((b)localObject1).pos = paramInt;
          ((b)localObject1).KUO = ((int)(System.currentTimeMillis() / 1000L));
          a((b)localObject1, paramz.field_talker);
        }
        AppMethodBeat.o(5935);
        return;
      }
      if (paramz.gAs())
      {
        e(paramz, paramInt);
        AppMethodBeat.o(5935);
        return;
      }
      localObject1 = (b)this.psu.get(paramz.getId());
      if (localObject1 == null)
      {
        localObject1 = new b();
        this.psu.put(paramz.getId(), localObject1);
        ((b)localObject1).KUC = paramz.field_talker;
        ((b)localObject1).dFm = 0L;
        a((b)localObject1, paramInt, paramz);
        ((b)localObject1).KUI = 0;
        ((b)localObject1).KUK = 0;
        ((b)localObject1).KUL = 0;
        ((b)localObject1).KTM = 0;
        ((b)localObject1).ybm = f(paramz);
        a((b)localObject1, paramz.field_talker);
        if (paramz.NQj)
        {
          paramInt = 1;
          ((b)localObject1).KUZ = paramInt;
          if (!paramz.NQk) {
            break label1420;
          }
        }
        label1420:
        for (paramInt = j;; paramInt = 0)
        {
          ((b)localObject1).KVa = paramInt;
          paramz = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramz.field_talker);
          paramInt = i;
          if (paramz != null)
          {
            paramInt = i;
            if (!c.oR(paramz.field_type)) {
              paramInt = 3;
            }
          }
          ((b)localObject1).nHh = paramInt;
          AppMethodBeat.o(5935);
          return;
          paramInt = 0;
          break;
        }
      }
      ((b)localObject1).KUG += 1;
      ((b)localObject1).pos = paramInt;
      ((b)localObject1).KUO = ((int)(System.currentTimeMillis() / 1000L));
      a((b)localObject1, paramz.field_talker);
      if (paramz.NQj)
      {
        paramInt = 1;
        ((b)localObject1).KUZ = paramInt;
        if (!paramz.NQk) {
          break label1508;
        }
      }
      label1508:
      for (paramInt = k;; paramInt = 0)
      {
        ((b)localObject1).KVa = paramInt;
        AppMethodBeat.o(5935);
        return;
        paramInt = 0;
        break;
      }
      label1513:
      k = 0;
      break label336;
      label1519:
      j = 0;
      break;
      label1525:
      j += 1;
      break;
      label1534:
      k = 0;
      break label392;
      k = 0;
      break label414;
    }
  }
  
  public final void cmz()
  {
    AppMethodBeat.i(194929);
    Dg(5);
    AppMethodBeat.o(194929);
  }
  
  public final void e(com.tencent.mm.storage.z paramz)
  {
    AppMethodBeat.i(194919);
    if (paramz.field_isRead == 1)
    {
      AppMethodBeat.o(194919);
      return;
    }
    this.psv.put(paramz.getId(), Boolean.TRUE);
    aa localaa = com.tencent.mm.al.ag.ban();
    if (paramz.field_isRead != 1) {
      com.tencent.f.h.RTc.b(new aa.5(localaa, paramz), "updateUnReadStatus");
    }
    AppMethodBeat.o(194919);
  }
  
  public final void f(com.tencent.mm.storage.z paramz, int paramInt)
  {
    AppMethodBeat.i(5938);
    a(paramz, 0, paramInt, -1);
    AppMethodBeat.o(5938);
  }
  
  public final void f(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(194931);
    int i = (int)(System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.report.service.h.CyF.a(15721, new Object[] { paramString1, Long.valueOf(0L), Integer.valueOf(17), Integer.valueOf(i), Integer.valueOf(this.dEb), Integer.valueOf(0), Long.valueOf(paramLong), paramString2, Integer.valueOf(1), Integer.valueOf(0) });
    AppMethodBeat.o(194931);
  }
  
  public final void g(com.tencent.mm.storage.z paramz)
  {
    AppMethodBeat.i(194927);
    f(paramz, 1);
    AppMethodBeat.o(194927);
  }
  
  public final void h(com.tencent.mm.storage.z paramz)
  {
    AppMethodBeat.i(194928);
    f(paramz, 9);
    AppMethodBeat.o(194928);
  }
  
  public final void l(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(194935);
    if (this.psw == null) {
      this.psw = new a((byte)0);
    }
    if (paramInt2 == 0)
    {
      localObject = this.psw;
      ((a)localObject).psE += 1;
      this.psw.psH = 0;
    }
    if (this.psw.psF == 0) {
      this.psw.psF = ((int)(System.currentTimeMillis() / 1000L));
    }
    Object localObject = this.psw;
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = this.psw.msgType;
    }
    ((a)localObject).msgType = i;
    this.psw.dEb = this.dEb;
    a locala = this.psw;
    localObject = paramString;
    if ("".equals(paramString)) {
      localObject = this.psw.dVu;
    }
    locala.dVu = ((String)localObject);
    if (this.psw.psG != 1) {
      this.psw.psG = paramInt2;
    }
    AppMethodBeat.o(194935);
  }
  
  static final class a
  {
    int dEb;
    String dVu;
    int msgType;
    int psE;
    int psF;
    int psG;
    int psH = -1;
  }
  
  public static final class b
    extends ot
  {
    public String fQY;
    public String psI;
  }
  
  public final class c<K, V>
    extends HashMap<K, V>
  {
    public c() {}
    
    public final V put(K paramK, V paramV)
    {
      AppMethodBeat.i(194917);
      com.tencent.mm.plugin.brandservice.ui.timeline.a.b localb = f.this.pst;
      String str = (String)paramK;
      f.b localb1 = (f.b)paramV;
      kotlin.g.b.p.h(str, "key");
      kotlin.g.b.p.h(localb1, "item");
      try
      {
        localb.pyQ.put(str, localb1);
        paramK = super.put(paramK, paramV);
        AppMethodBeat.o(194917);
        return paramK;
      }
      finally
      {
        AppMethodBeat.o(194917);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.f
 * JD-Core Version:    0.7.0.1
 */