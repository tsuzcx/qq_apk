package com.google.android.exoplayer2.c;

public abstract interface l
{
  public abstract long L(long paramLong);
  
  public abstract long getDurationUs();
  
  public abstract boolean sQ();
  
  public static final class a
    implements l
  {
    private final long aTs;
    
    public a(long paramLong)
    {
      this.aTs = paramLong;
    }
    
    public final long L(long paramLong)
    {
      return 0L;
    }
    
    public final long getDurationUs()
    {
      return this.aTs;
    }
    
    public final boolean sQ()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.l
 * JD-Core Version:    0.7.0.1
 */