package com.tencent.mm.bn;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@TargetApi(3)
public final class a
  extends OrientationEventListener
{
  private a ggB = a.ggE;
  private int ggC = 45;
  private a.b ggD;
  
  public a(Context paramContext, a.b paramb)
  {
    super(paramContext);
    this.ggD = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(78999);
    super.disable();
    this.ggB = a.ggE;
    AppMethodBeat.o(78999);
  }
  
  public final void enable()
  {
    AppMethodBeat.i(78998);
    super.enable();
    AppMethodBeat.o(78998);
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(79000);
    if (paramInt == -1)
    {
      AppMethodBeat.o(79000);
      return;
    }
    a locala2 = this.ggB;
    a locala1;
    if (((paramInt >= 360 - this.ggC) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.ggC + 0))) {
      locala1 = a.ggF;
    }
    for (;;)
    {
      if (locala1 != this.ggB)
      {
        if ((this.ggD != null) && (this.ggB != a.ggE)) {
          this.ggD.a(this.ggB, locala1);
        }
        this.ggB = locala1;
      }
      ab.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(79000);
      return;
      if ((paramInt >= 270 - this.ggC) && (paramInt <= this.ggC + 270))
      {
        locala1 = a.ggG;
      }
      else if ((paramInt >= 180 - this.ggC) && (paramInt <= this.ggC + 180))
      {
        locala1 = a.ggH;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.ggC)
        {
          locala1 = locala2;
          if (paramInt <= this.ggC + 90) {
            locala1 = a.ggI;
          }
        }
      }
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(78997);
      ggE = new a("NONE", 0);
      ggF = new a("PORTRAIT", 1);
      ggG = new a("LANDSCAPE", 2);
      ggH = new a("REVERSE_PORTRAIT", 3);
      ggI = new a("REVERSE_LANDSCAPE", 4);
      ggJ = new a[] { ggE, ggF, ggG, ggH, ggI };
      AppMethodBeat.o(78997);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bn.a
 * JD-Core Version:    0.7.0.1
 */