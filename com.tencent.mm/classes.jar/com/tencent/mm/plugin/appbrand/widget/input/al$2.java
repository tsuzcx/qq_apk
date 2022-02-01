package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ai;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.plugin.appbrand.widget.base.b;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import java.util.Iterator;
import java.util.LinkedList;

final class al$2
  implements View.OnTouchListener
{
  al$2(al paramal, g paramg, ah paramah) {}
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(177118);
    if (paramMotionEvent.getAction() != 0) {
      com.tencent.mm.plugin.appbrand.jsapi.ac.e.a(this.ovD, paramMotionEvent);
    }
    ah localah = this.ovE;
    boolean bool2;
    com.tencent.mm.plugin.appbrand.widget.base.e locale;
    label112:
    boolean bool1;
    if (paramMotionEvent == null)
    {
      bool2 = false;
      if (bool2)
      {
        AppMethodBeat.o(177118);
        return true;
      }
    }
    else
    {
      locale = localah.ovi.orW;
      if (locale.parent.onFilterTouchEventForSecurity(paramMotionEvent))
      {
        Object localObject;
        label122:
        int j;
        if (paramMotionEvent.getActionMasked() == 0)
        {
          paramView = new b(locale.parent);
          if (paramMotionEvent.getActionMasked() != 0) {
            break label271;
          }
          localObject = new e.a(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), (byte)0);
          locale.omC = ((e.a)localObject);
          bool1 = false;
          if (!paramView.hasNext()) {
            break label305;
          }
          localObject = (View)paramView.next();
          j = paramMotionEvent.getActionIndex();
          if (!locale.parent.isMotionEventSplittingEnabled()) {
            break label277;
          }
        }
        label256:
        label271:
        label277:
        for (int i = 1 << paramMotionEvent.getPointerId(j);; i = -1)
        {
          float f1 = paramMotionEvent.getX(j);
          float f2 = paramMotionEvent.getY(j);
          if (paramMotionEvent.getActionMasked() != 0) {
            break label283;
          }
          if ((!AppBrandViewMotionCompat.cN((View)localObject)) || (!AppBrandViewMotionCompat.a(locale.parent, f1, f2, (View)localObject))) {
            break label122;
          }
          if (!AppBrandViewMotionCompat.cM((View)localObject)) {
            break label590;
          }
          if (!AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.parent, paramMotionEvent, false, (View)localObject, i)) {
            break label587;
          }
          locale.omB.addLast(localObject);
          bool1 |= true;
          break label122;
          paramView = locale.omB.iterator();
          break;
          localObject = null;
          break label112;
        }
        label283:
        bool1 = AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.parent, paramMotionEvent, false, (View)localObject, i) | bool1;
      }
    }
    label305:
    label446:
    label587:
    label590:
    for (;;)
    {
      break label122;
      bool2 = bool1;
      switch (paramMotionEvent.getActionMasked())
      {
      default: 
        bool2 = bool1;
      case 2: 
        a.a("MicroMsg.AppBrand.InputTouchDuplicateDispatcher", "[textscroll] handled | ".concat(String.valueOf(bool2)), paramMotionEvent);
        if (2 == paramMotionEvent.getActionMasked())
        {
          if ((bool2) && (!localah.ovj))
          {
            paramView = (aj)localah.ovn.df(localah.ovi);
            if (paramView != null)
            {
              if (paramView.mDisabled) {
                break label510;
              }
              bool1 = true;
              localah.ovk = bool1;
              paramView.setPullDownEnabled(false);
              paramView.requestDisallowInterceptTouchEvent(true);
              localah.ovj = true;
            }
          }
          if (!bool2) {
            break label516;
          }
          localah.ovl = true;
        }
        else
        {
          switch (paramMotionEvent.getActionMasked())
          {
          }
        }
        break;
      case 1: 
      case 3: 
        for (;;)
        {
          label344:
          bool2 = false;
          break;
          locale.omB.clear();
          bool2 = bool1;
          break label344;
          bool2 = false;
          break label344;
          label510:
          bool1 = false;
          break label412;
          if (!localah.ovl) {
            break label446;
          }
          localah.ovl = false;
          break label446;
          if (localah.ovj)
          {
            paramView = (aj)localah.ovn.df(localah.ovi);
            if (paramView != null) {
              paramView.setPullDownEnabled(localah.ovk);
            }
            localah.ovj = false;
          }
        }
        AppMethodBeat.o(177118);
        return false;
        break label256;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.al.2
 * JD-Core Version:    0.7.0.1
 */