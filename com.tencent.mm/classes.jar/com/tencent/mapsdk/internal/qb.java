package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;

public class qb
  extends jp
{
  private static kt.a g;
  
  static
  {
    AppMethodBeat.i(226087);
    g = new kt.a(Bitmap.Config.ARGB_8888);
    AppMethodBeat.o(226087);
  }
  
  public qb()
  {
    AppMethodBeat.i(226064);
    a(g);
    AppMethodBeat.o(226064);
  }
  
  public qb(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
    AppMethodBeat.i(226077);
    a(g);
    AppMethodBeat.o(226077);
  }
  
  public final boolean f()
  {
    AppMethodBeat.i(226096);
    if ((this.c != null) && (!this.c.isRecycled()) && (this.b.get() <= 0))
    {
      this.c.recycle();
      kl.f("BD").a(new Object[] { "tileBitmap recycle out" });
    }
    this.d = null;
    if ((this.c == null) || (this.c.isRecycled()))
    {
      AppMethodBeat.o(226096);
      return true;
    }
    AppMethodBeat.o(226096);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qb
 * JD-Core Version:    0.7.0.1
 */