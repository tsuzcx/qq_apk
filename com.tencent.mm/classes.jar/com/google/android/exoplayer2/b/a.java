package com.google.android.exoplayer2.b;

public abstract class a
{
  public int flags;
  
  public void clear()
  {
    this.flags = 0;
  }
  
  public final void dK(int paramInt)
  {
    this.flags |= paramInt;
  }
  
  protected final boolean dL(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public final boolean uc()
  {
    return dL(-2147483648);
  }
  
  public final boolean ud()
  {
    return dL(4);
  }
  
  public final boolean ue()
  {
    return dL(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.b.a
 * JD-Core Version:    0.7.0.1
 */