package com.google.android.exoplayer2.h;

import java.io.IOException;

public class s$c
  extends IOException
{
  public final j aQI;
  public final int type;
  
  public s$c(IOException paramIOException, j paramj, int paramInt)
  {
    super(paramIOException);
    this.aQI = paramj;
    this.type = paramInt;
  }
  
  public s$c(String paramString, j paramj)
  {
    super(paramString);
    this.aQI = paramj;
    this.type = 1;
  }
  
  public s$c(String paramString, IOException paramIOException, j paramj)
  {
    super(paramString, paramIOException);
    this.aQI = paramj;
    this.type = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.s.c
 * JD-Core Version:    0.7.0.1
 */