package com.tencent.qav.controller.nodereport;

import android.content.Context;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.qav.log.AVLog;
import java.util.HashMap;

public class NodeReportOperator
{
  private static final String TAG = "NodeReportOperator";
  private Context mContext;
  private HashMap<Long, Long> mMsfTimestampMap = new HashMap();
  private long mSelfUin;
  private VcControllerImpl mVcCtrl;
  
  public NodeReportOperator(Context paramContext, long paramLong, VcControllerImpl paramVcControllerImpl)
  {
    this.mContext = paramContext;
    this.mSelfUin = paramLong;
    this.mVcCtrl = paramVcControllerImpl;
  }
  
  private long getChatRoom(long paramLong)
  {
    if (this.mVcCtrl != null) {
      return this.mVcCtrl.getChatRoomID(paramLong);
    }
    return 0L;
  }
  
  private static long strToLong(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      AVLog.e("NodeReportOperator", "strToLong fail.", paramString);
    }
    return 0L;
  }
  
  public void destroy()
  {
    this.mContext = null;
    this.mSelfUin = 0L;
    this.mVcCtrl = null;
    this.mMsfTimestampMap.clear();
  }
  
  public long getMsfInviteTimestamp(long paramLong)
  {
    long l = 0L;
    if (this.mMsfTimestampMap.containsKey(Long.valueOf(paramLong))) {
      l = ((Long)this.mMsfTimestampMap.get(Long.valueOf(paramLong))).longValue();
    }
    AVLog.d("NodeReportOperator", String.format("getMsfInviteTimestamp peerUin=%s timestamp=%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) }));
    return l;
  }
  
  public boolean nodeReport(long paramLong1, int paramInt, long paramLong2)
  {
    long l = getChatRoom(paramLong1);
    return nodeReport(this.mSelfUin, paramLong1, l, paramInt, paramLong2);
  }
  
  public boolean nodeReport(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4)
  {
    if (this.mVcCtrl != null)
    {
      AVLog.d("NodeReportOperator", String.format("nodeReport selfUin=%s peerUin=%s sessionId=%s node=%s timestamp=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramInt), Long.valueOf(paramLong4) }));
      return this.mVcCtrl.QuaReport(paramLong1, paramLong2, paramLong3, paramInt, paramLong4);
    }
    return false;
  }
  
  public void setMsfInviteTimestamp(long paramLong1, long paramLong2)
  {
    try
    {
      AVLog.d("NodeReportOperator", String.format("setMSFInviteTimeStamp peerUin=%s msfTimestamp=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      if ((paramLong1 > 0L) && (paramLong2 > 0L)) {
        this.mMsfTimestampMap.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      AVLog.d("NodeReportOperator", "setMSFInviteTimeStamp fail.", localThrowable);
    }
  }
  
  public int updateProcessInfo(long paramLong, String paramString1, String paramString2)
  {
    if (this.mVcCtrl != null)
    {
      AVLog.d("NodeReportOperator", String.format("updateProcessInfo peerUin=%s key=%s value=%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 }));
      return this.mVcCtrl.updateProcessInfo(paramLong, paramString1, paramString2);
    }
    return -1;
  }
  
  public int updateProcessInfo(String paramString1, String paramString2)
  {
    return updateProcessInfo(0L, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.controller.nodereport.NodeReportOperator
 * JD-Core Version:    0.7.0.1
 */