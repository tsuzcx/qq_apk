package tencent.im.fanpaizi;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FanPaiZi$RespGetList
  extends MessageMicro
{
  public static final int BYTES_COOKIE_FIELD_NUMBER = 3;
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int RPT_MSG_USER_LIST_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public FanPaiZi.BusiRespHead msg_head = new FanPaiZi.BusiRespHead();
  public final PBRepeatMessageField rpt_msg_user_list = PBField.initRepeatMessage(FanPaiZi.UserProfile.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_head", "rpt_msg_user_list", "bytes_cookie" }, new Object[] { null, null, localByteStringMicro }, RespGetList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.fanpaizi.FanPaiZi.RespGetList
 * JD-Core Version:    0.7.0.1
 */