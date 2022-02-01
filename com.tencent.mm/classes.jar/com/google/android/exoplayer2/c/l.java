package com.google.android.exoplayer2.c;

public abstract interface l
{
  public abstract long L(long paramLong);
  
  public abstract long getDurationUs();
  
  public abstract boolean up();
  
  public static final class a
    implements l
  {
    private final long bdM;
    
    public a(long paramLong)
    {
      this.bdM = paramLong;
    }
    
    public final long L(long paramLong)
    {
      return 0L;
    }
    
    public final long getDurationUs()
    {
      return this.bdM;
    }
    
    public final boolean up()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.l
 * JD-Core Version:    0.7.0.1
 */