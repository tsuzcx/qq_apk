package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Keep;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandEmptyPickerView
  extends View
  implements com.tencent.mm.plugin.appbrand.jsapi.m.c<Object>
{
  @Keep
  AppBrandEmptyPickerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public Object currentValue()
  {
    return null;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void onAttach(c paramc) {}
  
  public void onDetach(c paramc) {}
  
  public void onHide(c paramc) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137991);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getResources().getDimensionPixelSize(2131166682), 1073741824));
    AppMethodBeat.o(137991);
  }
  
  public void onShow(c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandEmptyPickerView
 * JD-Core Version:    0.7.0.1
 */