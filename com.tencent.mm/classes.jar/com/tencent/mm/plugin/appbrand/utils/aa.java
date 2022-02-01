package com.tencent.mm.plugin.appbrand.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

@TargetApi(3)
public final class aa
  extends OrientationEventListener
{
  private int iIs = 45;
  private a mPo = a.mPq;
  private b mPp;
  
  public aa(Context paramContext, b paramb)
  {
    super(paramContext);
    this.mPp = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(137920);
    super.disable();
    this.mPo = a.mPq;
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
    a locala2 = this.mPo;
    a locala1;
    if (((paramInt >= 360 - this.iIs) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.iIs + 0))) {
      locala1 = a.mPr;
    }
    for (;;)
    {
      if (locala1 != this.mPo)
      {
        if ((this.mPp != null) && (this.mPo != a.mPq)) {
          this.mPp.a(this.mPo, locala1);
        }
        this.mPo = locala1;
      }
      ad.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137921);
      return;
      if ((paramInt >= 270 - this.iIs) && (paramInt <= this.iIs + 270))
      {
        locala1 = a.mPs;
      }
      else if ((paramInt >= 180 - this.iIs) && (paramInt <= this.iIs + 180))
      {
        locala1 = a.mPt;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.iIs)
        {
          locala1 = locala2;
          if (paramInt <= this.iIs + 90) {
            locala1 = a.mPu;
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
      mPq = new a("NONE", 0);
      mPr = new a("PORTRAIT", 1);
      mPs = new a("LANDSCAPE", 2);
      mPt = new a("REVERSE_PORTRAIT", 3);
      mPu = new a("REVERSE_LANDSCAPE", 4);
      mPv = new a[] { mPq, mPr, mPs, mPt, mPu };
      AppMethodBeat.o(137918);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(aa.a parama1, aa.a parama2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.aa
 * JD-Core Version:    0.7.0.1
 */