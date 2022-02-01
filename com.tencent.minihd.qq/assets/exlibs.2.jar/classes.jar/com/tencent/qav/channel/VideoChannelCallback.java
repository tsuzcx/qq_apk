package com.tencent.qav.channel;

public abstract interface VideoChannelCallback
{
  public abstract void receiveGatewayMsg(String paramString, int paramInt);
  
  public abstract void receiveMultiVideoAck(byte[] paramArrayOfByte);
  
  public abstract void receiveMultiVideoMsg(byte[] paramArrayOfByte);
  
  public abstract void receiveMultiVideoOfflineMsg(byte[] paramArrayOfByte);
  
  public abstract void receiveSharpVideoAck(byte[] paramArrayOfByte);
  
  public abstract void receiveSharpVideoMsg(byte[] paramArrayOfByte);
  
  public abstract void receiveSharpVideoOfflineMsg(byte[] paramArrayOfByte);
  
  public abstract void receiveVideoConfig(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.qav.channel.VideoChannelCallback
 * JD-Core Version:    0.7.0.1
 */