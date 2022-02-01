package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.aw;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.page.bc;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class al
  implements bc
{
  private static View.OnTouchListener ngM;
  private final aa ckN;
  private final g ngN;
  
  static
  {
    AppMethodBeat.i(177120);
    ngM = new al.1();
    AppMethodBeat.o(177120);
  }
  
  public al(aa paramaa)
  {
    AppMethodBeat.i(136600);
    this.ckN = paramaa;
    this.ngN = new g(paramaa);
    AppMethodBeat.o(136600);
  }
  
  public final void a(aw paramaw)
  {
    AppMethodBeat.i(136602);
    if ((paramaw == aw.mes) || (paramaw == aw.met)) {
      o.x(this.ckN);
    }
    AppMethodBeat.o(136602);
  }
  
  public final void a(ay paramay)
  {
    AppMethodBeat.i(177119);
    if (paramay.getContentView() == null)
    {
      AppMethodBeat.o(177119);
      return;
    }
    ((ViewGroup)paramay.getContentView()).setOnTouchListener(ngM);
    AppMethodBeat.o(177119);
  }
  
  public final void c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136605);
    this.ngN.c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(136605);
  }
  
  public final ViewGroup getContainer()
  {
    return this.ngN;
  }
  
  public final void gw(int paramInt)
  {
    AppMethodBeat.i(136603);
    this.ngN.setTranslationY(paramInt);
    AppMethodBeat.o(136603);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(136604);
    this.ngN.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(136604);
  }
  
  public final void setupWebViewTouchInterceptor(ay paramay)
  {
    AppMethodBeat.i(136601);
    paramay = (ViewGroup)paramay.getContentView();
    final g localg = this.ngN;
    paramay.setOnTouchListener(new View.OnTouchListener()
    {
      @SuppressLint({"ClickableViewAccessibility"})
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(177118);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/NativeWidgetContainerWithInputDuplicateTouch$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (paramAnonymousMotionEvent.getAction() != 0) {
          com.tencent.mm.plugin.appbrand.jsapi.z.e.a(localg, paramAnonymousMotionEvent);
        }
        ah localah = this.ngP;
        boolean bool2;
        com.tencent.mm.plugin.appbrand.widget.base.e locale;
        label163:
        boolean bool1;
        if (paramAnonymousMotionEvent == null)
        {
          bool2 = false;
          if (bool2)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/input/NativeWidgetContainerWithInputDuplicateTouch$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(177118);
            return true;
          }
        }
        else
        {
          locale = localah.ngt.ndf;
          if (locale.gqv.onFilterTouchEventForSecurity(paramAnonymousMotionEvent))
          {
            label173:
            int j;
            if (paramAnonymousMotionEvent.getActionMasked() == 0)
            {
              paramAnonymousView = new com.tencent.mm.plugin.appbrand.widget.base.b(locale.gqv);
              if (paramAnonymousMotionEvent.getActionMasked() != 0) {
                break label322;
              }
              localObject = new e.a(paramAnonymousMotionEvent.getDownTime(), paramAnonymousMotionEvent.getEventTime(), (byte)0);
              locale.mUq = ((e.a)localObject);
              bool1 = false;
              if (!paramAnonymousView.hasNext()) {
                break label356;
              }
              localObject = (View)paramAnonymousView.next();
              j = paramAnonymousMotionEvent.getActionIndex();
              if (!locale.gqv.isMotionEventSplittingEnabled()) {
                break label328;
              }
            }
            label307:
            label322:
            label328:
            for (int i = 1 << paramAnonymousMotionEvent.getPointerId(j);; i = -1)
            {
              float f1 = paramAnonymousMotionEvent.getX(j);
              float f2 = paramAnonymousMotionEvent.getY(j);
              if (paramAnonymousMotionEvent.getActionMasked() != 0) {
                break label334;
              }
              if ((!AppBrandViewMotionCompat.cW((View)localObject)) || (!AppBrandViewMotionCompat.a(locale.gqv, f1, f2, (View)localObject))) {
                break label173;
              }
              if (!AppBrandViewMotionCompat.cV((View)localObject)) {
                break label655;
              }
              if (!AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.gqv, paramAnonymousMotionEvent, false, (View)localObject, i)) {
                break label652;
              }
              locale.mUp.addLast(localObject);
              bool1 |= true;
              break label173;
              paramAnonymousView = locale.mUp.iterator();
              break;
              localObject = null;
              break label163;
            }
            label334:
            bool1 = AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.gqv, paramAnonymousMotionEvent, false, (View)localObject, i) | bool1;
          }
        }
        label396:
        label655:
        for (;;)
        {
          break label173;
          label356:
          bool2 = bool1;
          switch (paramAnonymousMotionEvent.getActionMasked())
          {
          default: 
            bool2 = bool1;
          case 2: 
            com.tencent.mm.plugin.appbrand.widget.base.a.a("MicroMsg.AppBrand.InputTouchDuplicateDispatcher", "[textscroll] handled | ".concat(String.valueOf(bool2)), paramAnonymousMotionEvent);
            if (2 == paramAnonymousMotionEvent.getActionMasked())
            {
              if ((bool2) && (!localah.ngu))
              {
                paramAnonymousView = (com.tencent.mm.plugin.appbrand.page.ah)localah.ngy.jdMethod_do(localah.ngt);
                if (paramAnonymousView != null)
                {
                  if (paramAnonymousView.mcS) {
                    break label562;
                  }
                  bool1 = true;
                  localah.ngv = bool1;
                  paramAnonymousView.setPullDownEnabled(false);
                  paramAnonymousView.requestDisallowInterceptTouchEvent(true);
                  localah.ngu = true;
                }
              }
              if (!bool2) {
                break label568;
              }
              localah.ngw = true;
            }
            else
            {
              switch (paramAnonymousMotionEvent.getActionMasked())
              {
              }
            }
            break;
          case 1: 
          case 3: 
            for (;;)
            {
              label464:
              label498:
              bool2 = false;
              break;
              locale.mUp.clear();
              bool2 = bool1;
              break label396;
              bool2 = false;
              break label396;
              label562:
              bool1 = false;
              break label464;
              label568:
              if (!localah.ngw) {
                break label498;
              }
              localah.ngw = false;
              break label498;
              if (localah.ngu)
              {
                paramAnonymousView = (com.tencent.mm.plugin.appbrand.page.ah)localah.ngy.jdMethod_do(localah.ngt);
                if (paramAnonymousView != null) {
                  paramAnonymousView.setPullDownEnabled(localah.ngv);
                }
                localah.ngu = false;
              }
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/input/NativeWidgetContainerWithInputDuplicateTouch$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(177118);
            return false;
            break label307;
          }
        }
      }
    });
    AppMethodBeat.o(136601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.al
 * JD-Core Version:    0.7.0.1
 */