package com.tencent.mm.modelvideo;

public abstract interface b
{
  public abstract void a(a parama);
  
  public abstract void gj(String paramString);
  
  public abstract boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2);
  
  public abstract void p(String paramString1, String paramString2, String paramString3);
  
  public abstract void requestVideoData(String paramString, int paramInt1, int paramInt2);
  
  public static abstract interface a
  {
    public abstract void as(String paramString, int paramInt);
    
    public abstract void i(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onDataAvailable(String paramString, long paramLong1, long paramLong2);
    
    public abstract void sp(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.b
 * JD-Core Version:    0.7.0.1
 */