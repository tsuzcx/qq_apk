package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7de$RspBody
  extends MessageMicro
{
  public static final int BYTES_COOKIE_FIELD_NUMBER = 4;
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int RPT_MSG_USER_LIST_FIELD_NUMBER = 2;
  public static final int UINT32_ENDED_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public cmd0x7de.BusiRespHead msg_head = new cmd0x7de.BusiRespHead();
  public final PBRepeatMessageField rpt_msg_user_list = PBField.initRepeatMessage(cmd0x7de.UserProfile.class);
  public final PBUInt32Field uint32_ended = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg_head", "rpt_msg_user_list", "uint32_ended", "bytes_cookie" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7de.RspBody
 * JD-Core Version:    0.7.0.1
 */