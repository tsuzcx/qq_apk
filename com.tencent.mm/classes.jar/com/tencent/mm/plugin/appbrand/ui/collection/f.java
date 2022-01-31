package com.tencent.mm.plugin.appbrand.ui.collection;

import a.l;
import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionItemViewLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "plugin-appbrand-integration_release"})
final class f
  extends FrameLayout
{
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135102);
    AppMethodBeat.o(135102);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135101);
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredHeight() < getMeasuredWidth()) {
      setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
    AppMethodBeat.o(135101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.f
 * JD-Core Version:    0.7.0.1
 */