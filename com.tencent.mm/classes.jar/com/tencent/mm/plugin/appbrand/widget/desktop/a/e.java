package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.al;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBgServiceImpl;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "()V", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "", "isInitCrash", "loadDynamicBgLibrary", "", "markDrawEndPoint", "markDrawStartPoint", "markWillCrash", "needMarkDrawPoint", "onInitCrash", "onInitEnd", "onInitStart", "setEnableNativeDynamicBackground", "enable", "willCrash", "Companion", "plugin-appbrand-integration_release"})
public final class e
  implements com.tencent.mm.dynamicbackground.model.c
{
  public static final e.a mZm;
  
  static
  {
    AppMethodBeat.i(51440);
    mZm = new e.a((byte)0);
    AppMethodBeat.o(51440);
  }
  
  public final boolean adI()
  {
    AppMethodBeat.i(51430);
    boolean bool = b.adI();
    AppMethodBeat.o(51430);
    return bool;
  }
  
  public final void adJ()
  {
    AppMethodBeat.i(51438);
    b.ib(false);
    AppMethodBeat.o(51438);
  }
  
  public final void adK()
  {
    AppMethodBeat.i(51429);
    ad.i("MicroMsg.DynamicBgServiceImpl", "alvinluo loadDynamicBgLibrary");
    if (b.adI()) {
      c.bDp();
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
      c.bDo();
      AppMethodBeat.o(51429);
    }
  }
  
  public final boolean adL()
  {
    AppMethodBeat.i(51439);
    boolean bool = c.bDr();
    AppMethodBeat.o(51439);
    return bool;
  }
  
  public final void adM()
  {
    AppMethodBeat.i(51434);
    c.adM();
    AppMethodBeat.o(51434);
  }
  
  public final void adN()
  {
    AppMethodBeat.i(51436);
    c.bDo();
    AppMethodBeat.o(51436);
  }
  
  public final void adO()
  {
    AppMethodBeat.i(51437);
    c.bDq();
    AppMethodBeat.o(51437);
  }
  
  public final boolean adP()
  {
    AppMethodBeat.i(51431);
    boolean bool = c.adP();
    AppMethodBeat.o(51431);
    return bool;
  }
  
  public final boolean adQ()
  {
    AppMethodBeat.i(51435);
    boolean bool = c.adQ();
    AppMethodBeat.o(51435);
    return bool;
  }
  
  public final void adR()
  {
    AppMethodBeat.i(51433);
    c.adR();
    AppMethodBeat.o(51433);
  }
  
  public final void adS()
  {
    AppMethodBeat.i(51432);
    c.adS();
    AppMethodBeat.o(51432);
  }
  
  public final float adT()
  {
    AppMethodBeat.i(51428);
    a locala = a.mZg;
    float f = a.bDj();
    AppMethodBeat.o(51428);
    return f;
  }
  
  public final Point ci(Context paramContext)
  {
    AppMethodBeat.i(51427);
    p.h(paramContext, "context");
    paramContext = al.ci(paramContext);
    p.g(paramContext, "UIUtils.getDisplayRealSize(context)");
    AppMethodBeat.o(51427);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.e
 * JD-Core Version:    0.7.0.1
 */