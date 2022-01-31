package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.h.a.ln;
import com.tencent.mm.h.a.qt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.azf;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.s.a;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Method;
import junit.framework.Assert;

public final class j
  extends m
  implements com.tencent.mm.network.k
{
  private static boolean eta = false;
  private static int etd = 0;
  protected static int selector = 7;
  public String TAG = "MicroMsg.NetSceneSync";
  private String aox = "";
  private com.tencent.mm.ah.f dmL;
  private am ebj = null;
  private int errCode = 0;
  private int errType = 0;
  private boolean esC = false;
  public p esZ = null;
  private int esl = 0;
  private g.a esm;
  private long eso = -1L;
  private boolean esp = false;
  private boolean etb = false;
  private am etc = null;
  private int ete;
  private boolean etf = false;
  private String etg = "";
  public s.b eth = null;
  private long eti = 0L;
  
  public j(int paramInt)
  {
    y.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", new Object[] { Integer.valueOf(paramInt), bk.csb() });
    this.etg = ak.cri();
    this.esm = new g.a();
    if (this.esZ == null) {
      this.esZ = new p();
    }
    this.esZ.eug = paramInt;
    g.DQ();
    if ((g.DP() != null) && (g.DK()))
    {
      g.DQ();
      if ((g.DP().Dz() != null) && (!com.tencent.mm.kernel.a.CW()))
      {
        g.DQ();
        long l = bk.a((Long)g.DP().Dz().get(8196, null), 0L);
        if (l != 0L)
        {
          g.DQ();
          g.DP().Dz().o(8196, Long.valueOf(0L));
          int i = (int)(l | selector);
          selector = i;
          selector = i & 0x5F;
        }
      }
    }
    if (paramInt == 1) {
      eta = true;
    }
    if (paramInt == 1010)
    {
      selector |= 0x10;
      eta = true;
      this.ete = 7;
    }
    for (;;)
    {
      if (etd == 0) {
        Ph();
      }
      return;
      if (paramInt == 1011)
      {
        selector |= 0x40;
        eta = true;
        this.ete = 7;
      }
      else if (paramInt == 3)
      {
        selector |= 0x40000;
        eta = true;
        this.ete = 3;
        y.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(selector), Integer.valueOf(this.ete) });
      }
      else
      {
        this.ete = paramInt;
      }
    }
  }
  
  public j(s.b paramb, int paramInt, long paramLong)
  {
    this(8);
    this.etg = ak.cri();
    y.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", new Object[] { Long.valueOf(paramb.bufferSize), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    this.esl = paramInt;
    this.eso = paramLong;
    this.ebj = new am(g.DS().mnU.getLooper(), new j.1(this, paramb), false);
    if (etd == 0) {
      Ph();
    }
  }
  
  private boolean Ph()
  {
    Object localObject2 = new PInt();
    g.DQ();
    g.DN();
    Object localObject1 = com.tencent.mm.booter.f.a((PInt)localObject2, com.tencent.mm.kernel.a.CK());
    String str = this.TAG;
    int j = ((PInt)localObject2).value;
    int k = hashCode();
    if (localObject1 != null) {}
    for (int i = localObject1.length;; i = 0)
    {
      y.i(str, "dealWithRespData index:%d, hashcode:%d, buf.len:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      etd = ((PInt)localObject2).value;
      if ((((PInt)localObject2).value != 0) && (!bk.bE((byte[])localObject1))) {
        break;
      }
      etd = 0;
      return false;
    }
    localObject2 = new s.b();
    try
    {
      ((s.b)localObject2).A((byte[])localObject1);
      localObject1 = new j.a((s.b)localObject2);
      this.etc = new am(g.DS().mnU.getLooper(), new j.2(this, (j.a)localObject1), false);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.f.nEG.a(99L, 226L, 1L, false);
      y.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
      i = etd;
      g.DQ();
      g.DN();
      com.tencent.mm.booter.f.aV(i, com.tencent.mm.kernel.a.CK());
      etd = 0;
      return false;
    }
    catch (Error localError)
    {
      long l1 = Runtime.getRuntime().freeMemory() / 1000L;
      long l2 = Runtime.getRuntime().totalMemory() / 1000L;
      y.i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
      Assert.assertTrue("dealWithRespData error", false);
    }
    return false;
  }
  
  private boolean Pi()
  {
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)ae.getContext().getSystemService("power"), new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      y.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.valueOf(true), bk.j(localException) });
    }
    return true;
  }
  
  protected final int Ka()
  {
    return 100;
  }
  
  public final boolean Kx()
  {
    return true;
  }
  
  public final boolean Ky()
  {
    int i = 1;
    boolean bool = super.Ky();
    com.tencent.mm.plugin.report.f localf;
    if (bool)
    {
      com.tencent.mm.plugin.report.f.nEG.a(99L, 228L, 1L, false);
      localf = com.tencent.mm.plugin.report.f.nEG;
      if (!com.tencent.mm.sdk.a.b.foreground) {
        break label114;
      }
    }
    for (;;)
    {
      localf.f(12063, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), "9999" });
      return bool;
      label114:
      i = 2;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    if (k.Pj())
    {
      etd = 0;
      y.e(this.TAG, "dkinit never do sync before init done");
      return -1;
    }
    this.dmL = paramf;
    if (this.esZ == null) {
      this.esZ = new p();
    }
    this.esZ.euf = com.tencent.mm.sdk.a.b.foreground;
    if (this.etc != null)
    {
      y.i(this.TAG, "pushSyncRespHandler not null");
      c(parame);
      this.etc.S(0L, 0L);
      return 0;
    }
    if (etd > 0)
    {
      y.w(this.TAG, "other sync is dealing with resp data :%d", new Object[] { Integer.valueOf(etd) });
      return -1;
    }
    if (this.ebj != null)
    {
      y.i(this.TAG, "pusher not null");
      c(parame);
      this.ebj.S(0L, 0L);
      return 0;
    }
    paramf = new j.a();
    azf localazf = ((s.a)paramf.Kv()).sqi;
    if (this.ete == 3)
    {
      localazf.tvv = 1;
      if (!this.etf) {
        break label345;
      }
    }
    label345:
    for (int i = 6;; i = this.ete)
    {
      this.ete = i;
      localazf.sIh = selector;
      g.DQ();
      byte[] arrayOfByte = bk.ZM(bk.pm((String)g.DP().Dz().get(8195, new byte[0])));
      localazf.sIi = aa.I(arrayOfByte);
      localazf.pyo = this.ete;
      localazf.tvu = new qw();
      localazf.syI = d.dOM;
      y.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", new Object[] { Integer.valueOf(localazf.sIh), Integer.valueOf(localazf.pyo), com.tencent.mm.protocal.z.br(arrayOfByte) });
      eta = false;
      return a(parame, paramf, this);
      localazf.tvv = 0;
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramq == null) || (paramq.getType() != 138))
    {
      paramString = this.TAG;
      if (paramq == null) {}
      for (paramInt1 = -2;; paramInt1 = paramq.getType())
      {
        y.e(paramString, "onGYNetEnd error type:%d", new Object[] { Integer.valueOf(paramInt1) });
        return;
      }
    }
    s.b localb = (s.b)paramq.HF();
    paramArrayOfByte = this.TAG;
    long l = this.esm.zJ();
    boolean bool = this.esp;
    if (localb.sqj.sIl == null)
    {
      paramInt1 = -1;
      y.i(paramArrayOfByte, "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(l), Boolean.valueOf(bool), Integer.valueOf(paramInt1), this.ebj, this.etc });
      if (localb.sqj.sIl != null) {
        break label363;
      }
      paramInt1 = -1;
      label193:
      if (paramInt1 <= 0) {
        break label378;
      }
      paramInt1 = 1;
      label199:
      if (Pi()) {
        break label391;
      }
      paramArrayOfByte = com.tencent.mm.plugin.report.f.nEG;
      if (paramInt1 == 0) {
        break label383;
      }
      l = 221L;
      label220:
      paramArrayOfByte.a(99L, l, 1L, false);
      this.ebj = null;
      this.etb = true;
      if ((paramInt2 != 4) || (paramInt3 != -2006)) {
        break label839;
      }
      bool = true;
      paramInt2 = 0;
      paramInt3 = 0;
      com.tencent.mm.plugin.report.f.nEG.a(99L, 227L, 1L, false);
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        if (this.eth != null)
        {
          y.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
          this.errType = paramInt2;
          this.errCode = paramInt3;
          this.aox = paramString;
          ((s.b)paramq.HF()).sqj.sFD = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.f.nEG.a(99L, 232L, 1L, false);
          return;
          paramInt1 = localb.sqj.sIl.hPS;
          break;
          label363:
          paramInt1 = localb.sqj.sIl.hPS;
          break label193;
          label378:
          paramInt1 = 0;
          break label199;
          label383:
          l = 218L;
          break label220;
          label391:
          if (!com.tencent.mm.sdk.a.b.foreground)
          {
            paramArrayOfByte = com.tencent.mm.plugin.report.f.nEG;
            if (paramInt1 != 0) {}
            for (l = 220L;; l = 217L)
            {
              paramArrayOfByte.a(99L, l, 1L, false);
              break;
            }
          }
          paramArrayOfByte = com.tencent.mm.plugin.report.f.nEG;
          if (paramInt1 != 0) {}
          for (l = 219L;; l = 216L)
          {
            paramArrayOfByte.a(99L, l, 1L, false);
            break;
          }
          this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
      }
      com.tencent.mm.plugin.report.f.nEG.a(99L, 233L, 1L, false);
      paramArrayOfByte = aa.a(((s.a)paramq.Kv()).sqi.sIi);
      paramq = aa.a(localb.sqj.sIi);
      y.i(this.TAG, "onGYNetEnd replace key:%b req :%s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.protocal.z.br(paramArrayOfByte) });
      y.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.protocal.z.br(paramq) });
      if (!bool)
      {
        paramString = paramArrayOfByte;
        if (bk.bE(paramArrayOfByte))
        {
          g.DQ();
          paramString = bk.ZM(bk.pm((String)g.DP().Dz().get(8195, new byte[0])));
          y.d(this.TAG, "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramString.length), bk.bD(paramString) });
        }
        paramArrayOfByte = com.tencent.mm.protocal.z.g(paramString, paramq);
        if (paramArrayOfByte != null)
        {
          paramString = paramArrayOfByte;
          if (paramArrayOfByte.length > 0) {}
        }
        else
        {
          y.w(this.TAG, "merge key failed, use server side instead");
          paramString = paramq;
        }
        localb.sqj.sIi = aa.I(paramString);
      }
      g.DQ();
      g.DN().be(localb.sqj.hQq, localb.sqj.tvw);
      g.DQ();
      g.DN();
      com.tencent.mm.kernel.a.hv(localb.sqj.hQq);
      if (this.eth == null) {}
      for (bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.eth = localb;
        this.eti = bk.UY();
        new am(g.DS().mnU.getLooper(), new j.3(this), true).S(50L, 50L);
        return;
      }
      label839:
      bool = false;
    }
  }
  
  protected final void a(s.b paramb)
  {
    g.DQ();
    g.DP().Dz().o(8195, bk.bG(aa.a(paramb.sqj.sIi)));
    ae.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bk.bG(aa.a(paramb.sqj.sIi))).commit();
    g.DQ();
    g.DP().Dz().o(8196, Long.valueOf(paramb.sqj.sFD));
    boolean bool;
    Object localObject;
    if (((paramb.sqj.sFD & selector) != 0) && (!super.Ky()))
    {
      bool = true;
      y.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramb.sqj.sFD), Integer.valueOf(selector), Boolean.valueOf(super.Ky()) });
      if ((!bool) && ((paramb.sqj.sFD & 0x100) != 0))
      {
        localObject = new qt();
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      }
      if ((!bool) && ((paramb.sqj.sFD & 0x200000) != 0))
      {
        localObject = new ln();
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      }
      localObject = com.tencent.mm.plugin.report.f.nEG;
      if (!bool) {
        break label389;
      }
    }
    label389:
    for (long l = 234L;; l = 235L)
    {
      ((com.tencent.mm.plugin.report.f)localObject).a(99L, l, 1L, false);
      y.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", new Object[] { Integer.valueOf(paramb.sqj.sFD), Boolean.valueOf(this.esp), Boolean.valueOf(bool), Boolean.valueOf(eta), Integer.valueOf(this.esl), Boolean.valueOf(this.etf), this.etc });
      if ((this.esp) || (!bool)) {
        break label397;
      }
      this.etf = true;
      a(this.edc, this.dmL);
      return;
      bool = false;
      break;
    }
    label397:
    int i;
    if (eta)
    {
      y.i(this.TAG, "dkpush new notify pending, sync now");
      if (etd != 0)
      {
        i = etd;
        g.DQ();
        g.DN();
        com.tencent.mm.booter.f.aV(i, com.tencent.mm.kernel.a.CK());
      }
      etd = 0;
      this.etc = null;
      eta = false;
      this.etf = true;
      a(this.edc, this.dmL);
      return;
    }
    if (this.etc != null)
    {
      i = etd;
      g.DQ();
      g.DN();
      com.tencent.mm.booter.f.aV(i, com.tencent.mm.kernel.a.CK());
      this.etc = null;
      Ph();
      a(this.edc, this.dmL);
      return;
    }
    if ((this.esl & 0x1) > 0)
    {
      g.DQ();
      paramb = bk.ZM(bk.pm((String)g.DP().Dz().get(8195, null)));
      g.Dk().a(new f(this.eso, paramb), 0);
    }
    y.d(this.TAG, "sync or init end: reset selector : now = " + selector + " default = 7");
    selector = 7;
    this.dmL.onSceneEnd(this.errType, this.errCode, this.aox, this);
  }
  
  protected final boolean a(m paramm)
  {
    boolean bool = true;
    if (!(paramm instanceof j)) {}
    do
    {
      return false;
      paramm = (j)paramm;
    } while ((paramm.etb) || (!eta));
    y.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", new Object[] { Long.valueOf(paramm.edd) });
    if (bk.cp(paramm.edd) > 360000L) {}
    while (bool)
    {
      y.i(this.TAG, "summerworker NetSceneSync timeout");
      paramm = g.DS().crf().findTaskByRunTime(0L);
      if (paramm == null) {
        break;
      }
      y.e(this.TAG, "summerworker worker is just blocked by task: " + ah.dump(paramm, false));
      return false;
      bool = false;
    }
    return bool;
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  protected final void cancel()
  {
    super.cancel();
    com.tencent.mm.plugin.report.f.nEG.a(99L, 229L, 1L, false);
    this.esC = true;
  }
  
  public final int getType()
  {
    return 138;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.j
 * JD-Core Version:    0.7.0.1
 */