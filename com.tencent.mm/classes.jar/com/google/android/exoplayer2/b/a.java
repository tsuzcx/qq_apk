package com.google.android.exoplayer2.b;

public abstract class a
{
  public int flags;
  
  public void clear()
  {
    this.flags = 0;
  }
  
  public final void dL(int paramInt)
  {
    this.flags |= paramInt;
  }
  
  protected final boolean dM(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public final boolean sA()
  {
    return dM(1);
  }
  
  public final boolean sy()
  {
    return dM(-2147483648);
  }
  
  public final boolean sz()
  {
    return dM(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.b.a
 * JD-Core Version:    0.7.0.1
 */