package com.tencent.mm.plugin.ball.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class FloatBallHelper
{
  private ResultReceiver ett;
  private boolean isFinished;
  public BallInfo vjV;
  protected int vjW;
  protected com.tencent.mm.plugin.ball.c.b vjX;
  protected FloatBallProxyUI.a vjY;
  protected ResultReceiver vjZ;
  
  public FloatBallHelper()
  {
    AppMethodBeat.i(106062);
    this.isFinished = false;
    this.vjZ = new ResultReceiverImpl(MMHandler.createFreeHandler(Looper.getMainLooper()), this);
    this.ett = new FloatBallHelper.ResultReceiverImpl2(MMHandler.createFreeHandler(Looper.getMainLooper()), this);
    this.vjX = ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class));
    this.vjY = new FloatBallProxyUI.a()
    {
      public final void onCallback(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(288371);
        Log.i("MicroMsg.FloatBallHelper", "floatBallProxyUIResultCallback, reach count limit, callback: %d", new Object[] { Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt2 == 1)
        {
          Log.i("MicroMsg.FloatBallHelper", "floatBallProxyUIResultCallback, show float menu view");
          FloatBallHelper.this.b(FloatBallHelper.this.vjZ);
          AppMethodBeat.o(288371);
          return;
        }
        if ((paramAnonymousInt2 == 2) && (paramAnonymousInt1 == 1) && (FloatBallHelper.this.vjV != null))
        {
          FloatBallHelper.this.vjV.vjI.vjP = 2;
          ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).r(FloatBallHelper.this.vjV);
        }
        AppMethodBeat.o(288371);
      }
    };
    AppMethodBeat.o(106062);
  }
  
  private BallInfo ahS(String paramString)
  {
    AppMethodBeat.i(288380);
    try
    {
      paramString = BallInfo.aJ(new JSONObject(paramString));
      AppMethodBeat.o(288380);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallHelper", paramString, "getCurrentBallFromMMKV:%s", new Object[] { this.vjV });
      AppMethodBeat.o(288380);
    }
    return null;
  }
  
  private void cYA()
  {
    AppMethodBeat.i(288392);
    Log.i("MicroMsg.FloatBallHelper", "alvinluo removeMessageBallIfNeed enable: %b, isFromMessageFloatBall: %b, ballInfo.contentType: %d, originFloatBallType: %d", new Object[] { Boolean.valueOf(cYw()), Boolean.valueOf(cYx()), Integer.valueOf(this.vjV.cIh), Integer.valueOf(this.vjW) });
    if ((cop()) && (cYw()) && (cYx()) && (this.vjX != null)) {
      this.vjX.FF(this.vjW);
    }
    AppMethodBeat.o(288392);
  }
  
  private static String cYh()
  {
    AppMethodBeat.i(106068);
    int i = com.tencent.mm.kernel.b.aZP();
    if (i != 0)
    {
      long l = i;
      String str = (l & 0xFFFFFFFF) + "#" + "float_ball_storage";
      Log.i("MicroMsg.FloatBallHelper", "accountDataKey:%s", new Object[] { str });
      AppMethodBeat.o(106068);
      return str;
    }
    Log.i("MicroMsg.FloatBallHelper", "accountDataKey:%s", new Object[] { "float_ball_storage" });
    AppMethodBeat.o(106068);
    return "float_ball_storage";
  }
  
  private BallInfo cYk()
  {
    AppMethodBeat.i(288378);
    Log.d("MicroMsg.FloatBallHelper", "getCurrentMessageBallInner enableMessageFloatBall: %b", new Object[] { Boolean.valueOf(cop()) });
    if ((cop()) && (this.vjV != null))
    {
      Object localObject = String.format("%s#%s", new Object[] { Integer.valueOf(20), this.vjV.key });
      localObject = MultiProcessMMKV.getMMKV(cYh()).decodeString((String)localObject);
      Log.d("MicroMsg.FloatBallHelper", "getCurrentMessageBallInner enableMessageFloatBall data: %s", new Object[] { localObject });
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = ahS((String)localObject);
        AppMethodBeat.o(288378);
        return localObject;
      }
    }
    AppMethodBeat.o(288378);
    return null;
  }
  
  public static int cYn()
  {
    AppMethodBeat.i(288383);
    int i = MultiProcessMMKV.getMMKV(cYh()).decodeInt("ActiveCount", 0);
    AppMethodBeat.o(288383);
    return i;
  }
  
  private void cYt()
  {
    AppMethodBeat.i(288385);
    if (this.vjX != null) {
      this.vjX.cXU();
    }
    AppMethodBeat.o(288385);
  }
  
  private boolean cYx()
  {
    return this.vjV.type == 20;
  }
  
  private void cYz()
  {
    AppMethodBeat.i(288389);
    if (cop())
    {
      BallInfo localBallInfo = cYk();
      if (localBallInfo != null)
      {
        BallReportInfo localBallReportInfo = this.vjV.vjI;
        this.vjV = localBallInfo;
        this.vjV.b(localBallReportInfo);
        Log.i("MicroMsg.FloatBallHelper", "replaceMessageBallIfNeed, replace current message ball reportInfo: %s", new Object[] { this.vjV.vjI });
      }
    }
    AppMethodBeat.o(288389);
  }
  
  private static boolean fA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(106089);
    if ((paramString1 == null) && (paramString2 == null))
    {
      AppMethodBeat.o(106089);
      return true;
    }
    if (("".equals(paramString1)) && ("".equals(paramString2)))
    {
      AppMethodBeat.o(106089);
      return true;
    }
    if ((!Util.isNullOrNil(paramString1)) && (!Util.isNullOrNil(paramString2)) && (paramString1.equals(paramString2)))
    {
      AppMethodBeat.o(106089);
      return true;
    }
    AppMethodBeat.o(106089);
    return false;
  }
  
  public void B(boolean paramBoolean, int paramInt) {}
  
  public final void E(boolean paramBoolean)
  {
    AppMethodBeat.i(106082);
    if ((this.vjV != null) && (this.vjX != null)) {
      this.vjX.a(this.vjV, paramBoolean);
    }
    AppMethodBeat.o(106082);
  }
  
  protected void FI(int paramInt) {}
  
  public final void FJ(int paramInt)
  {
    AppMethodBeat.i(106085);
    if ((this.vjV != null) && (this.vjV.state != paramInt))
    {
      Log.i("MicroMsg.FloatBallHelper", "updateState, state:%s", new Object[] { Integer.valueOf(paramInt) });
      this.vjV.state = paramInt;
      cYr();
    }
    AppMethodBeat.o(106085);
  }
  
  public void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(106063);
    this.vjV = new BallInfo(paramInt, paramString);
    this.vjW = paramInt;
    paramString = cYj();
    if (paramString != null)
    {
      Log.i("MicroMsg.FloatBallHelper", "replaceCurrentBallIfNeed, replace current ball");
      this.vjV = paramString;
    }
    if (this.vjX != null) {
      this.vjX.a(this.vjV, this.ett);
    }
    AppMethodBeat.o(106063);
  }
  
  public final void ahT(String paramString)
  {
    AppMethodBeat.i(106081);
    if ((this.vjV != null) && (!Util.isNullOrNil(paramString)) && (!fA(this.vjV.icon, paramString)))
    {
      Log.i("MicroMsg.FloatBallHelper", "updateIcon, icon:%s", new Object[] { paramString });
      this.vjV.icon = paramString;
      cYr();
    }
    AppMethodBeat.o(106081);
  }
  
  public void ahU(String paramString)
  {
    AppMethodBeat.i(106083);
    if ((this.vjV != null) && (!Util.isNullOrNil(paramString)))
    {
      String str = paramString;
      if (paramString.length() > 50) {
        str = paramString.substring(0, 50);
      }
      if (!fA(this.vjV.name, str))
      {
        Log.i("MicroMsg.FloatBallHelper", "updateName, name:%s", new Object[] { str });
        this.vjV.name = str;
        cYr();
      }
    }
    AppMethodBeat.o(106083);
  }
  
  public final void ahV(String paramString)
  {
    AppMethodBeat.i(106084);
    if ((this.vjV != null) && (!Util.isNullOrNil(paramString)) && (!fA(this.vjV.desc, paramString)))
    {
      Log.i("MicroMsg.FloatBallHelper", "updateDesc, desc:%s", new Object[] { paramString });
      this.vjV.desc = paramString;
      cYr();
    }
    AppMethodBeat.o(106084);
  }
  
  protected void as(int paramInt, String paramString) {}
  
  public final void b(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(288417);
    if (this.vjX != null) {
      this.vjX.b(paramResultReceiver);
    }
    AppMethodBeat.o(288417);
  }
  
  public void bhT()
  {
    AppMethodBeat.i(106066);
    this.isFinished = false;
    if (this.vjX != null) {
      this.vjX.p(this.vjV);
    }
    if (this.vjV != null)
    {
      cYz();
      cYA();
    }
    AppMethodBeat.o(106066);
  }
  
  public boolean bhU()
  {
    return false;
  }
  
  protected void bhV() {}
  
  public void bhW()
  {
    AppMethodBeat.i(106067);
    if (this.vjX != null) {
      this.vjX.q(this.vjV);
    }
    if (this.vjV != null)
    {
      if (cYg()) {
        cYs();
      }
      if (this.isFinished) {
        ((a)h.ax(a.class)).f(this.vjV.vjI.mUU, false, cop());
      }
    }
    AppMethodBeat.o(106067);
  }
  
  public final void cXL()
  {
    AppMethodBeat.i(106069);
    if (this.vjX != null) {
      this.vjX.cXL();
    }
    AppMethodBeat.o(106069);
  }
  
  protected final boolean cYg()
  {
    AppMethodBeat.i(288405);
    if ((cop()) && (!this.isFinished))
    {
      AppMethodBeat.o(288405);
      return true;
    }
    AppMethodBeat.o(288405);
    return false;
  }
  
  public final BallInfo cYi()
  {
    AppMethodBeat.i(106071);
    if (this.vjX != null)
    {
      BallInfo localBallInfo = this.vjX.h(this.vjV);
      AppMethodBeat.o(106071);
      return localBallInfo;
    }
    AppMethodBeat.o(106071);
    return null;
  }
  
  public BallInfo cYj()
  {
    AppMethodBeat.i(106072);
    BallInfo localBallInfo = cYl();
    AppMethodBeat.o(106072);
    return localBallInfo;
  }
  
  public final BallInfo cYl()
  {
    AppMethodBeat.i(106073);
    if (this.vjV != null)
    {
      String str = this.vjV.cYc();
      Log.v("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV ballInfoKey: %s", new Object[] { str });
      str = MultiProcessMMKV.getMMKV(cYh()).decodeString(str);
      if (!Util.isNullOrNil(str))
      {
        BallInfo localBallInfo = ahS(str);
        Log.i("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, data:%s, ballInfo:%s", new Object[] { str, localBallInfo });
        AppMethodBeat.o(106073);
        return localBallInfo;
      }
      Log.w("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, no saved data");
    }
    AppMethodBeat.o(106073);
    return null;
  }
  
  public final boolean cYm()
  {
    AppMethodBeat.i(106074);
    if (this.vjX != null)
    {
      boolean bool = this.vjX.i(this.vjV);
      AppMethodBeat.o(106074);
      return bool;
    }
    AppMethodBeat.o(106074);
    return false;
  }
  
  public final boolean cYo()
  {
    AppMethodBeat.i(106075);
    if (this.vjX != null)
    {
      if (this.vjX.h(this.vjV) != null)
      {
        AppMethodBeat.o(106075);
        return true;
      }
      AppMethodBeat.o(106075);
      return false;
    }
    AppMethodBeat.o(106075);
    return false;
  }
  
  public void cYp()
  {
    AppMethodBeat.i(106076);
    if (this.vjX != null) {
      this.vjX.l(this.vjV);
    }
    AppMethodBeat.o(106076);
  }
  
  public void cYq()
  {
    AppMethodBeat.i(106077);
    if (this.vjX != null) {
      this.vjX.j(this.vjV);
    }
    AppMethodBeat.o(106077);
  }
  
  public void cYr()
  {
    AppMethodBeat.i(106078);
    if (this.vjX != null) {
      this.vjX.k(this.vjV);
    }
    AppMethodBeat.o(106078);
  }
  
  public final void cYs()
  {
    AppMethodBeat.i(288432);
    if (this.vjX != null) {
      this.vjX.t(this.vjV);
    }
    AppMethodBeat.o(288432);
  }
  
  public final void cYu()
  {
    AppMethodBeat.i(288434);
    if (this.vjX != null) {
      this.vjX.a(System.currentTimeMillis(), null);
    }
    AppMethodBeat.o(288434);
  }
  
  public final BallReportInfo cYv()
  {
    AppMethodBeat.i(106088);
    if (this.vjV == null)
    {
      localObject = new IllegalStateException("call FloatBallHelper#onCreate first");
      AppMethodBeat.o(106088);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vjV.vjI;
    AppMethodBeat.o(106088);
    return localObject;
  }
  
  protected boolean cYw()
  {
    AppMethodBeat.i(288465);
    boolean bool = cop();
    AppMethodBeat.o(288465);
    return bool;
  }
  
  final void cYy()
  {
    AppMethodBeat.i(288466);
    if (cYx())
    {
      this.vjV.type = this.vjV.cIh;
      this.vjV.state = 0;
      Log.v("MicroMsg.FloatBallHelper", "alvinluo resetFloatBallInfo ballInfo: %s", new Object[] { this.vjV });
    }
    AppMethodBeat.o(288466);
  }
  
  public void coi()
  {
    AppMethodBeat.i(106065);
    this.isFinished = false;
    if (this.vjX != null) {
      this.vjX.o(this.vjV);
    }
    if (this.vjV != null)
    {
      cYz();
      cYA();
    }
    AppMethodBeat.o(106065);
  }
  
  protected void coj() {}
  
  public boolean cop()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(288407);
    this.isFinished = true;
    cYt();
    AppMethodBeat.o(288407);
  }
  
  public final void fz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(106087);
    if ((this.vjV != null) && ((!this.vjV.ahQ(paramString1)) || (!fA(this.vjV.fy(paramString1, paramString2), paramString2))))
    {
      Log.printInfoStack("MicroMsg.FloatBallHelper", "updateStringExtra, %s:%s", new Object[] { paramString1, paramString2 });
      this.vjV.fx(paramString1, paramString2);
      cYr();
    }
    AppMethodBeat.o(106087);
  }
  
  public final void kd(long paramLong)
  {
    AppMethodBeat.i(184560);
    if ((this.vjV != null) && (this.vjV.hQO != paramLong))
    {
      Log.v("MicroMsg.FloatBallHelper", "updateProgress, progress:%d", new Object[] { Long.valueOf(paramLong) });
      this.vjV.hQO = paramLong;
      cYr();
    }
    AppMethodBeat.o(184560);
  }
  
  public final void mi(boolean paramBoolean)
  {
    AppMethodBeat.i(288431);
    if (this.vjX != null) {
      this.vjX.mi(paramBoolean);
    }
    AppMethodBeat.o(288431);
  }
  
  public final void mj(boolean paramBoolean)
  {
    AppMethodBeat.i(288427);
    if (this.vjX != null) {
      this.vjX.mj(paramBoolean);
    }
    AppMethodBeat.o(288427);
  }
  
  public final void mr(boolean paramBoolean)
  {
    AppMethodBeat.i(106086);
    if ((this.vjV != null) && (this.vjV.vjH != paramBoolean))
    {
      Log.i("MicroMsg.FloatBallHelper", "updatePassive, passive:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.vjV.vjH = paramBoolean;
      cYr();
    }
    AppMethodBeat.o(106086);
  }
  
  public final void ms(boolean paramBoolean)
  {
    AppMethodBeat.i(176959);
    if ((this.vjV != null) && (this.vjV.trn != paramBoolean))
    {
      Log.i("MicroMsg.FloatBallHelper", "updateHidden, hidden:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.vjV.trn = paramBoolean;
      cYr();
    }
    AppMethodBeat.o(176959);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106064);
    if (this.vjX != null) {
      this.vjX.s(this.vjV);
    }
    AppMethodBeat.o(106064);
  }
  
  public final void q(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(288453);
    if (this.vjV != null)
    {
      Log.i("MicroMsg.FloatBallHelper", "updateByteArrayExtra, %s", new Object[] { paramString });
      this.vjV.p(paramString, paramArrayOfByte);
      cYr();
    }
    AppMethodBeat.o(288453);
  }
  
  public boolean zX(int paramInt)
  {
    return false;
  }
  
  static class ResultReceiverImpl
    extends ResultReceiver
  {
    protected WeakReference<FloatBallHelper> vkb;
    
    public ResultReceiverImpl(Handler paramHandler, FloatBallHelper paramFloatBallHelper)
    {
      super();
      AppMethodBeat.i(288344);
      this.vkb = new WeakReference(paramFloatBallHelper);
      AppMethodBeat.o(288344);
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(288348);
      if (this.vkb == null)
      {
        AppMethodBeat.o(288348);
        return;
      }
      FloatBallHelper localFloatBallHelper = (FloatBallHelper)this.vkb.get();
      if (localFloatBallHelper == null)
      {
        AppMethodBeat.o(288348);
        return;
      }
      if ((paramInt == 2) && (paramBundle != null))
      {
        boolean bool = paramBundle.getBoolean("can_add_float_ball_when_hide", false);
        if ((bool) && (localFloatBallHelper.cYm()))
        {
          Log.i("MicroMsg.FloatBallHelper", "alvinluo autoAddFloatBall onReceiveResult add new after remove floatBall done");
          localFloatBallHelper.cYv().vjP = 1;
          localFloatBallHelper.B(true, 7);
          AppMethodBeat.o(288348);
          return;
        }
        if (localFloatBallHelper.vjV != null)
        {
          Log.i("MicroMsg.FloatBallHelper", "alvinluo autoAddFloatBall onReceiveResult not add, canAdd: %b", new Object[] { Boolean.valueOf(bool) });
          localFloatBallHelper.cYv().vjP = 2;
          ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).r(localFloatBallHelper.vjV);
        }
      }
      AppMethodBeat.o(288348);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallHelper
 * JD-Core Version:    0.7.0.1
 */