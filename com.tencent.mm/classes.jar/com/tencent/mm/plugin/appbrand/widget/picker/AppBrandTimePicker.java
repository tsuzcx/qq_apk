package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TimePicker;
import com.tencent.luggage.b.e.a.a;
import com.tencent.luggage.b.e.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.b;
import com.tencent.mm.ui.widget.picker.f;

public final class AppBrandTimePicker
  extends TimePicker
  implements com.tencent.mm.plugin.appbrand.jsapi.v.c<String>
{
  public int mMaxTimeHour;
  public int mMaxTimeMinute;
  public int mMinTimeHour;
  public int mMinTimeMinute;
  public NumberPicker uNT;
  private NumberPicker uNU;
  
  public AppBrandTimePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, a.b.Widget_AppBrand_Picker));
    AppMethodBeat.i(138065);
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    setIs24HourView(Boolean.TRUE);
    this.uNT = ahe("mHourSpinner");
    this.uNU = ahe("mMinuteSpinner");
    com.tencent.mm.ui.widget.picker.e.d(this.uNT);
    com.tencent.mm.ui.widget.picker.e.d(this.uNU);
    d.a(this.uNT);
    d.a(this.uNU);
    paramContext = getResources().getDrawable(a.a.appbrand_picker_divider);
    com.tencent.mm.ui.widget.picker.e.a(this.uNT, paramContext);
    com.tencent.mm.ui.widget.picker.e.a(this.uNU, paramContext);
    if (this.uNT != null) {
      this.uNT.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(138064);
          AppBrandTimePicker.a(AppBrandTimePicker.this);
          AppMethodBeat.o(138064);
        }
      });
    }
    if ((this.uNU != null) && (Build.VERSION.SDK_INT >= 21)) {
      this.uNU.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2) {}
      });
    }
    com.tencent.mm.ui.widget.picker.e.f(this.uNT);
    com.tencent.mm.ui.widget.picker.e.f(this.uNU);
    AppMethodBeat.o(138065);
  }
  
  private NumberPicker ahe(String paramString)
  {
    AppMethodBeat.i(138069);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramString = ahg(paramString);
      AppMethodBeat.o(138069);
      return paramString;
    }
    paramString = ahf(paramString);
    AppMethodBeat.o(138069);
    return paramString;
  }
  
  private NumberPicker ahf(String paramString)
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
  
  private NumberPicker ahg(String paramString)
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
  
  public final void eog()
  {
    AppMethodBeat.i(138066);
    if ((e.EE(this.mMinTimeHour)) && (f.ED(this.mMinTimeMinute)) && (this.uNT != null) && (this.uNU != null))
    {
      if (this.uNT.getValue() != this.mMinTimeHour) {
        break label119;
      }
      this.uNU.setMinValue(this.mMinTimeMinute);
    }
    while ((e.EE(this.mMaxTimeHour)) && (this.uNT != null) && (this.uNU != null)) {
      if (this.uNT.getValue() == this.mMaxTimeHour)
      {
        this.uNU.setMaxValue(this.mMaxTimeMinute);
        AppMethodBeat.o(138066);
        return;
        label119:
        this.uNU.setMinValue(0);
      }
      else
      {
        this.uNU.setMaxValue(59);
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
    com.tencent.mm.ui.widget.picker.e.e(this.uNT);
    com.tencent.mm.ui.widget.picker.e.e(this.uNU);
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
      eog();
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
      eog();
      AppMethodBeat.o(138067);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker
 * JD-Core Version:    0.7.0.1
 */