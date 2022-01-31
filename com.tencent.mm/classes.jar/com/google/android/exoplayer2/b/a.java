package com.google.android.exoplayer2.b;

public abstract class a
{
  public int flags;
  
  public final void cG(int paramInt)
  {
    this.flags |= paramInt;
  }
  
  protected final boolean cH(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public void clear()
  {
    this.flags = 0;
  }
  
  public final boolean lA()
  {
    return cH(1);
  }
  
  public final boolean ly()
  {
    return cH(-2147483648);
  }
  
  public final boolean lz()
  {
    return cH(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.b.a
 * JD-Core Version:    0.7.0.1
 */