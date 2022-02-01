package com.google.android.exoplayer2.b;

public abstract class a
{
  public int flags;
  
  public final boolean Rx()
  {
    return hq(-2147483648);
  }
  
  public final boolean Ry()
  {
    return hq(4);
  }
  
  public final boolean Rz()
  {
    return hq(1);
  }
  
  public void clear()
  {
    this.flags = 0;
  }
  
  public final void hp(int paramInt)
  {
    this.flags |= paramInt;
  }
  
  protected final boolean hq(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.b.a
 * JD-Core Version:    0.7.0.1
 */