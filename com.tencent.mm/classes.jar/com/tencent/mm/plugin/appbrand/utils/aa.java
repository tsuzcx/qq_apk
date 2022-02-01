package com.tencent.mm.plugin.appbrand.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

@TargetApi(3)
public final class aa
  extends OrientationEventListener
{
  private int ioV = 45;
  private a moM = a.moO;
  private b moN;
  
  public aa(Context paramContext, b paramb)
  {
    super(paramContext);
    this.moN = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(137920);
    super.disable();
    this.moM = a.moO;
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
    a locala2 = this.moM;
    a locala1;
    if (((paramInt >= 360 - this.ioV) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.ioV + 0))) {
      locala1 = a.moP;
    }
    for (;;)
    {
      if (locala1 != this.moM)
      {
        if ((this.moN != null) && (this.moM != a.moO)) {
          this.moN.a(this.moM, locala1);
        }
        this.moM = locala1;
      }
      ac.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137921);
      return;
      if ((paramInt >= 270 - this.ioV) && (paramInt <= this.ioV + 270))
      {
        locala1 = a.moQ;
      }
      else if ((paramInt >= 180 - this.ioV) && (paramInt <= this.ioV + 180))
      {
        locala1 = a.moR;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.ioV)
        {
          locala1 = locala2;
          if (paramInt <= this.ioV + 90) {
            locala1 = a.moS;
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
      moO = new a("NONE", 0);
      moP = new a("PORTRAIT", 1);
      moQ = new a("LANDSCAPE", 2);
      moR = new a("REVERSE_PORTRAIT", 3);
      moS = new a("REVERSE_LANDSCAPE", 4);
      moT = new a[] { moO, moP, moQ, moR, moS };
      AppMethodBeat.o(137918);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(aa.a parama1, aa.a parama2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.aa
 * JD-Core Version:    0.7.0.1
 */