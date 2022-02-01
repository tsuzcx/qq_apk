package com.tencent.mm.plugin.appbrand.floatball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.service.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class c
  extends com.tencent.mm.plugin.ball.service.e
{
  private static com.tencent.mm.plugin.ball.c.e roL;
  w qxC;
  
  static
  {
    AppMethodBeat.i(44975);
    roL = new c.2();
    AppMethodBeat.o(44975);
  }
  
  public c(f paramf, w paramw)
  {
    super(paramf);
    AppMethodBeat.i(44964);
    this.qxC = paramw;
    Log.i("MicroMsg.AppBrandFloatBallHelper", "create, runtime:%s", new Object[] { Integer.valueOf(paramw.hashCode()) });
    AppMethodBeat.o(44964);
  }
  
  public static int b(k.d paramd)
  {
    if (paramd == k.d.qrH) {
      return 2;
    }
    if (paramd == k.d.qrG) {
      return 1;
    }
    return 0;
  }
  
  public static void con()
  {
    AppMethodBeat.i(44972);
    if (h.ax(b.class) != null) {
      ((b)h.ax(b.class)).a(1, roL);
    }
    AppMethodBeat.o(44972);
  }
  
  public static void coo()
  {
    AppMethodBeat.i(44973);
    if (h.ax(b.class) != null) {
      ((b)h.ax(b.class)).b(1, roL);
    }
    AppMethodBeat.o(44973);
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(44966);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.J(paramInt, paramString);
    AppMethodBeat.o(44966);
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(318328);
    g localg = (g)this.qxC.aO(g.class);
    if ((localg != null) && (localg.cot()))
    {
      localg.a(AndroidContextUtil.castActivityOrNull(this.qxC.mContext), new g.a()
      {
        public final void coq()
        {
          AppMethodBeat.i(318278);
          Log.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, afterShowVOIPTip");
          if (parama != null) {
            parama.proceed();
          }
          AppMethodBeat.o(318278);
        }
      });
      AppMethodBeat.o(318328);
      return;
    }
    Log.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, not show vpip tip");
    parama.proceed();
    AppMethodBeat.o(318328);
  }
  
  public final boolean bhU()
  {
    return false;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(44971);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    this.vkT.iR(true);
    AppMethodBeat.o(44971);
  }
  
  public final void bhW()
  {
    AppMethodBeat.i(44970);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onExitPage, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    super.bhW();
    AppMethodBeat.o(44970);
  }
  
  public final void coi()
  {
    AppMethodBeat.i(44969);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onEnterPage, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    if (AppBrandRuntimeWCAccessible.isGame(this.qxC))
    {
      super.bhT();
      AppMethodBeat.o(44969);
      return;
    }
    super.coi();
    AppMethodBeat.o(44969);
  }
  
  public final boolean cop()
  {
    AppMethodBeat.i(44965);
    if (!this.qxC.getInitConfig().qYd)
    {
      AppMethodBeat.o(44965);
      return true;
    }
    AppMethodBeat.o(44965);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(44968);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onDestroy, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(44968);
  }
  
  public final boolean zX(int paramInt)
  {
    AppMethodBeat.i(44967);
    Log.i("MicroMsg.AppBrandFloatBallHelper", "onClose, runtime:%s", new Object[] { Integer.valueOf(this.qxC.hashCode()) });
    boolean bool = super.zX(paramInt);
    AppMethodBeat.o(44967);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.c
 * JD-Core Version:    0.7.0.1
 */