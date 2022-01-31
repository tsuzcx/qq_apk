package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends OrientationEventListener
{
  private int oGO = -1;
  private int oGP = -1;
  private long oGQ = 0L;
  private long oGR = 0L;
  public c.a oGS;
  private int orientation = -1;
  
  public c(Context paramContext)
  {
    super(paramContext, 2);
  }
  
  public final void a(c.a parama)
  {
    this.oGS = parama;
  }
  
  public final int bQJ()
  {
    AppMethodBeat.i(154470);
    int i = getOrientation();
    if ((i <= 60) || (i >= 300)) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(154470);
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
    AppMethodBeat.i(76465);
    ab.i("MicroMsg.DeviceOrientationListener", "enable, config isEnableLandscapeMode: %s", new Object[] { Boolean.valueOf(j.oHD) });
    if (j.oHD)
    {
      super.enable();
      this.oGR = bo.yB();
    }
    AppMethodBeat.o(76465);
  }
  
  public final int getOrientation()
  {
    if (!j.oHD) {
      return 0;
    }
    return this.orientation;
  }
  
  public final boolean isLandscape()
  {
    AppMethodBeat.i(76466);
    if (!j.oHD)
    {
      AppMethodBeat.o(76466);
      return false;
    }
    long l = bo.av(this.oGR);
    ab.i("MicroMsg.DeviceOrientationListener", "isLandscape, tickToNow: %s, orientation: %s", new Object[] { Long.valueOf(l), Integer.valueOf(this.orientation) });
    if (l < 2000L)
    {
      AppMethodBeat.o(76466);
      return false;
    }
    if (this.orientation < 0)
    {
      AppMethodBeat.o(76466);
      return false;
    }
    if ((this.orientation == 90) || (this.orientation == 270))
    {
      AppMethodBeat.o(76466);
      return true;
    }
    AppMethodBeat.o(76466);
    return false;
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(76464);
    if (!j.oHD)
    {
      AppMethodBeat.o(76464);
      return;
    }
    if (bo.av(this.oGR) < 2000L)
    {
      ab.v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
      AppMethodBeat.o(76464);
      return;
    }
    if ((Math.abs(this.oGO - paramInt) >= 30) || (bo.av(this.oGQ) >= 300L))
    {
      this.oGO = paramInt;
      this.oGQ = bo.yB();
      if ((paramInt > 60) && (paramInt < 300)) {
        break label141;
      }
      if ((paramInt <= 30) || (paramInt >= 330)) {
        this.orientation = 0;
      }
    }
    for (;;)
    {
      if (this.oGS != null) {
        this.oGS.zr(this.orientation);
      }
      AppMethodBeat.o(76464);
      return;
      label141:
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
    AppMethodBeat.i(76467);
    ab.i("MicroMsg.DeviceOrientationListener", "reset");
    this.oGP = -1;
    this.orientation = -1;
    this.oGO = -1;
    AppMethodBeat.o(76467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.c
 * JD-Core Version:    0.7.0.1
 */