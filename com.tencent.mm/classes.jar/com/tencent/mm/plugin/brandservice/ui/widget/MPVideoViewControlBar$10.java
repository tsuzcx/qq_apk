package com.tencent.mm.plugin.brandservice.ui.widget;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class MPVideoViewControlBar$10
  implements Runnable
{
  MPVideoViewControlBar$10(MPVideoViewControlBar paramMPVideoViewControlBar, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(209604);
    MPVideoViewControlBar.g(this.ouE).removeAllViews();
    Object localObject = this.fSx;
    if (!bt.hj((List)localObject))
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        ImageView localImageView = new ImageView(this.ouE.getContext());
        MPVideoViewControlBar.g(this.ouE).addView(localImageView);
        if (!MPVideoViewControlBar.a(this.ouE, localImageView, localc)) {
          MPVideoViewControlBar.g(this.ouE).removeView(localImageView);
        }
      }
    }
    AppMethodBeat.o(209604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.10
 * JD-Core Version:    0.7.0.1
 */