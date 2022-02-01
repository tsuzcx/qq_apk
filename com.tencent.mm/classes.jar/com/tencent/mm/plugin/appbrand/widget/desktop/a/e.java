package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBgServiceImpl;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "()V", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "", "isInitCrash", "loadDynamicBgLibrary", "", "markDrawEndPoint", "markDrawStartPoint", "markWillCrash", "needMarkDrawPoint", "onInitCrash", "onInitEnd", "onInitStart", "setEnableNativeDynamicBackground", "enable", "willCrash", "Companion", "plugin-appbrand-integration_release"})
public final class e
  implements com.tencent.mm.dynamicbackground.model.c
{
  public static final e.a myE;
  
  static
  {
    AppMethodBeat.i(51440);
    myE = new e.a((byte)0);
    AppMethodBeat.o(51440);
  }
  
  public final boolean abe()
  {
    AppMethodBeat.i(51430);
    boolean bool = b.abe();
    AppMethodBeat.o(51430);
    return bool;
  }
  
  public final void abf()
  {
    AppMethodBeat.i(51438);
    b.hR(false);
    AppMethodBeat.o(51438);
  }
  
  public final void abg()
  {
    AppMethodBeat.i(51429);
    ac.i("MicroMsg.DynamicBgServiceImpl", "alvinluo loadDynamicBgLibrary");
    if (b.abe()) {
      c.bzl();
    }
    try
    {
      System.loadLibrary("dynamicBg");
      AppMethodBeat.o(51429);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("MicroMsg.DynamicBgServiceImpl", localThrowable, "alvinluo DynamicBackgroundNative exception", new Object[0]);
      c.bzk();
      AppMethodBeat.o(51429);
    }
  }
  
  public final boolean abh()
  {
    AppMethodBeat.i(51439);
    boolean bool = c.bzn();
    AppMethodBeat.o(51439);
    return bool;
  }
  
  public final void abi()
  {
    AppMethodBeat.i(51434);
    c.abi();
    AppMethodBeat.o(51434);
  }
  
  public final void abj()
  {
    AppMethodBeat.i(51436);
    c.bzk();
    AppMethodBeat.o(51436);
  }
  
  public final void abk()
  {
    AppMethodBeat.i(51437);
    c.bzm();
    AppMethodBeat.o(51437);
  }
  
  public final boolean abl()
  {
    AppMethodBeat.i(51431);
    boolean bool = c.abl();
    AppMethodBeat.o(51431);
    return bool;
  }
  
  public final boolean abm()
  {
    AppMethodBeat.i(51435);
    boolean bool = c.abm();
    AppMethodBeat.o(51435);
    return bool;
  }
  
  public final void abn()
  {
    AppMethodBeat.i(51433);
    c.abn();
    AppMethodBeat.o(51433);
  }
  
  public final void abo()
  {
    AppMethodBeat.i(51432);
    c.abo();
    AppMethodBeat.o(51432);
  }
  
  public final float abp()
  {
    AppMethodBeat.i(51428);
    a locala = a.myy;
    float f = a.bzf();
    AppMethodBeat.o(51428);
    return f;
  }
  
  public final Point cl(Context paramContext)
  {
    AppMethodBeat.i(51427);
    k.h(paramContext, "context");
    paramContext = aj.cl(paramContext);
    k.g(paramContext, "UIUtils.getDisplayRealSize(context)");
    AppMethodBeat.o(51427);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.e
 * JD-Core Version:    0.7.0.1
 */