package com.tencent.mm.bw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public final class b
{
  public byte[] xy;
  
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
    this.xy = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.xy, 0, paramInt2);
    AppMethodBeat.o(2358);
  }
  
  public static b E(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2359);
    paramArrayOfByte = new b(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(2359);
    return paramArrayOfByte;
  }
  
  public static b aIw(String paramString)
  {
    AppMethodBeat.i(2361);
    try
    {
      b localb = new b();
      localb.xy = paramString.getBytes("UTF-8");
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
  
  public static b cc(byte[] paramArrayOfByte)
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
  
  public final b XD(int paramInt)
  {
    AppMethodBeat.i(2362);
    byte[] arrayOfByte = new byte[paramInt];
    if (this.xy.length >= paramInt) {
      System.arraycopy(this.xy, 0, arrayOfByte, 0, paramInt - 1);
    }
    for (this.xy = arrayOfByte;; this.xy = arrayOfByte)
    {
      AppMethodBeat.o(2362);
      return this;
      System.arraycopy(this.xy, 0, arrayOfByte, 0, this.xy.length);
    }
  }
  
  public final void cd(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2363);
    System.arraycopy(this.xy, 0, paramArrayOfByte, 4, this.xy.length);
    AppMethodBeat.o(2363);
  }
  
  public final String eQU()
  {
    int i = 0;
    AppMethodBeat.i(2366);
    try
    {
      while ((i < this.xy.length) && (this.xy[i] != 0)) {
        i += 1;
      }
      String str = new String(this.xy, 0, i, "UTF-8");
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
    return this.xy;
  }
  
  public final void i(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(2364);
    System.arraycopy(this.xy, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    AppMethodBeat.o(2364);
  }
  
  public final int size()
  {
    return this.xy.length;
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(2365);
    int i = this.xy.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.xy, 0, arrayOfByte, 0, i);
    AppMethodBeat.o(2365);
    return arrayOfByte;
  }
  
  public final String toString(String paramString)
  {
    AppMethodBeat.i(192923);
    paramString = new String(this.xy, paramString);
    AppMethodBeat.o(192923);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bw.b
 * JD-Core Version:    0.7.0.1
 */