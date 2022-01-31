package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.sdk.platformtools.y;

final class h$2
  implements Runnable
{
  h$2(h paramh) {}
  
  public final void run()
  {
    FrameLayout localFrameLayout = (FrameLayout)this.lKp.findViewById(a.e.mapview_content);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.lKp.lKl.findViewById(a.e.location_info_frame);
    if (localFrameLayout == null)
    {
      y.w("MicroMsg.TrackMapUI", "mapcontent is null!");
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localFrameLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    }
    localLayoutParams1.height = (localFrameLayout.getHeight() - localRelativeLayout.getHeight());
    localFrameLayout.setLayoutParams(localLayoutParams1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h.2
 * JD-Core Version:    0.7.0.1
 */