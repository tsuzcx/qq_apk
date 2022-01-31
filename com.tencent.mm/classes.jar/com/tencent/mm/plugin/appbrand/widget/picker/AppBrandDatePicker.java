package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.n.b;
import com.tencent.mm.ui.widget.picker.YADatePicker;
import com.tencent.mm.ui.widget.picker.YADatePicker.c;
import com.tencent.mm.ui.widget.picker.YADatePicker.d;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class AppBrandDatePicker
  extends YADatePicker
  implements b<String>
{
  public boolean jrZ;
  public boolean jsa;
  public boolean jsb;
  public NumberPicker jsc;
  public NumberPicker jsd;
  public NumberPicker jse;
  private Date jsf;
  private Date jsg;
  private final Calendar jsh;
  private final String[] jsi;
  
  @Keep
  public AppBrandDatePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131493756));
    AppMethodBeat.i(126690);
    this.jrZ = true;
    this.jsa = true;
    this.jsb = true;
    this.jsi = new String[12];
    int i = 0;
    while (i < this.jsi.length)
    {
      this.jsi[i] = (i + 1);
      i += 1;
    }
    this.jsh = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.jsc = ((YADatePicker.c)getUIDelegate()).AJv;
    this.jsd = ((YADatePicker.c)getUIDelegate()).AJu;
    this.jse = ((YADatePicker.c)getUIDelegate()).AJt;
    paramContext = getResources().getDrawable(2130837801);
    com.tencent.mm.ui.widget.picker.e.a(this.jsc, paramContext);
    com.tencent.mm.ui.widget.picker.e.a(this.jsd, paramContext);
    com.tencent.mm.ui.widget.picker.e.a(this.jse, paramContext);
    com.tencent.mm.ui.widget.picker.e.c(this.jsc);
    com.tencent.mm.ui.widget.picker.e.c(this.jsd);
    com.tencent.mm.ui.widget.picker.e.c(this.jse);
    e.a(this.jsc);
    e.a(this.jsd);
    e.a(this.jse);
    paramContext = new AppBrandDatePicker.1(this);
    if (this.jsc != null)
    {
      this.jsc.setOnValueChangedListener(paramContext);
      this.jsc.setMinValue(1900);
    }
    if (this.jsd != null) {
      this.jsd.setOnValueChangedListener(paramContext);
    }
    if (this.jse != null) {
      this.jse.setOnValueChangedListener(paramContext);
    }
    aRQ();
    com.tencent.mm.ui.widget.picker.e.e(this.jsc);
    com.tencent.mm.ui.widget.picker.e.e(this.jsd);
    com.tencent.mm.ui.widget.picker.e.e(this.jse);
    AppMethodBeat.o(126690);
  }
  
  private void aRQ()
  {
    int j = 0;
    AppMethodBeat.i(126691);
    if ((this.jsc == null) || (this.jsd == null) || (this.jse == null))
    {
      AppMethodBeat.o(126691);
      return;
    }
    this.jsd.setDisplayedValues(null);
    if ((this.jsc.getValue() == this.jsc.getMaxValue()) && (this.jsg != null))
    {
      this.jsd.setMaxValue(this.jsg.getMonth());
      if ((this.jsd.getValue() != this.jsd.getMaxValue()) || (this.jsg == null)) {
        break label333;
      }
      this.jse.setMaxValue(this.jsg.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.jsc.getValue();
        int k = this.jsd.getValue();
        this.jsh.set(i, k, 1);
        i = this.jsh.getActualMaximum(5);
        this.jse.setMaxValue(i);
      }
      if ((this.jsc.getValue() != this.jsc.getMinValue()) || (this.jsf == null)) {
        break label338;
      }
      this.jsd.setMinValue(this.jsf.getMonth());
      i = j;
      if (this.jsd.getValue() == this.jsd.getMinValue())
      {
        i = j;
        if (this.jsf != null) {
          this.jse.setMinValue(this.jsf.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.jse.setMinValue(1);
      }
      this.jsd.setDisplayedValues((String[])Arrays.copyOfRange(this.jsi, this.jsd.getMinValue(), this.jsd.getMaxValue() + 1));
      this.jsc.setWrapSelectorWheel(true);
      this.jsd.setWrapSelectorWheel(true);
      this.jse.setWrapSelectorWheel(true);
      AppMethodBeat.o(126691);
      return;
      this.jsd.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.jsd.setMinValue(0);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(126696);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    aRQ();
    AppMethodBeat.o(126696);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(126695);
    aRQ();
    AppMethodBeat.o(126695);
  }
  
  public final void aEs() {}
  
  public final void aEt() {}
  
  public final void b(d paramd) {}
  
  public final int getDayOfMonth()
  {
    AppMethodBeat.i(126699);
    if (this.jse != null)
    {
      i = this.jse.getValue();
      AppMethodBeat.o(126699);
      return i;
    }
    int i = super.getDayOfMonth();
    AppMethodBeat.o(126699);
    return i;
  }
  
  public final int getMonth()
  {
    AppMethodBeat.i(126698);
    if (this.jsd != null) {}
    for (int i = this.jsd.getValue() + 1;; i = super.getMonth() + 1)
    {
      i = Math.max(Math.min(i, 12), 0);
      AppMethodBeat.o(126698);
      return i;
    }
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final int getYear()
  {
    AppMethodBeat.i(126697);
    if (this.jsc != null)
    {
      i = this.jsc.getValue();
      AppMethodBeat.o(126697);
      return i;
    }
    int i = super.getYear();
    AppMethodBeat.o(126697);
    return i;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(126694);
    super.onAttachedToWindow();
    com.tencent.mm.ui.widget.picker.e.d(this.jsc);
    com.tencent.mm.ui.widget.picker.e.d(this.jsd);
    com.tencent.mm.ui.widget.picker.e.d(this.jse);
    AppMethodBeat.o(126694);
  }
  
  public final void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(126692);
    super.setMaxDate(paramLong);
    this.jsg = new Date(paramLong);
    if (this.jsc != null) {
      this.jsc.setMaxValue(this.jsg.getYear() + 1900);
    }
    AppMethodBeat.o(126692);
  }
  
  public final void setMinDate(long paramLong)
  {
    AppMethodBeat.i(126693);
    super.setMinDate(paramLong);
    this.jsf = new Date(paramLong);
    if (this.jsc != null) {
      this.jsc.setMinValue(this.jsf.getYear() + 1900);
    }
    AppMethodBeat.o(126693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker
 * JD-Core Version:    0.7.0.1
 */