package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7cb$TopicConfig
  extends MessageMicro
{
  public static final int STR_ERR_DEADLINE_FIELD_NUMBER = 4;
  public static final int STR_TOPIC_NAME_FIELD_NUMBER = 2;
  public static final int UINT32_DEADLINE_FIELD_NUMBER = 3;
  public static final int UINT32_TOPIC_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_topic_id", "str_topic_name", "uint32_deadline", "str_err_deadline" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "" }, TopicConfig.class);
  public final PBStringField str_err_deadline = PBField.initString("");
  public final PBStringField str_topic_name = PBField.initString("");
  public final PBUInt32Field uint32_deadline = PBField.initUInt32(0);
  public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7cb.TopicConfig
 * JD-Core Version:    0.7.0.1
 */