package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import com.tencent.luggage.wxa.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ak.b;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.au;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bz;
import com.tencent.mm.plugin.appbrand.page.bz.a;
import com.tencent.mm.plugin.appbrand.page.cg;
import com.tencent.mm.plugin.appbrand.page.cl;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.d;
import com.tencent.mm.plugin.appbrand.widget.base.e;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends AbsoluteLayout
  implements ak.b, aq, au, bz, cg, d
{
  private final ad enX;
  final e uFk;
  private boolean uFl;
  private int uFm;
  private int uFn;
  private final AbsoluteLayout uwg;
  private final List<bz.a> uwh;
  
  public g(ad paramad)
  {
    super(paramad.getContext().getApplicationContext());
    AppMethodBeat.i(136331);
    this.uwh = new LinkedList();
    super.setId(a.e.app_brand_page_input_container);
    this.enX = paramad;
    this.uwg = this;
    this.uFk = new e(this.uwg);
    AppMethodBeat.o(136331);
  }
  
  private void b(bd parambd)
  {
    AppMethodBeat.i(136334);
    parambd = parambd.getWrapperView();
    if ((this.uwg.getWidth() != parambd.getWidth()) || (this.uwg.getHeight() != parambd.getHeight()))
    {
      ViewGroup.LayoutParams localLayoutParams = this.uwg.getLayoutParams();
      localLayoutParams.width = parambd.getWidth();
      localLayoutParams.height = parambd.getHeight();
      this.uwg.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(136334);
  }
  
  private <Input extends View,  extends af> boolean b(bd parambd, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136333);
    if ((parambd == null) || (parambd.getWrapperView() == null) || (paramInput == null))
    {
      AppMethodBeat.o(136333);
      return false;
    }
    b(parambd);
    parambd = new AbsoluteLayout.LayoutParams(paramInt1, paramInt2, paramInt3, paramInt4);
    this.uwg.addView(paramInput, parambd);
    ((af)paramInput).H(this.enX);
    AppMethodBeat.o(136333);
    return true;
  }
  
  private <Input extends View,  extends af> boolean eb(Input paramInput)
  {
    AppMethodBeat.i(136336);
    if (paramInput == null)
    {
      AppMethodBeat.o(136336);
      return false;
    }
    if (this.uwg == null)
    {
      AppMethodBeat.o(136336);
      return false;
    }
    int i = 0;
    while (i < this.uwg.getChildCount())
    {
      if (paramInput == this.uwg.getChildAt(i))
      {
        AppMethodBeat.o(136336);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(136336);
    return false;
  }
  
  private boolean g(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136347);
    if (this.uwg == null)
    {
      AppMethodBeat.o(136347);
      return false;
    }
    ViewGroup.LayoutParams localLayoutParams = this.uwg.getLayoutParams();
    if (localLayoutParams == null)
    {
      localLayoutParams = new ViewGroup.LayoutParams(paramInt1, paramInt2);
      this.uwg.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(136347);
      return true;
    }
    if ((paramInt1 != localLayoutParams.width) || (paramInt2 != localLayoutParams.height))
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      this.uwg.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(136347);
      return true;
    }
    AppMethodBeat.o(136347);
    return paramBoolean;
  }
  
  public final boolean O(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(136341);
    if ((paramMotionEvent == null) || (paramMotionEvent.getActionMasked() != 0))
    {
      AppMethodBeat.o(136341);
      return false;
    }
    e locale = this.uFk;
    if ((paramMotionEvent == null) || (paramMotionEvent.getActionMasked() != 0) || (locale.uzp == null))
    {
      AppMethodBeat.o(136341);
      return false;
    }
    if ((paramMotionEvent.getDownTime() == locale.uzp.mWR) && (paramMotionEvent.getEventTime() == locale.uzp.rTI))
    {
      AppMethodBeat.o(136341);
      return true;
    }
    AppMethodBeat.o(136341);
    return false;
  }
  
  public final void a(bz.a parama)
  {
    AppMethodBeat.i(136342);
    if (parama == null)
    {
      AppMethodBeat.o(136342);
      return;
    }
    if (this.uwh.contains(parama))
    {
      AppMethodBeat.o(136342);
      return;
    }
    this.uwh.add(parama);
    AppMethodBeat.o(136342);
  }
  
  public final <Input extends View,  extends af> boolean a(bd parambd, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136332);
    boolean bool = b(parambd, paramInput, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(136332);
    return bool;
  }
  
  public final void b(bz.a parama)
  {
    AppMethodBeat.i(136343);
    if (parama == null)
    {
      AppMethodBeat.o(136343);
      return;
    }
    this.uwh.remove(parama);
    AppMethodBeat.o(136343);
  }
  
  public final void c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136346);
    if (g(paramBoolean, paramInt3 - paramInt1, paramInt4 - paramInt2)) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136330);
          g.a(g.this);
          AppMethodBeat.o(136330);
        }
      });
    }
    AppMethodBeat.o(136346);
  }
  
  public final <Input extends View,  extends af> boolean c(bd parambd, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136335);
    if ((parambd == null) || (parambd.getWrapperView() == null) || (paramInput == null))
    {
      AppMethodBeat.o(136335);
      return false;
    }
    if (!eb(paramInput))
    {
      AppMethodBeat.o(136335);
      return false;
    }
    b(parambd);
    if ((paramInput.getLayoutParams() == null) || (!(paramInput.getLayoutParams() instanceof AbsoluteLayout.LayoutParams)))
    {
      AppMethodBeat.o(136335);
      return false;
    }
    if ((paramInput.getWidth() != paramInt1) || (paramInput.getHeight() != paramInt2) || (paramInput.getLeft() != paramInt3) || (paramInput.getTop() != paramInt4))
    {
      parambd = (AbsoluteLayout.LayoutParams)paramInput.getLayoutParams();
      parambd.x = paramInt3;
      parambd.y = paramInt4;
      parambd.width = paramInt1;
      parambd.height = paramInt2;
      paramInput.setLayoutParams(parambd);
    }
    AppMethodBeat.o(136335);
    return true;
  }
  
  public final boolean cPf()
  {
    AppMethodBeat.i(136340);
    if (getChildCount() <= 0)
    {
      AppMethodBeat.o(136340);
      return false;
    }
    int i = 0;
    while (i <= getChildCount())
    {
      if (AppBrandViewMotionCompat.dR(getChildAt(i)))
      {
        AppMethodBeat.o(136340);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(136340);
    return false;
  }
  
  public final <Input extends View,  extends af> void ec(Input paramInput)
  {
    AppMethodBeat.i(136337);
    if (paramInput == null)
    {
      AppMethodBeat.o(136337);
      return;
    }
    paramInput.setVisibility(8);
    Log.v("MicroMsg.AppBrandInputContainer", "clearWebView imm active = %b", new Object[] { Boolean.valueOf(an.ep(this).isActive()) });
    this.uwg.removeView(paramInput);
    ((af)paramInput).I(this.enX);
    AppMethodBeat.o(136337);
  }
  
  public final boolean g(Canvas paramCanvas)
  {
    AppMethodBeat.i(136348);
    paramCanvas.save();
    paramCanvas.translate(-getScrollX(), -getScrollY());
    if (cl.o(this)) {
      cl.a(paramCanvas, this, 0.0F, 0.0F);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(136348);
      return true;
      draw(paramCanvas);
    }
  }
  
  protected final void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136345);
    if (this.uFl) {
      paramView.forceLayout();
    }
    super.measureChild(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(136345);
  }
  
  public final void mn(int paramInt)
  {
    AppMethodBeat.i(136339);
    setTranslationY(paramInt);
    AppMethodBeat.o(136339);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136344);
    if ((isLayoutRequested()) || (paramInt1 != this.uFm) || (paramInt2 != this.uFn)) {}
    for (boolean bool = true;; bool = false)
    {
      this.uFl = bool;
      this.uFm = paramInt1;
      this.uFn = paramInt2;
      super.onMeasure(paramInt1, paramInt2);
      this.uFl = false;
      AppMethodBeat.o(136344);
      return;
    }
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(136338);
    Log.v("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.uwg != null)
    {
      g(false, paramView.getWidth(), paramView.getHeight());
      this.uwg.scrollTo(paramInt1, paramInt2);
    }
    paramView = this.uwh.iterator();
    while (paramView.hasNext()) {
      ((bz.a)paramView.next()).fM(paramInt1, paramInt2);
    }
    AppMethodBeat.o(136338);
  }
  
  public final void setId(int paramInt) {}
  
  public final boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.g
 * JD-Core Version:    0.7.0.1
 */