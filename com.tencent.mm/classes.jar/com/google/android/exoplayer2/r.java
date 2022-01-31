package com.google.android.exoplayer2;

import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.source.l;

public abstract interface r
  extends f.b
{
  public abstract void a(t paramt, Format[] paramArrayOfFormat, l paraml, long paramLong1, boolean paramBoolean, long paramLong2);
  
  public abstract void a(Format[] paramArrayOfFormat, l paraml, long paramLong);
  
  public abstract void disable();
  
  public abstract void f(long paramLong1, long paramLong2);
  
  public abstract int getState();
  
  public abstract int getTrackType();
  
  public abstract boolean isReady();
  
  public abstract boolean mA();
  
  public abstract void mB();
  
  public abstract boolean mC();
  
  public abstract void mD();
  
  public abstract s mx();
  
  public abstract i my();
  
  public abstract l mz();
  
  public abstract void n(long paramLong);
  
  public abstract boolean nd();
  
  public abstract void setIndex(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.r
 * JD-Core Version:    0.7.0.1
 */