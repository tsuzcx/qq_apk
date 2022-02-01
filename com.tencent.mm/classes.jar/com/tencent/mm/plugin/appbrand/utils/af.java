package com.tencent.mm.plugin.appbrand.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

@TargetApi(3)
public final class af
  extends OrientationEventListener
{
  public int mze = 45;
  private a rjm = a.rjo;
  private b rjn;
  
  public af(Context paramContext, b paramb)
  {
    super(paramContext);
    this.rjn = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(137920);
    super.disable();
    this.rjm = a.rjo;
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
    a locala2 = this.rjm;
    a locala1;
    if (((paramInt >= 360 - this.mze) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.mze + 0))) {
      locala1 = a.rjp;
    }
    for (;;)
    {
      if (locala1 != this.rjm)
      {
        if ((this.rjn != null) && (this.rjm != a.rjo)) {
          this.rjn.a(this.rjm, locala1);
        }
        this.rjm = locala1;
      }
      Log.v("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137921);
      return;
      if ((paramInt >= 270 - this.mze) && (paramInt <= this.mze + 270))
      {
        locala1 = a.rjq;
      }
      else if ((paramInt >= 180 - this.mze) && (paramInt <= this.mze + 180))
      {
        locala1 = a.rjr;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.mze)
        {
          locala1 = locala2;
          if (paramInt <= this.mze + 90) {
            locala1 = a.rjs;
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
      rjo = new a("NONE", 0);
      rjp = new a("PORTRAIT", 1);
      rjq = new a("LANDSCAPE", 2);
      rjr = new a("REVERSE_PORTRAIT", 3);
      rjs = new a("REVERSE_LANDSCAPE", 4);
      rjt = new a[] { rjo, rjp, rjq, rjr, rjs };
      AppMethodBeat.o(137918);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(af.a parama1, af.a parama2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.af
 * JD-Core Version:    0.7.0.1
 */