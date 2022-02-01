package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.av;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class al
  implements bb
{
  private static View.OnTouchListener nlU;
  private final z ckP;
  private final g nlV;
  
  static
  {
    AppMethodBeat.i(177120);
    nlU = new al.1();
    AppMethodBeat.o(177120);
  }
  
  public al(z paramz)
  {
    AppMethodBeat.i(136600);
    this.ckP = paramz;
    this.nlV = new g(paramz);
    AppMethodBeat.o(136600);
  }
  
  public final void a(av paramav)
  {
    AppMethodBeat.i(136602);
    if ((paramav == av.miM) || (paramav == av.miN)) {
      o.y(this.ckP);
    }
    AppMethodBeat.o(136602);
  }
  
  public final void a(ax paramax)
  {
    AppMethodBeat.i(177119);
    if (paramax.getContentView() == null)
    {
      AppMethodBeat.o(177119);
      return;
    }
    ((ViewGroup)paramax.getContentView()).setOnTouchListener(nlU);
    AppMethodBeat.o(177119);
  }
  
  public final void c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136605);
    this.nlV.c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(136605);
  }
  
  public final ViewGroup getContainer()
  {
    return this.nlV;
  }
  
  public final void gw(int paramInt)
  {
    AppMethodBeat.i(136603);
    this.nlV.setTranslationY(paramInt);
    AppMethodBeat.o(136603);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(136604);
    this.nlV.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(136604);
  }
  
  public final void setupWebViewTouchInterceptor(ax paramax)
  {
    AppMethodBeat.i(136601);
    paramax = (ViewGroup)paramax.getContentView();
    final g localg = this.nlV;
    paramax.setOnTouchListener(new View.OnTouchListener()
    {
      @SuppressLint({"ClickableViewAccessibility"})
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(177118);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/NativeWidgetContainerWithInputDuplicateTouch$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (paramAnonymousMotionEvent.getAction() != 0) {
          com.tencent.mm.plugin.appbrand.jsapi.aa.e.a(localg, paramAnonymousMotionEvent);
        }
        ah localah = this.nlX;
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
          locale = localah.nlB.nio;
          if (locale.gsV.onFilterTouchEventForSecurity(paramAnonymousMotionEvent))
          {
            label173:
            int j;
            if (paramAnonymousMotionEvent.getActionMasked() == 0)
            {
              paramAnonymousView = new com.tencent.mm.plugin.appbrand.widget.base.b(locale.gsV);
              if (paramAnonymousMotionEvent.getActionMasked() != 0) {
                break label322;
              }
              localObject = new e.a(paramAnonymousMotionEvent.getDownTime(), paramAnonymousMotionEvent.getEventTime(), (byte)0);
              locale.mZx = ((e.a)localObject);
              bool1 = false;
              if (!paramAnonymousView.hasNext()) {
                break label356;
              }
              localObject = (View)paramAnonymousView.next();
              j = paramAnonymousMotionEvent.getActionIndex();
              if (!locale.gsV.isMotionEventSplittingEnabled()) {
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
              if ((!AppBrandViewMotionCompat.cW((View)localObject)) || (!AppBrandViewMotionCompat.a(locale.gsV, f1, f2, (View)localObject))) {
                break label173;
              }
              if (!AppBrandViewMotionCompat.cV((View)localObject)) {
                break label655;
              }
              if (!AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.gsV, paramAnonymousMotionEvent, false, (View)localObject, i)) {
                break label652;
              }
              locale.mZw.addLast(localObject);
              bool1 |= true;
              break label173;
              paramAnonymousView = locale.mZw.iterator();
              break;
              localObject = null;
              break label163;
            }
            label334:
            bool1 = AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.gsV, paramAnonymousMotionEvent, false, (View)localObject, i) | bool1;
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
              if ((bool2) && (!localah.nlC))
              {
                paramAnonymousView = (ag)localah.nlG.jdMethod_do(localah.nlB);
                if (paramAnonymousView != null)
                {
                  if (paramAnonymousView.mhk) {
                    break label562;
                  }
                  bool1 = true;
                  localah.nlD = bool1;
                  paramAnonymousView.setPullDownEnabled(false);
                  paramAnonymousView.requestDisallowInterceptTouchEvent(true);
                  localah.nlC = true;
                }
              }
              if (!bool2) {
                break label568;
              }
              localah.nlE = true;
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
              locale.mZw.clear();
              bool2 = bool1;
              break label396;
              bool2 = false;
              break label396;
              label562:
              bool1 = false;
              break label464;
              label568:
              if (!localah.nlE) {
                break label498;
              }
              localah.nlE = false;
              break label498;
              if (localah.nlC)
              {
                paramAnonymousView = (ag)localah.nlG.jdMethod_do(localah.nlB);
                if (paramAnonymousView != null) {
                  paramAnonymousView.setPullDownEnabled(localah.nlD);
                }
                localah.nlC = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.al
 * JD-Core Version:    0.7.0.1
 */