package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import androidx.annotation.Keep;
import com.tencent.luggage.b.e.a.a;
import com.tencent.luggage.b.e.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.ui.widget.picker.e;

public class AppBrandOptionsPicker
  extends NumberPicker
  implements com.tencent.mm.plugin.appbrand.jsapi.s.c<String>
{
  private int lj;
  private String[] rCh;
  private int rCi;
  private int uJ;
  
  @Keep
  public AppBrandOptionsPicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, a.b.Widget_AppBrand_Picker));
    AppMethodBeat.i(138018);
    e.a(this, getResources().getDrawable(a.a.appbrand_picker_divider));
    e.d(this);
    e.f(this);
    d.a(this);
    this.lj = a.fromDPToPix(paramContext, 100);
    this.rCi = a.fromDPToPix(paramContext, 20);
    AppMethodBeat.o(138018);
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(138024);
    if ((this.rCh == null) || (this.rCh.length <= 0))
    {
      AppMethodBeat.o(138024);
      return "";
    }
    String str = this.rCh[getValue()];
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
    e.e(this);
    AppMethodBeat.o(138023);
  }
  
  public void onDetach(c paramc) {}
  
  public void onHide(c paramc) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138022);
    if ((View.MeasureSpec.getMode(paramInt1) == -2147483648) || (View.MeasureSpec.getMode(paramInt1) == 1073741824)) {
      this.uJ = View.MeasureSpec.getSize(paramInt1);
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), paramInt2);
    if ((getMeasuredWidth() <= this.lj) && ((this.uJ <= 0) || (this.lj <= this.uJ)))
    {
      setMeasuredDimension(this.lj, getMeasuredHeight());
      AppMethodBeat.o(138022);
      return;
    }
    paramInt2 = getMeasuredWidth() + this.rCi * 2;
    paramInt1 = paramInt2;
    if (this.uJ > 0) {
      if (this.uJ <= paramInt2) {
        break label134;
      }
    }
    label134:
    for (paramInt1 = paramInt2;; paramInt1 = this.uJ)
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
    this.rCi = Math.max(paramInt, 0);
    AppMethodBeat.o(138020);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    this.uJ = paramInt;
  }
  
  public final void setMinWidth(int paramInt)
  {
    this.lj = paramInt;
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(138019);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(138019);
      return;
    }
    this.rCh = paramArrayOfString;
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