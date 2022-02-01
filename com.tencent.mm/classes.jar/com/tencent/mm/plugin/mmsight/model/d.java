package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  extends OrientationEventListener
{
  private int iHo = -1;
  private int orientation = -1;
  private int tBW = -1;
  private long tBX = 0L;
  private long tBY = 0L;
  public a tBZ;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public d(Context paramContext, byte paramByte)
  {
    super(paramContext, 2);
  }
  
  public final void a(a parama)
  {
    this.tBZ = parama;
  }
  
  public final boolean aov()
  {
    AppMethodBeat.i(89359);
    if (!k.tCK)
    {
      AppMethodBeat.o(89359);
      return false;
    }
    long l = bt.aS(this.tBY);
    ad.i("MicroMsg.DeviceOrientationListener", "isLandscape, tickToNow: %s, orientation: %s", new Object[] { Long.valueOf(l), Integer.valueOf(this.orientation) });
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
  
  public final int cPE()
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
  
  public final void enable()
  {
    AppMethodBeat.i(89357);
    ad.i("MicroMsg.DeviceOrientationListener", "enable, config isEnableLandscapeMode: %s", new Object[] { Boolean.valueOf(k.tCK) });
    if (k.tCK)
    {
      super.enable();
      this.tBY = bt.GC();
    }
    AppMethodBeat.o(89357);
  }
  
  public final int getOrientation()
  {
    if (!k.tCK) {
      return 0;
    }
    return this.orientation;
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(89356);
    if (!k.tCK)
    {
      AppMethodBeat.o(89356);
      return;
    }
    if (bt.aS(this.tBY) < 2000L)
    {
      ad.v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
      AppMethodBeat.o(89356);
      return;
    }
    if ((paramInt < 0) || (paramInt > 360))
    {
      ad.d("MicroMsg.DeviceOrientationListener", "orientation out of range, ignore");
      AppMethodBeat.o(89356);
      return;
    }
    if ((Math.abs(this.tBW - paramInt) >= 30) || (bt.aS(this.tBX) >= 300L))
    {
      this.tBW = paramInt;
      this.tBX = bt.GC();
      if ((paramInt > 60) && (paramInt < 300)) {
        break label165;
      }
      if ((paramInt <= 30) || (paramInt >= 330)) {
        this.orientation = 0;
      }
    }
    for (;;)
    {
      if (this.tBZ != null) {
        this.tBZ.wy(this.orientation);
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
    ad.i("MicroMsg.DeviceOrientationListener", "reset");
    this.iHo = -1;
    this.orientation = -1;
    this.tBW = -1;
    AppMethodBeat.o(89360);
  }
  
  public static abstract interface a
  {
    public abstract void wy(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.d
 * JD-Core Version:    0.7.0.1
 */