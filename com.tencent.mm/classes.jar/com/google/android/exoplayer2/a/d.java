package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract interface d
{
  public static final ByteBuffer avY = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
  
  public abstract void c(ByteBuffer paramByteBuffer);
  
  public abstract void flush();
  
  public abstract boolean isActive();
  
  public abstract boolean kU();
  
  public abstract int kZ();
  
  public abstract int la();
  
  public abstract void lb();
  
  public abstract ByteBuffer lc();
  
  public abstract boolean q(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.a.d
 * JD-Core Version:    0.7.0.1
 */