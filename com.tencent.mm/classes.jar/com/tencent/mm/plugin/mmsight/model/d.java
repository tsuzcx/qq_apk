package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class d
  extends OrientationEventListener
{
  private int gud = -1;
  private int orientation = -1;
  private int uKt = -1;
  private long uKu = 0L;
  private long uKv = 0L;
  public a uKw;
  
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
    this.uKw = parama;
  }
  
  public final boolean aly()
  {
    AppMethodBeat.i(89359);
    if (!k.uLh)
    {
      AppMethodBeat.o(89359);
      return false;
    }
    long l = bs.aO(this.uKv);
    ac.i("MicroMsg.DeviceOrientationListener", "isLandscape, tickToNow: %s, orientation: %s", new Object[] { Long.valueOf(l), Integer.valueOf(this.orientation) });
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
  
  public final int ddn()
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
    ac.i("MicroMsg.DeviceOrientationListener", "enable, config isEnableLandscapeMode: %s", new Object[] { Boolean.valueOf(k.uLh) });
    if (k.uLh)
    {
      super.enable();
      this.uKv = bs.Gn();
    }
    AppMethodBeat.o(89357);
  }
  
  public final int getOrientation()
  {
    if (!k.uLh) {
      return 0;
    }
    return this.orientation;
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(89356);
    if (!k.uLh)
    {
      AppMethodBeat.o(89356);
      return;
    }
    if (bs.aO(this.uKv) < 2000L)
    {
      ac.v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
      AppMethodBeat.o(89356);
      return;
    }
    if ((paramInt < 0) || (paramInt > 360))
    {
      ac.d("MicroMsg.DeviceOrientationListener", "orientation out of range, ignore");
      AppMethodBeat.o(89356);
      return;
    }
    if ((Math.abs(this.uKt - paramInt) >= 30) || (bs.aO(this.uKu) >= 300L))
    {
      this.uKt = paramInt;
      this.uKu = bs.Gn();
      if ((paramInt > 60) && (paramInt < 300)) {
        break label165;
      }
      if ((paramInt <= 30) || (paramInt >= 330)) {
        this.orientation = 0;
      }
    }
    for (;;)
    {
      if (this.uKw != null) {
        this.uKw.nm(this.orientation);
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
    ac.i("MicroMsg.DeviceOrientationListener", "reset");
    this.gud = -1;
    this.orientation = -1;
    this.uKt = -1;
    AppMethodBeat.o(89360);
  }
  
  public static abstract interface a
  {
    public abstract void nm(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.d
 * JD-Core Version:    0.7.0.1
 */