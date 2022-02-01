package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBgServiceImpl;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "()V", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "", "isInitCrash", "loadDynamicBgLibrary", "", "markDrawEndPoint", "markDrawStartPoint", "markWillCrash", "needMarkDrawPoint", "onInitCrash", "onInitEnd", "onInitStart", "setEnableNativeDynamicBackground", "enable", "willCrash", "Companion", "plugin-appbrand-integration_release"})
public final class e
  implements com.tencent.mm.dynamicbackground.model.c
{
  public static final e.a neu;
  
  static
  {
    AppMethodBeat.i(51440);
    neu = new e.a((byte)0);
    AppMethodBeat.o(51440);
  }
  
  public final boolean adU()
  {
    AppMethodBeat.i(51430);
    boolean bool = b.adU();
    AppMethodBeat.o(51430);
    return bool;
  }
  
  public final void adV()
  {
    AppMethodBeat.i(51438);
    b.hZ(false);
    AppMethodBeat.o(51438);
  }
  
  public final void adW()
  {
    AppMethodBeat.i(51429);
    ae.i("MicroMsg.DynamicBgServiceImpl", "alvinluo loadDynamicBgLibrary");
    if (b.adU()) {
      c.bEh();
    }
    try
    {
      System.loadLibrary("dynamicBg");
      AppMethodBeat.o(51429);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.DynamicBgServiceImpl", localThrowable, "alvinluo DynamicBackgroundNative exception", new Object[0]);
      c.bEg();
      AppMethodBeat.o(51429);
    }
  }
  
  public final boolean adX()
  {
    AppMethodBeat.i(51439);
    boolean bool = c.bEj();
    AppMethodBeat.o(51439);
    return bool;
  }
  
  public final void adY()
  {
    AppMethodBeat.i(51434);
    c.adY();
    AppMethodBeat.o(51434);
  }
  
  public final void adZ()
  {
    AppMethodBeat.i(51436);
    c.bEg();
    AppMethodBeat.o(51436);
  }
  
  public final void aea()
  {
    AppMethodBeat.i(51437);
    c.bEi();
    AppMethodBeat.o(51437);
  }
  
  public final boolean aeb()
  {
    AppMethodBeat.i(51431);
    boolean bool = c.aeb();
    AppMethodBeat.o(51431);
    return bool;
  }
  
  public final boolean aec()
  {
    AppMethodBeat.i(51435);
    boolean bool = c.aec();
    AppMethodBeat.o(51435);
    return bool;
  }
  
  public final void aed()
  {
    AppMethodBeat.i(51433);
    c.aed();
    AppMethodBeat.o(51433);
  }
  
  public final void aee()
  {
    AppMethodBeat.i(51432);
    c.aee();
    AppMethodBeat.o(51432);
  }
  
  public final float aef()
  {
    AppMethodBeat.i(51428);
    a locala = a.nen;
    float f = a.bEb();
    AppMethodBeat.o(51428);
    return f;
  }
  
  public final Point ck(Context paramContext)
  {
    AppMethodBeat.i(51427);
    p.h(paramContext, "context");
    paramContext = al.ck(paramContext);
    p.g(paramContext, "UIUtils.getDisplayRealSize(context)");
    AppMethodBeat.o(51427);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.e
 * JD-Core Version:    0.7.0.1
 */