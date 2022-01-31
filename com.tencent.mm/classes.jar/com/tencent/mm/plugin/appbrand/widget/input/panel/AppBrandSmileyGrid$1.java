package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.cd.e;

final class AppBrandSmileyGrid$1
  implements AdapterView.OnItemClickListener
{
  AppBrandSmileyGrid$1(AppBrandSmileyGrid paramAppBrandSmileyGrid) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == AppBrandSmileyGrid.a(this.hxL).getCount() - 1) {
      if (AppBrandSmileyGrid.b(this.hxL).hxT != null) {
        AppBrandSmileyGrid.b(this.hxL).hxT.asj();
      }
    }
    int i;
    int j;
    do
    {
      do
      {
        return;
      } while (AppBrandSmileyGrid.c(this.hxL) * (AppBrandSmileyGrid.d(this.hxL) - 1) + paramInt >= AppBrandSmileyGrid.e(this.hxL));
      i = AppBrandSmileyGrid.c(this.hxL);
      j = AppBrandSmileyGrid.d(this.hxL);
    } while (AppBrandSmileyGrid.b(this.hxL).hxT == null);
    AppBrandSmileyGrid.b(this.hxL).hxT.append(AppBrandSmileyGrid.b(this.hxL).asu().mY(i * (j - 1) + paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyGrid.1
 * JD-Core Version:    0.7.0.1
 */