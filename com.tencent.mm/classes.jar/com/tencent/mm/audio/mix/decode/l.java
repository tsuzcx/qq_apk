package com.tencent.mm.audio.mix.decode;

import com.tencent.mm.al.b;
import com.tencent.mm.audio.mix.a.d;

public abstract interface l
{
  public abstract void aFB();
  
  public abstract void aFC();
  
  public abstract boolean aFF();
  
  public abstract boolean aFG();
  
  public abstract boolean aFH();
  
  public abstract d aFI();
  
  public abstract void aFL();
  
  public abstract b aFR();
  
  public abstract long getCurrentPosition();
  
  public abstract void init();
  
  public abstract void onRelease();
  
  public abstract void pause();
  
  public abstract void release();
  
  public abstract void resume();
  
  public abstract void seek(int paramInt);
  
  public abstract void setVolume(float paramFloat1, float paramFloat2);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.decode.l
 * JD-Core Version:    0.7.0.1
 */