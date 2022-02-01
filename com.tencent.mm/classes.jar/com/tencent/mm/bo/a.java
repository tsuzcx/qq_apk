package com.tencent.mm.bo;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

@TargetApi(3)
public final class a
  extends OrientationEventListener
{
  private a ioU = a.ioX;
  private int ioV = 45;
  private b ioW;
  
  public a(Context paramContext, b paramb)
  {
    super(paramContext);
    this.ioW = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(151343);
    super.disable();
    this.ioU = a.ioX;
    AppMethodBeat.o(151343);
  }
  
  public final void enable()
  {
    AppMethodBeat.i(151342);
    super.enable();
    AppMethodBeat.o(151342);
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(151344);
    if (paramInt == -1)
    {
      AppMethodBeat.o(151344);
      return;
    }
    a locala2 = this.ioU;
    a locala1;
    if (((paramInt >= 360 - this.ioV) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.ioV + 0))) {
      locala1 = a.ioY;
    }
    for (;;)
    {
      if (locala1 != this.ioU)
      {
        if ((this.ioW != null) && (this.ioU != a.ioX)) {
          this.ioW.a(this.ioU, locala1);
        }
        this.ioU = locala1;
      }
      ac.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(151344);
      return;
      if ((paramInt >= 270 - this.ioV) && (paramInt <= this.ioV + 270))
      {
        locala1 = a.ioZ;
      }
      else if ((paramInt >= 180 - this.ioV) && (paramInt <= this.ioV + 180))
      {
        locala1 = a.ipa;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.ioV)
        {
          locala1 = locala2;
          if (paramInt <= this.ioV + 90) {
            locala1 = a.ipb;
          }
        }
      }
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(151341);
      ioX = new a("NONE", 0);
      ioY = new a("PORTRAIT", 1);
      ioZ = new a("LANDSCAPE", 2);
      ipa = new a("REVERSE_PORTRAIT", 3);
      ipb = new a("REVERSE_LANDSCAPE", 4);
      ipc = new a[] { ioX, ioY, ioZ, ipa, ipb };
      AppMethodBeat.o(151341);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(a.a parama1, a.a parama2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bo.a
 * JD-Core Version:    0.7.0.1
 */