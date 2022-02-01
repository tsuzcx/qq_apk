package com.tencent.ilink.network;

public abstract interface DeviceCallbackInterface
{
  public abstract void OnFinishGetStrategy();
  
  public abstract void OnLonglinkConnected();
  
  public abstract void OnLonglinkDisconnected();
  
  public abstract void OnSessionTimeout();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.ilink.network.DeviceCallbackInterface
 * JD-Core Version:    0.7.0.1
 */