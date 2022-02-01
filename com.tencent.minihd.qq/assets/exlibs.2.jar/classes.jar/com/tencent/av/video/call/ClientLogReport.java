package com.tencent.av.video.call;

import com.qq.jce.wup.UniPacket;
import com.tencent.av.video.jce.QQService.strupbuff;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.log.AVLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientLogReport
{
  private static final int GACSReportNewKey = 2085;
  private static final int GACSReportNewKey2 = 2207;
  private static final int LogSendRet_FAIL = 0;
  private static final int LogSendRet_OK = 1;
  private static final int LogSendRet_PENDING = 2;
  private static final String NewGACSReport = "dc02085";
  private static final String NewGACSReport2 = "dc02207";
  private static final String ServerFilterKey = "video_log";
  private static final String TAG = "ClientLogReport";
  private static final String UdpCheckResultServerFilterKey = "video_udpcheck_log";
  private static ClientLogReport instance;
  private VideoChannelInterface mVideoChannel;
  
  static
  {
    try
    {
      cacheMethodIds();
      return;
    }
    catch (Throwable localThrowable)
    {
      AVLog.e("ClientLogReport", "cacheMethodIds fail.", localThrowable);
    }
  }
  
  private ClientLogReport()
  {
    try
    {
      init();
      return;
    }
    catch (Throwable localThrowable)
    {
      AVLog.e("ClientLogReport", "init fail.", localThrowable);
    }
  }
  
  private static native void cacheMethodIds();
  
  private native void init();
  
  public static ClientLogReport instance()
  {
    if (instance == null) {
      instance = new ClientLogReport();
    }
    return instance;
  }
  
  private int sendLog(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AVLog.e("ClientLogReport", "sendLog log is empty.");
      return 0;
    }
    if (this.mVideoChannel == null)
    {
      AVLog.e("ClientLogReport", "sendLog mVideoChannel is null.");
      return 0;
    }
    Object localObject = String.valueOf(paramInt);
    if (paramInt == 0) {
      localObject = "video_log";
    }
    for (;;)
    {
      try
      {
        ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
        localConcurrentHashMap.put(localObject, new ArrayList());
        ((ArrayList)localConcurrentHashMap.get(localObject)).add(paramArrayOfByte);
        paramArrayOfByte = new strupbuff();
        paramArrayOfByte.logstring = localConcurrentHashMap;
        localObject = new UniPacket(true);
        ((UniPacket)localObject).put("Data", paramArrayOfByte);
        paramArrayOfByte = ((UniPacket)localObject).encode();
        AVLog.d("ClientLogReport", String.format("sendLog without response length=%s wupBuf=%s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Arrays.toString(paramArrayOfByte) }));
        this.mVideoChannel.sendLogReportMsg(paramLong, paramArrayOfByte);
        return 1;
      }
      catch (Throwable paramArrayOfByte)
      {
        AVLog.e("ClientLogReport", "callbackSendLog fail.", paramArrayOfByte);
      }
      if (paramInt == 1) {
        localObject = "video_udpcheck_log";
      } else if (paramInt == 2085) {
        localObject = "dc02085";
      } else if (paramInt == 2207) {
        localObject = "dc02207";
      }
    }
    return 0;
  }
  
  public int callbackSendLog(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    AVLog.d("ClientLogReport", String.format("callbackSendLog sendUin=%s topicId=%s log=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramArrayOfByte }));
    return sendLog(paramLong, paramInt, paramArrayOfByte);
  }
  
  public void setVideoChannel(VideoChannelInterface paramVideoChannelInterface)
  {
    this.mVideoChannel = paramVideoChannelInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.video.call.ClientLogReport
 * JD-Core Version:    0.7.0.1
 */