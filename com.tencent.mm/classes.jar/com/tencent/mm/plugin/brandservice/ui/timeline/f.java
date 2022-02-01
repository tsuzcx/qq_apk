package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.database.Cursor;
import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.an.t;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.protocal.protobuf.duu;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqc;
import com.tencent.mm.protocal.protobuf.eqd;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.fbh;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.aa.6;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.o;

public final class f
{
  public List<z> dataList;
  public int fwM;
  public long sBA;
  public com.tencent.mm.plugin.brandservice.ui.timeline.a.b sBB;
  public c<String, f.b> sBC;
  public HashMap<String, Boolean> sBD;
  a sBE;
  public int sBx;
  public int sBy;
  public long sBz;
  
  public f(int paramInt, long paramLong)
  {
    AppMethodBeat.i(265895);
    this.sBA = 0L;
    this.dataList = null;
    this.sBC = new c();
    this.sBD = new HashMap();
    this.fwM = paramInt;
    this.sBz = paramLong;
    com.tencent.mm.storage.v localv = com.tencent.mm.storage.v.Vdz;
    this.sBA = com.tencent.mm.storage.v.hwk();
    AppMethodBeat.o(265895);
  }
  
  private void a(f.b paramb, int paramInt, z paramz)
  {
    int i = 0;
    AppMethodBeat.i(265897);
    paramb.RWt = System.currentTimeMillis();
    paramb.RVT = ((int)(paramb.RWt / 1000L));
    paramb.pos = paramInt;
    paramb.ilo = paramz.field_bizClientMsgId;
    paramb.RVL = 1;
    paramb.RVS = 0;
    paramb.RVU = ((int)(paramz.field_createTime / 1000L));
    if (paramz.hwz())
    {
      paramInt = 3;
      paramb.RVW = paramInt;
      if (!this.sBD.containsKey(paramz.getId())) {
        break label167;
      }
    }
    label167:
    for (paramInt = i;; paramInt = 1)
    {
      paramb.RWc = paramInt;
      paramb.RWj = paramz.field_rankSessionId;
      paramb.weight = ((int)paramz.hww());
      AppMethodBeat.o(265897);
      return;
      if (paramz.hwv() == com.tencent.mm.ao.af.bjB().hxb())
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
  
  private static void a(f.b paramb, String paramString)
  {
    AppMethodBeat.i(5936);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramString);
    if ((paramString != null) && (paramString.ayn()))
    {
      paramb.RVR = 1;
      paramb.RVV = 1;
      AppMethodBeat.o(5936);
      return;
    }
    paramb.RVR = 0;
    paramb.RVV = 0;
    AppMethodBeat.o(5936);
  }
  
  public static void a(eqg parameqg)
  {
    AppMethodBeat.i(265905);
    if (parameqg.UsF != null) {
      com.tencent.mm.plugin.report.service.h.IzE.a(21064, new Object[] { Long.valueOf(System.currentTimeMillis()), parameqg.UsF.RVi, Long.valueOf(parameqg.Uaw), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(parameqg.style), parameqg.UsF.RVm });
    }
    AppMethodBeat.o(265905);
  }
  
  private void a(z paramz, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5939);
    com.tencent.mm.plugin.brandservice.b.am(new f.4(this, paramz, paramInt1, paramInt2, paramInt3));
    AppMethodBeat.o(5939);
  }
  
  private void d(z paramz, int paramInt)
  {
    AppMethodBeat.i(265900);
    eqg localeqg = paramz.hwL();
    Object localObject2;
    int j;
    int i;
    Object localObject3;
    Object localObject1;
    Object localObject4;
    if ((localeqg != null) && ((localeqg.style == 101) || (localeqg.style == 102) || (localeqg.style == 103)))
    {
      localObject2 = localeqg.UsF;
      if ((localObject2 == null) || (Util.isNullOrNil(((amf)localObject2).RVd)))
      {
        AppMethodBeat.o(265900);
        return;
      }
      j = 0;
      i = 0;
      if (j < ((amf)localObject2).RVd.size())
      {
        if (((pf)((amf)localObject2).RVd.get(j)).RIs != 0) {
          break label1641;
        }
        localObject3 = (pe)((pf)((amf)localObject2).RVd.get(j)).RXM.get(0);
        localObject1 = (f.b)this.sBC.get(paramz.getId() + "_" + j);
        if (localObject1 == null)
        {
          localObject4 = new f.b();
          this.sBC.put(paramz.getId() + "_" + j, localObject4);
          ((f.b)localObject4).RVH = ((pf)((amf)localObject2).RVd.get(j)).UserName;
          if ((localObject3 != null) && ((((pe)localObject3).RIs & 0x1) == 0))
          {
            localObject1 = ((pe)localObject3).RTk;
            if (Util.isNullOrNil((String)localObject1)) {}
          }
        }
      }
    }
    label1641:
    for (;;)
    {
      try
      {
        localObject1 = Uri.parse((String)localObject1);
        int k = Util.getInt(((Uri)localObject1).getQueryParameter("idx"), 0);
        long l1 = Util.getLong(((Uri)localObject1).getQueryParameter("mid"), 0L);
        ((f.b)localObject4).lnn = ((int)Util.getLong(new String(Base64.decode(((Uri)localObject1).getQueryParameter("__biz"), 2)), 0L));
        ((f.b)localObject4).RVK.add(Integer.valueOf(k));
        ((f.b)localObject4).fxU = l1;
        ((f.b)localObject4).RVY = l1;
        ((f.b)localObject4).RWl = ((pe)localObject3).RXJ;
        ((f.b)localObject4).RWm = ((pe)localObject3).RXK;
        a((f.b)localObject4, paramInt, paramz);
        k = 3;
        if (localeqg.style == 103) {
          k = 7;
        }
        ((f.b)localObject4).qJt = k;
        if (((pe)localObject3).CPq != null) {
          ((f.b)localObject4).RWh = ab.aXb(((pe)localObject3).CPq);
        }
        if (localeqg != null) {
          ((f.b)localObject4).RWg = localeqg.Uaw;
        }
        ((f.b)localObject4).RVZ = j;
        if (localObject3 != null) {
          ((f.b)localObject4).RKb = ((pe)localObject3).lpx;
        }
        if (paramz.Vei != null)
        {
          k = paramz.Vei.style;
          ((f.b)localObject4).style = k;
          if (paramz.Vei == null) {
            continue;
          }
          localObject1 = paramz.Vei.event;
          ((f.b)localObject4).event = ((String)localObject1);
          if ((paramz.Vei != null) && (paramz.Vei.UsF != null))
          {
            ((f.b)localObject4).fUL = paramz.Vei.UsF.RVi;
            ((f.b)localObject4).RWk = paramz.Vei.UsF.RVm;
          }
          if ((localeqg.style == 102) || (localeqg.style == 103))
          {
            ((f.b)localObject4).RWp = localeqg.UsF.SwI;
            ((f.b)localObject4).RWo = localeqg.UsF.SwH;
          }
          ((f.b)localObject4).tpe = localeqg.UsF.SwE;
          ((f.b)localObject4).RWv = ((pe)localObject3).RTv;
          if ((i == 0) && (localeqg.UsF != null)) {
            com.tencent.mm.plugin.report.service.h.IzE.a(21064, new Object[] { Long.valueOf(System.currentTimeMillis()), localeqg.UsF.RVi, Long.valueOf(localeqg.Uaw), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(localeqg.style), localeqg.UsF.RVm });
          }
          i = 1;
          j += 1;
          break;
        }
        k = 0;
        continue;
        localObject1 = "";
        continue;
        ((f.b)localObject1).RVL += 1;
        ((f.b)localObject1).pos = paramInt;
        ((f.b)localObject1).RVT = ((int)(System.currentTimeMillis() / 1000L));
        continue;
        AppMethodBeat.o(265900);
        return;
        if ((localeqg != null) && (localeqg.style == 1001) && (localeqg.UsH != null))
        {
          if (paramz.hwB())
          {
            localObject1 = (f.b)this.sBC.get(paramz.getId() + "_0");
            if (localObject1 == null)
            {
              localObject1 = new f.b();
              this.sBC.put(paramz.getId() + "_0", localObject1);
              ((f.b)localObject1).zaX = localeqg.fMh;
              a((f.b)localObject1, paramInt, paramz);
              ((f.b)localObject1).qJt = 5;
              if (localeqg != null) {
                ((f.b)localObject1).RWg = localeqg.Uaw;
              }
              ((f.b)localObject1).style = 1001;
              localObject1 = com.tencent.mm.plugin.webcanvas.l.PuB;
              com.tencent.mm.plugin.webcanvas.l.Tt(74L);
              localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
              l1 = System.currentTimeMillis();
              localObject3 = localeqg.UsH.cardId;
              long l2 = localeqg.Uaw;
              paramInt = localeqg.style;
              if (localeqg.UsF == null) {
                continue;
              }
              localObject1 = localeqg.UsF.RVm;
              ((com.tencent.mm.plugin.report.service.h)localObject2).a(21064, new Object[] { Long.valueOf(l1), localObject3, Long.valueOf(l2), Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(paramInt), localObject1 });
              Log.i("MicroMsg.BizTimeLineReport", "onExposeRecCanvasMsg %d", new Object[] { Long.valueOf(paramz.field_msgId) });
            }
          }
          else
          {
            AppMethodBeat.o(265900);
            return;
          }
          ((f.b)localObject1).RVL += 1;
          ((f.b)localObject1).pos = paramInt;
          ((f.b)localObject1).RVT = ((int)(System.currentTimeMillis() / 1000L));
          continue;
          localObject1 = "";
          continue;
        }
        localObject1 = paramz.hwK();
        if ((localObject1 == null) || (((eqb)localObject1).RXM == null) || (((eqb)localObject1).RXM.size() <= 0))
        {
          Log.w("MicroMsg.BizTimeLineReport", "recCard is null");
          AppMethodBeat.o(265900);
          return;
        }
        k = ((eqb)localObject1).RXM.size();
        i = 0;
        if (i < k)
        {
          localObject2 = (eqc)((eqb)localObject1).RXM.get(i);
          localObject3 = (f.b)this.sBC.get(paramz.getId() + "_" + i);
          if (localObject3 == null)
          {
            localObject3 = new f.b();
            this.sBC.put(paramz.getId() + "_" + i, localObject3);
            ((f.b)localObject3).RVH = paramz.field_talker;
            if ((localObject2 != null) && ((((eqc)localObject2).RIs & 0x1) == 0))
            {
              localObject4 = ((eqc)((eqb)localObject1).RXM.get(i)).RTk;
              if (Util.isNullOrNil((String)localObject4)) {}
            }
          }
        }
        try
        {
          localObject4 = Uri.parse((String)localObject4);
          j = Util.getInt(((Uri)localObject4).getQueryParameter("idx"), 0);
          l1 = Util.getLong(((Uri)localObject4).getQueryParameter("mid"), 0L);
          ((f.b)localObject3).lnn = ((int)Util.getLong(new String(Base64.decode(((Uri)localObject4).getQueryParameter("__biz"), 2)), 0L));
          ((f.b)localObject3).RVK.add(Integer.valueOf(j));
          ((f.b)localObject3).fxU = l1;
          ((f.b)localObject3).RVY = l1;
          if (localObject2 != null) {
            ((f.b)localObject3).RKb = ((eqc)localObject2).lpx;
          }
          a((f.b)localObject3, paramInt, paramz);
          ((f.b)localObject3).qJt = 1;
          if (((eqb)localObject1).Usy != null) {
            ((f.b)localObject3).RWh = ab.aXb(((eqb)localObject1).Usy.UsA);
          }
          if (localeqg != null) {
            ((f.b)localObject3).RWg = localeqg.Uaw;
          }
          ((f.b)localObject3).RVZ = i;
          if (paramz.Vei != null)
          {
            j = paramz.Vei.style;
            ((f.b)localObject3).style = j;
            ((f.b)localObject3).tpe = ((eqb)localObject1).SwE;
            i += 1;
          }
          else
          {
            j = 0;
            continue;
            ((f.b)localObject3).RVL += 1;
            ((f.b)localObject3).pos = paramInt;
            ((f.b)localObject3).RVT = ((int)(System.currentTimeMillis() / 1000L));
            continue;
            AppMethodBeat.o(265900);
            return;
          }
        }
        catch (Exception localException2) {}
      }
      catch (Exception localException1) {}
    }
  }
  
  private void e(z paramz, int paramInt)
  {
    AppMethodBeat.i(265903);
    if ((!paramz.hwz()) || (paramz.Ven == null) || (Util.isNullOrNil(paramz.Ven.UaA)))
    {
      AppMethodBeat.o(265903);
      return;
    }
    dug localdug = paramz.Ven;
    int j = localdug.UaA.size();
    int i = 0;
    for (;;)
    {
      Object localObject1;
      f.b localb;
      Object localObject2;
      if (i < j)
      {
        localObject1 = (dur)localdug.UaA.get(i);
        localb = (f.b)this.sBC.get(paramz.getId() + "_" + i);
        if (localb == null)
        {
          localb = new f.b();
          this.sBC.put(paramz.getId() + "_" + i, localb);
          a(localb, paramInt, paramz);
          if (i == 0) {
            localb.zaX = localdug.RXO;
          }
          localb.qJt = com.tencent.mm.storage.af.L(paramz);
          localb.RWu = paramz.Vee;
          localb.style = localdug.RVf;
          localb.RWm = ((dur)localObject1).RXK;
          localb.RKb = ((dur)localObject1).UaX.lpx;
          localb.RVZ = i;
          localb.RVH = ((dur)localObject1).UaW.UserName;
          localb.fUL = localdug.RVi;
          localObject2 = ((dur)localObject1).UaX.RTk;
          if (Util.isNullOrNil((String)localObject2)) {}
        }
      }
      try
      {
        localObject2 = Uri.parse((String)localObject2);
        int k = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
        long l = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
        localb.lnn = ((int)Util.getLong(new String(Base64.decode(((Uri)localObject2).getQueryParameter("__biz"), 2)), 0L));
        localb.RVK.add(Integer.valueOf(k));
        localb.fxU = l;
        localb.RVY = l;
        label380:
        if (localdug.RVf == 2002)
        {
          localb.RWp = localdug.SwI;
          localb.RWo = localdug.SwH;
          if (localdug.RVf != 2002) {
            break label549;
          }
          localb.RWh = ab.aXb(localdug.UaC);
          if (((dur)localObject1).UaX.Tua != null) {
            localb.RWv = ((dur)localObject1).UaX.Tua.RTv;
          }
          localb.RWe = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.c((dur)localObject1);
          if (localdug.RVf != 2002) {
            break label627;
          }
          localObject1 = localdug.UaD;
          if (localObject1 != null) {
            localb.tpe = ab.aXb(((duu)localObject1).wording);
          }
          localObject1 = com.tencent.mm.plugin.webcanvas.l.PuB;
          com.tencent.mm.plugin.webcanvas.l.Tt(74L);
        }
        for (;;)
        {
          label411:
          label435:
          label490:
          i += 1;
          break;
          localb.RWp = ((dur)localObject1).SwI;
          localb.RWo = ((dur)localObject1).SwH;
          break label411;
          label549:
          if (localdug.RVf != 2001) {
            break label435;
          }
          localb.RWh = ab.aXb(((dur)localObject1).UaC);
          if ((((dur)localObject1).UaX.lpx != 5) || (i != 0) || (!com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(localdug)) || (((dur)localObject1).UaX.Tua == null)) {
            break label435;
          }
          localb.sBR = ((dur)localObject1).UaX.Tua.RTv;
          break label435;
          label627:
          localObject1 = ((dur)localObject1).UaD;
          break label490;
          localb.RVL += 1;
          localb.pos = paramInt;
          localb.RVT = ((int)(System.currentTimeMillis() / 1000L));
        }
        AppMethodBeat.o(265903);
        return;
      }
      catch (Exception localException)
      {
        break label380;
      }
    }
  }
  
  private static int f(z paramz)
  {
    AppMethodBeat.i(265910);
    if (paramz.hwH())
    {
      AppMethodBeat.o(265910);
      return 1;
    }
    if (paramz.hwG())
    {
      AppMethodBeat.o(265910);
      return 2;
    }
    if (paramz.hwF())
    {
      AppMethodBeat.o(265910);
      return 3;
    }
    AppMethodBeat.o(265910);
    return -1;
  }
  
  public final void GM(int paramInt)
  {
    AppMethodBeat.i(5940);
    a("", 0L, 0, paramInt, -1);
    AppMethodBeat.o(5940);
  }
  
  public final void a(com.tencent.mm.plugin.brandservice.ui.timeline.a.b paramb)
  {
    this.sBB = paramb;
  }
  
  public final void a(final z paramz, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(265907);
    if (paramz == null)
    {
      AppMethodBeat.o(265907);
      return;
    }
    Object localObject2 = (f.b)this.sBC.get(paramz.getId() + "_" + paramInt1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.sBB != null)
      {
        c(paramz, paramInt1);
        this.sBB.cBa();
        localObject1 = (f.b)this.sBC.get(paramz.getId() + "_" + paramInt1);
      }
    }
    if (localObject1 != null)
    {
      ((f.b)localObject1).RWd = 1;
      Log.d("MicroMsg.BizTimeLineReport", "onClick %d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.brandservice.b.am(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5930);
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(this.sBF);
          if (!Util.isNullOrNil(this.sBF.sBR))
          {
            f.b localb = this.sBF;
            MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
            localb.RWq = MPVideoPreviewMgr.aqx(this.sBF.sBR);
            localb = this.sBF;
            localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
            localb.RWr = MPVideoPreviewMgr.aqy(this.sBF.sBR);
          }
          Log.i("MicroMsg.BizTimeLineReport", "reportOnClick %s.", new Object[] { paramz.getId() });
          com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.brandservice.b.l(localLinkedList, f.this.sBx, f.this.sBy, f.this.fwM, f.this.sBz, 1, 1, f.this.sBA), 0);
          AppMethodBeat.o(5930);
        }
      });
      localObject1 = g.sBS;
      localObject1 = this.dataList;
      localObject2 = this.sBC;
      kotlin.g.b.p.k(paramz, "info");
      kotlin.g.b.p.k(localObject2, "sessionItemCache");
      ad localad = ad.Vfe;
      if ((!ad.hxt()) || ((g.bcJ().decodeInt("ReSortBizMsgFlag", 0) & 0x3) == 0)) {
        break label316;
      }
    }
    label316:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (localObject1 != null))
      {
        i = ((List)localObject1).indexOf(paramz);
        if (i >= 0) {
          com.tencent.e.h.ZvG.bc((Runnable)new g.b(paramz, i, (List)localObject1, (c)localObject2, paramInt1));
        }
      }
      if ((!paramz.hwB()) && (!paramz.hwz())) {
        a(paramz, paramInt1, 11, paramInt2);
      }
      AppMethodBeat.o(265907);
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
    AppMethodBeat.i(265915);
    int i = paramInt3;
    if (paramInt3 <= 0) {
      i = (int)(System.currentTimeMillis() / 1000L);
    }
    if (paramBoolean) {}
    for (paramInt3 = 1;; paramInt3 = 0)
    {
      as localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramString);
      int j = paramInt3;
      if (!paramBoolean)
      {
        j = paramInt3;
        if (localas != null)
        {
          j = paramInt3;
          if (!d.rk(localas.field_type)) {
            j = 3;
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(15721, new Object[] { paramString, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.fwM), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), "", Integer.valueOf(j), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(265915);
      return;
    }
  }
  
  public final void a(String paramString1, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString2, int paramInt3, String paramString3, String paramString4, String paramString5, int paramInt4, int paramInt5, String paramString6)
  {
    AppMethodBeat.i(265917);
    int j = (int)(System.currentTimeMillis() / 1000L);
    int i = 3;
    if (paramInt5 == 103) {
      i = 7;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(15721, new Object[] { paramString1, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(this.fwM), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), paramString2, Integer.valueOf(i), Integer.valueOf(paramInt3), paramString3, paramString4, paramString5, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString6 });
    AppMethodBeat.o(265917);
  }
  
  public final void a(String paramString1, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(265919);
    int j = (int)(System.currentTimeMillis() / 1000L);
    int i = 3;
    if (paramInt3 == 103) {
      i = 7;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(15721, new Object[] { paramString1, Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(this.fwM), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), paramString2, Integer.valueOf(i), Integer.valueOf(0), paramString3, paramString4, paramString5, Integer.valueOf(0), Integer.valueOf(paramInt3), paramString6, paramString7, paramString8 });
    AppMethodBeat.o(265919);
  }
  
  public final void a(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(265918);
    int i = (int)(System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.report.service.h.IzE.a(15721, new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(16), Integer.valueOf(i), Integer.valueOf(this.fwM), Integer.valueOf(paramInt1), Long.valueOf(0L), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(0), "", "", paramString3, Integer.valueOf(0), Integer.valueOf(paramInt2), paramString4 });
    AppMethodBeat.o(265918);
  }
  
  public final void b(z paramz, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(265909);
    if ((!paramz.hwz()) && (!paramz.hwB()))
    {
      AppMethodBeat.o(265909);
      return;
    }
    f.b localb = (f.b)this.sBC.get(paramz.getId() + "_" + paramInt1);
    if (localb == null)
    {
      Log.i("MicroMsg.BizTimeLineReport", "onClickTag fail sessionItem is null");
      AppMethodBeat.o(265909);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localb);
    if (!Util.isNullOrNil(localb.sBR))
    {
      MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
      localb.RWq = MPVideoPreviewMgr.aqx(localb.sBR);
      localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
      localb.RWr = MPVideoPreviewMgr.aqy(localb.sBR);
    }
    Log.i("MicroMsg.BizTimeLineReport", "reportOnClick %s.", new Object[] { paramz.getId() });
    if (24 == paramInt2) {}
    for (paramInt1 = 2;; paramInt1 = 3)
    {
      com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.brandservice.b.l(localLinkedList, this.sBx, this.sBy, this.fwM, this.sBz, 1, paramInt1, this.sBA), 0);
      AppMethodBeat.o(265909);
      return;
    }
  }
  
  public final void b(z paramz, boolean paramBoolean)
  {
    AppMethodBeat.i(5937);
    paramz = (f.b)this.sBC.get(paramz.getId());
    if (paramz == null)
    {
      AppMethodBeat.o(5937);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramz.RUK = i;
      AppMethodBeat.o(5937);
      return;
    }
  }
  
  public final void c(z paramz, int paramInt)
  {
    AppMethodBeat.i(5935);
    if (paramz == null)
    {
      AppMethodBeat.o(5935);
      return;
    }
    Object localObject1;
    int j;
    Object localObject2;
    f.b localb;
    if (paramz.hwA()) {
      if (paramz.hwA())
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramz.field_msgId, paramz.field_content);
        if ((localObject1 == null) || (Util.isNullOrNil(((u)localObject1).lpz)))
        {
          AppMethodBeat.o(5935);
          return;
        }
        try
        {
          i = ((u)localObject1).lpz.size();
          if ((i <= 2) || (paramz.field_isExpand)) {
            break label1440;
          }
          i = 2;
        }
        catch (UnsupportedOperationException paramz)
        {
          for (;;)
          {
            int i;
            Object localObject3;
            Log.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { paramz.getMessage() });
            AppMethodBeat.o(5935);
            return;
            localb.RVM = 0;
          }
        }
        catch (Exception paramz)
        {
          Log.w("MicroMsg.BizTimeLineReport", "exposeLog exp %s", new Object[] { paramz.getMessage() });
        }
        if (j >= i) {
          break label858;
        }
        localObject2 = (com.tencent.mm.aj.v)((u)localObject1).lpz.get(j);
        if (localObject2 == null) {
          break label1446;
        }
        localb = (f.b)this.sBC.get(paramz.getId() + "_" + j);
        if (localb != null) {
          break label764;
        }
        localb = new f.b();
        this.sBC.put(paramz.getId() + "_" + j, localb);
        localb.RVH = paramz.field_talker;
        a(localb, paramInt, paramz);
        localb.RVN = 0;
        localb.RVP = 0;
        localb.RVQ = 0;
        localb.RUK = 0;
        localb.msg_type = ((com.tencent.mm.aj.v)localObject2).type;
        if (!Util.isNullOrNil(((com.tencent.mm.aj.v)localObject2).url))
        {
          localObject3 = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apc(((com.tencent.mm.aj.v)localObject2).url);
          if (localObject3 != null)
          {
            k = 0;
            if (((com.tencent.mm.aj.p)localObject3).lpu != null) {
              k = ((com.tencent.mm.aj.p)localObject3).lpu.lpo;
            }
            localb.RVX = ("1_" + k + ";");
            localb.RWs = ((com.tencent.mm.aj.p)localObject3).lpv;
          }
        }
        localb.RVZ = j;
        if (!paramz.field_isExpand) {
          break label1455;
        }
        k = 1;
        label387:
        localb.RWa = k;
        if ((j != 0) || (!paramz.Veb)) {
          break label1461;
        }
        k = 1;
        label409:
        localb.RWe = k;
        if (!paramz.Vec) {
          break label1467;
        }
      }
    }
    label1280:
    label1435:
    label1440:
    label1446:
    label1455:
    label1461:
    label1467:
    for (int k = 1;; k = 0)
    {
      localb.RWf = k;
      localb.RWi = ((com.tencent.mm.aj.v)localObject2).lls;
      localb.RKb = ((com.tencent.mm.aj.v)localObject2).type;
      localb.RWj = paramz.field_rankSessionId;
      a(localb, paramz.field_talker);
      if (!Util.isNullOrNil(((com.tencent.mm.aj.v)localObject2).url))
      {
        localObject3 = Uri.parse(((com.tencent.mm.aj.v)localObject2).url);
        k = Util.getInt(((Uri)localObject3).getQueryParameter("idx"), 0);
        long l = Util.getLong(((Uri)localObject3).getQueryParameter("mid"), 0L);
        localb.lnn = ((int)Util.getLong(new String(Base64.decode(((Uri)localObject3).getQueryParameter("__biz"), 2)), 0L));
        localb.RVK.add(Integer.valueOf(k));
        localb.fxU = l;
        localb.RVY = l;
      }
      if (paramz.field_isExpand)
      {
        localb.RVM = 2;
        localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramz.field_talker);
        if ((localObject3 == null) || (d.rk(((ax)localObject3).field_type))) {
          break label758;
        }
      }
      label758:
      for (k = 2;; k = 0)
      {
        localb.qJt = k;
        if (((com.tencent.mm.aj.v)localObject2).type == 5) {
          localb.sBR = ((com.tencent.mm.aj.v)localObject2).vid;
        }
        localb.RWv = ((com.tencent.mm.aj.v)localObject2).vid;
        break label1446;
        if (((u)localObject1).lpz.size() > 2)
        {
          localb.RVM = 1;
          break;
        }
        AppMethodBeat.o(5935);
        return;
      }
      label764:
      if ((j == 0) && (paramz.Veb))
      {
        k = 1;
        localb.RWe = k;
        if (!paramz.Vec) {
          break label852;
        }
      }
      label852:
      for (k = 1;; k = 0)
      {
        localb.RWf = k;
        localb.RVL += 1;
        localb.pos = paramInt;
        localb.RVT = ((int)(System.currentTimeMillis() / 1000L));
        a(localb, paramz.field_talker);
        break label1446;
        k = 0;
        break;
      }
      label858:
      AppMethodBeat.o(5935);
      return;
      if (paramz.hwB())
      {
        d(paramz, paramInt);
        AppMethodBeat.o(5935);
        return;
      }
      if (paramz.hwC())
      {
        if (paramz.hwC())
        {
          localObject1 = (f.b)this.sBC.get(paramz.getId());
          if (localObject1 == null)
          {
            localObject1 = new f.b();
            this.sBC.put(paramz.getId(), localObject1);
            ((f.b)localObject1).RVH = paramz.field_talker;
            a((f.b)localObject1, paramInt, paramz);
            ((f.b)localObject1).msg_type = f(paramz);
            a((f.b)localObject1, paramz.field_talker);
            ((f.b)localObject1).qJt = com.tencent.mm.storage.af.L(paramz);
            localObject2 = paramz.hwO();
            ((f.b)localObject1).aid = ((String)localObject2);
            ((f.b)localObject1).traceid = paramz.getTraceId();
            paramz = r.VcW;
            if (r.bve((String)localObject2)) {}
            for (paramInt = 1;; paramInt = 0)
            {
              ((f.b)localObject1).RWn = paramInt;
              AppMethodBeat.o(5935);
              return;
            }
          }
          ((f.b)localObject1).RVL += 1;
          ((f.b)localObject1).pos = paramInt;
          ((f.b)localObject1).RVT = ((int)(System.currentTimeMillis() / 1000L));
          a((f.b)localObject1, paramz.field_talker);
        }
        AppMethodBeat.o(5935);
        return;
      }
      if (paramz.hwz())
      {
        e(paramz, paramInt);
        AppMethodBeat.o(5935);
        return;
      }
      localObject1 = (f.b)this.sBC.get(paramz.getId());
      if (localObject1 == null)
      {
        localObject1 = new f.b();
        this.sBC.put(paramz.getId(), localObject1);
        ((f.b)localObject1).RVH = paramz.field_talker;
        ((f.b)localObject1).fxU = 0L;
        a((f.b)localObject1, paramInt, paramz);
        ((f.b)localObject1).RVN = 0;
        ((f.b)localObject1).RVP = 0;
        ((f.b)localObject1).RVQ = 0;
        ((f.b)localObject1).RUK = 0;
        ((f.b)localObject1).msg_type = f(paramz);
        a((f.b)localObject1, paramz.field_talker);
        if (paramz.Veb)
        {
          paramInt = 1;
          ((f.b)localObject1).RWe = paramInt;
          if (!paramz.Vec) {
            break label1343;
          }
          paramInt = 1;
          ((f.b)localObject1).RWf = paramInt;
          paramz = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramz.field_talker);
          if ((paramz == null) || (d.rk(paramz.field_type))) {
            break label1348;
          }
        }
        label1343:
        label1348:
        for (paramInt = 3;; paramInt = 0)
        {
          ((f.b)localObject1).qJt = paramInt;
          AppMethodBeat.o(5935);
          return;
          paramInt = 0;
          break;
          paramInt = 0;
          break label1280;
        }
      }
      ((f.b)localObject1).RVL += 1;
      ((f.b)localObject1).pos = paramInt;
      ((f.b)localObject1).RVT = ((int)(System.currentTimeMillis() / 1000L));
      a((f.b)localObject1, paramz.field_talker);
      if (paramz.Veb)
      {
        paramInt = 1;
        ((f.b)localObject1).RWe = paramInt;
        if (!paramz.Vec) {
          break label1435;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        ((f.b)localObject1).RWf = paramInt;
        AppMethodBeat.o(5935);
        return;
        paramInt = 0;
        break;
      }
      j = 0;
      break;
      j += 1;
      break;
      k = 0;
      break label387;
      k = 0;
      break label409;
    }
  }
  
  public final void cAf()
  {
    AppMethodBeat.i(265913);
    GM(5);
    AppMethodBeat.o(265913);
  }
  
  public final void e(z paramz)
  {
    AppMethodBeat.i(265896);
    if (paramz.field_isRead == 1)
    {
      AppMethodBeat.o(265896);
      return;
    }
    this.sBD.put(paramz.getId(), Boolean.TRUE);
    aa localaa = com.tencent.mm.ao.af.bjB();
    if (paramz.field_isRead != 1) {
      com.tencent.e.h.ZvG.d(new aa.6(localaa, paramz), "updateUnReadStatus");
    }
    AppMethodBeat.o(265896);
  }
  
  public final void f(z paramz, int paramInt)
  {
    AppMethodBeat.i(265908);
    a(paramz, paramInt, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(265908);
  }
  
  public final void f(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(265916);
    int i = (int)(System.currentTimeMillis() / 1000L);
    com.tencent.mm.plugin.report.service.h.IzE.a(15721, new Object[] { paramString1, Long.valueOf(0L), Integer.valueOf(17), Integer.valueOf(i), Integer.valueOf(this.fwM), Integer.valueOf(0), Long.valueOf(paramLong), paramString2, Integer.valueOf(1), Integer.valueOf(0) });
    AppMethodBeat.o(265916);
  }
  
  public final void g(z paramz)
  {
    AppMethodBeat.i(265911);
    g(paramz, 1);
    AppMethodBeat.o(265911);
  }
  
  public final void g(z paramz, int paramInt)
  {
    AppMethodBeat.i(5938);
    a(paramz, 0, paramInt, -1);
    AppMethodBeat.o(5938);
  }
  
  public final void h(z paramz)
  {
    AppMethodBeat.i(265912);
    g(paramz, 9);
    AppMethodBeat.o(265912);
  }
  
  public final void l(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(265920);
    if (this.sBE == null) {
      this.sBE = new a((byte)0);
    }
    if (paramInt2 == 0)
    {
      localObject = this.sBE;
      ((a)localObject).sBN += 1;
      this.sBE.sBQ = 0;
    }
    if (this.sBE.sBO == 0) {
      this.sBE.sBO = ((int)(System.currentTimeMillis() / 1000L));
    }
    Object localObject = this.sBE;
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = this.sBE.msgType;
    }
    ((a)localObject).msgType = i;
    this.sBE.fwM = this.fwM;
    a locala = this.sBE;
    localObject = paramString;
    if ("".equals(paramString)) {
      localObject = this.sBE.fOX;
    }
    locala.fOX = ((String)localObject);
    if (this.sBE.sBP != 1) {
      this.sBE.sBP = paramInt2;
    }
    AppMethodBeat.o(265920);
  }
  
  static final class a
  {
    String fOX;
    int fwM;
    int msgType;
    int sBN;
    int sBO;
    int sBP;
    int sBQ = -1;
  }
  
  public final class c<K, V>
    extends HashMap<K, V>
  {
    public c() {}
    
    public final V put(K paramK, V paramV)
    {
      AppMethodBeat.i(266161);
      com.tencent.mm.plugin.brandservice.ui.timeline.a.b localb = f.this.sBB;
      String str = (String)paramK;
      f.b localb1 = (f.b)paramV;
      kotlin.g.b.p.k(str, "key");
      kotlin.g.b.p.k(localb1, "item");
      try
      {
        localb.sIz.put(str, localb1);
        paramK = super.put(paramK, paramV);
        AppMethodBeat.o(266161);
        return paramK;
      }
      finally
      {
        AppMethodBeat.o(266161);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.f
 * JD-Core Version:    0.7.0.1
 */