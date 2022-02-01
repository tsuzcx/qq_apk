package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$MsgDecodeTestPkg
  extends MessageMicro
{
  public static final int DECODE_FAIL_FMT_FIELD_NUMBER = 2;
  public static final int DECODE_FAIL_LINE_FIELD_NUMBER = 4;
  public static final int DECODE_FAIL_MSG_TYPE_FIELD_NUMBER = 3;
  public static final int DECODE_SUCC_FIELD_NUMBER = 1;
  public static final int DEFAULT_IP_FIELD_NUMBER = 7;
  public static final int ENCODE_FAIL_FMT_FIELD_NUMBER = 9;
  public static final int ENCODE_FAIL_LINE_FIELD_NUMBER = 11;
  public static final int ENCODE_FAIL_MSG_TYPE_FIELD_NUMBER = 10;
  public static final int ENCODE_SUCC_FIELD_NUMBER = 8;
  public static final int FAIL_BUF_FIELD_NUMBER = 6;
  public static final int IGNORE_MSG_TYPE_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 61, 64, 74, 82, 90 }, new String[] { "decode_succ", "decode_fail_fmt", "decode_fail_msg_type", "decode_fail_line", "ignore_msg_type", "fail_buf", "default_ip", "encode_succ", "encode_fail_fmt", "encode_fail_msg_type", "encode_fail_line" }, new Object[] { Long.valueOf(0L), null, null, null, null, null, Integer.valueOf(0), Long.valueOf(0L), null, null, null }, MsgDecodeTestPkg.class);
  public final PBRepeatMessageField decode_fail_fmt = PBField.initRepeatMessage(im_msg_body.MsgDecodeTestMapElem.class);
  public final PBRepeatMessageField decode_fail_line = PBField.initRepeatMessage(im_msg_body.MsgDecodeTestMapElem.class);
  public final PBRepeatMessageField decode_fail_msg_type = PBField.initRepeatMessage(im_msg_body.MsgDecodeTestMapElem.class);
  public final PBUInt64Field decode_succ = PBField.initUInt64(0L);
  public final PBFixed32Field default_ip = PBField.initFixed32(0);
  public final PBRepeatMessageField encode_fail_fmt = PBField.initRepeatMessage(im_msg_body.MsgDecodeTestMapElem.class);
  public final PBRepeatMessageField encode_fail_line = PBField.initRepeatMessage(im_msg_body.MsgDecodeTestMapElem.class);
  public final PBRepeatMessageField encode_fail_msg_type = PBField.initRepeatMessage(im_msg_body.MsgDecodeTestMapElem.class);
  public final PBUInt64Field encode_succ = PBField.initUInt64(0L);
  public final PBRepeatMessageField fail_buf = PBField.initRepeatMessage(im_msg_body.MsgDecodeTestBufElem.class);
  public final PBRepeatMessageField ignore_msg_type = PBField.initRepeatMessage(im_msg_body.MsgDecodeTestMapElem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.MsgDecodeTestPkg
 * JD-Core Version:    0.7.0.1
 */