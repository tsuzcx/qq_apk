package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.b.a.a.b;
import com.tencent.luggage.b.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.f.b;
import java.util.Arrays;

public class AppBrandOptionsPickerV3
  implements com.tencent.mm.plugin.appbrand.jsapi.v.c<String>
{
  private Context context;
  private int uNA;
  public int uNB;
  private String[] uNw;
  public b<String> uNz;
  
  public AppBrandOptionsPickerV3(Context paramContext)
  {
    AppMethodBeat.i(138032);
    this.context = paramContext;
    this.uNz = new b(paramContext);
    AppMethodBeat.o(138032);
  }
  
  private void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(138035);
    this.uNz.pzu.setDividerColor(paramInt);
    AppMethodBeat.o(138035);
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(138038);
    this.uNz.bTe();
    String str = this.uNw[this.uNA];
    AppMethodBeat.o(138038);
    return str;
  }
  
  public final int getValue()
  {
    AppMethodBeat.i(138036);
    this.uNz.bTe();
    int i = this.uNA;
    AppMethodBeat.o(138036);
    return i;
  }
  
  public final void init()
  {
    AppMethodBeat.i(138034);
    new com.tencent.mm.picker.b.a(this.context, new com.tencent.mm.picker.d.d()
    {
      public final void xY(int paramAnonymousInt)
      {
        AppMethodBeat.i(138031);
        AppBrandOptionsPickerV3.a(AppBrandOptionsPickerV3.this, paramAnonymousInt);
        AppMethodBeat.o(138031);
      }
    }).xU(this.uNB).xT(androidx.core.content.a.w(this.context, a.b.BW_0_Alpha_0_1)).a(this.uNz);
    setDividerHeight(this.context.getResources().getDimensionPixelSize(a.c.bottomsheet_dividing_line_height));
    this.context.getResources().getDimensionPixelSize(a.c.picker_item_height);
    setDividerColor(androidx.core.content.a.w(this.context, a.b.BW_0_Alpha_0_1));
    this.uNz.pzu.eV(this.context.getResources().getDimensionPixelSize(a.c.Edge_2A), this.context.getResources().getDimensionPixelSize(a.c.Edge_2A));
    this.uNz.pzu.pzz.xS(androidx.core.content.a.w(this.context, a.b.BW_0_Alpha_0_9)).xR(this.context.getResources().getDimensionPixelSize(a.c.Edge_2A)).setBackgroundColor(androidx.core.content.a.w(this.context, a.b.BG_5));
    AppMethodBeat.o(138034);
  }
  
  public void onAttach(c paramc) {}
  
  public void onDetach(c paramc) {}
  
  public void onHide(c paramc) {}
  
  public void onShow(c paramc) {}
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(138037);
    this.uNz.setDividerHeight(paramFloat);
    AppMethodBeat.o(138037);
  }
  
  public final void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(138033);
    this.uNw = paramArrayOfString;
    this.uNz.cr(Arrays.asList(paramArrayOfString));
    AppMethodBeat.o(138033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3
 * JD-Core Version:    0.7.0.1
 */