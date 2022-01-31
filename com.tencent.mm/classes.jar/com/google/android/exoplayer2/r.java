package com.google.android.exoplayer2;

import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.source.i;

public abstract interface r
  extends f.b
{
  public abstract void a(t paramt, Format[] paramArrayOfFormat, i parami, long paramLong1, boolean paramBoolean, long paramLong2);
  
  public abstract void a(Format[] paramArrayOfFormat, i parami, long paramLong);
  
  public abstract void disable();
  
  public abstract void f(long paramLong1, long paramLong2);
  
  public abstract int getState();
  
  public abstract int getTrackType();
  
  public abstract boolean isReady();
  
  public abstract boolean kU();
  
  public abstract s kr();
  
  public abstract f ks();
  
  public abstract i kt();
  
  public abstract boolean ku();
  
  public abstract void kv();
  
  public abstract boolean kw();
  
  public abstract void kx();
  
  public abstract void p(long paramLong);
  
  public abstract void setIndex(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.r
 * JD-Core Version:    0.7.0.1
 */