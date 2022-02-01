package com.tencent.mm.plugin.appbrand.floatball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class b
  extends com.tencent.mm.plugin.ball.service.e
{
  private static com.tencent.mm.plugin.ball.c.e old;
  t nAH;
  
  static
  {
    AppMethodBeat.i(44975);
    old = new com.tencent.mm.plugin.ball.c.f()
    {
      public final void b(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(276121);
        b.a(paramAnonymousBallInfo);
        AppMethodBeat.o(276121);
      }
      
      public final void c(BallInfo paramAnonymousBallInfo) {}
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
    };
    AppMethodBeat.o(44975);
  }
  
  public b(com.tencent.mm.plugin.ball.a.f paramf, t paramt)
  {
    super(paramf);
    AppMethodBeat.i(44964);
    this.nAH = paramt;
    Log.i("MicroMsg.AppBrandFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramt.hashCode()) });
    AppMethodBeat.o(44964);
  }
  
  public static int b(k.d paramd)
  {
    if (paramd == k.d.ntc) {
      return 2;
    }
    if (paramd == k.d.ntb) {
      return 1;
    }
    return 0;
  }
  
  public static void bNZ()
  {
    AppMethodBeat.i(44972);
    if (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).a(1, old);
    }
    AppMethodBeat.o(44972);
  }
  
  public static void bOa()
  {
    AppMethodBeat.i(44973);
    if (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).b(1, old);
    }
    AppMethodBeat.o(44973);
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(44966);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.I(paramInt, paramString);
    AppMethodBeat.o(44966);
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(263239);
    f localf = (f)this.nAH.av(f.class);
    if ((localf != null) && (localf.bOg()))
    {
      localf.a(AndroidContextUtil.castActivityOrNull(this.nAH.mContext), new f.a()
      {
        public final void bOc()
        {
          AppMethodBeat.i(280311);
          Log.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, afterShowVOIPTip");
          if (parama != null) {
            parama.proceed();
          }
          AppMethodBeat.o(280311);
        }
      });
      AppMethodBeat.o(263239);
      return;
    }
    Log.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, not show vpip tip");
    parama.proceed();
    AppMethodBeat.o(263239);
  }
  
  public final boolean aOg()
  {
    return false;
  }
  
  public final boolean aOh()
  {
    AppMethodBeat.i(44965);
    if (!this.nAH.bDy().nYb)
    {
      AppMethodBeat.o(44965);
      return true;
    }
    AppMethodBeat.o(44965);
    return false;
  }
  
  public final void aOi()
  {
    AppMethodBeat.i(44971);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    this.rZC.hS(true);
    AppMethodBeat.o(44971);
  }
  
  public final void aOj()
  {
    AppMethodBeat.i(44970);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    super.aOj();
    AppMethodBeat.o(44970);
  }
  
  public final void bNV()
  {
    AppMethodBeat.i(44969);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    if (AppBrandRuntimeWCAccessible.isGame(this.nAH))
    {
      super.aOf();
      AppMethodBeat.o(44969);
      return;
    }
    super.bNV();
    AppMethodBeat.o(44969);
  }
  
  public final boolean bOb()
  {
    AppMethodBeat.i(263240);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "alvinluo enableMessageFloatBall %b, %s", new Object[] { Boolean.valueOf(aOh()), this });
    boolean bool = aOh();
    AppMethodBeat.o(263240);
    return bool;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(44968);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(44968);
  }
  
  public final boolean zH(int paramInt)
  {
    AppMethodBeat.i(44967);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.nAH.hashCode()) });
    boolean bool = super.zH(paramInt);
    AppMethodBeat.o(44967);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.b
 * JD-Core Version:    0.7.0.1
 */