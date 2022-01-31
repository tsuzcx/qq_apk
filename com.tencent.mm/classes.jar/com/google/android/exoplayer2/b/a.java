package com.google.android.exoplayer2.b;

public abstract class a
{
  public int flags;
  
  public void clear()
  {
    this.flags = 0;
  }
  
  public final void db(int paramInt)
  {
    this.flags |= paramInt;
  }
  
  protected final boolean dc(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public final boolean nD()
  {
    return dc(-2147483648);
  }
  
  public final boolean nE()
  {
    return dc(4);
  }
  
  public final boolean nF()
  {
    return dc(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.b.a
 * JD-Core Version:    0.7.0.1
 */