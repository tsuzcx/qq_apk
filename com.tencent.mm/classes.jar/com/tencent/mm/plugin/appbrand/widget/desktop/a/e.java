package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ai;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBgServiceImpl;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "()V", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "", "isInitCrash", "loadDynamicBgLibrary", "", "markDrawEndPoint", "markDrawStartPoint", "markWillCrash", "needMarkDrawPoint", "onInitCrash", "onInitEnd", "onInitStart", "setEnableNativeDynamicBackground", "enable", "willCrash", "Companion", "plugin-appbrand-integration_release"})
public final class e
  implements com.tencent.mm.dynamicbackground.model.c
{
  public static final e.a lWC;
  
  static
  {
    AppMethodBeat.i(51440);
    lWC = new e.a((byte)0);
    AppMethodBeat.o(51440);
  }
  
  public final boolean aaf()
  {
    AppMethodBeat.i(51430);
    boolean bool = b.aaf();
    AppMethodBeat.o(51430);
    return bool;
  }
  
  public final void aag()
  {
    AppMethodBeat.i(51438);
    b.ht(false);
    AppMethodBeat.o(51438);
  }
  
  public final void aah()
  {
    AppMethodBeat.i(51429);
    ad.i("MicroMsg.DynamicBgServiceImpl", "alvinluo loadDynamicBgLibrary");
    if (b.aaf()) {
      c.bsl();
    }
    try
    {
      System.loadLibrary("dynamicBg");
      AppMethodBeat.o(51429);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.DynamicBgServiceImpl", localThrowable, "alvinluo DynamicBackgroundNative exception", new Object[0]);
      c.bsk();
      AppMethodBeat.o(51429);
    }
  }
  
  public final boolean aai()
  {
    AppMethodBeat.i(51439);
    boolean bool = c.bsn();
    AppMethodBeat.o(51439);
    return bool;
  }
  
  public final void aaj()
  {
    AppMethodBeat.i(51434);
    c.aaj();
    AppMethodBeat.o(51434);
  }
  
  public final void aak()
  {
    AppMethodBeat.i(51436);
    c.bsk();
    AppMethodBeat.o(51436);
  }
  
  public final void aal()
  {
    AppMethodBeat.i(51437);
    c.bsm();
    AppMethodBeat.o(51437);
  }
  
  public final boolean aam()
  {
    AppMethodBeat.i(51431);
    boolean bool = c.aam();
    AppMethodBeat.o(51431);
    return bool;
  }
  
  public final boolean aan()
  {
    AppMethodBeat.i(51435);
    boolean bool = c.aan();
    AppMethodBeat.o(51435);
    return bool;
  }
  
  public final void aao()
  {
    AppMethodBeat.i(51433);
    c.aao();
    AppMethodBeat.o(51433);
  }
  
  public final void aap()
  {
    AppMethodBeat.i(51432);
    c.aap();
    AppMethodBeat.o(51432);
  }
  
  public final float aaq()
  {
    AppMethodBeat.i(51428);
    a locala = a.lWw;
    float f = a.bsf();
    AppMethodBeat.o(51428);
    return f;
  }
  
  public final Point cf(Context paramContext)
  {
    AppMethodBeat.i(51427);
    k.h(paramContext, "context");
    paramContext = ai.cf(paramContext);
    k.g(paramContext, "UIUtils.getDisplayRealSize(context)");
    AppMethodBeat.o(51427);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.e
 * JD-Core Version:    0.7.0.1
 */