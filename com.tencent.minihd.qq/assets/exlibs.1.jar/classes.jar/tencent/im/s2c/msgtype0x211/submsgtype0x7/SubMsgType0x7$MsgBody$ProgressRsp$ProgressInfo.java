package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x7$MsgBody$ProgressRsp$ProgressInfo
  extends MessageMicro
{
  public static final int STR_FILENAME_FIELD_NUMBER = 5;
  public static final int UINT32_STATUS_FIELD_NUMBER = 3;
  public static final int UINT64_FILESIZE_FIELD_NUMBER = 4;
  public static final int UINT64_PROGRESS_FIELD_NUMBER = 2;
  public static final int UINT64_SESSIONID_FIELD_NUMBER = 1;
  public static final int UINT64_TIME_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "uint64_sessionid", "uint64_progress", "uint32_status", "uint64_filesize", "str_filename", "uint64_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), "", Long.valueOf(0L) }, ProgressInfo.class);
  public final PBStringField str_filename = PBField.initString("");
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_filesize = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_progress = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.ProgressRsp.ProgressInfo
 * JD-Core Version:    0.7.0.1
 */