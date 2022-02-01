package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
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
  implements com.tencent.mm.plugin.appbrand.jsapi.v.c<String>
{
  public boolean uMX;
  public boolean uMY;
  public boolean uMZ;
  public NumberPicker uNa;
  public NumberPicker uNb;
  public NumberPicker uNc;
  private Date uNd;
  private Date uNe;
  private final Calendar uNf;
  private final String[] uNg;
  
  public AppBrandDatePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, a.h.Widget_AppBrand_Picker));
    AppMethodBeat.i(137973);
    this.uMX = true;
    this.uMY = true;
    this.uMZ = true;
    this.uNg = new String[12];
    int i = 0;
    while (i < this.uNg.length)
    {
      this.uNg[i] = (i + 1);
      i += 1;
    }
    this.uNf = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.uNa = ((YADatePicker.c)getUIDelegate()).agkI;
    this.uNb = ((YADatePicker.c)getUIDelegate()).agkH;
    this.uNc = ((YADatePicker.c)getUIDelegate()).agkG;
    paramContext = getResources().getDrawable(a.d.appbrand_picker_divider);
    e.a(this.uNa, paramContext);
    e.a(this.uNb, paramContext);
    e.a(this.uNc, paramContext);
    e.d(this.uNa);
    e.d(this.uNb);
    e.d(this.uNc);
    d.a(this.uNa);
    d.a(this.uNb);
    d.a(this.uNc);
    paramContext = new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(137972);
        AppBrandDatePicker.a(AppBrandDatePicker.this);
        AppMethodBeat.o(137972);
      }
    };
    if (this.uNa != null)
    {
      this.uNa.setOnValueChangedListener(paramContext);
      this.uNa.setMinValue(1900);
    }
    if (this.uNb != null) {
      this.uNb.setOnValueChangedListener(paramContext);
    }
    if (this.uNc != null) {
      this.uNc.setOnValueChangedListener(paramContext);
    }
    cSm();
    e.f(this.uNa);
    e.f(this.uNb);
    e.f(this.uNc);
    AppMethodBeat.o(137973);
  }
  
  private void cSm()
  {
    int j = 0;
    AppMethodBeat.i(137974);
    if ((this.uNa == null) || (this.uNb == null) || (this.uNc == null))
    {
      AppMethodBeat.o(137974);
      return;
    }
    this.uNb.setDisplayedValues(null);
    if ((this.uNa.getValue() == this.uNa.getMaxValue()) && (this.uNe != null))
    {
      this.uNb.setMaxValue(this.uNe.getMonth());
      if ((this.uNb.getValue() != this.uNb.getMaxValue()) || (this.uNe == null)) {
        break label333;
      }
      this.uNc.setMaxValue(this.uNe.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.uNa.getValue();
        int k = this.uNb.getValue();
        this.uNf.set(i, k, 1);
        i = this.uNf.getActualMaximum(5);
        this.uNc.setMaxValue(i);
      }
      if ((this.uNa.getValue() != this.uNa.getMinValue()) || (this.uNd == null)) {
        break label338;
      }
      this.uNb.setMinValue(this.uNd.getMonth());
      i = j;
      if (this.uNb.getValue() == this.uNb.getMinValue())
      {
        i = j;
        if (this.uNd != null) {
          this.uNc.setMinValue(this.uNd.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.uNc.setMinValue(1);
      }
      this.uNb.setDisplayedValues((String[])Arrays.copyOfRange(this.uNg, this.uNb.getMinValue(), this.uNb.getMaxValue() + 1));
      this.uNa.setWrapSelectorWheel(true);
      this.uNb.setWrapSelectorWheel(true);
      this.uNc.setWrapSelectorWheel(true);
      AppMethodBeat.o(137974);
      return;
      this.uNb.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.uNb.setMinValue(0);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(137979);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    cSm();
    AppMethodBeat.o(137979);
  }
  
  public final int getDayOfMonth()
  {
    AppMethodBeat.i(137982);
    if (this.uNc != null)
    {
      i = this.uNc.getValue();
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
    if (this.uNb != null) {}
    for (int i = this.uNb.getValue() + 1;; i = super.getMonth() + 1)
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
    if (this.uNa != null)
    {
      i = this.uNa.getValue();
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
    e.e(this.uNa);
    e.e(this.uNb);
    e.e(this.uNc);
    AppMethodBeat.o(137977);
  }
  
  public final void onDetach(c paramc) {}
  
  public final void onHide(c paramc) {}
  
  public final void onShow(c paramc)
  {
    AppMethodBeat.i(137978);
    cSm();
    AppMethodBeat.o(137978);
  }
  
  public final void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(137975);
    super.setMaxDate(paramLong);
    this.uNe = new Date(paramLong);
    if (this.uNa != null) {
      this.uNa.setMaxValue(this.uNe.getYear() + 1900);
    }
    AppMethodBeat.o(137975);
  }
  
  public final void setMinDate(long paramLong)
  {
    AppMethodBeat.i(137976);
    super.setMinDate(paramLong);
    this.uNd = new Date(paramLong);
    if (this.uNa != null) {
      this.uNa.setMinValue(this.uNd.getYear() + 1900);
    }
    AppMethodBeat.o(137976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker
 * JD-Core Version:    0.7.0.1
 */