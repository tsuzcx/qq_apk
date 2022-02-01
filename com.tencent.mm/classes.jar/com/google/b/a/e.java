package com.google.b.a;

import java.io.IOException;

public abstract class e
{
  protected volatile int bGA = -1;
  
  public static <T extends e> T a(T paramT, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new a(paramArrayOfByte, paramInt);
      paramT.a(paramArrayOfByte);
      paramArrayOfByte.fB(0);
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
    byte[] arrayOfByte = new byte[parame.xS()];
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
  
  public String toString()
  {
    return f.c(this);
  }
  
  public final int xR()
  {
    if (this.bGA < 0) {
      xS();
    }
    return this.bGA;
  }
  
  public final int xS()
  {
    int i = xT();
    this.bGA = i;
    return i;
  }
  
  protected int xT()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.e
 * JD-Core Version:    0.7.0.1
 */