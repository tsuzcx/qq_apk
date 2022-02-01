package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract interface d
{
  public static final ByteBuffer cIl = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
  
  public abstract boolean C(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean QU();
  
  public abstract int Rb();
  
  public abstract int Rc();
  
  public abstract void Rd();
  
  public abstract ByteBuffer Re();
  
  public abstract void d(ByteBuffer paramByteBuffer);
  
  public abstract void flush();
  
  public abstract boolean isActive();
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.d
 * JD-Core Version:    0.7.0.1
 */