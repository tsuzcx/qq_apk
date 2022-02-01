package com.tencent.mm.plugin.appbrand.floatball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.ball.service.f.a;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends com.tencent.mm.plugin.ball.service.f
{
  private static com.tencent.mm.plugin.ball.c.f kjw;
  o jCo;
  
  static
  {
    AppMethodBeat.i(44975);
    kjw = new c.2();
    AppMethodBeat.o(44975);
  }
  
  public c(com.tencent.mm.plugin.ball.a.f paramf, o paramo)
  {
    super(paramf);
    AppMethodBeat.i(44964);
    this.jCo = paramo;
    ad.i("MicroMsg.AppBrandFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramo.hashCode()) });
    AppMethodBeat.o(44964);
  }
  
  public static int b(g.d paramd)
  {
    if (paramd == g.d.jwm) {
      return 2;
    }
    if (paramd == g.d.jwl) {
      return 1;
    }
    return 0;
  }
  
  public static void bgJ()
  {
    AppMethodBeat.i(44972);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(1, kjw);
    }
    AppMethodBeat.o(44972);
  }
  
  public static void bgK()
  {
    AppMethodBeat.i(44973);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(1, kjw);
    }
    AppMethodBeat.o(44973);
  }
  
  public final void a(final f.a parama)
  {
    AppMethodBeat.i(188144);
    g localg = (g)this.jCo.as(g.class);
    if ((localg != null) && (localg.bgP()))
    {
      localg.a(a.jq(this.jCo.mContext), new g.a()
      {
        public final void bgL()
        {
          AppMethodBeat.i(188142);
          ad.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, afterShowVOIPTip");
          if (parama != null) {
            parama.proceed();
          }
          AppMethodBeat.o(188142);
        }
      });
      AppMethodBeat.o(188144);
      return;
    }
    ad.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, not show vpip tip");
    parama.proceed();
    AppMethodBeat.o(188144);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(44966);
    ad.i("MicroMsg.AppBrandFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.ac(paramInt, paramString);
    AppMethodBeat.o(44966);
  }
  
  public final boolean bgA()
  {
    AppMethodBeat.i(44965);
    if (!this.jCo.aXc().jXu)
    {
      AppMethodBeat.o(44965);
      return true;
    }
    AppMethodBeat.o(44965);
    return false;
  }
  
  public final void bgB()
  {
    AppMethodBeat.i(44969);
    ad.i("MicroMsg.AppBrandFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    if (AppBrandRuntimeWCAccessible.isGame(this.jCo))
    {
      super.bKs();
      AppMethodBeat.o(44969);
      return;
    }
    super.bgB();
    AppMethodBeat.o(44969);
  }
  
  public final void bgC()
  {
    AppMethodBeat.i(44970);
    ad.i("MicroMsg.AppBrandFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    super.bgC();
    AppMethodBeat.o(44970);
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(44971);
    ad.i("MicroMsg.AppBrandFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    this.nHb.gg(true);
    AppMethodBeat.o(44971);
  }
  
  public final boolean bgI()
  {
    AppMethodBeat.i(188145);
    ad.i("MicroMsg.AppBrandFloatBallHelper", "alvinluo enableMessageFloatBall %b, %s", new Object[] { Boolean.valueOf(bgA()), this });
    boolean bool = bgA();
    AppMethodBeat.o(188145);
    return bool;
  }
  
  public final boolean bgz()
  {
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(44968);
    ad.i("MicroMsg.AppBrandFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(44968);
  }
  
  public final boolean sv(int paramInt)
  {
    AppMethodBeat.i(44967);
    ad.i("MicroMsg.AppBrandFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jCo.hashCode()) });
    boolean bool = super.sv(paramInt);
    AppMethodBeat.o(44967);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.c
 * JD-Core Version:    0.7.0.1
 */