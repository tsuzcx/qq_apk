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
  implements com.tencent.mm.plugin.appbrand.jsapi.r.c<String>
{
  public boolean ozb;
  public boolean ozc;
  public boolean ozd;
  public NumberPicker oze;
  public NumberPicker ozf;
  public NumberPicker ozg;
  private Date ozh;
  private Date ozi;
  private final Calendar ozj;
  private final String[] ozk;
  
  @Keep
  public AppBrandDatePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821601));
    AppMethodBeat.i(137973);
    this.ozb = true;
    this.ozc = true;
    this.ozd = true;
    this.ozk = new String[12];
    int i = 0;
    while (i < this.ozk.length)
    {
      this.ozk[i] = (i + 1);
      i += 1;
    }
    this.ozj = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.oze = ((YADatePicker.c)getUIDelegate()).QUi;
    this.ozf = ((YADatePicker.c)getUIDelegate()).QUh;
    this.ozg = ((YADatePicker.c)getUIDelegate()).QUg;
    paramContext = getResources().getDrawable(2131231090);
    f.a(this.oze, paramContext);
    f.a(this.ozf, paramContext);
    f.a(this.ozg, paramContext);
    f.d(this.oze);
    f.d(this.ozf);
    f.d(this.ozg);
    d.a(this.oze);
    d.a(this.ozf);
    d.a(this.ozg);
    paramContext = new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(137972);
        AppBrandDatePicker.a(AppBrandDatePicker.this);
        AppMethodBeat.o(137972);
      }
    };
    if (this.oze != null)
    {
      this.oze.setOnValueChangedListener(paramContext);
      this.oze.setMinValue(1900);
    }
    if (this.ozf != null) {
      this.ozf.setOnValueChangedListener(paramContext);
    }
    if (this.ozg != null) {
      this.ozg.setOnValueChangedListener(paramContext);
    }
    ccq();
    f.f(this.oze);
    f.f(this.ozf);
    f.f(this.ozg);
    AppMethodBeat.o(137973);
  }
  
  private void ccq()
  {
    int j = 0;
    AppMethodBeat.i(137974);
    if ((this.oze == null) || (this.ozf == null) || (this.ozg == null))
    {
      AppMethodBeat.o(137974);
      return;
    }
    this.ozf.setDisplayedValues(null);
    if ((this.oze.getValue() == this.oze.getMaxValue()) && (this.ozi != null))
    {
      this.ozf.setMaxValue(this.ozi.getMonth());
      if ((this.ozf.getValue() != this.ozf.getMaxValue()) || (this.ozi == null)) {
        break label333;
      }
      this.ozg.setMaxValue(this.ozi.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.oze.getValue();
        int k = this.ozf.getValue();
        this.ozj.set(i, k, 1);
        i = this.ozj.getActualMaximum(5);
        this.ozg.setMaxValue(i);
      }
      if ((this.oze.getValue() != this.oze.getMinValue()) || (this.ozh == null)) {
        break label338;
      }
      this.ozf.setMinValue(this.ozh.getMonth());
      i = j;
      if (this.ozf.getValue() == this.ozf.getMinValue())
      {
        i = j;
        if (this.ozh != null) {
          this.ozg.setMinValue(this.ozh.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.ozg.setMinValue(1);
      }
      this.ozf.setDisplayedValues((String[])Arrays.copyOfRange(this.ozk, this.ozf.getMinValue(), this.ozf.getMaxValue() + 1));
      this.oze.setWrapSelectorWheel(true);
      this.ozf.setWrapSelectorWheel(true);
      this.ozg.setWrapSelectorWheel(true);
      AppMethodBeat.o(137974);
      return;
      this.ozf.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.ozf.setMinValue(0);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(137979);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    ccq();
    AppMethodBeat.o(137979);
  }
  
  public final int getDayOfMonth()
  {
    AppMethodBeat.i(137982);
    if (this.ozg != null)
    {
      i = this.ozg.getValue();
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
    if (this.ozf != null) {}
    for (int i = this.ozf.getValue() + 1;; i = super.getMonth() + 1)
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
    if (this.oze != null)
    {
      i = this.oze.getValue();
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
    f.e(this.oze);
    f.e(this.ozf);
    f.e(this.ozg);
    AppMethodBeat.o(137977);
  }
  
  public final void onDetach(c paramc) {}
  
  public final void onHide(c paramc) {}
  
  public final void onShow(c paramc)
  {
    AppMethodBeat.i(137978);
    ccq();
    AppMethodBeat.o(137978);
  }
  
  public final void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(137975);
    super.setMaxDate(paramLong);
    this.ozi = new Date(paramLong);
    if (this.oze != null) {
      this.oze.setMaxValue(this.ozi.getYear() + 1900);
    }
    AppMethodBeat.o(137975);
  }
  
  public final void setMinDate(long paramLong)
  {
    AppMethodBeat.i(137976);
    super.setMinDate(paramLong);
    this.ozh = new Date(paramLong);
    if (this.oze != null) {
      this.oze.setMinValue(this.ozh.getYear() + 1900);
    }
    AppMethodBeat.o(137976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker
 * JD-Core Version:    0.7.0.1
 */