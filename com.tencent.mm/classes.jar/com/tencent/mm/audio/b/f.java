package com.tencent.mm.audio.b;

public abstract class f
{
  protected a dzD;
  protected int dzZ = 0;
  protected int dzk = -123456789;
  protected boolean mIsPause = false;
  
  public final void a(a parama)
  {
    this.dzD = parama;
  }
  
  public abstract boolean aai();
  
  public final int aal()
  {
    return this.dzZ;
  }
  
  public abstract void de(boolean paramBoolean);
  
  public final void jl(int paramInt)
  {
    this.dzk = paramInt;
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