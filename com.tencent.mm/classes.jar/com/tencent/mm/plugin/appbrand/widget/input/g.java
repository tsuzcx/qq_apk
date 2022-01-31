package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import com.tencent.luggage.l.a.a.d;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.ak;
import com.tencent.mm.plugin.appbrand.page.ak.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.u.b;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.d;
import com.tencent.mm.plugin.appbrand.widget.base.e;
import com.tencent.mm.plugin.appbrand.widget.base.e.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class g
  extends AbsoluteLayout
  implements ab, ak, u.b, z, d
{
  private final q gkh;
  private final List<ak.a> htm = new LinkedList();
  final e htn;
  private final AbsoluteLayout hto;
  
  public g(q paramq)
  {
    super(paramq.mContext);
    super.setId(a.d.app_brand_page_input_container);
    this.gkh = paramq;
    this.hto = this;
    this.htn = new e(this.hto);
  }
  
  private boolean cj(int paramInt1, int paramInt2)
  {
    if (this.hto == null) {
      return false;
    }
    ViewGroup.LayoutParams localLayoutParams2 = this.hto.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null)
    {
      localLayoutParams1 = new ViewGroup.LayoutParams(paramInt1, paramInt2);
      this.hto.setLayoutParams(localLayoutParams1);
    }
    if ((paramInt1 != localLayoutParams1.width) || (paramInt2 != localLayoutParams1.height))
    {
      localLayoutParams1.width = paramInt1;
      localLayoutParams1.height = paramInt2;
      this.hto.setLayoutParams(localLayoutParams1);
    }
    return true;
  }
  
  private void d(af paramaf)
  {
    paramaf = paramaf.getWrapperView();
    if ((this.hto.getWidth() != paramaf.getWidth()) || (this.hto.getHeight() != paramaf.getHeight()))
    {
      ViewGroup.LayoutParams localLayoutParams = this.hto.getLayoutParams();
      localLayoutParams.width = paramaf.getWidth();
      localLayoutParams.height = paramaf.getHeight();
      this.hto.setLayoutParams(localLayoutParams);
    }
  }
  
  public final void a(ak.a parama)
  {
    if (parama == null) {}
    while (this.htm.contains(parama)) {
      return;
    }
    this.htm.add(parama);
  }
  
  public final <Input extends View,  extends aa> boolean a(af paramaf, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramaf == null) || (paramaf.getWrapperView() == null) || (paramInput == null)) {
      return false;
    }
    d(paramaf);
    paramaf = new AbsoluteLayout.LayoutParams(paramInt1, paramInt2, paramInt3, paramInt4);
    this.hto.addView(paramInput, paramaf);
    ((aa)paramInput).z(this.gkh);
    return true;
  }
  
  public final boolean arc()
  {
    if (getChildCount() <= 0) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i <= getChildCount())
      {
        if (AppBrandViewMotionCompat.cc(getChildAt(i))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final void b(ak.a parama)
  {
    if (parama == null) {
      return;
    }
    this.htm.remove(parama);
  }
  
  public final void b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    cj(paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
  
  public final <Input extends View,  extends aa> boolean b(af paramaf, Input paramInput, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramaf == null) || (paramaf.getWrapperView() == null) || (paramInput == null)) {}
    label33:
    label174:
    for (;;)
    {
      return false;
      if ((paramInput != null) && (this.hto != null))
      {
        i = 0;
        if (i < this.hto.getChildCount()) {
          if (paramInput != this.hto.getChildAt(i)) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label174;
        }
        d(paramaf);
        if ((paramInput.getLayoutParams() == null) || (!(paramInput.getLayoutParams() instanceof AbsoluteLayout.LayoutParams))) {
          break;
        }
        if ((paramInput.getWidth() != paramInt1) || (paramInput.getHeight() != paramInt2) || (paramInput.getLeft() != paramInt3) || (paramInput.getTop() != paramInt4))
        {
          paramaf = (AbsoluteLayout.LayoutParams)paramInput.getLayoutParams();
          paramaf.x = paramInt3;
          paramaf.y = paramInt4;
          paramaf.width = paramInt1;
          paramaf.height = paramInt2;
          paramInput.setLayoutParams(paramaf);
        }
        return true;
        i += 1;
        break label33;
      }
    }
  }
  
  public final <Input extends View,  extends aa> void cg(Input paramInput)
  {
    if (paramInput == null) {
      return;
    }
    paramInput.setVisibility(8);
    this.hto.removeView(paramInput);
    ((aa)paramInput).A(this.gkh);
  }
  
  public final void kU(int paramInt)
  {
    setTranslationY(paramInt);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    y.v("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (cj(paramView.getWidth(), paramView.getHeight())) {
      this.hto.scrollTo(paramInt1, paramInt2);
    }
    paramInt3 = 0;
    while (paramInt3 < this.htm.size())
    {
      ((ak.a)this.htm.get(paramInt3)).ce(paramInt1, paramInt2);
      paramInt3 += 1;
    }
  }
  
  public final void setId(int paramInt) {}
  
  public final boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean z(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent == null) || (paramMotionEvent.getActionMasked() != 0)) {}
    e locale;
    do
    {
      return false;
      locale = this.htn;
    } while ((paramMotionEvent == null) || (paramMotionEvent.getActionMasked() != 0) || (locale.hpe == null) || (paramMotionEvent.getDownTime() != locale.hpe.hpf) || (paramMotionEvent.getEventTime() != locale.hpe.hpg));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.g
 * JD-Core Version:    0.7.0.1
 */