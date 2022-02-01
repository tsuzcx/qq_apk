package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class group_feeds$GroupFeedsRecord$FaceRecord
  extends MessageMicro
{
  public static final int TYPE_FIELD_NUMBER = 14;
  public static final int UIN_FIELD_NUMBER = 13;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 109, 112 }, new String[] { "uin", "type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, FaceRecord.class);
  public final PBInt32Field type = PBField.initInt32(0);
  public final PBFixed32Field uin = PBField.initFixed32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsRecord.FaceRecord
 * JD-Core Version:    0.7.0.1
 */