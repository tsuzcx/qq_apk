package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$a$1
  extends View
{
  e$a$1(e.a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(123947);
    this.jqm.mInLayout = true;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jqm.mInLayout = false;
    AppMethodBeat.o(123947);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123948);
    if (this.jqm.jlY > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.jqm.jlY, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(123948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.e.a.1
 * JD-Core Version:    0.7.0.1
 */