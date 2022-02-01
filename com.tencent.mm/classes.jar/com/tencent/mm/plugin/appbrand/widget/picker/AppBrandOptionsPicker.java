package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.widget.picker.f;

public class AppBrandOptionsPicker
  extends NumberPicker
  implements com.tencent.mm.plugin.appbrand.jsapi.p.c<String>
{
  private int mMaxWidth;
  private int mMinWidth;
  private String[] npT;
  private int npU;
  
  @Keep
  public AppBrandOptionsPicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821553));
    AppMethodBeat.i(138018);
    f.a(this, getResources().getDrawable(2131231055));
    f.d(this);
    f.f(this);
    d.a(this);
    this.mMinWidth = a.fromDPToPix(paramContext, 100);
    this.npU = a.fromDPToPix(paramContext, 20);
    AppMethodBeat.o(138018);
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(138024);
    if ((this.npT == null) || (this.npT.length <= 0))
    {
      AppMethodBeat.o(138024);
      return "";
    }
    String str = this.npT[getValue()];
    AppMethodBeat.o(138024);
    return str;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void onAttach(c paramc) {}
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(138023);
    super.onAttachedToWindow();
    f.e(this);
    AppMethodBeat.o(138023);
  }
  
  public void onDetach(c paramc) {}
  
  public void onHide(c paramc) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138022);
    if ((View.MeasureSpec.getMode(paramInt1) == -2147483648) || (View.MeasureSpec.getMode(paramInt1) == 1073741824)) {
      this.mMaxWidth = View.MeasureSpec.getSize(paramInt1);
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), paramInt2);
    if ((getMeasuredWidth() <= this.mMinWidth) && ((this.mMaxWidth <= 0) || (this.mMinWidth <= this.mMaxWidth)))
    {
      setMeasuredDimension(this.mMinWidth, getMeasuredHeight());
      AppMethodBeat.o(138022);
      return;
    }
    paramInt2 = getMeasuredWidth() + this.npU * 2;
    paramInt1 = paramInt2;
    if (this.mMaxWidth > 0) {
      if (this.mMaxWidth <= paramInt2) {
        break label134;
      }
    }
    label134:
    for (paramInt1 = paramInt2;; paramInt1 = this.mMaxWidth)
    {
      setMeasuredDimension(paramInt1, getMeasuredHeight());
      AppMethodBeat.o(138022);
      return;
    }
  }
  
  public void onShow(c paramc) {}
  
  @Deprecated
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    AppMethodBeat.i(138021);
    super.setDisplayedValues(paramArrayOfString);
    AppMethodBeat.o(138021);
  }
  
  public final void setExtraPadding(int paramInt)
  {
    AppMethodBeat.i(138020);
    this.npU = Math.max(paramInt, 0);
    AppMethodBeat.o(138020);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
  }
  
  public final void setMinWidth(int paramInt)
  {
    this.mMinWidth = paramInt;
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(138019);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(138019);
      return;
    }
    this.npT = paramArrayOfString;
    setDisplayedValues(null);
    setMinValue(0);
    setMaxValue(Math.max(paramArrayOfString.length - 1, 0));
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString.length <= 0) {
      arrayOfString = null;
    }
    super.setDisplayedValues(arrayOfString);
    AppMethodBeat.o(138019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker
 * JD-Core Version:    0.7.0.1
 */