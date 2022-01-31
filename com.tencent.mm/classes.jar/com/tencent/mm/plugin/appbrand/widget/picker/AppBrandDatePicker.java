package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import com.tencent.luggage.c.a.a.b;
import com.tencent.luggage.c.a.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.m.b;
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
  public boolean hzJ = true;
  public boolean hzK = true;
  public boolean hzL = true;
  public NumberPicker hzM;
  public NumberPicker hzN;
  public NumberPicker hzO;
  private Date hzP;
  private Date hzQ;
  private final Calendar hzR;
  private final String[] hzS = new String[12];
  
  @Keep
  public AppBrandDatePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, a.f.Widget_AppBrand_Picker));
    int i = 0;
    while (i < this.hzS.length)
    {
      this.hzS[i] = (i + 1);
      i += 1;
    }
    this.hzR = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.hzM = ((YADatePicker.c)getUIDelegate()).woV;
    this.hzN = ((YADatePicker.c)getUIDelegate()).woU;
    this.hzO = ((YADatePicker.c)getUIDelegate()).woT;
    paramContext = getResources().getDrawable(a.b.appbrand_picker_divider);
    com.tencent.mm.ui.widget.picker.e.a(this.hzM, paramContext);
    com.tencent.mm.ui.widget.picker.e.a(this.hzN, paramContext);
    com.tencent.mm.ui.widget.picker.e.a(this.hzO, paramContext);
    com.tencent.mm.ui.widget.picker.e.c(this.hzM);
    com.tencent.mm.ui.widget.picker.e.c(this.hzN);
    com.tencent.mm.ui.widget.picker.e.c(this.hzO);
    e.a(this.hzM);
    e.a(this.hzN);
    e.a(this.hzO);
    paramContext = new AppBrandDatePicker.1(this);
    if (this.hzM != null)
    {
      this.hzM.setOnValueChangedListener(paramContext);
      this.hzM.setMinValue(1900);
    }
    if (this.hzN != null) {
      this.hzN.setOnValueChangedListener(paramContext);
    }
    if (this.hzO != null) {
      this.hzO.setOnValueChangedListener(paramContext);
    }
    asO();
    com.tencent.mm.ui.widget.picker.e.e(this.hzM);
    com.tencent.mm.ui.widget.picker.e.e(this.hzN);
    com.tencent.mm.ui.widget.picker.e.e(this.hzO);
  }
  
  private void asO()
  {
    int j = 0;
    if ((this.hzM == null) || (this.hzN == null) || (this.hzO == null)) {
      return;
    }
    this.hzN.setDisplayedValues(null);
    if ((this.hzM.getValue() == this.hzM.getMaxValue()) && (this.hzQ != null))
    {
      this.hzN.setMaxValue(this.hzQ.getMonth());
      if ((this.hzN.getValue() != this.hzN.getMaxValue()) || (this.hzQ == null)) {
        break label318;
      }
      this.hzO.setMaxValue(this.hzQ.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.hzM.getValue();
        int k = this.hzN.getValue();
        this.hzR.set(i, k, 1);
        i = this.hzR.getActualMaximum(5);
        this.hzO.setMaxValue(i);
      }
      if ((this.hzM.getValue() != this.hzM.getMinValue()) || (this.hzP == null)) {
        break label323;
      }
      this.hzN.setMinValue(this.hzP.getMonth());
      i = j;
      if (this.hzN.getValue() == this.hzN.getMinValue())
      {
        i = j;
        if (this.hzP != null) {
          this.hzO.setMinValue(this.hzP.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.hzO.setMinValue(1);
      }
      this.hzN.setDisplayedValues((String[])Arrays.copyOfRange(this.hzS, this.hzN.getMinValue(), this.hzN.getMaxValue() + 1));
      this.hzM.setWrapSelectorWheel(true);
      this.hzN.setWrapSelectorWheel(true);
      this.hzO.setWrapSelectorWheel(true);
      return;
      this.hzN.setMaxValue(11);
      label318:
      i = 0;
      break;
      label323:
      this.hzN.setMinValue(0);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    asO();
  }
  
  public final void a(d paramd)
  {
    asO();
  }
  
  public final void ajP() {}
  
  public final void ajQ() {}
  
  public final void b(d paramd) {}
  
  public final int getDayOfMonth()
  {
    if (this.hzO != null) {
      return this.hzO.getValue();
    }
    return super.getDayOfMonth();
  }
  
  public final int getMonth()
  {
    if (this.hzN != null) {}
    for (int i = this.hzN.getValue() + 1;; i = super.getMonth() + 1) {
      return Math.max(Math.min(i, 12), 0);
    }
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final int getYear()
  {
    if (this.hzM != null) {
      return this.hzM.getValue();
    }
    return super.getYear();
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    com.tencent.mm.ui.widget.picker.e.d(this.hzM);
    com.tencent.mm.ui.widget.picker.e.d(this.hzN);
    com.tencent.mm.ui.widget.picker.e.d(this.hzO);
  }
  
  public final void setMaxDate(long paramLong)
  {
    super.setMaxDate(paramLong);
    this.hzQ = new Date(paramLong);
    if (this.hzM != null) {
      this.hzM.setMaxValue(this.hzQ.getYear() + 1900);
    }
  }
  
  public final void setMinDate(long paramLong)
  {
    super.setMinDate(paramLong);
    this.hzP = new Date(paramLong);
    if (this.hzM != null) {
      this.hzM.setMinValue(this.hzP.getYear() + 1900);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker
 * JD-Core Version:    0.7.0.1
 */