package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.plugin.appbrand.jsapi.n.b;

public final class AppBrandTimePicker
  extends TimePicker
  implements b<String>
{
  public int hWY;
  public int hWZ;
  public int hXa;
  public int hXb;
  public NumberPicker jsD;
  private NumberPicker jsE;
  
  @Keep
  public AppBrandTimePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131493756));
    AppMethodBeat.i(126742);
    this.hWY = -1;
    this.hWZ = -1;
    this.hXa = -1;
    this.hXb = -1;
    setIs24HourView(Boolean.TRUE);
    this.jsD = FS("mHourSpinner");
    this.jsE = FS("mMinuteSpinner");
    com.tencent.mm.ui.widget.picker.e.c(this.jsD);
    com.tencent.mm.ui.widget.picker.e.c(this.jsE);
    e.a(this.jsD);
    e.a(this.jsE);
    paramContext = getResources().getDrawable(2130837801);
    com.tencent.mm.ui.widget.picker.e.a(this.jsD, paramContext);
    com.tencent.mm.ui.widget.picker.e.a(this.jsE, paramContext);
    if (this.jsD != null) {
      this.jsD.setOnValueChangedListener(new AppBrandTimePicker.1(this));
    }
    if ((this.jsE != null) && (Build.VERSION.SDK_INT >= 21)) {
      this.jsE.setOnValueChangedListener(new AppBrandTimePicker.2(this));
    }
    com.tencent.mm.ui.widget.picker.e.e(this.jsD);
    com.tencent.mm.ui.widget.picker.e.e(this.jsE);
    AppMethodBeat.o(126742);
  }
  
  private NumberPicker FS(String paramString)
  {
    AppMethodBeat.i(126746);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramString = FU(paramString);
      AppMethodBeat.o(126746);
      return paramString;
    }
    paramString = FT(paramString);
    AppMethodBeat.o(126746);
    return paramString;
  }
  
  private NumberPicker FT(String paramString)
  {
    AppMethodBeat.i(126747);
    try
    {
      paramString = (NumberPicker)new c(this, paramString, null).get();
      AppMethodBeat.o(126747);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(126747);
    }
    return null;
  }
  
  private NumberPicker FU(String paramString)
  {
    AppMethodBeat.i(126748);
    try
    {
      Object localObject = new c(this, "mDelegate", null).get();
      if (localObject != null)
      {
        paramString = (NumberPicker)new c(localObject, paramString, null).get();
        AppMethodBeat.o(126748);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(126748);
    }
    return null;
  }
  
  public final void a(d paramd) {}
  
  public final void aEs() {}
  
  public final void aEt() {}
  
  public final void aRT()
  {
    AppMethodBeat.i(126743);
    if ((f.qL(this.hWY)) && (com.tencent.mm.ui.widget.picker.f.qK(this.hWZ)) && (this.jsD != null) && (this.jsE != null))
    {
      if (this.jsD.getValue() != this.hWY) {
        break label119;
      }
      this.jsE.setMinValue(this.hWZ);
    }
    while ((f.qL(this.hXa)) && (this.jsD != null) && (this.jsE != null)) {
      if (this.jsD.getValue() == this.hXa)
      {
        this.jsE.setMaxValue(this.hXb);
        AppMethodBeat.o(126743);
        return;
        label119:
        this.jsE.setMinValue(0);
      }
      else
      {
        this.jsE.setMaxValue(59);
      }
    }
    AppMethodBeat.o(126743);
  }
  
  public final void b(d paramd) {}
  
  public final View getView()
  {
    return this;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(126749);
    super.onAttachedToWindow();
    com.tencent.mm.ui.widget.picker.e.d(this.jsD);
    com.tencent.mm.ui.widget.picker.e.d(this.jsE);
    AppMethodBeat.o(126749);
  }
  
  public final void setCurrentHour(Integer paramInteger)
  {
    AppMethodBeat.i(126745);
    if (paramInteger == null) {}
    for (int i = 0;; i = paramInteger.intValue())
    {
      super.setCurrentHour(Integer.valueOf(i));
      aRT();
      AppMethodBeat.o(126745);
      return;
    }
  }
  
  public final void setCurrentMinute(Integer paramInteger)
  {
    AppMethodBeat.i(126744);
    if (paramInteger == null) {}
    for (int i = 0;; i = paramInteger.intValue())
    {
      super.setCurrentMinute(Integer.valueOf(i));
      aRT();
      AppMethodBeat.o(126744);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker
 * JD-Core Version:    0.7.0.1
 */