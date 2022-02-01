package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bya;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.lang.reflect.Method;
import java.util.LinkedList;
import junit.framework.Assert;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  protected static int hLw = 7;
  private static boolean hMt = false;
  private static int hMw = 0;
  public String TAG;
  private com.tencent.mm.ak.g callback;
  private int errCode;
  private String errMsg;
  private int errType;
  private f.a gma;
  private boolean hLA;
  private boolean hLV;
  private int hLx;
  private long hLz;
  public v.b hMA;
  private long hMB;
  public q hMs;
  private boolean hMu;
  private au hMv;
  private int hMx;
  private boolean hMy;
  private String hMz;
  private au htR;
  
  public k(int paramInt)
  {
    AppMethodBeat.i(132574);
    this.TAG = "MicroMsg.NetSceneSync";
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.hMs = null;
    this.hMu = false;
    this.hLx = 0;
    this.htR = null;
    this.hMv = null;
    this.hLz = -1L;
    this.hLA = false;
    this.hMy = false;
    this.hLV = false;
    this.hMz = "";
    this.hMA = null;
    this.hMB = 0L;
    this.TAG = (this.TAG + "[" + hashCode() + "]");
    ac.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", new Object[] { Integer.valueOf(paramInt), bs.eWi() });
    this.hMz = as.eVo();
    this.gma = new f.a();
    if (this.hMs == null) {
      this.hMs = new q();
    }
    this.hMs.hNy = paramInt;
    com.tencent.mm.kernel.g.agS();
    if ((com.tencent.mm.kernel.g.agR() != null) && (com.tencent.mm.kernel.g.agM()))
    {
      com.tencent.mm.kernel.g.agS();
      if ((com.tencent.mm.kernel.g.agR().agA() != null) && (!com.tencent.mm.kernel.a.afS()))
      {
        com.tencent.mm.kernel.g.agS();
        long l = bs.a((Long)com.tencent.mm.kernel.g.agR().agA().get(8196, null), 0L);
        if (l != 0L)
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(8196, Long.valueOf(0L));
          int i = (int)(l | hLw);
          hLw = i;
          hLw = i & 0x5F;
        }
      }
    }
    if (paramInt == 1) {
      hMt = true;
    }
    if (paramInt == 1010)
    {
      hLw |= 0x10;
      hMt = true;
      this.hMx = 7;
    }
    for (;;)
    {
      if (hMw == 0) {
        aGh();
      }
      AppMethodBeat.o(132574);
      return;
      if (paramInt == 1011)
      {
        hLw |= 0x40;
        hMt = true;
        this.hMx = 7;
      }
      else if (paramInt == 3)
      {
        hLw |= 0x40000;
        hMt = true;
        this.hMx = 3;
        ac.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hLw), Integer.valueOf(this.hMx) });
      }
      else
      {
        this.hMx = paramInt;
      }
    }
  }
  
  public k(final v.b paramb, int paramInt, long paramLong)
  {
    this(8);
    AppMethodBeat.i(132575);
    this.hMz = as.eVo();
    ac.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", new Object[] { Long.valueOf(paramb.getBufferSize()), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    this.hLx = paramInt;
    this.hLz = paramLong;
    this.htR = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132569);
        k.a(k.this);
        k.a locala = new k.a(paramb);
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 230L, 1L, false);
        k.this.onGYNetEnd(-1, 0, 0, "", locala, null);
        AppMethodBeat.o(132569);
        return false;
      }
    }, false);
    if (hMw == 0) {
      aGh();
    }
    AppMethodBeat.o(132575);
  }
  
  private boolean aGh()
  {
    AppMethodBeat.i(132580);
    Object localObject2 = new PInt();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP();
    Object localObject1 = com.tencent.mm.booter.g.a((PInt)localObject2, com.tencent.mm.kernel.a.getUin());
    String str = this.TAG;
    int j = ((PInt)localObject2).value;
    int k = hashCode();
    if (localObject1 != null) {}
    for (int i = localObject1.length;; i = 0)
    {
      ac.i(str, "dealWithRespData index:%d, hashcode:%d, buf.len:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      hMw = ((PInt)localObject2).value;
      if ((((PInt)localObject2).value != 0) && (!bs.cv((byte[])localObject1))) {
        break;
      }
      hMw = 0;
      AppMethodBeat.o(132580);
      return false;
    }
    localObject2 = new v.b();
    try
    {
      ((v.b)localObject2).fromProtoBuf((byte[])localObject1);
      localObject1 = new a((v.b)localObject2);
      this.hMv = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(132570);
          k.a(k.this);
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 231L, 1L, false);
          k.this.onGYNetEnd(-1, 0, 0, "", this.hMD, null);
          AppMethodBeat.o(132570);
          return false;
        }
      }, false);
      AppMethodBeat.o(132580);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 226L, 1L, false);
      ac.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
      i = hMw;
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.booter.g.cm(i, com.tencent.mm.kernel.a.getUin());
      hMw = 0;
      AppMethodBeat.o(132580);
      return false;
    }
    catch (Error localError)
    {
      long l1 = Runtime.getRuntime().freeMemory() / 1000L;
      long l2 = Runtime.getRuntime().totalMemory() / 1000L;
      ac.i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
      Assert.assertTrue("dealWithRespData error", false);
      AppMethodBeat.o(132580);
    }
    return false;
  }
  
  private boolean aGi()
  {
    AppMethodBeat.i(132583);
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)ai.getContext().getSystemService("power"), new Object[0])).booleanValue();
      AppMethodBeat.o(132583);
      return bool;
    }
    catch (Exception localException)
    {
      ac.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, bs.m(localException) });
      AppMethodBeat.o(132583);
    }
    return true;
  }
  
  protected final void a(v.b paramb)
  {
    AppMethodBeat.i(132582);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(8195, bs.cx(z.a(paramb.DJr.Eki)));
    ai.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.YK()).edit().putString("notify_sync_key_keybuf", bs.cx(z.a(paramb.DJr.Eki))).commit();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(8196, Long.valueOf(paramb.DJr.EfS));
    boolean bool;
    Object localObject;
    if (((paramb.DJr.EfS & hLw) != 0) && (!super.securityLimitCountReach()))
    {
      bool = true;
      ac.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramb.DJr.EfS), Integer.valueOf(hLw), Boolean.valueOf(super.securityLimitCountReach()) });
      if ((!bool) && ((paramb.DJr.EfS & 0x100) != 0))
      {
        localObject = new uj();
        ((uj)localObject).dxb.sourceType = 1;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if ((!bool) && ((paramb.DJr.EfS & 0x200000) != 0))
      {
        localObject = new nx();
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if ((!bool) && ((paramb.DJr.EfS & 0x1000000) != 0))
      {
        localObject = new hi();
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      }
      localObject = com.tencent.mm.plugin.report.e.wTc;
      if (!bool) {
        break label448;
      }
    }
    label448:
    for (long l = 234L;; l = 235L)
    {
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(99L, l, 1L, false);
      ac.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", new Object[] { Integer.valueOf(paramb.DJr.EfS), Boolean.valueOf(this.hLA), Boolean.valueOf(bool), Boolean.valueOf(hMt), Integer.valueOf(this.hLx), Boolean.valueOf(this.hMy), this.hMv });
      if ((this.hLA) || (!bool)) {
        break label456;
      }
      this.hMy = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
      bool = false;
      break;
    }
    label456:
    int i;
    if (hMt)
    {
      ac.i(this.TAG, "dkpush new notify pending, sync now");
      if (hMw != 0)
      {
        i = hMw;
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.booter.g.cm(i, com.tencent.mm.kernel.a.getUin());
      }
      hMw = 0;
      this.hMv = null;
      hMt = false;
      this.hMy = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
    }
    if (this.hMv != null)
    {
      i = hMw;
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.booter.g.cm(i, com.tencent.mm.kernel.a.getUin());
      this.hMv = null;
      aGh();
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
    }
    if ((this.hLx & 0x1) > 0)
    {
      com.tencent.mm.kernel.g.agS();
      paramb = bs.aLu(bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(8195, null)));
      com.tencent.mm.kernel.g.agi().a(new g(this.hLz, paramb), 0);
    }
    ac.d(this.TAG, "sync or init end: reset selector : now = " + hLw + " default = 7");
    hLw = 7;
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
    if ((!paramn.hMu) && (hMt))
    {
      ac.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", new Object[] { Long.valueOf(paramn.lastdispatch) });
      label111:
      String str;
      StringBuilder localStringBuilder;
      if (bs.aO(paramn.lastdispatch) > 360000L)
      {
        if (!bool) {
          break label192;
        }
        ac.i(this.TAG, "summerworker NetSceneSync timeout");
        paramn = com.tencent.mm.kernel.g.agU().cOC().getRunningMessage();
        if (paramn != null) {
          break label176;
        }
        paramn = null;
        if (paramn == null) {
          break label192;
        }
        str = this.TAG;
        localStringBuilder = new StringBuilder("summerworker worker is just blocked by task: ");
        paramn = com.tencent.mm.kernel.g.agU().cOC().getRunningMessage();
        if (paramn != null) {
          break label184;
        }
      }
      label176:
      label184:
      for (paramn = localObject;; paramn = paramn.toString())
      {
        ac.e(str, paramn);
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
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 229L, 1L, false);
    this.hLV = true;
    AppMethodBeat.o(132578);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(132579);
    if (l.aGj())
    {
      hMw = 0;
      ac.e(this.TAG, "dkinit never do sync before init done");
      AppMethodBeat.o(132579);
      return -1;
    }
    this.callback = paramg;
    if (this.hMs == null) {
      this.hMs = new q();
    }
    this.hMs.cqM = com.tencent.mm.sdk.a.b.foreground;
    if (this.hMv != null)
    {
      ac.i(this.TAG, "pushSyncRespHandler not null");
      prepareDispatcher(parame);
      this.hMv.au(0L, 0L);
      AppMethodBeat.o(132579);
      return 0;
    }
    if (hMw > 0)
    {
      ac.w(this.TAG, "other sync is dealing with resp data :%d", new Object[] { Integer.valueOf(hMw) });
      AppMethodBeat.o(132579);
      return -1;
    }
    if (this.htR != null)
    {
      ac.i(this.TAG, "pusher not null");
      prepareDispatcher(parame);
      this.htR.au(0L, 0L);
      AppMethodBeat.o(132579);
      return 0;
    }
    paramg = new a();
    bya localbya = ((v.a)paramg.getReqObj()).DJq;
    if (this.hMx == 3)
    {
      localbya.Fnl = 1;
      if (!this.hMy) {
        break label383;
      }
    }
    label383:
    for (int i = 6;; i = this.hMx)
    {
      this.hMx = i;
      localbya.Ekh = hLw;
      com.tencent.mm.kernel.g.agS();
      byte[] arrayOfByte = bs.aLu(bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(8195, new byte[0])));
      localbya.Eki = z.al(arrayOfByte);
      localbya.Scene = this.hMx;
      localbya.Fnk = new xw();
      localbya.DUp = d.gMK;
      ac.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", new Object[] { Integer.valueOf(localbya.Ekh), Integer.valueOf(localbya.Scene), ad.cj(arrayOfByte) });
      hMt = false;
      i = dispatch(parame, paramg, this);
      AppMethodBeat.o(132579);
      return i;
      localbya.Fnl = 0;
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
        ac.e(paramString, "onGYNetEnd error type:%d", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(132581);
        return;
      }
    }
    v.b localb = (v.b)paramq.getRespObj();
    paramArrayOfByte = this.TAG;
    long l = this.gma.YH();
    boolean bool = this.hLA;
    if (localb.DJr.Ekl == null)
    {
      paramInt1 = -1;
      ac.i(paramArrayOfByte, "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(l), Boolean.valueOf(bool), Integer.valueOf(paramInt1), this.htR, this.hMv });
      if (localb.DJr.Ekl != null) {
        break label381;
      }
      paramInt1 = -1;
      label205:
      if (paramInt1 <= 0) {
        break label396;
      }
      paramInt1 = 1;
      label211:
      if (aGi()) {
        break label409;
      }
      paramArrayOfByte = com.tencent.mm.plugin.report.e.wTc;
      if (paramInt1 == 0) {
        break label401;
      }
      l = 221L;
      label232:
      paramArrayOfByte.idkeyStat(99L, l, 1L, false);
      this.htR = null;
      this.hMu = true;
      if ((paramInt2 != 4) || (paramInt3 != -2006)) {
        break label863;
      }
      bool = true;
      paramInt2 = 0;
      paramInt3 = 0;
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 227L, 1L, false);
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        if (this.hMA != null)
        {
          ac.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
          this.errType = paramInt2;
          this.errCode = paramInt3;
          this.errMsg = paramString;
          ((v.b)paramq.getRespObj()).DJr.EfS = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 232L, 1L, false);
          AppMethodBeat.o(132581);
          return;
          paramInt1 = localb.DJr.Ekl.ncL;
          break;
          label381:
          paramInt1 = localb.DJr.Ekl.ncL;
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
            paramArrayOfByte = com.tencent.mm.plugin.report.e.wTc;
            if (paramInt1 != 0) {}
            for (l = 220L;; l = 217L)
            {
              paramArrayOfByte.idkeyStat(99L, l, 1L, false);
              break;
            }
          }
          paramArrayOfByte = com.tencent.mm.plugin.report.e.wTc;
          if (paramInt1 != 0) {}
          for (l = 219L;; l = 216L)
          {
            paramArrayOfByte.idkeyStat(99L, l, 1L, false);
            break;
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 233L, 1L, false);
      paramArrayOfByte = z.a(((v.a)paramq.getReqObj()).DJq.Eki);
      paramq = z.a(localb.DJr.Eki);
      ac.i(this.TAG, "onGYNetEnd replace key:%b req :%s", new Object[] { Boolean.valueOf(bool), ad.cj(paramArrayOfByte) });
      ac.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", new Object[] { Boolean.valueOf(bool), ad.cj(paramq) });
      if (!bool)
      {
        paramString = paramArrayOfByte;
        if (bs.cv(paramArrayOfByte))
        {
          com.tencent.mm.kernel.g.agS();
          paramString = bs.aLu(bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(8195, new byte[0])));
          ac.d(this.TAG, "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramString.length), bs.cu(paramString) });
        }
        paramArrayOfByte = ad.k(paramString, paramq);
        if (paramArrayOfByte != null)
        {
          paramString = paramArrayOfByte;
          if (paramArrayOfByte.length > 0) {}
        }
        else
        {
          ac.w(this.TAG, "merge key failed, use server side instead");
          paramString = paramq;
        }
        localb.DJr.Eki = z.al(paramString);
      }
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agP().cM(localb.DJr.ndj, localb.DJr.Fnm);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.kernel.a.mn(localb.DJr.ndj);
      if (this.hMA == null) {}
      for (bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.hMA = localb;
        this.hMB = bs.eWj();
        new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
        {
          private int hME = 0;
          private long hMF = 0L;
          private int hMG = 0;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(132571);
            Object localObject2 = new c();
            if (!com.tencent.mm.kernel.g.agM())
            {
              ac.e(k.b(k.this), "syncRespHandler acc is not ready STOP :%s", new Object[] { k.c(k.this) });
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            if (k.e(k.this))
            {
              ((c)localObject2).dq(k.this);
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            if ((k.c(k.this) == null) || (k.c(k.this).DJr.Ekl == null) || (k.c(k.this).DJr.Ekl.ncM == null))
            {
              ac.e(k.b(k.this), "syncRespHandler CmdList is null! Stop Processing :%s", new Object[] { k.c(k.this) });
              ((c)localObject2).dq(k.this);
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            Object localObject1 = k.c(k.this).DJr.Ekl.ncM;
            ((c)localObject2).jdMethod_do(k.this);
            this.hMG += 1;
            long l1 = bs.eWj();
            int i = 0;
            while (i < 5)
            {
              if (this.hME < ((LinkedList)localObject1).size())
              {
                ac.v(k.b(k.this), "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.hME), Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((xv)((LinkedList)localObject1).get(this.hME)).ErL), Integer.valueOf(((xv)((LinkedList)localObject1).get(this.hME)).ErM.getILen()) });
                ((LinkedList)localObject1).size();
                if (!((c)localObject2).a((xv)((LinkedList)localObject1).get(this.hME), false)) {
                  ac.w(k.b(k.this), "DoCmd Failed index:%d", new Object[] { Integer.valueOf(this.hME) });
                }
                this.hME += 1;
              }
              if (this.hME >= ((LinkedList)localObject1).size())
              {
                this.hMF += bs.Ap(l1);
                l2 = bs.Ap(k.f(k.this));
                ac.i(k.b(k.this), "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", new Object[] { Integer.valueOf(this.hME), Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(l2), Long.valueOf(this.hMF), Integer.valueOf(this.hMG), k.c(k.this) });
                k.this.a(k.c(k.this));
                ((c)localObject2).dp(k.this);
                i = bs.m((Integer)com.tencent.mm.plugin.report.e.a((int)this.hMF, new int[] { 100, 300, 1000, 3000 }, new Integer[] { Integer.valueOf(240), Integer.valueOf(239), Integer.valueOf(238), Integer.valueOf(237), Integer.valueOf(236) }));
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, i, 1L, false);
                i = bs.m((Integer)com.tencent.mm.plugin.report.e.a(((LinkedList)localObject1).size(), new int[] { 0, 1, 2, 3, 5, 10 }, new Integer[] { Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(247), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243) }));
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, i, 1L, false);
                localObject2 = com.tencent.mm.plugin.report.e.wTc;
                int j;
                int k;
                int m;
                int n;
                if (com.tencent.mm.sdk.a.b.foreground)
                {
                  l1 = 241L;
                  ((com.tencent.mm.plugin.report.e)localObject2).idkeyStat(99L, l1, 1L, false);
                  com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, k.g(k.this), 1L, false);
                  com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 0L, 1L, false);
                  localObject2 = com.tencent.mm.plugin.report.e.wTc;
                  j = ((LinkedList)localObject1).size();
                  k = k.g(k.this);
                  m = k.c(k.this).DJr.EfS;
                  l1 = this.hMF;
                  n = this.hMG;
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
              long l2 = bs.Ap(l1);
              if (l2 > 500L)
              {
                ac.d(k.b(k.this), "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(this.hME), k.c(k.this) });
                this.hMF += bs.Ap(l1);
                AppMethodBeat.o(132571);
                return true;
              }
              i += 1;
            }
            this.hMF += bs.Ap(l1);
            AppMethodBeat.o(132571);
            return true;
          }
        }, true).au(50L, 50L);
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
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(99L, 228L, 1L, false);
      locale = com.tencent.mm.plugin.report.e.wTc;
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
    return n.b.hwa;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends com.tencent.mm.ak.l
  {
    private final v.a hLD;
    private final v.b hLE;
    private final boolean hLF;
    
    public a()
    {
      AppMethodBeat.i(132572);
      this.hLD = new v.a();
      this.hLE = new v.b();
      this.hLF = false;
      AppMethodBeat.o(132572);
    }
    
    public a(v.b paramb)
    {
      AppMethodBeat.i(132573);
      this.hLD = new v.a();
      this.hLE = paramb;
      this.hLF = true;
      AppMethodBeat.o(132573);
    }
    
    public final boolean getPush()
    {
      return this.hLF;
    }
    
    public final l.d getReqObjImp()
    {
      return this.hLD;
    }
    
    public final l.e getRespObj()
    {
      return this.hLE;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.k
 * JD-Core Version:    0.7.0.1
 */