package com.google.android.exoplayer2.h;

public final class p
  extends s.a
{
  private final boolean boV;
  private final int boW;
  private final int boX;
  private final w<? super g> bol;
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
    this.bol = paramw;
    this.boW = 8000;
    this.boX = 8000;
    this.boV = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.p
 * JD-Core Version:    0.7.0.1
 */