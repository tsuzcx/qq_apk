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
import com.tencent.mm.plugin.appbrand.page.ag.b;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.bp;
import com.tencent.mm.plugin.appbrand.page.bp.a;
import com.tencent.mm.plugin.appbrand.page.bt;
import com.tencent.mm.plugin.appbrand.page.bw;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.d;
import com.tencent.mm.plugin.appbrand.widget.base.e;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class g
  extends AbsoluteLayout
  implements ag.b, am, ap, bp, bt, d
{
  private final z clw;
  private final AbsoluteLayout mWT;
  private final List<bp.a> mWU;
  final e nio;
  private boolean nip;
  private int niq;
  private int nir;
  
  public g(z paramz)
  {
    super(paramz.getContext());
    AppMethodBeat.i(136331);
    this.mWU = new LinkedList();
    super.setId(2131296779);
    this.clw = paramz;
    this.mWT = this;
    this.nio = new e(this.mWT);
    AppMethodBeat.o(136331);
  }
  
  private void b(ax paramax)
  {
    AppMethodBeat.i(136334);
    paramax = paramax.getWrapperView();
    if ((this.mWT.getWidth() != paramax.getWidth()) || (this.mWT.getHeight() != paramax.getHeight()))
    {
      ViewGroup.LayoutParams localLayoutParams = this.mWT.getLayoutParams();
      localLayoutParams.width = paramax.getWidth();
      localLayoutParams.height = paramax.getHeight();
      this.mWT.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(136334);
  }
  
  private <Input extends View,  extends ab> boolean b(ax paramax, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136333);
    if ((paramax == null) || (paramax.getWrapperView() == null) || (paramInput == null))
    {
      AppMethodBeat.o(136333);
      return false;
    }
    b(paramax);
    paramax = new AbsoluteLayout.LayoutParams(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWT.addView(paramInput, paramax);
    ((ab)paramInput).B(this.clw);
    AppMethodBeat.o(136333);
    return true;
  }
  
  private <Input extends View,  extends ab> boolean db(Input paramInput)
  {
    AppMethodBeat.i(136336);
    if (paramInput == null)
    {
      AppMethodBeat.o(136336);
      return false;
    }
    if (this.mWT == null)
    {
      AppMethodBeat.o(136336);
      return false;
    }
    int i = 0;
    while (i < this.mWT.getChildCount())
    {
      if (paramInput == this.mWT.getChildAt(i))
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
    if (this.mWT == null)
    {
      AppMethodBeat.o(136347);
      return false;
    }
    ViewGroup.LayoutParams localLayoutParams = this.mWT.getLayoutParams();
    if (localLayoutParams == null)
    {
      localLayoutParams = new ViewGroup.LayoutParams(paramInt1, paramInt2);
      this.mWT.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(136347);
      return true;
    }
    if ((paramInt1 != localLayoutParams.width) || (paramInt2 != localLayoutParams.height))
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      this.mWT.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(136347);
      return true;
    }
    AppMethodBeat.o(136347);
    return paramBoolean;
  }
  
  public final boolean H(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(136341);
    if ((paramMotionEvent == null) || (paramMotionEvent.getActionMasked() != 0))
    {
      AppMethodBeat.o(136341);
      return false;
    }
    e locale = this.nio;
    if ((paramMotionEvent == null) || (paramMotionEvent.getActionMasked() != 0) || (locale.mZx == null))
    {
      AppMethodBeat.o(136341);
      return false;
    }
    if ((paramMotionEvent.getDownTime() == locale.mZx.gOH) && (paramMotionEvent.getEventTime() == locale.mZx.kOp))
    {
      AppMethodBeat.o(136341);
      return true;
    }
    AppMethodBeat.o(136341);
    return false;
  }
  
  public final void a(bp.a parama)
  {
    AppMethodBeat.i(136342);
    if (parama == null)
    {
      AppMethodBeat.o(136342);
      return;
    }
    if (this.mWU.contains(parama))
    {
      AppMethodBeat.o(136342);
      return;
    }
    this.mWU.add(parama);
    AppMethodBeat.o(136342);
  }
  
  public final <Input extends View,  extends ab> boolean a(ax paramax, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136332);
    boolean bool = b(paramax, paramInput, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(136332);
    return bool;
  }
  
  public final void b(bp.a parama)
  {
    AppMethodBeat.i(136343);
    if (parama == null)
    {
      AppMethodBeat.o(136343);
      return;
    }
    this.mWU.remove(parama);
    AppMethodBeat.o(136343);
  }
  
  public final boolean bDj()
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
      if (AppBrandViewMotionCompat.cV(getChildAt(i)))
      {
        AppMethodBeat.o(136340);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(136340);
    return false;
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
    if (bw.k(this)) {
      bw.a(paramCanvas, this, 0.0F, 0.0F);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(136348);
      return true;
      h.a(paramCanvas, this);
    }
  }
  
  public final <Input extends View,  extends ab> boolean c(ax paramax, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136335);
    if ((paramax == null) || (paramax.getWrapperView() == null) || (paramInput == null))
    {
      AppMethodBeat.o(136335);
      return false;
    }
    if (!db(paramInput))
    {
      AppMethodBeat.o(136335);
      return false;
    }
    b(paramax);
    if ((paramInput.getLayoutParams() == null) || (!(paramInput.getLayoutParams() instanceof AbsoluteLayout.LayoutParams)))
    {
      AppMethodBeat.o(136335);
      return false;
    }
    if ((paramInput.getWidth() != paramInt1) || (paramInput.getHeight() != paramInt2) || (paramInput.getLeft() != paramInt3) || (paramInput.getTop() != paramInt4))
    {
      paramax = (AbsoluteLayout.LayoutParams)paramInput.getLayoutParams();
      paramax.x = paramInt3;
      paramax.y = paramInt4;
      paramax.width = paramInt1;
      paramax.height = paramInt2;
      paramInput.setLayoutParams(paramax);
    }
    AppMethodBeat.o(136335);
    return true;
  }
  
  public final <Input extends View,  extends ab> void dc(Input paramInput)
  {
    AppMethodBeat.i(136337);
    if (paramInput == null)
    {
      AppMethodBeat.o(136337);
      return;
    }
    paramInput.setVisibility(8);
    ae.v("MicroMsg.AppBrandInputContainer", "clearWebView imm active = %b", new Object[] { Boolean.valueOf(aj.dp(this).isActive()) });
    this.mWT.removeView(paramInput);
    ((ab)paramInput).C(this.clw);
    AppMethodBeat.o(136337);
  }
  
  public final void gw(int paramInt)
  {
    AppMethodBeat.i(136339);
    setTranslationY(paramInt);
    AppMethodBeat.o(136339);
  }
  
  protected final void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136345);
    if (this.nip) {
      paramView.forceLayout();
    }
    super.measureChild(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(136345);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136344);
    if ((isLayoutRequested()) || (paramInt1 != this.niq) || (paramInt2 != this.nir)) {}
    for (boolean bool = true;; bool = false)
    {
      this.nip = bool;
      this.niq = paramInt1;
      this.nir = paramInt2;
      super.onMeasure(paramInt1, paramInt2);
      this.nip = false;
      AppMethodBeat.o(136344);
      return;
    }
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(136338);
    ae.v("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.mWT != null)
    {
      e(false, paramView.getWidth(), paramView.getHeight());
      this.mWT.scrollTo(paramInt1, paramInt2);
    }
    paramView = this.mWU.iterator();
    while (paramView.hasNext()) {
      ((bp.a)paramView.next()).eg(paramInt1, paramInt2);
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