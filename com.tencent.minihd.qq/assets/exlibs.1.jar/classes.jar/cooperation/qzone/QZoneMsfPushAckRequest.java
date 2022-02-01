package cooperation.qzone;

import PUSHAPI.PushRsp;
import common.config.service.WupTool;

public class QZoneMsfPushAckRequest
  extends QzoneExternalRequest
{
  public static final int a = 1000000;
  public static final String a = "wns.pushrsp";
  public static final int b = 1000006;
  private static final String b = "wns.pushrsp";
  private static final String c = "wns.pushrsp";
  private long a;
  
  public QZoneMsfPushAckRequest(long paramLong1, long paramLong2, String paramString)
  {
    super.a(paramLong1);
    super.b(paramLong1);
    super.d(paramString);
    this.a = paramLong2;
    this.b = false;
  }
  
  public String a()
  {
    return "wns.pushrsp";
  }
  
  protected byte[] a()
  {
    PushRsp localPushRsp = new PushRsp();
    localPushRsp.ptime = this.a;
    localPushRsp.is_bgd = 0;
    localPushRsp.sUID = "<JIEHEBAN>";
    return WupTool.a(localPushRsp);
  }
  
  public String f()
  {
    return "wns.pushrsp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneMsfPushAckRequest
 * JD-Core Version:    0.7.0.1
 */