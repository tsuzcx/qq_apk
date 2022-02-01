package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class group_feeds$GroupCommentRecord
  extends MessageMicro
{
  public static final int BADNUM_FIELD_NUMBER = 11;
  public static final int CMMNT_ID_FIELD_NUMBER = 14;
  public static final int COMMENTTIME_FIELD_NUMBER = 7;
  public static final int CONTENT_FIELD_NUMBER = 13;
  public static final int FROMUIN_FIELD_NUMBER = 3;
  public static final int GOODNUM_FIELD_NUMBER = 10;
  public static final int GROUPCODE_FIELD_NUMBER = 2;
  public static final int LASTMODTIME_FIELD_NUMBER = 9;
  public static final int MSGFLAG_FIELD_NUMBER = 6;
  public static final int MSGTYPE_FIELD_NUMBER = 5;
  public static final int RESERVE_FIELD_NUMBER = 12;
  public static final int SECCMTID_FIELD_NUMBER = 15;
  public static final int SRVTIME_FIELD_NUMBER = 8;
  public static final int TOPICID_FIELD_NUMBER = 4;
  public static final int VERSION_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFixed32Field badnum = PBField.initFixed32(0);
  public final PBInt32Field cmmnt_id = PBField.initInt32(0);
  public final PBFixed32Field commenttime = PBField.initFixed32(0);
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field fromuin = PBField.initFixed32(0);
  public final PBFixed32Field goodnum = PBField.initFixed32(0);
  public final PBFixed32Field groupcode = PBField.initFixed32(0);
  public final PBFixed32Field lastmodtime = PBField.initFixed32(0);
  public final PBFixed32Field msgflag = PBField.initFixed32(0);
  public final PBInt32Field msgtype = PBField.initInt32(0);
  public final PBBytesField reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field seccmtid = PBField.initInt32(0);
  public final PBFixed32Field srvtime = PBField.initFixed32(0);
  public final PBBytesField topicid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field version = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 29, 34, 40, 53, 61, 69, 77, 85, 93, 98, 106, 112, 120 }, new String[] { "version", "groupcode", "fromuin", "topicid", "msgtype", "msgflag", "commenttime", "srvtime", "lastmodtime", "goodnum", "badnum", "reserve", "content", "cmmnt_id", "seccmtid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, GroupCommentRecord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupCommentRecord
 * JD-Core Version:    0.7.0.1
 */