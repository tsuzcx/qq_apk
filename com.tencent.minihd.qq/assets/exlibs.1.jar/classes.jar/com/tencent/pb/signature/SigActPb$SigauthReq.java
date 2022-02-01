package com.tencent.pb.signature;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SigActPb$SigauthReq
  extends MessageMicro
{
  public static final int DATA_FIELD_NUMBER = 4;
  public static final int ITEMID_FIELD_NUMBER = 2;
  public static final int LEN_FIELD_NUMBER = 3;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field itemid = PBField.initInt32(0);
  public final PBInt32Field len = PBField.initInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uin", "itemid", "len", "data" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, SigauthReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.signature.SigActPb.SigauthReq
 * JD-Core Version:    0.7.0.1
 */