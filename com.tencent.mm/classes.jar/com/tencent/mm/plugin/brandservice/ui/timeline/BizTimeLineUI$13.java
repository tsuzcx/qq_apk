package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Process;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.sdk.platformtools.ab;

final class BizTimeLineUI$13
  implements AbsListView.OnScrollListener
{
  BizTimeLineUI$13(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(14197);
    BizTimeLineUI.a(this.jXh, paramInt1, paramInt2);
    BizTimeLineUI.ga(paramInt1);
    AppMethodBeat.o(14197);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(14196);
    o.ahG().bX(paramInt);
    if (paramInt == 0) {
      BizTimeLineUI.c(this.jXh).dI(BizTimeLineUI.b(this.jXh).getFirstVisiblePosition(), BizTimeLineUI.b(this.jXh).getLastVisiblePosition());
    }
    boolean bool;
    int i;
    int j;
    int k;
    if (paramInt == 2)
    {
      paramAbsListView = this.jXh;
      bool = WXHardCoderJNI.hcBizEnable;
      i = WXHardCoderJNI.hcBizDelay;
      j = WXHardCoderJNI.hcBizCPU;
      k = WXHardCoderJNI.hcBizIO;
      if (!WXHardCoderJNI.hcBizThr) {
        break label153;
      }
    }
    label153:
    for (paramInt = Process.myTid();; paramInt = 0)
    {
      BizTimeLineUI.a(paramAbsListView, WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt, WXHardCoderJNI.hcBizTimeout, 903, WXHardCoderJNI.hcBizAction, "MicroMsg.BizTimeLineUI"));
      ab.i("MicroMsg.BizTimeLineUI", "summer hardcoder biz startPerformance [%s] [%s]", new Object[] { Integer.valueOf(903), Integer.valueOf(BizTimeLineUI.d(this.jXh)) });
      AppMethodBeat.o(14196);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.13
 * JD-Core Version:    0.7.0.1
 */