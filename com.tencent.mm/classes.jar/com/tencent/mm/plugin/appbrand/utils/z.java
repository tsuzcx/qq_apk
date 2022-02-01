package com.tencent.mm.plugin.appbrand.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

@TargetApi(3)
public final class z
  extends OrientationEventListener
{
  private int hOz = 45;
  private a lMM = a.lMO;
  private b lMN;
  
  public z(Context paramContext, b paramb)
  {
    super(paramContext);
    this.lMN = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(137920);
    super.disable();
    this.lMM = a.lMO;
    AppMethodBeat.o(137920);
  }
  
  public final void enable()
  {
    AppMethodBeat.i(137919);
    super.enable();
    AppMethodBeat.o(137919);
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(137921);
    if (paramInt == -1)
    {
      AppMethodBeat.o(137921);
      return;
    }
    a locala2 = this.lMM;
    a locala1;
    if (((paramInt >= 360 - this.hOz) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.hOz + 0))) {
      locala1 = a.lMP;
    }
    for (;;)
    {
      if (locala1 != this.lMM)
      {
        if ((this.lMN != null) && (this.lMM != a.lMO)) {
          this.lMN.a(this.lMM, locala1);
        }
        this.lMM = locala1;
      }
      ad.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137921);
      return;
      if ((paramInt >= 270 - this.hOz) && (paramInt <= this.hOz + 270))
      {
        locala1 = a.lMQ;
      }
      else if ((paramInt >= 180 - this.hOz) && (paramInt <= this.hOz + 180))
      {
        locala1 = a.lMR;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.hOz)
        {
          locala1 = locala2;
          if (paramInt <= this.hOz + 90) {
            locala1 = a.lMS;
          }
        }
      }
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(137918);
      lMO = new a("NONE", 0);
      lMP = new a("PORTRAIT", 1);
      lMQ = new a("LANDSCAPE", 2);
      lMR = new a("REVERSE_PORTRAIT", 3);
      lMS = new a("REVERSE_LANDSCAPE", 4);
      lMT = new a[] { lMO, lMP, lMQ, lMR, lMS };
      AppMethodBeat.o(137918);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(z.a parama1, z.a parama2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.z
 * JD-Core Version:    0.7.0.1
 */