package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends OrientationEventListener
{
  public int mgp = -1;
  public int mgq = -1;
  private long mgr = 0L;
  private long mgs = 0L;
  public c.a mgt;
  public int orientation = -1;
  
  public c(Context paramContext)
  {
    super(paramContext, 2);
  }
  
  public final boolean biH()
  {
    if (!j.mhy) {}
    long l;
    do
    {
      return false;
      l = bk.cp(this.mgs);
      y.i("MicroMsg.DeviceOrientationListener", "isLandscape, tickToNow: %s, orientation: %s", new Object[] { Long.valueOf(l), Integer.valueOf(this.orientation) });
    } while ((l < 2000L) || (this.orientation < 0) || ((this.orientation != 90) && (this.orientation != 270)));
    return true;
  }
  
  public final void enable()
  {
    y.i("MicroMsg.DeviceOrientationListener", "enable, config isEnableLandscapeMode: %s", new Object[] { Boolean.valueOf(j.mhy) });
    if (j.mhy)
    {
      super.enable();
      this.mgs = bk.UZ();
    }
  }
  
  public final int getOrientation()
  {
    if (!j.mhy) {
      return 0;
    }
    return this.orientation;
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    if (!j.mhy) {}
    for (;;)
    {
      return;
      if (bk.cp(this.mgs) < 2000L)
      {
        y.v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
        return;
      }
      if ((Math.abs(this.mgp - paramInt) >= 30) || (bk.cp(this.mgr) >= 300L))
      {
        this.mgp = paramInt;
        this.mgr = bk.UZ();
        if ((paramInt <= 60) || (paramInt >= 300)) {
          if ((paramInt <= 30) || (paramInt >= 330)) {
            this.orientation = 0;
          }
        }
        while (this.mgt != null)
        {
          this.mgt.tX(this.orientation);
          return;
          if ((paramInt >= 30) && (paramInt <= 150))
          {
            if ((paramInt >= 60) && (paramInt <= 120)) {
              this.orientation = 90;
            }
          }
          else if ((paramInt >= 120) && (paramInt <= 240))
          {
            if ((paramInt >= 150) && (paramInt <= 210)) {
              this.orientation = 180;
            }
          }
          else if ((paramInt >= 210) && (paramInt <= 330) && (paramInt >= 240) && (paramInt <= 300)) {
            this.orientation = 270;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.c
 * JD-Core Version:    0.7.0.1
 */