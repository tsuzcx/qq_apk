package com.tencent.mm.plugin.ball.service;

import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements com.tencent.mm.plugin.ball.c.a
{
  private ResultReceiver cpd;
  public BallInfo nLK;
  protected int nLL;
  protected c nLM;
  protected FloatBallProxyUI.a nLN;
  protected ResultReceiver nLO;
  
  public a()
  {
    AppMethodBeat.i(106062);
    this.nLO = new FloatBallHelper.1(this, aq.createFreeHandler(Looper.getMainLooper()));
    this.cpd = new FloatBallHelper.6(this, aq.createFreeHandler(Looper.getMainLooper()));
    this.nLM = ((c)g.ab(c.class));
    this.nLN = new FloatBallProxyUI.a()
    {
      public final void eH(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(209432);
        ae.i("MicroMsg.FloatBallHelper", "floatBallProxyUIResultCallback, reach count limit, callback: %d", new Object[] { Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt2 == 1)
        {
          ae.i("MicroMsg.FloatBallHelper", "floatBallProxyUIResultCallback, show float menu view");
          a.this.a(a.this.nLO);
          AppMethodBeat.o(209432);
          return;
        }
        if ((paramAnonymousInt2 == 2) && (paramAnonymousInt1 == 1) && (a.this.nLK != null))
        {
          a.this.nLK.nLw.nLE = 2;
          ((c)g.ab(c.class)).s(a.this.nLK);
        }
        AppMethodBeat.o(209432);
      }
    };
    AppMethodBeat.o(106062);
  }
  
  private BallInfo WW(String paramString)
  {
    AppMethodBeat.i(209438);
    try
    {
      paramString = BallInfo.ad(new JSONObject(paramString));
      AppMethodBeat.o(209438);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.FloatBallHelper", paramString, "getCurrentBallFromMMKV:%s", new Object[] { this.nLK });
      AppMethodBeat.o(209438);
    }
    return null;
  }
  
  static String bLr()
  {
    AppMethodBeat.i(106068);
    int i = com.tencent.mm.kernel.a.ajc();
    if (i != 0)
    {
      long l = i;
      String str = (l & 0xFFFFFFFF) + "#" + "float_ball_storage";
      ae.i("MicroMsg.FloatBallHelper", "accountDataKey:%s", new Object[] { str });
      AppMethodBeat.o(106068);
      return str;
    }
    ae.i("MicroMsg.FloatBallHelper", "accountDataKey:%s", new Object[] { "float_ball_storage" });
    AppMethodBeat.o(106068);
    return "float_ball_storage";
  }
  
  private static boolean eE(String paramString1, String paramString2)
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
    if ((!bu.isNullOrNil(paramString1)) && (!bu.isNullOrNil(paramString2)) && (paramString1.equals(paramString2)))
    {
      AppMethodBeat.o(106089);
      return true;
    }
    AppMethodBeat.o(106089);
    return false;
  }
  
  private static void t(Runnable paramRunnable)
  {
    AppMethodBeat.i(224568);
    h.MqF.i(paramRunnable, "FloatBallLoopTag");
    AppMethodBeat.o(224568);
  }
  
  public final void V(boolean paramBoolean)
  {
    AppMethodBeat.i(106082);
    if ((this.nLK != null) && (this.nLM != null)) {
      this.nLM.a(this.nLK, paramBoolean);
    }
    AppMethodBeat.o(106082);
  }
  
  public final void WX(String paramString)
  {
    AppMethodBeat.i(106081);
    if ((this.nLK != null) && (!bu.isNullOrNil(paramString)) && (!eE(this.nLK.dEM, paramString)))
    {
      ae.i("MicroMsg.FloatBallHelper", "updateIcon, icon:%s", new Object[] { paramString });
      this.nLK.dEM = paramString;
      bLz();
    }
    AppMethodBeat.o(106081);
  }
  
  public void WY(String paramString)
  {
    AppMethodBeat.i(106083);
    if ((this.nLK != null) && (!bu.isNullOrNil(paramString)))
    {
      String str = paramString;
      if (paramString.length() > 50) {
        str = paramString.substring(0, 50);
      }
      if (!eE(this.nLK.name, str))
      {
        ae.i("MicroMsg.FloatBallHelper", "updateName, name:%s", new Object[] { str });
        this.nLK.name = str;
        bLz();
      }
    }
    AppMethodBeat.o(106083);
  }
  
  public final void WZ(String paramString)
  {
    AppMethodBeat.i(106084);
    if ((this.nLK != null) && (!bu.isNullOrNil(paramString)) && (!eE(this.nLK.desc, paramString)))
    {
      ae.i("MicroMsg.FloatBallHelper", "updateDesc, desc:%s", new Object[] { paramString });
      this.nLK.desc = paramString;
      bLz();
    }
    AppMethodBeat.o(106084);
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(209436);
    if (this.nLM != null) {
      this.nLM.a(paramResultReceiver);
    }
    AppMethodBeat.o(209436);
  }
  
  public void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(106063);
    this.nLK = new BallInfo(paramInt, paramString);
    this.nLL = paramInt;
    paramString = bLs();
    if (paramString != null)
    {
      ae.i("MicroMsg.FloatBallHelper", "replaceCurrentBallIfNeed, replace current ball");
      this.nLK = paramString;
    }
    if (this.nLM != null) {
      this.nLM.a(this.nLK, this.cpd);
    }
    AppMethodBeat.o(106063);
  }
  
  protected void ad(int paramInt, String paramString) {}
  
  public final void b(com.tencent.mm.plugin.ball.c.i parami)
  {
    AppMethodBeat.i(176958);
    if ((this.nLM != null) && (parami != null)) {
      this.nLM.a(parami);
    }
    AppMethodBeat.o(176958);
  }
  
  public final BallInfo bKS()
  {
    AppMethodBeat.i(106071);
    if (this.nLM != null)
    {
      BallInfo localBallInfo = this.nLM.i(this.nLK);
      AppMethodBeat.o(106071);
      return localBallInfo;
    }
    AppMethodBeat.o(106071);
    return null;
  }
  
  public final void bKY()
  {
    AppMethodBeat.i(106069);
    if (this.nLM != null) {
      this.nLM.bKY();
    }
    AppMethodBeat.o(106069);
  }
  
  public final void bLA()
  {
    AppMethodBeat.i(106079);
    if (this.nLM != null) {
      this.nLM.iN(true);
    }
    AppMethodBeat.o(106079);
  }
  
  public final void bLB()
  {
    AppMethodBeat.i(106080);
    if (this.nLM != null) {
      this.nLM.iM(true);
    }
    AppMethodBeat.o(106080);
  }
  
  public final void bLC()
  {
    AppMethodBeat.i(209439);
    if (this.nLM != null) {
      this.nLM.a(System.currentTimeMillis(), null);
    }
    AppMethodBeat.o(209439);
  }
  
  public final BallReportInfo bLD()
  {
    AppMethodBeat.i(106088);
    if (this.nLK == null)
    {
      localObject = new IllegalStateException("call FloatBallHelper#onCreate first");
      AppMethodBeat.o(106088);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nLK.nLw;
    AppMethodBeat.o(106088);
    return localObject;
  }
  
  public final BallInfo bLE()
  {
    return this.nLK;
  }
  
  protected boolean bLF()
  {
    AppMethodBeat.i(209440);
    boolean bool = bhq();
    AppMethodBeat.o(209440);
    return bool;
  }
  
  final boolean bLG()
  {
    return this.nLK.type == 20;
  }
  
  public final void bLH()
  {
    AppMethodBeat.i(224567);
    if (this.nLM != null) {
      this.nLM.u(this.nLK);
    }
    AppMethodBeat.o(224567);
  }
  
  public void bLp()
  {
    AppMethodBeat.i(106066);
    t(new a.2(this));
    AppMethodBeat.o(106066);
  }
  
  protected final boolean bLq()
  {
    AppMethodBeat.i(209435);
    if ((!bLw()) && (bhq()))
    {
      AppMethodBeat.o(209435);
      return true;
    }
    AppMethodBeat.o(209435);
    return false;
  }
  
  public BallInfo bLs()
  {
    AppMethodBeat.i(106072);
    BallInfo localBallInfo = bLu();
    AppMethodBeat.o(106072);
    return localBallInfo;
  }
  
  public final BallInfo bLu()
  {
    AppMethodBeat.i(106073);
    if (this.nLK != null)
    {
      String str = this.nLK.bLl();
      ae.v("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV ballInfoKey: %s", new Object[] { str });
      str = ay.aRW(bLr()).decodeString(str);
      if (!bu.isNullOrNil(str))
      {
        BallInfo localBallInfo = WW(str);
        ae.i("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, data:%s, ballInfo:%s", new Object[] { str, localBallInfo });
        AppMethodBeat.o(106073);
        return localBallInfo;
      }
      ae.w("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, no saved data");
    }
    AppMethodBeat.o(106073);
    return null;
  }
  
  public final boolean bLv()
  {
    AppMethodBeat.i(106074);
    if (this.nLM != null)
    {
      boolean bool = this.nLM.j(this.nLK);
      AppMethodBeat.o(106074);
      return bool;
    }
    AppMethodBeat.o(106074);
    return false;
  }
  
  public final boolean bLw()
  {
    AppMethodBeat.i(106075);
    if (this.nLM != null)
    {
      if (this.nLM.i(this.nLK) != null)
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
  
  public void bLx()
  {
    AppMethodBeat.i(106076);
    if (this.nLM != null) {
      this.nLM.m(this.nLK);
    }
    AppMethodBeat.o(106076);
  }
  
  public void bLy()
  {
    AppMethodBeat.i(106077);
    if (this.nLM != null) {
      this.nLM.k(this.nLK);
    }
    AppMethodBeat.o(106077);
  }
  
  public void bLz()
  {
    AppMethodBeat.i(106078);
    if (this.nLM != null) {
      this.nLM.l(this.nLK);
    }
    AppMethodBeat.o(106078);
  }
  
  public boolean bhh()
  {
    return false;
  }
  
  public boolean bhi()
  {
    return false;
  }
  
  public void bhj()
  {
    AppMethodBeat.i(106065);
    t(new FloatBallHelper.3(this));
    AppMethodBeat.o(106065);
  }
  
  public void bhk()
  {
    AppMethodBeat.i(106067);
    t(new a.3(this));
    AppMethodBeat.o(106067);
  }
  
  protected void bhl() {}
  
  protected void bhm() {}
  
  public boolean bhq()
  {
    return false;
  }
  
  public final void eD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(106087);
    if ((this.nLK != null) && ((!this.nLK.hasExtra(paramString1)) || (!eE(this.nLK.eC(paramString1, paramString2), paramString2))))
    {
      ae.m("MicroMsg.FloatBallHelper", "updateStringExtra, %s:%s", new Object[] { paramString1, paramString2 });
      this.nLK.eB(paramString1, paramString2);
      bLz();
    }
    AppMethodBeat.o(106087);
  }
  
  public final void iK(boolean paramBoolean)
  {
    AppMethodBeat.i(224566);
    o(paramBoolean, 2);
    AppMethodBeat.o(224566);
  }
  
  public final void iV(boolean paramBoolean)
  {
    AppMethodBeat.i(106086);
    if ((this.nLK != null) && (this.nLK.nLu != paramBoolean))
    {
      ae.i("MicroMsg.FloatBallHelper", "updatePassive, passive:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.nLK.nLu = paramBoolean;
      bLz();
    }
    AppMethodBeat.o(106086);
  }
  
  public final void iW(boolean paramBoolean)
  {
    AppMethodBeat.i(176959);
    if ((this.nLK != null) && (this.nLK.nLv != paramBoolean))
    {
      ae.i("MicroMsg.FloatBallHelper", "updateHidden, hidden:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.nLK.nLv = paramBoolean;
      bLz();
    }
    AppMethodBeat.o(176959);
  }
  
  public void o(boolean paramBoolean, int paramInt) {}
  
  public void onDestroy()
  {
    AppMethodBeat.i(106064);
    if (this.nLM != null) {
      this.nLM.t(this.nLK);
    }
    AppMethodBeat.o(106064);
  }
  
  public boolean sy(int paramInt)
  {
    return false;
  }
  
  public final void tt(long paramLong)
  {
    AppMethodBeat.i(184560);
    if ((this.nLK != null) && (this.nLK.progress != paramLong))
    {
      ae.v("MicroMsg.FloatBallHelper", "updateProgress, progress:%d", new Object[] { Long.valueOf(paramLong) });
      this.nLK.progress = paramLong;
      bLz();
    }
    AppMethodBeat.o(184560);
  }
  
  protected void yb(int paramInt) {}
  
  public final void yc(int paramInt)
  {
    AppMethodBeat.i(106085);
    if ((this.nLK != null) && (this.nLK.state != paramInt))
    {
      ae.i("MicroMsg.FloatBallHelper", "updateState, state:%s", new Object[] { Integer.valueOf(paramInt) });
      this.nLK.state = paramInt;
      bLz();
    }
    AppMethodBeat.o(106085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.a
 * JD-Core Version:    0.7.0.1
 */