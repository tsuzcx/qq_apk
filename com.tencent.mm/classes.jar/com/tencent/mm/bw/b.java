package com.tencent.mm.bw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public final class b
{
  public byte[] zy;
  
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
    this.zy = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.zy, 0, paramInt2);
    AppMethodBeat.o(2358);
  }
  
  public static b Q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2359);
    paramArrayOfByte = new b(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(2359);
    return paramArrayOfByte;
  }
  
  public static b bfZ(String paramString)
  {
    AppMethodBeat.i(2361);
    try
    {
      b localb = new b();
      localb.zy = paramString.getBytes("UTF-8");
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
  
  public static b cD(byte[] paramArrayOfByte)
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
  
  public final b aiU(int paramInt)
  {
    AppMethodBeat.i(2362);
    byte[] arrayOfByte = new byte[paramInt];
    if (this.zy.length >= paramInt) {
      System.arraycopy(this.zy, 0, arrayOfByte, 0, paramInt - 1);
    }
    for (this.zy = arrayOfByte;; this.zy = arrayOfByte)
    {
      AppMethodBeat.o(2362);
      return this;
      System.arraycopy(this.zy, 0, arrayOfByte, 0, this.zy.length);
    }
  }
  
  public final void cE(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2363);
    System.arraycopy(this.zy, 0, paramArrayOfByte, 4, this.zy.length);
    AppMethodBeat.o(2363);
  }
  
  public final void j(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(2364);
    System.arraycopy(this.zy, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    AppMethodBeat.o(2364);
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(2365);
    int i = this.zy.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.zy, 0, arrayOfByte, 0, i);
    AppMethodBeat.o(2365);
    return arrayOfByte;
  }
  
  public final String toString(String paramString)
  {
    AppMethodBeat.i(196829);
    paramString = new String(this.zy, paramString);
    AppMethodBeat.o(196829);
    return paramString;
  }
  
  public final String yO()
  {
    int i = 0;
    AppMethodBeat.i(2366);
    try
    {
      while ((i < this.zy.length) && (this.zy[i] != 0)) {
        i += 1;
      }
      String str = new String(this.zy, 0, i, "UTF-8");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bw.b
 * JD-Core Version:    0.7.0.1
 */