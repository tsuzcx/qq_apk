package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x5fc$ReqBody
  extends MessageMicro
{
  public static final int UINT32_FETCH_COUNT_FIELD_NUMBER = 3;
  public static final int UINT64_LAST_EVENT_ID_FIELD_NUMBER = 1;
  public static final int UINT64_READ_EVENT_ID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_last_event_id", "uint64_read_event_id", "uint32_fetch_count" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_fetch_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_last_event_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_read_event_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5fc.ReqBody
 * JD-Core Version:    0.7.0.1
 */