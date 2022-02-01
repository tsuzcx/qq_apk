package com.tencent.mm.bx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public final class b
{
  public byte[] zr;
  
  private b() {}
  
  public b(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.i(2357);
    AppMethodBeat.o(2357);
  }
  
  public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2358);
    this.zr = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.zr, 0, paramInt2);
    AppMethodBeat.o(2358);
  }
  
  public static b F(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2359);
    paramArrayOfByte = new b(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(2359);
    return paramArrayOfByte;
  }
  
  public static b aNZ(String paramString)
  {
    AppMethodBeat.i(2361);
    try
    {
      b localb = new b();
      localb.zr = paramString.getBytes("UTF-8");
      AppMethodBeat.o(2361);
      return localb;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new RuntimeException("UTF-8 not supported?", paramString);
      AppMethodBeat.o(2361);
      throw paramString;
    }
  }
  
  public static b cj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2360);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      paramArrayOfByte = new b(paramArrayOfByte);
      AppMethodBeat.o(2360);
      return paramArrayOfByte;
      paramArrayOfByte = new byte[0];
    }
  }
  
  public final b Zz(int paramInt)
  {
    AppMethodBeat.i(2362);
    byte[] arrayOfByte = new byte[paramInt];
    if (this.zr.length >= paramInt) {
      System.arraycopy(this.zr, 0, arrayOfByte, 0, paramInt - 1);
    }
    for (this.zr = arrayOfByte;; this.zr = arrayOfByte)
    {
      AppMethodBeat.o(2362);
      return this;
      System.arraycopy(this.zr, 0, arrayOfByte, 0, this.zr.length);
    }
  }
  
  public final void ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2363);
    System.arraycopy(this.zr, 0, paramArrayOfByte, 4, this.zr.length);
    AppMethodBeat.o(2363);
  }
  
  public final String ffY()
  {
    int i = 0;
    AppMethodBeat.i(2366);
    try
    {
      while ((i < this.zr.length) && (this.zr[i] != 0)) {
        i += 1;
      }
      String str = new String(this.zr, 0, i, "UTF-8");
      AppMethodBeat.o(2366);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      RuntimeException localRuntimeException = new RuntimeException("UTF-8 not supported?");
      AppMethodBeat.o(2366);
      throw localRuntimeException;
    }
  }
  
  public final byte[] getBytes()
  {
    return this.zr;
  }
  
  public final void i(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(2364);
    System.arraycopy(this.zr, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    AppMethodBeat.o(2364);
  }
  
  public final int size()
  {
    return this.zr.length;
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(2365);
    int i = this.zr.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.zr, 0, arrayOfByte, 0, i);
    AppMethodBeat.o(2365);
    return arrayOfByte;
  }
  
  public final String toString(String paramString)
  {
    AppMethodBeat.i(215641);
    paramString = new String(this.zr, paramString);
    AppMethodBeat.o(215641);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bx.b
 * JD-Core Version:    0.7.0.1
 */