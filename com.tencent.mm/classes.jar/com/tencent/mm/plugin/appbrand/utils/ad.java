package com.tencent.mm.plugin.appbrand.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

@TargetApi(3)
public final class ad
  extends OrientationEventListener
{
  private int iLl = 45;
  private a mUx = a.mUz;
  private b mUy;
  
  public ad(Context paramContext, b paramb)
  {
    super(paramContext);
    this.mUy = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(137920);
    super.disable();
    this.mUx = a.mUz;
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
    a locala2 = this.mUx;
    a locala1;
    if (((paramInt >= 360 - this.iLl) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.iLl + 0))) {
      locala1 = a.mUB;
    }
    for (;;)
    {
      if (locala1 != this.mUx)
      {
        if ((this.mUy != null) && (this.mUx != a.mUz)) {
          this.mUy.a(this.mUx, locala1);
        }
        this.mUx = locala1;
      }
      ae.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137921);
      return;
      if ((paramInt >= 270 - this.iLl) && (paramInt <= this.iLl + 270))
      {
        locala1 = a.mUC;
      }
      else if ((paramInt >= 180 - this.iLl) && (paramInt <= this.iLl + 180))
      {
        locala1 = a.mUD;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.iLl)
        {
          locala1 = locala2;
          if (paramInt <= this.iLl + 90) {
            locala1 = a.mUE;
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
      mUz = new a("NONE", 0);
      mUB = new a("PORTRAIT", 1);
      mUC = new a("LANDSCAPE", 2);
      mUD = new a("REVERSE_PORTRAIT", 3);
      mUE = new a("REVERSE_LANDSCAPE", 4);
      mUF = new a[] { mUz, mUB, mUC, mUD, mUE };
      AppMethodBeat.o(137918);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(ad.a parama1, ad.a parama2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ad
 * JD-Core Version:    0.7.0.1
 */