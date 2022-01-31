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
import com.tencent.mm.plugin.appbrand.jsapi.n.b;

public class AppBrandOptionsPicker
  extends NumberPicker
  implements b<String>
{
  private String[] jsr;
  private int jss;
  private int mMaxWidth;
  private int mMinWidth;
  
  @Keep
  public AppBrandOptionsPicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131493756));
    AppMethodBeat.i(126714);
    com.tencent.mm.ui.widget.picker.e.a(this, getResources().getDrawable(2130837801));
    com.tencent.mm.ui.widget.picker.e.c(this);
    com.tencent.mm.ui.widget.picker.e.e(this);
    e.a(this);
    this.mMinWidth = a.fromDPToPix(paramContext, 100);
    this.jss = a.fromDPToPix(paramContext, 20);
    AppMethodBeat.o(126714);
  }
  
  public final void a(d paramd) {}
  
  public final void aEs() {}
  
  public final void aEt() {}
  
  public final String aRR()
  {
    AppMethodBeat.i(126720);
    if ((this.jsr == null) || (this.jsr.length <= 0))
    {
      AppMethodBeat.o(126720);
      return "";
    }
    String str = this.jsr[getValue()];
    AppMethodBeat.o(126720);
    return str;
  }
  
  public final void b(d paramd) {}
  
  public View getView()
  {
    return this;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(126719);
    super.onAttachedToWindow();
    com.tencent.mm.ui.widget.picker.e.d(this);
    AppMethodBeat.o(126719);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126718);
    if ((View.MeasureSpec.getMode(paramInt1) == -2147483648) || (View.MeasureSpec.getMode(paramInt1) == 1073741824)) {
      this.mMaxWidth = View.MeasureSpec.getSize(paramInt1);
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), paramInt2);
    if ((getMeasuredWidth() <= this.mMinWidth) && ((this.mMaxWidth <= 0) || (this.mMinWidth <= this.mMaxWidth)))
    {
      setMeasuredDimension(this.mMinWidth, getMeasuredHeight());
      AppMethodBeat.o(126718);
      return;
    }
    paramInt2 = getMeasuredWidth() + this.jss * 2;
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
      AppMethodBeat.o(126718);
      return;
    }
  }
  
  @Deprecated
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    AppMethodBeat.i(126717);
    super.setDisplayedValues(paramArrayOfString);
    AppMethodBeat.o(126717);
  }
  
  public final void setExtraPadding(int paramInt)
  {
    AppMethodBeat.i(126716);
    this.jss = Math.max(paramInt, 0);
    AppMethodBeat.o(126716);
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
    AppMethodBeat.i(126715);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(126715);
      return;
    }
    this.jsr = paramArrayOfString;
    setDisplayedValues(null);
    setMinValue(0);
    setMaxValue(Math.max(paramArrayOfString.length - 1, 0));
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString.length <= 0) {
      arrayOfString = null;
    }
    super.setDisplayedValues(arrayOfString);
    AppMethodBeat.o(126715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker
 * JD-Core Version:    0.7.0.1
 */