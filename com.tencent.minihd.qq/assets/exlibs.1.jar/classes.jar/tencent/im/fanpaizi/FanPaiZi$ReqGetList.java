package tencent.im.fanpaizi;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class FanPaiZi$ReqGetList
  extends MessageMicro
{
  public static final int BYTES_COOKIE_FIELD_NUMBER = 3;
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int MSG_LBS_INFO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public FanPaiZi.BusiReqHead msg_head = new FanPaiZi.BusiReqHead();
  public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_head", "msg_lbs_info", "bytes_cookie" }, new Object[] { null, null, localByteStringMicro }, ReqGetList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.fanpaizi.FanPaiZi.ReqGetList
 * JD-Core Version:    0.7.0.1
 */