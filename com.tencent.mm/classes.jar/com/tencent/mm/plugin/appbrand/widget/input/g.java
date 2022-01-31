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
import com.tencent.mm.plugin.appbrand.page.ab.b;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bd.a;
import com.tencent.mm.plugin.appbrand.page.bg;
import com.tencent.mm.plugin.appbrand.page.bj;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.e;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class g
  extends AbsoluteLayout
  implements ab.b, ag, com.tencent.mm.plugin.appbrand.page.aj, bd, bg, com.tencent.mm.plugin.appbrand.widget.base.d
{
  private final v bCk;
  private final List<bd.a> jkR;
  final e jkS;
  private final AbsoluteLayout jkT;
  private boolean jkU;
  private int jkV;
  private int jkW;
  
  public g(v paramv)
  {
    super(paramv.getContext());
    AppMethodBeat.i(123600);
    this.jkR = new LinkedList();
    super.setId(2131820568);
    this.bCk = paramv;
    this.jkT = this;
    this.jkS = new e(this.jkT);
    AppMethodBeat.o(123600);
  }
  
  private void a(ap paramap)
  {
    AppMethodBeat.i(123603);
    paramap = paramap.getWrapperView();
    if ((this.jkT.getWidth() != paramap.getWidth()) || (this.jkT.getHeight() != paramap.getHeight()))
    {
      ViewGroup.LayoutParams localLayoutParams = this.jkT.getLayoutParams();
      localLayoutParams.width = paramap.getWidth();
      localLayoutParams.height = paramap.getHeight();
      this.jkT.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(123603);
  }
  
  private <Input extends View,  extends ab> boolean b(ap paramap, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(123602);
    if ((paramap == null) || (paramap.getWrapperView() == null) || (paramInput == null))
    {
      AppMethodBeat.o(123602);
      return false;
    }
    a(paramap);
    paramap = new AbsoluteLayout.LayoutParams(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jkT.addView(paramInput, paramap);
    ((ab)paramInput).t(this.bCk);
    AppMethodBeat.o(123602);
    return true;
  }
  
  private <Input extends View,  extends ab> boolean cH(Input paramInput)
  {
    AppMethodBeat.i(123605);
    if (paramInput == null)
    {
      AppMethodBeat.o(123605);
      return false;
    }
    if (this.jkT == null)
    {
      AppMethodBeat.o(123605);
      return false;
    }
    int i = 0;
    while (i < this.jkT.getChildCount())
    {
      if (paramInput == this.jkT.getChildAt(i))
      {
        AppMethodBeat.o(123605);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(123605);
    return false;
  }
  
  private boolean d(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123616);
    if (this.jkT == null)
    {
      AppMethodBeat.o(123616);
      return false;
    }
    ViewGroup.LayoutParams localLayoutParams = this.jkT.getLayoutParams();
    if (localLayoutParams == null)
    {
      localLayoutParams = new ViewGroup.LayoutParams(paramInt1, paramInt2);
      this.jkT.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(123616);
      return true;
    }
    if ((paramInt1 != localLayoutParams.width) || (paramInt2 != localLayoutParams.height))
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      this.jkT.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(123616);
      return true;
    }
    AppMethodBeat.o(123616);
    return paramBoolean;
  }
  
  public final boolean I(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(123610);
    if ((paramMotionEvent == null) || (paramMotionEvent.getActionMasked() != 0))
    {
      AppMethodBeat.o(123610);
      return false;
    }
    e locale = this.jkS;
    if ((paramMotionEvent == null) || (paramMotionEvent.getActionMasked() != 0) || (locale.jbO == null))
    {
      AppMethodBeat.o(123610);
      return false;
    }
    if ((paramMotionEvent.getDownTime() == locale.jbO.hLi) && (paramMotionEvent.getEventTime() == locale.jbO.hLh))
    {
      AppMethodBeat.o(123610);
      return true;
    }
    AppMethodBeat.o(123610);
    return false;
  }
  
  public final void a(bd.a parama)
  {
    AppMethodBeat.i(123611);
    if (parama == null)
    {
      AppMethodBeat.o(123611);
      return;
    }
    if (this.jkR.contains(parama))
    {
      AppMethodBeat.o(123611);
      return;
    }
    this.jkR.add(parama);
    AppMethodBeat.o(123611);
  }
  
  public final boolean a(Canvas paramCanvas)
  {
    AppMethodBeat.i(123617);
    paramCanvas.save();
    paramCanvas.translate(-getScrollX(), -getScrollY());
    if (bj.i(this)) {
      bj.a(paramCanvas, this, 0.0F, 0.0F);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(123617);
      return true;
      com.tencent.mm.sdk.platformtools.d.a(paramCanvas, this);
    }
  }
  
  public final <Input extends View,  extends ab> boolean a(ap paramap, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(123601);
    boolean bool = b(paramap, paramInput, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(123601);
    return bool;
  }
  
  public final boolean aOP()
  {
    AppMethodBeat.i(123609);
    if (getChildCount() <= 0)
    {
      AppMethodBeat.o(123609);
      return false;
    }
    int i = 0;
    while (i <= getChildCount())
    {
      if (AppBrandViewMotionCompat.cF(getChildAt(i)))
      {
        AppMethodBeat.o(123609);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(123609);
    return false;
  }
  
  public final void b(bd.a parama)
  {
    AppMethodBeat.i(123612);
    if (parama == null)
    {
      AppMethodBeat.o(123612);
      return;
    }
    this.jkR.remove(parama);
    AppMethodBeat.o(123612);
  }
  
  public final void c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(123615);
    if (d(paramBoolean, paramInt3 - paramInt1, paramInt4 - paramInt2)) {
      post(new g.1(this));
    }
    AppMethodBeat.o(123615);
  }
  
  public final <Input extends View,  extends ab> boolean c(ap paramap, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(123604);
    if ((paramap == null) || (paramap.getWrapperView() == null) || (paramInput == null))
    {
      AppMethodBeat.o(123604);
      return false;
    }
    if (!cH(paramInput))
    {
      AppMethodBeat.o(123604);
      return false;
    }
    a(paramap);
    if ((paramInput.getLayoutParams() == null) || (!(paramInput.getLayoutParams() instanceof AbsoluteLayout.LayoutParams)))
    {
      AppMethodBeat.o(123604);
      return false;
    }
    if ((paramInput.getWidth() != paramInt1) || (paramInput.getHeight() != paramInt2) || (paramInput.getLeft() != paramInt3) || (paramInput.getTop() != paramInt4))
    {
      paramap = (AbsoluteLayout.LayoutParams)paramInput.getLayoutParams();
      paramap.x = paramInt3;
      paramap.y = paramInt4;
      paramap.width = paramInt1;
      paramap.height = paramInt2;
      paramInput.setLayoutParams(paramap);
    }
    AppMethodBeat.o(123604);
    return true;
  }
  
  public final <Input extends View,  extends ab> void cI(Input paramInput)
  {
    AppMethodBeat.i(123606);
    if (paramInput == null)
    {
      AppMethodBeat.o(123606);
      return;
    }
    paramInput.setVisibility(8);
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrandInputContainer", "clearWebView imm active = %b", new Object[] { Boolean.valueOf(aj.cV(this).isActive()) });
    this.jkT.removeView(paramInput);
    ((ab)paramInput).u(this.bCk);
    AppMethodBeat.o(123606);
  }
  
  public final void fr(int paramInt)
  {
    AppMethodBeat.i(123608);
    setTranslationY(paramInt);
    AppMethodBeat.o(123608);
  }
  
  protected final void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123614);
    if (this.jkU) {
      paramView.forceLayout();
    }
    super.measureChild(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(123614);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123613);
    if ((isLayoutRequested()) || (paramInt1 != this.jkV) || (paramInt2 != this.jkW)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jkU = bool;
      this.jkV = paramInt1;
      this.jkW = paramInt2;
      super.onMeasure(paramInt1, paramInt2);
      this.jkU = false;
      AppMethodBeat.o(123613);
      return;
    }
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(123607);
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.jkT != null)
    {
      d(false, paramView.getWidth(), paramView.getHeight());
      this.jkT.scrollTo(paramInt1, paramInt2);
    }
    paramView = this.jkR.iterator();
    while (paramView.hasNext()) {
      ((bd.a)paramView.next()).dn(paramInt1, paramInt2);
    }
    AppMethodBeat.o(123607);
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