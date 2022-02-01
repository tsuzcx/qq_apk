package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract interface d
{
  public static final ByteBuffer beR = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
  
  public abstract void f(ByteBuffer paramByteBuffer);
  
  public abstract void flush();
  
  public abstract boolean isActive();
  
  public abstract void reset();
  
  public abstract boolean s(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int tC();
  
  public abstract void tD();
  
  public abstract ByteBuffer tE();
  
  public abstract boolean tw();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.d
 * JD-Core Version:    0.7.0.1
 */