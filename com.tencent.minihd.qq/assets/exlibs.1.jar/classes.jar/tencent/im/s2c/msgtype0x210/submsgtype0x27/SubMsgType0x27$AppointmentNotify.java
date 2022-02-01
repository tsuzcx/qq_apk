package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$AppointmentNotify
  extends MessageMicro
{
  public static final int BYTES_EVENT_INFO_FIELD_NUMBER = 9;
  public static final int BYTES_SIG_FIELD_NUMBER = 8;
  public static final int STR_APPOINT_ID_FIELD_NUMBER = 2;
  public static final int STR_JOIN_WORDING_FIELD_NUMBER = 6;
  public static final int STR_TIPS_CONTENT_FIELD_NUMBER = 4;
  public static final int STR_VIEW_WORDING_FIELD_NUMBER = 7;
  public static final int UINT32_NOTIFYTYPE_FIELD_NUMBER = 3;
  public static final int UINT32_UNREAD_COUNT_FIELD_NUMBER = 5;
  public static final int UINT64_FROM_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_event_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_appoint_id = PBField.initString("");
  public final PBStringField str_join_wording = PBField.initString("");
  public final PBStringField str_tips_content = PBField.initString("");
  public final PBStringField str_view_wording = PBField.initString("");
  public final PBUInt32Field uint32_notifytype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50, 58, 66, 74 }, new String[] { "uint64_from_uin", "str_appoint_id", "uint32_notifytype", "str_tips_content", "uint32_unread_count", "str_join_wording", "str_view_wording", "bytes_sig", "bytes_event_info" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), "", Integer.valueOf(0), "", "", localByteStringMicro1, localByteStringMicro2 }, AppointmentNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify
 * JD-Core Version:    0.7.0.1
 */