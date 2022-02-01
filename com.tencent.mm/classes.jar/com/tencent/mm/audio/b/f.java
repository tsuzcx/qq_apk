package com.tencent.mm.audio.b;

public abstract class f
{
  protected a cYD;
  protected int cYZ = 0;
  protected int cYk = -123456789;
  protected boolean mIsPause = false;
  
  public abstract boolean Ok();
  
  public final int On()
  {
    return this.cYZ;
  }
  
  public final void a(a parama)
  {
    this.cYD = parama;
  }
  
  public abstract void ct(boolean paramBoolean);
  
  public final void hY(int paramInt)
  {
    this.cYk = paramInt;
  }
  
  public abstract void stopRecord();
  
  public static abstract interface a
  {
    public abstract void d(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.f
 * JD-Core Version:    0.7.0.1
 */