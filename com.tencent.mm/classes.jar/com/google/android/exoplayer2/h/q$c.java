package com.google.android.exoplayer2.h;

import java.io.IOException;

public class q$c
  extends IOException
{
  public final i aJa;
  public final int type;
  
  public q$c(IOException paramIOException, i parami, int paramInt)
  {
    super(paramIOException);
    this.aJa = parami;
    this.type = paramInt;
  }
  
  public q$c(String paramString, i parami)
  {
    super(paramString);
    this.aJa = parami;
    this.type = 1;
  }
  
  public q$c(String paramString, IOException paramIOException, i parami)
  {
    super(paramString, paramIOException);
    this.aJa = parami;
    this.type = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.h.q.c
 * JD-Core Version:    0.7.0.1
 */