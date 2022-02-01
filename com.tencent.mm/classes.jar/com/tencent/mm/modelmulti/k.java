package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.a.he;
import com.tencent.mm.g.a.no;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.lang.reflect.Method;
import java.util.LinkedList;
import junit.framework.Assert;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  protected static int hkT = 7;
  private static boolean hlQ = false;
  private static int hlT = 0;
  public String TAG;
  private com.tencent.mm.al.g callback;
  private int errCode;
  private String errMsg;
  private int errType;
  private av gTs;
  private f.a ghu;
  private int hkU;
  private long hkW;
  private boolean hkX;
  public q hlP;
  private boolean hlR;
  private av hlS;
  private int hlU;
  private boolean hlV;
  private String hlW;
  public v.b hlX;
  private long hlY;
  private boolean hls;
  
  public k(int paramInt)
  {
    AppMethodBeat.i(132574);
    this.TAG = "MicroMsg.NetSceneSync";
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.hlP = null;
    this.hlR = false;
    this.hkU = 0;
    this.gTs = null;
    this.hlS = null;
    this.hkW = -1L;
    this.hkX = false;
    this.hlV = false;
    this.hls = false;
    this.hlW = "";
    this.hlX = null;
    this.hlY = 0L;
    this.TAG = (this.TAG + "[" + hashCode() + "]");
    com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", new Object[] { Integer.valueOf(paramInt), bt.eGN() });
    this.hlW = at.eFT();
    this.ghu = new f.a();
    if (this.hlP == null) {
      this.hlP = new q();
    }
    this.hlP.hmV = paramInt;
    com.tencent.mm.kernel.g.afC();
    if ((com.tencent.mm.kernel.g.afB() != null) && (com.tencent.mm.kernel.g.afw()))
    {
      com.tencent.mm.kernel.g.afC();
      if ((com.tencent.mm.kernel.g.afB().afk() != null) && (!com.tencent.mm.kernel.a.aeC()))
      {
        com.tencent.mm.kernel.g.afC();
        long l = bt.a((Long)com.tencent.mm.kernel.g.afB().afk().get(8196, null), 0L);
        if (l != 0L)
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(8196, Long.valueOf(0L));
          int i = (int)(l | hkT);
          hkT = i;
          hkT = i & 0x5F;
        }
      }
    }
    if (paramInt == 1) {
      hlQ = true;
    }
    if (paramInt == 1010)
    {
      hkT |= 0x10;
      hlQ = true;
      this.hlU = 7;
    }
    for (;;)
    {
      if (hlT == 0) {
        azq();
      }
      AppMethodBeat.o(132574);
      return;
      if (paramInt == 1011)
      {
        hkT |= 0x40;
        hlQ = true;
        this.hlU = 7;
      }
      else if (paramInt == 3)
      {
        hkT |= 0x40000;
        hlQ = true;
        this.hlU = 3;
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hkT), Integer.valueOf(this.hlU) });
      }
      else
      {
        this.hlU = paramInt;
      }
    }
  }
  
  public k(final v.b paramb, int paramInt, long paramLong)
  {
    this(8);
    AppMethodBeat.i(132575);
    this.hlW = at.eFT();
    com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", new Object[] { Long.valueOf(paramb.getBufferSize()), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    this.hkU = paramInt;
    this.hkW = paramLong;
    this.gTs = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132569);
        k.a(k.this);
        k.a locala = new k.a(paramb);
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 230L, 1L, false);
        k.this.onGYNetEnd(-1, 0, 0, "", locala, null);
        AppMethodBeat.o(132569);
        return false;
      }
    }, false);
    if (hlT == 0) {
      azq();
    }
    AppMethodBeat.o(132575);
  }
  
  private boolean azq()
  {
    AppMethodBeat.i(132580);
    Object localObject2 = new PInt();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz();
    Object localObject1 = com.tencent.mm.booter.g.a((PInt)localObject2, com.tencent.mm.kernel.a.getUin());
    String str = this.TAG;
    int j = ((PInt)localObject2).value;
    int k = hashCode();
    if (localObject1 != null) {}
    for (int i = localObject1.length;; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i(str, "dealWithRespData index:%d, hashcode:%d, buf.len:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      hlT = ((PInt)localObject2).value;
      if ((((PInt)localObject2).value != 0) && (!bt.cw((byte[])localObject1))) {
        break;
      }
      hlT = 0;
      AppMethodBeat.o(132580);
      return false;
    }
    localObject2 = new v.b();
    try
    {
      ((v.b)localObject2).fromProtoBuf((byte[])localObject1);
      localObject1 = new a((v.b)localObject2);
      this.hlS = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(132570);
          k.a(k.this);
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 231L, 1L, false);
          k.this.onGYNetEnd(-1, 0, 0, "", this.hma, null);
          AppMethodBeat.o(132570);
          return false;
        }
      }, false);
      AppMethodBeat.o(132580);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 226L, 1L, false);
      com.tencent.mm.sdk.platformtools.ad.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
      i = hlT;
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
      hlT = 0;
      AppMethodBeat.o(132580);
      return false;
    }
    catch (Error localError)
    {
      long l1 = Runtime.getRuntime().freeMemory() / 1000L;
      long l2 = Runtime.getRuntime().totalMemory() / 1000L;
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
      Assert.assertTrue("dealWithRespData error", false);
      AppMethodBeat.o(132580);
    }
    return false;
  }
  
  private boolean azr()
  {
    AppMethodBeat.i(132583);
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)aj.getContext().getSystemService("power"), new Object[0])).booleanValue();
      AppMethodBeat.o(132583);
      return bool;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, bt.m(localException) });
      AppMethodBeat.o(132583);
    }
    return true;
  }
  
  protected final void a(v.b paramb)
  {
    AppMethodBeat.i(132582);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(8195, bt.cy(z.a(paramb.CqZ.CRx)));
    aj.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.XN()).edit().putString("notify_sync_key_keybuf", bt.cy(z.a(paramb.CqZ.CRx))).commit();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(8196, Long.valueOf(paramb.CqZ.CNq));
    boolean bool;
    Object localObject;
    if (((paramb.CqZ.CNq & hkT) != 0) && (!super.securityLimitCountReach()))
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramb.CqZ.CNq), Integer.valueOf(hkT), Boolean.valueOf(super.securityLimitCountReach()) });
      if ((!bool) && ((paramb.CqZ.CNq & 0x100) != 0))
      {
        localObject = new tz();
        ((tz)localObject).dzp.sourceType = 1;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if ((!bool) && ((paramb.CqZ.CNq & 0x200000) != 0))
      {
        localObject = new no();
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if ((!bool) && ((paramb.CqZ.CNq & 0x1000000) != 0))
      {
        localObject = new he();
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      localObject = com.tencent.mm.plugin.report.e.vIY;
      if (!bool) {
        break label448;
      }
    }
    label448:
    for (long l = 234L;; l = 235L)
    {
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(99L, l, 1L, false);
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", new Object[] { Integer.valueOf(paramb.CqZ.CNq), Boolean.valueOf(this.hkX), Boolean.valueOf(bool), Boolean.valueOf(hlQ), Integer.valueOf(this.hkU), Boolean.valueOf(this.hlV), this.hlS });
      if ((this.hkX) || (!bool)) {
        break label456;
      }
      this.hlV = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
      bool = false;
      break;
    }
    label456:
    int i;
    if (hlQ)
    {
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "dkpush new notify pending, sync now");
      if (hlT != 0)
      {
        i = hlT;
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afz();
        com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
      }
      hlT = 0;
      this.hlS = null;
      hlQ = false;
      this.hlV = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
    }
    if (this.hlS != null)
    {
      i = hlT;
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
      this.hlS = null;
      azq();
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
    }
    if ((this.hkU & 0x1) > 0)
    {
      com.tencent.mm.kernel.g.afC();
      paramb = bt.aGd(bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(8195, null)));
      com.tencent.mm.kernel.g.aeS().a(new g(this.hkW, paramb), 0);
    }
    com.tencent.mm.sdk.platformtools.ad.d(this.TAG, "sync or init end: reset selector : now = " + hkT + " default = 7");
    hkT = 7;
    this.callback.onSceneEnd(this.errType, this.errCode, this.errMsg, this);
    AppMethodBeat.o(132582);
  }
  
  public final boolean accept(n paramn)
  {
    Object localObject = null;
    boolean bool = true;
    AppMethodBeat.i(132576);
    if (!(paramn instanceof k))
    {
      AppMethodBeat.o(132576);
      return false;
    }
    paramn = (k)paramn;
    if ((!paramn.hlR) && (hlQ))
    {
      com.tencent.mm.sdk.platformtools.ad.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", new Object[] { Long.valueOf(paramn.lastdispatch) });
      label111:
      String str;
      StringBuilder localStringBuilder;
      if (bt.aS(paramn.lastdispatch) > 360000L)
      {
        if (!bool) {
          break label192;
        }
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "summerworker NetSceneSync timeout");
        paramn = com.tencent.mm.kernel.g.afE().cBt().getRunningMessage();
        if (paramn != null) {
          break label176;
        }
        paramn = null;
        if (paramn == null) {
          break label192;
        }
        str = this.TAG;
        localStringBuilder = new StringBuilder("summerworker worker is just blocked by task: ");
        paramn = com.tencent.mm.kernel.g.afE().cBt().getRunningMessage();
        if (paramn != null) {
          break label184;
        }
      }
      label176:
      label184:
      for (paramn = localObject;; paramn = paramn.toString())
      {
        com.tencent.mm.sdk.platformtools.ad.e(str, paramn);
        AppMethodBeat.o(132576);
        return false;
        bool = false;
        break;
        paramn = paramn.getCallback();
        break label111;
      }
      label192:
      AppMethodBeat.o(132576);
      return bool;
    }
    AppMethodBeat.o(132576);
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(132578);
    super.cancel();
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 229L, 1L, false);
    this.hls = true;
    AppMethodBeat.o(132578);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(132579);
    if (l.azs())
    {
      hlT = 0;
      com.tencent.mm.sdk.platformtools.ad.e(this.TAG, "dkinit never do sync before init done");
      AppMethodBeat.o(132579);
      return -1;
    }
    this.callback = paramg;
    if (this.hlP == null) {
      this.hlP = new q();
    }
    this.hlP.ctF = com.tencent.mm.sdk.a.b.foreground;
    if (this.hlS != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "pushSyncRespHandler not null");
      prepareDispatcher(parame);
      this.hlS.av(0L, 0L);
      AppMethodBeat.o(132579);
      return 0;
    }
    if (hlT > 0)
    {
      com.tencent.mm.sdk.platformtools.ad.w(this.TAG, "other sync is dealing with resp data :%d", new Object[] { Integer.valueOf(hlT) });
      AppMethodBeat.o(132579);
      return -1;
    }
    if (this.gTs != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "pusher not null");
      prepareDispatcher(parame);
      this.gTs.av(0L, 0L);
      AppMethodBeat.o(132579);
      return 0;
    }
    paramg = new a();
    btj localbtj = ((v.a)paramg.getReqObj()).CqY;
    if (this.hlU == 3)
    {
      localbtj.DQT = 1;
      if (!this.hlV) {
        break label383;
      }
    }
    label383:
    for (int i = 6;; i = this.hlU)
    {
      this.hlU = i;
      localbtj.CRw = hkT;
      com.tencent.mm.kernel.g.afC();
      byte[] arrayOfByte = bt.aGd(bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(8195, new byte[0])));
      localbtj.CRx = z.am(arrayOfByte);
      localbtj.Scene = this.hlU;
      localbtj.DQS = new xe();
      localbtj.CBS = d.glX;
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", new Object[] { Integer.valueOf(localbtj.CRw), Integer.valueOf(localbtj.Scene), com.tencent.mm.protocal.ad.ck(arrayOfByte) });
      hlQ = false;
      i = dispatch(parame, paramg, this);
      AppMethodBeat.o(132579);
      return i;
      localbtj.DQT = 0;
      break;
    }
  }
  
  public final int getType()
  {
    return 138;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132581);
    if ((paramq == null) || (paramq.getType() != 138))
    {
      paramString = this.TAG;
      if (paramq == null) {}
      for (paramInt1 = -2;; paramInt1 = paramq.getType())
      {
        com.tencent.mm.sdk.platformtools.ad.e(paramString, "onGYNetEnd error type:%d", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(132581);
        return;
      }
    }
    v.b localb = (v.b)paramq.getRespObj();
    paramArrayOfByte = this.TAG;
    long l = this.ghu.XK();
    boolean bool = this.hkX;
    if (localb.CqZ.CRA == null)
    {
      paramInt1 = -1;
      com.tencent.mm.sdk.platformtools.ad.i(paramArrayOfByte, "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(l), Boolean.valueOf(bool), Integer.valueOf(paramInt1), this.gTs, this.hlS });
      if (localb.CqZ.CRA != null) {
        break label381;
      }
      paramInt1 = -1;
      label205:
      if (paramInt1 <= 0) {
        break label396;
      }
      paramInt1 = 1;
      label211:
      if (azr()) {
        break label409;
      }
      paramArrayOfByte = com.tencent.mm.plugin.report.e.vIY;
      if (paramInt1 == 0) {
        break label401;
      }
      l = 221L;
      label232:
      paramArrayOfByte.idkeyStat(99L, l, 1L, false);
      this.gTs = null;
      this.hlR = true;
      if ((paramInt2 != 4) || (paramInt3 != -2006)) {
        break label863;
      }
      bool = true;
      paramInt2 = 0;
      paramInt3 = 0;
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 227L, 1L, false);
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        if (this.hlX != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
          this.errType = paramInt2;
          this.errCode = paramInt3;
          this.errMsg = paramString;
          ((v.b)paramq.getRespObj()).CqZ.CNq = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 232L, 1L, false);
          AppMethodBeat.o(132581);
          return;
          paramInt1 = localb.CqZ.CRA.mAK;
          break;
          label381:
          paramInt1 = localb.CqZ.CRA.mAK;
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
            paramArrayOfByte = com.tencent.mm.plugin.report.e.vIY;
            if (paramInt1 != 0) {}
            for (l = 220L;; l = 217L)
            {
              paramArrayOfByte.idkeyStat(99L, l, 1L, false);
              break;
            }
          }
          paramArrayOfByte = com.tencent.mm.plugin.report.e.vIY;
          if (paramInt1 != 0) {}
          for (l = 219L;; l = 216L)
          {
            paramArrayOfByte.idkeyStat(99L, l, 1L, false);
            break;
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
      }
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 233L, 1L, false);
      paramArrayOfByte = z.a(((v.a)paramq.getReqObj()).CqY.CRx);
      paramq = z.a(localb.CqZ.CRx);
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "onGYNetEnd replace key:%b req :%s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.protocal.ad.ck(paramArrayOfByte) });
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.protocal.ad.ck(paramq) });
      if (!bool)
      {
        paramString = paramArrayOfByte;
        if (bt.cw(paramArrayOfByte))
        {
          com.tencent.mm.kernel.g.afC();
          paramString = bt.aGd(bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(8195, new byte[0])));
          com.tencent.mm.sdk.platformtools.ad.d(this.TAG, "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramString.length), bt.cv(paramString) });
        }
        paramArrayOfByte = com.tencent.mm.protocal.ad.k(paramString, paramq);
        if (paramArrayOfByte != null)
        {
          paramString = paramArrayOfByte;
          if (paramArrayOfByte.length > 0) {}
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ad.w(this.TAG, "merge key failed, use server side instead");
          paramString = paramq;
        }
        localb.CqZ.CRx = z.am(paramString);
      }
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afz().cO(localb.CqZ.mBi, localb.CqZ.DQU);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.kernel.a.mo(localb.CqZ.mBi);
      if (this.hlX == null) {}
      for (bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.hlX = localb;
        this.hlY = bt.eGO();
        new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new av.a()
        {
          private int hmb = 0;
          private long hmc = 0L;
          private int hmd = 0;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(132571);
            Object localObject2 = new c();
            if (!com.tencent.mm.kernel.g.afw())
            {
              com.tencent.mm.sdk.platformtools.ad.e(k.b(k.this), "syncRespHandler acc is not ready STOP :%s", new Object[] { k.c(k.this) });
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            if (k.e(k.this))
            {
              ((c)localObject2).dp(k.this);
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            if ((k.c(k.this) == null) || (k.c(k.this).CqZ.CRA == null) || (k.c(k.this).CqZ.CRA.mAL == null))
            {
              com.tencent.mm.sdk.platformtools.ad.e(k.b(k.this), "syncRespHandler CmdList is null! Stop Processing :%s", new Object[] { k.c(k.this) });
              ((c)localObject2).dp(k.this);
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            Object localObject1 = k.c(k.this).CqZ.CRA.mAL;
            ((c)localObject2).dn(k.this);
            this.hmd += 1;
            long l1 = bt.eGO();
            int i = 0;
            while (i < 5)
            {
              if (this.hmb < ((LinkedList)localObject1).size())
              {
                com.tencent.mm.sdk.platformtools.ad.v(k.b(k.this), "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.hmb), Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((xd)((LinkedList)localObject1).get(this.hmb)).CYY), Integer.valueOf(((xd)((LinkedList)localObject1).get(this.hmb)).CYZ.getILen()) });
                ((LinkedList)localObject1).size();
                if (!((c)localObject2).a((xd)((LinkedList)localObject1).get(this.hmb), false)) {
                  com.tencent.mm.sdk.platformtools.ad.w(k.b(k.this), "DoCmd Failed index:%d", new Object[] { Integer.valueOf(this.hmb) });
                }
                this.hmb += 1;
              }
              if (this.hmb >= ((LinkedList)localObject1).size())
              {
                this.hmc += bt.vM(l1);
                l2 = bt.vM(k.f(k.this));
                com.tencent.mm.sdk.platformtools.ad.i(k.b(k.this), "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", new Object[] { Integer.valueOf(this.hmb), Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(l2), Long.valueOf(this.hmc), Integer.valueOf(this.hmd), k.c(k.this) });
                k.this.a(k.c(k.this));
                ((c)localObject2).jdMethod_do(k.this);
                i = bt.l((Integer)com.tencent.mm.plugin.report.e.a((int)this.hmc, new int[] { 100, 300, 1000, 3000 }, new Integer[] { Integer.valueOf(240), Integer.valueOf(239), Integer.valueOf(238), Integer.valueOf(237), Integer.valueOf(236) }));
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, i, 1L, false);
                i = bt.l((Integer)com.tencent.mm.plugin.report.e.a(((LinkedList)localObject1).size(), new int[] { 0, 1, 2, 3, 5, 10 }, new Integer[] { Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(247), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243) }));
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, i, 1L, false);
                localObject2 = com.tencent.mm.plugin.report.e.vIY;
                int j;
                int k;
                int m;
                int n;
                if (com.tencent.mm.sdk.a.b.foreground)
                {
                  l1 = 241L;
                  ((com.tencent.mm.plugin.report.e)localObject2).idkeyStat(99L, l1, 1L, false);
                  com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, k.g(k.this), 1L, false);
                  com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 0L, 1L, false);
                  localObject2 = com.tencent.mm.plugin.report.e.vIY;
                  j = ((LinkedList)localObject1).size();
                  k = k.g(k.this);
                  m = k.c(k.this).CqZ.CNq;
                  l1 = this.hmc;
                  n = this.hmd;
                  localObject1 = k.h(k.this);
                  if (!com.tencent.mm.sdk.a.b.foreground) {
                    break label987;
                  }
                }
                label987:
                for (i = 1;; i = 2)
                {
                  ((com.tencent.mm.plugin.report.e)localObject2).f(12063, new Object[] { Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Integer.valueOf(n), localObject1, Integer.valueOf(i) });
                  k.d(k.this);
                  AppMethodBeat.o(132571);
                  return false;
                  l1 = 242L;
                  break;
                }
              }
              long l2 = bt.vM(l1);
              if (l2 > 500L)
              {
                com.tencent.mm.sdk.platformtools.ad.d(k.b(k.this), "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(this.hmb), k.c(k.this) });
                this.hmc += bt.vM(l1);
                AppMethodBeat.o(132571);
                return true;
              }
              i += 1;
            }
            this.hmc += bt.vM(l1);
            AppMethodBeat.o(132571);
            return true;
          }
        }, true).av(50L, 50L);
        AppMethodBeat.o(132581);
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
    AppMethodBeat.i(132577);
    boolean bool = super.securityLimitCountReach();
    com.tencent.mm.plugin.report.e locale;
    if (bool)
    {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(99L, 228L, 1L, false);
      locale = com.tencent.mm.plugin.report.e.vIY;
      if (!com.tencent.mm.sdk.a.b.foreground) {
        break label126;
      }
    }
    for (;;)
    {
      locale.f(12063, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), "9999" });
      AppMethodBeat.o(132577);
      return bool;
      label126:
      i = 2;
    }
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.gVB;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends com.tencent.mm.al.l
  {
    private final v.a hla;
    private final v.b hlb;
    private final boolean hlc;
    
    public a()
    {
      AppMethodBeat.i(132572);
      this.hla = new v.a();
      this.hlb = new v.b();
      this.hlc = false;
      AppMethodBeat.o(132572);
    }
    
    public a(v.b paramb)
    {
      AppMethodBeat.i(132573);
      this.hla = new v.a();
      this.hlb = paramb;
      this.hlc = true;
      AppMethodBeat.o(132573);
    }
    
    public final boolean getPush()
    {
      return this.hlc;
    }
    
    public final l.d getReqObjImp()
    {
      return this.hla;
    }
    
    public final l.e getRespObj()
    {
      return this.hlb;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.k
 * JD-Core Version:    0.7.0.1
 */