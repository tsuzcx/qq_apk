package com.tencent.device.file;

import com.tencent.litetransfersdk.Session;

public abstract interface DeviceAVFileMsgObserver$DevMsgProcessor
{
  public abstract long a(String paramString, long paramLong);
  
  public abstract void a(Session paramSession);
  
  public abstract void a(Session paramSession, String paramString, long paramLong, int paramInt, float paramFloat);
  
  public abstract void a(Session paramSession, String paramString, long paramLong, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.file.DeviceAVFileMsgObserver.DevMsgProcessor
 * JD-Core Version:    0.7.0.1
 */