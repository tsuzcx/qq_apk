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
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends com.tencent.mm.plugin.ball.service.f
{
  private static com.tencent.mm.plugin.ball.c.f jPm;
  o jPl;
  
  static
  {
    AppMethodBeat.i(44975);
    jPm = new com.tencent.mm.plugin.ball.c.g()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(186447);
        c.b(paramAnonymousBallInfo);
        AppMethodBeat.o(186447);
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
    this.jPl = paramo;
    ac.i("MicroMsg.AppBrandFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramo.hashCode()) });
    AppMethodBeat.o(44964);
  }
  
  public static int b(g.d paramd)
  {
    if (paramd == g.d.jdd) {
      return 2;
    }
    if (paramd == g.d.jdc) {
      return 1;
    }
    return 0;
  }
  
  public static void bdf()
  {
    AppMethodBeat.i(44972);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(1, jPm);
    }
    AppMethodBeat.o(44972);
  }
  
  public static void bdg()
  {
    AppMethodBeat.i(44973);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(1, jPm);
    }
    AppMethodBeat.o(44973);
  }
  
  public final void a(final f.a parama)
  {
    AppMethodBeat.i(186448);
    g localg = (g)this.jPl.as(g.class);
    if ((localg != null) && (localg.bdl()))
    {
      localg.a(a.jg(this.jPl.mContext), new g.a()
      {
        public final void bdh()
        {
          AppMethodBeat.i(186446);
          ac.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, afterShowVOIPTip");
          if (parama != null) {
            parama.proceed();
          }
          AppMethodBeat.o(186446);
        }
      });
      AppMethodBeat.o(186448);
      return;
    }
    ac.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, not show vpip tip");
    parama.proceed();
    AppMethodBeat.o(186448);
  }
  
  public final void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(44966);
    ac.i("MicroMsg.AppBrandFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.aa(paramInt, paramString);
    AppMethodBeat.o(44966);
  }
  
  public final boolean bcV()
  {
    return false;
  }
  
  public final boolean bcW()
  {
    AppMethodBeat.i(44965);
    if (!this.jPl.aTS().jDy)
    {
      AppMethodBeat.o(44965);
      return true;
    }
    AppMethodBeat.o(44965);
    return false;
  }
  
  public final void bcX()
  {
    AppMethodBeat.i(44969);
    ac.i("MicroMsg.AppBrandFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    if (AppBrandRuntimeWCAccessible.isGame(this.jPl))
    {
      super.bGh();
      AppMethodBeat.o(44969);
      return;
    }
    super.bcX();
    AppMethodBeat.o(44969);
  }
  
  public final void bcY()
  {
    AppMethodBeat.i(44970);
    ac.i("MicroMsg.AppBrandFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    super.bcY();
    AppMethodBeat.o(44970);
  }
  
  public final void bcZ()
  {
    AppMethodBeat.i(44971);
    ac.i("MicroMsg.AppBrandFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    this.ngF.gb(true);
    AppMethodBeat.o(44971);
  }
  
  public final boolean bde()
  {
    AppMethodBeat.i(186449);
    ac.i("MicroMsg.AppBrandFloatBallHelper", "alvinluo enableMessageFloatBall %b, %s", new Object[] { Boolean.valueOf(bcW()), this });
    boolean bool = bcW();
    AppMethodBeat.o(186449);
    return bool;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(44968);
    ac.i("MicroMsg.AppBrandFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(44968);
  }
  
  public final boolean rT(int paramInt)
  {
    AppMethodBeat.i(44967);
    ac.i("MicroMsg.AppBrandFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jPl.hashCode()) });
    boolean bool = super.rT(paramInt);
    AppMethodBeat.o(44967);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.c
 * JD-Core Version:    0.7.0.1
 */