package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends e
{
  private Integer uvY;
  private Integer uvZ;
  private Float uwa;
  private Integer uwb;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(323929);
    Log.i("Luggage.WXA.AppBrandCenterInsideRuntimeFrameLayout", "AppBrandCenterInsideRuntimeFrameLayout: create");
    AppMethodBeat.o(323929);
  }
  
  private void dP(View paramView)
  {
    AppMethodBeat.i(323931);
    if (this.uwa == null)
    {
      AppMethodBeat.o(323931);
      return;
    }
    if (Math.abs(paramView.getScaleX() - this.uwa.floatValue()) >= 0.01F)
    {
      paramView.setScaleX(this.uwa.floatValue());
      paramView.setScaleY(this.uwa.floatValue());
    }
    AppMethodBeat.o(323931);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(323934);
    super.addView(paramView);
    dP(paramView);
    AppMethodBeat.o(323934);
  }
  
  public final void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(323937);
    super.addView(paramView, paramInt);
    dP(paramView);
    AppMethodBeat.o(323937);
  }
  
  public final void addView(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(323942);
    super.addView(paramView, paramInt1, paramInt2);
    dP(paramView);
    AppMethodBeat.o(323942);
  }
  
  public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(323949);
    super.addView(paramView, paramInt, paramLayoutParams);
    dP(paramView);
    AppMethodBeat.o(323949);
  }
  
  public final void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(323946);
    super.addView(paramView, paramLayoutParams);
    dP(paramView);
    AppMethodBeat.o(323946);
  }
  
  protected final void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(323956);
    int i = paramInt1;
    if (this.uvZ != null)
    {
      i = paramInt1;
      if (this.uvY != null)
      {
        if (this.uvY.intValue() > 0) {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(this.uvY.intValue(), 1073741824);
        }
        i = paramInt1;
        if (this.uvZ.intValue() > 0) {
          paramInt3 = View.MeasureSpec.makeMeasureSpec(this.uvZ.intValue(), 1073741824);
        }
      }
    }
    for (;;)
    {
      super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(323956);
      return;
      paramInt1 = i;
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(323963);
    int i = 0;
    int j = 0;
    int n = j;
    int m = i;
    if (this.uvY != null)
    {
      n = j;
      m = i;
      if (this.uvZ != null)
      {
        m = (paramInt3 - paramInt1) / 2 - this.uvY.intValue() / 2;
        n = (paramInt4 - paramInt2) / 2 - this.uvZ.intValue() / 2;
      }
    }
    int i1;
    int i2;
    label97:
    View localView;
    int k;
    if (this.uwb == null)
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
      i1 = this.uwb.intValue();
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
    AppMethodBeat.o(323963);
  }
  
  public final void setWxaLayoutParams(WxaWindowLayoutParams paramWxaWindowLayoutParams)
  {
    AppMethodBeat.i(323953);
    this.uvY = Integer.valueOf(paramWxaWindowLayoutParams.width);
    this.uvZ = Integer.valueOf(paramWxaWindowLayoutParams.height);
    this.uwa = Float.valueOf(paramWxaWindowLayoutParams.scale);
    this.uwb = Integer.valueOf(paramWxaWindowLayoutParams.gravity);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      dP(getChildAt(i));
      i += 1;
    }
    requestLayout();
    AppMethodBeat.o(323953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c
 * JD-Core Version:    0.7.0.1
 */