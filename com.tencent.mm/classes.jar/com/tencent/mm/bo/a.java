package com.tencent.mm.bo;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

@TargetApi(3)
public final class a
  extends OrientationEventListener
{
  private a iLk = a.iLn;
  private int iLl = 45;
  private b iLm;
  
  public a(Context paramContext, b paramb)
  {
    super(paramContext);
    this.iLm = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(151343);
    super.disable();
    this.iLk = a.iLn;
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
    a locala2 = this.iLk;
    a locala1;
    if (((paramInt >= 360 - this.iLl) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.iLl + 0))) {
      locala1 = a.iLo;
    }
    for (;;)
    {
      if (locala1 != this.iLk)
      {
        if ((this.iLm != null) && (this.iLk != a.iLn)) {
          this.iLm.a(this.iLk, locala1);
        }
        this.iLk = locala1;
      }
      ae.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(151344);
      return;
      if ((paramInt >= 270 - this.iLl) && (paramInt <= this.iLl + 270))
      {
        locala1 = a.iLp;
      }
      else if ((paramInt >= 180 - this.iLl) && (paramInt <= this.iLl + 180))
      {
        locala1 = a.iLq;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.iLl)
        {
          locala1 = locala2;
          if (paramInt <= this.iLl + 90) {
            locala1 = a.iLr;
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
      iLn = new a("NONE", 0);
      iLo = new a("PORTRAIT", 1);
      iLp = new a("LANDSCAPE", 2);
      iLq = new a("REVERSE_PORTRAIT", 3);
      iLr = new a("REVERSE_LANDSCAPE", 4);
      iLs = new a[] { iLn, iLo, iLp, iLq, iLr };
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