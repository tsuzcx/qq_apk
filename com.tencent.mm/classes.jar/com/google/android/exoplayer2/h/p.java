package com.google.android.exoplayer2.h;

public final class p
  extends s.a
{
  private final w<? super g> bEI;
  private final boolean bFs;
  private final int bFt;
  private final int bFu;
  private final String userAgent;
  
  public p(String paramString)
  {
    this(paramString, null);
  }
  
  public p(String paramString, w<? super g> paramw)
  {
    this(paramString, paramw, false);
  }
  
  public p(String paramString, w<? super g> paramw, boolean paramBoolean)
  {
    this.userAgent = paramString;
    this.bEI = paramw;
    this.bFt = 8000;
    this.bFu = 8000;
    this.bFs = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.h.p
 * JD-Core Version:    0.7.0.1
 */