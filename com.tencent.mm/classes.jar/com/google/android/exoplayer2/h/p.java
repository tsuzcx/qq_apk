package com.google.android.exoplayer2.h;

public final class p
  extends s.a
{
  private final x<? super g> bws;
  private final boolean bxc;
  private final int bxd;
  private final int bxe;
  private final String userAgent;
  
  public p(String paramString)
  {
    this(paramString, null);
  }
  
  public p(String paramString, x<? super g> paramx)
  {
    this(paramString, paramx, false);
  }
  
  public p(String paramString, x<? super g> paramx, boolean paramBoolean)
  {
    this.userAgent = paramString;
    this.bws = paramx;
    this.bxd = 8000;
    this.bxe = 8000;
    this.bxc = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.p
 * JD-Core Version:    0.7.0.1
 */