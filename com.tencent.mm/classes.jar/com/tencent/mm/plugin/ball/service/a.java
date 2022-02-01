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
  private ResultReceiver coZ;
  public BallInfo nGj;
  protected int nGk;
  protected c nGl;
  public ResultReceiver nGm;
  
  public a()
  {
    AppMethodBeat.i(106062);
    this.nGm = new FloatBallHelper.1(this, ap.createFreeHandler(Looper.getMainLooper()));
    this.coZ = new FloatBallHelper.2(this, ap.createFreeHandler(Looper.getMainLooper()));
    this.nGl = ((c)g.ab(c.class));
    AppMethodBeat.o(106062);
  }
  
  private BallInfo Wk(String paramString)
  {
    AppMethodBeat.i(217252);
    try
    {
      paramString = BallInfo.ad(new JSONObject(paramString));
      AppMethodBeat.o(217252);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.FloatBallHelper", paramString, "getCurrentBallFromMMKV:%s", new Object[] { this.nGj });
      AppMethodBeat.o(217252);
    }
    return null;
  }
  
  private void bKK()
  {
    AppMethodBeat.i(217255);
    if (bgI())
    {
      BallInfo localBallInfo = bKw();
      if (localBallInfo != null)
      {
        BallReportInfo localBallReportInfo = this.nGj.nFZ;
        this.nGj = localBallInfo;
        this.nGj.b(localBallReportInfo);
        ad.i("MicroMsg.FloatBallHelper", "replaceMessageBallIfNeed, replace current message ball reportInfo: %s", new Object[] { this.nGj.nFZ });
      }
    }
    AppMethodBeat.o(217255);
  }
  
  private void bKL()
  {
    AppMethodBeat.i(217256);
    ad.i("MicroMsg.FloatBallHelper", "alvinluo removeMessageBallIfNeed enable: %b, isFromMessageFloatBall: %b, ballInfo.contentType: %d, originFloatBallType: %d", new Object[] { Boolean.valueOf(bKI()), Boolean.valueOf(bKJ()), Integer.valueOf(this.nGj.beN), Integer.valueOf(this.nGk) });
    if ((bgI()) && (bKI()) && (bKJ()) && (this.nGl != null)) {
      this.nGl.xU(this.nGk);
    }
    AppMethodBeat.o(217256);
  }
  
  static String bKu()
  {
    AppMethodBeat.i(106068);
    int i = com.tencent.mm.kernel.a.aiN();
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
  
  private BallInfo bKw()
  {
    AppMethodBeat.i(217251);
    ad.d("MicroMsg.FloatBallHelper", "getCurrentMessageBallInner enableMessageFloatBall: %b", new Object[] { Boolean.valueOf(bgI()) });
    if ((bgI()) && (this.nGj != null))
    {
      Object localObject = String.format("%s#%s", new Object[] { Integer.valueOf(20), this.nGj.key });
      localObject = ax.aQz(bKu()).decodeString((String)localObject);
      ad.d("MicroMsg.FloatBallHelper", "getCurrentMessageBallInner enableMessageFloatBall data: %s", new Object[] { localObject });
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = Wk((String)localObject);
        AppMethodBeat.o(217251);
        return localObject;
      }
    }
    AppMethodBeat.o(217251);
    return null;
  }
  
  private static boolean eB(String paramString1, String paramString2)
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
  
  public final void V(boolean paramBoolean)
  {
    AppMethodBeat.i(106082);
    if ((this.nGj != null) && (this.nGl != null)) {
      this.nGl.a(this.nGj, paramBoolean);
    }
    AppMethodBeat.o(106082);
  }
  
  public final void Wl(String paramString)
  {
    AppMethodBeat.i(106081);
    if ((this.nGj != null) && (!bt.isNullOrNil(paramString)) && (!eB(this.nGj.dDH, paramString)))
    {
      ad.i("MicroMsg.FloatBallHelper", "updateIcon, icon:%s", new Object[] { paramString });
      this.nGj.dDH = paramString;
      bKC();
    }
    AppMethodBeat.o(106081);
  }
  
  public void Wm(String paramString)
  {
    AppMethodBeat.i(106083);
    if ((this.nGj != null) && (!bt.isNullOrNil(paramString)))
    {
      String str = paramString;
      if (paramString.length() > 50) {
        str = paramString.substring(0, 50);
      }
      if (!eB(this.nGj.name, str))
      {
        ad.i("MicroMsg.FloatBallHelper", "updateName, name:%s", new Object[] { str });
        this.nGj.name = str;
        bKC();
      }
    }
    AppMethodBeat.o(106083);
  }
  
  public final void Wn(String paramString)
  {
    AppMethodBeat.i(106084);
    if ((this.nGj != null) && (!bt.isNullOrNil(paramString)) && (!eB(this.nGj.desc, paramString)))
    {
      ad.i("MicroMsg.FloatBallHelper", "updateDesc, desc:%s", new Object[] { paramString });
      this.nGj.desc = paramString;
      bKC();
    }
    AppMethodBeat.o(106084);
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(217250);
    if (this.nGl != null) {
      this.nGl.a(paramResultReceiver);
    }
    AppMethodBeat.o(217250);
  }
  
  public void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(106063);
    this.nGj = new BallInfo(paramInt, paramString);
    this.nGk = paramInt;
    paramString = bKv();
    if (paramString != null)
    {
      ad.i("MicroMsg.FloatBallHelper", "replaceCurrentBallIfNeed, replace current ball");
      this.nGj = paramString;
    }
    if (this.nGl != null) {
      this.nGl.a(this.nGj, this.coZ);
    }
    AppMethodBeat.o(106063);
  }
  
  protected void ad(int paramInt, String paramString) {}
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(176958);
    if ((this.nGl != null) && (paramh != null)) {
      this.nGl.a(paramh);
    }
    AppMethodBeat.o(176958);
  }
  
  public final BallInfo bJU()
  {
    AppMethodBeat.i(106071);
    if (this.nGl != null)
    {
      BallInfo localBallInfo = this.nGl.i(this.nGj);
      AppMethodBeat.o(106071);
      return localBallInfo;
    }
    AppMethodBeat.o(106071);
    return null;
  }
  
  public void bKA()
  {
    AppMethodBeat.i(106076);
    if (this.nGl != null) {
      this.nGl.m(this.nGj);
    }
    AppMethodBeat.o(106076);
  }
  
  public void bKB()
  {
    AppMethodBeat.i(106077);
    if (this.nGl != null) {
      this.nGl.k(this.nGj);
    }
    AppMethodBeat.o(106077);
  }
  
  public void bKC()
  {
    AppMethodBeat.i(106078);
    if (this.nGl != null) {
      this.nGl.l(this.nGj);
    }
    AppMethodBeat.o(106078);
  }
  
  public final void bKD()
  {
    AppMethodBeat.i(106079);
    if (this.nGl != null) {
      this.nGl.iO(true);
    }
    AppMethodBeat.o(106079);
  }
  
  public final void bKE()
  {
    AppMethodBeat.i(106080);
    if (this.nGl != null) {
      this.nGl.iN(true);
    }
    AppMethodBeat.o(106080);
  }
  
  public final void bKF()
  {
    AppMethodBeat.i(217253);
    if (this.nGl != null) {
      this.nGl.a(System.currentTimeMillis(), null);
    }
    AppMethodBeat.o(217253);
  }
  
  public final BallReportInfo bKG()
  {
    AppMethodBeat.i(106088);
    if (this.nGj == null)
    {
      localObject = new IllegalStateException("call FloatBallHelper#onCreate first");
      AppMethodBeat.o(106088);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nGj.nFZ;
    AppMethodBeat.o(106088);
    return localObject;
  }
  
  public final BallInfo bKH()
  {
    return this.nGj;
  }
  
  protected boolean bKI()
  {
    AppMethodBeat.i(217254);
    boolean bool = bgI();
    AppMethodBeat.o(217254);
    return bool;
  }
  
  final boolean bKJ()
  {
    return this.nGj.type == 20;
  }
  
  public final void bKa()
  {
    AppMethodBeat.i(106069);
    if (this.nGl != null) {
      this.nGl.bKa();
    }
    AppMethodBeat.o(106069);
  }
  
  public void bKs()
  {
    AppMethodBeat.i(106066);
    if (this.nGl != null) {
      this.nGl.q(this.nGj);
    }
    if (this.nGj != null)
    {
      bKK();
      bKL();
    }
    AppMethodBeat.o(106066);
  }
  
  protected final boolean bKt()
  {
    AppMethodBeat.i(217249);
    if ((!bKz()) && (bgI()))
    {
      AppMethodBeat.o(217249);
      return true;
    }
    AppMethodBeat.o(217249);
    return false;
  }
  
  public BallInfo bKv()
  {
    AppMethodBeat.i(106072);
    BallInfo localBallInfo = bKx();
    AppMethodBeat.o(106072);
    return localBallInfo;
  }
  
  public final BallInfo bKx()
  {
    AppMethodBeat.i(106073);
    if (this.nGj != null)
    {
      String str = this.nGj.bKo();
      ad.v("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV ballInfoKey: %s", new Object[] { str });
      str = ax.aQz(bKu()).decodeString(str);
      if (!bt.isNullOrNil(str))
      {
        BallInfo localBallInfo = Wk(str);
        ad.i("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, data:%s, ballInfo:%s", new Object[] { str, localBallInfo });
        AppMethodBeat.o(106073);
        return localBallInfo;
      }
      ad.w("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, no saved data");
    }
    AppMethodBeat.o(106073);
    return null;
  }
  
  public final boolean bKy()
  {
    AppMethodBeat.i(106074);
    if (this.nGl != null)
    {
      boolean bool = this.nGl.j(this.nGj);
      AppMethodBeat.o(106074);
      return bool;
    }
    AppMethodBeat.o(106074);
    return false;
  }
  
  public final boolean bKz()
  {
    AppMethodBeat.i(106075);
    if (this.nGl != null)
    {
      if (this.nGl.i(this.nGj) != null)
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
  
  public boolean bgA()
  {
    return false;
  }
  
  public void bgB()
  {
    AppMethodBeat.i(106065);
    if (this.nGl != null) {
      this.nGl.p(this.nGj);
    }
    if (this.nGj != null)
    {
      bKK();
      bKL();
    }
    AppMethodBeat.o(106065);
  }
  
  public void bgC()
  {
    AppMethodBeat.i(106067);
    if (this.nGl != null) {
      this.nGl.r(this.nGj);
    }
    if (this.nGj != null)
    {
      if ((bKt()) && (this.nGl != null)) {
        this.nGl.t(this.nGj);
      }
      ((b)g.ab(b.class)).c(this.nGj.nFZ.nGc, bKz(), bgI());
    }
    AppMethodBeat.o(106067);
  }
  
  protected void bgD() {}
  
  protected void bgE() {}
  
  public boolean bgI()
  {
    return false;
  }
  
  public boolean bgz()
  {
    return false;
  }
  
  public final void eA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(106087);
    if ((this.nGj != null) && ((!this.nGj.hasExtra(paramString1)) || (!eB(this.nGj.ez(paramString1, paramString2), paramString2))))
    {
      ad.m("MicroMsg.FloatBallHelper", "updateStringExtra, %s:%s", new Object[] { paramString1, paramString2 });
      this.nGj.ey(paramString1, paramString2);
      bKC();
    }
    AppMethodBeat.o(106087);
  }
  
  public void gf(boolean paramBoolean) {}
  
  public final void iW(boolean paramBoolean)
  {
    AppMethodBeat.i(106086);
    if ((this.nGj != null) && (this.nGj.nFX != paramBoolean))
    {
      ad.i("MicroMsg.FloatBallHelper", "updatePassive, passive:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.nGj.nFX = paramBoolean;
      bKC();
    }
    AppMethodBeat.o(106086);
  }
  
  public final void iX(boolean paramBoolean)
  {
    AppMethodBeat.i(176959);
    if ((this.nGj != null) && (this.nGj.nFY != paramBoolean))
    {
      ad.i("MicroMsg.FloatBallHelper", "updateHidden, hidden:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.nGj.nFY = paramBoolean;
      bKC();
    }
    AppMethodBeat.o(176959);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106064);
    if (this.nGl != null) {
      this.nGl.s(this.nGj);
    }
    AppMethodBeat.o(106064);
  }
  
  public boolean sv(int paramInt)
  {
    return false;
  }
  
  public final void tf(long paramLong)
  {
    AppMethodBeat.i(184560);
    if ((this.nGj != null) && (this.nGj.progress != paramLong))
    {
      ad.v("MicroMsg.FloatBallHelper", "updateProgress, progress:%d", new Object[] { Long.valueOf(paramLong) });
      this.nGj.progress = paramLong;
      bKC();
    }
    AppMethodBeat.o(184560);
  }
  
  protected void xX(int paramInt) {}
  
  public final void xY(int paramInt)
  {
    AppMethodBeat.i(106085);
    if ((this.nGj != null) && (this.nGj.state != paramInt))
    {
      ad.i("MicroMsg.FloatBallHelper", "updateState, state:%s", new Object[] { Integer.valueOf(paramInt) });
      this.nGj.state = paramInt;
      bKC();
    }
    AppMethodBeat.o(106085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.a
 * JD-Core Version:    0.7.0.1
 */