package com.tencent.mm.audio.b;

public abstract class f
{
  protected int frZ = -123456789;
  protected int fsO = 0;
  protected a fss;
  protected boolean mIsPause = false;
  
  public final void a(a parama)
  {
    this.fss = parama;
  }
  
  public abstract boolean aeU();
  
  public final int aeX()
  {
    return this.fsO;
  }
  
  public abstract void dE(boolean paramBoolean);
  
  public final void kF(int paramInt)
  {
    this.frZ = paramInt;
  }
  
  public abstract void stopRecord();
  
  public static abstract interface a
  {
    public abstract void d(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.b.f
 * JD-Core Version:    0.7.0.1
 */