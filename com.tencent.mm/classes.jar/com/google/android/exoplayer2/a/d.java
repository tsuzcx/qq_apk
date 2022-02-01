package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract interface d
{
  public static final ByteBuffer aOp = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
  
  public abstract void c(ByteBuffer paramByteBuffer);
  
  public abstract void flush();
  
  public abstract boolean isActive();
  
  public abstract boolean m(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void rA();
  
  public abstract ByteBuffer rB();
  
  public abstract void reset();
  
  public abstract boolean rt();
  
  public abstract int rz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.d
 * JD-Core Version:    0.7.0.1
 */