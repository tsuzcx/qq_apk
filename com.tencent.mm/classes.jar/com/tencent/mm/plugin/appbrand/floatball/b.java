package com.tencent.mm.plugin.appbrand.floatball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class b
  extends com.tencent.mm.plugin.ball.service.f
{
  private static e lqt;
  q kGW;
  
  static
  {
    AppMethodBeat.i(44975);
    lqt = new b.2();
    AppMethodBeat.o(44975);
  }
  
  public b(com.tencent.mm.plugin.ball.a.f paramf, q paramq)
  {
    super(paramf);
    AppMethodBeat.i(44964);
    this.kGW = paramq;
    Log.i("MicroMsg.AppBrandFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramq.hashCode()) });
    AppMethodBeat.o(44964);
  }
  
  public static int b(h.d paramd)
  {
    if (paramd == h.d.kzQ) {
      return 2;
    }
    if (paramd == h.d.kzP) {
      return 1;
    }
    return 0;
  }
  
  public static void bCE()
  {
    AppMethodBeat.i(44972);
    if (g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).a(1, lqt);
    }
    AppMethodBeat.o(44972);
  }
  
  public static void bCF()
  {
    AppMethodBeat.i(44973);
    if (g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).b(1, lqt);
    }
    AppMethodBeat.o(44973);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(44966);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.G(paramInt, paramString);
    AppMethodBeat.o(44966);
  }
  
  public final void a(final com.tencent.mm.plugin.ball.service.f.a parama)
  {
    AppMethodBeat.i(226533);
    f localf = (f)this.kGW.aw(f.class);
    if ((localf != null) && (localf.bCL()))
    {
      localf.a(AndroidContextUtil.castActivityOrNull(this.kGW.mContext), new f.a()
      {
        public final void bCH()
        {
          AppMethodBeat.i(226531);
          Log.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, afterShowVOIPTip");
          if (parama != null) {
            parama.proceed();
          }
          AppMethodBeat.o(226531);
        }
      });
      AppMethodBeat.o(226533);
      return;
    }
    Log.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, not show vpip tip");
    parama.proceed();
    AppMethodBeat.o(226533);
  }
  
  public final boolean aGg()
  {
    return false;
  }
  
  public final boolean aGh()
  {
    AppMethodBeat.i(44965);
    if (!this.kGW.bsC().ldN)
    {
      AppMethodBeat.o(44965);
      return true;
    }
    AppMethodBeat.o(44965);
    return false;
  }
  
  public final void aGi()
  {
    AppMethodBeat.i(44971);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    this.oXA.hb(true);
    AppMethodBeat.o(44971);
  }
  
  public final void aGj()
  {
    AppMethodBeat.i(44970);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    super.aGj();
    AppMethodBeat.o(44970);
  }
  
  public final void bCA()
  {
    AppMethodBeat.i(44969);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    if (AppBrandRuntimeWCAccessible.isGame(this.kGW))
    {
      super.aGf();
      AppMethodBeat.o(44969);
      return;
    }
    super.bCA();
    AppMethodBeat.o(44969);
  }
  
  public final boolean bCG()
  {
    AppMethodBeat.i(226534);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "alvinluo enableMessageFloatBall %b, %s", new Object[] { Boolean.valueOf(aGh()), this });
    boolean bool = aGh();
    AppMethodBeat.o(226534);
    return bool;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(44968);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(44968);
  }
  
  public final boolean wu(int paramInt)
  {
    AppMethodBeat.i(44967);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.kGW.hashCode()) });
    boolean bool = super.wu(paramInt);
    AppMethodBeat.o(44967);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.b
 * JD-Core Version:    0.7.0.1
 */