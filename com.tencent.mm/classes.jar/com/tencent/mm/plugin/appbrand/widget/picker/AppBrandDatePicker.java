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
  public boolean nkm;
  public boolean nkn;
  public boolean nko;
  public NumberPicker nkp;
  public NumberPicker nkq;
  public NumberPicker nkr;
  private Date nks;
  private Date nkt;
  private final Calendar nku;
  private final String[] nkv;
  
  @Keep
  public AppBrandDatePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821553));
    AppMethodBeat.i(137973);
    this.nkm = true;
    this.nkn = true;
    this.nko = true;
    this.nkv = new String[12];
    int i = 0;
    while (i < this.nkv.length)
    {
      this.nkv[i] = (i + 1);
      i += 1;
    }
    this.nku = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.nkp = ((YADatePicker.c)getUIDelegate()).LbR;
    this.nkq = ((YADatePicker.c)getUIDelegate()).LbQ;
    this.nkr = ((YADatePicker.c)getUIDelegate()).LbP;
    paramContext = getResources().getDrawable(2131231055);
    f.a(this.nkp, paramContext);
    f.a(this.nkq, paramContext);
    f.a(this.nkr, paramContext);
    f.d(this.nkp);
    f.d(this.nkq);
    f.d(this.nkr);
    d.a(this.nkp);
    d.a(this.nkq);
    d.a(this.nkr);
    paramContext = new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(137972);
        AppBrandDatePicker.a(AppBrandDatePicker.this);
        AppMethodBeat.o(137972);
      }
    };
    if (this.nkp != null)
    {
      this.nkp.setOnValueChangedListener(paramContext);
      this.nkp.setMinValue(1900);
    }
    if (this.nkq != null) {
      this.nkq.setOnValueChangedListener(paramContext);
    }
    if (this.nkr != null) {
      this.nkr.setOnValueChangedListener(paramContext);
    }
    bFi();
    f.f(this.nkp);
    f.f(this.nkq);
    f.f(this.nkr);
    AppMethodBeat.o(137973);
  }
  
  private void bFi()
  {
    int j = 0;
    AppMethodBeat.i(137974);
    if ((this.nkp == null) || (this.nkq == null) || (this.nkr == null))
    {
      AppMethodBeat.o(137974);
      return;
    }
    this.nkq.setDisplayedValues(null);
    if ((this.nkp.getValue() == this.nkp.getMaxValue()) && (this.nkt != null))
    {
      this.nkq.setMaxValue(this.nkt.getMonth());
      if ((this.nkq.getValue() != this.nkq.getMaxValue()) || (this.nkt == null)) {
        break label333;
      }
      this.nkr.setMaxValue(this.nkt.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.nkp.getValue();
        int k = this.nkq.getValue();
        this.nku.set(i, k, 1);
        i = this.nku.getActualMaximum(5);
        this.nkr.setMaxValue(i);
      }
      if ((this.nkp.getValue() != this.nkp.getMinValue()) || (this.nks == null)) {
        break label338;
      }
      this.nkq.setMinValue(this.nks.getMonth());
      i = j;
      if (this.nkq.getValue() == this.nkq.getMinValue())
      {
        i = j;
        if (this.nks != null) {
          this.nkr.setMinValue(this.nks.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.nkr.setMinValue(1);
      }
      this.nkq.setDisplayedValues((String[])Arrays.copyOfRange(this.nkv, this.nkq.getMinValue(), this.nkq.getMaxValue() + 1));
      this.nkp.setWrapSelectorWheel(true);
      this.nkq.setWrapSelectorWheel(true);
      this.nkr.setWrapSelectorWheel(true);
      AppMethodBeat.o(137974);
      return;
      this.nkq.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.nkq.setMinValue(0);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(137979);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    bFi();
    AppMethodBeat.o(137979);
  }
  
  public final int getDayOfMonth()
  {
    AppMethodBeat.i(137982);
    if (this.nkr != null)
    {
      i = this.nkr.getValue();
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
    if (this.nkq != null) {}
    for (int i = this.nkq.getValue() + 1;; i = super.getMonth() + 1)
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
    if (this.nkp != null)
    {
      i = this.nkp.getValue();
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
    f.e(this.nkp);
    f.e(this.nkq);
    f.e(this.nkr);
    AppMethodBeat.o(137977);
  }
  
  public final void onDetach(c paramc) {}
  
  public final void onHide(c paramc) {}
  
  public final void onShow(c paramc)
  {
    AppMethodBeat.i(137978);
    bFi();
    AppMethodBeat.o(137978);
  }
  
  public final void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(137975);
    super.setMaxDate(paramLong);
    this.nkt = new Date(paramLong);
    if (this.nkp != null) {
      this.nkp.setMaxValue(this.nkt.getYear() + 1900);
    }
    AppMethodBeat.o(137975);
  }
  
  public final void setMinDate(long paramLong)
  {
    AppMethodBeat.i(137976);
    super.setMinDate(paramLong);
    this.nks = new Date(paramLong);
    if (this.nkp != null) {
      this.nkp.setMinValue(this.nks.getYear() + 1900);
    }
    AppMethodBeat.o(137976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker
 * JD-Core Version:    0.7.0.1
 */