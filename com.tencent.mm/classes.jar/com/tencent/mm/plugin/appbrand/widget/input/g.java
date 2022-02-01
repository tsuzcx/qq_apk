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
import com.tencent.mm.plugin.appbrand.page.ah.b;
import com.tencent.mm.plugin.appbrand.page.an;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.page.br;
import com.tencent.mm.plugin.appbrand.page.br.a;
import com.tencent.mm.plugin.appbrand.page.bu;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.d;
import com.tencent.mm.plugin.appbrand.widget.base.e;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class g
  extends AbsoluteLayout
  implements ah.b, an, aq, br, bu, d
{
  private final aa cbd;
  final e mCF;
  private boolean mCG;
  private int mCH;
  private int mCI;
  private final AbsoluteLayout mre;
  private final List<br.a> mrf;
  
  public g(aa paramaa)
  {
    super(paramaa.getContext());
    AppMethodBeat.i(136331);
    this.mrf = new LinkedList();
    super.setId(2131296779);
    this.cbd = paramaa;
    this.mre = this;
    this.mCF = new e(this.mre);
    AppMethodBeat.o(136331);
  }
  
  private void b(ay paramay)
  {
    AppMethodBeat.i(136334);
    paramay = paramay.getWrapperView();
    if ((this.mre.getWidth() != paramay.getWidth()) || (this.mre.getHeight() != paramay.getHeight()))
    {
      ViewGroup.LayoutParams localLayoutParams = this.mre.getLayoutParams();
      localLayoutParams.width = paramay.getWidth();
      localLayoutParams.height = paramay.getHeight();
      this.mre.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(136334);
  }
  
  private <Input extends View,  extends ab> boolean b(ay paramay, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136333);
    if ((paramay == null) || (paramay.getWrapperView() == null) || (paramInput == null))
    {
      AppMethodBeat.o(136333);
      return false;
    }
    b(paramay);
    paramay = new AbsoluteLayout.LayoutParams(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mre.addView(paramInput, paramay);
    ((ab)paramInput).A(this.cbd);
    AppMethodBeat.o(136333);
    return true;
  }
  
  private <Input extends View,  extends ab> boolean cZ(Input paramInput)
  {
    AppMethodBeat.i(136336);
    if (paramInput == null)
    {
      AppMethodBeat.o(136336);
      return false;
    }
    if (this.mre == null)
    {
      AppMethodBeat.o(136336);
      return false;
    }
    int i = 0;
    while (i < this.mre.getChildCount())
    {
      if (paramInput == this.mre.getChildAt(i))
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
    if (this.mre == null)
    {
      AppMethodBeat.o(136347);
      return false;
    }
    ViewGroup.LayoutParams localLayoutParams = this.mre.getLayoutParams();
    if (localLayoutParams == null)
    {
      localLayoutParams = new ViewGroup.LayoutParams(paramInt1, paramInt2);
      this.mre.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(136347);
      return true;
    }
    if ((paramInt1 != localLayoutParams.width) || (paramInt2 != localLayoutParams.height))
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      this.mre.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(136347);
      return true;
    }
    AppMethodBeat.o(136347);
    return paramBoolean;
  }
  
  public final boolean L(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(136341);
    if ((paramMotionEvent == null) || (paramMotionEvent.getActionMasked() != 0))
    {
      AppMethodBeat.o(136341);
      return false;
    }
    e locale = this.mCF;
    if ((paramMotionEvent == null) || (paramMotionEvent.getActionMasked() != 0) || (locale.mtK == null))
    {
      AppMethodBeat.o(136341);
      return false;
    }
    if ((paramMotionEvent.getDownTime() == locale.mtK.gsq) && (paramMotionEvent.getEventTime() == locale.mtK.kpY))
    {
      AppMethodBeat.o(136341);
      return true;
    }
    AppMethodBeat.o(136341);
    return false;
  }
  
  public final void a(br.a parama)
  {
    AppMethodBeat.i(136342);
    if (parama == null)
    {
      AppMethodBeat.o(136342);
      return;
    }
    if (this.mrf.contains(parama))
    {
      AppMethodBeat.o(136342);
      return;
    }
    this.mrf.add(parama);
    AppMethodBeat.o(136342);
  }
  
  public final <Input extends View,  extends ab> boolean a(ay paramay, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136332);
    boolean bool = b(paramay, paramInput, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(136332);
    return bool;
  }
  
  public final void b(br.a parama)
  {
    AppMethodBeat.i(136343);
    if (parama == null)
    {
      AppMethodBeat.o(136343);
      return;
    }
    this.mrf.remove(parama);
    AppMethodBeat.o(136343);
  }
  
  public final boolean bym()
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
      if (AppBrandViewMotionCompat.cT(getChildAt(i)))
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
    if (bx.k(this)) {
      bx.a(paramCanvas, this, 0.0F, 0.0F);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(136348);
      return true;
      f.a(paramCanvas, this);
    }
  }
  
  public final <Input extends View,  extends ab> boolean c(ay paramay, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136335);
    if ((paramay == null) || (paramay.getWrapperView() == null) || (paramInput == null))
    {
      AppMethodBeat.o(136335);
      return false;
    }
    if (!cZ(paramInput))
    {
      AppMethodBeat.o(136335);
      return false;
    }
    b(paramay);
    if ((paramInput.getLayoutParams() == null) || (!(paramInput.getLayoutParams() instanceof AbsoluteLayout.LayoutParams)))
    {
      AppMethodBeat.o(136335);
      return false;
    }
    if ((paramInput.getWidth() != paramInt1) || (paramInput.getHeight() != paramInt2) || (paramInput.getLeft() != paramInt3) || (paramInput.getTop() != paramInt4))
    {
      paramay = (AbsoluteLayout.LayoutParams)paramInput.getLayoutParams();
      paramay.x = paramInt3;
      paramay.y = paramInt4;
      paramay.width = paramInt1;
      paramay.height = paramInt2;
      paramInput.setLayoutParams(paramay);
    }
    AppMethodBeat.o(136335);
    return true;
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
  
  public final <Input extends View,  extends ab> void da(Input paramInput)
  {
    AppMethodBeat.i(136337);
    if (paramInput == null)
    {
      AppMethodBeat.o(136337);
      return;
    }
    paramInput.setVisibility(8);
    ac.v("MicroMsg.AppBrandInputContainer", "clearWebView imm active = %b", new Object[] { Boolean.valueOf(aj.dn(this).isActive()) });
    this.mre.removeView(paramInput);
    ((ab)paramInput).B(this.cbd);
    AppMethodBeat.o(136337);
  }
  
  public final void gt(int paramInt)
  {
    AppMethodBeat.i(136339);
    setTranslationY(paramInt);
    AppMethodBeat.o(136339);
  }
  
  protected final void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136345);
    if (this.mCG) {
      paramView.forceLayout();
    }
    super.measureChild(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(136345);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136344);
    if ((isLayoutRequested()) || (paramInt1 != this.mCH) || (paramInt2 != this.mCI)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mCG = bool;
      this.mCH = paramInt1;
      this.mCI = paramInt2;
      super.onMeasure(paramInt1, paramInt2);
      this.mCG = false;
      AppMethodBeat.o(136344);
      return;
    }
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(136338);
    ac.v("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.mre != null)
    {
      d(false, paramView.getWidth(), paramView.getHeight());
      this.mre.scrollTo(paramInt1, paramInt2);
    }
    paramView = this.mrf.iterator();
    while (paramView.hasNext()) {
      ((br.a)paramView.next()).ee(paramInt1, paramInt2);
    }
    AppMethodBeat.o(136338);
  }
  
  public final void setId(int paramInt) {}
  
  public final boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.g
 * JD-Core Version:    0.7.0.1
 */