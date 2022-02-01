package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public final class ly
  implements ma
{
  private int g;
  private byte[] h;
  
  private ly(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222757);
    this.h = paramArrayOfByte;
    this.g = 0;
    AppMethodBeat.o(222757);
  }
  
  private void a(int paramInt)
  {
    this.g += paramInt;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    this.h = paramArrayOfByte;
    this.g = 0;
  }
  
  private byte[] a()
  {
    AppMethodBeat.i(222770);
    byte[] arrayOfByte = new byte[this.h.length - this.g];
    System.arraycopy(this.h, this.g, arrayOfByte, 0, arrayOfByte.length);
    AppMethodBeat.o(222770);
    return arrayOfByte;
  }
  
  private int b()
  {
    return this.g;
  }
  
  private void b(int paramInt)
  {
    this.g -= paramInt;
  }
  
  private byte c()
  {
    if ((this.h == null) || (this.g >= this.h.length)) {
      return 0;
    }
    byte[] arrayOfByte = this.h;
    int i = this.g;
    this.g = (i + 1);
    return arrayOfByte[i];
  }
  
  private byte[] c(int paramInt)
  {
    AppMethodBeat.i(222807);
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[i] = c();
      i += 1;
    }
    AppMethodBeat.o(222807);
    return arrayOfByte;
  }
  
  private String d(int paramInt)
  {
    AppMethodBeat.i(222866);
    Object localObject = new StringBuffer();
    int i = 0;
    while (i < paramInt >> 1)
    {
      ((StringBuffer)localObject).append(f());
      i += 1;
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(222866);
    return localObject;
  }
  
  private boolean d()
  {
    AppMethodBeat.i(222815);
    if (c() == 0)
    {
      AppMethodBeat.o(222815);
      return false;
    }
    AppMethodBeat.o(222815);
    return true;
  }
  
  private int e()
  {
    AppMethodBeat.i(222824);
    int i = (int)e(2);
    AppMethodBeat.o(222824);
    return i;
  }
  
  private long e(int paramInt)
  {
    AppMethodBeat.i(222905);
    long l = 0L;
    paramInt -= 1;
    while (paramInt >= 0)
    {
      l |= (c() & 0xFF) << paramInt * 8;
      paramInt -= 1;
    }
    AppMethodBeat.o(222905);
    return l;
  }
  
  private char f()
  {
    AppMethodBeat.i(222832);
    long l = 0L;
    int i = 0;
    while (i < 2)
    {
      l |= (c() & 0xFF) << i * 8;
      i += 1;
    }
    char c = (char)(int)l;
    AppMethodBeat.o(222832);
    return c;
  }
  
  private int g()
  {
    AppMethodBeat.i(222843);
    int i = (int)e(4);
    AppMethodBeat.o(222843);
    return i;
  }
  
  private long h()
  {
    AppMethodBeat.i(222852);
    long l = e(8);
    AppMethodBeat.o(222852);
    return l;
  }
  
  private String i()
  {
    AppMethodBeat.i(222859);
    int j = (int)e(2);
    if (j == 0)
    {
      AppMethodBeat.o(222859);
      return "";
    }
    Object localObject = new StringBuffer();
    int i = 0;
    while (i < j)
    {
      ((StringBuffer)localObject).append(f());
      i += 1;
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(222859);
    return localObject;
  }
  
  private String j()
  {
    AppMethodBeat.i(222873);
    int j = (int)e(2);
    if (j == 0)
    {
      AppMethodBeat.o(222873);
      return "";
    }
    Object localObject = new byte[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = c();
      i += 1;
    }
    try
    {
      localObject = new String((byte[])localObject, "UTF-8");
      AppMethodBeat.o(222873);
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str = "";
      }
    }
  }
  
  private boolean k()
  {
    return this.g == this.h.length - 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ly
 * JD-Core Version:    0.7.0.1
 */