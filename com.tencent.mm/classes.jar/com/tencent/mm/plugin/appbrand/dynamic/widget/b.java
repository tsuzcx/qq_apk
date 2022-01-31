package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  private static volatile boolean eGH = false;
  private static volatile int hrs = 0;
  
  public static int aAk()
  {
    return hrs;
  }
  
  public static String aAl()
  {
    switch (hrs)
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
  
  public static View bX(Context paramContext)
  {
    AppMethodBeat.i(11120);
    if (!eGH) {
      initialize();
    }
    ab.d("MicroMsg.WidgetDrawableViewFactory", "inflate(mode : %d)", new Object[] { Integer.valueOf(hrs) });
    switch (hrs)
    {
    default: 
      paramContext = new MHardwareAccelerateDrawableView(paramContext);
      paramContext.getDrawContext().heH = com.tencent.mm.plugin.appbrand.dynamic.b.b.azN();
      paramContext.setDrawActionReportable(new b.6(paramContext));
      AppMethodBeat.o(11120);
      return paramContext;
    case 1: 
      paramContext = new MTextureView(paramContext);
      paramContext.getDrawContext().heH = com.tencent.mm.plugin.appbrand.dynamic.b.b.azN();
      paramContext.setDrawActionReportable(new b.2(paramContext));
      AppMethodBeat.o(11120);
      return paramContext;
    case 2: 
      paramContext = new MSurfaceView(paramContext);
      paramContext.getDrawContext().heH = com.tencent.mm.plugin.appbrand.dynamic.b.b.azN();
      paramContext.setDrawActionReportable(new b.3(paramContext));
      AppMethodBeat.o(11120);
      return paramContext;
    case 3: 
      paramContext = new MCanvasView(paramContext);
      paramContext.getDrawContext().heH = com.tencent.mm.plugin.appbrand.dynamic.b.b.azN();
      paramContext.setDrawActionReportable(new b.4(paramContext));
      AppMethodBeat.o(11120);
      return paramContext;
    }
    paramContext = new MDrawableView(paramContext);
    paramContext.getDrawContext().heH = com.tencent.mm.plugin.appbrand.dynamic.b.b.azN();
    paramContext.setDrawActionReportable(new b.5(paramContext));
    AppMethodBeat.o(11120);
    return paramContext;
  }
  
  public static void initialize()
  {
    AppMethodBeat.i(11119);
    com.tencent.mm.ch.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(11088);
        Object localObject = a.b.eEW;
        localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.me("100284");
        if (localObject == null)
        {
          ab.i("MicroMsg.WidgetDrawableViewFactory", "widget canvas mode ABTest item is null.");
          AppMethodBeat.o(11088);
          return;
        }
        if (!((c)localObject).isValid())
        {
          b.nL(0);
          AppMethodBeat.o(11088);
          return;
        }
        try
        {
          b.nL(bo.getInt((String)((c)localObject).dvN().get("mode"), 0));
          ab.i("MicroMsg.WidgetDrawableViewFactory", "current canvas mode is : %d", new Object[] { Integer.valueOf(b.hrs) });
          AppMethodBeat.o(11088);
          return;
        }
        catch (Exception localException)
        {
          ab.w("MicroMsg.WidgetDrawableViewFactory", "parse widget canvas mode error : %s", new Object[] { Log.getStackTraceString(localException) });
          AppMethodBeat.o(11088);
        }
      }
    });
    AppMethodBeat.o(11119);
  }
  
  public static void nL(int paramInt)
  {
    hrs = paramInt;
    eGH = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b
 * JD-Core Version:    0.7.0.1
 */