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
import com.tencent.luggage.c.c.a.b;
import com.tencent.luggage.c.c.a.e;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.plugin.appbrand.jsapi.m.b;

public final class AppBrandTimePicker
  extends TimePicker
  implements b<String>
{
  public int gAa = -1;
  public int gzX = -1;
  public int gzY = -1;
  public int gzZ = -1;
  public NumberPicker hAo;
  private NumberPicker hAp;
  
  @Keep
  public AppBrandTimePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, a.e.Widget_AppBrand_Picker));
    setIs24HourView(Boolean.valueOf(true));
    this.hAo = xf("mHourSpinner");
    this.hAp = xf("mMinuteSpinner");
    com.tencent.mm.ui.widget.picker.e.c(this.hAo);
    com.tencent.mm.ui.widget.picker.e.c(this.hAp);
    e.a(this.hAo);
    e.a(this.hAp);
    paramContext = getResources().getDrawable(a.b.appbrand_picker_divider);
    com.tencent.mm.ui.widget.picker.e.a(this.hAo, paramContext);
    com.tencent.mm.ui.widget.picker.e.a(this.hAp, paramContext);
    if (this.hAo != null) {
      this.hAo.setOnValueChangedListener(new AppBrandTimePicker.1(this));
    }
    if ((this.hAp != null) && (Build.VERSION.SDK_INT >= 21)) {
      this.hAp.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2) {}
      });
    }
    com.tencent.mm.ui.widget.picker.e.e(this.hAo);
    com.tencent.mm.ui.widget.picker.e.e(this.hAp);
  }
  
  private NumberPicker xf(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return xh(paramString);
    }
    return xg(paramString);
  }
  
  private NumberPicker xg(String paramString)
  {
    try
    {
      paramString = (NumberPicker)new c(this, paramString, null).get();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private NumberPicker xh(String paramString)
  {
    try
    {
      Object localObject = new c(this, "mDelegate", null).get();
      if (localObject != null)
      {
        paramString = (NumberPicker)new c(localObject, paramString, null).get();
        return paramString;
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public final void a(d paramd) {}
  
  public final void ajP() {}
  
  public final void ajQ() {}
  
  public final void asR()
  {
    if ((f.ne(this.gzX)) && (com.tencent.mm.ui.widget.picker.f.nd(this.gzY)) && (this.hAo != null) && (this.hAp != null))
    {
      if (this.hAo.getValue() != this.gzX) {
        break label109;
      }
      this.hAp.setMinValue(this.gzY);
    }
    for (;;)
    {
      if ((f.ne(this.gzZ)) && (this.hAo != null) && (this.hAp != null))
      {
        if (this.hAo.getValue() != this.gzZ) {
          break;
        }
        this.hAp.setMaxValue(this.gAa);
      }
      return;
      label109:
      this.hAp.setMinValue(0);
    }
    this.hAp.setMaxValue(59);
  }
  
  public final void b(d paramd) {}
  
  public final View getView()
  {
    return this;
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    com.tencent.mm.ui.widget.picker.e.d(this.hAo);
    com.tencent.mm.ui.widget.picker.e.d(this.hAp);
  }
  
  public final void setCurrentHour(Integer paramInteger)
  {
    if (paramInteger == null) {}
    for (int i = 0;; i = paramInteger.intValue())
    {
      super.setCurrentHour(Integer.valueOf(i));
      asR();
      return;
    }
  }
  
  public final void setCurrentMinute(Integer paramInteger)
  {
    if (paramInteger == null) {}
    for (int i = 0;; i = paramInteger.intValue())
    {
      super.setCurrentMinute(Integer.valueOf(i));
      asR();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker
 * JD-Core Version:    0.7.0.1
 */