package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends d
{
  private Integer rmk;
  private Integer rml;
  private Float rmm;
  private Integer rmn;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(244988);
    Log.i("Luggage.WXA.AppBrandCenterInsideRuntimeFrameLayout", "AppBrandCenterInsideRuntimeFrameLayout: create");
    AppMethodBeat.o(244988);
  }
  
  private void df(View paramView)
  {
    AppMethodBeat.i(245001);
    if (this.rmm == null)
    {
      AppMethodBeat.o(245001);
      return;
    }
    if (Math.abs(paramView.getScaleX() - this.rmm.floatValue()) >= 0.01F)
    {
      paramView.setScaleX(this.rmm.floatValue());
      paramView.setScaleY(this.rmm.floatValue());
    }
    AppMethodBeat.o(245001);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(244990);
    super.addView(paramView);
    df(paramView);
    AppMethodBeat.o(244990);
  }
  
  public final void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(244992);
    super.addView(paramView, paramInt);
    df(paramView);
    AppMethodBeat.o(244992);
  }
  
  public final void addView(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(244995);
    super.addView(paramView, paramInt1, paramInt2);
    df(paramView);
    AppMethodBeat.o(244995);
  }
  
  public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(244999);
    super.addView(paramView, paramInt, paramLayoutParams);
    df(paramView);
    AppMethodBeat.o(244999);
  }
  
  public final void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(244997);
    super.addView(paramView, paramLayoutParams);
    df(paramView);
    AppMethodBeat.o(244997);
  }
  
  protected final void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(245008);
    int i = paramInt1;
    if (this.rml != null)
    {
      i = paramInt1;
      if (this.rmk != null)
      {
        if (this.rmk.intValue() > 0) {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(this.rmk.intValue(), 1073741824);
        }
        i = paramInt1;
        if (this.rml.intValue() > 0) {
          paramInt3 = View.MeasureSpec.makeMeasureSpec(this.rml.intValue(), 1073741824);
        }
      }
    }
    for (;;)
    {
      super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(245008);
      return;
      paramInt1 = i;
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(245011);
    int i = 0;
    int j = 0;
    int n = j;
    int m = i;
    if (this.rmk != null)
    {
      n = j;
      m = i;
      if (this.rml != null)
      {
        m = (paramInt3 - paramInt1) / 2 - this.rmk.intValue() / 2;
        n = (paramInt4 - paramInt2) / 2 - this.rml.intValue() / 2;
      }
    }
    int i1;
    int i2;
    label97:
    View localView;
    int k;
    if (this.rmn == null)
    {
      i1 = 17;
      int i3 = getChildCount();
      i2 = 0;
      if (i2 >= i3) {
        break label287;
      }
      localView = getChildAt(i2);
      if (localView.getVisibility() != 8)
      {
        k = localView.getMeasuredWidth();
        paramInt3 = localView.getMeasuredHeight();
        switch (i1)
        {
        default: 
          k = paramInt1 + k;
          paramInt3 = paramInt2 + paramInt3;
          Log.w("Luggage.WXA.AppBrandCenterInsideRuntimeFrameLayout", "onLayout: unhandled gravity[%d], good luck~", new Object[] { Integer.valueOf(i1) });
          i = paramInt2;
          j = paramInt1;
        }
      }
    }
    for (;;)
    {
      localView.layout(j, i, k, paramInt3);
      i2 += 1;
      break label97;
      i1 = this.rmn.intValue();
      break;
      j = paramInt1 + m;
      i = paramInt2 + n;
      k = j + k;
      paramInt3 = i + paramInt3;
      continue;
      k = paramInt1 + k;
      i = paramInt4 - paramInt3;
      paramInt3 = paramInt4;
      j = paramInt1;
    }
    label287:
    AppMethodBeat.o(245011);
  }
  
  public final void setWxaLayoutParams(WxaWindowLayoutParams paramWxaWindowLayoutParams)
  {
    AppMethodBeat.i(245005);
    this.rmk = Integer.valueOf(paramWxaWindowLayoutParams.width);
    this.rml = Integer.valueOf(paramWxaWindowLayoutParams.height);
    this.rmm = Float.valueOf(paramWxaWindowLayoutParams.scale);
    this.rmn = Integer.valueOf(paramWxaWindowLayoutParams.gravity);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      df(getChildAt(i));
      i += 1;
    }
    requestLayout();
    AppMethodBeat.o(245005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c
 * JD-Core Version:    0.7.0.1
 */