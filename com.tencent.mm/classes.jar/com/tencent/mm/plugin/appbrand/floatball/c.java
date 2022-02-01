package com.tencent.mm.plugin.appbrand.floatball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.f.a;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends com.tencent.mm.plugin.ball.service.f
{
  private static com.tencent.mm.plugin.ball.c.f jpa;
  o joZ;
  
  static
  {
    AppMethodBeat.i(44975);
    jpa = new com.tencent.mm.plugin.ball.c.g()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(195726);
        c.b(paramAnonymousBallInfo);
        AppMethodBeat.o(195726);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(44975);
  }
  
  public c(com.tencent.mm.plugin.ball.a.f paramf, o paramo)
  {
    super(paramf);
    AppMethodBeat.i(44964);
    this.joZ = paramo;
    ad.i("MicroMsg.AppBrandFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramo.hashCode()) });
    AppMethodBeat.o(44964);
  }
  
  public static void aWh()
  {
    AppMethodBeat.i(44972);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(1, jpa);
    }
    AppMethodBeat.o(44972);
  }
  
  public static void aWi()
  {
    AppMethodBeat.i(44973);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(1, jpa);
    }
    AppMethodBeat.o(44973);
  }
  
  public static int b(g.d paramd)
  {
    if (paramd == g.d.iDd) {
      return 2;
    }
    if (paramd == g.d.iDc) {
      return 1;
    }
    return 0;
  }
  
  public final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(44966);
    ad.i("MicroMsg.AppBrandFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.Z(paramInt, paramString);
    AppMethodBeat.o(44966);
  }
  
  public final void a(final f.a parama)
  {
    AppMethodBeat.i(195727);
    g localg = (g)this.joZ.as(g.class);
    if ((localg != null) && (localg.aWn()))
    {
      localg.a(a.iV(this.joZ.mContext), new g.a()
      {
        public final void aWj()
        {
          AppMethodBeat.i(195725);
          ad.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, afterShowVOIPTip");
          if (parama != null) {
            parama.proceed();
          }
          AppMethodBeat.o(195725);
        }
      });
      AppMethodBeat.o(195727);
      return;
    }
    ad.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, not show vpip tip");
    parama.proceed();
    AppMethodBeat.o(195727);
  }
  
  public final boolean aVX()
  {
    return false;
  }
  
  public final boolean aVY()
  {
    AppMethodBeat.i(44965);
    if (!this.joZ.aNc().jdl)
    {
      AppMethodBeat.o(44965);
      return true;
    }
    AppMethodBeat.o(44965);
    return false;
  }
  
  public final void aVZ()
  {
    AppMethodBeat.i(44969);
    ad.i("MicroMsg.AppBrandFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    if (AppBrandRuntimeWCAccessible.isGame(this.joZ))
    {
      super.bzl();
      AppMethodBeat.o(44969);
      return;
    }
    super.aVZ();
    AppMethodBeat.o(44969);
  }
  
  public final void aWa()
  {
    AppMethodBeat.i(44970);
    ad.i("MicroMsg.AppBrandFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    super.aWa();
    AppMethodBeat.o(44970);
  }
  
  public final void aWb()
  {
    AppMethodBeat.i(44971);
    ad.i("MicroMsg.AppBrandFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    this.mEA.fF(true);
    AppMethodBeat.o(44971);
  }
  
  public final boolean aWg()
  {
    AppMethodBeat.i(195728);
    ad.i("MicroMsg.AppBrandFloatBallHelper", "alvinluo enableMessageFloatBall %b, %s", new Object[] { Boolean.valueOf(aVY()), this });
    boolean bool = aVY();
    AppMethodBeat.o(195728);
    return bool;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(44968);
    ad.i("MicroMsg.AppBrandFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(44968);
  }
  
  public final boolean rg(int paramInt)
  {
    AppMethodBeat.i(44967);
    ad.i("MicroMsg.AppBrandFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.joZ.hashCode()) });
    boolean bool = super.rg(paramInt);
    AppMethodBeat.o(44967);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.c
 * JD-Core Version:    0.7.0.1
 */