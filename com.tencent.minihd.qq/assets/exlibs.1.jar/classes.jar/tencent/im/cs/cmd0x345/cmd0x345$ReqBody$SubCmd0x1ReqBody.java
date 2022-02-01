package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x345$ReqBody$SubCmd0x1ReqBody
  extends MessageMicro
{
  public static final int STR_FILE_NAME_FIELD_NUMBER = 3;
  public static final int STR_MD5_FIELD_NUMBER = 1;
  public static final int STR_SHA_FIELD_NUMBER = 2;
  public static final int UINT32_COSTOM_ID_FIELD_NUMBER = 8;
  public static final int UINT32_DISSCUS_UIN_FIELD_NUMBER = 6;
  public static final int UINT32_SENDER_UIN_FIELD_NUMBER = 7;
  public static final int UINT32_UPLOAD_TYPE_FIELD_NUMBER = 5;
  public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64 }, new String[] { "str_md5", "str_sha", "str_file_name", "uint64_file_size", "uint32_upload_type", "uint32_disscus_uin", "uint32_sender_uin", "uint32_costom_id" }, new Object[] { "", "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x1ReqBody.class);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_md5 = PBField.initString("");
  public final PBStringField str_sha = PBField.initString("");
  public final PBUInt32Field uint32_costom_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_disscus_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sender_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upload_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x1ReqBody
 * JD-Core Version:    0.7.0.1
 */