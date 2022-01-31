package com.tencent.mm.game.report.api;

public abstract class b
{
  public static b dCw;
  
  public abstract void a(long paramLong, a parama);
  
  public abstract void a(String paramString1, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, String paramString2, int paramInt3, int paramInt4, String paramString3, long paramLong4, int paramInt5, long paramLong5, String paramString4);
  
  public final void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, String paramString3)
  {
    a(paramString1, paramInt1, paramInt2, 0L, 0L, 0L, "", 0, 0, paramString2, 0L, 0, paramLong, paramString3);
  }
  
  public abstract void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public final void a(String paramString1, int paramInt, long paramLong1, String paramString2, long paramLong2)
  {
    a(paramString1, 0, paramInt, 0L, 0L, 0L, "", 0, 0, paramString2, paramLong2, 0, paramLong1, "");
  }
  
  public abstract a bu(long paramLong);
  
  public abstract void i(String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.game.report.api.b
 * JD-Core Version:    0.7.0.1
 */