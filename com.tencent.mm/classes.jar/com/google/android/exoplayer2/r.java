package com.google.android.exoplayer2;

import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.source.n;

public abstract interface r
  extends f.b
{
  public abstract void a(t paramt, Format[] paramArrayOfFormat, n paramn, long paramLong1, boolean paramBoolean, long paramLong2);
  
  public abstract void a(Format[] paramArrayOfFormat, n paramn, long paramLong);
  
  public abstract void disable();
  
  public abstract void f(long paramLong1, long paramLong2);
  
  public abstract int getState();
  
  public abstract int getTrackType();
  
  public abstract boolean isReady();
  
  public abstract s qK();
  
  public abstract i qL();
  
  public abstract n qM();
  
  public abstract boolean qN();
  
  public abstract void qO();
  
  public abstract boolean qP();
  
  public abstract void qQ();
  
  public abstract boolean rt();
  
  public abstract void setIndex(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract void w(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.r
 * JD-Core Version:    0.7.0.1
 */