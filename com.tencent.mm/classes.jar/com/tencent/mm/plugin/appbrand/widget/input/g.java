package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.am.b;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.page.av;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bw;
import com.tencent.mm.plugin.appbrand.page.bw.a;
import com.tencent.mm.plugin.appbrand.page.bz;
import com.tencent.mm.plugin.appbrand.page.cc;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.d;
import com.tencent.mm.plugin.appbrand.widget.base.e;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class g
  extends AbsoluteLayout
  implements am.b, as, av, bw, bz, d
{
  private final aa ceg;
  private final List<bw.a> maH;
  final e maI;
  private final AbsoluteLayout maJ;
  private boolean maK;
  private int maL;
  private int maM;
  
  public g(aa paramaa)
  {
    super(paramaa.getContext());
    AppMethodBeat.i(136331);
    this.maH = new LinkedList();
    super.setId(2131296779);
    this.ceg = paramaa;
    this.maJ = this;
    this.maI = new e(this.maJ);
    AppMethodBeat.o(136331);
  }
  
  private void b(bd parambd)
  {
    AppMethodBeat.i(136334);
    parambd = parambd.getWrapperView();
    if ((this.maJ.getWidth() != parambd.getWidth()) || (this.maJ.getHeight() != parambd.getHeight()))
    {
      ViewGroup.LayoutParams localLayoutParams = this.maJ.getLayoutParams();
      localLayoutParams.width = parambd.getWidth();
      localLayoutParams.height = parambd.getHeight();
      this.maJ.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(136334);
  }
  
  private <Input extends View,  extends ab> boolean b(bd parambd, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136333);
    if ((parambd == null) || (parambd.getWrapperView() == null) || (paramInput == null))
    {
      AppMethodBeat.o(136333);
      return false;
    }
    b(parambd);
    parambd = new AbsoluteLayout.LayoutParams(paramInt1, paramInt2, paramInt3, paramInt4);
    this.maJ.addView(paramInput, parambd);
    ((ab)paramInput).A(this.ceg);
    AppMethodBeat.o(136333);
    return true;
  }
  
  private <Input extends View,  extends ab> boolean cX(Input paramInput)
  {
    AppMethodBeat.i(136336);
    if (paramInput == null)
    {
      AppMethodBeat.o(136336);
      return false;
    }
    if (this.maJ == null)
    {
      AppMethodBeat.o(136336);
      return false;
    }
    int i = 0;
    while (i < this.maJ.getChildCount())
    {
      if (paramInput == this.maJ.getChildAt(i))
      {
        AppMethodBeat.o(136336);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(136336);
    return false;
  }
  
  private boolean d(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136347);
    if (this.maJ == null)
    {
      AppMethodBeat.o(136347);
      return false;
    }
    ViewGroup.LayoutParams localLayoutParams = this.maJ.getLayoutParams();
    if (localLayoutParams == null)
    {
      localLayoutParams = new ViewGroup.LayoutParams(paramInt1, paramInt2);
      this.maJ.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(136347);
      return true;
    }
    if ((paramInt1 != localLayoutParams.width) || (paramInt2 != localLayoutParams.height))
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      this.maJ.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(136347);
      return true;
    }
    AppMethodBeat.o(136347);
    return paramBoolean;
  }
  
  public final boolean N(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(136341);
    if ((paramMotionEvent == null) || (paramMotionEvent.getActionMasked() != 0))
    {
      AppMethodBeat.o(136341);
      return false;
    }
    e locale = this.maI;
    if ((paramMotionEvent == null) || (paramMotionEvent.getActionMasked() != 0) || (locale.lRI == null))
    {
      AppMethodBeat.o(136341);
      return false;
    }
    if ((paramMotionEvent.getDownTime() == locale.lRI.jPo) && (paramMotionEvent.getEventTime() == locale.lRI.jPn))
    {
      AppMethodBeat.o(136341);
      return true;
    }
    AppMethodBeat.o(136341);
    return false;
  }
  
  public final void a(bw.a parama)
  {
    AppMethodBeat.i(136342);
    if (parama == null)
    {
      AppMethodBeat.o(136342);
      return;
    }
    if (this.maH.contains(parama))
    {
      AppMethodBeat.o(136342);
      return;
    }
    this.maH.add(parama);
    AppMethodBeat.o(136342);
  }
  
  public final <Input extends View,  extends ab> boolean a(bd parambd, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136332);
    boolean bool = b(parambd, paramInput, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(136332);
    return bool;
  }
  
  public final void b(bw.a parama)
  {
    AppMethodBeat.i(136343);
    if (parama == null)
    {
      AppMethodBeat.o(136343);
      return;
    }
    this.maH.remove(parama);
    AppMethodBeat.o(136343);
  }
  
  public final boolean brm()
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
      if (AppBrandViewMotionCompat.cR(getChildAt(i)))
      {
        AppMethodBeat.o(136340);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(136340);
    return false;
  }
  
  public final boolean c(Canvas paramCanvas)
  {
    AppMethodBeat.i(136348);
    paramCanvas.save();
    paramCanvas.translate(-getScrollX(), -getScrollY());
    if (cc.k(this)) {
      cc.a(paramCanvas, this, 0.0F, 0.0F);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(136348);
      return true;
      f.a(paramCanvas, this);
    }
  }
  
  public final <Input extends View,  extends ab> boolean c(bd parambd, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136335);
    if ((parambd == null) || (parambd.getWrapperView() == null) || (paramInput == null))
    {
      AppMethodBeat.o(136335);
      return false;
    }
    if (!cX(paramInput))
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
  
  public final <Input extends View,  extends ab> void cY(Input paramInput)
  {
    AppMethodBeat.i(136337);
    if (paramInput == null)
    {
      AppMethodBeat.o(136337);
      return;
    }
    paramInput.setVisibility(8);
    ad.v("MicroMsg.AppBrandInputContainer", "clearWebView imm active = %b", new Object[] { Boolean.valueOf(aj.dl(this).isActive()) });
    this.maJ.removeView(paramInput);
    ((ab)paramInput).B(this.ceg);
    AppMethodBeat.o(136337);
  }
  
  public final void d(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136346);
    if (d(paramBoolean, paramInt3 - paramInt1, paramInt4 - paramInt2)) {
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
  
  public final void gJ(int paramInt)
  {
    AppMethodBeat.i(136339);
    setTranslationY(paramInt);
    AppMethodBeat.o(136339);
  }
  
  protected final void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136345);
    if (this.maK) {
      paramView.forceLayout();
    }
    super.measureChild(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(136345);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136344);
    if ((isLayoutRequested()) || (paramInt1 != this.maL) || (paramInt2 != this.maM)) {}
    for (boolean bool = true;; bool = false)
    {
      this.maK = bool;
      this.maL = paramInt1;
      this.maM = paramInt2;
      super.onMeasure(paramInt1, paramInt2);
      this.maK = false;
      AppMethodBeat.o(136344);
      return;
    }
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(136338);
    ad.v("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.maJ != null)
    {
      d(false, paramView.getWidth(), paramView.getHeight());
      this.maJ.scrollTo(paramInt1, paramInt2);
    }
    paramView = this.maH.iterator();
    while (paramView.hasNext()) {
      ((bw.a)paramView.next()).ed(paramInt1, paramInt2);
    }
    AppMethodBeat.o(136338);
  }
  
  public final void setId(int paramInt) {}
  
  public final boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.g
 * JD-Core Version:    0.7.0.1
 */