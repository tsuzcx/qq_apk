package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.jsapi.m.b;

public class c
  extends YANumberPicker
  implements b<String>
{
  private String[] hAc;
  private int hAe;
  
  public c(Context paramContext)
  {
    super(paramContext);
    setDividerHeight(a.fromDPToPix(paramContext, 2));
    setDividerColor(Color.parseColor("#1AAD19"));
    setItemPaddingVertical(a.fromDPToPix(paramContext, 8));
    setNormalTextColor(Color.parseColor("#A5A5A5"));
    setSelectedTextColor(-16777216);
  }
  
  public final void a(d paramd) {}
  
  public final void ajP()
  {
    asY();
  }
  
  public final void ajQ() {}
  
  public final void b(d paramd) {}
  
  public final View getView()
  {
    return this;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.hAe > 0) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(this.hAe, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void setForceWidth(int paramInt)
  {
    this.hAe = paramInt;
  }
  
  public final void setOptionsArray(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      setEnabled(false);
      setVisibility(4);
      return;
    }
    setEnabled(true);
    setVisibility(0);
    this.hAc = paramArrayOfString;
    int i = getMinValue();
    int j = getMaxValue();
    int k = paramArrayOfString.length - 1;
    if (k - i + 1 > j - i + 1)
    {
      setDisplayedValues(paramArrayOfString);
      setMaxValue(k);
      return;
    }
    setMaxValue(k);
    setDisplayedValues(paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */