package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionItemViewLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "plugin-appbrand-integration_release"})
final class g
  extends FrameLayout
{
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51266);
    AppMethodBeat.o(51266);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51265);
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredHeight() < getMeasuredWidth()) {
      setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
    AppMethodBeat.o(51265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.g
 * JD-Core Version:    0.7.0.1
 */