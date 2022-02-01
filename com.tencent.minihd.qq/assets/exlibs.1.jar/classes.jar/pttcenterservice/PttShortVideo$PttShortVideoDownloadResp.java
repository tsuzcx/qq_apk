package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class PttShortVideo$PttShortVideoDownloadResp
  extends MessageMicro
{
  public static final int BYTES_DOWNLOADKEY_FIELD_NUMBER = 5;
  public static final int BYTES_FILE_MD5_FIELD_NUMBER = 6;
  public static final int INT32_RET_CODE_FIELD_NUMBER = 1;
  public static final int RPT_DIFF_AREA_OUT_ADDR_FIELD_NUMBER = 4;
  public static final int RPT_SAME_AREA_OUT_ADDR_FIELD_NUMBER = 3;
  public static final int STR_RET_MSG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_downloadkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_diff_area_out_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
  public final PBRepeatMessageField rpt_same_area_out_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
  public final PBStringField str_ret_msg = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "int32_ret_code", "str_ret_msg", "rpt_same_area_out_addr", "rpt_diff_area_out_addr", "bytes_downloadkey", "bytes_file_md5" }, new Object[] { Integer.valueOf(0), "", null, null, localByteStringMicro1, localByteStringMicro2 }, PttShortVideoDownloadResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.PttShortVideoDownloadResp
 * JD-Core Version:    0.7.0.1
 */