package com.tencent.mm.plugin.appbrand;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.r;

final class i$8
  implements ViewGroup.OnHierarchyChangeListener
{
  i$8(i parami, View paramView) {}
  
  public final void onChildViewAdded(View paramView1, View paramView2) {}
  
  public final void onChildViewRemoved(View paramView1, View paramView2)
  {
    AppMethodBeat.i(86660);
    if ((paramView2 == this.gQi) && (!this.gPY.mFinished)) {
      this.gPY.atj().setActuallyVisible(true);
    }
    AppMethodBeat.o(86660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.8
 * JD-Core Version:    0.7.0.1
 */