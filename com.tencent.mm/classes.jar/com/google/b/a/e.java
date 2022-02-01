package com.google.b.a;

import java.io.IOException;

public abstract class e
{
  protected volatile int ccR = -1;
  
  public static <T extends e> T a(T paramT, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new a(paramArrayOfByte, paramInt);
      paramT.a(paramArrayOfByte);
      paramArrayOfByte.gy(0);
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
    byte[] arrayOfByte = new byte[parame.Ad()];
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
  
  public final int Ad()
  {
    int i = JG();
    this.ccR = i;
    return i;
  }
  
  public final int JF()
  {
    if (this.ccR < 0) {
      Ad();
    }
    return this.ccR;
  }
  
  protected int JG()
  {
    return 0;
  }
  
  public abstract e a(a parama);
  
  public void a(b paramb) {}
  
  public String toString()
  {
    return f.c(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.a.e
 * JD-Core Version:    0.7.0.1
 */