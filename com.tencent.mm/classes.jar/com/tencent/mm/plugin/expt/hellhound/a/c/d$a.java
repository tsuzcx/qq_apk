package com.tencent.mm.plugin.expt.hellhound.a.c;

import android.app.Activity;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a
  implements AbsListView.OnScrollListener
{
  Activity activity;
  
  private d$a(d paramd) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(73467);
    if (d.a(this.mbI) != null) {
      d.a(this.mbI).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    d.c(this.mbI, paramAbsListView);
    d.b(this.mbI, paramInt2);
    d.a(this.mbI, this.activity, paramAbsListView, paramInt2);
    AppMethodBeat.o(73467);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(73466);
    if (d.a(this.mbI) != null) {
      d.a(this.mbI).onScrollStateChanged(paramAbsListView, paramInt);
    }
    d.a(this.mbI, paramInt);
    if (paramInt == 1)
    {
      d.a(this.mbI, paramAbsListView);
      AppMethodBeat.o(73466);
      return;
    }
    if (paramInt == 2)
    {
      d.b(this.mbI, paramAbsListView);
      AppMethodBeat.o(73466);
      return;
    }
    if (paramInt == 0) {
      d.b(this.mbI);
    }
    AppMethodBeat.o(73466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.d.a
 * JD-Core Version:    0.7.0.1
 */