package com.tencent.mars.mm;

import com.tencent.mm.network.u;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public class MMLiveSpeedTestInterfaces
{
  private static final String TAG = "MMLiveSpeedTestInterfaces";
  private static MMLiveSpeedTestInterfaces mInstance = null;
  private static Map<Integer, u> speedTestCallbackMap = new HashMap();
  private static int speedTestTaskId = 1;
  
  public static MMLiveSpeedTestInterfaces getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new MMLiveSpeedTestInterfaces();
      }
      MMLiveSpeedTestInterfaces localMMLiveSpeedTestInterfaces = mInstance;
      return localMMLiveSpeedTestInterfaces;
    }
    finally {}
  }
  
  public int doLiveSpeedTest(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, u paramu)
  {
    if ((paramu == null) || (paramArrayOfByte1 == null) || (paramArrayOfByte2 == null))
    {
      paramString = new StringBuilder("speed test callback is null ");
      if (paramu == null)
      {
        bool = true;
        paramString = paramString.append(bool).append(" ");
        if (paramArrayOfByte1 != null) {
          break label95;
        }
        bool = true;
        label53:
        paramString = paramString.append(bool).append(" ");
        if (paramArrayOfByte2 != null) {
          break label101;
        }
      }
      label95:
      label101:
      for (boolean bool = true;; bool = false)
      {
        Log.e("MMLiveSpeedTestInterfaces", bool);
        return -1;
        bool = false;
        break;
        bool = false;
        break label53;
      }
    }
    try
    {
      int i = speedTestTaskId;
      speedTestTaskId += 1;
      speedTestCallbackMap.put(Integer.valueOf(i), paramu);
      Log.i("MMLiveSpeedTestInterfaces", "start speed test " + paramString + " " + paramArrayOfByte1.length + " " + paramArrayOfByte2.length + " id is " + i);
      Log.d("MMLiveSpeedTestInterfaces", "ctx is " + new String(paramArrayOfByte1) + " download " + new String(paramArrayOfByte2));
      paramu = new SpeedTestCtx();
      paramu.uploadCtx = paramArrayOfByte1;
      paramu.downloadCtx = paramArrayOfByte2;
      MMLogic.doLiveSpeedTest(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramu, i);
      return 0;
    }
    finally {}
  }
  
  public void onLiveSpeedTestCallback(LiveSpeedTestResult paramLiveSpeedTestResult, boolean paramBoolean)
  {
    Log.i("MMLiveSpeedTestInterfaces", "receive onSpeedTestUploadDone " + paramBoolean + " id " + paramLiveSpeedTestResult.taskId);
    for (;;)
    {
      u localu;
      try
      {
        localu = (u)speedTestCallbackMap.get(Integer.valueOf(paramLiveSpeedTestResult.taskId));
        if (localu == null)
        {
          Log.e("MMLiveSpeedTestInterfaces", "speed test callback is null");
          return;
        }
      }
      finally {}
      if (!paramBoolean) {}
      try
      {
        localu.a(paramLiveSpeedTestResult.pingRttSuccessful, paramLiveSpeedTestResult.averagePingRtt, paramLiveSpeedTestResult.pingJitter, paramLiveSpeedTestResult.uploadSuccessful, paramLiveSpeedTestResult.avgUploadSpeed, paramLiveSpeedTestResult.minUploadSpeed, paramLiveSpeedTestResult.maxUploadSpeed);
        while (paramBoolean)
        {
          try
          {
            speedTestCallbackMap.remove(Integer.valueOf(paramLiveSpeedTestResult.taskId));
            return;
          }
          finally
          {
            paramLiveSpeedTestResult = finally;
            throw paramLiveSpeedTestResult;
          }
          localu.a(paramLiveSpeedTestResult.pingRttSuccessful, paramLiveSpeedTestResult.averagePingRtt, paramLiveSpeedTestResult.pingJitter, paramLiveSpeedTestResult.uploadSuccessful, paramLiveSpeedTestResult.avgUploadSpeed, paramLiveSpeedTestResult.minUploadSpeed, paramLiveSpeedTestResult.maxUploadSpeed, paramLiveSpeedTestResult.downloadSuccessful, paramLiveSpeedTestResult.avgDownloadSpeed, paramLiveSpeedTestResult.minDownloadSpeed, paramLiveSpeedTestResult.maxDownloadSpeed);
        }
      }
      catch (Exception localException)
      {
        Log.e("MMLiveSpeedTestInterfaces", "error " + localException.toString());
        if (!paramBoolean) {
          continue;
        }
        try
        {
          speedTestCallbackMap.remove(Integer.valueOf(paramLiveSpeedTestResult.taskId));
          return;
        }
        finally
        {
          paramLiveSpeedTestResult = finally;
          throw paramLiveSpeedTestResult;
        }
      }
      finally
      {
        if (paramBoolean) {}
        try
        {
          speedTestCallbackMap.remove(Integer.valueOf(paramLiveSpeedTestResult.taskId));
          throw localObject;
        }
        finally {}
      }
    }
  }
  
  public static class LiveSpeedTestResult
  {
    public float averagePingRtt = 0.0F;
    public int avgDownloadSpeed = 0;
    public int avgUploadSpeed = 0;
    public boolean downloadSuccessful = false;
    public int maxDownloadSpeed = 0;
    public int maxUploadSpeed = 0;
    public int minDownloadSpeed = 0;
    public int minUploadSpeed = 0;
    public boolean onlyUploadDone = false;
    public float pingJitter = 0.0F;
    public boolean pingRttSuccessful = false;
    public int taskId = 0;
    public boolean uploadSuccessful = false;
  }
  
  public static class SpeedTestCtx
  {
    public byte[] downloadCtx = null;
    public byte[] uploadCtx = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mars.mm.MMLiveSpeedTestInterfaces
 * JD-Core Version:    0.7.0.1
 */