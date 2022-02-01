package com.tencent.mm.plugin.ball.service;

import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.c.h;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements com.tencent.mm.plugin.ball.c.a
{
  private ResultReceiver chN;
  public BallInfo mDH;
  protected int mDI;
  protected c mDJ;
  public ResultReceiver mDK;
  
  public a()
  {
    AppMethodBeat.i(106062);
    this.mDK = new FloatBallHelper.1(this, ap.createFreeHandler(Looper.getMainLooper()));
    this.chN = new FloatBallHelper.2(this, ap.createFreeHandler(Looper.getMainLooper()));
    this.mDJ = ((c)g.ab(c.class));
    AppMethodBeat.o(106062);
  }
  
  private BallInfo OC(String paramString)
  {
    AppMethodBeat.i(190605);
    try
    {
      paramString = BallInfo.aa(new JSONObject(paramString));
      AppMethodBeat.o(190605);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.FloatBallHelper", paramString, "getCurrentBallFromMMKV:%s", new Object[] { this.mDH });
      AppMethodBeat.o(190605);
    }
    return null;
  }
  
  private void bzD()
  {
    AppMethodBeat.i(190608);
    if (aWg())
    {
      BallInfo localBallInfo = bzp();
      if (localBallInfo != null)
      {
        BallReportInfo localBallReportInfo = this.mDH.mDw;
        this.mDH = localBallInfo;
        this.mDH.b(localBallReportInfo);
        ad.i("MicroMsg.FloatBallHelper", "replaceMessageBallIfNeed, replace current message ball reportInfo: %s", new Object[] { this.mDH.mDw });
      }
    }
    AppMethodBeat.o(190608);
  }
  
  private void bzE()
  {
    AppMethodBeat.i(190609);
    ad.i("MicroMsg.FloatBallHelper", "alvinluo removeMessageBallIfNeed enable: %b, isFromMessageFloatBall: %b, ballInfo.contentType: %d, originFloatBallType: %d", new Object[] { Boolean.valueOf(bzB()), Boolean.valueOf(bzC()), Integer.valueOf(this.mDH.aTB), Integer.valueOf(this.mDI) });
    if ((aWg()) && (bzB()) && (bzC()) && (this.mDJ != null)) {
      this.mDJ.ww(this.mDI);
    }
    AppMethodBeat.o(190609);
  }
  
  static String bzn()
  {
    AppMethodBeat.i(106068);
    int i = com.tencent.mm.kernel.a.aeL();
    if (i != 0)
    {
      long l = i;
      String str = (l & 0xFFFFFFFF) + "#" + "float_ball_storage";
      ad.i("MicroMsg.FloatBallHelper", "accountDataKey:%s", new Object[] { str });
      AppMethodBeat.o(106068);
      return str;
    }
    ad.i("MicroMsg.FloatBallHelper", "accountDataKey:%s", new Object[] { "float_ball_storage" });
    AppMethodBeat.o(106068);
    return "float_ball_storage";
  }
  
  private BallInfo bzp()
  {
    AppMethodBeat.i(190604);
    ad.d("MicroMsg.FloatBallHelper", "getCurrentMessageBallInner enableMessageFloatBall: %b", new Object[] { Boolean.valueOf(aWg()) });
    if (aWg())
    {
      Object localObject = String.format("%s#%s", new Object[] { Integer.valueOf(19), this.mDH.key });
      localObject = ax.aFC(bzn()).decodeString((String)localObject);
      ad.d("MicroMsg.FloatBallHelper", "getCurrentMessageBallInner enableMessageFloatBall data: %s", new Object[] { localObject });
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = OC((String)localObject);
        AppMethodBeat.o(190604);
        return localObject;
      }
    }
    AppMethodBeat.o(190604);
    return null;
  }
  
  private static boolean eg(String paramString1, String paramString2)
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
    if ((!bt.isNullOrNil(paramString1)) && (!bt.isNullOrNil(paramString2)) && (paramString1.equals(paramString2)))
    {
      AppMethodBeat.o(106089);
      return true;
    }
    AppMethodBeat.o(106089);
    return false;
  }
  
  public final void OD(String paramString)
  {
    AppMethodBeat.i(106081);
    if ((this.mDH != null) && (!bt.isNullOrNil(paramString)) && (!eg(this.mDH.dub, paramString)))
    {
      ad.i("MicroMsg.FloatBallHelper", "updateIcon, icon:%s", new Object[] { paramString });
      this.mDH.dub = paramString;
      bzv();
    }
    AppMethodBeat.o(106081);
  }
  
  public void OE(String paramString)
  {
    AppMethodBeat.i(106083);
    if ((this.mDH != null) && (!bt.isNullOrNil(paramString)))
    {
      String str = paramString;
      if (paramString.length() > 50) {
        str = paramString.substring(0, 50);
      }
      if (!eg(this.mDH.name, str))
      {
        ad.i("MicroMsg.FloatBallHelper", "updateName, name:%s", new Object[] { str });
        this.mDH.name = str;
        bzv();
      }
    }
    AppMethodBeat.o(106083);
  }
  
  public final void OF(String paramString)
  {
    AppMethodBeat.i(106084);
    if ((this.mDH != null) && (!bt.isNullOrNil(paramString)) && (!eg(this.mDH.desc, paramString)))
    {
      ad.i("MicroMsg.FloatBallHelper", "updateDesc, desc:%s", new Object[] { paramString });
      this.mDH.desc = paramString;
      bzv();
    }
    AppMethodBeat.o(106084);
  }
  
  public final void V(boolean paramBoolean)
  {
    AppMethodBeat.i(106082);
    if ((this.mDH != null) && (this.mDJ != null)) {
      this.mDJ.a(this.mDH, paramBoolean);
    }
    AppMethodBeat.o(106082);
  }
  
  public void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(106063);
    this.mDH = new BallInfo(paramInt, paramString);
    this.mDI = paramInt;
    paramString = bzo();
    if (paramString != null)
    {
      ad.i("MicroMsg.FloatBallHelper", "replaceCurrentBallIfNeed, replace current ball");
      this.mDH = paramString;
    }
    if (this.mDJ != null) {
      this.mDJ.a(this.mDH, this.chN);
    }
    AppMethodBeat.o(106063);
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(190603);
    if (this.mDJ != null) {
      this.mDJ.a(paramResultReceiver);
    }
    AppMethodBeat.o(190603);
  }
  
  public boolean aVX()
  {
    return false;
  }
  
  public boolean aVY()
  {
    return false;
  }
  
  public void aVZ()
  {
    AppMethodBeat.i(106065);
    if (this.mDJ != null) {
      this.mDJ.n(this.mDH);
    }
    bzD();
    bzE();
    AppMethodBeat.o(106065);
  }
  
  public void aWa()
  {
    AppMethodBeat.i(106067);
    if (this.mDJ != null) {
      this.mDJ.p(this.mDH);
    }
    if ((bzm()) && (this.mDJ != null)) {
      this.mDJ.r(this.mDH);
    }
    if (this.mDH != null) {
      ((b)g.ab(b.class)).c(this.mDH.mDw.mDz, bzs(), aWg());
    }
    AppMethodBeat.o(106067);
  }
  
  protected void aWb() {}
  
  protected void aWc() {}
  
  public boolean aWg()
  {
    return false;
  }
  
  protected void aa(int paramInt, String paramString) {}
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(176958);
    if ((this.mDJ != null) && (paramh != null)) {
      this.mDJ.a(paramh);
    }
    AppMethodBeat.o(176958);
  }
  
  public final BallInfo byO()
  {
    AppMethodBeat.i(106071);
    if (this.mDJ != null)
    {
      BallInfo localBallInfo = this.mDJ.g(this.mDH);
      AppMethodBeat.o(106071);
      return localBallInfo;
    }
    AppMethodBeat.o(106071);
    return null;
  }
  
  public final void byU()
  {
    AppMethodBeat.i(106069);
    if (this.mDJ != null) {
      this.mDJ.byU();
    }
    AppMethodBeat.o(106069);
  }
  
  public final BallInfo bzA()
  {
    return this.mDH;
  }
  
  protected boolean bzB()
  {
    AppMethodBeat.i(190607);
    boolean bool = aWg();
    AppMethodBeat.o(190607);
    return bool;
  }
  
  final boolean bzC()
  {
    return this.mDH.type == 19;
  }
  
  public void bzl()
  {
    AppMethodBeat.i(106066);
    if (this.mDJ != null) {
      this.mDJ.o(this.mDH);
    }
    bzD();
    bzE();
    AppMethodBeat.o(106066);
  }
  
  protected final boolean bzm()
  {
    AppMethodBeat.i(190602);
    if ((!bzs()) && (aWg()))
    {
      AppMethodBeat.o(190602);
      return true;
    }
    AppMethodBeat.o(190602);
    return false;
  }
  
  public BallInfo bzo()
  {
    AppMethodBeat.i(106072);
    BallInfo localBallInfo = bzq();
    AppMethodBeat.o(106072);
    return localBallInfo;
  }
  
  public final BallInfo bzq()
  {
    AppMethodBeat.i(106073);
    if (this.mDH != null)
    {
      String str = this.mDH.bzh();
      ad.v("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV ballInfoKey: %s", new Object[] { str });
      str = ax.aFC(bzn()).decodeString(str);
      if (!bt.isNullOrNil(str))
      {
        BallInfo localBallInfo = OC(str);
        ad.i("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, data:%s, ballInfo:%s", new Object[] { str, localBallInfo });
        AppMethodBeat.o(106073);
        return localBallInfo;
      }
      ad.w("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, no saved data");
    }
    AppMethodBeat.o(106073);
    return null;
  }
  
  public final boolean bzr()
  {
    AppMethodBeat.i(106074);
    if (this.mDJ != null)
    {
      boolean bool = this.mDJ.h(this.mDH);
      AppMethodBeat.o(106074);
      return bool;
    }
    AppMethodBeat.o(106074);
    return false;
  }
  
  public final boolean bzs()
  {
    AppMethodBeat.i(106075);
    if (this.mDJ != null)
    {
      if (this.mDJ.g(this.mDH) != null)
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
  
  public void bzt()
  {
    AppMethodBeat.i(106076);
    if (this.mDJ != null) {
      this.mDJ.k(this.mDH);
    }
    AppMethodBeat.o(106076);
  }
  
  public void bzu()
  {
    AppMethodBeat.i(106077);
    if (this.mDJ != null) {
      this.mDJ.i(this.mDH);
    }
    AppMethodBeat.o(106077);
  }
  
  public void bzv()
  {
    AppMethodBeat.i(106078);
    if (this.mDJ != null) {
      this.mDJ.j(this.mDH);
    }
    AppMethodBeat.o(106078);
  }
  
  public final void bzw()
  {
    AppMethodBeat.i(106079);
    if (this.mDJ != null) {
      this.mDJ.jdMethod_if(true);
    }
    AppMethodBeat.o(106079);
  }
  
  public final void bzx()
  {
    AppMethodBeat.i(106080);
    if (this.mDJ != null) {
      this.mDJ.ie(true);
    }
    AppMethodBeat.o(106080);
  }
  
  public final void bzy()
  {
    AppMethodBeat.i(190606);
    if (this.mDJ != null) {
      this.mDJ.a(System.currentTimeMillis(), null);
    }
    AppMethodBeat.o(190606);
  }
  
  public final BallReportInfo bzz()
  {
    AppMethodBeat.i(106088);
    if (this.mDH == null)
    {
      localObject = new IllegalStateException("call FloatBallHelper#onCreate first");
      AppMethodBeat.o(106088);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mDH.mDw;
    AppMethodBeat.o(106088);
    return localObject;
  }
  
  public final void ef(String paramString1, String paramString2)
  {
    AppMethodBeat.i(106087);
    if ((this.mDH != null) && ((!this.mDH.hasExtra(paramString1)) || (!eg(this.mDH.ee(paramString1, paramString2), paramString2))))
    {
      ad.m("MicroMsg.FloatBallHelper", "updateStringExtra, %s:%s", new Object[] { paramString1, paramString2 });
      this.mDH.ed(paramString1, paramString2);
      bzv();
    }
    AppMethodBeat.o(106087);
  }
  
  public void fE(boolean paramBoolean) {}
  
  public final void in(boolean paramBoolean)
  {
    AppMethodBeat.i(106086);
    if ((this.mDH != null) && (this.mDH.mDu != paramBoolean))
    {
      ad.i("MicroMsg.FloatBallHelper", "updatePassive, passive:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.mDH.mDu = paramBoolean;
      bzv();
    }
    AppMethodBeat.o(106086);
  }
  
  public final void io(boolean paramBoolean)
  {
    AppMethodBeat.i(176959);
    if ((this.mDH != null) && (this.mDH.mDv != paramBoolean))
    {
      ad.i("MicroMsg.FloatBallHelper", "updateHidden, hidden:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.mDH.mDv = paramBoolean;
      bzv();
    }
    AppMethodBeat.o(176959);
  }
  
  public final void nu(long paramLong)
  {
    AppMethodBeat.i(184560);
    if ((this.mDH != null) && (this.mDH.progress != paramLong))
    {
      ad.v("MicroMsg.FloatBallHelper", "updateProgress, progress:%d", new Object[] { Long.valueOf(paramLong) });
      this.mDH.progress = paramLong;
      bzv();
    }
    AppMethodBeat.o(184560);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106064);
    if (this.mDJ != null) {
      this.mDJ.q(this.mDH);
    }
    AppMethodBeat.o(106064);
  }
  
  public boolean rg(int paramInt)
  {
    return false;
  }
  
  protected void wA(int paramInt) {}
  
  public final void wB(int paramInt)
  {
    AppMethodBeat.i(106085);
    if ((this.mDH != null) && (this.mDH.state != paramInt))
    {
      ad.i("MicroMsg.FloatBallHelper", "updateState, state:%s", new Object[] { Integer.valueOf(paramInt) });
      this.mDH.state = paramInt;
      bzv();
    }
    AppMethodBeat.o(106085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.a
 * JD-Core Version:    0.7.0.1
 */