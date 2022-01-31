package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.jsapi.s.c;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.plugin.appbrand.widget.base.b;
import com.tencent.mm.plugin.appbrand.widget.base.e;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import java.util.Iterator;
import java.util.LinkedList;

final class ak$1
  implements View.OnTouchListener
{
  ak$1(ak paramak, g paramg, ag paramag) {}
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 0) {
      c.a(this.hwp, paramMotionEvent);
    }
    ag localag = this.hwq;
    boolean bool2;
    e locale;
    label102:
    boolean bool1;
    if (paramMotionEvent == null)
    {
      bool2 = false;
      if (bool2) {
        return true;
      }
    }
    else
    {
      locale = localag.hvU.htn;
      if (locale.hpb.onFilterTouchEventForSecurity(paramMotionEvent))
      {
        Object localObject;
        label112:
        int j;
        if (paramMotionEvent.getActionMasked() == 0)
        {
          paramView = new b(locale.hpb);
          if (paramMotionEvent.getActionMasked() != 0) {
            break label261;
          }
          localObject = new e.a(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), (byte)0);
          locale.hpe = ((e.a)localObject);
          bool1 = false;
          if (!paramView.hasNext()) {
            break label295;
          }
          localObject = (View)paramView.next();
          j = paramMotionEvent.getActionIndex();
          if (!locale.hpb.isMotionEventSplittingEnabled()) {
            break label267;
          }
        }
        label261:
        label267:
        for (int i = 1 << paramMotionEvent.getPointerId(j);; i = -1)
        {
          float f1 = paramMotionEvent.getX(j);
          float f2 = paramMotionEvent.getY(j);
          if (paramMotionEvent.getActionMasked() != 0) {
            break label273;
          }
          if ((!AppBrandViewMotionCompat.cd((View)localObject)) || (!AppBrandViewMotionCompat.a(locale.hpb, f1, f2, (View)localObject))) {
            break label112;
          }
          if (!AppBrandViewMotionCompat.cc((View)localObject)) {
            break label581;
          }
          if (!AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.hpb, paramMotionEvent, false, (View)localObject, i)) {
            break label578;
          }
          locale.hpd.addLast(localObject);
          bool1 |= true;
          label246:
          break label112;
          paramView = locale.hpd.iterator();
          break;
          localObject = null;
          break label102;
        }
        label273:
        bool1 = AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.hpb, paramMotionEvent, false, (View)localObject, i) | bool1;
      }
    }
    label295:
    label441:
    label578:
    label581:
    for (;;)
    {
      break label112;
      bool2 = bool1;
      switch (paramMotionEvent.getActionMasked())
      {
      default: 
        bool2 = bool1;
      case 2: 
        a.a("MicroMsg.AppBrand.InputTouchDuplicateDispatcher", "[textscroll] handled | " + bool2, paramMotionEvent);
        if (2 == paramMotionEvent.getActionMasked())
        {
          if ((bool2) && (!localag.hvV))
          {
            paramView = (u)localag.hvZ.cr(localag.hvU);
            if (paramView != null)
            {
              if (paramView.gUE) {
                break label506;
              }
              bool1 = true;
              localag.hvW = bool1;
              paramView.setPullDownEnabled(false);
              paramView.requestDisallowInterceptTouchEvent(true);
              localag.hvV = true;
            }
          }
          if (!bool2) {
            break label512;
          }
          localag.hvX = true;
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
          label332:
          bool2 = false;
          break;
          locale.hpd.clear();
          bool2 = bool1;
          break label332;
          bool2 = false;
          break label332;
          label506:
          bool1 = false;
          break label407;
          if (!localag.hvX) {
            break label441;
          }
          localag.hvX = false;
          break label441;
          if (localag.hvV)
          {
            paramView = (u)localag.hvZ.cr(localag.hvU);
            if (paramView != null) {
              paramView.setPullDownEnabled(localag.hvW);
            }
            localag.hvV = false;
          }
        }
        return false;
        break label246;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ak.1
 * JD-Core Version:    0.7.0.1
 */