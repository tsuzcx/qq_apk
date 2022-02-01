package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import androidx.annotation.Keep;
import com.tencent.luggage.b.a.a.d;
import com.tencent.luggage.b.a.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.YADatePicker;
import com.tencent.mm.ui.widget.picker.YADatePicker.c;
import com.tencent.mm.ui.widget.picker.YADatePicker.d;
import com.tencent.mm.ui.widget.picker.e;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class AppBrandDatePicker
  extends YADatePicker
  implements com.tencent.mm.plugin.appbrand.jsapi.s.c<String>
{
  public boolean rBI;
  public boolean rBJ;
  public boolean rBK;
  public NumberPicker rBL;
  public NumberPicker rBM;
  public NumberPicker rBN;
  private Date rBO;
  private Date rBP;
  private final Calendar rBQ;
  private final String[] rBR;
  
  @Keep
  public AppBrandDatePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, a.h.Widget_AppBrand_Picker));
    AppMethodBeat.i(137973);
    this.rBI = true;
    this.rBJ = true;
    this.rBK = true;
    this.rBR = new String[12];
    int i = 0;
    while (i < this.rBR.length)
    {
      this.rBR[i] = (i + 1);
      i += 1;
    }
    this.rBQ = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.rBL = ((YADatePicker.c)getUIDelegate()).Yst;
    this.rBM = ((YADatePicker.c)getUIDelegate()).Yss;
    this.rBN = ((YADatePicker.c)getUIDelegate()).Ysr;
    paramContext = getResources().getDrawable(a.d.appbrand_picker_divider);
    e.a(this.rBL, paramContext);
    e.a(this.rBM, paramContext);
    e.a(this.rBN, paramContext);
    e.d(this.rBL);
    e.d(this.rBM);
    e.d(this.rBN);
    d.a(this.rBL);
    d.a(this.rBM);
    d.a(this.rBN);
    paramContext = new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(137972);
        AppBrandDatePicker.a(AppBrandDatePicker.this);
        AppMethodBeat.o(137972);
      }
    };
    if (this.rBL != null)
    {
      this.rBL.setOnValueChangedListener(paramContext);
      this.rBL.setMinValue(1900);
    }
    if (this.rBM != null) {
      this.rBM.setOnValueChangedListener(paramContext);
    }
    if (this.rBN != null) {
      this.rBN.setOnValueChangedListener(paramContext);
    }
    cpH();
    e.f(this.rBL);
    e.f(this.rBM);
    e.f(this.rBN);
    AppMethodBeat.o(137973);
  }
  
  private void cpH()
  {
    int j = 0;
    AppMethodBeat.i(137974);
    if ((this.rBL == null) || (this.rBM == null) || (this.rBN == null))
    {
      AppMethodBeat.o(137974);
      return;
    }
    this.rBM.setDisplayedValues(null);
    if ((this.rBL.getValue() == this.rBL.getMaxValue()) && (this.rBP != null))
    {
      this.rBM.setMaxValue(this.rBP.getMonth());
      if ((this.rBM.getValue() != this.rBM.getMaxValue()) || (this.rBP == null)) {
        break label333;
      }
      this.rBN.setMaxValue(this.rBP.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.rBL.getValue();
        int k = this.rBM.getValue();
        this.rBQ.set(i, k, 1);
        i = this.rBQ.getActualMaximum(5);
        this.rBN.setMaxValue(i);
      }
      if ((this.rBL.getValue() != this.rBL.getMinValue()) || (this.rBO == null)) {
        break label338;
      }
      this.rBM.setMinValue(this.rBO.getMonth());
      i = j;
      if (this.rBM.getValue() == this.rBM.getMinValue())
      {
        i = j;
        if (this.rBO != null) {
          this.rBN.setMinValue(this.rBO.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.rBN.setMinValue(1);
      }
      this.rBM.setDisplayedValues((String[])Arrays.copyOfRange(this.rBR, this.rBM.getMinValue(), this.rBM.getMaxValue() + 1));
      this.rBL.setWrapSelectorWheel(true);
      this.rBM.setWrapSelectorWheel(true);
      this.rBN.setWrapSelectorWheel(true);
      AppMethodBeat.o(137974);
      return;
      this.rBM.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.rBM.setMinValue(0);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(137979);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    cpH();
    AppMethodBeat.o(137979);
  }
  
  public final int getDayOfMonth()
  {
    AppMethodBeat.i(137982);
    if (this.rBN != null)
    {
      i = this.rBN.getValue();
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
    if (this.rBM != null) {}
    for (int i = this.rBM.getValue() + 1;; i = super.getMonth() + 1)
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
    if (this.rBL != null)
    {
      i = this.rBL.getValue();
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
    e.e(this.rBL);
    e.e(this.rBM);
    e.e(this.rBN);
    AppMethodBeat.o(137977);
  }
  
  public final void onDetach(c paramc) {}
  
  public final void onHide(c paramc) {}
  
  public final void onShow(c paramc)
  {
    AppMethodBeat.i(137978);
    cpH();
    AppMethodBeat.o(137978);
  }
  
  public final void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(137975);
    super.setMaxDate(paramLong);
    this.rBP = new Date(paramLong);
    if (this.rBL != null) {
      this.rBL.setMaxValue(this.rBP.getYear() + 1900);
    }
    AppMethodBeat.o(137975);
  }
  
  public final void setMinDate(long paramLong)
  {
    AppMethodBeat.i(137976);
    super.setMinDate(paramLong);
    this.rBO = new Date(paramLong);
    if (this.rBL != null) {
      this.rBL.setMinValue(this.rBO.getYear() + 1900);
    }
    AppMethodBeat.o(137976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker
 * JD-Core Version:    0.7.0.1
 */