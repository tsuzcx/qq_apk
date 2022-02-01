package tencent.im.s2c.msgtype0x211.submsgtype0xb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0xb$MsgBody$MsgHeader
  extends MessageMicro
{
  public static final int AUDIO_START_SUCCESS_NOTIFY = 102;
  public static final int REJECT_NOTIFY = 101;
  public static final int STR_TO_MOBILE_FIELD_NUMBER = 4;
  public static final int UINT32_BODY_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_SESSION_TYPE_FIELD_NUMBER = 2;
  public static final int UINT64_ROOM_ID_FIELD_NUMBER = 5;
  public static final int UINT64_TO_UIN_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint32_body_type", "uint32_session_type", "uint64_to_uin", "str_to_mobile", "uint64_room_id" }, new Object[] { Integer.valueOf(101), Integer.valueOf(0), Long.valueOf(0L), "", Long.valueOf(0L) }, MsgHeader.class);
  public final PBStringField str_to_mobile = PBField.initString("");
  public final PBEnumField uint32_body_type = PBField.initEnum(101);
  public final PBUInt32Field uint32_session_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_room_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader
 * JD-Core Version:    0.7.0.1
 */