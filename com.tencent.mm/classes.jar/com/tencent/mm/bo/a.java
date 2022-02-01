package com.tencent.mm.bo;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(3)
public final class a
  extends OrientationEventListener
{
  private a jHY = a.jIb;
  private int jHZ = 45;
  private b jIa;
  
  public a(Context paramContext, b paramb)
  {
    super(paramContext);
    this.jIa = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(151343);
    super.disable();
    this.jHY = a.jIb;
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
    a locala2 = this.jHY;
    a locala1;
    if (((paramInt >= 360 - this.jHZ) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.jHZ + 0))) {
      locala1 = a.jIc;
    }
    for (;;)
    {
      if (locala1 != this.jHY)
      {
        if ((this.jIa != null) && (this.jHY != a.jIb)) {
          this.jIa.a(this.jHY, locala1);
        }
        this.jHY = locala1;
      }
      AppMethodBeat.o(151344);
      return;
      if ((paramInt >= 270 - this.jHZ) && (paramInt <= this.jHZ + 270))
      {
        locala1 = a.jId;
      }
      else if ((paramInt >= 180 - this.jHZ) && (paramInt <= this.jHZ + 180))
      {
        locala1 = a.jIe;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.jHZ)
        {
          locala1 = locala2;
          if (paramInt <= this.jHZ + 90) {
            locala1 = a.jIf;
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
      jIb = new a("NONE", 0);
      jIc = new a("PORTRAIT", 1);
      jId = new a("LANDSCAPE", 2);
      jIe = new a("REVERSE_PORTRAIT", 3);
      jIf = new a("REVERSE_LANDSCAPE", 4);
      jIg = new a[] { jIb, jIc, jId, jIe, jIf };
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