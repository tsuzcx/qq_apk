package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.o;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.f.a.av;
import com.tencent.mm.f.a.is;
import com.tencent.mm.f.a.pv;
import com.tencent.mm.f.a.xk;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.protocal.protobuf.dcr;
import com.tencent.mm.protocal.protobuf.eae;
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
  protected static int fFT = 7;
  private static boolean lTA = false;
  private static int lTD = 0;
  public String TAG;
  private i callback;
  private int errCode;
  private String errMsg;
  private int errType;
  private f.a khd;
  private MTimerHandler lAo;
  private int lSE;
  private long lSG;
  private boolean lSH;
  private boolean lTB;
  private MTimerHandler lTC;
  private int lTE;
  private boolean lTF;
  private String lTG;
  public v.b lTH;
  private long lTI;
  private boolean lTb;
  public r lTz;
  
  public k(int paramInt)
  {
    AppMethodBeat.i(132574);
    this.TAG = "MicroMsg.NetSceneSync";
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.lTz = null;
    this.lTB = false;
    this.lSE = 0;
    this.lAo = null;
    this.lTC = null;
    this.lSG = -1L;
    this.lSH = false;
    this.lTF = false;
    this.lTb = false;
    this.lTG = "";
    this.lTH = null;
    this.lTI = 0L;
    this.TAG = (this.TAG + "[" + hashCode() + "]");
    Log.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", new Object[] { Integer.valueOf(paramInt), Util.getStack() });
    this.lTG = MMStack.getCaller();
    this.khd = new f.a();
    if (this.lTz == null) {
      this.lTz = new r();
    }
    this.lTz.lVa = paramInt;
    h.aHH();
    if ((h.aHG() != null) && (h.aHB()))
    {
      h.aHH();
      if ((h.aHG().aHp() != null) && (!b.aGE()))
      {
        h.aHH();
        long l = Util.nullAs((Long)h.aHG().aHp().b(8196, null), 0L);
        if (l != 0L)
        {
          h.aHH();
          h.aHG().aHp().i(8196, Long.valueOf(0L));
          int i = (int)(l | fFT);
          fFT = i;
          fFT = i & 0x5F;
        }
      }
    }
    if (paramInt == 1) {
      lTA = true;
    }
    if (paramInt == 1010)
    {
      fFT |= 0x10;
      lTA = true;
      this.lTE = 7;
    }
    for (;;)
    {
      if (lTD == 0) {
        bng();
      }
      AppMethodBeat.o(132574);
      return;
      if (paramInt == 1011)
      {
        fFT |= 0x40;
        lTA = true;
        this.lTE = 7;
      }
      else if (paramInt == 3)
      {
        fFT |= 0x40000;
        lTA = true;
        this.lTE = 3;
        Log.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fFT), Integer.valueOf(this.lTE) });
      }
      else
      {
        this.lTE = paramInt;
      }
    }
  }
  
  public k(final v.b paramb, int paramInt, long paramLong)
  {
    this(8);
    AppMethodBeat.i(132575);
    this.lTG = MMStack.getCaller();
    Log.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", new Object[] { Long.valueOf(paramb.getBufferSize()), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    this.lSE = paramInt;
    this.lSG = paramLong;
    this.lAo = new MTimerHandler(h.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132569);
        k.a(k.this);
        k.a locala = new k.a(paramb);
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 230L, 1L, false);
        k.this.onGYNetEnd(-1, 0, 0, "", locala, null);
        AppMethodBeat.o(132569);
        return false;
      }
    }, false);
    if (lTD == 0) {
      bng();
    }
    AppMethodBeat.o(132575);
  }
  
  private boolean bng()
  {
    AppMethodBeat.i(132580);
    Object localObject2 = new PInt();
    h.aHH();
    h.aHE();
    Object localObject1 = com.tencent.mm.booter.g.a((PInt)localObject2, b.getUin());
    String str = this.TAG;
    int j = ((PInt)localObject2).value;
    int k = hashCode();
    if (localObject1 != null) {}
    for (int i = localObject1.length;; i = 0)
    {
      Log.i(str, "dealWithRespData index:%d, hashcode:%d, buf.len:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      lTD = ((PInt)localObject2).value;
      if ((((PInt)localObject2).value != 0) && (!Util.isNullOrNil((byte[])localObject1))) {
        break;
      }
      lTD = 0;
      AppMethodBeat.o(132580);
      return false;
    }
    localObject2 = new v.b();
    try
    {
      ((v.b)localObject2).fromProtoBuf((byte[])localObject1);
      localObject1 = new a((v.b)localObject2);
      this.lTC = new MTimerHandler(h.aHJ().getLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(132570);
          k.a(k.this);
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 231L, 1L, false);
          k.this.onGYNetEnd(-1, 0, 0, "", this.lTK, null);
          AppMethodBeat.o(132570);
          return false;
        }
      }, false);
      AppMethodBeat.o(132580);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 226L, 1L, false);
      Log.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
      i = lTD;
      h.aHH();
      h.aHE();
      com.tencent.mm.booter.g.cI(i, b.getUin());
      lTD = 0;
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
  
  private boolean bnh()
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
    h.aHH();
    h.aHG().aHp().i(8195, Util.encodeHexString(z.a(paramb.RBX.SfI)));
    MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.avK()).edit().putString("notify_sync_key_keybuf", Util.encodeHexString(z.a(paramb.RBX.SfI))).commit();
    h.aHH();
    h.aHG().aHp().i(8196, Long.valueOf(paramb.RBX.Saq));
    boolean bool;
    Object localObject;
    if (((paramb.RBX.Saq & fFT) != 0) && (!super.securityLimitCountReach()))
    {
      bool = true;
      Log.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramb.RBX.Saq), Integer.valueOf(fFT), Boolean.valueOf(super.securityLimitCountReach()) });
      if ((!bool) && ((paramb.RBX.Saq & 0x100) != 0))
      {
        localObject = new xk();
        ((xk)localObject).fWr.sourceType = 1;
        EventCenter.instance.publish((IEvent)localObject);
      }
      if ((!bool) && ((paramb.RBX.Saq & 0x200000) != 0))
      {
        localObject = new pv();
        EventCenter.instance.publish((IEvent)localObject);
      }
      if ((!bool) && ((paramb.RBX.Saq & 0x1000000) != 0))
      {
        localObject = new is();
        EventCenter.instance.publish((IEvent)localObject);
      }
      if ((!bool) && ((paramb.RBX.Saq & 0x20) != 0))
      {
        localObject = new av();
        EventCenter.instance.publish((IEvent)localObject);
      }
      localObject = com.tencent.mm.plugin.report.f.Iyx;
      if (!bool) {
        break label483;
      }
    }
    label483:
    for (long l = 234L;; l = 235L)
    {
      ((com.tencent.mm.plugin.report.f)localObject).idkeyStat(99L, l, 1L, false);
      Log.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", new Object[] { Integer.valueOf(paramb.RBX.Saq), Boolean.valueOf(this.lSH), Boolean.valueOf(bool), Boolean.valueOf(lTA), Integer.valueOf(this.lSE), Boolean.valueOf(this.lTF), this.lTC });
      if ((this.lSH) || (!bool)) {
        break label491;
      }
      this.lTF = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
      bool = false;
      break;
    }
    label491:
    int i;
    if (lTA)
    {
      Log.i(this.TAG, "dkpush new notify pending, sync now");
      if (lTD != 0)
      {
        i = lTD;
        h.aHH();
        h.aHE();
        com.tencent.mm.booter.g.cI(i, b.getUin());
      }
      lTD = 0;
      this.lTC = null;
      lTA = false;
      this.lTF = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
    }
    if (this.lTC != null)
    {
      i = lTD;
      h.aHH();
      h.aHE();
      com.tencent.mm.booter.g.cI(i, b.getUin());
      this.lTC = null;
      bng();
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
    }
    if ((this.lSE & 0x1) > 0)
    {
      h.aHH();
      paramb = Util.decodeHexString(Util.nullAsNil((String)h.aHG().aHp().b(8195, null)));
      h.aGY().a(new g(this.lSG, paramb), 0);
    }
    Log.d(this.TAG, "sync or init end: reset selector : now = " + fFT + " default = 7");
    fFT = 7;
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
    if ((!paramq.lTB) && (lTA))
    {
      Log.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", new Object[] { Long.valueOf(paramq.lastdispatch) });
      if (Util.ticksToNow(paramq.lastdispatch) > 360000L) {}
      while (bool)
      {
        Log.i(this.TAG, "summerworker NetSceneSync timeout");
        if (h.aHJ().findTaskByRunTime(false, 0L) == null) {
          break;
        }
        Log.e(this.TAG, "summerworker worker is just blocked by task: " + h.aHJ().dump(false, false));
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
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 229L, 1L, false);
    this.lTb = true;
    AppMethodBeat.o(132578);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(132579);
    if (l.bni())
    {
      lTD = 0;
      Log.e(this.TAG, "dkinit never do sync before init done");
      AppMethodBeat.o(132579);
      return -1;
    }
    this.callback = parami;
    if (this.lTz == null) {
      this.lTz = new r();
    }
    this.lTz.dgo = CrashReportFactory.foreground;
    if (this.lTC != null)
    {
      Log.i(this.TAG, "pushSyncRespHandler not null");
      prepareDispatcher(paramg);
      this.lTC.startTimer(0L);
      AppMethodBeat.o(132579);
      return 0;
    }
    if (lTD > 0)
    {
      Log.w(this.TAG, "other sync is dealing with resp data :%d", new Object[] { Integer.valueOf(lTD) });
      AppMethodBeat.o(132579);
      return -1;
    }
    if (this.lAo != null)
    {
      Log.i(this.TAG, "pusher not null");
      prepareDispatcher(paramg);
      this.lAo.startTimer(0L);
      AppMethodBeat.o(132579);
      return 0;
    }
    parami = new a();
    dcq localdcq = ((v.a)parami.getReqObj()).RBW;
    if (this.lTE == 3)
    {
      localdcq.TKB = 1;
      if (!this.lTF) {
        break label381;
      }
    }
    label381:
    for (int i = 6;; i = this.lTE)
    {
      this.lTE = i;
      localdcq.SfH = fFT;
      h.aHH();
      byte[] arrayOfByte = Util.decodeHexString(Util.nullAsNil((String)h.aHG().aHp().b(8195, new byte[0])));
      localdcq.SfI = z.aN(arrayOfByte);
      localdcq.CPw = this.lTE;
      localdcq.TKA = new abv();
      localdcq.RMK = d.kQZ;
      Log.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", new Object[] { Integer.valueOf(localdcq.SfH), Integer.valueOf(localdcq.CPw), ad.db(arrayOfByte) });
      lTA = false;
      i = dispatch(paramg, parami, this);
      AppMethodBeat.o(132579);
      return i;
      localdcq.TKB = 0;
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
    long l = this.khd.avE();
    boolean bool = this.lSH;
    if (localb.RBX.SfL == null)
    {
      paramInt1 = -1;
      Log.i(paramArrayOfByte, "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(l), Boolean.valueOf(bool), Integer.valueOf(paramInt1), this.lAo, this.lTC });
      if (localb.RBX.SfL != null) {
        break label381;
      }
      paramInt1 = -1;
      label205:
      if (paramInt1 <= 0) {
        break label396;
      }
      paramInt1 = 1;
      label211:
      if (bnh()) {
        break label409;
      }
      paramArrayOfByte = com.tencent.mm.plugin.report.f.Iyx;
      if (paramInt1 == 0) {
        break label401;
      }
      l = 221L;
      label232:
      paramArrayOfByte.idkeyStat(99L, l, 1L, false);
      this.lAo = null;
      this.lTB = true;
      if ((paramInt2 != 4) || (paramInt3 != -2006)) {
        break label872;
      }
      bool = true;
      paramInt2 = 0;
      paramInt3 = 0;
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 227L, 1L, false);
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        if (this.lTH != null)
        {
          Log.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
          this.errType = paramInt2;
          this.errCode = paramInt3;
          this.errMsg = paramString;
          ((v.b)params.getRespObj()).RBX.Saq = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 232L, 1L, false);
          AppMethodBeat.o(132581);
          return;
          paramInt1 = localb.RBX.SfL.rVx;
          break;
          label381:
          paramInt1 = localb.RBX.SfL.rVx;
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
            paramArrayOfByte = com.tencent.mm.plugin.report.f.Iyx;
            if (paramInt1 != 0) {}
            for (l = 220L;; l = 217L)
            {
              paramArrayOfByte.idkeyStat(99L, l, 1L, false);
              break;
            }
          }
          paramArrayOfByte = com.tencent.mm.plugin.report.f.Iyx;
          if (paramInt1 != 0) {}
          for (l = 219L;; l = 216L)
          {
            paramArrayOfByte.idkeyStat(99L, l, 1L, false);
            break;
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 233L, 1L, false);
      paramArrayOfByte = z.a(((v.a)params.getReqObj()).RBW.SfI);
      params = z.a(localb.RBX.SfI);
      Log.i(this.TAG, "onGYNetEnd replace key:%b req :%s", new Object[] { Boolean.valueOf(bool), ad.db(paramArrayOfByte) });
      Log.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", new Object[] { Boolean.valueOf(bool), ad.db(params) });
      if (!bool)
      {
        paramString = paramArrayOfByte;
        if (Util.isNullOrNil(paramArrayOfByte))
        {
          h.aHH();
          paramString = Util.decodeHexString(Util.nullAsNil((String)h.aHG().aHp().b(8195, "")));
          paramArrayOfByte = this.TAG;
          if (paramString == null)
          {
            paramInt1 = -1;
            Log.d(paramArrayOfByte, "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramInt1), Util.dumpHex(paramString) });
          }
        }
        else
        {
          paramArrayOfByte = ad.n(paramString, params);
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
          localb.RBX.SfI = z.aN(paramString);
        }
      }
      else
      {
        h.aHH();
        h.aHE().dp(localb.RBX.rVU, localb.RBX.TKC);
        h.aHH();
        h.aHE();
        b.sB(localb.RBX.rVU);
        if (this.lTH != null) {
          break label866;
        }
      }
      label866:
      for (bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.lTH = localb;
        this.lTI = Util.nowMilliSecond();
        new MTimerHandler(h.aHJ().getLooper(), new MTimerHandler.CallBack()
        {
          private int lTL = 0;
          private long lTM = 0L;
          private int lTN = 0;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(132571);
            Object localObject2 = new c();
            if (!h.aHB())
            {
              Log.e(k.b(k.this), "syncRespHandler acc is not ready STOP :%s", new Object[] { k.c(k.this) });
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            if (k.e(k.this))
            {
              ((c)localObject2).dE(k.this);
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            if ((k.c(k.this) == null) || (k.c(k.this).RBX.SfL == null) || (k.c(k.this).RBX.SfL.rVy == null))
            {
              Log.e(k.b(k.this), "syncRespHandler CmdList is null! Stop Processing :%s", new Object[] { k.c(k.this) });
              ((c)localObject2).dE(k.this);
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            Object localObject1 = k.c(k.this).RBX.SfL.rVy;
            ((c)localObject2).dC(k.this);
            this.lTN += 1;
            long l1 = Util.nowMilliSecond();
            int i = 0;
            while (i < 5)
            {
              if (this.lTL < ((LinkedList)localObject1).size())
              {
                Log.v(k.b(k.this), "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.lTL), Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((abu)((LinkedList)localObject1).get(this.lTL)).SnG), Integer.valueOf(((abu)((LinkedList)localObject1).get(this.lTL)).SnH.Ufv) });
                ((LinkedList)localObject1).size();
                if (!((c)localObject2).a((abu)((LinkedList)localObject1).get(this.lTL), false)) {
                  Log.w(k.b(k.this), "DoCmd Failed index:%d", new Object[] { Integer.valueOf(this.lTL) });
                }
                this.lTL += 1;
              }
              if (this.lTL >= ((LinkedList)localObject1).size())
              {
                this.lTM += Util.milliSecondsToNow(l1);
                l2 = Util.milliSecondsToNow(k.f(k.this));
                Log.i(k.b(k.this), "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", new Object[] { Integer.valueOf(this.lTL), Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(l2), Long.valueOf(this.lTM), Integer.valueOf(this.lTN), k.c(k.this) });
                k.this.a(k.c(k.this));
                ((c)localObject2).dD(k.this);
                i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.f.a((int)this.lTM, new int[] { 100, 300, 1000, 3000 }, new Integer[] { Integer.valueOf(240), Integer.valueOf(239), Integer.valueOf(238), Integer.valueOf(237), Integer.valueOf(236) }));
                com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, i, 1L, false);
                i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.f.a(((LinkedList)localObject1).size(), new int[] { 0, 1, 2, 3, 5, 10 }, new Integer[] { Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(247), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243) }));
                com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, i, 1L, false);
                localObject2 = com.tencent.mm.plugin.report.f.Iyx;
                int j;
                int k;
                int m;
                int n;
                if (CrashReportFactory.foreground)
                {
                  l1 = 241L;
                  ((com.tencent.mm.plugin.report.f)localObject2).idkeyStat(99L, l1, 1L, false);
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, k.g(k.this), 1L, false);
                  com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 0L, 1L, false);
                  localObject2 = com.tencent.mm.plugin.report.f.Iyx;
                  j = ((LinkedList)localObject1).size();
                  k = k.g(k.this);
                  m = k.c(k.this).RBX.Saq;
                  l1 = this.lTM;
                  n = this.lTN;
                  localObject1 = k.h(k.this);
                  if (!CrashReportFactory.foreground) {
                    break label987;
                  }
                }
                label987:
                for (i = 1;; i = 2)
                {
                  ((com.tencent.mm.plugin.report.f)localObject2).a(12063, new Object[] { Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Integer.valueOf(n), localObject1, Integer.valueOf(i) });
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
                Log.d(k.b(k.this), "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(this.lTL), k.c(k.this) });
                this.lTM += Util.milliSecondsToNow(l1);
                AppMethodBeat.o(132571);
                return true;
              }
              i += 1;
            }
            this.lTM += Util.milliSecondsToNow(l1);
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
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(99L, 228L, 1L, false);
      localf = com.tencent.mm.plugin.report.f.Iyx;
      if (!CrashReportFactory.foreground) {
        break label126;
      }
    }
    for (;;)
    {
      localf.a(12063, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), "9999" });
      AppMethodBeat.o(132577);
      return bool;
      label126:
      i = 2;
    }
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends o
  {
    private final v.a lSK;
    private final v.b lSL;
    private final boolean lSM;
    
    public a()
    {
      AppMethodBeat.i(132572);
      this.lSK = new v.a();
      this.lSL = new v.b();
      this.lSM = false;
      AppMethodBeat.o(132572);
    }
    
    public a(v.b paramb)
    {
      AppMethodBeat.i(132573);
      this.lSK = new v.a();
      this.lSL = paramb;
      this.lSM = true;
      AppMethodBeat.o(132573);
    }
    
    public final boolean getPush()
    {
      return this.lSM;
    }
    
    public final l.d getReqObjImp()
    {
      return this.lSK;
    }
    
    public final l.e getRespObj()
    {
      return this.lSL;
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