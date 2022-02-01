package cooperation.qlink;

import java.io.Serializable;
import java.util.HashMap;

public class QlAndQQInterface$ReportPerformanceInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public long mDuration;
  public HashMap mParams;
  public long mSize;
  public boolean mSuccess;
  public String mTagName;
  public String mUin;
  
  public QlAndQQInterface$ReportPerformanceInfo(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap)
  {
    this.mUin = paramString1;
    this.mTagName = paramString2;
    this.mSuccess = paramBoolean;
    this.mDuration = paramLong1;
    this.mSize = paramLong2;
    this.mParams = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qlink.QlAndQQInterface.ReportPerformanceInfo
 * JD-Core Version:    0.7.0.1
 */