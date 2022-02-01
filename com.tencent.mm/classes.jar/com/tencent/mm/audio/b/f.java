package com.tencent.mm.audio.b;

public abstract class f
{
  protected int cVG = -123456789;
  protected f.a cVZ;
  protected int cWv = 0;
  protected boolean mIsPause = false;
  
  public abstract boolean Og();
  
  public final int Oj()
  {
    return this.cWv;
  }
  
  public final void a(f.a parama)
  {
    this.cVZ = parama;
  }
  
  public abstract void cu(boolean paramBoolean);
  
  public final void hI(int paramInt)
  {
    this.cVG = paramInt;
  }
  
  public abstract void stopRecord();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b.f
 * JD-Core Version:    0.7.0.1
 */