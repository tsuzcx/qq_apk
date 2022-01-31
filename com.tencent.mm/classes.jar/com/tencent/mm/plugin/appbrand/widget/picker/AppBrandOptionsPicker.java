package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.tencent.luggage.c.c.a.b;
import com.tencent.luggage.c.c.a.e;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.jsapi.m.b;

public class AppBrandOptionsPicker
  extends NumberPicker
  implements b<String>
{
  private int Un;
  private int eg;
  private String[] hAc;
  private int hAd;
  
  @Keep
  public AppBrandOptionsPicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, a.e.Widget_AppBrand_Picker));
    com.tencent.mm.ui.widget.picker.e.a(this, getResources().getDrawable(a.b.appbrand_picker_divider));
    com.tencent.mm.ui.widget.picker.e.c(this);
    com.tencent.mm.ui.widget.picker.e.e(this);
    e.a(this);
    this.Un = a.fromDPToPix(paramContext, 100);
    this.hAd = a.fromDPToPix(paramContext, 20);
  }
  
  public final void a(d paramd) {}
  
  public final void ajP() {}
  
  public final void ajQ() {}
  
  public final String asP()
  {
    if ((this.hAc == null) || (this.hAc.length <= 0)) {
      return "";
    }
    return this.hAc[getValue()];
  }
  
  public final void b(d paramd) {}
  
  public View getView()
  {
    return this;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    com.tencent.mm.ui.widget.picker.e.d(this);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((View.MeasureSpec.getMode(paramInt1) == -2147483648) || (View.MeasureSpec.getMode(paramInt1) == 1073741824)) {
      this.eg = View.MeasureSpec.getSize(paramInt1);
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), paramInt2);
    if ((getMeasuredWidth() <= this.Un) && ((this.eg <= 0) || (this.Un <= this.eg)))
    {
      setMeasuredDimension(this.Un, getMeasuredHeight());
      return;
    }
    paramInt2 = getMeasuredWidth() + this.hAd * 2;
    paramInt1 = paramInt2;
    if (this.eg > 0) {
      if (this.eg <= paramInt2) {
        break label119;
      }
    }
    label119:
    for (paramInt1 = paramInt2;; paramInt1 = this.eg)
    {
      setMeasuredDimension(paramInt1, getMeasuredHeight());
      return;
    }
  }
  
  @Deprecated
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    super.setDisplayedValues(paramArrayOfString);
  }
  
  public final void setExtraPadding(int paramInt)
  {
    this.hAd = Math.max(paramInt, 0);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    this.eg = paramInt;
  }
  
  public final void setMinWidth(int paramInt)
  {
    this.Un = paramInt;
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    this.hAc = paramArrayOfString;
    setDisplayedValues(null);
    setMinValue(0);
    setMaxValue(Math.max(paramArrayOfString.length - 1, 0));
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString.length <= 0) {
      arrayOfString = null;
    }
    super.setDisplayedValues(arrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker
 * JD-Core Version:    0.7.0.1
 */