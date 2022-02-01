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
  private ResultReceiver cAX;
  public BallInfo rYE;
  protected int rYF;
  protected com.tencent.mm.plugin.ball.c.b rYG;
  protected FloatBallProxyUI.a rYH;
  protected ResultReceiver rYI;
  
  public FloatBallHelper()
  {
    AppMethodBeat.i(106062);
    this.rYI = new ResultReceiverImpl(MMHandler.createFreeHandler(Looper.getMainLooper()), this);
    this.cAX = new ResultReceiverImpl2(MMHandler.createFreeHandler(Looper.getMainLooper()), this);
    this.rYG = ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class));
    this.rYH = new FloatBallProxyUI.a()
    {
      public final void ft(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(188230);
        Log.i("MicroMsg.FloatBallHelper", "floatBallProxyUIResultCallback, reach count limit, callback: %d", new Object[] { Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt2 == 1)
        {
          Log.i("MicroMsg.FloatBallHelper", "floatBallProxyUIResultCallback, show float menu view");
          FloatBallHelper.this.a(FloatBallHelper.this.rYI);
          AppMethodBeat.o(188230);
          return;
        }
        if ((paramAnonymousInt2 == 2) && (paramAnonymousInt1 == 1) && (FloatBallHelper.this.rYE != null))
        {
          FloatBallHelper.this.rYE.rYs.rYz = 2;
          ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).r(FloatBallHelper.this.rYE);
        }
        AppMethodBeat.o(188230);
      }
    };
    AppMethodBeat.o(106062);
  }
  
  private BallInfo aow(String paramString)
  {
    AppMethodBeat.i(186291);
    try
    {
      paramString = BallInfo.az(new JSONObject(paramString));
      AppMethodBeat.o(186291);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallHelper", paramString, "getCurrentBallFromMMKV:%s", new Object[] { this.rYE });
      AppMethodBeat.o(186291);
    }
    return null;
  }
  
  public static int cvC()
  {
    AppMethodBeat.i(186295);
    int i = MultiProcessMMKV.getMMKV(cvw()).decodeInt("ActiveCount", 0);
    AppMethodBeat.o(186295);
    return i;
  }
  
  private boolean cvO()
  {
    return this.rYE.type == 20;
  }
  
  private void cvQ()
  {
    AppMethodBeat.i(186350);
    if (bOb())
    {
      BallInfo localBallInfo = cvz();
      if (localBallInfo != null)
      {
        BallReportInfo localBallReportInfo = this.rYE.rYs;
        this.rYE = localBallInfo;
        this.rYE.b(localBallReportInfo);
        Log.i("MicroMsg.FloatBallHelper", "replaceMessageBallIfNeed, replace current message ball reportInfo: %s", new Object[] { this.rYE.rYs });
      }
    }
    AppMethodBeat.o(186350);
  }
  
  private void cvR()
  {
    AppMethodBeat.i(186352);
    Log.i("MicroMsg.FloatBallHelper", "alvinluo removeMessageBallIfNeed enable: %b, isFromMessageFloatBall: %b, ballInfo.contentType: %d, originFloatBallType: %d", new Object[] { Boolean.valueOf(cvN()), Boolean.valueOf(cvO()), Integer.valueOf(this.rYE.aOl), Integer.valueOf(this.rYF) });
    if ((bOb()) && (cvN()) && (cvO()) && (this.rYG != null)) {
      this.rYG.Fe(this.rYF);
    }
    AppMethodBeat.o(186352);
  }
  
  private static String cvw()
  {
    AppMethodBeat.i(106068);
    int i = com.tencent.mm.kernel.b.aGP();
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
  
  private BallInfo cvz()
  {
    AppMethodBeat.i(186287);
    Log.d("MicroMsg.FloatBallHelper", "getCurrentMessageBallInner enableMessageFloatBall: %b", new Object[] { Boolean.valueOf(bOb()) });
    if ((bOb()) && (this.rYE != null))
    {
      Object localObject = String.format("%s#%s", new Object[] { Integer.valueOf(20), this.rYE.key });
      localObject = MultiProcessMMKV.getMMKV(cvw()).decodeString((String)localObject);
      Log.d("MicroMsg.FloatBallHelper", "getCurrentMessageBallInner enableMessageFloatBall data: %s", new Object[] { localObject });
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = aow((String)localObject);
        AppMethodBeat.o(186287);
        return localObject;
      }
    }
    AppMethodBeat.o(186287);
    return null;
  }
  
  private static boolean fj(String paramString1, String paramString2)
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
  
  public final void A(boolean paramBoolean)
  {
    AppMethodBeat.i(106082);
    if ((this.rYE != null) && (this.rYG != null)) {
      this.rYG.a(this.rYE, paramBoolean);
    }
    AppMethodBeat.o(106082);
  }
  
  public void D(boolean paramBoolean, int paramInt) {}
  
  protected void Fh(int paramInt) {}
  
  public final void Fi(int paramInt)
  {
    AppMethodBeat.i(106085);
    if ((this.rYE != null) && (this.rYE.state != paramInt))
    {
      Log.i("MicroMsg.FloatBallHelper", "updateState, state:%s", new Object[] { Integer.valueOf(paramInt) });
      this.rYE.state = paramInt;
      cvG();
    }
    AppMethodBeat.o(106085);
  }
  
  public final void HM(long paramLong)
  {
    AppMethodBeat.i(184560);
    if ((this.rYE != null) && (this.rYE.progress != paramLong))
    {
      Log.v("MicroMsg.FloatBallHelper", "updateProgress, progress:%d", new Object[] { Long.valueOf(paramLong) });
      this.rYE.progress = paramLong;
      cvG();
    }
    AppMethodBeat.o(184560);
  }
  
  public void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(106063);
    this.rYE = new BallInfo(paramInt, paramString);
    this.rYF = paramInt;
    paramString = cvy();
    if (paramString != null)
    {
      Log.i("MicroMsg.FloatBallHelper", "replaceCurrentBallIfNeed, replace current ball");
      this.rYE = paramString;
    }
    if (this.rYG != null) {
      this.rYG.a(this.rYE, this.cAX);
    }
    AppMethodBeat.o(106063);
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(186284);
    if (this.rYG != null) {
      this.rYG.a(paramResultReceiver);
    }
    AppMethodBeat.o(186284);
  }
  
  public void aOf()
  {
    AppMethodBeat.i(106066);
    if (this.rYG != null) {
      this.rYG.p(this.rYE);
    }
    if (this.rYE != null)
    {
      cvQ();
      cvR();
    }
    AppMethodBeat.o(106066);
  }
  
  public boolean aOg()
  {
    return false;
  }
  
  public boolean aOh()
  {
    return false;
  }
  
  protected void aOi() {}
  
  public void aOj()
  {
    AppMethodBeat.i(106067);
    if (this.rYG != null) {
      this.rYG.q(this.rYE);
    }
    if (this.rYE != null)
    {
      if ((bOb()) && (this.rYG != null)) {
        this.rYG.t(this.rYE);
      }
      ((a)h.ae(a.class)).f(this.rYE.rYs.kqZ, false, bOb());
    }
    AppMethodBeat.o(106067);
  }
  
  protected void ai(int paramInt, String paramString) {}
  
  public final void aox(String paramString)
  {
    AppMethodBeat.i(106081);
    if ((this.rYE != null) && (!Util.isNullOrNil(paramString)) && (!fj(this.rYE.icon, paramString)))
    {
      Log.i("MicroMsg.FloatBallHelper", "updateIcon, icon:%s", new Object[] { paramString });
      this.rYE.icon = paramString;
      cvG();
    }
    AppMethodBeat.o(106081);
  }
  
  public void aoy(String paramString)
  {
    AppMethodBeat.i(106083);
    if ((this.rYE != null) && (!Util.isNullOrNil(paramString)))
    {
      String str = paramString;
      if (paramString.length() > 50) {
        str = paramString.substring(0, 50);
      }
      if (!fj(this.rYE.name, str))
      {
        Log.i("MicroMsg.FloatBallHelper", "updateName, name:%s", new Object[] { str });
        this.rYE.name = str;
        cvG();
      }
    }
    AppMethodBeat.o(106083);
  }
  
  public final void aoz(String paramString)
  {
    AppMethodBeat.i(106084);
    if ((this.rYE != null) && (!Util.isNullOrNil(paramString)) && (!fj(this.rYE.desc, paramString)))
    {
      Log.i("MicroMsg.FloatBallHelper", "updateDesc, desc:%s", new Object[] { paramString });
      this.rYE.desc = paramString;
      cvG();
    }
    AppMethodBeat.o(106084);
  }
  
  public void bNV()
  {
    AppMethodBeat.i(106065);
    if (this.rYG != null) {
      this.rYG.o(this.rYE);
    }
    if (this.rYE != null)
    {
      cvQ();
      cvR();
    }
    AppMethodBeat.o(106065);
  }
  
  protected void bNW() {}
  
  public boolean bOb()
  {
    return false;
  }
  
  public final BallInfo cvA()
  {
    AppMethodBeat.i(106073);
    if (this.rYE != null)
    {
      String str = this.rYE.cvr();
      Log.v("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV ballInfoKey: %s", new Object[] { str });
      str = MultiProcessMMKV.getMMKV(cvw()).decodeString(str);
      if (!Util.isNullOrNil(str))
      {
        BallInfo localBallInfo = aow(str);
        Log.i("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, data:%s, ballInfo:%s", new Object[] { str, localBallInfo });
        AppMethodBeat.o(106073);
        return localBallInfo;
      }
      Log.w("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, no saved data");
    }
    AppMethodBeat.o(106073);
    return null;
  }
  
  public final boolean cvB()
  {
    AppMethodBeat.i(106074);
    if (this.rYG != null)
    {
      boolean bool = this.rYG.i(this.rYE);
      AppMethodBeat.o(106074);
      return bool;
    }
    AppMethodBeat.o(106074);
    return false;
  }
  
  public final boolean cvD()
  {
    AppMethodBeat.i(106075);
    if (this.rYG != null)
    {
      if (this.rYG.h(this.rYE) != null)
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
  
  public void cvE()
  {
    AppMethodBeat.i(106076);
    if (this.rYG != null) {
      this.rYG.l(this.rYE);
    }
    AppMethodBeat.o(106076);
  }
  
  public void cvF()
  {
    AppMethodBeat.i(106077);
    if (this.rYG != null) {
      this.rYG.j(this.rYE);
    }
    AppMethodBeat.o(106077);
  }
  
  public void cvG()
  {
    AppMethodBeat.i(106078);
    if (this.rYG != null) {
      this.rYG.k(this.rYE);
    }
    AppMethodBeat.o(106078);
  }
  
  public final void cvH()
  {
    AppMethodBeat.i(106079);
    if (this.rYG != null) {
      this.rYG.kW(true);
    }
    AppMethodBeat.o(106079);
  }
  
  public final void cvI()
  {
    AppMethodBeat.i(106080);
    if (this.rYG != null) {
      this.rYG.kV(true);
    }
    AppMethodBeat.o(106080);
  }
  
  public final void cvJ()
  {
    AppMethodBeat.i(186316);
    if (this.rYG != null) {
      this.rYG.a(System.currentTimeMillis(), null);
    }
    AppMethodBeat.o(186316);
  }
  
  public final void cvK()
  {
    AppMethodBeat.i(292746);
    cvG();
    AppMethodBeat.o(292746);
  }
  
  public final BallReportInfo cvL()
  {
    AppMethodBeat.i(106088);
    if (this.rYE == null)
    {
      localObject = new IllegalStateException("call FloatBallHelper#onCreate first");
      AppMethodBeat.o(106088);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rYE.rYs;
    AppMethodBeat.o(106088);
    return localObject;
  }
  
  public final BallInfo cvM()
  {
    return this.rYE;
  }
  
  protected boolean cvN()
  {
    AppMethodBeat.i(186345);
    boolean bool = bOb();
    AppMethodBeat.o(186345);
    return bool;
  }
  
  final void cvP()
  {
    AppMethodBeat.i(186348);
    if (cvO())
    {
      this.rYE.type = this.rYE.aOl;
      this.rYE.state = 0;
      Log.v("MicroMsg.FloatBallHelper", "alvinluo resetFloatBallInfo ballInfo: %s", new Object[] { this.rYE });
    }
    AppMethodBeat.o(186348);
  }
  
  public final void cvb()
  {
    AppMethodBeat.i(106069);
    if (this.rYG != null) {
      this.rYG.cvb();
    }
    AppMethodBeat.o(106069);
  }
  
  public final void cvv()
  {
    AppMethodBeat.i(186276);
    D(true, 2);
    AppMethodBeat.o(186276);
  }
  
  public final BallInfo cvx()
  {
    AppMethodBeat.i(106071);
    if (this.rYG != null)
    {
      BallInfo localBallInfo = this.rYG.h(this.rYE);
      AppMethodBeat.o(106071);
      return localBallInfo;
    }
    AppMethodBeat.o(106071);
    return null;
  }
  
  public BallInfo cvy()
  {
    AppMethodBeat.i(106072);
    BallInfo localBallInfo = cvA();
    AppMethodBeat.o(106072);
    return localBallInfo;
  }
  
  public final void fi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(106087);
    if ((this.rYE != null) && ((!this.rYE.aot(paramString1)) || (!fj(this.rYE.fh(paramString1, paramString2), paramString2))))
    {
      Log.printInfoStack("MicroMsg.FloatBallHelper", "updateStringExtra, %s:%s", new Object[] { paramString1, paramString2 });
      this.rYE.fg(paramString1, paramString2);
      cvG();
    }
    AppMethodBeat.o(106087);
  }
  
  public final void le(boolean paramBoolean)
  {
    AppMethodBeat.i(106086);
    if ((this.rYE != null) && (this.rYE.rYr != paramBoolean))
    {
      Log.i("MicroMsg.FloatBallHelper", "updatePassive, passive:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.rYE.rYr = paramBoolean;
      cvG();
    }
    AppMethodBeat.o(106086);
  }
  
  public final void lf(boolean paramBoolean)
  {
    AppMethodBeat.i(176959);
    if ((this.rYE != null) && (this.rYE.qmt != paramBoolean))
    {
      Log.i("MicroMsg.FloatBallHelper", "updateHidden, hidden:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.rYE.qmt = paramBoolean;
      cvG();
    }
    AppMethodBeat.o(176959);
  }
  
  public final void n(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186336);
    if (this.rYE != null)
    {
      Log.i("MicroMsg.FloatBallHelper", "updateByteArrayExtra, %s", new Object[] { paramString });
      this.rYE.m(paramString, paramArrayOfByte);
      cvG();
    }
    AppMethodBeat.o(186336);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106064);
    if (this.rYG != null) {
      this.rYG.s(this.rYE);
    }
    AppMethodBeat.o(106064);
  }
  
  public boolean zH(int paramInt)
  {
    return false;
  }
  
  static class ResultReceiverImpl
    extends ResultReceiver
  {
    protected WeakReference<FloatBallHelper> rYK;
    
    public ResultReceiverImpl(Handler paramHandler, FloatBallHelper paramFloatBallHelper)
    {
      super();
      AppMethodBeat.i(186903);
      this.rYK = new WeakReference(paramFloatBallHelper);
      AppMethodBeat.o(186903);
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(186904);
      if (this.rYK == null)
      {
        AppMethodBeat.o(186904);
        return;
      }
      FloatBallHelper localFloatBallHelper = (FloatBallHelper)this.rYK.get();
      if (localFloatBallHelper == null)
      {
        AppMethodBeat.o(186904);
        return;
      }
      if ((paramInt == 2) && (paramBundle != null))
      {
        boolean bool = paramBundle.getBoolean("can_add_float_ball_when_hide", false);
        if ((bool) && (localFloatBallHelper.cvB()))
        {
          Log.i("MicroMsg.FloatBallHelper", "alvinluo autoAddFloatBall onReceiveResult add new after remove floatBall done");
          localFloatBallHelper.cvL().rYz = 1;
          localFloatBallHelper.D(true, 7);
          AppMethodBeat.o(186904);
          return;
        }
        if (localFloatBallHelper.rYE != null)
        {
          Log.i("MicroMsg.FloatBallHelper", "alvinluo autoAddFloatBall onReceiveResult not add, canAdd: %b", new Object[] { Boolean.valueOf(bool) });
          localFloatBallHelper.cvL().rYz = 2;
          ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).r(localFloatBallHelper.rYE);
        }
      }
      AppMethodBeat.o(186904);
    }
  }
  
  static class ResultReceiverImpl2
    extends ResultReceiver
  {
    protected WeakReference<FloatBallHelper> rYK;
    
    public ResultReceiverImpl2(Handler paramHandler, FloatBallHelper paramFloatBallHelper)
    {
      super();
      AppMethodBeat.i(187519);
      this.rYK = new WeakReference(paramFloatBallHelper);
      AppMethodBeat.o(187519);
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(187524);
      FloatBallHelper localFloatBallHelper = (FloatBallHelper)this.rYK.get();
      if (localFloatBallHelper == null)
      {
        AppMethodBeat.o(187524);
        return;
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(187524);
        return;
        int i;
        if (paramBundle != null)
        {
          i = paramBundle.getInt("type", 0);
          paramBundle = paramBundle.getString("key", null);
          if (i != 0)
          {
            localFloatBallHelper.ai(i, paramBundle);
            Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(ADD_BALL_INFO), type:%d, key: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramBundle });
            AppMethodBeat.o(187524);
            return;
          }
          Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(ADD_BALL_INFO), no type", new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(187524);
          return;
        }
        Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(ADD_BALL_INFO), no resultData", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(187524);
        return;
        Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(UPDATE_BALL_INFO)", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(187524);
        return;
        Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(REMOVE_BALL_INFO)", new Object[] { Integer.valueOf(paramInt) });
        localFloatBallHelper.bNW();
        AppMethodBeat.o(187524);
        return;
        Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(FINISH_WHEN_SWITCH_BALL)", new Object[] { Integer.valueOf(paramInt) });
        localFloatBallHelper.aOi();
        AppMethodBeat.o(187524);
        return;
        if (paramBundle != null)
        {
          i = paramBundle.getInt("ActiveCount", 0);
          localFloatBallHelper.Fh(i);
          Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(BALL_INFO_COUNT_CHANGED), activeCount:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
          AppMethodBeat.o(187524);
          return;
        }
        Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(BALL_INFO_COUNT_CHANGED), no resultData", new Object[] { Integer.valueOf(paramInt) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallHelper
 * JD-Core Version:    0.7.0.1
 */