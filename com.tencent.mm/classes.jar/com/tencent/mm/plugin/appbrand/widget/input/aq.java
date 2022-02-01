package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.ak;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bh;
import com.tencent.mm.plugin.appbrand.page.bh.a;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.plugin.appbrand.widget.base.b;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class aq
  implements bh
{
  private static View.OnTouchListener ryn;
  private final ad cvo;
  private final g ryo;
  
  static
  {
    AppMethodBeat.i(177120);
    ryn = new aq.1();
    AppMethodBeat.o(177120);
  }
  
  public aq(ad paramad)
  {
    AppMethodBeat.i(136600);
    this.cvo = paramad;
    this.ryo = new g(paramad);
    AppMethodBeat.o(136600);
  }
  
  public final void a(bb parambb)
  {
    AppMethodBeat.i(136602);
    if ((parambb == bb.quZ) || (parambb == bb.qva)) {
      o.D(this.cvo);
    }
    AppMethodBeat.o(136602);
  }
  
  public final void a(bd parambd)
  {
    AppMethodBeat.i(177119);
    if (parambd.getContentView() == null)
    {
      AppMethodBeat.o(177119);
      return;
    }
    ((ViewGroup)parambd.getContentView()).setOnTouchListener(ryn);
    AppMethodBeat.o(177119);
  }
  
  public final void c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136605);
    this.ryo.c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(136605);
  }
  
  public final ViewGroup getContainer()
  {
    return this.ryo;
  }
  
  public final void iK(int paramInt)
  {
    AppMethodBeat.i(136603);
    this.ryo.setTranslationY(paramInt);
    AppMethodBeat.o(136603);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(136604);
    this.ryo.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(136604);
  }
  
  public final void setupWebViewTouchInterceptor(bd parambd)
  {
    AppMethodBeat.i(136601);
    parambd = (ViewGroup)parambd.getContentView();
    final g localg = this.ryo;
    parambd.setOnTouchListener(new View.OnTouchListener()
    {
      @SuppressLint({"ClickableViewAccessibility"})
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(177118);
        if (paramAnonymousMotionEvent.getAction() != 0) {
          com.tencent.mm.plugin.appbrand.jsapi.ae.e.a(localg, paramAnonymousMotionEvent);
        }
        al localal = this.ryq;
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
          locale = localal.rxK.ruf;
          if (locale.parent.onFilterTouchEventForSecurity(paramAnonymousMotionEvent))
          {
            Object localObject;
            label122:
            int j;
            if (paramAnonymousMotionEvent.getActionMasked() == 0)
            {
              paramAnonymousView = new b(locale.parent);
              if (paramAnonymousMotionEvent.getActionMasked() != 0) {
                break label271;
              }
              localObject = new e.a(paramAnonymousMotionEvent.getDownTime(), paramAnonymousMotionEvent.getEventTime(), (byte)0);
              locale.rpe = ((e.a)localObject);
              bool1 = false;
              if (!paramAnonymousView.hasNext()) {
                break label305;
              }
              localObject = (View)paramAnonymousView.next();
              j = paramAnonymousMotionEvent.getActionIndex();
              if (!locale.parent.isMotionEventSplittingEnabled()) {
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
              if ((!AppBrandViewMotionCompat.dh((View)localObject)) || (!AppBrandViewMotionCompat.a(locale.parent, f1, f2, (View)localObject))) {
                break label122;
              }
              if (!AppBrandViewMotionCompat.dg((View)localObject)) {
                break label590;
              }
              if (!AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.parent, paramAnonymousMotionEvent, false, (View)localObject, i)) {
                break label587;
              }
              locale.rpd.addLast(localObject);
              bool1 |= true;
              break label122;
              paramAnonymousView = locale.rpd.iterator();
              break;
              localObject = null;
              break label112;
            }
            label283:
            bool1 = AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.parent, paramAnonymousMotionEvent, false, (View)localObject, i) | bool1;
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
              if ((bool2) && (!localal.rxL))
              {
                paramAnonymousView = (ak)localal.rxP.dA(localal.rxK);
                if (paramAnonymousView != null)
                {
                  if (paramAnonymousView.mDisabled) {
                    break label510;
                  }
                  bool1 = true;
                  localal.rxM = bool1;
                  paramAnonymousView.setPullDownEnabled(false);
                  paramAnonymousView.requestDisallowInterceptTouchEvent(true);
                  localal.rxL = true;
                }
              }
              if (!bool2) {
                break label516;
              }
              localal.rxN = true;
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
              locale.rpd.clear();
              bool2 = bool1;
              break label344;
              bool2 = false;
              break label344;
              label510:
              bool1 = false;
              break label412;
              if (!localal.rxN) {
                break label446;
              }
              localal.rxN = false;
              break label446;
              if (localal.rxL)
              {
                paramAnonymousView = (ak)localal.rxP.dA(localal.rxK);
                if (paramAnonymousView != null) {
                  paramAnonymousView.setPullDownEnabled(localal.rxM);
                }
                localal.rxL = false;
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
    implements bh.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aq
 * JD-Core Version:    0.7.0.1
 */