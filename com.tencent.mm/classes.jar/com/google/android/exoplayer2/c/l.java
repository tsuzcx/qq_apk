package com.google.android.exoplayer2.c;

public abstract interface l
{
  public abstract long O(long paramLong);
  
  public abstract long getDurationUs();
  
  public abstract boolean so();
  
  public static final class a
    implements l
  {
    private final long aNk;
    
    public a(long paramLong)
    {
      this.aNk = paramLong;
    }
    
    public final long O(long paramLong)
    {
      return 0L;
    }
    
    public final long getDurationUs()
    {
      return this.aNk;
    }
    
    public final boolean so()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.l
 * JD-Core Version:    0.7.0.1
 */