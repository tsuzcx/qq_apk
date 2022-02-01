package com.tencent.qav.reporter;

import com.tencent.qav.observer.FilterableObserver;

public class DebugInfoObserver
  extends FilterableObserver
{
  public static final int MSG_ON_MONITER_INFO = 1;
  
  public void onNetworkMonitorInfo(String paramString, byte[] paramArrayOfByte1, long paramLong, byte[] paramArrayOfByte2) {}
  
  public void update(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    onNetworkMonitorInfo((String)paramVarArgs[0], (byte[])paramVarArgs[1], ((Long)paramVarArgs[2]).longValue(), (byte[])paramVarArgs[3]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.reporter.DebugInfoObserver
 * JD-Core Version:    0.7.0.1
 */