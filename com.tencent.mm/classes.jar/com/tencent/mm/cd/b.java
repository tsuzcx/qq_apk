package com.tencent.mm.cd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public final class b
{
  public byte[] UH;
  
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
    this.UH = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.UH, 0, paramInt2);
    AppMethodBeat.o(2358);
  }
  
  public static b S(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2359);
    paramArrayOfByte = new b(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(2359);
    return paramArrayOfByte;
  }
  
  public static b bss(String paramString)
  {
    AppMethodBeat.i(2361);
    try
    {
      paramString = nz(paramString, "UTF-8");
      AppMethodBeat.o(2361);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new RuntimeException("UTF-8 not supported?", paramString);
      AppMethodBeat.o(2361);
      throw paramString;
    }
  }
  
  public static b cU(byte[] paramArrayOfByte)
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
  
  public static b nz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198908);
    b localb = new b();
    localb.UH = paramString1.getBytes(paramString2);
    AppMethodBeat.o(198908);
    return localb;
  }
  
  public final String Ap()
  {
    int i = 0;
    AppMethodBeat.i(2366);
    try
    {
      while ((i < this.UH.length) && (this.UH[i] != 0)) {
        i += 1;
      }
      String str = new String(this.UH, 0, i, "UTF-8");
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
  
  public final b arf(int paramInt)
  {
    AppMethodBeat.i(2362);
    byte[] arrayOfByte = new byte[paramInt];
    if (this.UH.length >= paramInt) {
      System.arraycopy(this.UH, 0, arrayOfByte, 0, paramInt - 1);
    }
    for (this.UH = arrayOfByte;; this.UH = arrayOfByte)
    {
      AppMethodBeat.o(2362);
      return this;
      System.arraycopy(this.UH, 0, arrayOfByte, 0, this.UH.length);
    }
  }
  
  public final void cV(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2363);
    System.arraycopy(this.UH, 0, paramArrayOfByte, 4, this.UH.length);
    AppMethodBeat.o(2363);
  }
  
  public final void k(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(2364);
    System.arraycopy(this.UH, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    AppMethodBeat.o(2364);
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(2365);
    int i = this.UH.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.UH, 0, arrayOfByte, 0, i);
    AppMethodBeat.o(2365);
    return arrayOfByte;
  }
  
  public final String toString(String paramString)
  {
    AppMethodBeat.i(198913);
    paramString = new String(this.UH, paramString);
    AppMethodBeat.o(198913);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cd.b
 * JD-Core Version:    0.7.0.1
 */