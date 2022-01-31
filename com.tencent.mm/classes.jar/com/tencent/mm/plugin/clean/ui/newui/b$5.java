package com.tencent.mm.plugin.clean.ui.newui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.ak;

final class b$5
  implements AbsListView.OnScrollListener
{
  b$5(b paramb) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(18851);
    o.ahG().bX(paramInt);
    if (paramInt != 2)
    {
      b.a(this.kJe, false);
      b.c(this.kJe).removeCallbacksAndMessages(null);
      b.c(this.kJe).sendEmptyMessageDelayed(0, 200L);
      AppMethodBeat.o(18851);
      return;
    }
    b.a(this.kJe, true);
    AppMethodBeat.o(18851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.b.5
 * JD-Core Version:    0.7.0.1
 */