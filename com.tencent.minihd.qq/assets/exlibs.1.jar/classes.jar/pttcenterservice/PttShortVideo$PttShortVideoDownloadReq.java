package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PttShortVideo$PttShortVideoDownloadReq
  extends MessageMicro
{
  public static final int BYTES_FILE_MD5_FIELD_NUMBER = 8;
  public static final int STR_FILEID_FIELD_NUMBER = 5;
  public static final int UINT32_AGENT_TYPE_FIELD_NUMBER = 7;
  public static final int UINT32_CHAT_TYPE_FIELD_NUMBER = 3;
  public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 4;
  public static final int UINT64_FROMUIN_FIELD_NUMBER = 1;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 6;
  public static final int UINT64_TOUIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_fileid = PBField.initString("");
  public final PBUInt32Field uint32_agent_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 66 }, new String[] { "uint64_fromuin", "uint64_touin", "uint32_chat_type", "uint32_client_type", "str_fileid", "uint64_group_code", "uint32_agent_type", "bytes_file_md5" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, PttShortVideoDownloadReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.PttShortVideoDownloadReq
 * JD-Core Version:    0.7.0.1
 */