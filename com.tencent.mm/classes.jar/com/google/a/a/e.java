package com.google.a.a;

import java.io.IOException;

public abstract class e
{
  public volatile int aUI = -1;
  
  public static <T extends e> T a(T paramT, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new a(paramArrayOfByte, paramInt);
      paramT.a(paramArrayOfByte);
      paramArrayOfByte.dH(0);
      return paramT;
    }
    catch (d paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final byte[] b(e parame)
  {
    byte[] arrayOfByte = new byte[parame.oP()];
    int i = arrayOfByte.length;
    try
    {
      b localb = new b(arrayOfByte, i);
      parame.a(localb);
      if (localb.limit - localb.position != 0) {
        throw new IllegalStateException("Did not write as much data as expected.");
      }
    }
    catch (IOException parame)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", parame);
    }
    return arrayOfByte;
  }
  
  public abstract e a(a parama);
  
  public void a(b paramb) {}
  
  public final int oP()
  {
    int i = oQ();
    this.aUI = i;
    return i;
  }
  
  public int oQ()
  {
    return 0;
  }
  
  public String toString()
  {
    return f.c(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.a.a.e
 * JD-Core Version:    0.7.0.1
 */