package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Keep;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class AppBrandOptionsPickerV2
  extends YANumberPicker
  implements com.tencent.mm.plugin.appbrand.jsapi.r.c<String>
{
  private String[] ozA;
  private int ozC;
  
  @Keep
  public AppBrandOptionsPickerV2(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138026);
    setDividerHeight(a.fromDPToPix(paramContext, 2));
    setDividerColor(Color.parseColor("#1AAD19"));
    setItemPaddingVertical(a.fromDPToPix(paramContext, 8));
    setNormalTextColor(Color.parseColor("#A5A5A5"));
    setSelectedTextColor(-16777216);
    AppMethodBeat.o(138026);
  }
  
  public final View getView()
  {
    return this;
  }
  
  public void onAttach(c paramc) {}
  
  public void onDetach(c paramc) {}
  
  public void onHide(c paramc)
  {
    AppMethodBeat.i(138029);
    ccG();
    AppMethodBeat.o(138029);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138028);
    if (this.ozC > 0) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(this.ozC, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(138028);
  }
  
  public void onShow(c paramc) {}
  
  public final void setForceWidth(int paramInt)
  {
    this.ozC = paramInt;
  }
  
  public final void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(138027);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      setEnabled(false);
      setVisibility(4);
      AppMethodBeat.o(138027);
      return;
    }
    setEnabled(true);
    setVisibility(0);
    this.ozA = paramArrayOfString;
    int i = getMinValue();
    int j = getMaxValue();
    int k = paramArrayOfString.length - 1;
    if (k - i + 1 > j - i + 1)
    {
      setDisplayedValues(paramArrayOfString);
      setMaxValue(k);
      AppMethodBeat.o(138027);
      return;
    }
    setMaxValue(k);
    setDisplayedValues(paramArrayOfString);
    AppMethodBeat.o(138027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV2
 * JD-Core Version:    0.7.0.1
 */