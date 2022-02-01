package com.tencent.mm.br;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(3)
public final class a
  extends OrientationEventListener
{
  private a mzd = a.mzg;
  private int mze = 45;
  private b mzf;
  
  public a(Context paramContext, b paramb)
  {
    super(paramContext);
    this.mzf = paramb;
  }
  
  public final void disable()
  {
    AppMethodBeat.i(151343);
    super.disable();
    this.mzd = a.mzg;
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
    a locala2 = this.mzd;
    a locala1;
    if (((paramInt >= 360 - this.mze) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.mze + 0))) {
      locala1 = a.mzh;
    }
    for (;;)
    {
      if (locala1 != this.mzd)
      {
        if ((this.mzf != null) && (this.mzd != a.mzg)) {
          this.mzf.a(this.mzd, locala1);
        }
        this.mzd = locala1;
      }
      AppMethodBeat.o(151344);
      return;
      if ((paramInt >= 270 - this.mze) && (paramInt <= this.mze + 270))
      {
        locala1 = a.mzi;
      }
      else if ((paramInt >= 180 - this.mze) && (paramInt <= this.mze + 180))
      {
        locala1 = a.mzj;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.mze)
        {
          locala1 = locala2;
          if (paramInt <= this.mze + 90) {
            locala1 = a.mzk;
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
      mzg = new a("NONE", 0);
      mzh = new a("PORTRAIT", 1);
      mzi = new a("LANDSCAPE", 2);
      mzj = new a("REVERSE_PORTRAIT", 3);
      mzk = new a("REVERSE_LANDSCAPE", 4);
      mzl = new a[] { mzg, mzh, mzi, mzj, mzk };
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
 * Qualified Name:     com.tencent.mm.br.a
 * JD-Core Version:    0.7.0.1
 */