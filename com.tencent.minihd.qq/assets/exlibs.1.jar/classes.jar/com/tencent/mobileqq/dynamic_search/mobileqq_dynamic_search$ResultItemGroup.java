package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_dynamic_search$ResultItemGroup
  extends MessageMicro
{
  public static final int GROUP_MASK_FIELD_NUMBER = 1;
  public static final int GROUP_NAME_FIELD_NUMBER = 2;
  public static final int MORE_NAME_FIELD_NUMBER = 6;
  public static final int MORE_URL_FIELD_NUMBER = 5;
  public static final int RESULT_ITEMS_FIELD_NUMBER = 3;
  public static final int TOTAL_RESULT_COUNT_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field group_mask = PBField.initUInt32(0);
  public final PBBytesField group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField more_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField more_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField result_items = PBField.initRepeatMessage(mobileqq_dynamic_search.ResultItem.class);
  public final PBUInt64Field total_result_count = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50 }, new String[] { "group_mask", "group_name", "result_items", "total_result_count", "more_url", "more_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3 }, ResultItemGroup.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResultItemGroup
 * JD-Core Version:    0.7.0.1
 */