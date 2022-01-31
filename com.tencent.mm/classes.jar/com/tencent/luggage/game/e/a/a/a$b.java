package com.tencent.luggage.game.e.a.a;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.a;
import com.tencent.magicbrush.handler.MBJsThreadHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.sdk.platformtools.ab;

final class a$b
  extends MBRuntime.a
{
  private a$b(a parama) {}
  
  public final void onConsoleOutput(String paramString)
  {
    AppMethodBeat.i(140431);
    ab.i("Luggage.AppBrandGameServiceLogicImp", "[WAGame][CONSOLE] output = [%s]", new Object[] { paramString });
    if ((!((com.tencent.luggage.sdk.b.a.c.c)a.i(this.bBl)).aud()) && (!((com.tencent.luggage.sdk.b.a.c.c)a.j(this.bBl)).isRunning()))
    {
      AppMethodBeat.o(140431);
      return;
    }
    com.tencent.luggage.sdk.d.b localb = ((com.tencent.luggage.sdk.b.a.c.c)a.k(this.bBl)).wj();
    if ((localb == null) || (localb.wR().bDj)) {
      a.bQ(paramString);
    }
    AppMethodBeat.o(140431);
  }
  
  public final void onFirstFrameRendered()
  {
    AppMethodBeat.i(140430);
    a.h(this.bBl);
    AppMethodBeat.o(140430);
  }
  
  public final void onMainCanvasTypeDefined(int paramInt)
  {
    AppMethodBeat.i(140432);
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("onMainCanvasTypeDefined received invalid input [" + paramInt + "]");
      AppMethodBeat.o(140432);
      throw localIllegalStateException;
    }
    if ((!((com.tencent.luggage.sdk.b.a.c.c)a.l(this.bBl)).aud()) && (!((com.tencent.luggage.sdk.b.a.c.c)a.m(this.bBl)).isRunning()))
    {
      AppMethodBeat.o(140432);
      return;
    }
    this.bBl.onMainCanvasTypeDefined(paramInt);
    AppMethodBeat.o(140432);
  }
  
  public final void onRendererReady(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140428);
    ab.i("Luggage.AppBrandGameServiceLogicImp", "MagicBrushListener.onRendererReady width = [%d] height = [%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a.e(this.bBl);
    this.bBl.bBi.bzF.bzI.getJsThreadHandler().post(new a.b.1(this));
    AppMethodBeat.o(140428);
  }
  
  public final void onSystemSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140429);
    com.tencent.luggage.sdk.d.b localb = ((com.tencent.luggage.sdk.b.a.c.c)a.g(this.bBl)).wj();
    if (localb == null)
    {
      AppMethodBeat.o(140429);
      return;
    }
    n localn = localb.gPK;
    ab.i("MicroMsg.AppBrandOnWindowSizeChangedEvent", "hy: on resizeWindow");
    localn.i(localb.ws()).aBz();
    AppMethodBeat.o(140429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.e.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */