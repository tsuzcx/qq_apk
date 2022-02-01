package com.google.android.exoplayer2.b;

public abstract class a
{
  public int flags;
  
  public void clear()
  {
    this.flags = 0;
  }
  
  public final void dY(int paramInt)
  {
    this.flags |= paramInt;
  }
  
  protected final boolean dZ(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public final boolean rU()
  {
    return dZ(-2147483648);
  }
  
  public final boolean rV()
  {
    return dZ(4);
  }
  
  public final boolean rW()
  {
    return dZ(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.b.a
 * JD-Core Version:    0.7.0.1
 */