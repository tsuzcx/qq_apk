package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.x.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bh;
import com.tencent.mm.plugin.appbrand.page.bh.a;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.plugin.appbrand.widget.base.b;
import com.tencent.mm.plugin.appbrand.widget.base.e;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class al
  implements bh
{
  private static View.OnTouchListener mep;
  private final aa cdz;
  private final g meq;
  
  static
  {
    AppMethodBeat.i(177120);
    mep = new al.1();
    AppMethodBeat.o(177120);
  }
  
  public al(aa paramaa)
  {
    AppMethodBeat.i(136600);
    this.cdz = paramaa;
    this.meq = new g(paramaa);
    AppMethodBeat.o(136600);
  }
  
  public final void a(bb parambb)
  {
    AppMethodBeat.i(136602);
    if ((parambb == bb.leY) || (parambb == bb.leZ)) {
      o.x(this.cdz);
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
    ((ViewGroup)parambd.getContentView()).setOnTouchListener(mep);
    AppMethodBeat.o(177119);
  }
  
  public final void d(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136605);
    this.meq.d(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(136605);
  }
  
  public final void gJ(int paramInt)
  {
    AppMethodBeat.i(136603);
    this.meq.setTranslationY(paramInt);
    AppMethodBeat.o(136603);
  }
  
  public final ViewGroup getContainer()
  {
    return this.meq;
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(136604);
    this.meq.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(136604);
  }
  
  public final void setupWebViewTouchInterceptor(bd parambd)
  {
    AppMethodBeat.i(136601);
    parambd = (ViewGroup)parambd.getContentView();
    final g localg = this.meq;
    parambd.setOnTouchListener(new View.OnTouchListener()
    {
      @SuppressLint({"ClickableViewAccessibility"})
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(177118);
        if (paramAnonymousMotionEvent.getAction() != 0) {
          d.a(localg, paramAnonymousMotionEvent);
        }
        ah localah = this.mes;
        boolean bool2;
        e locale;
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
          locale = localah.mdW.maI;
          if (locale.fSZ.onFilterTouchEventForSecurity(paramAnonymousMotionEvent))
          {
            Object localObject;
            label122:
            int j;
            if (paramAnonymousMotionEvent.getActionMasked() == 0)
            {
              paramAnonymousView = new b(locale.fSZ);
              if (paramAnonymousMotionEvent.getActionMasked() != 0) {
                break label271;
              }
              localObject = new e.a(paramAnonymousMotionEvent.getDownTime(), paramAnonymousMotionEvent.getEventTime(), (byte)0);
              locale.lRI = ((e.a)localObject);
              bool1 = false;
              if (!paramAnonymousView.hasNext()) {
                break label305;
              }
              localObject = (View)paramAnonymousView.next();
              j = paramAnonymousMotionEvent.getActionIndex();
              if (!locale.fSZ.isMotionEventSplittingEnabled()) {
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
              if ((!AppBrandViewMotionCompat.cS((View)localObject)) || (!AppBrandViewMotionCompat.a(locale.fSZ, f1, f2, (View)localObject))) {
                break label122;
              }
              if (!AppBrandViewMotionCompat.cR((View)localObject)) {
                break label590;
              }
              if (!AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.fSZ, paramAnonymousMotionEvent, false, (View)localObject, i)) {
                break label587;
              }
              locale.lRH.addLast(localObject);
              bool1 |= true;
              break label122;
              paramAnonymousView = locale.lRH.iterator();
              break;
              localObject = null;
              break label112;
            }
            label283:
            bool1 = AppBrandViewMotionCompat.dispatchTransformedTouchEvent(locale.fSZ, paramAnonymousMotionEvent, false, (View)localObject, i) | bool1;
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
              if ((bool2) && (!localah.mdX))
              {
                paramAnonymousView = (am)localah.meb.dk(localah.mdW);
                if (paramAnonymousView != null)
                {
                  if (paramAnonymousView.ldy) {
                    break label510;
                  }
                  bool1 = true;
                  localah.mdY = bool1;
                  paramAnonymousView.setPullDownEnabled(false);
                  paramAnonymousView.requestDisallowInterceptTouchEvent(true);
                  localah.mdX = true;
                }
              }
              if (!bool2) {
                break label516;
              }
              localah.mdZ = true;
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
              locale.lRH.clear();
              bool2 = bool1;
              break label344;
              bool2 = false;
              break label344;
              label510:
              bool1 = false;
              break label412;
              if (!localah.mdZ) {
                break label446;
              }
              localah.mdZ = false;
              break label446;
              if (localah.mdX)
              {
                paramAnonymousView = (am)localah.meb.dk(localah.mdW);
                if (paramAnonymousView != null) {
                  paramAnonymousView.setPullDownEnabled(localah.mdY);
                }
                localah.mdX = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.al
 * JD-Core Version:    0.7.0.1
 */