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
  implements com.tencent.mm.plugin.appbrand.jsapi.n.c<String>
{
  private Context context;
  private String[] mip;
  public com.tencent.mm.picker.f.b<String> mis;
  private int mit;
  public int miu;
  
  @Keep
  public AppBrandOptionsPickerV3(Context paramContext)
  {
    AppMethodBeat.i(138032);
    this.context = paramContext;
    this.mis = new com.tencent.mm.picker.f.b(paramContext);
    AppMethodBeat.o(138032);
  }
  
  private void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(138035);
    this.mis.hSS.setDividerColor(paramInt);
    AppMethodBeat.o(138035);
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(138038);
    this.mis.aGe();
    String str = this.mip[this.mit];
    AppMethodBeat.o(138038);
    return str;
  }
  
  public final int getValue()
  {
    AppMethodBeat.i(138036);
    this.mis.aGe();
    int i = this.mit;
    AppMethodBeat.o(138036);
    return i;
  }
  
  public final void init()
  {
    AppMethodBeat.i(138034);
    new a(this.context, new com.tencent.mm.picker.d.c()
    {
      public final void pH(int paramAnonymousInt)
      {
        AppMethodBeat.i(138031);
        AppBrandOptionsPickerV3.a(AppBrandOptionsPickerV3.this, paramAnonymousInt);
        AppMethodBeat.o(138031);
      }
    }).pF(this.miu).pE(android.support.v4.content.b.n(this.context, 2131099656)).a(this.mis);
    setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165923));
    this.context.getResources().getDimensionPixelSize(2131166681);
    setDividerColor(android.support.v4.content.b.n(this.context, 2131099656));
    this.mis.hSS.ds(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
    this.mis.hSS.hSW.pD(android.support.v4.content.b.n(this.context, 2131099664)).pC(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
    AppMethodBeat.o(138034);
  }
  
  public void onAttach(c paramc) {}
  
  public void onDetach(c paramc) {}
  
  public void onHide(c paramc) {}
  
  public void onShow(c paramc) {}
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(138037);
    this.mis.setDividerHeight(paramFloat);
    AppMethodBeat.o(138037);
  }
  
  public final void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(138033);
    this.mip = paramArrayOfString;
    this.mis.aI(Arrays.asList(paramArrayOfString));
    AppMethodBeat.o(138033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3
 * JD-Core Version:    0.7.0.1
 */