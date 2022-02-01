package com.google.android.gms.wearable;

import java.io.IOException;

public class ChannelIOException
  extends IOException
{
  private final int zzg;
  private final int zzh;
  
  public ChannelIOException(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString);
    this.zzg = paramInt1;
    this.zzh = paramInt2;
  }
  
  public int getAppSpecificErrorCode()
  {
    return this.zzh;
  }
  
  public int getCloseReason()
  {
    return this.zzg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.ChannelIOException
 * JD-Core Version:    0.7.0.1
 */