package com.bumptech.glide.c.d.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.b.a.a;
import com.bumptech.glide.c.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements a.a
{
  private final e aCk;
  private final com.bumptech.glide.c.b.a.b aCp;
  
  public b(e parame, com.bumptech.glide.c.b.a.b paramb)
  {
    this.aCk = parame;
    this.aCp = paramb;
  }
  
  public final Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77476);
    paramConfig = this.aCk.g(paramInt1, paramInt2, paramConfig);
    AppMethodBeat.o(77476);
    return paramConfig;
  }
  
  public final byte[] dk(int paramInt)
  {
    AppMethodBeat.i(77478);
    if (this.aCp == null)
    {
      arrayOfByte = new byte[paramInt];
      AppMethodBeat.o(77478);
      return arrayOfByte;
    }
    byte[] arrayOfByte = (byte[])this.aCp.a(paramInt, [B.class);
    AppMethodBeat.o(77478);
    return arrayOfByte;
  }
  
  public final int[] dl(int paramInt)
  {
    AppMethodBeat.i(77480);
    if (this.aCp == null)
    {
      arrayOfInt = new int[paramInt];
      AppMethodBeat.o(77480);
      return arrayOfInt;
    }
    int[] arrayOfInt = (int[])this.aCp.a(paramInt, [I.class);
    AppMethodBeat.o(77480);
    return arrayOfInt;
  }
  
  public final void f(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77477);
    this.aCk.g(paramBitmap);
    AppMethodBeat.o(77477);
  }
  
  public final void k(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77479);
    if (this.aCp == null)
    {
      AppMethodBeat.o(77479);
      return;
    }
    this.aCp.put(paramArrayOfByte);
    AppMethodBeat.o(77479);
  }
  
  public final void o(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(77481);
    if (this.aCp == null)
    {
      AppMethodBeat.o(77481);
      return;
    }
    this.aCp.put(paramArrayOfInt);
    AppMethodBeat.o(77481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.e.b
 * JD-Core Version:    0.7.0.1
 */