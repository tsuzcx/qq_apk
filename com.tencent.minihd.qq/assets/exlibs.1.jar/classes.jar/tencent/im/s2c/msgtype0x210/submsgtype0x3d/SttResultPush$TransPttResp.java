package tencent.im.s2c.msgtype0x210.submsgtype0x3d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SttResultPush$TransPttResp
  extends MessageMicro
{
  public static final int BYTES_TEXT_FIELD_NUMBER = 8;
  public static final int STR_FILEMD5_FIELD_NUMBER = 12;
  public static final int STR_FILE_PATH_FIELD_NUMBER = 13;
  public static final int UINT32_ERROR_CODE_FIELD_NUMBER = 3;
  public static final int UINT32_FILEID_FIELD_NUMBER = 11;
  public static final int UINT32_LEN_FIELD_NUMBER = 7;
  public static final int UINT32_POS_FIELD_NUMBER = 6;
  public static final int UINT32_PTT_TYPE_FIELD_NUMBER = 2;
  public static final int UINT32_SEQ_FIELD_NUMBER = 5;
  public static final int UINT32_TOTAL_LEN_FIELD_NUMBER = 4;
  public static final int UINT64_RECEIVER_UIN_FIELD_NUMBER = 10;
  public static final int UINT64_SENDER_UIN_FIELD_NUMBER = 9;
  public static final int UINT64_SESSIONID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_Filemd5 = PBField.initString("");
  public final PBStringField str_file_path = PBField.initString("");
  public final PBUInt32Field uint32_FileID = PBField.initUInt32(0);
  public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_len = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pos = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ptt_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_len = PBField.initUInt32(0);
  public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72, 80, 88, 98, 106 }, new String[] { "uint64_sessionid", "uint32_ptt_type", "uint32_error_code", "uint32_total_len", "uint32_seq", "uint32_pos", "uint32_len", "bytes_text", "uint64_sender_uin", "uint64_receiver_uin", "uint32_FileID", "str_Filemd5", "str_file_path" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", "" }, TransPttResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.TransPttResp
 * JD-Core Version:    0.7.0.1
 */