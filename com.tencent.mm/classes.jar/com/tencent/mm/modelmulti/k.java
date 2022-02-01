package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.of;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ccr;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.lang.reflect.Method;
import java.util.LinkedList;
import junit.framework.Assert;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  protected static int duf = 7;
  private static boolean ifn = false;
  private static int ifq = 0;
  public String TAG;
  private f callback;
  private int errCode;
  private String errMsg;
  private int errType;
  private f.a gFK;
  private av hMj;
  private boolean ieP;
  private int ier;
  private long iet;
  private boolean ieu;
  public r ifm;
  private boolean ifo;
  private av ifp;
  private int ifr;
  private boolean ifs;
  private String ift;
  public v.b ifu;
  private long ifv;
  
  public k(int paramInt)
  {
    AppMethodBeat.i(132574);
    this.TAG = "MicroMsg.NetSceneSync";
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.ifm = null;
    this.ifo = false;
    this.ier = 0;
    this.hMj = null;
    this.ifp = null;
    this.iet = -1L;
    this.ieu = false;
    this.ifs = false;
    this.ieP = false;
    this.ift = "";
    this.ifu = null;
    this.ifv = 0L;
    this.TAG = (this.TAG + "[" + hashCode() + "]");
    com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", new Object[] { Integer.valueOf(paramInt), bt.flS() });
    this.ift = at.fkV();
    this.gFK = new f.a();
    if (this.ifm == null) {
      this.ifm = new r();
    }
    this.ifm.igM = paramInt;
    com.tencent.mm.kernel.g.ajD();
    if ((com.tencent.mm.kernel.g.ajC() != null) && (com.tencent.mm.kernel.g.ajx()))
    {
      com.tencent.mm.kernel.g.ajD();
      if ((com.tencent.mm.kernel.g.ajC().ajl() != null) && (!com.tencent.mm.kernel.a.aiE()))
      {
        com.tencent.mm.kernel.g.ajD();
        long l = bt.a((Long)com.tencent.mm.kernel.g.ajC().ajl().get(8196, null), 0L);
        if (l != 0L)
        {
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(8196, Long.valueOf(0L));
          int i = (int)(l | duf);
          duf = i;
          duf = i & 0x5F;
        }
      }
    }
    if (paramInt == 1) {
      ifn = true;
    }
    if (paramInt == 1010)
    {
      duf |= 0x10;
      ifn = true;
      this.ifr = 7;
    }
    for (;;)
    {
      if (ifq == 0) {
        aJq();
      }
      AppMethodBeat.o(132574);
      return;
      if (paramInt == 1011)
      {
        duf |= 0x40;
        ifn = true;
        this.ifr = 7;
      }
      else if (paramInt == 3)
      {
        duf |= 0x40000;
        ifn = true;
        this.ifr = 3;
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(duf), Integer.valueOf(this.ifr) });
      }
      else
      {
        this.ifr = paramInt;
      }
    }
  }
  
  public k(final v.b paramb, int paramInt, long paramLong)
  {
    this(8);
    AppMethodBeat.i(132575);
    this.ift = at.fkV();
    com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", new Object[] { Long.valueOf(paramb.getBufferSize()), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    this.ier = paramInt;
    this.iet = paramLong;
    this.hMj = new av(com.tencent.mm.kernel.g.ajF().IdO.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132569);
        k.a(k.this);
        k.a locala = new k.a(paramb);
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 230L, 1L, false);
        k.this.onGYNetEnd(-1, 0, 0, "", locala, null);
        AppMethodBeat.o(132569);
        return false;
      }
    }, false);
    if (ifq == 0) {
      aJq();
    }
    AppMethodBeat.o(132575);
  }
  
  private boolean aJq()
  {
    AppMethodBeat.i(132580);
    Object localObject2 = new PInt();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA();
    Object localObject1 = com.tencent.mm.booter.g.a((PInt)localObject2, com.tencent.mm.kernel.a.getUin());
    String str = this.TAG;
    int j = ((PInt)localObject2).value;
    int k = hashCode();
    if (localObject1 != null) {}
    for (int i = localObject1.length;; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i(str, "dealWithRespData index:%d, hashcode:%d, buf.len:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      ifq = ((PInt)localObject2).value;
      if ((((PInt)localObject2).value != 0) && (!bt.cC((byte[])localObject1))) {
        break;
      }
      ifq = 0;
      AppMethodBeat.o(132580);
      return false;
    }
    localObject2 = new v.b();
    try
    {
      ((v.b)localObject2).fromProtoBuf((byte[])localObject1);
      localObject1 = new a((v.b)localObject2);
      this.ifp = new av(com.tencent.mm.kernel.g.ajF().IdO.getLooper(), new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(132570);
          k.a(k.this);
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 231L, 1L, false);
          k.this.onGYNetEnd(-1, 0, 0, "", this.ifx, null);
          AppMethodBeat.o(132570);
          return false;
        }
      }, false);
      AppMethodBeat.o(132580);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 226L, 1L, false);
      com.tencent.mm.sdk.platformtools.ad.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
      i = ifq;
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
      ifq = 0;
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
  
  private boolean aJr()
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
      com.tencent.mm.sdk.platformtools.ad.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, bt.n(localException) });
      AppMethodBeat.o(132583);
    }
    return true;
  }
  
  protected final void a(v.b paramb)
  {
    AppMethodBeat.i(132582);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(8195, bt.cE(z.a(paramb.Foy.FRr)));
    aj.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.abm()).edit().putString("notify_sync_key_keybuf", bt.cE(z.a(paramb.Foy.FRr))).commit();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(8196, Long.valueOf(paramb.Foy.FMr));
    boolean bool;
    Object localObject;
    if (((paramb.Foy.FMr & duf) != 0) && (!super.securityLimitCountReach()))
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramb.Foy.FMr), Integer.valueOf(duf), Boolean.valueOf(super.securityLimitCountReach()) });
      if ((!bool) && ((paramb.Foy.FMr & 0x100) != 0))
      {
        localObject = new vc();
        ((vc)localObject).dJn.sourceType = 1;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if ((!bool) && ((paramb.Foy.FMr & 0x200000) != 0))
      {
        localObject = new of();
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if ((!bool) && ((paramb.Foy.FMr & 0x1000000) != 0))
      {
        localObject = new hp();
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if ((!bool) && ((paramb.Foy.FMr & 0x20) != 0))
      {
        localObject = new ar();
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      localObject = com.tencent.mm.plugin.report.e.ygI;
      if (!bool) {
        break label483;
      }
    }
    label483:
    for (long l = 234L;; l = 235L)
    {
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(99L, l, 1L, false);
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", new Object[] { Integer.valueOf(paramb.Foy.FMr), Boolean.valueOf(this.ieu), Boolean.valueOf(bool), Boolean.valueOf(ifn), Integer.valueOf(this.ier), Boolean.valueOf(this.ifs), this.ifp });
      if ((this.ieu) || (!bool)) {
        break label491;
      }
      this.ifs = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
      bool = false;
      break;
    }
    label491:
    int i;
    if (ifn)
    {
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "dkpush new notify pending, sync now");
      if (ifq != 0)
      {
        i = ifq;
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajA();
        com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
      }
      ifq = 0;
      this.ifp = null;
      ifn = false;
      this.ifs = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
    }
    if (this.ifp != null)
    {
      i = ifq;
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
      this.ifp = null;
      aJq();
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
    }
    if ((this.ier & 0x1) > 0)
    {
      com.tencent.mm.kernel.g.ajD();
      paramb = bt.aRa(bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(8195, null)));
      com.tencent.mm.kernel.g.aiU().a(new g(this.iet, paramb), 0);
    }
    com.tencent.mm.sdk.platformtools.ad.d(this.TAG, "sync or init end: reset selector : now = " + duf + " default = 7");
    duf = 7;
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
    if ((!paramn.ifo) && (ifn))
    {
      com.tencent.mm.sdk.platformtools.ad.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", new Object[] { Long.valueOf(paramn.lastdispatch) });
      label111:
      String str;
      StringBuilder localStringBuilder;
      if (bt.aO(paramn.lastdispatch) > 360000L)
      {
        if (!bool) {
          break label192;
        }
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "summerworker NetSceneSync timeout");
        paramn = com.tencent.mm.kernel.g.ajF().cWY().getRunningMessage();
        if (paramn != null) {
          break label176;
        }
        paramn = null;
        if (paramn == null) {
          break label192;
        }
        str = this.TAG;
        localStringBuilder = new StringBuilder("summerworker worker is just blocked by task: ");
        paramn = com.tencent.mm.kernel.g.ajF().cWY().getRunningMessage();
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
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 229L, 1L, false);
    this.ieP = true;
    AppMethodBeat.o(132578);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(132579);
    if (l.aJs())
    {
      ifq = 0;
      com.tencent.mm.sdk.platformtools.ad.e(this.TAG, "dkinit never do sync before init done");
      AppMethodBeat.o(132579);
      return -1;
    }
    this.callback = paramf;
    if (this.ifm == null) {
      this.ifm = new r();
    }
    this.ifm.cBJ = com.tencent.mm.sdk.a.b.foreground;
    if (this.ifp != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "pushSyncRespHandler not null");
      prepareDispatcher(parame);
      this.ifp.az(0L, 0L);
      AppMethodBeat.o(132579);
      return 0;
    }
    if (ifq > 0)
    {
      com.tencent.mm.sdk.platformtools.ad.w(this.TAG, "other sync is dealing with resp data :%d", new Object[] { Integer.valueOf(ifq) });
      AppMethodBeat.o(132579);
      return -1;
    }
    if (this.hMj != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "pusher not null");
      prepareDispatcher(parame);
      this.hMj.az(0L, 0L);
      AppMethodBeat.o(132579);
      return 0;
    }
    paramf = new a();
    ccr localccr = ((v.a)paramf.getReqObj()).Fox;
    if (this.ifr == 3)
    {
      localccr.GWU = 1;
      if (!this.ifs) {
        break label383;
      }
    }
    label383:
    for (int i = 6;; i = this.ifr)
    {
      this.ifr = i;
      localccr.FRq = duf;
      com.tencent.mm.kernel.g.ajD();
      byte[] arrayOfByte = bt.aRa(bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(8195, new byte[0])));
      localccr.FRr = z.al(arrayOfByte);
      localccr.Scene = this.ifr;
      localccr.GWT = new zv();
      localccr.FzJ = d.hgH;
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", new Object[] { Integer.valueOf(localccr.FRq), Integer.valueOf(localccr.Scene), com.tencent.mm.protocal.ad.cq(arrayOfByte) });
      ifn = false;
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(132579);
      return i;
      localccr.GWU = 0;
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
    long l = this.gFK.abj();
    boolean bool = this.ieu;
    if (localb.Foy.FRu == null)
    {
      paramInt1 = -1;
      com.tencent.mm.sdk.platformtools.ad.i(paramArrayOfByte, "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(l), Boolean.valueOf(bool), Integer.valueOf(paramInt1), this.hMj, this.ifp });
      if (localb.Foy.FRu != null) {
        break label381;
      }
      paramInt1 = -1;
      label205:
      if (paramInt1 <= 0) {
        break label396;
      }
      paramInt1 = 1;
      label211:
      if (aJr()) {
        break label409;
      }
      paramArrayOfByte = com.tencent.mm.plugin.report.e.ygI;
      if (paramInt1 == 0) {
        break label401;
      }
      l = 221L;
      label232:
      paramArrayOfByte.idkeyStat(99L, l, 1L, false);
      this.hMj = null;
      this.ifo = true;
      if ((paramInt2 != 4) || (paramInt3 != -2006)) {
        break label863;
      }
      bool = true;
      paramInt2 = 0;
      paramInt3 = 0;
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 227L, 1L, false);
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        if (this.ifu != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
          this.errType = paramInt2;
          this.errCode = paramInt3;
          this.errMsg = paramString;
          ((v.b)paramq.getRespObj()).Foy.FMr = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 232L, 1L, false);
          AppMethodBeat.o(132581);
          return;
          paramInt1 = localb.Foy.FRu.nDi;
          break;
          label381:
          paramInt1 = localb.Foy.FRu.nDi;
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
            paramArrayOfByte = com.tencent.mm.plugin.report.e.ygI;
            if (paramInt1 != 0) {}
            for (l = 220L;; l = 217L)
            {
              paramArrayOfByte.idkeyStat(99L, l, 1L, false);
              break;
            }
          }
          paramArrayOfByte = com.tencent.mm.plugin.report.e.ygI;
          if (paramInt1 != 0) {}
          for (l = 219L;; l = 216L)
          {
            paramArrayOfByte.idkeyStat(99L, l, 1L, false);
            break;
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 233L, 1L, false);
      paramArrayOfByte = z.a(((v.a)paramq.getReqObj()).Fox.FRr);
      paramq = z.a(localb.Foy.FRr);
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "onGYNetEnd replace key:%b req :%s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.protocal.ad.cq(paramArrayOfByte) });
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", new Object[] { Boolean.valueOf(bool), com.tencent.mm.protocal.ad.cq(paramq) });
      if (!bool)
      {
        paramString = paramArrayOfByte;
        if (bt.cC(paramArrayOfByte))
        {
          com.tencent.mm.kernel.g.ajD();
          paramString = bt.aRa(bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(8195, new byte[0])));
          com.tencent.mm.sdk.platformtools.ad.d(this.TAG, "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramString.length), bt.cB(paramString) });
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
        localb.Foy.FRr = z.al(paramString);
      }
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajA().cO(localb.Foy.nDG, localb.Foy.GWV);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.kernel.a.mM(localb.Foy.nDG);
      if (this.ifu == null) {}
      for (bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.ifu = localb;
        this.ifv = bt.flT();
        new av(com.tencent.mm.kernel.g.ajF().IdO.getLooper(), new av.a()
        {
          private int ifA = 0;
          private int ify = 0;
          private long ifz = 0L;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(132571);
            Object localObject2 = new c();
            if (!com.tencent.mm.kernel.g.ajx())
            {
              com.tencent.mm.sdk.platformtools.ad.e(k.b(k.this), "syncRespHandler acc is not ready STOP :%s", new Object[] { k.c(k.this) });
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            if (k.e(k.this))
            {
              ((c)localObject2).dt(k.this);
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            if ((k.c(k.this) == null) || (k.c(k.this).Foy.FRu == null) || (k.c(k.this).Foy.FRu.nDj == null))
            {
              com.tencent.mm.sdk.platformtools.ad.e(k.b(k.this), "syncRespHandler CmdList is null! Stop Processing :%s", new Object[] { k.c(k.this) });
              ((c)localObject2).dt(k.this);
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            Object localObject1 = k.c(k.this).Foy.FRu.nDj;
            ((c)localObject2).dr(k.this);
            this.ifA += 1;
            long l1 = bt.flT();
            int i = 0;
            while (i < 5)
            {
              if (this.ify < ((LinkedList)localObject1).size())
              {
                com.tencent.mm.sdk.platformtools.ad.v(k.b(k.this), "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.ify), Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((zu)((LinkedList)localObject1).get(this.ify)).FYU), Integer.valueOf(((zu)((LinkedList)localObject1).get(this.ify)).FYV.getILen()) });
                ((LinkedList)localObject1).size();
                if (!((c)localObject2).a((zu)((LinkedList)localObject1).get(this.ify), false)) {
                  com.tencent.mm.sdk.platformtools.ad.w(k.b(k.this), "DoCmd Failed index:%d", new Object[] { Integer.valueOf(this.ify) });
                }
                this.ify += 1;
              }
              if (this.ify >= ((LinkedList)localObject1).size())
              {
                this.ifz += bt.Df(l1);
                l2 = bt.Df(k.f(k.this));
                com.tencent.mm.sdk.platformtools.ad.i(k.b(k.this), "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", new Object[] { Integer.valueOf(this.ify), Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(l2), Long.valueOf(this.ifz), Integer.valueOf(this.ifA), k.c(k.this) });
                k.this.a(k.c(k.this));
                ((c)localObject2).ds(k.this);
                i = bt.n((Integer)com.tencent.mm.plugin.report.e.a((int)this.ifz, new int[] { 100, 300, 1000, 3000 }, new Integer[] { Integer.valueOf(240), Integer.valueOf(239), Integer.valueOf(238), Integer.valueOf(237), Integer.valueOf(236) }));
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, i, 1L, false);
                i = bt.n((Integer)com.tencent.mm.plugin.report.e.a(((LinkedList)localObject1).size(), new int[] { 0, 1, 2, 3, 5, 10 }, new Integer[] { Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(247), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243) }));
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, i, 1L, false);
                localObject2 = com.tencent.mm.plugin.report.e.ygI;
                int j;
                int k;
                int m;
                int n;
                if (com.tencent.mm.sdk.a.b.foreground)
                {
                  l1 = 241L;
                  ((com.tencent.mm.plugin.report.e)localObject2).idkeyStat(99L, l1, 1L, false);
                  com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, k.g(k.this), 1L, false);
                  com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 0L, 1L, false);
                  localObject2 = com.tencent.mm.plugin.report.e.ygI;
                  j = ((LinkedList)localObject1).size();
                  k = k.g(k.this);
                  m = k.c(k.this).Foy.FMr;
                  l1 = this.ifz;
                  n = this.ifA;
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
              long l2 = bt.Df(l1);
              if (l2 > 500L)
              {
                com.tencent.mm.sdk.platformtools.ad.d(k.b(k.this), "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(this.ify), k.c(k.this) });
                this.ifz += bt.Df(l1);
                AppMethodBeat.o(132571);
                return true;
              }
              i += 1;
            }
            this.ifz += bt.Df(l1);
            AppMethodBeat.o(132571);
            return true;
          }
        }, true).az(50L, 50L);
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
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(99L, 228L, 1L, false);
      locale = com.tencent.mm.plugin.report.e.ygI;
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
    return n.b.hOp;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends com.tencent.mm.al.l
  {
    private final v.a iex;
    private final v.b iey;
    private final boolean iez;
    
    public a()
    {
      AppMethodBeat.i(132572);
      this.iex = new v.a();
      this.iey = new v.b();
      this.iez = false;
      AppMethodBeat.o(132572);
    }
    
    public a(v.b paramb)
    {
      AppMethodBeat.i(132573);
      this.iex = new v.a();
      this.iey = paramb;
      this.iez = true;
      AppMethodBeat.o(132573);
    }
    
    public final boolean getPush()
    {
      return this.iez;
    }
    
    public final l.d getReqObjImp()
    {
      return this.iex;
    }
    
    public final l.e getRespObj()
    {
      return this.iey;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelmulti.k
 * JD-Core Version:    0.7.0.1
 */