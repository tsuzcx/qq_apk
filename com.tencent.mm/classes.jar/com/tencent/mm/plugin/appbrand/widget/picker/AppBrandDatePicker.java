package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.YADatePicker;
import com.tencent.mm.ui.widget.picker.YADatePicker.c;
import com.tencent.mm.ui.widget.picker.YADatePicker.d;
import com.tencent.mm.ui.widget.picker.f;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class AppBrandDatePicker
  extends YADatePicker
  implements com.tencent.mm.plugin.appbrand.jsapi.n.c<String>
{
  public boolean mhP;
  public boolean mhQ;
  public boolean mhR;
  public NumberPicker mhS;
  public NumberPicker mhT;
  public NumberPicker mhU;
  private Date mhV;
  private Date mhW;
  private final Calendar mhX;
  private final String[] mhY;
  
  @Keep
  public AppBrandDatePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821553));
    AppMethodBeat.i(137973);
    this.mhP = true;
    this.mhQ = true;
    this.mhR = true;
    this.mhY = new String[12];
    int i = 0;
    while (i < this.mhY.length)
    {
      this.mhY[i] = (i + 1);
      i += 1;
    }
    this.mhX = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.mhS = ((YADatePicker.c)getUIDelegate()).HJX;
    this.mhT = ((YADatePicker.c)getUIDelegate()).HJW;
    this.mhU = ((YADatePicker.c)getUIDelegate()).HJV;
    paramContext = getResources().getDrawable(2131231055);
    f.a(this.mhS, paramContext);
    f.a(this.mhT, paramContext);
    f.a(this.mhU, paramContext);
    f.d(this.mhS);
    f.d(this.mhT);
    f.d(this.mhU);
    d.a(this.mhS);
    d.a(this.mhT);
    d.a(this.mhU);
    paramContext = new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(137972);
        AppBrandDatePicker.a(AppBrandDatePicker.this);
        AppMethodBeat.o(137972);
      }
    };
    if (this.mhS != null)
    {
      this.mhS.setOnValueChangedListener(paramContext);
      this.mhS.setMinValue(1900);
    }
    if (this.mhT != null) {
      this.mhT.setOnValueChangedListener(paramContext);
    }
    if (this.mhU != null) {
      this.mhU.setOnValueChangedListener(paramContext);
    }
    bui();
    f.f(this.mhS);
    f.f(this.mhT);
    f.f(this.mhU);
    AppMethodBeat.o(137973);
  }
  
  private void bui()
  {
    int j = 0;
    AppMethodBeat.i(137974);
    if ((this.mhS == null) || (this.mhT == null) || (this.mhU == null))
    {
      AppMethodBeat.o(137974);
      return;
    }
    this.mhT.setDisplayedValues(null);
    if ((this.mhS.getValue() == this.mhS.getMaxValue()) && (this.mhW != null))
    {
      this.mhT.setMaxValue(this.mhW.getMonth());
      if ((this.mhT.getValue() != this.mhT.getMaxValue()) || (this.mhW == null)) {
        break label333;
      }
      this.mhU.setMaxValue(this.mhW.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.mhS.getValue();
        int k = this.mhT.getValue();
        this.mhX.set(i, k, 1);
        i = this.mhX.getActualMaximum(5);
        this.mhU.setMaxValue(i);
      }
      if ((this.mhS.getValue() != this.mhS.getMinValue()) || (this.mhV == null)) {
        break label338;
      }
      this.mhT.setMinValue(this.mhV.getMonth());
      i = j;
      if (this.mhT.getValue() == this.mhT.getMinValue())
      {
        i = j;
        if (this.mhV != null) {
          this.mhU.setMinValue(this.mhV.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.mhU.setMinValue(1);
      }
      this.mhT.setDisplayedValues((String[])Arrays.copyOfRange(this.mhY, this.mhT.getMinValue(), this.mhT.getMaxValue() + 1));
      this.mhS.setWrapSelectorWheel(true);
      this.mhT.setWrapSelectorWheel(true);
      this.mhU.setWrapSelectorWheel(true);
      AppMethodBeat.o(137974);
      return;
      this.mhT.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.mhT.setMinValue(0);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(137979);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    bui();
    AppMethodBeat.o(137979);
  }
  
  public final int getDayOfMonth()
  {
    AppMethodBeat.i(137982);
    if (this.mhU != null)
    {
      i = this.mhU.getValue();
      AppMethodBeat.o(137982);
      return i;
    }
    int i = super.getDayOfMonth();
    AppMethodBeat.o(137982);
    return i;
  }
  
  public final int getMonth()
  {
    AppMethodBeat.i(137981);
    if (this.mhT != null) {}
    for (int i = this.mhT.getValue() + 1;; i = super.getMonth() + 1)
    {
      i = Math.max(Math.min(i, 12), 0);
      AppMethodBeat.o(137981);
      return i;
    }
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final int getYear()
  {
    AppMethodBeat.i(137980);
    if (this.mhS != null)
    {
      i = this.mhS.getValue();
      AppMethodBeat.o(137980);
      return i;
    }
    int i = super.getYear();
    AppMethodBeat.o(137980);
    return i;
  }
  
  public final void onAttach(c paramc) {}
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(137977);
    super.onAttachedToWindow();
    f.e(this.mhS);
    f.e(this.mhT);
    f.e(this.mhU);
    AppMethodBeat.o(137977);
  }
  
  public final void onDetach(c paramc) {}
  
  public final void onHide(c paramc) {}
  
  public final void onShow(c paramc)
  {
    AppMethodBeat.i(137978);
    bui();
    AppMethodBeat.o(137978);
  }
  
  public final void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(137975);
    super.setMaxDate(paramLong);
    this.mhW = new Date(paramLong);
    if (this.mhS != null) {
      this.mhS.setMaxValue(this.mhW.getYear() + 1900);
    }
    AppMethodBeat.o(137975);
  }
  
  public final void setMinDate(long paramLong)
  {
    AppMethodBeat.i(137976);
    super.setMinDate(paramLong);
    this.mhV = new Date(paramLong);
    if (this.mhS != null) {
      this.mhS.setMinValue(this.mhV.getYear() + 1900);
    }
    AppMethodBeat.o(137976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker
 * JD-Core Version:    0.7.0.1
 */