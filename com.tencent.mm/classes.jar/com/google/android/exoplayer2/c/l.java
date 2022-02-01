package com.google.android.exoplayer2.c;

public abstract interface l
{
  public abstract long K(long paramLong);
  
  public abstract long getDurationUs();
  
  public abstract boolean sH();
  
  public static final class a
    implements l
  {
    private final long aSz;
    
    public a(long paramLong)
    {
      this.aSz = paramLong;
    }
    
    public final long K(long paramLong)
    {
      return 0L;
    }
    
    public final long getDurationUs()
    {
      return this.aSz;
    }
    
    public final boolean sH()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.l
 * JD-Core Version:    0.7.0.1
 */