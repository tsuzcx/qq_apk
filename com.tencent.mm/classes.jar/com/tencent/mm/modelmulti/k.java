package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cdl;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.lang.reflect.Method;
import java.util.LinkedList;
import junit.framework.Assert;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  protected static int dvk = 7;
  private static boolean iig = false;
  private static int iij = 0;
  public String TAG;
  private f callback;
  private int errCode;
  private String errMsg;
  private int errType;
  private f.a gIr;
  private aw hPc;
  private boolean ihH;
  private int ihj;
  private long ihl;
  private boolean ihm;
  public r iif;
  private boolean iih;
  private aw iii;
  private int iik;
  private boolean iil;
  private String iim;
  public v.b iin;
  private long iio;
  
  public k(int paramInt)
  {
    AppMethodBeat.i(132574);
    this.TAG = "MicroMsg.NetSceneSync";
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.iif = null;
    this.iih = false;
    this.ihj = 0;
    this.hPc = null;
    this.iii = null;
    this.ihl = -1L;
    this.ihm = false;
    this.iil = false;
    this.ihH = false;
    this.iim = "";
    this.iin = null;
    this.iio = 0L;
    this.TAG = (this.TAG + "[" + hashCode() + "]");
    ae.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", new Object[] { Integer.valueOf(paramInt), bu.fpN() });
    this.iim = au.foQ();
    this.gIr = new f.a();
    if (this.iif == null) {
      this.iif = new r();
    }
    this.iif.ijF = paramInt;
    com.tencent.mm.kernel.g.ajS();
    if ((com.tencent.mm.kernel.g.ajR() != null) && (com.tencent.mm.kernel.g.ajM()))
    {
      com.tencent.mm.kernel.g.ajS();
      if ((com.tencent.mm.kernel.g.ajR().ajA() != null) && (!com.tencent.mm.kernel.a.aiT()))
      {
        com.tencent.mm.kernel.g.ajS();
        long l = bu.a((Long)com.tencent.mm.kernel.g.ajR().ajA().get(8196, null), 0L);
        if (l != 0L)
        {
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(8196, Long.valueOf(0L));
          int i = (int)(l | dvk);
          dvk = i;
          dvk = i & 0x5F;
        }
      }
    }
    if (paramInt == 1) {
      iig = true;
    }
    if (paramInt == 1010)
    {
      dvk |= 0x10;
      iig = true;
      this.iik = 7;
    }
    for (;;)
    {
      if (iij == 0) {
        aJJ();
      }
      AppMethodBeat.o(132574);
      return;
      if (paramInt == 1011)
      {
        dvk |= 0x40;
        iig = true;
        this.iik = 7;
      }
      else if (paramInt == 3)
      {
        dvk |= 0x40000;
        iig = true;
        this.iik = 3;
        ae.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(dvk), Integer.valueOf(this.iik) });
      }
      else
      {
        this.iik = paramInt;
      }
    }
  }
  
  public k(final v.b paramb, int paramInt, long paramLong)
  {
    this(8);
    AppMethodBeat.i(132575);
    this.iim = au.foQ();
    ae.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", new Object[] { Long.valueOf(paramb.getBufferSize()), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    this.ihj = paramInt;
    this.ihl = paramLong;
    this.hPc = new aw(com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132569);
        k.a(k.this);
        k.a locala = new k.a(paramb);
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 230L, 1L, false);
        k.this.onGYNetEnd(-1, 0, 0, "", locala, null);
        AppMethodBeat.o(132569);
        return false;
      }
    }, false);
    if (iij == 0) {
      aJJ();
    }
    AppMethodBeat.o(132575);
  }
  
  private boolean aJJ()
  {
    AppMethodBeat.i(132580);
    Object localObject2 = new PInt();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP();
    Object localObject1 = com.tencent.mm.booter.g.a((PInt)localObject2, com.tencent.mm.kernel.a.getUin());
    String str = this.TAG;
    int j = ((PInt)localObject2).value;
    int k = hashCode();
    if (localObject1 != null) {}
    for (int i = localObject1.length;; i = 0)
    {
      ae.i(str, "dealWithRespData index:%d, hashcode:%d, buf.len:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      iij = ((PInt)localObject2).value;
      if ((((PInt)localObject2).value != 0) && (!bu.cF((byte[])localObject1))) {
        break;
      }
      iij = 0;
      AppMethodBeat.o(132580);
      return false;
    }
    localObject2 = new v.b();
    try
    {
      ((v.b)localObject2).fromProtoBuf((byte[])localObject1);
      localObject1 = new a((v.b)localObject2);
      this.iii = new aw(com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(132570);
          k.a(k.this);
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 231L, 1L, false);
          k.this.onGYNetEnd(-1, 0, 0, "", this.iiq, null);
          AppMethodBeat.o(132570);
          return false;
        }
      }, false);
      AppMethodBeat.o(132580);
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 226L, 1L, false);
      ae.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
      i = iij;
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
      iij = 0;
      AppMethodBeat.o(132580);
      return false;
    }
    catch (Error localError)
    {
      long l1 = Runtime.getRuntime().freeMemory() / 1000L;
      long l2 = Runtime.getRuntime().totalMemory() / 1000L;
      ae.i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
      Assert.assertTrue("dealWithRespData error", false);
      AppMethodBeat.o(132580);
    }
    return false;
  }
  
  private boolean aJK()
  {
    AppMethodBeat.i(132583);
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)ak.getContext().getSystemService("power"), new Object[0])).booleanValue();
      AppMethodBeat.o(132583);
      return bool;
    }
    catch (Exception localException)
    {
      ae.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[] { Boolean.TRUE, bu.o(localException) });
      AppMethodBeat.o(132583);
    }
    return true;
  }
  
  protected final void a(v.b paramb)
  {
    AppMethodBeat.i(132582);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(8195, bu.cH(z.a(paramb.FGW.GjQ)));
    ak.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.abv()).edit().putString("notify_sync_key_keybuf", bu.cH(z.a(paramb.FGW.GjQ))).commit();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(8196, Long.valueOf(paramb.FGW.GeQ));
    boolean bool;
    Object localObject;
    if (((paramb.FGW.GeQ & dvk) != 0) && (!super.securityLimitCountReach()))
    {
      bool = true;
      ae.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramb.FGW.GeQ), Integer.valueOf(dvk), Boolean.valueOf(super.securityLimitCountReach()) });
      if ((!bool) && ((paramb.FGW.GeQ & 0x100) != 0))
      {
        localObject = new vg();
        ((vg)localObject).dKB.sourceType = 1;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if ((!bool) && ((paramb.FGW.GeQ & 0x200000) != 0))
      {
        localObject = new og();
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if ((!bool) && ((paramb.FGW.GeQ & 0x1000000) != 0))
      {
        localObject = new hq();
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      }
      if ((!bool) && ((paramb.FGW.GeQ & 0x20) != 0))
      {
        localObject = new com.tencent.mm.g.a.ar();
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      }
      localObject = com.tencent.mm.plugin.report.e.ywz;
      if (!bool) {
        break label483;
      }
    }
    label483:
    for (long l = 234L;; l = 235L)
    {
      ((com.tencent.mm.plugin.report.e)localObject).idkeyStat(99L, l, 1L, false);
      ae.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", new Object[] { Integer.valueOf(paramb.FGW.GeQ), Boolean.valueOf(this.ihm), Boolean.valueOf(bool), Boolean.valueOf(iig), Integer.valueOf(this.ihj), Boolean.valueOf(this.iil), this.iii });
      if ((this.ihm) || (!bool)) {
        break label491;
      }
      this.iil = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
      bool = false;
      break;
    }
    label491:
    int i;
    if (iig)
    {
      ae.i(this.TAG, "dkpush new notify pending, sync now");
      if (iij != 0)
      {
        i = iij;
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajP();
        com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
      }
      iij = 0;
      this.iii = null;
      iig = false;
      this.iil = true;
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
    }
    if (this.iii != null)
    {
      i = iij;
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.booter.g.co(i, com.tencent.mm.kernel.a.getUin());
      this.iii = null;
      aJJ();
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(132582);
      return;
    }
    if ((this.ihj & 0x1) > 0)
    {
      com.tencent.mm.kernel.g.ajS();
      paramb = bu.aSx(bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(8195, null)));
      com.tencent.mm.kernel.g.ajj().a(new g(this.ihl, paramb), 0);
    }
    ae.d(this.TAG, "sync or init end: reset selector : now = " + dvk + " default = 7");
    dvk = 7;
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
    if ((!paramn.iih) && (iig))
    {
      ae.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", new Object[] { Long.valueOf(paramn.lastdispatch) });
      label111:
      String str;
      StringBuilder localStringBuilder;
      if (bu.aO(paramn.lastdispatch) > 360000L)
      {
        if (!bool) {
          break label192;
        }
        ae.i(this.TAG, "summerworker NetSceneSync timeout");
        paramn = com.tencent.mm.kernel.g.ajU().cZF().getRunningMessage();
        if (paramn != null) {
          break label176;
        }
        paramn = null;
        if (paramn == null) {
          break label192;
        }
        str = this.TAG;
        localStringBuilder = new StringBuilder("summerworker worker is just blocked by task: ");
        paramn = com.tencent.mm.kernel.g.ajU().cZF().getRunningMessage();
        if (paramn != null) {
          break label184;
        }
      }
      label176:
      label184:
      for (paramn = localObject;; paramn = paramn.toString())
      {
        ae.e(str, paramn);
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
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 229L, 1L, false);
    this.ihH = true;
    AppMethodBeat.o(132578);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(132579);
    if (l.aJL())
    {
      iij = 0;
      ae.e(this.TAG, "dkinit never do sync before init done");
      AppMethodBeat.o(132579);
      return -1;
    }
    this.callback = paramf;
    if (this.iif == null) {
      this.iif = new r();
    }
    this.iif.cCq = com.tencent.mm.sdk.a.b.foreground;
    if (this.iii != null)
    {
      ae.i(this.TAG, "pushSyncRespHandler not null");
      prepareDispatcher(parame);
      this.iii.ay(0L, 0L);
      AppMethodBeat.o(132579);
      return 0;
    }
    if (iij > 0)
    {
      ae.w(this.TAG, "other sync is dealing with resp data :%d", new Object[] { Integer.valueOf(iij) });
      AppMethodBeat.o(132579);
      return -1;
    }
    if (this.hPc != null)
    {
      ae.i(this.TAG, "pusher not null");
      prepareDispatcher(parame);
      this.hPc.ay(0L, 0L);
      AppMethodBeat.o(132579);
      return 0;
    }
    paramf = new a();
    cdl localcdl = ((v.a)paramf.getReqObj()).FGV;
    if (this.iik == 3)
    {
      localcdl.Hqu = 1;
      if (!this.iil) {
        break label383;
      }
    }
    label383:
    for (int i = 6;; i = this.iik)
    {
      this.iik = i;
      localcdl.GjP = dvk;
      com.tencent.mm.kernel.g.ajS();
      byte[] arrayOfByte = bu.aSx(bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(8195, new byte[0])));
      localcdl.GjQ = z.al(arrayOfByte);
      localcdl.Scene = this.iik;
      localcdl.Hqt = new zy();
      localcdl.FSh = d.hjv;
      ae.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", new Object[] { Integer.valueOf(localcdl.GjP), Integer.valueOf(localcdl.Scene), ad.ct(arrayOfByte) });
      iig = false;
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(132579);
      return i;
      localcdl.Hqu = 0;
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
        ae.e(paramString, "onGYNetEnd error type:%d", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(132581);
        return;
      }
    }
    v.b localb = (v.b)paramq.getRespObj();
    paramArrayOfByte = this.TAG;
    long l = this.gIr.abs();
    boolean bool = this.ihm;
    if (localb.FGW.GjT == null)
    {
      paramInt1 = -1;
      ae.i(paramArrayOfByte, "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(l), Boolean.valueOf(bool), Integer.valueOf(paramInt1), this.hPc, this.iii });
      if (localb.FGW.GjT != null) {
        break label381;
      }
      paramInt1 = -1;
      label205:
      if (paramInt1 <= 0) {
        break label396;
      }
      paramInt1 = 1;
      label211:
      if (aJK()) {
        break label409;
      }
      paramArrayOfByte = com.tencent.mm.plugin.report.e.ywz;
      if (paramInt1 == 0) {
        break label401;
      }
      l = 221L;
      label232:
      paramArrayOfByte.idkeyStat(99L, l, 1L, false);
      this.hPc = null;
      this.iih = true;
      if ((paramInt2 != 4) || (paramInt3 != -2006)) {
        break label863;
      }
      bool = true;
      paramInt2 = 0;
      paramInt3 = 0;
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 227L, 1L, false);
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        if (this.iin != null)
        {
          ae.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
          this.errType = paramInt2;
          this.errCode = paramInt3;
          this.errMsg = paramString;
          ((v.b)paramq.getRespObj()).FGW.GeQ = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 232L, 1L, false);
          AppMethodBeat.o(132581);
          return;
          paramInt1 = localb.FGW.GjT.nID;
          break;
          label381:
          paramInt1 = localb.FGW.GjT.nID;
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
            paramArrayOfByte = com.tencent.mm.plugin.report.e.ywz;
            if (paramInt1 != 0) {}
            for (l = 220L;; l = 217L)
            {
              paramArrayOfByte.idkeyStat(99L, l, 1L, false);
              break;
            }
          }
          paramArrayOfByte = com.tencent.mm.plugin.report.e.ywz;
          if (paramInt1 != 0) {}
          for (l = 219L;; l = 216L)
          {
            paramArrayOfByte.idkeyStat(99L, l, 1L, false);
            break;
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 233L, 1L, false);
      paramArrayOfByte = z.a(((v.a)paramq.getReqObj()).FGV.GjQ);
      paramq = z.a(localb.FGW.GjQ);
      ae.i(this.TAG, "onGYNetEnd replace key:%b req :%s", new Object[] { Boolean.valueOf(bool), ad.ct(paramArrayOfByte) });
      ae.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", new Object[] { Boolean.valueOf(bool), ad.ct(paramq) });
      if (!bool)
      {
        paramString = paramArrayOfByte;
        if (bu.cF(paramArrayOfByte))
        {
          com.tencent.mm.kernel.g.ajS();
          paramString = bu.aSx(bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(8195, new byte[0])));
          ae.d(this.TAG, "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramString.length), bu.cE(paramString) });
        }
        paramArrayOfByte = ad.l(paramString, paramq);
        if (paramArrayOfByte != null)
        {
          paramString = paramArrayOfByte;
          if (paramArrayOfByte.length > 0) {}
        }
        else
        {
          ae.w(this.TAG, "merge key failed, use server side instead");
          paramString = paramq;
        }
        localb.FGW.GjQ = z.al(paramString);
      }
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajP().cO(localb.FGW.nJb, localb.FGW.Hqv);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.kernel.a.mP(localb.FGW.nJb);
      if (this.iin == null) {}
      for (bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.iin = localb;
        this.iio = bu.fpO();
        new aw(com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), new aw.a()
        {
          private int iir = 0;
          private long iis = 0L;
          private int iit = 0;
          
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(132571);
            Object localObject2 = new c();
            if (!com.tencent.mm.kernel.g.ajM())
            {
              ae.e(k.b(k.this), "syncRespHandler acc is not ready STOP :%s", new Object[] { k.c(k.this) });
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            if (k.e(k.this))
            {
              ((c)localObject2).du(k.this);
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            if ((k.c(k.this) == null) || (k.c(k.this).FGW.GjT == null) || (k.c(k.this).FGW.GjT.nIE == null))
            {
              ae.e(k.b(k.this), "syncRespHandler CmdList is null! Stop Processing :%s", new Object[] { k.c(k.this) });
              ((c)localObject2).du(k.this);
              k.d(k.this);
              AppMethodBeat.o(132571);
              return false;
            }
            Object localObject1 = k.c(k.this).FGW.GjT.nIE;
            ((c)localObject2).ds(k.this);
            this.iit += 1;
            long l1 = bu.fpO();
            int i = 0;
            while (i < 5)
            {
              if (this.iir < ((LinkedList)localObject1).size())
              {
                ae.v(k.b(k.this), "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.iir), Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((zx)((LinkedList)localObject1).get(this.iir)).Gru), Integer.valueOf(((zx)((LinkedList)localObject1).get(this.iir)).Grv.getILen()) });
                ((LinkedList)localObject1).size();
                if (!((c)localObject2).a((zx)((LinkedList)localObject1).get(this.iir), false)) {
                  ae.w(k.b(k.this), "DoCmd Failed index:%d", new Object[] { Integer.valueOf(this.iir) });
                }
                this.iir += 1;
              }
              if (this.iir >= ((LinkedList)localObject1).size())
              {
                this.iis += bu.DD(l1);
                l2 = bu.DD(k.f(k.this));
                ae.i(k.b(k.this), "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", new Object[] { Integer.valueOf(this.iir), Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(l2), Long.valueOf(this.iis), Integer.valueOf(this.iit), k.c(k.this) });
                k.this.a(k.c(k.this));
                ((c)localObject2).dt(k.this);
                i = bu.o((Integer)com.tencent.mm.plugin.report.e.a((int)this.iis, new int[] { 100, 300, 1000, 3000 }, new Integer[] { Integer.valueOf(240), Integer.valueOf(239), Integer.valueOf(238), Integer.valueOf(237), Integer.valueOf(236) }));
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, i, 1L, false);
                i = bu.o((Integer)com.tencent.mm.plugin.report.e.a(((LinkedList)localObject1).size(), new int[] { 0, 1, 2, 3, 5, 10 }, new Integer[] { Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(247), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243) }));
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, i, 1L, false);
                localObject2 = com.tencent.mm.plugin.report.e.ywz;
                int j;
                int k;
                int m;
                int n;
                if (com.tencent.mm.sdk.a.b.foreground)
                {
                  l1 = 241L;
                  ((com.tencent.mm.plugin.report.e)localObject2).idkeyStat(99L, l1, 1L, false);
                  com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, k.g(k.this), 1L, false);
                  com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 0L, 1L, false);
                  localObject2 = com.tencent.mm.plugin.report.e.ywz;
                  j = ((LinkedList)localObject1).size();
                  k = k.g(k.this);
                  m = k.c(k.this).FGW.GeQ;
                  l1 = this.iis;
                  n = this.iit;
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
              long l2 = bu.DD(l1);
              if (l2 > 500L)
              {
                ae.d(k.b(k.this), "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(this.iir), k.c(k.this) });
                this.iis += bu.DD(l1);
                AppMethodBeat.o(132571);
                return true;
              }
              i += 1;
            }
            this.iis += bu.DD(l1);
            AppMethodBeat.o(132571);
            return true;
          }
        }, true).ay(50L, 50L);
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
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(99L, 228L, 1L, false);
      locale = com.tencent.mm.plugin.report.e.ywz;
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
    return n.b.hRi;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends com.tencent.mm.ak.l
  {
    private final v.a ihp;
    private final v.b ihq;
    private final boolean ihr;
    
    public a()
    {
      AppMethodBeat.i(132572);
      this.ihp = new v.a();
      this.ihq = new v.b();
      this.ihr = false;
      AppMethodBeat.o(132572);
    }
    
    public a(v.b paramb)
    {
      AppMethodBeat.i(132573);
      this.ihp = new v.a();
      this.ihq = paramb;
      this.ihr = true;
      AppMethodBeat.o(132573);
    }
    
    public final boolean getPush()
    {
      return this.ihr;
    }
    
    public final l.d getReqObjImp()
    {
      return this.ihp;
    }
    
    public final l.e getRespObj()
    {
      return this.ihq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.k
 * JD-Core Version:    0.7.0.1
 */