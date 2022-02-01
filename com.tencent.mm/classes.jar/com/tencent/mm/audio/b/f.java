package com.tencent.mm.audio.b;

public abstract class f
{
  protected a hwI;
  protected int hwn = -123456789;
  protected int hxd = 0;
  protected boolean mIsPause = false;
  
  public final void a(a parama)
  {
    this.hwI = parama;
  }
  
  public abstract boolean aGR();
  
  public final int aGV()
  {
    return this.hxd;
  }
  
  public abstract void eq(boolean paramBoolean);
  
  public final void om(int paramInt)
  {
    this.hwn = paramInt;
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