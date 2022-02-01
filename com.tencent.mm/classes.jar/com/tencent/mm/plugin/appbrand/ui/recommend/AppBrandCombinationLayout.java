package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandCombinationLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getChildDrawingOrder", "", "childCount", "i", "init", "", "plugin-appbrand-integration_release"})
public final class AppBrandCombinationLayout
  extends FrameLayout
{
  public AppBrandCombinationLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51304);
    setChildrenDrawingOrderEnabled(true);
    AppMethodBeat.o(51304);
  }
  
  protected final int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandCombinationLayout
 * JD-Core Version:    0.7.0.1
 */