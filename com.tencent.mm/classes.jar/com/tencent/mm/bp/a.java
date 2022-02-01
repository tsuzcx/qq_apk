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
  private a iIr = a.iIu;
  private int iIs = 45;
  private b iIt;
  
  public a(Context paramContext, b paramb)
  {
    super(paramContext);
    this.iIt = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(151343);
    super.disable();
    this.iIr = a.iIu;
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
    a locala2 = this.iIr;
    a locala1;
    if (((paramInt >= 360 - this.iIs) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.iIs + 0))) {
      locala1 = a.iIv;
    }
    for (;;)
    {
      if (locala1 != this.iIr)
      {
        if ((this.iIt != null) && (this.iIr != a.iIu)) {
          this.iIt.a(this.iIr, locala1);
        }
        this.iIr = locala1;
      }
      ad.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(151344);
      return;
      if ((paramInt >= 270 - this.iIs) && (paramInt <= this.iIs + 270))
      {
        locala1 = a.iIw;
      }
      else if ((paramInt >= 180 - this.iIs) && (paramInt <= this.iIs + 180))
      {
        locala1 = a.iIx;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.iIs)
        {
          locala1 = locala2;
          if (paramInt <= this.iIs + 90) {
            locala1 = a.iIy;
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
      iIu = new a("NONE", 0);
      iIv = new a("PORTRAIT", 1);
      iIw = new a("LANDSCAPE", 2);
      iIx = new a("REVERSE_PORTRAIT", 3);
      iIy = new a("REVERSE_LANDSCAPE", 4);
      iIz = new a[] { iIu, iIv, iIw, iIx, iIy };
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