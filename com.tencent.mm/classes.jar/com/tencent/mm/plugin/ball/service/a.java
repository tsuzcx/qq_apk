package com.tencent.mm.plugin.ball.service;

import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private ResultReceiver cBu;
  public BallInfo oWE;
  protected int oWF;
  protected b oWG;
  protected FloatBallProxyUI.a oWH;
  protected ResultReceiver oWI;
  
  public a()
  {
    AppMethodBeat.i(106062);
    this.oWI = new FloatBallHelper.1(this, MMHandler.createFreeHandler(Looper.getMainLooper()));
    this.cBu = new FloatBallHelper.6(this, MMHandler.createFreeHandler(Looper.getMainLooper()));
    this.oWG = ((b)g.af(b.class));
    this.oWH = new FloatBallProxyUI.a()
    {
      public final void eU(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(216970);
        Log.i("MicroMsg.FloatBallHelper", "floatBallProxyUIResultCallback, reach count limit, callback: %d", new Object[] { Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt2 == 1)
        {
          Log.i("MicroMsg.FloatBallHelper", "floatBallProxyUIResultCallback, show float menu view");
          a.this.a(a.this.oWI);
          AppMethodBeat.o(216970);
          return;
        }
        if ((paramAnonymousInt2 == 2) && (paramAnonymousInt1 == 1) && (a.this.oWE != null))
        {
          a.this.oWE.oWs.oWz = 2;
          ((b)g.af(b.class)).r(a.this.oWE);
        }
        AppMethodBeat.o(216970);
      }
    };
    AppMethodBeat.o(106062);
  }
  
  private BallInfo agR(String paramString)
  {
    AppMethodBeat.i(216977);
    try
    {
      paramString = BallInfo.av(new JSONObject(paramString));
      AppMethodBeat.o(216977);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallHelper", paramString, "getCurrentBallFromMMKV:%s", new Object[] { this.oWE });
      AppMethodBeat.o(216977);
    }
    return null;
  }
  
  private static String cik()
  {
    AppMethodBeat.i(106068);
    int i = com.tencent.mm.kernel.a.azs();
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
  
  public static int cip()
  {
    AppMethodBeat.i(216978);
    int i = MultiProcessMMKV.getMMKV(cik()).decodeInt("ActiveCount", 0);
    AppMethodBeat.o(216978);
    return i;
  }
  
  private static boolean eV(String paramString1, String paramString2)
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
  
  private static void v(Runnable paramRunnable)
  {
    AppMethodBeat.i(216982);
    h.RTc.e(paramRunnable, "FloatBallLoopTag");
    AppMethodBeat.o(216982);
  }
  
  protected void BG(int paramInt) {}
  
  public final void BH(int paramInt)
  {
    AppMethodBeat.i(106085);
    if ((this.oWE != null) && (this.oWE.state != paramInt))
    {
      Log.i("MicroMsg.FloatBallHelper", "updateState, state:%s", new Object[] { Integer.valueOf(paramInt) });
      this.oWE.state = paramInt;
      cit();
    }
    AppMethodBeat.o(106085);
  }
  
  public final void Bz(long paramLong)
  {
    AppMethodBeat.i(184560);
    if ((this.oWE != null) && (this.oWE.progress != paramLong))
    {
      Log.v("MicroMsg.FloatBallHelper", "updateProgress, progress:%d", new Object[] { Long.valueOf(paramLong) });
      this.oWE.progress = paramLong;
      cit();
    }
    AppMethodBeat.o(184560);
  }
  
  public void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(106063);
    this.oWE = new BallInfo(paramInt, paramString);
    this.oWF = paramInt;
    paramString = cim();
    if (paramString != null)
    {
      Log.i("MicroMsg.FloatBallHelper", "replaceCurrentBallIfNeed, replace current ball");
      this.oWE = paramString;
    }
    if (this.oWG != null) {
      this.oWG.a(this.oWE, this.cBu);
    }
    AppMethodBeat.o(106063);
  }
  
  public final void U(boolean paramBoolean)
  {
    AppMethodBeat.i(106082);
    if ((this.oWE != null) && (this.oWG != null)) {
      this.oWG.a(this.oWE, paramBoolean);
    }
    AppMethodBeat.o(106082);
  }
  
  public final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(216976);
    if (this.oWG != null) {
      this.oWG.a(paramResultReceiver);
    }
    AppMethodBeat.o(216976);
  }
  
  public void aGf()
  {
    AppMethodBeat.i(106066);
    v(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216972);
        if (a.this.oWG != null) {
          a.this.oWG.p(a.this.oWE);
        }
        if (a.this.oWE != null)
        {
          a.a(a.this);
          a.b(a.this);
        }
        AppMethodBeat.o(216972);
      }
    });
    AppMethodBeat.o(106066);
  }
  
  public boolean aGg()
  {
    return false;
  }
  
  public boolean aGh()
  {
    return false;
  }
  
  protected void aGi() {}
  
  public void aGj()
  {
    AppMethodBeat.i(106067);
    v(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216973);
        if (a.this.oWG != null) {
          a.this.oWG.q(a.this.oWE);
        }
        if (a.this.oWE != null)
        {
          if (a.this.cij()) {
            a.this.ciu();
          }
          ((com.tencent.mm.plugin.ball.c.a)g.af(com.tencent.mm.plugin.ball.c.a.class)).d(a.this.oWE.oWs.hDa, a.this.ciq(), a.this.bCG());
        }
        AppMethodBeat.o(216973);
      }
    });
    AppMethodBeat.o(106067);
  }
  
  protected void ag(int paramInt, String paramString) {}
  
  public final void agS(String paramString)
  {
    AppMethodBeat.i(106081);
    if ((this.oWE != null) && (!Util.isNullOrNil(paramString)) && (!eV(this.oWE.icon, paramString)))
    {
      Log.i("MicroMsg.FloatBallHelper", "updateIcon, icon:%s", new Object[] { paramString });
      this.oWE.icon = paramString;
      cit();
    }
    AppMethodBeat.o(106081);
  }
  
  public void agT(String paramString)
  {
    AppMethodBeat.i(106083);
    if ((this.oWE != null) && (!Util.isNullOrNil(paramString)))
    {
      String str = paramString;
      if (paramString.length() > 50) {
        str = paramString.substring(0, 50);
      }
      if (!eV(this.oWE.name, str))
      {
        Log.i("MicroMsg.FloatBallHelper", "updateName, name:%s", new Object[] { str });
        this.oWE.name = str;
        cit();
      }
    }
    AppMethodBeat.o(106083);
  }
  
  public final void agU(String paramString)
  {
    AppMethodBeat.i(106084);
    if ((this.oWE != null) && (!Util.isNullOrNil(paramString)) && (!eV(this.oWE.desc, paramString)))
    {
      Log.i("MicroMsg.FloatBallHelper", "updateDesc, desc:%s", new Object[] { paramString });
      this.oWE.desc = paramString;
      cit();
    }
    AppMethodBeat.o(106084);
  }
  
  public void bCA()
  {
    AppMethodBeat.i(106065);
    v(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216971);
        if (a.this.oWG != null) {
          a.this.oWG.o(a.this.oWE);
        }
        if (a.this.oWE != null)
        {
          a.a(a.this);
          a.b(a.this);
        }
        AppMethodBeat.o(216971);
      }
    });
    AppMethodBeat.o(106065);
  }
  
  protected void bCB() {}
  
  public boolean bCG()
  {
    return false;
  }
  
  protected final boolean cij()
  {
    AppMethodBeat.i(216975);
    if ((bCG()) && (!ciq()))
    {
      AppMethodBeat.o(216975);
      return true;
    }
    AppMethodBeat.o(216975);
    return false;
  }
  
  public final BallInfo cil()
  {
    AppMethodBeat.i(106071);
    if (this.oWG != null)
    {
      BallInfo localBallInfo = this.oWG.h(this.oWE);
      AppMethodBeat.o(106071);
      return localBallInfo;
    }
    AppMethodBeat.o(106071);
    return null;
  }
  
  public BallInfo cim()
  {
    AppMethodBeat.i(106072);
    BallInfo localBallInfo = cin();
    AppMethodBeat.o(106072);
    return localBallInfo;
  }
  
  public final BallInfo cin()
  {
    AppMethodBeat.i(106073);
    if (this.oWE != null)
    {
      String str = this.oWE.cif();
      Log.v("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV ballInfoKey: %s", new Object[] { str });
      str = MultiProcessMMKV.getMMKV(cik()).decodeString(str);
      if (!Util.isNullOrNil(str))
      {
        BallInfo localBallInfo = agR(str);
        Log.i("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, data:%s, ballInfo:%s", new Object[] { str, localBallInfo });
        AppMethodBeat.o(106073);
        return localBallInfo;
      }
      Log.w("MicroMsg.FloatBallHelper", "getCurrentBallFromMMKV, no saved data");
    }
    AppMethodBeat.o(106073);
    return null;
  }
  
  public final boolean cio()
  {
    AppMethodBeat.i(106074);
    if (this.oWG != null)
    {
      boolean bool = this.oWG.i(this.oWE);
      AppMethodBeat.o(106074);
      return bool;
    }
    AppMethodBeat.o(106074);
    return false;
  }
  
  public final boolean ciq()
  {
    AppMethodBeat.i(106075);
    if (this.oWG != null)
    {
      if (this.oWG.h(this.oWE) != null)
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
  
  public void cir()
  {
    AppMethodBeat.i(106076);
    if (this.oWG != null) {
      this.oWG.l(this.oWE);
    }
    AppMethodBeat.o(106076);
  }
  
  public void cis()
  {
    AppMethodBeat.i(106077);
    if (this.oWG != null) {
      this.oWG.j(this.oWE);
    }
    AppMethodBeat.o(106077);
  }
  
  public void cit()
  {
    AppMethodBeat.i(106078);
    if (this.oWG != null) {
      this.oWG.k(this.oWE);
    }
    AppMethodBeat.o(106078);
  }
  
  public final void ciu()
  {
    AppMethodBeat.i(216979);
    if (this.oWG != null) {
      this.oWG.t(this.oWE);
    }
    AppMethodBeat.o(216979);
  }
  
  public final void civ()
  {
    AppMethodBeat.i(258574);
    cit();
    AppMethodBeat.o(258574);
  }
  
  public final BallReportInfo ciw()
  {
    AppMethodBeat.i(106088);
    if (this.oWE == null)
    {
      localObject = new IllegalStateException("call FloatBallHelper#onCreate first");
      AppMethodBeat.o(106088);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oWE.oWs;
    AppMethodBeat.o(106088);
    return localObject;
  }
  
  public final BallInfo cix()
  {
    return this.oWE;
  }
  
  protected boolean ciy()
  {
    AppMethodBeat.i(216981);
    boolean bool = bCG();
    AppMethodBeat.o(216981);
    return bool;
  }
  
  final boolean ciz()
  {
    return this.oWE.type == 20;
  }
  
  public final void cjk()
  {
    AppMethodBeat.i(106080);
    if (this.oWG != null) {
      this.oWG.jL(true);
    }
    AppMethodBeat.o(106080);
  }
  
  public final void eU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(106087);
    if ((this.oWE != null) && ((!this.oWE.hasExtra(paramString1)) || (!eV(this.oWE.eT(paramString1, paramString2), paramString2))))
    {
      Log.printInfoStack("MicroMsg.FloatBallHelper", "updateStringExtra, %s:%s", new Object[] { paramString1, paramString2 });
      this.oWE.eS(paramString1, paramString2);
      cit();
    }
    AppMethodBeat.o(106087);
  }
  
  public final void fwa()
  {
    AppMethodBeat.i(106069);
    if (this.oWG != null) {
      this.oWG.fwa();
    }
    AppMethodBeat.o(106069);
  }
  
  public final void gcN()
  {
    AppMethodBeat.i(106079);
    if (this.oWG != null) {
      this.oWG.jM(true);
    }
    AppMethodBeat.o(106079);
  }
  
  public final void gcO()
  {
    AppMethodBeat.i(258573);
    if (this.oWG != null) {
      this.oWG.a(System.currentTimeMillis(), null);
    }
    AppMethodBeat.o(258573);
  }
  
  public final void jT(boolean paramBoolean)
  {
    AppMethodBeat.i(106086);
    if ((this.oWE != null) && (this.oWE.oWr != paramBoolean))
    {
      Log.i("MicroMsg.FloatBallHelper", "updatePassive, passive:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.oWE.oWr = paramBoolean;
      cit();
    }
    AppMethodBeat.o(106086);
  }
  
  public final void jU(boolean paramBoolean)
  {
    AppMethodBeat.i(176959);
    if ((this.oWE != null) && (this.oWE.nno != paramBoolean))
    {
      Log.i("MicroMsg.FloatBallHelper", "updateHidden, hidden:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.oWE.nno = paramBoolean;
      cit();
    }
    AppMethodBeat.o(176959);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106064);
    if (this.oWG != null) {
      this.oWG.s(this.oWE);
    }
    AppMethodBeat.o(106064);
  }
  
  public boolean wu(int paramInt)
  {
    return false;
  }
  
  public void y(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.a
 * JD-Core Version:    0.7.0.1
 */