package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizTimeLineHotView$8
  implements Runnable
{
  BizTimeLineHotView$8(BizTimeLineHotView paramBizTimeLineHotView, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(14313);
    Object localObject = BizTimeLineHotView.f(this.jZn);
    b localb = this.jZs;
    if (localb != null)
    {
      localObject = (BizTimeLineHotListView.b)((BizTimeLineHotListView)localObject).bQ(localb.position);
      if (localObject != null)
      {
        if (localb.jZt)
        {
          ((BizTimeLineHotListView.b)localObject).jZd.setVisibility(0);
          AppMethodBeat.o(14313);
          return;
        }
        ((BizTimeLineHotListView.b)localObject).jZd.setVisibility(8);
      }
    }
    AppMethodBeat.o(14313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView.8
 * JD-Core Version:    0.7.0.1
 */