package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.o;
import com.tencent.mm.sdk.platformtools.ah;

final class b$6
  implements AbsListView.OnScrollListener
{
  b$6(b paramb) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    o.ON().bR(paramInt);
    if (paramInt != 2)
    {
      b.a(this.iCF, false);
      b.g(this.iCF).removeCallbacksAndMessages(null);
      b.g(this.iCF).sendEmptyMessageDelayed(0, 200L);
      return;
    }
    b.a(this.iCF, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b.6
 * JD-Core Version:    0.7.0.1
 */