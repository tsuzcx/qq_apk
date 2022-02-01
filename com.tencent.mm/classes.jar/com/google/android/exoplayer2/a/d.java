package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract interface d
{
  public static final ByteBuffer beO = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
  
  public abstract void f(ByteBuffer paramByteBuffer);
  
  public abstract void flush();
  
  public abstract boolean isActive();
  
  public abstract boolean p(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void reset();
  
  public abstract boolean tB();
  
  public abstract int tH();
  
  public abstract void tI();
  
  public abstract ByteBuffer tJ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.a.d
 * JD-Core Version:    0.7.0.1
 */