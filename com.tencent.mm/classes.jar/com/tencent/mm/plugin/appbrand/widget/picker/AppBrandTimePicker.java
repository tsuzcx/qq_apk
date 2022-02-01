package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TimePicker;
import androidx.annotation.Keep;
import com.tencent.luggage.b.e.a.a;
import com.tencent.luggage.b.e.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.b;
import com.tencent.mm.ui.widget.picker.f;

public final class AppBrandTimePicker
  extends TimePicker
  implements com.tencent.mm.plugin.appbrand.jsapi.s.c<String>
{
  public int mMaxTimeHour;
  public int mMaxTimeMinute;
  public int mMinTimeHour;
  public int mMinTimeMinute;
  public NumberPicker rCC;
  private NumberPicker rCD;
  
  @Keep
  public AppBrandTimePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, a.b.Widget_AppBrand_Picker));
    AppMethodBeat.i(138065);
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    setIs24HourView(Boolean.TRUE);
    this.rCC = anG("mHourSpinner");
    this.rCD = anG("mMinuteSpinner");
    com.tencent.mm.ui.widget.picker.e.d(this.rCC);
    com.tencent.mm.ui.widget.picker.e.d(this.rCD);
    d.a(this.rCC);
    d.a(this.rCD);
    paramContext = getResources().getDrawable(a.a.appbrand_picker_divider);
    com.tencent.mm.ui.widget.picker.e.a(this.rCC, paramContext);
    com.tencent.mm.ui.widget.picker.e.a(this.rCD, paramContext);
    if (this.rCC != null) {
      this.rCC.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(138064);
          AppBrandTimePicker.a(AppBrandTimePicker.this);
          AppMethodBeat.o(138064);
        }
      });
    }
    if ((this.rCD != null) && (Build.VERSION.SDK_INT >= 21)) {
      this.rCD.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2) {}
      });
    }
    com.tencent.mm.ui.widget.picker.e.f(this.rCC);
    com.tencent.mm.ui.widget.picker.e.f(this.rCD);
    AppMethodBeat.o(138065);
  }
  
  private NumberPicker anG(String paramString)
  {
    AppMethodBeat.i(138069);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramString = anI(paramString);
      AppMethodBeat.o(138069);
      return paramString;
    }
    paramString = anH(paramString);
    AppMethodBeat.o(138069);
    return paramString;
  }
  
  private NumberPicker anH(String paramString)
  {
    AppMethodBeat.i(138070);
    try
    {
      paramString = (NumberPicker)new b(this, paramString, null).get();
      AppMethodBeat.o(138070);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(138070);
    }
    return null;
  }
  
  private NumberPicker anI(String paramString)
  {
    AppMethodBeat.i(138071);
    try
    {
      Object localObject = new b(this, "mDelegate", null).get();
      if (localObject != null)
      {
        paramString = (NumberPicker)new b(localObject, paramString, null).get();
        AppMethodBeat.o(138071);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(138071);
    }
    return null;
  }
  
  public final void cpN()
  {
    AppMethodBeat.i(138066);
    if ((e.Ee(this.mMinTimeHour)) && (f.Ed(this.mMinTimeMinute)) && (this.rCC != null) && (this.rCD != null))
    {
      if (this.rCC.getValue() != this.mMinTimeHour) {
        break label119;
      }
      this.rCD.setMinValue(this.mMinTimeMinute);
    }
    while ((e.Ee(this.mMaxTimeHour)) && (this.rCC != null) && (this.rCD != null)) {
      if (this.rCC.getValue() == this.mMaxTimeHour)
      {
        this.rCD.setMaxValue(this.mMaxTimeMinute);
        AppMethodBeat.o(138066);
        return;
        label119:
        this.rCD.setMinValue(0);
      }
      else
      {
        this.rCD.setMaxValue(59);
      }
    }
    AppMethodBeat.o(138066);
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void onAttach(c paramc) {}
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(138072);
    super.onAttachedToWindow();
    com.tencent.mm.ui.widget.picker.e.e(this.rCC);
    com.tencent.mm.ui.widget.picker.e.e(this.rCD);
    AppMethodBeat.o(138072);
  }
  
  public final void onDetach(c paramc) {}
  
  public final void onHide(c paramc) {}
  
  public final void onShow(c paramc) {}
  
  public final void setCurrentHour(Integer paramInteger)
  {
    AppMethodBeat.i(138068);
    if (paramInteger == null) {}
    for (int i = 0;; i = paramInteger.intValue())
    {
      super.setCurrentHour(Integer.valueOf(i));
      cpN();
      AppMethodBeat.o(138068);
      return;
    }
  }
  
  public final void setCurrentMinute(Integer paramInteger)
  {
    AppMethodBeat.i(138067);
    if (paramInteger == null) {}
    for (int i = 0;; i = paramInteger.intValue())
    {
      super.setCurrentMinute(Integer.valueOf(i));
      cpN();
      AppMethodBeat.o(138067);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker
 * JD-Core Version:    0.7.0.1
 */