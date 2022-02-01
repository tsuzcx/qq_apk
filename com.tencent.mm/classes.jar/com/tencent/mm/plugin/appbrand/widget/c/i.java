package com.tencent.mm.plugin.appbrand.widget.c;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.plugin.appbrand.widget.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerProxy;", "Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;)V", "animateContainer", "", "type", "Lcom/tencent/mm/plugin/appbrand/widget/ContainerAnimateType;", "enable", "", "getCurrentStatus", "Lcom/tencent/mm/plugin/appbrand/widget/ViewStatus;", "handleInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "handleTouchEvent", "isAttachedToWindow", "onInterceptTapToFullScreen", "onLayout", "left", "", "top", "right", "bottom", "setDefaultViewHeight", "height", "Companion", "plugin-appbrand-integration_release"})
public final class i
  implements com.tencent.mm.plugin.appbrand.widget.i
{
  public static final a rtx;
  private final t nAH;
  private final com.tencent.mm.plugin.appbrand.widget.i rtw;
  
  static
  {
    AppMethodBeat.i(284446);
    rtx = new a((byte)0);
    AppMethodBeat.o(284446);
  }
  
  private i(t paramt, com.tencent.mm.plugin.appbrand.widget.i parami)
  {
    this.nAH = paramt;
    this.rtw = parami;
  }
  
  private final boolean bFu()
  {
    AppMethodBeat.i(284441);
    y localy = this.nAH.bDz();
    if ((localy != null) && (localy.getPageCount() == 1) && (this.nAH.bDy().nBE.nZE) && (isAttachedToWindow()))
    {
      AppMethodBeat.o(284441);
      return true;
    }
    AppMethodBeat.o(284441);
    return false;
  }
  
  private final boolean isAttachedToWindow()
  {
    AppMethodBeat.i(284442);
    d locald = this.nAH.bBZ();
    if (locald != null)
    {
      boolean bool = locald.isAttachedToWindow();
      AppMethodBeat.o(284442);
      return bool;
    }
    AppMethodBeat.o(284442);
    return false;
  }
  
  public final void C(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(284438);
    this.rtw.C(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(284438);
  }
  
  public final void Dw(int paramInt)
  {
    AppMethodBeat.i(284443);
    this.rtw.Dw(paramInt);
    AppMethodBeat.o(284443);
  }
  
  public final boolean I(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(284439);
    kotlin.g.b.p.k(paramMotionEvent, "ev");
    if (!bFu())
    {
      AppMethodBeat.o(284439);
      return false;
    }
    boolean bool = this.rtw.I(paramMotionEvent);
    AppMethodBeat.o(284439);
    return bool;
  }
  
  public final boolean J(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(284440);
    kotlin.g.b.p.k(paramMotionEvent, "ev");
    if (!bFu())
    {
      AppMethodBeat.o(284440);
      return false;
    }
    Object localObject = this.nAH.bDz();
    if (paramMotionEvent.getAction() == 0)
    {
      kotlin.g.b.p.j(localObject, "pageContainer");
      if (((y)localObject).getPageCount() == 1)
      {
        if ((!this.nAH.bDy().nBE.isEnable()) || (!this.nAH.bDy().nBE.nZE)) {
          break label118;
        }
        localObject = ((y)localObject).getCurrentPage();
        if (localObject != null) {
          ((u)localObject).setEnableGesture(false);
        }
      }
    }
    for (;;)
    {
      boolean bool = this.rtw.J(paramMotionEvent);
      AppMethodBeat.o(284440);
      return bool;
      label118:
      localObject = ((y)localObject).getCurrentPage();
      if (localObject != null) {
        ((u)localObject).setEnableGesture(true);
      }
    }
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(284444);
    kotlin.g.b.p.k(paramf, "type");
    if (!isAttachedToWindow())
    {
      AppMethodBeat.o(284444);
      return;
    }
    this.rtw.a(paramf);
    AppMethodBeat.o(284444);
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.p cmX()
  {
    AppMethodBeat.i(284445);
    com.tencent.mm.plugin.appbrand.widget.p localp = this.rtw.cmX();
    AppMethodBeat.o(284445);
    return localp;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenGestureControllerProxy$Companion;", "", "()V", "newInstance", "Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static com.tencent.mm.plugin.appbrand.widget.i T(t paramt)
    {
      AppMethodBeat.i(280366);
      kotlin.g.b.p.k(paramt, "runtime");
      paramt = (com.tencent.mm.plugin.appbrand.widget.i)new i(paramt, (com.tencent.mm.plugin.appbrand.widget.i)new g(paramt), (byte)0);
      AppMethodBeat.o(280366);
      return paramt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c.i
 * JD-Core Version:    0.7.0.1
 */