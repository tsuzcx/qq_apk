package com.bumptech.glide.c.d.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.b.a.a;
import com.bumptech.glide.c.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements a.a
{
  private final com.bumptech.glide.c.b.a.b azE;
  private final e azz;
  
  public b(e parame, com.bumptech.glide.c.b.a.b paramb)
  {
    this.azz = parame;
    this.azE = paramb;
  }
  
  public final Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77476);
    paramConfig = this.azz.g(paramInt1, paramInt2, paramConfig);
    AppMethodBeat.o(77476);
    return paramConfig;
  }
  
  public final byte[] dl(int paramInt)
  {
    AppMethodBeat.i(77478);
    if (this.azE == null)
    {
      arrayOfByte = new byte[paramInt];
      AppMethodBeat.o(77478);
      return arrayOfByte;
    }
    byte[] arrayOfByte = (byte[])this.azE.a(paramInt, [B.class);
    AppMethodBeat.o(77478);
    return arrayOfByte;
  }
  
  public final int[] dm(int paramInt)
  {
    AppMethodBeat.i(77480);
    if (this.azE == null)
    {
      arrayOfInt = new int[paramInt];
      AppMethodBeat.o(77480);
      return arrayOfInt;
    }
    int[] arrayOfInt = (int[])this.azE.a(paramInt, [I.class);
    AppMethodBeat.o(77480);
    return arrayOfInt;
  }
  
  public final void f(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77477);
    this.azz.g(paramBitmap);
    AppMethodBeat.o(77477);
  }
  
  public final void k(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77479);
    if (this.azE == null)
    {
      AppMethodBeat.o(77479);
      return;
    }
    this.azE.put(paramArrayOfByte);
    AppMethodBeat.o(77479);
  }
  
  public final void n(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(77481);
    if (this.azE == null)
    {
      AppMethodBeat.o(77481);
      return;
    }
    this.azE.put(paramArrayOfInt);
    AppMethodBeat.o(77481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.d.e.b
 * JD-Core Version:    0.7.0.1
 */