package com.google.android.exoplayer2.c;

public abstract interface l
{
  public abstract boolean RR();
  
  public abstract long cc(long paramLong);
  
  public abstract long getDurationUs();
  
  public static final class a
    implements l
  {
    private final long cHg;
    
    public a(long paramLong)
    {
      this.cHg = paramLong;
    }
    
    public final boolean RR()
    {
      return false;
    }
    
    public final long cc(long paramLong)
    {
      return 0L;
    }
    
    public final long getDurationUs()
    {
      return this.cHg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.l
 * JD-Core Version:    0.7.0.1
 */