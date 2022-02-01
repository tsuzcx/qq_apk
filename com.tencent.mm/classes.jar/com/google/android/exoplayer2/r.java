package com.google.android.exoplayer2;

import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.source.l;

public abstract interface r
  extends f.b
{
  public abstract void a(t paramt, Format[] paramArrayOfFormat, l paraml, long paramLong1, boolean paramBoolean, long paramLong2);
  
  public abstract void a(Format[] paramArrayOfFormat, l paraml, long paramLong);
  
  public abstract void disable();
  
  public abstract void e(long paramLong1, long paramLong2);
  
  public abstract int getState();
  
  public abstract int getTrackType();
  
  public abstract boolean isReady();
  
  public abstract s sR();
  
  public abstract i sS();
  
  public abstract l sT();
  
  public abstract boolean sU();
  
  public abstract void sV();
  
  public abstract boolean sW();
  
  public abstract void sX();
  
  public abstract void setIndex(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract boolean tw();
  
  public abstract void u(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.r
 * JD-Core Version:    0.7.0.1
 */