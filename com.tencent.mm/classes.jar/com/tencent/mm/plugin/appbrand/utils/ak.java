package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class ak
  extends OrientationEventListener
{
  public int pvP = 45;
  private a urB = a.urD;
  private b urC;
  
  public ak(Context paramContext, b paramb)
  {
    super(paramContext);
    this.urC = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(137920);
    super.disable();
    this.urB = a.urD;
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
    a locala2 = this.urB;
    a locala1;
    if (((paramInt >= 360 - this.pvP) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.pvP + 0))) {
      locala1 = a.urE;
    }
    for (;;)
    {
      if (locala1 != this.urB)
      {
        if ((this.urC != null) && (this.urB != a.urD)) {
          this.urC.onFourOrientationsChange(this.urB, locala1);
        }
        this.urB = locala1;
      }
      Log.v("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137921);
      return;
      if ((paramInt >= 270 - this.pvP) && (paramInt <= this.pvP + 270))
      {
        locala1 = a.urF;
      }
      else if ((paramInt >= 180 - this.pvP) && (paramInt <= this.pvP + 180))
      {
        locala1 = a.urG;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.pvP)
        {
          locala1 = locala2;
          if (paramInt <= this.pvP + 90) {
            locala1 = a.urH;
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
      urD = new a("NONE", 0);
      urE = new a("PORTRAIT", 1);
      urF = new a("LANDSCAPE", 2);
      urG = new a("REVERSE_PORTRAIT", 3);
      urH = new a("REVERSE_LANDSCAPE", 4);
      urI = new a[] { urD, urE, urF, urG, urH };
      AppMethodBeat.o(137918);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void onFourOrientationsChange(ak.a parama1, ak.a parama2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ak
 * JD-Core Version:    0.7.0.1
 */