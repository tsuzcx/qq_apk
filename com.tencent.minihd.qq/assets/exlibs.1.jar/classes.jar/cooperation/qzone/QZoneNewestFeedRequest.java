package cooperation.qzone;

import NS_MOBILE_AIONewestFeed.AIONewestFeedReq;
import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class QZoneNewestFeedRequest
  extends QzoneExternalRequest
{
  public static final String a = "getAIONewestFeed";
  public static final String b = "getAIONewestFeed";
  private static final String c = "QzoneNewService.getAIONewestFeed";
  private static final String d = "getAIONewestFeed";
  
  public QZoneNewestFeedRequest(long paramLong1, ArrayList paramArrayList, long paramLong2, String paramString)
  {
    super.d(paramString);
    super.a(paramLong1);
    super.b(paramLong1);
    paramString = new AIONewestFeedReq();
    paramString.uOpUin = paramLong1;
    paramString.uHostUin = paramArrayList;
    paramString.uLastTime = paramLong2;
    super.a(paramString);
  }
  
  public static AIONewestFeedRsp a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    do
    {
      return paramArrayOfByte;
      paramQQAppInterface = (AIONewestFeedRsp)a(paramArrayOfByte, "getAIONewestFeed");
      paramArrayOfByte = paramQQAppInterface;
    } while (paramQQAppInterface != null);
    return null;
  }
  
  public String a()
  {
    return "getAIONewestFeed";
  }
  
  public String f()
  {
    return "QzoneNewService.getAIONewestFeed";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneNewestFeedRequest
 * JD-Core Version:    0.7.0.1
 */