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
import com.tencent.mm.plugin.appbrand.page.bc.a;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.plugin.appbrand.widget.base.b;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class al
  implements bc
{
  private static View.OnTouchListener mGo;
  private final aa caw;
  private final g mGp;
  
  static
  {
    AppMethodBeat.i(177120);
    mGo = new al.1();
    AppMethodBeat.o(177120);
  }
  
  public al(aa paramaa)
  {
    AppMethodBeat.i(136600);
    this.caw = paramaa;
    this.mGp = new g(paramaa);
    AppMethodBeat.o(136600);
  }
  
  public final void a(aw paramaw)
  {
    AppMethodBeat.i(136602);
    if ((paramaw == aw.lEO) || (paramaw == aw.lEP)) {
      o.x(this.caw);
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
    ((ViewGroup)paramay.getContentView()).setOnTouchListener(mGo);
    AppMethodBeat.o(177119);
  }
  
  public final void d(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136605);
    this.mGp.d(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(136605);
  }
  
  public final ViewGroup getContainer()
  {
    return this.mGp;
  }
  
  public final void gt(int paramInt)
  {
    AppMethodBeat.i(136603);
    this.mGp.setTranslationY(paramInt);
    AppMethodBeat.o(136603);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(136604);
    this.mGp.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(136604);
  }
  
  public final void setupWebViewTouchInterceptor(ay paramay)
  {
    AppMethodBeat.i(136601);
    paramay = (ViewGroup)paramay.getContentView();
    final g localg = this.mGp;
    paramay.setOnTouchListener(new View.OnTouchListener()
    {
      @SuppressLint({"ClickableViewAccessibility"})
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(177118);
        if (paramAnonymousMotionEvent.getAction() != 0) {
          com.tencent.mm.plugin.appbrand.jsapi.w.e.a(localg, paramAnonymousMotionEvent);
        }
        ah localah = this.mGr;
        boolean bool2;
        com.tencent.mm.plugin.appbrand.widget.base.e locale;
        label112:
        boolean bool1;
        if (paramAnonymousMotionEvent == null)
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
          locale = localah.mFV.mCF;
          if (locale.fWU.onFilterTouchEventForSecurity(paramAnonymousMotionEvent))
          {
            Object localObject;
            label122:
            int j;
            if (paramAnonymousMotionEvent.getActionMasked() == 0)
            {
              paramAnonymousView = new b(locale.fWU);
              if (paramAnonymousMotionEvent.getActionMasked() != 0) {
                break label271;
              }
              localObject = new e.a(paramAnonymousMotionEvent.getDownTime(), paramAnonymousMotionEvent.getEventTime(), (byte)0);
              locale.mtK = ((e.a)localObject);
              bool1 = false;
              if (!paramAnonymousView.hasNext()) {
                break label305;
              }
              localObject = (View)paramAnonymousView.next();
              j = paramAnonymousMotionEvent.getActionIndex();
              if (!locale.fWU.isMotionEventSplittingEnabled()) {
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
              if ((!AppBrandViewMotionCompat.cU((View)localObject)) || (!AppBrandViewMotionCompat.a(locale.fWU, f1, f2, (View)localObject))) {
                break label122;
              }
              if (!AppBrandViewMotionCompat.cT((View)localObject)) {
                break label590;
              }
              if (!AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.fWU, paramAnonymousMotionEvent, false, (View)localObject, i)) {
                break label587;
              }
              locale.mtJ.addLast(localObject);
              bool1 |= true;
              break label122;
              paramAnonymousView = locale.mtJ.iterator();
              break;
              localObject = null;
              break label112;
            }
            label283:
            bool1 = AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.fWU, paramAnonymousMotionEvent, false, (View)localObject, i) | bool1;
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
              if ((bool2) && (!localah.mFW))
              {
                paramAnonymousView = (com.tencent.mm.plugin.appbrand.page.ah)localah.mGa.dm(localah.mFV);
                if (paramAnonymousView != null)
                {
                  if (paramAnonymousView.lDp) {
                    break label510;
                  }
                  bool1 = true;
                  localah.mFX = bool1;
                  paramAnonymousView.setPullDownEnabled(false);
                  paramAnonymousView.requestDisallowInterceptTouchEvent(true);
                  localah.mFW = true;
                }
              }
              if (!bool2) {
                break label516;
              }
              localah.mFY = true;
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
              locale.mtJ.clear();
              bool2 = bool1;
              break label344;
              bool2 = false;
              break label344;
              label510:
              bool1 = false;
              break label412;
              if (!localah.mFY) {
                break label446;
              }
              localah.mFY = false;
              break label446;
              if (localah.mFW)
              {
                paramAnonymousView = (com.tencent.mm.plugin.appbrand.page.ah)localah.mGa.dm(localah.mFV);
                if (paramAnonymousView != null) {
                  paramAnonymousView.setPullDownEnabled(localah.mFX);
                }
                localah.mFW = false;
              }
            }
            AppMethodBeat.o(177118);
            return false;
            break label256;
          }
        }
      }
    });
    AppMethodBeat.o(136601);
  }
  
  public static final class a
    implements bc.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.al
 * JD-Core Version:    0.7.0.1
 */