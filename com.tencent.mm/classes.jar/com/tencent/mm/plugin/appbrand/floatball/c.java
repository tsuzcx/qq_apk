package com.tencent.mm.plugin.appbrand.floatball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.f.a;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends com.tencent.mm.plugin.ball.service.f
{
  private static com.tencent.mm.plugin.ball.c.f kmM;
  p jFm;
  
  static
  {
    AppMethodBeat.i(44975);
    kmM = new com.tencent.mm.plugin.ball.c.g()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(222269);
        c.b(paramAnonymousBallInfo);
        AppMethodBeat.o(222269);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(44975);
  }
  
  public c(com.tencent.mm.plugin.ball.a.f paramf, p paramp)
  {
    super(paramf);
    AppMethodBeat.i(44964);
    this.jFm = paramp;
    ae.i("MicroMsg.AppBrandFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramp.hashCode()) });
    AppMethodBeat.o(44964);
  }
  
  public static int b(h.d paramd)
  {
    if (paramd == h.d.jzi) {
      return 2;
    }
    if (paramd == h.d.jzh) {
      return 1;
    }
    return 0;
  }
  
  public static void bhr()
  {
    AppMethodBeat.i(44972);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(1, kmM);
    }
    AppMethodBeat.o(44972);
  }
  
  public static void bhs()
  {
    AppMethodBeat.i(44973);
    if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class) != null) {
      ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(1, kmM);
    }
    AppMethodBeat.o(44973);
  }
  
  public final void a(final f.a parama)
  {
    AppMethodBeat.i(222270);
    g localg = (g)this.jFm.as(g.class);
    if ((localg != null) && (localg.bhx()))
    {
      localg.a(a.jw(this.jFm.mContext), new g.a()
      {
        public final void bht()
        {
          AppMethodBeat.i(222268);
          ae.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, afterShowVOIPTip");
          if (parama != null) {
            parama.proceed();
          }
          AppMethodBeat.o(222268);
        }
      });
      AppMethodBeat.o(222270);
      return;
    }
    ae.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, not show vpip tip");
    parama.proceed();
    AppMethodBeat.o(222270);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(44966);
    ae.i("MicroMsg.AppBrandFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.ac(paramInt, paramString);
    AppMethodBeat.o(44966);
  }
  
  public final boolean bhh()
  {
    return false;
  }
  
  public final boolean bhi()
  {
    AppMethodBeat.i(44965);
    if (!this.jFm.aXx().kaJ)
    {
      AppMethodBeat.o(44965);
      return true;
    }
    AppMethodBeat.o(44965);
    return false;
  }
  
  public final void bhj()
  {
    AppMethodBeat.i(44969);
    ae.i("MicroMsg.AppBrandFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    if (AppBrandRuntimeWCAccessible.isGame(this.jFm))
    {
      super.bLp();
      AppMethodBeat.o(44969);
      return;
    }
    super.bhj();
    AppMethodBeat.o(44969);
  }
  
  public final void bhk()
  {
    AppMethodBeat.i(44970);
    ae.i("MicroMsg.AppBrandFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    super.bhk();
    AppMethodBeat.o(44970);
  }
  
  public final void bhl()
  {
    AppMethodBeat.i(44971);
    ae.i("MicroMsg.AppBrandFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    this.nME.ge(true);
    AppMethodBeat.o(44971);
  }
  
  public final boolean bhq()
  {
    AppMethodBeat.i(222271);
    ae.i("MicroMsg.AppBrandFloatBallHelper", "alvinluo enableMessageFloatBall %b, %s", new Object[] { Boolean.valueOf(bhi()), this });
    boolean bool = bhi();
    AppMethodBeat.o(222271);
    return bool;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(44968);
    ae.i("MicroMsg.AppBrandFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(44968);
  }
  
  public final boolean sy(int paramInt)
  {
    AppMethodBeat.i(44967);
    ae.i("MicroMsg.AppBrandFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.jFm.hashCode()) });
    boolean bool = super.sy(paramInt);
    AppMethodBeat.o(44967);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.c
 * JD-Core Version:    0.7.0.1
 */