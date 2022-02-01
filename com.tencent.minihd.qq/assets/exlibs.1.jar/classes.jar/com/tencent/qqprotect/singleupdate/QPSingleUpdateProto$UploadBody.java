package com.tencent.qqprotect.singleupdate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QPSingleUpdateProto$UploadBody
  extends MessageMicro
{
  public static final int BYTES_FAILED_REASON_FIELD_NUMBER = 3;
  public static final int BYTES_FAILED_STEP_FIELD_NUMBER = 2;
  public static final int UINT32_SUC_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_failed_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_failed_step = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_suc = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_suc", "bytes_failed_step", "bytes_failed_reason" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, UploadBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdateProto.UploadBody
 * JD-Core Version:    0.7.0.1
 */