package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x388$GetPttUrlRsp
  extends MessageMicro
{
  public static final int BYTES_DOWN_DOMAIN_FIELD_NUMBER = 8;
  public static final int BYTES_DOWN_PARA_FIELD_NUMBER = 9;
  public static final int BYTES_FAIL_MSG_FIELD_NUMBER = 4;
  public static final int BYTES_FILE_MD5_FIELD_NUMBER = 2;
  public static final int RPT_BYTES_DOWN_URL_FIELD_NUMBER = 5;
  public static final int RPT_UINT32_DOWN_IP_FIELD_NUMBER = 6;
  public static final int RPT_UINT32_DOWN_PORT_FIELD_NUMBER = 7;
  public static final int UINT32_RESULT_FIELD_NUMBER = 3;
  public static final int UINT64_FILEID_FIELD_NUMBER = 1;
  public static final int UINT64_FILE_ID_FIELD_NUMBER = 10;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_down_domain = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField rpt_bytes_down_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField rpt_uint32_down_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField rpt_uint32_down_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_fileid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 56, 66, 74, 80 }, new String[] { "uint64_fileid", "bytes_file_md5", "uint32_result", "bytes_fail_msg", "rpt_bytes_down_url", "rpt_uint32_down_ip", "rpt_uint32_down_port", "bytes_down_domain", "bytes_down_para", "uint64_file_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L) }, GetPttUrlRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlRsp
 * JD-Core Version:    0.7.0.1
 */