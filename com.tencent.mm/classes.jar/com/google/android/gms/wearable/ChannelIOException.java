package com.google.android.gms.wearable;

import java.io.IOException;

public class ChannelIOException
  extends IOException
{
  private final int zzbSR;
  private final int zzbSS;
  
  public ChannelIOException(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString);
    this.zzbSR = paramInt1;
    this.zzbSS = paramInt2;
  }
  
  public int getAppSpecificErrorCode()
  {
    return this.zzbSS;
  }
  
  public int getCloseReason()
  {
    return this.zzbSR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.ChannelIOException
 * JD-Core Version:    0.7.0.1
 */