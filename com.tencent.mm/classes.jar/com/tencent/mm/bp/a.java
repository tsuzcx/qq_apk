package com.tencent.mm.bp;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

@TargetApi(3)
public final class a
  extends OrientationEventListener
{
  private b hOA;
  private a hOy = a.hOB;
  private int hOz = 45;
  
  public a(Context paramContext, b paramb)
  {
    super(paramContext);
    this.hOA = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(151343);
    super.disable();
    this.hOy = a.hOB;
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
    a locala2 = this.hOy;
    a locala1;
    if (((paramInt >= 360 - this.hOz) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.hOz + 0))) {
      locala1 = a.hOC;
    }
    for (;;)
    {
      if (locala1 != this.hOy)
      {
        if ((this.hOA != null) && (this.hOy != a.hOB)) {
          this.hOA.a(this.hOy, locala1);
        }
        this.hOy = locala1;
      }
      ad.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(151344);
      return;
      if ((paramInt >= 270 - this.hOz) && (paramInt <= this.hOz + 270))
      {
        locala1 = a.hOD;
      }
      else if ((paramInt >= 180 - this.hOz) && (paramInt <= this.hOz + 180))
      {
        locala1 = a.hOE;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.hOz)
        {
          locala1 = locala2;
          if (paramInt <= this.hOz + 90) {
            locala1 = a.hOF;
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
      hOB = new a("NONE", 0);
      hOC = new a("PORTRAIT", 1);
      hOD = new a("LANDSCAPE", 2);
      hOE = new a("REVERSE_PORTRAIT", 3);
      hOF = new a("REVERSE_LANDSCAPE", 4);
      hOG = new a[] { hOB, hOC, hOD, hOE, hOF };
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
 * Qualified Name:     com.tencent.mm.bp.a
 * JD-Core Version:    0.7.0.1
 */