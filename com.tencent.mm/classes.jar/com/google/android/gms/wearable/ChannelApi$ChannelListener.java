package com.google.android.gms.wearable;

@Deprecated
public abstract interface ChannelApi$ChannelListener
{
  public static final int CLOSE_REASON_DISCONNECTED = 1;
  public static final int CLOSE_REASON_LOCAL_CLOSE = 3;
  public static final int CLOSE_REASON_NORMAL = 0;
  public static final int CLOSE_REASON_REMOTE_CLOSE = 2;
  
  public abstract void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2);
  
  public abstract void onChannelOpened(Channel paramChannel);
  
  public abstract void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2);
  
  public abstract void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.ChannelApi.ChannelListener
 * JD-Core Version:    0.7.0.1
 */