package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.e;

final class AppBrandSmileyGrid$1
  implements AdapterView.OnItemClickListener
{
  AppBrandSmileyGrid$1(AppBrandSmileyGrid paramAppBrandSmileyGrid) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(134307);
    if (paramInt == AppBrandSmileyGrid.a(this.jpV).getCount() - 1)
    {
      if (AppBrandSmileyGrid.b(this.jpV).jqd != null) {
        AppBrandSmileyGrid.b(this.jpV).jqd.aRo();
      }
      AppMethodBeat.o(134307);
      return;
    }
    if (AppBrandSmileyGrid.c(this.jpV) * (AppBrandSmileyGrid.d(this.jpV) - 1) + paramInt >= AppBrandSmileyGrid.e(this.jpV))
    {
      AppMethodBeat.o(134307);
      return;
    }
    int i = AppBrandSmileyGrid.c(this.jpV);
    int j = AppBrandSmileyGrid.d(this.jpV);
    if (AppBrandSmileyGrid.b(this.jpV).jqd != null) {
      AppBrandSmileyGrid.b(this.jpV).jqd.append(AppBrandSmileyGrid.b(this.jpV).aRy().qC(i * (j - 1) + paramInt));
    }
    AppMethodBeat.o(134307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid.1
 * JD-Core Version:    0.7.0.1
 */