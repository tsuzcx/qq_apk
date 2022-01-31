package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.view.View;
import com.tencent.mm.cg.a;
import com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView;
import com.tencent.mm.plugin.appbrand.dynamic.b.b;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  private static volatile boolean dJj = false;
  private static volatile int fYg = 0;
  
  public static int afG()
  {
    return fYg;
  }
  
  public static String afH()
  {
    switch (fYg)
    {
    default: 
      return "MHADrawableView";
    case 1: 
      return "MTextureView";
    case 2: 
      return "MSurfaceView";
    case 3: 
      return "MCanvasView";
    }
    return "MDrawableView";
  }
  
  public static View bt(Context paramContext)
  {
    if (!dJj) {
      initialize();
    }
    y.d("MicroMsg.WidgetDrawableViewFactory", "inflate(mode : %d)", new Object[] { Integer.valueOf(fYg) });
    switch (fYg)
    {
    default: 
      paramContext = new MHardwareAccelerateDrawableView(paramContext);
      paramContext.getDrawContext().fLv = b.afj();
      paramContext.setDrawActionReportable(new c.6(paramContext));
      return paramContext;
    case 1: 
      paramContext = new MTextureView(paramContext);
      paramContext.getDrawContext().fLv = b.afj();
      paramContext.setDrawActionReportable(new c.2(paramContext));
      return paramContext;
    case 2: 
      paramContext = new MSurfaceView(paramContext);
      paramContext.getDrawContext().fLv = b.afj();
      paramContext.setDrawActionReportable(new c.3(paramContext));
      return paramContext;
    case 3: 
      paramContext = new MCanvasView(paramContext);
      paramContext.getDrawContext().fLv = b.afj();
      paramContext.setDrawActionReportable(new c.4(paramContext));
      return paramContext;
    }
    paramContext = new MDrawableView(paramContext);
    paramContext.getDrawContext().fLv = b.afj();
    paramContext.setDrawActionReportable(new c.5(paramContext));
    return paramContext;
  }
  
  public static void initialize()
  {
    a.post(new c.1());
  }
  
  public static void kO(int paramInt)
  {
    fYg = paramInt;
    dJj = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.c
 * JD-Core Version:    0.7.0.1
 */