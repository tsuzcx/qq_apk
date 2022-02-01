package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$MsgDecodeTestConfig
  extends MessageMicro
{
  public static final int COMPRESS_THRESHOLD_FIELD_NUMBER = 4;
  public static final int MAX_PKG_SIZE_FIELD_NUMBER = 3;
  public static final int REPORT_INTERVAL_FIELD_NUMBER = 5;
  public static final int SERVER_IP_FIELD_NUMBER = 1;
  public static final int SERVER_PORT_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 24, 32, 40 }, new String[] { "server_ip", "server_port", "max_pkg_size", "compress_threshold", "report_interval" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MsgDecodeTestConfig.class);
  public final PBUInt32Field compress_threshold = PBField.initUInt32(0);
  public final PBUInt32Field max_pkg_size = PBField.initUInt32(0);
  public final PBUInt32Field report_interval = PBField.initUInt32(0);
  public final PBFixed32Field server_ip = PBField.initFixed32(0);
  public final PBUInt32Field server_port = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.MsgDecodeTestConfig
 * JD-Core Version:    0.7.0.1
 */