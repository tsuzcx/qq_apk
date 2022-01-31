package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.x;

final class a
  extends FrameLayout
{
  public a(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(77401);
    addView(paramView);
    AppMethodBeat.o(77401);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77402);
    int i = paramInt2;
    Context localContext;
    if ((getParent() instanceof View))
    {
      i = paramInt2;
      if (((View)getParent()).getMeasuredHeight() > 0)
      {
        localContext = getContext();
        if (!x.gN(getContext())) {
          break label89;
        }
      }
    }
    label89:
    for (paramInt2 = 173;; paramInt2 = 24)
    {
      paramInt2 = com.tencent.mm.cb.a.fromDPToPix(localContext, paramInt2);
      i = View.MeasureSpec.makeMeasureSpec(((View)getParent()).getMeasuredHeight() - paramInt2, -2147483648);
      super.onMeasure(paramInt1, i);
      AppMethodBeat.o(77402);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.a
 * JD-Core Version:    0.7.0.1
 */