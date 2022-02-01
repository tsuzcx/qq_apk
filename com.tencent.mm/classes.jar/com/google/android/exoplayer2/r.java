package com.google.android.exoplayer2;

import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.source.m;

public abstract interface r
  extends f.b
{
  public abstract void a(t paramt, Format[] paramArrayOfFormat, m paramm, long paramLong1, boolean paramBoolean, long paramLong2);
  
  public abstract void a(Format[] paramArrayOfFormat, m paramm, long paramLong);
  
  public abstract void disable();
  
  public abstract void e(long paramLong1, long paramLong2);
  
  public abstract int getState();
  
  public abstract int getTrackType();
  
  public abstract boolean isReady();
  
  public abstract boolean rM();
  
  public abstract s rh();
  
  public abstract i ri();
  
  public abstract m rj();
  
  public abstract boolean rk();
  
  public abstract void rl();
  
  public abstract boolean rm();
  
  public abstract void rn();
  
  public abstract void s(long paramLong);
  
  public abstract void setIndex(int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.r
 * JD-Core Version:    0.7.0.1
 */