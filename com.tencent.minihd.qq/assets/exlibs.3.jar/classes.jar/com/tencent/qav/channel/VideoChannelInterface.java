package com.tencent.qav.channel;

public abstract interface VideoChannelInterface
{
  public abstract void sendGetGatewayMsg();
  
  public abstract void sendGetVideoConfig(byte[] paramArrayOfByte);
  
  public abstract void sendLogReportMsg(long paramLong, byte[] paramArrayOfByte);
  
  public abstract void sendMultiVideoMsg(long paramLong1, long paramLong2, byte[] paramArrayOfByte);
  
  public abstract void sendSharpVideoMsg(long paramLong, byte[] paramArrayOfByte);
  
  public abstract void setVideoChannelCallback(VideoChannelCallback paramVideoChannelCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.channel.VideoChannelInterface
 * JD-Core Version:    0.7.0.1
 */