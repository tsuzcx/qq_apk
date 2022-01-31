package com.tencent.mm.audio.b;

public abstract class f
{
  protected f.a cjK;
  protected int cjs = -123456789;
  protected int ckg = 0;
  protected boolean mIsPause = false;
  
  public abstract boolean EC();
  
  public final int EF()
  {
    return this.ckg;
  }
  
  public final void a(f.a parama)
  {
    this.cjK = parama;
  }
  
  public abstract void bB(boolean paramBoolean);
  
  public final void gB(int paramInt)
  {
    this.cjs = paramInt;
  }
  
  public abstract void stopRecord();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.f
 * JD-Core Version:    0.7.0.1
 */