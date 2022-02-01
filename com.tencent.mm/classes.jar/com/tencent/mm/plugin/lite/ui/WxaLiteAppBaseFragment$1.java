package com.tencent.mm.plugin.lite.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;

final class WxaLiteAppBaseFragment$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  WxaLiteAppBaseFragment$1(WxaLiteAppBaseFragment paramWxaLiteAppBaseFragment) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(198907);
    Point localPoint = ao.az(this.yFi.getContext());
    this.yFi.yFg.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    DisplayMetrics localDisplayMetrics = this.yFi.getContext().getResources().getDisplayMetrics();
    int i = this.yFi.yFg.getWidth();
    int j = this.yFi.yFg.getHeight();
    float f1 = localDisplayMetrics.density;
    float f2 = 48.0F * f1;
    LiteAppCenter.setDisplayParams(i / f1, j / f1, localPoint.x / f1, localPoint.y / f1, localDisplayMetrics.densityDpi, f1, f2 / f1, 0.0F, 0.0F);
    Log.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "SetDisplayParams w=%d h=%d screen=%d,%d actionBar=%f densityDpi=%d density=%f", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y), Float.valueOf(f2), Integer.valueOf(localDisplayMetrics.densityDpi), Float.valueOf(localDisplayMetrics.density) });
    AppMethodBeat.o(198907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */