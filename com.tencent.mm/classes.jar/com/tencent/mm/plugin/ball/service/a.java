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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements com.tencent.mm.plugin.ball.c.a
{
  private ResultReceiver ceI;
  public BallInfo nfN;
  protected int nfO;
  protected c nfP;
  public ResultReceiver nfQ;
  
  public a()
  {
    AppMethodBeat.i(106062);
    this.nfQ = new FloatBallHelper.1(this, ao.createFreeHandler(Looper.getMainLooper()));
    this.ceI = new FloatBallHelper.2(this, ao.createFreeHandler(Looper.getMainLooper()));
    this.nfP = ((c)g.ab(c.class));
    AppMethodBeat.o(106062);
  }
  
  private BallInfo SM(String paramString)
  {
    AppMethodBeat.i(207970);
    try
    {
      paramString = BallInfo.aa(new JSONObject(paramString));
      AppMethodBeat.o(207970);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ac.printErrStackTrace("MicroMsg.FloatBallHelper", paramString, "getCurrentBallFromMMKV:%s", new Object[] { this.nfN });
      AppMethodBeat.o(207970);
    }
    return null;
  }
  
  private void bGA()
  {
    AppMethodBeat.i(207974);
    ac.i("MicroMsg.FloatBallHelper", "alvinluo removeMessageBallIfNeed enable: %b, isFromMessageFloatBall: %b, ballInfo.contentType: %d, originFloatBallType: %d", new Object[] { Boolean.valueOf(bGx()), Boolean.valueOf(bGy()), Integer.valueOf(this.nfN.aUt), Integer.valueOf(this.nfO) });
    if ((bde()) && (bGx()) && (bGy()) && (this.nfP != null)) {
      this.nfP.xo(this.nfO);
    }
    AppMethodBeat.o(207974);
  }
  
  static String bGj()
  {
    AppMethodBeat.i(106068);
    int i = com.tencent.mm.kernel.a.agb();
    if (i != 0)
    {
      long l = i;
      String str = (l & 0xFFFFFFFF) + "#" + "float_ball_storage";
      ac.i("MicroMsg.FloatBallHelper", "accountDataKey:%s", new Object[] { str });
      AppMethodBeat.o(106068);
      return str;
    }
    ac.i("MicroMsg.FloatBallHelper", "accountDataKey:%s", new Object[] { "float_ball_storage" });
    AppMethodBeat.o(106068);
    return "float_ball_storage";
  }
  
  private BallInfo bGl()
  {
    AppMethodBeat.i(207969);
    ac.d("MicroMsg.FloatBallHelper", "getCurrentMessageBallInner enableMessageFloatBall: %b", new Object[] { Boolean.valueOf(bde()) });
    if ((bde()) && (this.nfN != null))
    {
      Object localObject = String.format("%s#%s", new Object[] { Integer.valueOf(20), this.nfN.key });
      localObject = aw.aKT(bGj()).decodeString((String)localObject);
      ac.d("MicroMsg.FloatBallHelper", "getCurrentMessageBallInner enableMessageFloatBall data: %s", new Object[] { localObject });
      if (!bs.isNullOrNil((String)localObject))
      {
        localObject = SM((String)localObject);
        AppMethodBeat.o(207969);
        return localObject;
      }
    }
    AppMethodBeat.o(207969);
    return null;
  }
  
  private void bGz()
  {
    AppMethodBeat.i(207973);
    if (bde())
    {
      BallInfo localBallInfo = bGl();
      if (localBallInfo != null)
      {
        BallReportInfo localBallReportInfo = this.nfN.nfD;
        this.nfN = localBallInfo;
        this.nfN.b(localBallReportInfo);
        ac.i("MicroMsg.FloatBallHelper", "replaceMessageBallIfNeed, replace current message ball reportInfo: %s", new Object[] { this.nfN.nfD });
      }
    }
    AppMethodBeat.o(207973);
  }
  
  private static boolean es(String paramString1, String paramString2)
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
    if ((!bs.isNullOrNil(paramString1)) && (!bs.isNullOrNil(paramString2)) && (paramString1.equals(paramString2)))
    {
      AppMethodBeat.o(106089);
      return true;
    }
    AppMethodBeat.o(106089);
    return false;
  }
  
  public final void SN(String paramString)
  {
    AppMethodBeat.i(106081);
    if ((this.nfN != null) && (!bs.isNullOrNil(paramString)) && (!es(this.nfN.drM, paramString)))
    {
      ac.i("MicroMsg.FloatBallHelper", "updateIcon, icon:%s", new Object[] { paramString });
      this.nfN.drM = paramString;
      bGr();
    }
    AppMethodBeat.o(106081);
  }
  
  public void SO(String paramString)
  {
    AppMethodBeat.i(106083);
    if ((this.nfN != null) && (!bs.isNullOrNil(paramString)))
    {
      String str = paramString;
      if (paramString.length() > 50) {
        str = paramString.substring(0, 50);
      }
      if (!es(this.nfN.name, str))
      {
        ac.i("MicroMsg.FloatBallHelper", "updateName, name:%s", new Object[] { str });
        this.nfN.name = str;
        bGr();
      }
    }
    AppMethodBeat.o(106083);
  }
  
  public final void SP(String paramString)
  {
    AppMethodBeat.i(106084);
    if ((this.nfN != null) && (!bs.isNullOrNil(paramString)) && (!es(this.nfN.desc, paramString)))
    {
      ac.i("MicroMsg.FloatBallHelper", "updateDesc, desc:%s", new Object[] { paramString });
      this.nfN.desc = paramString;
      bGr();
    }
    AppMethodBeat.o(106084);
  }
  
  public final void V(boolean paramBoolean)
  {
    AppMethodBeat.i(106082);
    if ((this.nfN != null) && (this.nfP != null)) {
      this.nfP.a(this.nfN, paramBoolean);
    }
    AppMethodBeat.o(106082);
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(207968);
    if (this.nfP != null) {
      this.nfP.a(paramResultReceiver);
    }
    AppMethodBeat.o(207968);
  }
  
  public void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(106063);
    this.nfN = new BallInfo(paramInt, paramString);
    this.nfO = paramInt;
    paramString = bGk();
    if (paramString != null)
    {
      ac.i("MicroMsg.FloatBallHelper", "replaceCurrentBallIfNeed, replace current ball");
      this.nfN = paramString;
    }
    if (this.nfP != null) {
      this.nfP.a(this.nfN, this.ceI);
    }
    AppMethodBeat.o(106063);
  }
  
  protected void ab(int paramInt, String paramString) {}
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(176958);
    if ((this.nfP != null) && (paramh != null)) {
      this.nfP.a(paramh);
    }
    AppMethodBeat.o(176958);
  }
  
  public final BallInfo bFK()
  {
    AppMethodBeat.i(106071);
    if (this.nfP != null)
    {
      BallInfo localBallInfo = this.nfP.h(this.nfN);
      AppMethodBeat.o(106071);
      return localBallInfo;
    }
    AppMethodBeat.o(106071);
    return null;
  }
  
  public final void bFQ()
  {
    AppMethodBeat.i(106069);
    if (this.nfP != null) {
      this.nfP.bFQ();
    }
    AppMethodBeat.o(106069);
  }
  
  public void bGh()
  {
    AppMethodBeat.i(106066);
    if (this.nfP != null) {
      this.nfP.p(this.nfN);
    }
    if (this.nfN != null)
    {
      bGz();
      bGA();
    }
    AppMethodBeat.o(106066);
  }
  
  protected final boolean bGi()
  {
    AppMethodBeat.i(207967);
    if ((!bGo()) && (bde()))
    {
      AppMethodBeat.o(207967);
      return true;
    }
    AppMethodBeat.o(207967);
    return false;
  }
  
  public BallInfo bGk()
  {
    AppMethodBeat.i(106072);
    BallInfo localBallInfo = bGm();
    AppMethodBeat.o(106072);
    return localBallInfo;
  }
  
  public final BallInfo bGm()
  {
    AppMethodBeat.i(106073);
    if (this.nfN != null)
    {
      String str = this.nfN.bGd();
      ac.v("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV ballInfoKey: %s", new Object[] { str });
      str = aw.aKT(bGj()).decodeString(str);
      if (!bs.isNullOrNil(str))
      {
        BallInfo localBallInfo = SM(str);
        ac.i("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, data:%s, ballInfo:%s", new Object[] { str, localBallInfo });
        AppMethodBeat.o(106073);
        return localBallInfo;
      }
      ac.w("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, no saved data");
    }
    AppMethodBeat.o(106073);
    return null;
  }
  
  public final boolean bGn()
  {
    AppMethodBeat.i(106074);
    if (this.nfP != null)
    {
      boolean bool = this.nfP.i(this.nfN);
      AppMethodBeat.o(106074);
      return bool;
    }
    AppMethodBeat.o(106074);
    return false;
  }
  
  public final boolean bGo()
  {
    AppMethodBeat.i(106075);
    if (this.nfP != null)
    {
      if (this.nfP.h(this.nfN) != null)
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
  
  public void bGp()
  {
    AppMethodBeat.i(106076);
    if (this.nfP != null) {
      this.nfP.l(this.nfN);
    }
    AppMethodBeat.o(106076);
  }
  
  public void bGq()
  {
    AppMethodBeat.i(106077);
    if (this.nfP != null) {
      this.nfP.j(this.nfN);
    }
    AppMethodBeat.o(106077);
  }
  
  public void bGr()
  {
    AppMethodBeat.i(106078);
    if (this.nfP != null) {
      this.nfP.k(this.nfN);
    }
    AppMethodBeat.o(106078);
  }
  
  public final void bGs()
  {
    AppMethodBeat.i(106079);
    if (this.nfP != null) {
      this.nfP.iF(true);
    }
    AppMethodBeat.o(106079);
  }
  
  public final void bGt()
  {
    AppMethodBeat.i(106080);
    if (this.nfP != null) {
      this.nfP.iE(true);
    }
    AppMethodBeat.o(106080);
  }
  
  public final void bGu()
  {
    AppMethodBeat.i(207971);
    if (this.nfP != null) {
      this.nfP.a(System.currentTimeMillis(), null);
    }
    AppMethodBeat.o(207971);
  }
  
  public final BallReportInfo bGv()
  {
    AppMethodBeat.i(106088);
    if (this.nfN == null)
    {
      localObject = new IllegalStateException("call FloatBallHelper#onCreate first");
      AppMethodBeat.o(106088);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nfN.nfD;
    AppMethodBeat.o(106088);
    return localObject;
  }
  
  public final BallInfo bGw()
  {
    return this.nfN;
  }
  
  protected boolean bGx()
  {
    AppMethodBeat.i(207972);
    boolean bool = bde();
    AppMethodBeat.o(207972);
    return bool;
  }
  
  final boolean bGy()
  {
    return this.nfN.type == 20;
  }
  
  public boolean bcV()
  {
    return false;
  }
  
  public boolean bcW()
  {
    return false;
  }
  
  public void bcX()
  {
    AppMethodBeat.i(106065);
    if (this.nfP != null) {
      this.nfP.o(this.nfN);
    }
    if (this.nfN != null)
    {
      bGz();
      bGA();
    }
    AppMethodBeat.o(106065);
  }
  
  public void bcY()
  {
    AppMethodBeat.i(106067);
    if (this.nfP != null) {
      this.nfP.q(this.nfN);
    }
    if (this.nfN != null)
    {
      if ((bGi()) && (this.nfP != null)) {
        this.nfP.s(this.nfN);
      }
      ((b)g.ab(b.class)).c(this.nfN.nfD.nfG, bGo(), bde());
    }
    AppMethodBeat.o(106067);
  }
  
  protected void bcZ() {}
  
  protected void bda() {}
  
  public boolean bde()
  {
    return false;
  }
  
  public final void er(String paramString1, String paramString2)
  {
    AppMethodBeat.i(106087);
    if ((this.nfN != null) && ((!this.nfN.hasExtra(paramString1)) || (!es(this.nfN.eq(paramString1, paramString2), paramString2))))
    {
      ac.m("MicroMsg.FloatBallHelper", "updateStringExtra, %s:%s", new Object[] { paramString1, paramString2 });
      this.nfN.ep(paramString1, paramString2);
      bGr();
    }
    AppMethodBeat.o(106087);
  }
  
  public void ga(boolean paramBoolean) {}
  
  public final void iN(boolean paramBoolean)
  {
    AppMethodBeat.i(106086);
    if ((this.nfN != null) && (this.nfN.nfB != paramBoolean))
    {
      ac.i("MicroMsg.FloatBallHelper", "updatePassive, passive:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.nfN.nfB = paramBoolean;
      bGr();
    }
    AppMethodBeat.o(106086);
  }
  
  public final void iO(boolean paramBoolean)
  {
    AppMethodBeat.i(176959);
    if ((this.nfN != null) && (this.nfN.nfC != paramBoolean))
    {
      ac.i("MicroMsg.FloatBallHelper", "updateHidden, hidden:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.nfN.nfC = paramBoolean;
      bGr();
    }
    AppMethodBeat.o(176959);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106064);
    if (this.nfP != null) {
      this.nfP.r(this.nfN);
    }
    AppMethodBeat.o(106064);
  }
  
  public boolean rT(int paramInt)
  {
    return false;
  }
  
  public final void rg(long paramLong)
  {
    AppMethodBeat.i(184560);
    if ((this.nfN != null) && (this.nfN.progress != paramLong))
    {
      ac.v("MicroMsg.FloatBallHelper", "updateProgress, progress:%d", new Object[] { Long.valueOf(paramLong) });
      this.nfN.progress = paramLong;
      bGr();
    }
    AppMethodBeat.o(184560);
  }
  
  protected void xr(int paramInt) {}
  
  public final void xs(int paramInt)
  {
    AppMethodBeat.i(106085);
    if ((this.nfN != null) && (this.nfN.state != paramInt))
    {
      ac.i("MicroMsg.FloatBallHelper", "updateState, state:%s", new Object[] { Integer.valueOf(paramInt) });
      this.nfN.state = paramInt;
      bGr();
    }
    AppMethodBeat.o(106085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.a
 * JD-Core Version:    0.7.0.1
 */