package com.tencent.mm.plugin.appbrand.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

@TargetApi(3)
public final class ad
  extends OrientationEventListener
{
  public int jHZ = 45;
  private a ohy = a.ohA;
  private b ohz;
  
  public ad(Context paramContext, b paramb)
  {
    super(paramContext);
    this.ohz = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(137920);
    super.disable();
    this.ohy = a.ohA;
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
    a locala2 = this.ohy;
    a locala1;
    if (((paramInt >= 360 - this.jHZ) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.jHZ + 0))) {
      locala1 = a.ohB;
    }
    for (;;)
    {
      if (locala1 != this.ohy)
      {
        if ((this.ohz != null) && (this.ohy != a.ohA)) {
          this.ohz.a(this.ohy, locala1);
        }
        this.ohy = locala1;
      }
      Log.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137921);
      return;
      if ((paramInt >= 270 - this.jHZ) && (paramInt <= this.jHZ + 270))
      {
        locala1 = a.ohC;
      }
      else if ((paramInt >= 180 - this.jHZ) && (paramInt <= this.jHZ + 180))
      {
        locala1 = a.ohD;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.jHZ)
        {
          locala1 = locala2;
          if (paramInt <= this.jHZ + 90) {
            locala1 = a.ohE;
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
      ohA = new a("NONE", 0);
      ohB = new a("PORTRAIT", 1);
      ohC = new a("LANDSCAPE", 2);
      ohD = new a("REVERSE_PORTRAIT", 3);
      ohE = new a("REVERSE_LANDSCAPE", 4);
      ohF = new a[] { ohA, ohB, ohC, ohD, ohE };
      AppMethodBeat.o(137918);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(ad.a parama1, ad.a parama2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ad
 * JD-Core Version:    0.7.0.1
 */