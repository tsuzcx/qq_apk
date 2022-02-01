package cooperation.qzone;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_req;
import com.qq.taf.jce.JceStruct;

public class QZoneRequestEncoder
  extends QzoneExternalRequest
{
  public static final String a = "getCover";
  private static final String b = "QzoneNewService.getCover";
  
  public QZoneRequestEncoder(long paramLong1, long paramLong2, int paramInt)
  {
    mobile_sub_get_cover_req localmobile_sub_get_cover_req = new mobile_sub_get_cover_req();
    localmobile_sub_get_cover_req.uin = paramLong1;
    localmobile_sub_get_cover_req.flag = paramInt;
    super.a(localmobile_sub_get_cover_req);
    super.a(paramLong1);
    super.b(paramLong2);
  }
  
  public static JceStruct a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return a(paramArrayOfByte, "getCover");
  }
  
  public String a()
  {
    return "getCover";
  }
  
  public String f()
  {
    return "QzoneNewService.getCover";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneRequestEncoder
 * JD-Core Version:    0.7.0.1
 */