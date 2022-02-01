package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.q;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class b$6
  implements AbsListView.OnScrollListener
{
  b$6(b paramb) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(22861);
    q.bcV().onScrollStateChanged(paramInt);
    if (paramInt != 2)
    {
      b.a(this.qqp, false);
      b.g(this.qqp).removeCallbacksAndMessages(null);
      b.g(this.qqp).sendEmptyMessageDelayed(0, 200L);
      AppMethodBeat.o(22861);
      return;
    }
    b.a(this.qqp, true);
    AppMethodBeat.o(22861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b.6
 * JD-Core Version:    0.7.0.1
 */