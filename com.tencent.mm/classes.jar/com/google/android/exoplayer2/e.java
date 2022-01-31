package com.google.android.exoplayer2;

import java.io.IOException;

public final class e
  extends Exception
{
  public final int atb;
  public final int type;
  
  private e(int paramInt1, Throwable paramThrowable, int paramInt2)
  {
    super(null, paramThrowable);
    this.type = paramInt1;
    this.atb = paramInt2;
  }
  
  public static e a(IOException paramIOException)
  {
    return new e(0, paramIOException, -1);
  }
  
  public static e a(Exception paramException, int paramInt)
  {
    return new e(1, paramException, paramInt);
  }
  
  static e b(RuntimeException paramRuntimeException)
  {
    return new e(2, paramRuntimeException, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.e
 * JD-Core Version:    0.7.0.1
 */