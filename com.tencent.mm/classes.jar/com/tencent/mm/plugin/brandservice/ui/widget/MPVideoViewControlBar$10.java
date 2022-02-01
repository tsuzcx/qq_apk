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
    AppMethodBeat.i(193011);
    MPVideoViewControlBar.g(this.noW).removeAllViews();
    Object localObject = this.fvD;
    if (!bt.gL((List)localObject))
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        ImageView localImageView = new ImageView(this.noW.getContext());
        MPVideoViewControlBar.g(this.noW).addView(localImageView);
        if (!MPVideoViewControlBar.a(this.noW, localImageView, localc)) {
          MPVideoViewControlBar.g(this.noW).removeView(localImageView);
        }
      }
    }
    AppMethodBeat.o(193011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.10
 * JD-Core Version:    0.7.0.1
 */