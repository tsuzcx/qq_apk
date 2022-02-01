package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.b.a;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.f.d;
import java.util.Arrays;

public class AppBrandOptionsPickerV3
  implements com.tencent.mm.plugin.appbrand.jsapi.p.c<String>
{
  private Context context;
  private String[] npT;
  public com.tencent.mm.picker.f.b<String> npW;
  private int npX;
  public int npY;
  
  @Keep
  public AppBrandOptionsPickerV3(Context paramContext)
  {
    AppMethodBeat.i(138032);
    this.context = paramContext;
    this.npW = new com.tencent.mm.picker.f.b(paramContext);
    AppMethodBeat.o(138032);
  }
  
  private void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(138035);
    this.npW.iOT.setDividerColor(paramInt);
    AppMethodBeat.o(138035);
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(138038);
    this.npW.aQB();
    String str = this.npT[this.npX];
    AppMethodBeat.o(138038);
    return str;
  }
  
  public final int getValue()
  {
    AppMethodBeat.i(138036);
    this.npW.aQB();
    int i = this.npX;
    AppMethodBeat.o(138036);
    return i;
  }
  
  public final void init()
  {
    AppMethodBeat.i(138034);
    new a(this.context, new com.tencent.mm.picker.d.c()
    {
      public final void qX(int paramAnonymousInt)
      {
        AppMethodBeat.i(138031);
        AppBrandOptionsPickerV3.a(AppBrandOptionsPickerV3.this, paramAnonymousInt);
        AppMethodBeat.o(138031);
      }
    }).qV(this.npY).qU(android.support.v4.content.b.n(this.context, 2131099656)).a(this.npW);
    setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165923));
    this.context.getResources().getDimensionPixelSize(2131166681);
    setDividerColor(android.support.v4.content.b.n(this.context, 2131099656));
    this.npW.iOT.du(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
    this.npW.iOT.iOX.qT(android.support.v4.content.b.n(this.context, 2131099664)).qS(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
    AppMethodBeat.o(138034);
  }
  
  public void onAttach(c paramc) {}
  
  public void onDetach(c paramc) {}
  
  public void onHide(c paramc) {}
  
  public void onShow(c paramc) {}
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(138037);
    this.npW.setDividerHeight(paramFloat);
    AppMethodBeat.o(138037);
  }
  
  public final void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(138033);
    this.npT = paramArrayOfString;
    this.npW.aG(Arrays.asList(paramArrayOfString));
    AppMethodBeat.o(138033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3
 * JD-Core Version:    0.7.0.1
 */