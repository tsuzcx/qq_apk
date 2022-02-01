package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ctr;
import com.tencent.mm.protocal.protobuf.cts;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.lang.reflect.Method;
import java.util.LinkedList;
import junit.framework.Assert;

public final class k
  extends q
  implements m
{
  protected static int dML = 7;
  private static boolean jdb = false;
  private static int jde = 0;
  public String TAG;
  private i callback;
  private int errCode;
  private String errMsg;
  private int errType;
  private f.a hvh;
  private MTimerHandler iKj;
  private boolean jcC;
  private int jce;
  private long jcg;
  private boolean jch;
  public r jda;
  private boolean jdc;
  private MTimerHandler jdd;
  private int jdf;
  private boolean jdg;
  private String jdh;
  public v.b jdi;
  private long jdj;
  
  public k(int paramInt)
  {
    AppMethodBeat.i(132574);
    this.TAG = "MicroMsg.NetSceneSync";
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.jda = null;
    this.jdc = false;
    this.jce = 0;
    this.iKj = null;
    this.jdd = null;
    this.jcg = -1L;
    this.jch = false;
    this.jdg = false;
    this.jcC = false;
    this.jdh = "";
    this.jdi = null;
    this.jdj = 0L;
    this.TAG = (this.TAG + "[" + hashCode() + "]");
    Log.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", new Object[] { Integer.valueOf(paramInt), Util.getStack() });
    this.jdh = MMStack.getCaller();
    this.hvh = new f.a();
    if (this.jda == null) {
      this.jda = new r();
    }
    this.jda.jeB = paramInt;
    com.tencent.mm.kernel.g.aAi();
    if ((com.tencent.mm.kernel.g.aAh() != null) && (com.tencent.mm.kernel.g.aAc()))
    {
      com.tencent.mm.kernel.g.aAi();
      if ((com.tencent.mm.kernel.g.aAh().azQ() != null) && (!a.azj()))
      {
        com.tencent.mm.kernel.g.aAi();
        long l = Util.nullAs((Long)com.tencent.mm.kernel.g.aAh().azQ().get(8196, null), 0L);
        if (l != 0L)
        {
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(8196, Long.valueOf(0L));
          int i = (int)(l | dML);
          dML = i;
          dML = i & 0x5F;
        }
      }
    }
    if (paramInt == 1) {
      jdb = true;
    }
    if (paramInt == 1010)
    {
      dML |= 0x10;
      jdb = true;
      this.jdf = 7;
    }
    for (;;)
    {
      if (jde == 0) {
        bdL();
      }
      AppMethodBeat.o(132574);
      return;
      if (paramInt == 1011)
      {
        dML |= 0x40;
        jdb = true;
        this.jdf = 7;
      }
      else if (paramInt == 3)
      {
        dML |= 0x40000;
        jdb = true;
        this.jdf = 3;
        Log.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(dML), Integer.valueOf(this.jdf) });
      }
      else
      {
        this.jdf = paramInt;
      }
    }
  }
  
  public k(final v.b paramb, int paramInt, long paramLong)
  {
    this(8);
    AppMethodBeat.i(132575);
    this.jdh = MMStack.getCaller();
    Log.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", new Object[] { Long.valueOf(paramb.getBufferSize()), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    this.jce = paramInt;
    this.jcg = paramLong;
    this.iKj = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132569);
        k.a(k.this);
        k.a locala = new k.a(paramb);
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 230L, 1L, false);
        k.this.onGYNetEnd(-1, 0, 0, "", locala, null);
        AppMethodBeat.o(132569);
        return false;
      }
    }, false);
    if (jde == 0) {
      bdL();
    }
    AppMethodBeat.o(132575);
  }
  
  private boolean bdL()
  {
    AppMethodBeat.i(132580);
    Object localObject2 = new PInt();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf();
    Object localObject1 = com.tencent.mm.booter.g.a((PInt)localObject2, a.getUin());
    String str = this.TAG;
    int j = ((PInt)localObject2).value;
    int k = hashCode();
    if (localObject1 != null) {}
    for (int i = localObject1.length;; i = 0)
    {
      Log.i(str, "dealWithRespData index:%d, hashcode:%d, buf.len:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      jde = ((PInt)localObject2).value;
      if ((((PInt)localObject2).value != 0) && (!Util.isNullOrNil((byte[])localObject1))) {
        break;
      }
      jde = 0;
      AppMethodBeat.o(132580);
      return false;
    }
    localObject2 = new v.b();
    try
    {
      ((v.b)localObject2).fromProtoBuf((byte[])localObject1);
      localObject1 = new a((v.b)localObject2);
      this.jdd = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(132570);
          k.a(k.this);
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 231L, 1L, false);
          k.this.onGYNetEnd(-1, 0, 0, "", this.jdl, null);
          AppMethodBeat.o(132570);
          return false;
        }
      }, false);
      AppMethodBeat.o(132580);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 226L, 1L, false);
      Log.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
      i = jde;
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAf();
      com.tencent.mm.booter.g.cq(i, a.getUin());
      jde = 0;
      AppMethodBeat.o(132580);
      return false;
    }
    catch (Error localError)
    {
      long l1 = Runtime.getRuntime().freeMemory() / 1000L;
      long l2 = Runtime.getRuntime().totalMemory() / 1000L;
      Log.i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
      Assert.assertTrue("dealWithRespData error", false);
      AppMethodBeat.o(132580);
    }
    return false;
  }
  
  private boolean bdM()
  {
    AppMethodBeat.i(132583);
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)MMApplicationContext.getContext().getSystemService("power"), new Object[0])).booleanValue();
      AppMethodBeat.o(132583);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, Util.stackTraceToString(localException) });
      AppMethodBeat.o(132583);
    }
    return true;
  }
  
  protected final void a(v.b paramb)
  {
    AppMethodBeat.i(132582);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().set(8195, Util.encodeHexString(z.a(paramb.KAh.Lev)));
    MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.aps()).edit().putString("notify_sync_key_keybuf", Util.encodeHexString(z.a(paramb.KAh.Lev))).commit();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().set(8196, Long.valueOf(paramb.KAh.KZh));
    boolean bool;
    Object localObject;
    if (((paramb.KAh.KZh & dML) != 0) && (!super.securityLimitCountReach()))
    {
      bool = true;
      Log.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramb.KAh.KZh), Integer.valueOf(dML), Boolean.valueOf(super.securityLimitCountReach()) });
      if ((!bool) && ((paramb.KAh.KZh & 0x100) != 0))
      {
        localObject = new wf();
        ((wf)localObject).ecp.sourceType = 1;
        EventCenter.instance.publish((IEvent)localObject);
      }
      if ((!bool) && ((paramb.KAh.KZh & 0x200000) != 0))
      {
        localObject = new oy();
        EventCenter.instance.publish((IEvent)localObject);
      }
      if ((!bool) && ((paramb.KAh.KZh & 0x1000000) != 0))
      {
        localObject = new id();
        EventCenter.instance.publish((IEvent)localObject);
      }
      if ((!bool) && ((paramb.KAh.KZh & 0x20) != 0))
      {
        localObject = new at();
        EventCenter.instance.publish((IEvent)localObject);
      }
      localObject = com.tencent.mm.plugin.report.e.Cxv;
      if (!bool) {
        break label483;
      }
    }
    label483:
    for (long l = 234L;; l = 235L)
    {
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(99L, l, 1L, false);
      Log.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", new Object[] { Integer.valueOf(paramb.KAh.KZh), Boolean.valueOf(this.jch), Boolean.valueOf(bool), Boolean.valueOf(jdb), Integer.valueOf(this.jce), Boolean.valueOf(this.jdg), this.jdd });
      if ((this.jch) || (!bool)) {
        break label491;
      }
      this.jdg = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
      bool = false;
      break;
    }
    label491:
    int i;
    if (jdb)
    {
      Log.i(this.TAG, "dkpush new notify pending, sync now");
      if (jde != 0)
      {
        i = jde;
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAf();
        com.tencent.mm.booter.g.cq(i, a.getUin());
      }
      jde = 0;
      this.jdd = null;
      jdb = false;
      this.jdg = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
    }
    if (this.jdd != null)
    {
      i = jde;
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAf();
      com.tencent.mm.booter.g.cq(i, a.getUin());
      this.jdd = null;
      bdL();
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
    }
    if ((this.jce & 0x1) > 0)
    {
      com.tencent.mm.kernel.g.aAi();
      paramb = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(8195, null)));
      com.tencent.mm.kernel.g.azz().a(new g(this.jcg, paramb), 0);
    }
    Log.d(this.TAG, "sync or init end: reset selector : now = " + dML + " default = 7");
    dML = 7;
    this.callback.onSceneEnd(this.errType, this.errCode, this.errMsg, this);
    AppMethodBeat.o(132582);
  }
  
  public final boolean accept(q paramq)
  {
    boolean bool = true;
    AppMethodBeat.i(132576);
    if (!(paramq instanceof k))
    {
      AppMethodBeat.o(132576);
      return false;
    }
    paramq = (k)paramq;
    if ((!paramq.jdc) && (jdb))
    {
      Log.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", new Object[] { Long.valueOf(paramq.lastdispatch) });
      if (Util.ticksToNow(paramq.lastdispatch) > 360000L) {}
      while (bool)
      {
        Log.i(this.TAG, "summerworker NetSceneSync timeout");
        if (com.tencent.mm.kernel.g.aAk().findTaskByRunTime(false, 0L) == null) {
          break;
        }
        Log.e(this.TAG, "summerworker worker is just blocked by task: " + com.tencent.mm.kernel.g.aAk().dump(false, false));
        AppMethodBeat.o(132576);
        return false;
        bool = false;
      }
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
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 229L, 1L, false);
    this.jcC = true;
    AppMethodBeat.o(132578);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(132579);
    if (l.bdN())
    {
      jde = 0;
      Log.e(this.TAG, "dkinit never do sync before init done");
      AppMethodBeat.o(132579);
      return -1;
    }
    this.callback = parami;
    if (this.jda == null) {
      this.jda = new r();
    }
    this.jda.cQp = CrashReportFactory.foreground;
    if (this.jdd != null)
    {
      Log.i(this.TAG, "pushSyncRespHandler not null");
      prepareDispatcher(paramg);
      this.jdd.startTimer(0L);
      AppMethodBeat.o(132579);
      return 0;
    }
    if (jde > 0)
    {
      Log.w(this.TAG, "other sync is dealing with resp data :%d", new Object[] { Integer.valueOf(jde) });
      AppMethodBeat.o(132579);
      return -1;
    }
    if (this.iKj != null)
    {
      Log.i(this.TAG, "pusher not null");
      prepareDispatcher(paramg);
      this.iKj.startTimer(0L);
      AppMethodBeat.o(132579);
      return 0;
    }
    parami = new a();
    ctr localctr = ((v.a)parami.getReqObj()).KAg;
    if (this.jdf == 3)
    {
      localctr.Mza = 1;
      if (!this.jdg) {
        break label381;
      }
    }
    label381:
    for (int i = 6;; i = this.jdf)
    {
      this.jdf = i;
      localctr.Leu = dML;
      com.tencent.mm.kernel.g.aAi();
      byte[] arrayOfByte = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(8195, new byte[0])));
      localctr.Lev = z.aC(arrayOfByte);
      localctr.Scene = this.jdf;
      localctr.MyZ = new abo();
      localctr.KLO = d.ics;
      Log.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", new Object[] { Integer.valueOf(localctr.Leu), Integer.valueOf(localctr.Scene), ad.cK(arrayOfByte) });
      jdb = false;
      i = dispatch(paramg, parami, this);
      AppMethodBeat.o(132579);
      return i;
      localctr.Mza = 0;
      break;
    }
  }
  
  public final int getType()
  {
    return 138;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132581);
    if ((params == null) || (params.getType() != 138))
    {
      paramString = this.TAG;
      if (params == null) {}
      for (paramInt1 = -2;; paramInt1 = params.getType())
      {
        Log.e(paramString, "onGYNetEnd error type:%d", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(132581);
        return;
      }
    }
    v.b localb = (v.b)params.getRespObj();
    paramArrayOfByte = this.TAG;
    long l = this.hvh.apr();
    boolean bool = this.jch;
    if (localb.KAh.Ley == null)
    {
      paramInt1 = -1;
      Log.i(paramArrayOfByte, "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(l), Boolean.valueOf(bool), Integer.valueOf(paramInt1), this.iKj, this.jdd });
      if (localb.KAh.Ley != null) {
        break label381;
      }
      paramInt1 = -1;
      label205:
      if (paramInt1 <= 0) {
        break label396;
      }
      paramInt1 = 1;
      label211:
      if (bdM()) {
        break label409;
      }
      paramArrayOfByte = com.tencent.mm.plugin.report.e.Cxv;
      if (paramInt1 == 0) {
        break label401;
      }
      l = 221L;
      label232:
      paramArrayOfByte.idkeyStat(99L, l, 1L, false);
      this.iKj = null;
      this.jdc = true;
      if ((paramInt2 != 4) || (paramInt3 != -2006)) {
        break label872;
      }
      bool = true;
      paramInt2 = 0;
      paramInt3 = 0;
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 227L, 1L, false);
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        if (this.jdi != null)
        {
          Log.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
          this.errType = paramInt2;
          this.errCode = paramInt3;
          this.errMsg = paramString;
          ((v.b)params.getRespObj()).KAh.KZh = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 232L, 1L, false);
          AppMethodBeat.o(132581);
          return;
          paramInt1 = localb.KAh.Ley.oTz;
          break;
          label381:
          paramInt1 = localb.KAh.Ley.oTz;
          break label205;
          label396:
          paramInt1 = 0;
          break label211;
          label401:
          l = 218L;
          break label232;
          label409:
          if (!CrashReportFactory.foreground)
          {
            paramArrayOfByte = com.tencent.mm.plugin.report.e.Cxv;
            if (paramInt1 != 0) {}
            for (l = 220L;; l = 217L)
            {
              paramArrayOfByte.idkeyStat(99L, l, 1L, false);
              break;
            }
          }
          paramArrayOfByte = com.tencent.mm.plugin.report.e.Cxv;
          if (paramInt1 != 0) {}
          for (l = 219L;; l = 216L)
          {
            paramArrayOfByte.idkeyStat(99L, l, 1L, false);
            break;
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
      }
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 233L, 1L, false);
      paramArrayOfByte = z.a(((v.a)params.getReqObj()).KAg.Lev);
      params = z.a(localb.KAh.Lev);
      Log.i(this.TAG, "onGYNetEnd replace key:%b req :%s", new Object[] { Boolean.valueOf(bool), ad.cK(paramArrayOfByte) });
      Log.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", new Object[] { Boolean.valueOf(bool), ad.cK(params) });
      if (!bool)
      {
        paramString = paramArrayOfByte;
        if (Util.isNullOrNil(paramArrayOfByte))
        {
          com.tencent.mm.kernel.g.aAi();
          paramString = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(8195, "")));
          paramArrayOfByte = this.TAG;
          if (paramString == null)
          {
            paramInt1 = -1;
            Log.d(paramArrayOfByte, "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramInt1), Util.dumpHex(paramString) });
          }
        }
        else
        {
          paramArrayOfByte = ad.l(paramString, params);
          if (paramArrayOfByte != null)
          {
            paramString = paramArrayOfByte;
            if (paramArrayOfByte.length > 0) {}
          }
          else
          {
            Log.w(this.TAG, "merge key failed, use server side instead");
            paramString = params;
          }
          localb.KAh.Lev = z.aC(paramString);
        }
      }
      else
      {
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAf().cU(localb.KAh.oTW, localb.KAh.Mzb);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAf();
        a.qc(localb.KAh.oTW);
        if (this.jdi != null) {
          break label866;
        }
      }
      label866:
      for (bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.jdi = localb;
        this.jdj = Util.nowMilliSecond();
        new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), new MTimerHandler.CallBack()
        {
          private int jdm = 0;
          private long jdn = 0L;
          private int jdo = 0;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(132571);
            Object localObject2 = new c();
            if (!com.tencent.mm.kernel.g.aAc())
            {
              Log.e(k.b(k.this), "syncRespHandler acc is not ready STOP :%s", new Object[] { k.c(k.this) });
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            if (k.e(k.this))
            {
              ((c)localObject2).dB(k.this);
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            if ((k.c(k.this) == null) || (k.c(k.this).KAh.Ley == null) || (k.c(k.this).KAh.Ley.oTA == null))
            {
              Log.e(k.b(k.this), "syncRespHandler CmdList is null! Stop Processing :%s", new Object[] { k.c(k.this) });
              ((c)localObject2).dB(k.this);
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            Object localObject1 = k.c(k.this).KAh.Ley.oTA;
            ((c)localObject2).dz(k.this);
            this.jdo += 1;
            long l1 = Util.nowMilliSecond();
            int i = 0;
            while (i < 5)
            {
              if (this.jdm < ((LinkedList)localObject1).size())
              {
                Log.v(k.b(k.this), "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdm), Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((abn)((LinkedList)localObject1).get(this.jdm)).Lms), Integer.valueOf(((abn)((LinkedList)localObject1).get(this.jdm)).Lmt.getILen()) });
                ((LinkedList)localObject1).size();
                if (!((c)localObject2).a((abn)((LinkedList)localObject1).get(this.jdm), false)) {
                  Log.w(k.b(k.this), "DoCmd Failed index:%d", new Object[] { Integer.valueOf(this.jdm) });
                }
                this.jdm += 1;
              }
              if (this.jdm >= ((LinkedList)localObject1).size())
              {
                this.jdn += Util.milliSecondsToNow(l1);
                l2 = Util.milliSecondsToNow(k.f(k.this));
                Log.i(k.b(k.this), "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", new Object[] { Integer.valueOf(this.jdm), Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(l2), Long.valueOf(this.jdn), Integer.valueOf(this.jdo), k.c(k.this) });
                k.this.a(k.c(k.this));
                ((c)localObject2).dA(k.this);
                i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.e.a((int)this.jdn, new int[] { 100, 300, 1000, 3000 }, new Integer[] { Integer.valueOf(240), Integer.valueOf(239), Integer.valueOf(238), Integer.valueOf(237), Integer.valueOf(236) }));
                com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, i, 1L, false);
                i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.e.a(((LinkedList)localObject1).size(), new int[] { 0, 1, 2, 3, 5, 10 }, new Integer[] { Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(247), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243) }));
                com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, i, 1L, false);
                localObject2 = com.tencent.mm.plugin.report.e.Cxv;
                int j;
                int k;
                int m;
                int n;
                if (CrashReportFactory.foreground)
                {
                  l1 = 241L;
                  ((com.tencent.mm.plugin.report.e)localObject2).idkeyStat(99L, l1, 1L, false);
                  com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, k.g(k.this), 1L, false);
                  com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 0L, 1L, false);
                  localObject2 = com.tencent.mm.plugin.report.e.Cxv;
                  j = ((LinkedList)localObject1).size();
                  k = k.g(k.this);
                  m = k.c(k.this).KAh.KZh;
                  l1 = this.jdn;
                  n = this.jdo;
                  localObject1 = k.h(k.this);
                  if (!CrashReportFactory.foreground) {
                    break label987;
                  }
                }
                label987:
                for (i = 1;; i = 2)
                {
                  ((com.tencent.mm.plugin.report.e)localObject2).a(12063, new Object[] { Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Integer.valueOf(n), localObject1, Integer.valueOf(i) });
                  k.d(k.this);
                  AppMethodBeat.o(132571);
                  return false;
                  l1 = 242L;
                  break;
                }
              }
              long l2 = Util.milliSecondsToNow(l1);
              if (l2 > 500L)
              {
                Log.d(k.b(k.this), "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(this.jdm), k.c(k.this) });
                this.jdn += Util.milliSecondsToNow(l1);
                AppMethodBeat.o(132571);
                return true;
              }
              i += 1;
            }
            this.jdn += Util.milliSecondsToNow(l1);
            AppMethodBeat.o(132571);
            return true;
          }
        }, true).startTimer(50L);
        AppMethodBeat.o(132581);
        return;
        paramInt1 = paramString.length;
        break;
      }
      label872:
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
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(99L, 228L, 1L, false);
      locale = com.tencent.mm.plugin.report.e.Cxv;
      if (!CrashReportFactory.foreground) {
        break label126;
      }
    }
    for (;;)
    {
      locale.a(12063, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), "9999" });
      AppMethodBeat.o(132577);
      return bool;
      label126:
      i = 2;
    }
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends o
  {
    private final v.a jck;
    private final v.b jcl;
    private final boolean jcm;
    
    public a()
    {
      AppMethodBeat.i(132572);
      this.jck = new v.a();
      this.jcl = new v.b();
      this.jcm = false;
      AppMethodBeat.o(132572);
    }
    
    public a(v.b paramb)
    {
      AppMethodBeat.i(132573);
      this.jck = new v.a();
      this.jcl = paramb;
      this.jcm = true;
      AppMethodBeat.o(132573);
    }
    
    public final boolean getPush()
    {
      return this.jcm;
    }
    
    public final l.d getReqObjImp()
    {
      return this.jck;
    }
    
    public final l.e getRespObj()
    {
      return this.jcl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.k
 * JD-Core Version:    0.7.0.1
 */