package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.f;
import com.tencent.mm.ui.widget.picker.g;

public final class AppBrandTimePicker
  extends TimePicker
  implements com.tencent.mm.plugin.appbrand.jsapi.r.c<String>
{
  public int mMaxTimeHour;
  public int mMaxTimeMinute;
  public int mMinTimeHour;
  public int mMinTimeMinute;
  public NumberPicker ozT;
  private NumberPicker ozU;
  
  @Keep
  public AppBrandTimePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821601));
    AppMethodBeat.i(138065);
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    setIs24HourView(Boolean.TRUE);
    this.ozT = agd("mHourSpinner");
    this.ozU = agd("mMinuteSpinner");
    f.d(this.ozT);
    f.d(this.ozU);
    d.a(this.ozT);
    d.a(this.ozU);
    paramContext = getResources().getDrawable(2131231090);
    f.a(this.ozT, paramContext);
    f.a(this.ozU, paramContext);
    if (this.ozT != null) {
      this.ozT.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(138064);
          AppBrandTimePicker.a(AppBrandTimePicker.this);
          AppMethodBeat.o(138064);
        }
      });
    }
    if ((this.ozU != null) && (Build.VERSION.SDK_INT >= 21)) {
      this.ozU.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2) {}
      });
    }
    f.f(this.ozT);
    f.f(this.ozU);
    AppMethodBeat.o(138065);
  }
  
  private NumberPicker agd(String paramString)
  {
    AppMethodBeat.i(138069);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramString = agf(paramString);
      AppMethodBeat.o(138069);
      return paramString;
    }
    paramString = age(paramString);
    AppMethodBeat.o(138069);
    return paramString;
  }
  
  private NumberPicker age(String paramString)
  {
    AppMethodBeat.i(138070);
    try
    {
      paramString = (NumberPicker)new com.tencent.mm.compatible.loader.c(this, paramString, null).get();
      AppMethodBeat.o(138070);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(138070);
    }
    return null;
  }
  
  private NumberPicker agf(String paramString)
  {
    AppMethodBeat.i(138071);
    try
    {
      Object localObject = new com.tencent.mm.compatible.loader.c(this, "mDelegate", null).get();
      if (localObject != null)
      {
        paramString = (NumberPicker)new com.tencent.mm.compatible.loader.c(localObject, paramString, null).get();
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
  
  public final void dRg()
  {
    AppMethodBeat.i(138066);
    if ((e.Ax(this.mMinTimeHour)) && (g.Aw(this.mMinTimeMinute)) && (this.ozT != null) && (this.ozU != null))
    {
      if (this.ozT.getValue() != this.mMinTimeHour) {
        break label119;
      }
      this.ozU.setMinValue(this.mMinTimeMinute);
    }
    while ((e.Ax(this.mMaxTimeHour)) && (this.ozT != null) && (this.ozU != null)) {
      if (this.ozT.getValue() == this.mMaxTimeHour)
      {
        this.ozU.setMaxValue(this.mMaxTimeMinute);
        AppMethodBeat.o(138066);
        return;
        label119:
        this.ozU.setMinValue(0);
      }
      else
      {
        this.ozU.setMaxValue(59);
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
    f.e(this.ozT);
    f.e(this.ozU);
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
      dRg();
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
      dRg();
      AppMethodBeat.o(138067);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker
 * JD-Core Version:    0.7.0.1
 */