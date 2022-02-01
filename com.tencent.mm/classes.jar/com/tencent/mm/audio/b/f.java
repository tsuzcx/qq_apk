package com.tencent.mm.audio.b;

public abstract class f
{
  protected int dhY = -123456789;
  protected int diO = 0;
  protected a dis;
  protected boolean mIsPause = false;
  
  public abstract boolean PO();
  
  public final int PR()
  {
    return this.diO;
  }
  
  public final void a(a parama)
  {
    this.dis = parama;
  }
  
  public abstract void cw(boolean paramBoolean);
  
  public final void hR(int paramInt)
  {
    this.dhY = paramInt;
  }
  
  public abstract void stopRecord();
  
  public static abstract interface a
  {
    public abstract void d(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b.f
 * JD-Core Version:    0.7.0.1
 */