package com.tencent.mm.plugin.brandservice.ui.widget;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class MPVideoViewControlBar$10
  implements Runnable
{
  MPVideoViewControlBar$10(MPVideoViewControlBar paramMPVideoViewControlBar, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(198787);
    MPVideoViewControlBar.g(this.nRW).removeAllViews();
    Object localObject = this.fzk;
    if (!bs.gY((List)localObject))
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        ImageView localImageView = new ImageView(this.nRW.getContext());
        MPVideoViewControlBar.g(this.nRW).addView(localImageView);
        if (!MPVideoViewControlBar.a(this.nRW, localImageView, localc)) {
          MPVideoViewControlBar.g(this.nRW).removeView(localImageView);
        }
      }
    }
    AppMethodBeat.o(198787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.10
 * JD-Core Version:    0.7.0.1
 */