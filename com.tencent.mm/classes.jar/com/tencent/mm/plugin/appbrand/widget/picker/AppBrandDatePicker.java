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
  implements com.tencent.mm.plugin.appbrand.jsapi.p.c<String>
{
  private Date npA;
  private Date npB;
  private final Calendar npC;
  private final String[] npD;
  public boolean npu;
  public boolean npv;
  public boolean npw;
  public NumberPicker npx;
  public NumberPicker npy;
  public NumberPicker npz;
  
  @Keep
  public AppBrandDatePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821553));
    AppMethodBeat.i(137973);
    this.npu = true;
    this.npv = true;
    this.npw = true;
    this.npD = new String[12];
    int i = 0;
    while (i < this.npD.length)
    {
      this.npD[i] = (i + 1);
      i += 1;
    }
    this.npC = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.npx = ((YADatePicker.c)getUIDelegate()).Lys;
    this.npy = ((YADatePicker.c)getUIDelegate()).Lyr;
    this.npz = ((YADatePicker.c)getUIDelegate()).Lyq;
    paramContext = getResources().getDrawable(2131231055);
    f.a(this.npx, paramContext);
    f.a(this.npy, paramContext);
    f.a(this.npz, paramContext);
    f.d(this.npx);
    f.d(this.npy);
    f.d(this.npz);
    d.a(this.npx);
    d.a(this.npy);
    d.a(this.npz);
    paramContext = new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(137972);
        AppBrandDatePicker.a(AppBrandDatePicker.this);
        AppMethodBeat.o(137972);
      }
    };
    if (this.npx != null)
    {
      this.npx.setOnValueChangedListener(paramContext);
      this.npx.setMinValue(1900);
    }
    if (this.npy != null) {
      this.npy.setOnValueChangedListener(paramContext);
    }
    if (this.npz != null) {
      this.npz.setOnValueChangedListener(paramContext);
    }
    bGa();
    f.f(this.npx);
    f.f(this.npy);
    f.f(this.npz);
    AppMethodBeat.o(137973);
  }
  
  private void bGa()
  {
    int j = 0;
    AppMethodBeat.i(137974);
    if ((this.npx == null) || (this.npy == null) || (this.npz == null))
    {
      AppMethodBeat.o(137974);
      return;
    }
    this.npy.setDisplayedValues(null);
    if ((this.npx.getValue() == this.npx.getMaxValue()) && (this.npB != null))
    {
      this.npy.setMaxValue(this.npB.getMonth());
      if ((this.npy.getValue() != this.npy.getMaxValue()) || (this.npB == null)) {
        break label333;
      }
      this.npz.setMaxValue(this.npB.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.npx.getValue();
        int k = this.npy.getValue();
        this.npC.set(i, k, 1);
        i = this.npC.getActualMaximum(5);
        this.npz.setMaxValue(i);
      }
      if ((this.npx.getValue() != this.npx.getMinValue()) || (this.npA == null)) {
        break label338;
      }
      this.npy.setMinValue(this.npA.getMonth());
      i = j;
      if (this.npy.getValue() == this.npy.getMinValue())
      {
        i = j;
        if (this.npA != null) {
          this.npz.setMinValue(this.npA.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.npz.setMinValue(1);
      }
      this.npy.setDisplayedValues((String[])Arrays.copyOfRange(this.npD, this.npy.getMinValue(), this.npy.getMaxValue() + 1));
      this.npx.setWrapSelectorWheel(true);
      this.npy.setWrapSelectorWheel(true);
      this.npz.setWrapSelectorWheel(true);
      AppMethodBeat.o(137974);
      return;
      this.npy.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.npy.setMinValue(0);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(137979);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    bGa();
    AppMethodBeat.o(137979);
  }
  
  public final int getDayOfMonth()
  {
    AppMethodBeat.i(137982);
    if (this.npz != null)
    {
      i = this.npz.getValue();
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
    if (this.npy != null) {}
    for (int i = this.npy.getValue() + 1;; i = super.getMonth() + 1)
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
    if (this.npx != null)
    {
      i = this.npx.getValue();
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
    f.e(this.npx);
    f.e(this.npy);
    f.e(this.npz);
    AppMethodBeat.o(137977);
  }
  
  public final void onDetach(c paramc) {}
  
  public final void onHide(c paramc) {}
  
  public final void onShow(c paramc)
  {
    AppMethodBeat.i(137978);
    bGa();
    AppMethodBeat.o(137978);
  }
  
  public final void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(137975);
    super.setMaxDate(paramLong);
    this.npB = new Date(paramLong);
    if (this.npx != null) {
      this.npx.setMaxValue(this.npB.getYear() + 1900);
    }
    AppMethodBeat.o(137975);
  }
  
  public final void setMinDate(long paramLong)
  {
    AppMethodBeat.i(137976);
    super.setMinDate(paramLong);
    this.npA = new Date(paramLong);
    if (this.npx != null) {
      this.npx.setMinValue(this.npA.getYear() + 1900);
    }
    AppMethodBeat.o(137976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker
 * JD-Core Version:    0.7.0.1
 */