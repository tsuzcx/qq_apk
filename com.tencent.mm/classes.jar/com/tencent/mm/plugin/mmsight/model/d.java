package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class d
  extends OrientationEventListener
{
  private int KUR = -1;
  private long KUS = 0L;
  private long KUT = 0L;
  public d.a KUU;
  private int lastOrientation = -1;
  private int orientation = -1;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public d(Context paramContext, byte paramByte)
  {
    super(paramContext, 2);
  }
  
  public void enable()
  {
    AppMethodBeat.i(89357);
    Log.i("MicroMsg.DeviceOrientationListener", "enable, config isEnableLandscapeMode: %s", new Object[] { Boolean.valueOf(j.KVG) });
    if (j.KVG)
    {
      super.enable();
      this.KUT = Util.currentTicks();
    }
    AppMethodBeat.o(89357);
  }
  
  public final int gbW()
  {
    AppMethodBeat.i(89358);
    int i = getOrientation();
    if ((i <= 60) || (i >= 300)) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(89358);
      return i;
      if (i <= 120) {
        i = 90;
      } else if (i <= 210) {
        i = 180;
      } else {
        i = 270;
      }
    }
  }
  
  public final int getOrientation()
  {
    if (!j.KVG) {
      return 0;
    }
    return this.orientation;
  }
  
  public final boolean isLandscape()
  {
    AppMethodBeat.i(89359);
    if (!j.KVG)
    {
      AppMethodBeat.o(89359);
      return false;
    }
    long l = Util.ticksToNow(this.KUT);
    Log.i("MicroMsg.DeviceOrientationListener", "isLandscape, tickToNow: %s, orientation: %s", new Object[] { Long.valueOf(l), Integer.valueOf(this.orientation) });
    if (l < 2000L)
    {
      AppMethodBeat.o(89359);
      return false;
    }
    if (this.orientation < 0)
    {
      AppMethodBeat.o(89359);
      return false;
    }
    if ((this.orientation == 90) || (this.orientation == 270))
    {
      AppMethodBeat.o(89359);
      return true;
    }
    AppMethodBeat.o(89359);
    return false;
  }
  
  public void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(89356);
    if (!j.KVG)
    {
      AppMethodBeat.o(89356);
      return;
    }
    if (Util.ticksToNow(this.KUT) < 2000L)
    {
      Log.v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
      AppMethodBeat.o(89356);
      return;
    }
    if ((paramInt < 0) || (paramInt > 360))
    {
      Log.d("MicroMsg.DeviceOrientationListener", "orientation out of range, ignore");
      AppMethodBeat.o(89356);
      return;
    }
    if ((Math.abs(this.KUR - paramInt) >= 30) || (Util.ticksToNow(this.KUS) >= 300L))
    {
      this.KUR = paramInt;
      this.KUS = Util.currentTicks();
      if ((paramInt > 60) && (paramInt < 300)) {
        break label165;
      }
      if ((paramInt <= 30) || (paramInt >= 330)) {
        this.orientation = 0;
      }
    }
    for (;;)
    {
      if (this.KUU != null) {
        this.KUU.onOrientationChange(this.orientation);
      }
      AppMethodBeat.o(89356);
      return;
      label165:
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
  
  public final void reset()
  {
    AppMethodBeat.i(89360);
    Log.i("MicroMsg.DeviceOrientationListener", "reset");
    this.lastOrientation = -1;
    this.orientation = -1;
    this.KUR = -1;
    AppMethodBeat.o(89360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.d
 * JD-Core Version:    0.7.0.1
 */