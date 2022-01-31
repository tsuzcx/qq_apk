package com.tencent.mm.plugin.appbrand.t;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@TargetApi(3)
public final class t
  extends OrientationEventListener
{
  private int ggC = 45;
  private t.a iYb = t.a.iYd;
  private t.b iYc;
  
  public t(Context paramContext, t.b paramb)
  {
    super(paramContext);
    this.iYc = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(126642);
    super.disable();
    this.iYb = t.a.iYd;
    AppMethodBeat.o(126642);
  }
  
  public final void enable()
  {
    AppMethodBeat.i(126641);
    super.enable();
    AppMethodBeat.o(126641);
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(126643);
    if (paramInt == -1)
    {
      AppMethodBeat.o(126643);
      return;
    }
    t.a locala2 = this.iYb;
    t.a locala1;
    if (((paramInt >= 360 - this.ggC) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.ggC + 0))) {
      locala1 = t.a.iYe;
    }
    for (;;)
    {
      if (locala1 != this.iYb)
      {
        if ((this.iYc != null) && (this.iYb != t.a.iYd)) {
          this.iYc.a(this.iYb, locala1);
        }
        this.iYb = locala1;
      }
      ab.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(126643);
      return;
      if ((paramInt >= 270 - this.ggC) && (paramInt <= this.ggC + 270))
      {
        locala1 = t.a.iYf;
      }
      else if ((paramInt >= 180 - this.ggC) && (paramInt <= this.ggC + 180))
      {
        locala1 = t.a.iYg;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.ggC)
        {
          locala1 = locala2;
          if (paramInt <= this.ggC + 90) {
            locala1 = t.a.iYh;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.t
 * JD-Core Version:    0.7.0.1
 */