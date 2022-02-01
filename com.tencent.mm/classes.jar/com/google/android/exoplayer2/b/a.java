package com.google.android.exoplayer2.b;

public abstract class a
{
  public int flags;
  
  public void clear()
  {
    this.flags = 0;
  }
  
  public final void dM(int paramInt)
  {
    this.flags |= paramInt;
  }
  
  protected final boolean dN(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public final boolean sp()
  {
    return dN(-2147483648);
  }
  
  public final boolean sq()
  {
    return dN(4);
  }
  
  public final boolean sr()
  {
    return dN(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.b.a
 * JD-Core Version:    0.7.0.1
 */