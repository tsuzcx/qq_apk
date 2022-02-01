package com.tencent.mm.plugin.appbrand.widget.d;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.plugin.appbrand.widget.l;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerProxy;", "Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;)V", "animateContainer", "", "type", "Lcom/tencent/mm/plugin/appbrand/widget/ContainerAnimateType;", "canHandleTouchEvent", "", "getCurrentStatus", "Lcom/tencent/mm/plugin/appbrand/widget/ViewStatus;", "handleInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "handleTouchEvent", "isAttachedToWindow", "onInterceptTapToFullScreen", "onLayout", "left", "", "top", "right", "bottom", "setDefaultViewHeight", "height", "setGestureConfig", "canGesture", "forbidSlidingUpGesture", "setWxaHalfScreenEmptyAreaClickHandler", "handler", "Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenEmptyAreaClickHandler;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements l
{
  public static final a uEg;
  private final w qxC;
  private final l uEh;
  
  static
  {
    AppMethodBeat.i(324305);
    uEg = new a((byte)0);
    AppMethodBeat.o(324305);
  }
  
  private g(w paramw, l paraml)
  {
    this.qxC = paramw;
    this.uEh = paraml;
  }
  
  private final boolean cQp()
  {
    AppMethodBeat.i(324289);
    if ((this.qxC.ccN() != null) && (this.qxC.qvN.cQd()) && (isAttachedToWindow()))
    {
      AppMethodBeat.o(324289);
      return true;
    }
    AppMethodBeat.o(324289);
    return false;
  }
  
  private final boolean isAttachedToWindow()
  {
    AppMethodBeat.i(324294);
    e locale = this.qxC.qsk;
    if (locale == null)
    {
      AppMethodBeat.o(324294);
      return false;
    }
    boolean bool = locale.isAttachedToWindow();
    AppMethodBeat.o(324294);
    return bool;
  }
  
  public final void DV(int paramInt)
  {
    AppMethodBeat.i(324344);
    this.uEh.DV(paramInt);
    AppMethodBeat.o(324344);
  }
  
  public final void G(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(324356);
    if (this.qxC.getInitConfig().qAT.isEnable()) {
      this.uEh.G(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(324356);
  }
  
  public final void I(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(324319);
    this.uEh.I(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(324319);
  }
  
  public final boolean K(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(324324);
    kotlin.g.b.s.u(paramMotionEvent, "ev");
    if (!cQp())
    {
      AppMethodBeat.o(324324);
      return false;
    }
    boolean bool = this.uEh.K(paramMotionEvent);
    AppMethodBeat.o(324324);
    return bool;
  }
  
  public final boolean L(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(324335);
    kotlin.g.b.s.u(paramMotionEvent, "ev");
    if (!cQp())
    {
      AppMethodBeat.o(324335);
      return false;
    }
    Object localObject = this.qxC.ccN();
    if ((paramMotionEvent.getAction() == 0) && (((y)localObject).getPageCount() == 1))
    {
      if ((!this.qxC.getInitConfig().qAT.isEnable()) || (!this.qxC.getInitConfig().qAT.qZO)) {
        break label112;
      }
      localObject = ((y)localObject).getCurrentPage();
      if (localObject != null) {
        ((u)localObject).setEnableGesture(false);
      }
    }
    for (;;)
    {
      boolean bool = this.uEh.L(paramMotionEvent);
      AppMethodBeat.o(324335);
      return bool;
      label112:
      localObject = ((y)localObject).getCurrentPage();
      if (localObject != null) {
        ((u)localObject).setEnableGesture(true);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.g paramg)
  {
    AppMethodBeat.i(324348);
    kotlin.g.b.s.u(paramg, "type");
    if (!isAttachedToWindow())
    {
      AppMethodBeat.o(324348);
      return;
    }
    this.uEh.a(paramg);
    AppMethodBeat.o(324348);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(324312);
    this.uEh.a(paramk);
    AppMethodBeat.o(324312);
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.s cOP()
  {
    AppMethodBeat.i(324351);
    com.tencent.mm.plugin.appbrand.widget.s locals = this.uEh.cOP();
    AppMethodBeat.o(324351);
    return locals;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerProxy$Companion;", "", "()V", "newInstance", "Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static l ac(w paramw)
    {
      AppMethodBeat.i(324300);
      kotlin.g.b.s.u(paramw, "runtime");
      paramw = (l)new g(paramw, (l)new f(paramw), (byte)0);
      AppMethodBeat.o(324300);
      return paramw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.g
 * JD-Core Version:    0.7.0.1
 */