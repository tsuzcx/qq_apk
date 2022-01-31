package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.page.an;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.plugin.appbrand.widget.base.b;
import com.tencent.mm.plugin.appbrand.widget.base.e;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class al
  implements as
{
  private final v bBK;
  private final g joA;
  
  public al(v paramv)
  {
    AppMethodBeat.i(123860);
    this.bBK = paramv;
    this.joA = new g(paramv);
    AppMethodBeat.o(123860);
  }
  
  public final void a(an paraman)
  {
    AppMethodBeat.i(123862);
    if ((paraman == an.iyW) || (paraman == an.iyX)) {
      o.q(this.bBK);
    }
    AppMethodBeat.o(123862);
  }
  
  public final void c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(123865);
    this.joA.c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(123865);
  }
  
  public final void fr(int paramInt)
  {
    AppMethodBeat.i(123863);
    this.joA.setTranslationY(paramInt);
    AppMethodBeat.o(123863);
  }
  
  public final ViewGroup getContainer()
  {
    return this.joA;
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(123864);
    this.joA.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(123864);
  }
  
  public final void setupWebViewTouchInterceptor(ap paramap)
  {
    AppMethodBeat.i(123861);
    paramap = (ViewGroup)paramap.getContentView();
    final g localg = this.joA;
    paramap.setOnTouchListener(new View.OnTouchListener()
    {
      @SuppressLint({"ClickableViewAccessibility"})
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123858);
        if (paramAnonymousMotionEvent.getAction() != 0) {
          d.a(localg, paramAnonymousMotionEvent);
        }
        ah localah = this.joC;
        boolean bool2;
        e locale;
        label112:
        boolean bool1;
        if (paramAnonymousMotionEvent == null)
        {
          bool2 = false;
          if (bool2)
          {
            AppMethodBeat.o(123858);
            return true;
          }
        }
        else
        {
          locale = localah.joh.jkS;
          if (locale.eyt.onFilterTouchEventForSecurity(paramAnonymousMotionEvent))
          {
            Object localObject;
            label122:
            int j;
            if (paramAnonymousMotionEvent.getActionMasked() == 0)
            {
              paramAnonymousView = new b(locale.eyt);
              if (paramAnonymousMotionEvent.getActionMasked() != 0) {
                break label271;
              }
              localObject = new e.a(paramAnonymousMotionEvent.getDownTime(), paramAnonymousMotionEvent.getEventTime(), (byte)0);
              locale.jbO = ((e.a)localObject);
              bool1 = false;
              if (!paramAnonymousView.hasNext()) {
                break label305;
              }
              localObject = (View)paramAnonymousView.next();
              j = paramAnonymousMotionEvent.getActionIndex();
              if (!locale.eyt.isMotionEventSplittingEnabled()) {
                break label277;
              }
            }
            label256:
            label271:
            label277:
            for (int i = 1 << paramAnonymousMotionEvent.getPointerId(j);; i = -1)
            {
              float f1 = paramAnonymousMotionEvent.getX(j);
              float f2 = paramAnonymousMotionEvent.getY(j);
              if (paramAnonymousMotionEvent.getActionMasked() != 0) {
                break label283;
              }
              if ((!AppBrandViewMotionCompat.cG((View)localObject)) || (!AppBrandViewMotionCompat.a(locale.eyt, f1, f2, (View)localObject))) {
                break label122;
              }
              if (!AppBrandViewMotionCompat.cF((View)localObject)) {
                break label590;
              }
              if (!AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.eyt, paramAnonymousMotionEvent, false, (View)localObject, i)) {
                break label587;
              }
              locale.jbN.addLast(localObject);
              bool1 |= true;
              break label122;
              paramAnonymousView = locale.jbN.iterator();
              break;
              localObject = null;
              break label112;
            }
            label283:
            bool1 = AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.eyt, paramAnonymousMotionEvent, false, (View)localObject, i) | bool1;
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
          switch (paramAnonymousMotionEvent.getActionMasked())
          {
          default: 
            bool2 = bool1;
          case 2: 
            a.a("MicroMsg.AppBrand.InputTouchDuplicateDispatcher", "[textscroll] handled | ".concat(String.valueOf(bool2)), paramAnonymousMotionEvent);
            if (2 == paramAnonymousMotionEvent.getActionMasked())
            {
              if ((bool2) && (!localah.joi))
              {
                paramAnonymousView = (ab)localah.jom.cU(localah.joh);
                if (paramAnonymousView != null)
                {
                  if (paramAnonymousView.ixN) {
                    break label510;
                  }
                  bool1 = true;
                  localah.joj = bool1;
                  paramAnonymousView.setPullDownEnabled(false);
                  paramAnonymousView.requestDisallowInterceptTouchEvent(true);
                  localah.joi = true;
                }
              }
              if (!bool2) {
                break label516;
              }
              localah.jok = true;
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
              label344:
              bool2 = false;
              break;
              locale.jbN.clear();
              bool2 = bool1;
              break label344;
              bool2 = false;
              break label344;
              label510:
              bool1 = false;
              break label412;
              if (!localah.jok) {
                break label446;
              }
              localah.jok = false;
              break label446;
              if (localah.joi)
              {
                paramAnonymousView = (ab)localah.jom.cU(localah.joh);
                if (paramAnonymousView != null) {
                  paramAnonymousView.setPullDownEnabled(localah.joj);
                }
                localah.joi = false;
              }
            }
            AppMethodBeat.o(123858);
            return false;
            break label256;
          }
        }
      }
    });
    AppMethodBeat.o(123861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.al
 * JD-Core Version:    0.7.0.1
 */