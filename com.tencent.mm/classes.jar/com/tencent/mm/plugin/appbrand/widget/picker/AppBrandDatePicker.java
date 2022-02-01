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
  implements com.tencent.mm.plugin.appbrand.jsapi.m.c<String>
{
  public boolean mJQ;
  public boolean mJR;
  public boolean mJS;
  public NumberPicker mJT;
  public NumberPicker mJU;
  public NumberPicker mJV;
  private Date mJW;
  private Date mJX;
  private final Calendar mJY;
  private final String[] mJZ;
  
  @Keep
  public AppBrandDatePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821553));
    AppMethodBeat.i(137973);
    this.mJQ = true;
    this.mJR = true;
    this.mJS = true;
    this.mJZ = new String[12];
    int i = 0;
    while (i < this.mJZ.length)
    {
      this.mJZ[i] = (i + 1);
      i += 1;
    }
    this.mJY = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.mJT = ((YADatePicker.c)getUIDelegate()).Jku;
    this.mJU = ((YADatePicker.c)getUIDelegate()).Jkt;
    this.mJV = ((YADatePicker.c)getUIDelegate()).Jks;
    paramContext = getResources().getDrawable(2131231055);
    f.a(this.mJT, paramContext);
    f.a(this.mJU, paramContext);
    f.a(this.mJV, paramContext);
    f.d(this.mJT);
    f.d(this.mJU);
    f.d(this.mJV);
    d.a(this.mJT);
    d.a(this.mJU);
    d.a(this.mJV);
    paramContext = new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(137972);
        AppBrandDatePicker.a(AppBrandDatePicker.this);
        AppMethodBeat.o(137972);
      }
    };
    if (this.mJT != null)
    {
      this.mJT.setOnValueChangedListener(paramContext);
      this.mJT.setMinValue(1900);
    }
    if (this.mJU != null) {
      this.mJU.setOnValueChangedListener(paramContext);
    }
    if (this.mJV != null) {
      this.mJV.setOnValueChangedListener(paramContext);
    }
    bBg();
    f.f(this.mJT);
    f.f(this.mJU);
    f.f(this.mJV);
    AppMethodBeat.o(137973);
  }
  
  private void bBg()
  {
    int j = 0;
    AppMethodBeat.i(137974);
    if ((this.mJT == null) || (this.mJU == null) || (this.mJV == null))
    {
      AppMethodBeat.o(137974);
      return;
    }
    this.mJU.setDisplayedValues(null);
    if ((this.mJT.getValue() == this.mJT.getMaxValue()) && (this.mJX != null))
    {
      this.mJU.setMaxValue(this.mJX.getMonth());
      if ((this.mJU.getValue() != this.mJU.getMaxValue()) || (this.mJX == null)) {
        break label333;
      }
      this.mJV.setMaxValue(this.mJX.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.mJT.getValue();
        int k = this.mJU.getValue();
        this.mJY.set(i, k, 1);
        i = this.mJY.getActualMaximum(5);
        this.mJV.setMaxValue(i);
      }
      if ((this.mJT.getValue() != this.mJT.getMinValue()) || (this.mJW == null)) {
        break label338;
      }
      this.mJU.setMinValue(this.mJW.getMonth());
      i = j;
      if (this.mJU.getValue() == this.mJU.getMinValue())
      {
        i = j;
        if (this.mJW != null) {
          this.mJV.setMinValue(this.mJW.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.mJV.setMinValue(1);
      }
      this.mJU.setDisplayedValues((String[])Arrays.copyOfRange(this.mJZ, this.mJU.getMinValue(), this.mJU.getMaxValue() + 1));
      this.mJT.setWrapSelectorWheel(true);
      this.mJU.setWrapSelectorWheel(true);
      this.mJV.setWrapSelectorWheel(true);
      AppMethodBeat.o(137974);
      return;
      this.mJU.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.mJU.setMinValue(0);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(137979);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    bBg();
    AppMethodBeat.o(137979);
  }
  
  public final int getDayOfMonth()
  {
    AppMethodBeat.i(137982);
    if (this.mJV != null)
    {
      i = this.mJV.getValue();
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
    if (this.mJU != null) {}
    for (int i = this.mJU.getValue() + 1;; i = super.getMonth() + 1)
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
    if (this.mJT != null)
    {
      i = this.mJT.getValue();
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
    f.e(this.mJT);
    f.e(this.mJU);
    f.e(this.mJV);
    AppMethodBeat.o(137977);
  }
  
  public final void onDetach(c paramc) {}
  
  public final void onHide(c paramc) {}
  
  public final void onShow(c paramc)
  {
    AppMethodBeat.i(137978);
    bBg();
    AppMethodBeat.o(137978);
  }
  
  public final void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(137975);
    super.setMaxDate(paramLong);
    this.mJX = new Date(paramLong);
    if (this.mJT != null) {
      this.mJT.setMaxValue(this.mJX.getYear() + 1900);
    }
    AppMethodBeat.o(137975);
  }
  
  public final void setMinDate(long paramLong)
  {
    AppMethodBeat.i(137976);
    super.setMinDate(paramLong);
    this.mJW = new Date(paramLong);
    if (this.mJT != null) {
      this.mJT.setMinValue(this.mJW.getYear() + 1900);
    }
    AppMethodBeat.o(137976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker
 * JD-Core Version:    0.7.0.1
 */