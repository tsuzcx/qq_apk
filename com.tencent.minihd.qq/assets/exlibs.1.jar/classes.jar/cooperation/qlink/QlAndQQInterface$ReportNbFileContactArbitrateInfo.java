package cooperation.qlink;

import java.io.Serializable;
import java.util.Random;

public class QlAndQQInterface$ReportNbFileContactArbitrateInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public final int _id;
  public boolean eResult;
  public String param_errMsg;
  public int param_failCode;
  public int param_result;
  public int param_source;
  public String reserved;
  public long rpSize;
  public long startTime;
  
  public QlAndQQInterface$ReportNbFileContactArbitrateInfo(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    this.eResult = paramBoolean;
    this.startTime = 0L;
    this.rpSize = 0L;
    this.param_failCode = paramInt1;
    this.param_result = paramInt2;
    this.param_errMsg = paramString1;
    this.param_source = paramInt3;
    this.reserved = paramString2;
    this._id = new Random().nextInt();
  }
  
  public String toString()
  {
    return "_id[" + this._id + "]eResult[" + this.eResult + "] startTime[" + this.startTime + "] rpSize[" + this.rpSize + "] param_failCode[" + this.param_failCode + "] param_result[" + this.param_result + "] param_errMsg[" + this.param_errMsg + "] param_source[" + this.param_source + "] reserved[" + this.reserved + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qlink.QlAndQQInterface.ReportNbFileContactArbitrateInfo
 * JD-Core Version:    0.7.0.1
 */