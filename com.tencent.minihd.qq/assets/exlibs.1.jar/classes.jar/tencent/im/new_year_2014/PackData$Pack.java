package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackData$Pack
  extends MessageMicro
{
  public static final int BUSINESS_FIELD_NUMBER = 6;
  public static final int CTIME_FIELD_NUMBER = 4;
  public static final int ETIME_FIELD_NUMBER = 10;
  public static final int EXPIRED_FIELD_NUMBER = 12;
  public static final int LOCKED_FIELD_NUMBER = 13;
  public static final int MONEY_FIELD_NUMBER = 5;
  public static final int ORDER_FIELD_NUMBER = 14;
  public static final int PACK_ID_FIELD_NUMBER = 1;
  public static final int PEER_FACE_FIELD_NUMBER = 15;
  public static final int PEER_NICK_FIELD_NUMBER = 11;
  public static final int PEER_UIN_FIELD_NUMBER = 9;
  public static final int SIGNATURE_FIELD_NUMBER = 7;
  public static final int STATE_FIELD_NUMBER = 2;
  public static final int TYPE_FIELD_NUMBER = 3;
  public static final int URL_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field business = PBField.initUInt32(0);
  public final PBUInt32Field ctime = PBField.initUInt32(0);
  public final PBUInt32Field etime = PBField.initUInt32(0);
  public final PBBoolField expired = PBField.initBool(false);
  public final PBBoolField locked = PBField.initBool(false);
  public final PBUInt32Field money = PBField.initUInt32(0);
  public final PBStringField order = PBField.initString("");
  public final PBBytesField pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField peer_face = PBField.initString("");
  public final PBBytesField peer_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  public final PBBytesField signature = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field state = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 66, 72, 80, 90, 96, 104, 114, 122 }, new String[] { "pack_id", "state", "type", "ctime", "money", "business", "signature", "url", "peer_uin", "etime", "peer_nick", "expired", "locked", "order", "peer_face" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, "", Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, Boolean.valueOf(false), Boolean.valueOf(false), "", "" }, Pack.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.new_year_2014.PackData.Pack
 * JD-Core Version:    0.7.0.1
 */