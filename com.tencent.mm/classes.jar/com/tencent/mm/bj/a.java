package com.tencent.mm.bj;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends OrientationEventListener
{
  private a pvO = a.pvR;
  private int pvP = 45;
  private b pvQ;
  
  public a(Context paramContext, b paramb)
  {
    super(paramContext);
    this.pvQ = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(151343);
    super.disable();
    this.pvO = a.pvR;
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
    a locala2 = this.pvO;
    a locala1;
    if (((paramInt >= 360 - this.pvP) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.pvP + 0))) {
      locala1 = a.pvS;
    }
    for (;;)
    {
      if (locala1 != this.pvO)
      {
        if ((this.pvQ != null) && (this.pvO != a.pvR)) {
          this.pvQ.onFourOrientationsChange(this.pvO, locala1);
        }
        this.pvO = locala1;
      }
      AppMethodBeat.o(151344);
      return;
      if ((paramInt >= 270 - this.pvP) && (paramInt <= this.pvP + 270))
      {
        locala1 = a.pvT;
      }
      else if ((paramInt >= 180 - this.pvP) && (paramInt <= this.pvP + 180))
      {
        locala1 = a.pvU;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.pvP)
        {
          locala1 = locala2;
          if (paramInt <= this.pvP + 90) {
            locala1 = a.pvV;
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
      pvR = new a("NONE", 0);
      pvS = new a("PORTRAIT", 1);
      pvT = new a("LANDSCAPE", 2);
      pvU = new a("REVERSE_PORTRAIT", 3);
      pvV = new a("REVERSE_LANDSCAPE", 4);
      pvW = new a[] { pvR, pvS, pvT, pvU, pvV };
      AppMethodBeat.o(151341);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void onFourOrientationsChange(a.a parama1, a.a parama2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bj.a
 * JD-Core Version:    0.7.0.1
 */