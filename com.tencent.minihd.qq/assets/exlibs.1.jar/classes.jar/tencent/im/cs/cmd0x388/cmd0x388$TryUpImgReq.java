package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x388$TryUpImgReq
  extends MessageMicro
{
  public static final int BYTES_BUILD_VER_FIELD_NUMBER = 13;
  public static final int BYTES_FILE_MD5_FIELD_NUMBER = 4;
  public static final int BYTES_FILE_NAME_FIELD_NUMBER = 6;
  public static final int UINT32_APP_PIC_TYPE_FIELD_NUMBER = 15;
  public static final int UINT32_BU_TYPE_FIELD_NUMBER = 9;
  public static final int UINT32_INNER_IP_FIELD_NUMBER = 14;
  public static final int UINT32_ORIGINAL_PIC_FIELD_NUMBER = 16;
  public static final int UINT32_PIC_HEIGHT_FIELD_NUMBER = 11;
  public static final int UINT32_PIC_TYPE_FIELD_NUMBER = 12;
  public static final int UINT32_PIC_WIDTH_FIELD_NUMBER = 10;
  public static final int UINT32_PLATFORM_TYPE_FIELD_NUMBER = 8;
  public static final int UINT32_SRC_TERM_FIELD_NUMBER = 7;
  public static final int UINT64_FILE_ID_FIELD_NUMBER = 3;
  public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 5;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  public static final int UINT64_SRC_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_app_pic_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bu_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_inner_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_original_pic = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56, 64, 72, 80, 88, 96, 106, 112, 120, 128 }, new String[] { "uint64_group_code", "uint64_src_uin", "uint64_file_id", "bytes_file_md5", "uint64_file_size", "bytes_file_name", "uint32_src_term", "uint32_platform_type", "uint32_bu_type", "uint32_pic_width", "uint32_pic_height", "uint32_pic_type", "bytes_build_ver", "uint32_inner_ip", "uint32_app_pic_type", "uint32_original_pic" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TryUpImgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.TryUpImgReq
 * JD-Core Version:    0.7.0.1
 */