package com.google.android.exoplayer2.h;

public final class p
  extends s.a
{
  private final boolean allowCrossProtocolRedirects;
  private final w<? super g> bEG;
  private final int connectTimeoutMillis;
  private final int readTimeoutMillis;
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
    this.bEG = paramw;
    this.connectTimeoutMillis = 8000;
    this.readTimeoutMillis = 8000;
    this.allowCrossProtocolRedirects = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.p
 * JD-Core Version:    0.7.0.1
 */