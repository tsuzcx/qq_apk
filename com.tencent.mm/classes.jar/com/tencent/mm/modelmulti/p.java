package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.a.ba;
import com.tencent.mm.autogen.a.jo;
import com.tencent.mm.autogen.a.ri;
import com.tencent.mm.autogen.a.zd;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.duj;
import com.tencent.mm.protocal.protobuf.duk;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.lang.reflect.Method;
import java.util.LinkedList;
import junit.framework.Assert;

public final class p
  extends com.tencent.mm.am.p
  implements m
{
  private static boolean oMt = false;
  private static int oMw = 0;
  protected static int selector = 7;
  public String TAG;
  private com.tencent.mm.am.h callback;
  private int errCode;
  private String errMsg;
  private int errType;
  private f.a mHw;
  private boolean oLA;
  private boolean oLU;
  private int oLx;
  private long oLz;
  public v.b oMA;
  private long oMB;
  public x oMs;
  private boolean oMu;
  private MTimerHandler oMv;
  private int oMx;
  private boolean oMy;
  private String oMz;
  private MTimerHandler orP;
  
  public p(int paramInt)
  {
    AppMethodBeat.i(132574);
    this.TAG = "MicroMsg.NetSceneSync";
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.oMs = null;
    this.oMu = false;
    this.oLx = 0;
    this.orP = null;
    this.oMv = null;
    this.oLz = -1L;
    this.oLA = false;
    this.oMy = false;
    this.oLU = false;
    this.oMz = "";
    this.oMA = null;
    this.oMB = 0L;
    this.TAG = (this.TAG + "[" + hashCode() + "]");
    Log.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", new Object[] { Integer.valueOf(paramInt), Util.getStack() });
    this.oMz = MMStack.getCaller();
    this.mHw = new f.a();
    if (this.oMs == null) {
      this.oMs = new x();
    }
    this.oMs.oOc = paramInt;
    com.tencent.mm.kernel.h.baF();
    if ((com.tencent.mm.kernel.h.baE() != null) && (com.tencent.mm.kernel.h.baz()))
    {
      com.tencent.mm.kernel.h.baF();
      if ((com.tencent.mm.kernel.h.baE().ban() != null) && (!b.aZG()))
      {
        com.tencent.mm.kernel.h.baF();
        long l = Util.nullAs((Long)com.tencent.mm.kernel.h.baE().ban().d(8196, null), 0L);
        if (l != 0L)
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().B(8196, Long.valueOf(0L));
          int i = (int)(l | selector);
          selector = i;
          selector = i & 0x5F;
        }
      }
    }
    if (paramInt == 1) {
      oMt = true;
    }
    if (paramInt == 1010)
    {
      selector |= 0x10;
      oMt = true;
      this.oMx = 7;
    }
    for (;;)
    {
      if (oMw == 0) {
        bKR();
      }
      AppMethodBeat.o(132574);
      return;
      if (paramInt == 1011)
      {
        selector |= 0x40;
        oMt = true;
        this.oMx = 7;
      }
      else if (paramInt == 3)
      {
        selector |= 0x40000;
        oMt = true;
        this.oMx = 3;
        Log.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(selector), Integer.valueOf(this.oMx) });
      }
      else
      {
        this.oMx = paramInt;
      }
    }
  }
  
  public p(final v.b paramb, int paramInt, long paramLong)
  {
    this(8);
    AppMethodBeat.i(132575);
    this.oMz = MMStack.getCaller();
    Log.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", new Object[] { Long.valueOf(paramb.getBufferSize()), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    this.oLx = paramInt;
    this.oLz = paramLong;
    this.orP = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132569);
        p.a(p.this);
        p.a locala = new p.a(paramb);
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 230L, 1L, false);
        p.this.onGYNetEnd(-1, 0, 0, "", locala, null);
        AppMethodBeat.o(132569);
        return false;
      }
    }, false);
    if (oMw == 0) {
      bKR();
    }
    AppMethodBeat.o(132575);
  }
  
  private boolean bKR()
  {
    AppMethodBeat.i(132580);
    Object localObject2 = new PInt();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC();
    Object localObject1 = com.tencent.mm.booter.g.a((PInt)localObject2, b.getUin());
    String str = this.TAG;
    int j = ((PInt)localObject2).value;
    int k = hashCode();
    if (localObject1 != null) {}
    for (int i = localObject1.length;; i = 0)
    {
      Log.i(str, "dealWithRespData index:%d, hashcode:%d, buf.len:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      oMw = ((PInt)localObject2).value;
      if ((((PInt)localObject2).value != 0) && (!Util.isNullOrNil((byte[])localObject1))) {
        break;
      }
      oMw = 0;
      AppMethodBeat.o(132580);
      return false;
    }
    localObject2 = new v.b();
    try
    {
      ((v.b)localObject2).fromProtoBuf((byte[])localObject1);
      localObject1 = new a((v.b)localObject2);
      this.oMv = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(132570);
          p.a(p.this);
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 231L, 1L, false);
          p.this.onGYNetEnd(-1, 0, 0, "", this.oMD, null);
          AppMethodBeat.o(132570);
          return false;
        }
      }, false);
      AppMethodBeat.o(132580);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 226L, 1L, false);
      Log.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
      i = oMw;
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.booter.g.dy(i, b.getUin());
      oMw = 0;
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
  
  private boolean bKS()
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
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().B(8195, Util.encodeHexString(w.a(paramb.YyA.ZdD)));
    MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.aQe()).edit().putString("notify_sync_key_keybuf", Util.encodeHexString(w.a(paramb.YyA.ZdD))).commit();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().B(8196, Long.valueOf(paramb.YyA.YYp));
    boolean bool;
    Object localObject;
    if (((paramb.YyA.YYp & selector) != 0) && (!super.securityLimitCountReach()))
    {
      bool = true;
      Log.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramb.YyA.YYp), Integer.valueOf(selector), Boolean.valueOf(super.securityLimitCountReach()) });
      if ((!bool) && ((paramb.YyA.YYp & 0x100) != 0))
      {
        localObject = new zd();
        ((zd)localObject).icq.sourceType = 1;
        ((zd)localObject).publish();
      }
      if ((!bool) && ((paramb.YyA.YYp & 0x200000) != 0)) {
        new ri().publish();
      }
      if ((!bool) && ((paramb.YyA.YYp & 0x1000000) != 0)) {
        new jo().publish();
      }
      if ((!bool) && ((paramb.YyA.YYp & 0x20) != 0)) {
        new ba().publish();
      }
      localObject = com.tencent.mm.plugin.report.f.Ozc;
      if (!bool) {
        break label459;
      }
    }
    label459:
    for (long l = 234L;; l = 235L)
    {
      ((com.tencent.mm.plugin.report.f)localObject).idkeyStat(99L, l, 1L, false);
      Log.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", new Object[] { Integer.valueOf(paramb.YyA.YYp), Boolean.valueOf(this.oLA), Boolean.valueOf(bool), Boolean.valueOf(oMt), Integer.valueOf(this.oLx), Boolean.valueOf(this.oMy), this.oMv });
      if ((this.oLA) || (!bool)) {
        break label467;
      }
      this.oMy = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
      bool = false;
      break;
    }
    label467:
    int i;
    if (oMt)
    {
      Log.i(this.TAG, "dkpush new notify pending, sync now");
      if (oMw != 0)
      {
        i = oMw;
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baC();
        com.tencent.mm.booter.g.dy(i, b.getUin());
      }
      oMw = 0;
      this.oMv = null;
      oMt = false;
      this.oMy = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
    }
    if (this.oMv != null)
    {
      i = oMw;
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.booter.g.dy(i, b.getUin());
      this.oMv = null;
      bKR();
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
    }
    if ((this.oLx & 0x1) > 0)
    {
      com.tencent.mm.kernel.h.baF();
      paramb = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(8195, null)));
      com.tencent.mm.kernel.h.aZW().a(new l(this.oLz, paramb), 0);
    }
    Log.d(this.TAG, "sync or init end: reset selector : now = " + selector + " default = 7");
    selector = 7;
    this.callback.onSceneEnd(this.errType, this.errCode, this.errMsg, this);
    AppMethodBeat.o(132582);
  }
  
  public final boolean accept(com.tencent.mm.am.p paramp)
  {
    boolean bool = true;
    AppMethodBeat.i(132576);
    if (!(paramp instanceof p))
    {
      AppMethodBeat.o(132576);
      return false;
    }
    paramp = (p)paramp;
    if ((!paramp.oMu) && (oMt))
    {
      Log.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", new Object[] { Long.valueOf(paramp.lastdispatch) });
      if (Util.ticksToNow(paramp.lastdispatch) > 360000L) {}
      while (bool)
      {
        Log.i(this.TAG, "summerworker NetSceneSync timeout");
        if (com.tencent.mm.kernel.h.baH().findTaskByRunTime(false, 0L) == null) {
          break;
        }
        Log.e(this.TAG, "summerworker worker is just blocked by task: " + com.tencent.mm.kernel.h.baH().dump(false, false));
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
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 229L, 1L, false);
    this.oLU = true;
    AppMethodBeat.o(132578);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(132579);
    if (q.bKT())
    {
      oMw = 0;
      Log.e(this.TAG, "dkinit never do sync before init done");
      AppMethodBeat.o(132579);
      return -1;
    }
    this.callback = paramh;
    if (this.oMs == null) {
      this.oMs = new x();
    }
    this.oMs.ffv = CrashReportFactory.foreground;
    if (this.oMv != null)
    {
      Log.i(this.TAG, "pushSyncRespHandler not null");
      prepareDispatcher(paramg);
      this.oMv.startTimer(0L);
      AppMethodBeat.o(132579);
      return 0;
    }
    if (oMw > 0)
    {
      Log.w(this.TAG, "other sync is dealing with resp data :%d", new Object[] { Integer.valueOf(oMw) });
      AppMethodBeat.o(132579);
      return -1;
    }
    if (this.orP != null)
    {
      Log.i(this.TAG, "pusher not null");
      prepareDispatcher(paramg);
      this.orP.startTimer(0L);
      AppMethodBeat.o(132579);
      return 0;
    }
    paramh = new a();
    duj localduj = ((v.a)paramh.getReqObj()).Yyz;
    if (this.oMx == 3)
    {
      localduj.abau = 1;
      if (!this.oMy) {
        break label381;
      }
    }
    label381:
    for (int i = 6;; i = this.oMx)
    {
      this.oMx = i;
      localduj.ZdC = selector;
      com.tencent.mm.kernel.h.baF();
      byte[] arrayOfByte = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(8195, new byte[0])));
      localduj.ZdD = w.aN(arrayOfByte);
      localduj.IJG = this.oMx;
      localduj.abat = new adx();
      localduj.YJY = d.nsC;
      Log.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", new Object[] { Integer.valueOf(localduj.ZdC), Integer.valueOf(localduj.IJG), ad.de(arrayOfByte) });
      oMt = false;
      i = dispatch(paramg, paramh, this);
      AppMethodBeat.o(132579);
      return i;
      localduj.abau = 0;
      break;
    }
  }
  
  public final int getType()
  {
    return 138;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
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
    long l = this.mHw.aPY();
    boolean bool = this.oLA;
    if (localb.YyA.ZdG == null)
    {
      paramInt1 = -1;
      Log.i(paramArrayOfByte, "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(l), Boolean.valueOf(bool), Integer.valueOf(paramInt1), this.orP, this.oMv });
      if (localb.YyA.ZdG != null) {
        break label381;
      }
      paramInt1 = -1;
      label205:
      if (paramInt1 <= 0) {
        break label396;
      }
      paramInt1 = 1;
      label211:
      if (bKS()) {
        break label409;
      }
      paramArrayOfByte = com.tencent.mm.plugin.report.f.Ozc;
      if (paramInt1 == 0) {
        break label401;
      }
      l = 221L;
      label232:
      paramArrayOfByte.idkeyStat(99L, l, 1L, false);
      this.orP = null;
      this.oMu = true;
      if ((paramInt2 != 4) || (paramInt3 != -2006)) {
        break label872;
      }
      bool = true;
      paramInt2 = 0;
      paramInt3 = 0;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 227L, 1L, false);
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        if (this.oMA != null)
        {
          Log.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
          this.errType = paramInt2;
          this.errCode = paramInt3;
          this.errMsg = paramString;
          ((v.b)params.getRespObj()).YyA.YYp = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 232L, 1L, false);
          AppMethodBeat.o(132581);
          return;
          paramInt1 = localb.YyA.ZdG.vgN;
          break;
          label381:
          paramInt1 = localb.YyA.ZdG.vgN;
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
            paramArrayOfByte = com.tencent.mm.plugin.report.f.Ozc;
            if (paramInt1 != 0) {}
            for (l = 220L;; l = 217L)
            {
              paramArrayOfByte.idkeyStat(99L, l, 1L, false);
              break;
            }
          }
          paramArrayOfByte = com.tencent.mm.plugin.report.f.Ozc;
          if (paramInt1 != 0) {}
          for (l = 219L;; l = 216L)
          {
            paramArrayOfByte.idkeyStat(99L, l, 1L, false);
            break;
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 233L, 1L, false);
      paramArrayOfByte = w.a(((v.a)params.getReqObj()).Yyz.ZdD);
      params = w.a(localb.YyA.ZdD);
      Log.i(this.TAG, "onGYNetEnd replace key:%b req :%s", new Object[] { Boolean.valueOf(bool), ad.de(paramArrayOfByte) });
      Log.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", new Object[] { Boolean.valueOf(bool), ad.de(params) });
      if (!bool)
      {
        paramString = paramArrayOfByte;
        if (Util.isNullOrNil(paramArrayOfByte))
        {
          com.tencent.mm.kernel.h.baF();
          paramString = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(8195, "")));
          paramArrayOfByte = this.TAG;
          if (paramString == null)
          {
            paramInt1 = -1;
            Log.d(paramArrayOfByte, "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramInt1), Util.dumpHex(paramString) });
          }
        }
        else
        {
          paramArrayOfByte = ad.o(paramString, params);
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
          localb.YyA.ZdD = w.aN(paramString);
        }
      }
      else
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baC().ec(localb.YyA.vhk, localb.YyA.abav);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baC();
        b.sx(localb.YyA.vhk);
        if (this.oMA != null) {
          break label866;
        }
      }
      label866:
      for (bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.oMA = localb;
        this.oMB = Util.nowMilliSecond();
        new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
        {
          private int oME = 0;
          private long oMF = 0L;
          private int oMG = 0;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(132571);
            Object localObject2 = new c();
            if (!com.tencent.mm.kernel.h.baz())
            {
              Log.e(p.b(p.this), "syncRespHandler acc is not ready STOP :%s", new Object[] { p.c(p.this) });
              p.d(p.this);
              AppMethodBeat.o(132571);
              return false;
            }
            if (p.e(p.this))
            {
              ((c)localObject2).fV(p.this);
              p.d(p.this);
              AppMethodBeat.o(132571);
              return false;
            }
            if ((p.c(p.this) == null) || (p.c(p.this).YyA.ZdG == null) || (p.c(p.this).YyA.ZdG.vgO == null))
            {
              Log.e(p.b(p.this), "syncRespHandler CmdList is null! Stop Processing :%s", new Object[] { p.c(p.this) });
              ((c)localObject2).fV(p.this);
              p.d(p.this);
              AppMethodBeat.o(132571);
              return false;
            }
            Object localObject1 = p.c(p.this).YyA.ZdG.vgO;
            ((c)localObject2).fT(p.this);
            this.oMG += 1;
            long l1 = Util.nowMilliSecond();
            int i = 0;
            while (i < 5)
            {
              if (this.oME < ((LinkedList)localObject1).size())
              {
                Log.v(p.b(p.this), "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.oME), Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((adw)((LinkedList)localObject1).get(this.oME)).Zmc), Integer.valueOf(((adw)((LinkedList)localObject1).get(this.oME)).Zmd.abwJ) });
                ((LinkedList)localObject1).size();
                if (!((c)localObject2).a((adw)((LinkedList)localObject1).get(this.oME), false)) {
                  Log.w(p.b(p.this), "DoCmd Failed index:%d", new Object[] { Integer.valueOf(this.oME) });
                }
                this.oME += 1;
              }
              if (this.oME >= ((LinkedList)localObject1).size())
              {
                this.oMF += Util.milliSecondsToNow(l1);
                l2 = Util.milliSecondsToNow(p.f(p.this));
                Log.i(p.b(p.this), "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", new Object[] { Integer.valueOf(this.oME), Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(l2), Long.valueOf(this.oMF), Integer.valueOf(this.oMG), p.c(p.this) });
                p.this.a(p.c(p.this));
                ((c)localObject2).fU(p.this);
                i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.f.a((int)this.oMF, new int[] { 100, 300, 1000, 3000 }, new Integer[] { Integer.valueOf(240), Integer.valueOf(239), Integer.valueOf(238), Integer.valueOf(237), Integer.valueOf(236) }));
                com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, i, 1L, false);
                i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.f.a(((LinkedList)localObject1).size(), new int[] { 0, 1, 2, 3, 5, 10 }, new Integer[] { Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(247), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243) }));
                com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, i, 1L, false);
                localObject2 = com.tencent.mm.plugin.report.f.Ozc;
                int j;
                int k;
                int m;
                int n;
                if (CrashReportFactory.foreground)
                {
                  l1 = 241L;
                  ((com.tencent.mm.plugin.report.f)localObject2).idkeyStat(99L, l1, 1L, false);
                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, p.g(p.this), 1L, false);
                  com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 0L, 1L, false);
                  localObject2 = com.tencent.mm.plugin.report.f.Ozc;
                  j = ((LinkedList)localObject1).size();
                  k = p.g(p.this);
                  m = p.c(p.this).YyA.YYp;
                  l1 = this.oMF;
                  n = this.oMG;
                  localObject1 = p.h(p.this);
                  if (!CrashReportFactory.foreground) {
                    break label987;
                  }
                }
                label987:
                for (i = 1;; i = 2)
                {
                  ((com.tencent.mm.plugin.report.f)localObject2).b(12063, new Object[] { Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Integer.valueOf(n), localObject1, Integer.valueOf(i) });
                  p.d(p.this);
                  AppMethodBeat.o(132571);
                  return false;
                  l1 = 242L;
                  break;
                }
              }
              long l2 = Util.milliSecondsToNow(l1);
              if (l2 > 500L)
              {
                Log.d(p.b(p.this), "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(this.oME), p.c(p.this) });
                this.oMF += Util.milliSecondsToNow(l1);
                AppMethodBeat.o(132571);
                return true;
              }
              i += 1;
            }
            this.oMF += Util.milliSecondsToNow(l1);
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
    com.tencent.mm.plugin.report.f localf;
    if (bool)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(99L, 228L, 1L, false);
      localf = com.tencent.mm.plugin.report.f.Ozc;
      if (!CrashReportFactory.foreground) {
        break label126;
      }
    }
    for (;;)
    {
      localf.b(12063, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), "9999" });
      AppMethodBeat.o(132577);
      return bool;
      label126:
      i = 2;
    }
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends n
  {
    private final v.a oLD;
    private final v.b oLE;
    private final boolean oLF;
    
    public a()
    {
      AppMethodBeat.i(132572);
      this.oLD = new v.a();
      this.oLE = new v.b();
      this.oLF = false;
      AppMethodBeat.o(132572);
    }
    
    public a(v.b paramb)
    {
      AppMethodBeat.i(132573);
      this.oLD = new v.a();
      this.oLE = paramb;
      this.oLF = true;
      AppMethodBeat.o(132573);
    }
    
    public final boolean getPush()
    {
      return this.oLF;
    }
    
    public final l.d getReqObjImp()
    {
      return this.oLD;
    }
    
    public final l.e getRespObj()
    {
      return this.oLE;
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
 * Qualified Name:     com.tencent.mm.modelmulti.p
 * JD-Core Version:    0.7.0.1
 */