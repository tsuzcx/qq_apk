package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.ak;

final class b$6
  implements AbsListView.OnScrollListener
{
  b$6(b paramb) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(18751);
    o.ahG().bX(paramInt);
    if (paramInt != 2)
    {
      b.a(this.kHM, false);
      b.g(this.kHM).removeCallbacksAndMessages(null);
      b.g(this.kHM).sendEmptyMessageDelayed(0, 200L);
      AppMethodBeat.o(18751);
      return;
    }
    b.a(this.kHM, true);
    AppMethodBeat.o(18751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b.6
 * JD-Core Version:    0.7.0.1
 */