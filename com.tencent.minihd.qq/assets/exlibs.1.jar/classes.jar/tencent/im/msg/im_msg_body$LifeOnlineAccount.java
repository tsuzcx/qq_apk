package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$LifeOnlineAccount
  extends MessageMicro
{
  public static final int UINT32_ACK_FIELD_NUMBER = 5;
  public static final int UINT32_OP_FIELD_NUMBER = 2;
  public static final int UINT32_REPORT_FIELD_NUMBER = 4;
  public static final int UINT32_SHOW_TIME_FIELD_NUMBER = 3;
  public static final int UINT64_BITMAP_FIELD_NUMBER = 6;
  public static final int UINT64_UNIQUE_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_unique_id", "uint32_op", "uint32_show_time", "uint32_report", "uint32_ack", "uint64_bitmap" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, LifeOnlineAccount.class);
  public final PBUInt32Field uint32_ack = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op = PBField.initUInt32(0);
  public final PBUInt32Field uint32_report = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_bitmap = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_unique_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.LifeOnlineAccount
 * JD-Core Version:    0.7.0.1
 */