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
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.aj.b;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bv;
import com.tencent.mm.plugin.appbrand.page.bv.a;
import com.tencent.mm.plugin.appbrand.page.bz;
import com.tencent.mm.plugin.appbrand.page.cc;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.d;
import com.tencent.mm.plugin.appbrand.widget.base.e;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class g
  extends AbsoluteLayout
  implements aj.b, ap, as, bv, bz, d
{
  private final ac cxr;
  private final AbsoluteLayout ojW;
  private final List<bv.a> ojX;
  final e orW;
  private boolean orX;
  private int orY;
  private int orZ;
  
  public g(ac paramac)
  {
    super(paramac.getContext());
    AppMethodBeat.i(136331);
    this.ojX = new LinkedList();
    super.setId(2131296861);
    this.cxr = paramac;
    this.ojW = this;
    this.orW = new e(this.ojW);
    AppMethodBeat.o(136331);
  }
  
  private void b(bb parambb)
  {
    AppMethodBeat.i(136334);
    parambb = parambb.getWrapperView();
    if ((this.ojW.getWidth() != parambb.getWidth()) || (this.ojW.getHeight() != parambb.getHeight()))
    {
      ViewGroup.LayoutParams localLayoutParams = this.ojW.getLayoutParams();
      localLayoutParams.width = parambb.getWidth();
      localLayoutParams.height = parambb.getHeight();
      this.ojW.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(136334);
  }
  
  private <Input extends View,  extends ab> boolean b(bb parambb, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136333);
    if ((parambb == null) || (parambb.getWrapperView() == null) || (paramInput == null))
    {
      AppMethodBeat.o(136333);
      return false;
    }
    b(parambb);
    parambb = new AbsoluteLayout.LayoutParams(paramInt1, paramInt2, paramInt3, paramInt4);
    this.ojW.addView(paramInput, parambb);
    ((ab)paramInput).G(this.cxr);
    AppMethodBeat.o(136333);
    return true;
  }
  
  private <Input extends View,  extends ab> boolean cU(Input paramInput)
  {
    AppMethodBeat.i(136336);
    if (paramInput == null)
    {
      AppMethodBeat.o(136336);
      return false;
    }
    if (this.ojW == null)
    {
      AppMethodBeat.o(136336);
      return false;
    }
    int i = 0;
    while (i < this.ojW.getChildCount())
    {
      if (paramInput == this.ojW.getChildAt(i))
      {
        AppMethodBeat.o(136336);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(136336);
    return false;
  }
  
  private boolean e(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136347);
    if (this.ojW == null)
    {
      AppMethodBeat.o(136347);
      return false;
    }
    ViewGroup.LayoutParams localLayoutParams = this.ojW.getLayoutParams();
    if (localLayoutParams == null)
    {
      localLayoutParams = new ViewGroup.LayoutParams(paramInt1, paramInt2);
      this.ojW.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(136347);
      return true;
    }
    if ((paramInt1 != localLayoutParams.width) || (paramInt2 != localLayoutParams.height))
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      this.ojW.setLayoutParams(localLayoutParams);
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
    e locale = this.orW;
    if ((paramMotionEvent == null) || (paramMotionEvent.getActionMasked() != 0) || (locale.omC == null))
    {
      AppMethodBeat.o(136341);
      return false;
    }
    if ((paramMotionEvent.getDownTime() == locale.omC.hET) && (paramMotionEvent.getEventTime() == locale.omC.lTl))
    {
      AppMethodBeat.o(136341);
      return true;
    }
    AppMethodBeat.o(136341);
    return false;
  }
  
  public final void a(bv.a parama)
  {
    AppMethodBeat.i(136342);
    if (parama == null)
    {
      AppMethodBeat.o(136342);
      return;
    }
    if (this.ojX.contains(parama))
    {
      AppMethodBeat.o(136342);
      return;
    }
    this.ojX.add(parama);
    AppMethodBeat.o(136342);
  }
  
  public final <Input extends View,  extends ab> boolean a(bb parambb, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136332);
    boolean bool = b(parambb, paramInput, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(136332);
    return bool;
  }
  
  public final void b(bv.a parama)
  {
    AppMethodBeat.i(136343);
    if (parama == null)
    {
      AppMethodBeat.o(136343);
      return;
    }
    this.ojX.remove(parama);
    AppMethodBeat.o(136343);
  }
  
  public final void c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136346);
    if (e(paramBoolean, paramInt3 - paramInt1, paramInt4 - paramInt2)) {
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
      draw(paramCanvas);
    }
  }
  
  public final <Input extends View,  extends ab> boolean c(bb parambb, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136335);
    if ((parambb == null) || (parambb.getWrapperView() == null) || (paramInput == null))
    {
      AppMethodBeat.o(136335);
      return false;
    }
    if (!cU(paramInput))
    {
      AppMethodBeat.o(136335);
      return false;
    }
    b(parambb);
    if ((paramInput.getLayoutParams() == null) || (!(paramInput.getLayoutParams() instanceof AbsoluteLayout.LayoutParams)))
    {
      AppMethodBeat.o(136335);
      return false;
    }
    if ((paramInput.getWidth() != paramInt1) || (paramInput.getHeight() != paramInt2) || (paramInput.getLeft() != paramInt3) || (paramInput.getTop() != paramInt4))
    {
      parambb = (AbsoluteLayout.LayoutParams)paramInput.getLayoutParams();
      parambb.x = paramInt3;
      parambb.y = paramInt4;
      parambb.width = paramInt1;
      parambb.height = paramInt2;
      paramInput.setLayoutParams(parambb);
    }
    AppMethodBeat.o(136335);
    return true;
  }
  
  public final <Input extends View,  extends ab> void cV(Input paramInput)
  {
    AppMethodBeat.i(136337);
    if (paramInput == null)
    {
      AppMethodBeat.o(136337);
      return;
    }
    paramInput.setVisibility(8);
    Log.v("MicroMsg.AppBrandInputContainer", "clearWebView imm active = %b", new Object[] { Boolean.valueOf(aj.dg(this).isActive()) });
    this.ojW.removeView(paramInput);
    ((ab)paramInput).H(this.cxr);
    AppMethodBeat.o(136337);
  }
  
  public final boolean caj()
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
      if (AppBrandViewMotionCompat.cM(getChildAt(i)))
      {
        AppMethodBeat.o(136340);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(136340);
    return false;
  }
  
  public final void hK(int paramInt)
  {
    AppMethodBeat.i(136339);
    setTranslationY(paramInt);
    AppMethodBeat.o(136339);
  }
  
  protected final void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136345);
    if (this.orX) {
      paramView.forceLayout();
    }
    super.measureChild(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(136345);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136344);
    if ((isLayoutRequested()) || (paramInt1 != this.orY) || (paramInt2 != this.orZ)) {}
    for (boolean bool = true;; bool = false)
    {
      this.orX = bool;
      this.orY = paramInt1;
      this.orZ = paramInt2;
      super.onMeasure(paramInt1, paramInt2);
      this.orX = false;
      AppMethodBeat.o(136344);
      return;
    }
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(136338);
    Log.v("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.ojW != null)
    {
      e(false, paramView.getWidth(), paramView.getHeight());
      this.ojW.scrollTo(paramInt1, paramInt2);
    }
    paramView = this.ojX.iterator();
    while (paramView.hasNext()) {
      ((bv.a)paramView.next()).eu(paramInt1, paramInt2);
    }
    AppMethodBeat.o(136338);
  }
  
  public final void setId(int paramInt) {}
  
  public final boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.g
 * JD-Core Version:    0.7.0.1
 */