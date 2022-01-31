package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.t.a;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.lang.reflect.Method;
import junit.framework.Assert;

public final class j
  extends m
  implements com.tencent.mm.network.k
{
  protected static int fHY = 7;
  private static boolean fIN = false;
  private static int fIQ = 0;
  public String TAG;
  private com.tencent.mm.ai.f callback;
  private g.a eMo;
  private int errCode;
  private String errMsg;
  private int errType;
  private int fHZ;
  public p fIM;
  private boolean fIO;
  private ap fIP;
  private int fIR;
  private boolean fIS;
  private String fIT;
  public t.b fIU;
  private long fIV;
  private long fIb;
  private boolean fIc;
  private boolean fIp;
  private ap frx;
  
  public j(int paramInt)
  {
    AppMethodBeat.i(58384);
    this.TAG = "MicroMsg.NetSceneSync";
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.fIM = null;
    this.fIO = false;
    this.fHZ = 0;
    this.frx = null;
    this.fIP = null;
    this.fIb = -1L;
    this.fIc = false;
    this.fIS = false;
    this.fIp = false;
    this.fIT = "";
    this.fIU = null;
    this.fIV = 0L;
    this.TAG = (this.TAG + "[" + hashCode() + "]");
    com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", new Object[] { Integer.valueOf(paramInt), bo.dtY() });
    this.fIT = an.dtg();
    this.eMo = new g.a();
    if (this.fIM == null) {
      this.fIM = new p();
    }
    this.fIM.fJS = paramInt;
    com.tencent.mm.kernel.g.RM();
    if ((com.tencent.mm.kernel.g.RL() != null) && (com.tencent.mm.kernel.g.RG()))
    {
      com.tencent.mm.kernel.g.RM();
      if ((com.tencent.mm.kernel.g.RL().Ru() != null) && (!com.tencent.mm.kernel.a.QP()))
      {
        com.tencent.mm.kernel.g.RM();
        long l = bo.a((Long)com.tencent.mm.kernel.g.RL().Ru().get(8196, null), 0L);
        if (l != 0L)
        {
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RL().Ru().set(8196, Long.valueOf(0L));
          int i = (int)(l | fHY);
          fHY = i;
          fHY = i & 0x5F;
        }
      }
    }
    if (paramInt == 1) {
      fIN = true;
    }
    if (paramInt == 1010)
    {
      fHY |= 0x10;
      fIN = true;
      this.fIR = 7;
    }
    for (;;)
    {
      if (fIQ == 0) {
        aij();
      }
      AppMethodBeat.o(58384);
      return;
      if (paramInt == 1011)
      {
        fHY |= 0x40;
        fIN = true;
        this.fIR = 7;
      }
      else if (paramInt == 3)
      {
        fHY |= 0x40000;
        fIN = true;
        this.fIR = 3;
        com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fHY), Integer.valueOf(this.fIR) });
      }
      else
      {
        this.fIR = paramInt;
      }
    }
  }
  
  public j(t.b paramb, int paramInt, long paramLong)
  {
    this(8);
    AppMethodBeat.i(58385);
    this.fIT = an.dtg();
    com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", new Object[] { Long.valueOf(paramb.getBufferSize()), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    this.fHZ = paramInt;
    this.fIb = paramLong;
    this.frx = new ap(com.tencent.mm.kernel.g.RO().oNc.getLooper(), new j.1(this, paramb), false);
    if (fIQ == 0) {
      aij();
    }
    AppMethodBeat.o(58385);
  }
  
  private boolean aij()
  {
    AppMethodBeat.i(58390);
    Object localObject2 = new PInt();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ();
    Object localObject1 = com.tencent.mm.booter.g.a((PInt)localObject2, com.tencent.mm.kernel.a.getUin());
    String str = this.TAG;
    int j = ((PInt)localObject2).value;
    int k = hashCode();
    if (localObject1 != null) {}
    for (int i = localObject1.length;; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ab.i(str, "dealWithRespData index:%d, hashcode:%d, buf.len:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      fIQ = ((PInt)localObject2).value;
      if ((((PInt)localObject2).value != 0) && (!bo.ce((byte[])localObject1))) {
        break;
      }
      fIQ = 0;
      AppMethodBeat.o(58390);
      return false;
    }
    localObject2 = new t.b();
    try
    {
      ((t.b)localObject2).fromProtoBuf((byte[])localObject1);
      localObject1 = new a((t.b)localObject2);
      this.fIP = new ap(com.tencent.mm.kernel.g.RO().oNc.getLooper(), new j.2(this, (a)localObject1), false);
      AppMethodBeat.o(58390);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(99L, 226L, 1L, false);
      com.tencent.mm.sdk.platformtools.ab.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
      i = fIQ;
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RJ();
      com.tencent.mm.booter.g.bT(i, com.tencent.mm.kernel.a.getUin());
      fIQ = 0;
      AppMethodBeat.o(58390);
      return false;
    }
    catch (Error localError)
    {
      long l1 = Runtime.getRuntime().freeMemory() / 1000L;
      long l2 = Runtime.getRuntime().totalMemory() / 1000L;
      com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
      Assert.assertTrue("dealWithRespData error", false);
      AppMethodBeat.o(58390);
    }
    return false;
  }
  
  private boolean aik()
  {
    AppMethodBeat.i(58393);
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)ah.getContext().getSystemService("power"), new Object[0])).booleanValue();
      AppMethodBeat.o(58393);
      return bool;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, bo.l(localException) });
      AppMethodBeat.o(58393);
    }
    return true;
  }
  
  protected final void a(t.b paramb)
  {
    AppMethodBeat.i(146143);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RL().Ru().set(8195, bo.cg(aa.a(paramb.wiN.wFR)));
    ah.getContext().getSharedPreferences("notify_sync_pref", h.Mp()).edit().putString("notify_sync_key_keybuf", bo.cg(aa.a(paramb.wiN.wFR))).commit();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RL().Ru().set(8196, Long.valueOf(paramb.wiN.wBX));
    boolean bool;
    Object localObject;
    if (((paramb.wiN.wBX & fHY) != 0) && (!super.securityLimitCountReach()))
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramb.wiN.wBX), Integer.valueOf(fHY), Boolean.valueOf(super.securityLimitCountReach()) });
      if ((!bool) && ((paramb.wiN.wBX & 0x100) != 0))
      {
        localObject = new sf();
        ((sf)localObject).cIz.cpG = 1;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if ((!bool) && ((paramb.wiN.wBX & 0x200000) != 0))
      {
        localObject = new mc();
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      }
      localObject = com.tencent.mm.plugin.report.e.qrI;
      if (!bool) {
        break label412;
      }
    }
    label412:
    for (long l = 234L;; l = 235L)
    {
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(99L, l, 1L, false);
      com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", new Object[] { Integer.valueOf(paramb.wiN.wBX), Boolean.valueOf(this.fIc), Boolean.valueOf(bool), Boolean.valueOf(fIN), Integer.valueOf(this.fHZ), Boolean.valueOf(this.fIS), this.fIP });
      if ((this.fIc) || (!bool)) {
        break label420;
      }
      this.fIS = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(146143);
      return;
      bool = false;
      break;
    }
    label420:
    int i;
    if (fIN)
    {
      com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "dkpush new notify pending, sync now");
      if (fIQ != 0)
      {
        i = fIQ;
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RJ();
        com.tencent.mm.booter.g.bT(i, com.tencent.mm.kernel.a.getUin());
      }
      fIQ = 0;
      this.fIP = null;
      fIN = false;
      this.fIS = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(146143);
      return;
    }
    if (this.fIP != null)
    {
      i = fIQ;
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RJ();
      com.tencent.mm.booter.g.bT(i, com.tencent.mm.kernel.a.getUin());
      this.fIP = null;
      aij();
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(146143);
      return;
    }
    if ((this.fHZ & 0x1) > 0)
    {
      com.tencent.mm.kernel.g.RM();
      paramb = bo.apQ(bo.nullAsNil((String)com.tencent.mm.kernel.g.RL().Ru().get(8195, null)));
      com.tencent.mm.kernel.g.Rc().a(new f(this.fIb, paramb), 0);
    }
    com.tencent.mm.sdk.platformtools.ab.d(this.TAG, "sync or init end: reset selector : now = " + fHY + " default = 7");
    fHY = 7;
    this.callback.onSceneEnd(this.errType, this.errCode, this.errMsg, this);
    AppMethodBeat.o(146143);
  }
  
  public final boolean accept(m paramm)
  {
    boolean bool = true;
    AppMethodBeat.i(58386);
    if (!(paramm instanceof j))
    {
      AppMethodBeat.o(58386);
      return false;
    }
    paramm = (j)paramm;
    if ((!paramm.fIO) && (fIN))
    {
      com.tencent.mm.sdk.platformtools.ab.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", new Object[] { Long.valueOf(paramm.lastdispatch) });
      if (bo.av(paramm.lastdispatch) > 360000L) {}
      while (bool)
      {
        com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "summerworker NetSceneSync timeout");
        paramm = com.tencent.mm.kernel.g.RO().caB().findTaskByRunTime(0L);
        if (paramm == null) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ab.e(this.TAG, "summerworker worker is just blocked by task: " + ak.dump(paramm, false));
        AppMethodBeat.o(58386);
        return false;
        bool = false;
      }
      AppMethodBeat.o(58386);
      return bool;
    }
    AppMethodBeat.o(58386);
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(58388);
    super.cancel();
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(99L, 229L, 1L, false);
    this.fIp = true;
    AppMethodBeat.o(58388);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(58389);
    if (k.ail())
    {
      fIQ = 0;
      com.tencent.mm.sdk.platformtools.ab.e(this.TAG, "dkinit never do sync before init done");
      AppMethodBeat.o(58389);
      return -1;
    }
    this.callback = paramf;
    if (this.fIM == null) {
      this.fIM = new p();
    }
    this.fIM.bSe = com.tencent.mm.sdk.a.b.foreground;
    if (this.fIP != null)
    {
      com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "pushSyncRespHandler not null");
      prepareDispatcher(parame);
      this.fIP.ag(0L, 0L);
      AppMethodBeat.o(58389);
      return 0;
    }
    if (fIQ > 0)
    {
      com.tencent.mm.sdk.platformtools.ab.w(this.TAG, "other sync is dealing with resp data :%d", new Object[] { Integer.valueOf(fIQ) });
      AppMethodBeat.o(58389);
      return -1;
    }
    if (this.frx != null)
    {
      com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "pusher not null");
      prepareDispatcher(parame);
      this.frx.ag(0L, 0L);
      AppMethodBeat.o(58389);
      return 0;
    }
    paramf = new a();
    bgi localbgi = ((t.a)paramf.getReqObj()).wiM;
    if (this.fIR == 3)
    {
      localbgi.xvG = 1;
      if (!this.fIS) {
        break label383;
      }
    }
    label383:
    for (int i = 6;; i = this.fIR)
    {
      this.fIR = i;
      localbgi.wFQ = fHY;
      com.tencent.mm.kernel.g.RM();
      byte[] arrayOfByte = bo.apQ(bo.nullAsNil((String)com.tencent.mm.kernel.g.RL().Ru().get(8195, new byte[0])));
      localbgi.wFR = aa.ac(arrayOfByte);
      localbgi.Scene = this.fIR;
      localbgi.xvF = new ue();
      localbgi.wsq = d.eQs;
      com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", new Object[] { Integer.valueOf(localbgi.wFQ), Integer.valueOf(localbgi.Scene), com.tencent.mm.protocal.ab.bS(arrayOfByte) });
      fIN = false;
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(58389);
      return i;
      localbgi.xvG = 0;
      break;
    }
  }
  
  public final int getType()
  {
    return 138;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58391);
    if ((paramq == null) || (paramq.getType() != 138))
    {
      paramString = this.TAG;
      if (paramq == null) {}
      for (paramInt1 = -2;; paramInt1 = paramq.getType())
      {
        com.tencent.mm.sdk.platformtools.ab.e(paramString, "onGYNetEnd error type:%d", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(58391);
        return;
      }
    }
    t.b localb = (t.b)paramq.getRespObj();
    paramArrayOfByte = this.TAG;
    long l = this.eMo.Mm();
    boolean bool = this.fIc;
    if (localb.wiN.wFU == null)
    {
      paramInt1 = -1;
      com.tencent.mm.sdk.platformtools.ab.i(paramArrayOfByte, "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(l), Boolean.valueOf(bool), Integer.valueOf(paramInt1), this.frx, this.fIP });
      if (localb.wiN.wFU != null) {
        break label381;
      }
      paramInt1 = -1;
      label205:
      if (paramInt1 <= 0) {
        break label396;
      }
      paramInt1 = 1;
      label211:
      if (aik()) {
        break label409;
      }
      paramArrayOfByte = com.tencent.mm.plugin.report.e.qrI;
      if (paramInt1 == 0) {
        break label401;
      }
      l = 221L;
      label232:
      paramArrayOfByte.idkeyStat(99L, l, 1L, false);
      this.frx = null;
      this.fIO = true;
      if ((paramInt2 != 4) || (paramInt3 != -2006)) {
        break label863;
      }
      bool = true;
      paramInt2 = 0;
      paramInt3 = 0;
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(99L, 227L, 1L, false);
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        if (this.fIU != null)
        {
          com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
          this.errType = paramInt2;
          this.errCode = paramInt3;
          this.errMsg = paramString;
          ((t.b)paramq.getRespObj()).wiN.wBX = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(99L, 232L, 1L, false);
          AppMethodBeat.o(58391);
          return;
          paramInt1 = localb.wiN.wFU.jJu;
          break;
          label381:
          paramInt1 = localb.wiN.wFU.jJu;
          break label205;
          label396:
          paramInt1 = 0;
          break label211;
          label401:
          l = 218L;
          break label232;
          label409:
          if (!com.tencent.mm.sdk.a.b.foreground)
          {
            paramArrayOfByte = com.tencent.mm.plugin.report.e.qrI;
            if (paramInt1 != 0) {}
            for (l = 220L;; l = 217L)
            {
              paramArrayOfByte.idkeyStat(99L, l, 1L, false);
              break;
            }
          }
          paramArrayOfByte = com.tencent.mm.plugin.report.e.qrI;
          if (paramInt1 != 0) {}
          for (l = 219L;; l = 216L)
          {
            paramArrayOfByte.idkeyStat(99L, l, 1L, false);
            break;
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
      }
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(99L, 233L, 1L, false);
      paramArrayOfByte = aa.a(((t.a)paramq.getReqObj()).wiM.wFR);
      paramq = aa.a(localb.wiN.wFR);
      com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "onGYNetEnd replace key:%b req :%s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.protocal.ab.bS(paramArrayOfByte) });
      com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.protocal.ab.bS(paramq) });
      if (!bool)
      {
        paramString = paramArrayOfByte;
        if (bo.ce(paramArrayOfByte))
        {
          com.tencent.mm.kernel.g.RM();
          paramString = bo.apQ(bo.nullAsNil((String)com.tencent.mm.kernel.g.RL().Ru().get(8195, new byte[0])));
          com.tencent.mm.sdk.platformtools.ab.d(this.TAG, "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramString.length), bo.cd(paramString) });
        }
        paramArrayOfByte = com.tencent.mm.protocal.ab.j(paramString, paramq);
        if (paramArrayOfByte != null)
        {
          paramString = paramArrayOfByte;
          if (paramArrayOfByte.length > 0) {}
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ab.w(this.TAG, "merge key failed, use server side instead");
          paramString = paramq;
        }
        localb.wiN.wFR = aa.ac(paramString);
      }
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RJ().ci(localb.wiN.jJS, localb.wiN.xvH);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RJ();
      com.tencent.mm.kernel.a.jL(localb.wiN.jJS);
      if (this.fIU == null) {}
      for (bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.fIU = localb;
        this.fIV = bo.aoy();
        new ap(com.tencent.mm.kernel.g.RO().oNc.getLooper(), new j.3(this), true).ag(50L, 50L);
        AppMethodBeat.o(58391);
        return;
      }
      label863:
      bool = false;
    }
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final boolean securityLimitCountReach()
  {
    int i = 1;
    AppMethodBeat.i(58387);
    boolean bool = super.securityLimitCountReach();
    com.tencent.mm.plugin.report.e locale;
    if (bool)
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(99L, 228L, 1L, false);
      locale = com.tencent.mm.plugin.report.e.qrI;
      if (!com.tencent.mm.sdk.a.b.foreground) {
        break label126;
      }
    }
    for (;;)
    {
      locale.e(12063, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), "9999" });
      AppMethodBeat.o(58387);
      return bool;
      label126:
      i = 2;
    }
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends com.tencent.mm.ai.k
  {
    private final t.a fIf;
    private final t.b fIg;
    private final boolean fIh;
    
    public a()
    {
      AppMethodBeat.i(58382);
      this.fIf = new t.a();
      this.fIg = new t.b();
      this.fIh = false;
      AppMethodBeat.o(58382);
    }
    
    public a(t.b paramb)
    {
      AppMethodBeat.i(58383);
      this.fIf = new t.a();
      this.fIg = paramb;
      this.fIh = true;
      AppMethodBeat.o(58383);
    }
    
    public final boolean getPush()
    {
      return this.fIh;
    }
    
    public final l.d getReqObjImp()
    {
      return this.fIf;
    }
    
    public final l.e getRespObj()
    {
      return this.fIg;
    }
    
    public final int getType()
    {
      return 138;
    }
    
    public final String getUri()
    {
      return "/cgi-bin/micromsg-bin/newsync";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.j
 * JD-Core Version:    0.7.0.1
 */