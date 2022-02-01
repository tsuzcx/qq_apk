package com.tencent.mm.audio.b;

public abstract class f
{
  protected int dgW = -123456789;
  protected int dhL = 0;
  protected a dhp;
  protected boolean mIsPause = false;
  
  public abstract boolean PP();
  
  public final int PS()
  {
    return this.dhL;
  }
  
  public final void a(a parama)
  {
    this.dhp = parama;
  }
  
  public abstract void cw(boolean paramBoolean);
  
  public final void hP(int paramInt)
  {
    this.dgW = paramInt;
  }
  
  public abstract void stopRecord();
  
  public static abstract interface a
  {
    public abstract void d(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.b.f
 * JD-Core Version:    0.7.0.1
 */