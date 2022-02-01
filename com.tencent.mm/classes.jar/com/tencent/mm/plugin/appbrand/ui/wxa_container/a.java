package com.tencent.mm.plugin.appbrand.ui.wxa_container;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.widget.c.e;
import com.tencent.mm.plugin.appbrand.widget.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandActivityContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "runtimeContainer", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "getRuntimeContainer", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "setRuntimeContainer", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;)V", "getRuntime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "plugin-appbrand-integration_release"})
public final class a
  extends FrameLayout
{
  public AppBrandRuntimeContainerWC rhV;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(283876);
    AppMethodBeat.o(283876);
  }
  
  private final t getRuntime()
  {
    AppMethodBeat.i(283875);
    Object localObject = this.rhV;
    if (localObject == null) {
      p.bGy("runtimeContainer");
    }
    d locald = (d)((AppBrandRuntimeContainerWC)localObject).getActiveRuntime();
    localObject = locald;
    if (!(locald instanceof t)) {
      localObject = null;
    }
    localObject = (t)localObject;
    AppMethodBeat.o(283875);
    return localObject;
  }
  
  public final AppBrandRuntimeContainerWC getRuntimeContainer()
  {
    AppMethodBeat.i(283871);
    AppBrandRuntimeContainerWC localAppBrandRuntimeContainerWC = this.rhV;
    if (localAppBrandRuntimeContainerWC == null) {
      p.bGy("runtimeContainer");
    }
    AppMethodBeat.o(283871);
    return localAppBrandRuntimeContainerWC;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(283874);
    p.k(paramMotionEvent, "ev");
    if (((a)this).rhV != null)
    {
      Object localObject = getRuntime();
      if (localObject != null)
      {
        localObject = ((t)localObject).bDM();
        if (localObject != null)
        {
          localObject = ((e)localObject).rta;
          if ((localObject != null) && (((i)localObject).J(paramMotionEvent) == true))
          {
            AppMethodBeat.o(283874);
            return true;
          }
        }
      }
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(283874);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(283873);
    p.k(paramMotionEvent, "event");
    if (((a)this).rhV != null)
    {
      Object localObject = getRuntime();
      if (localObject != null)
      {
        localObject = ((t)localObject).bDM();
        if (localObject != null)
        {
          localObject = ((e)localObject).rta;
          if ((localObject != null) && (((i)localObject).I(paramMotionEvent) == true))
          {
            AppMethodBeat.o(283873);
            return true;
          }
        }
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(283873);
    return bool;
  }
  
  public final void setRuntimeContainer(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    AppMethodBeat.i(283872);
    p.k(paramAppBrandRuntimeContainerWC, "<set-?>");
    this.rhV = paramAppBrandRuntimeContainerWC;
    AppMethodBeat.o(283872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.wxa_container.a
 * JD-Core Version:    0.7.0.1
 */