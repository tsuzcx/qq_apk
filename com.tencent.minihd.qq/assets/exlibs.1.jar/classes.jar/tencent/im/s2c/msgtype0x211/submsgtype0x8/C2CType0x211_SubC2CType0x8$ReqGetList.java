package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class C2CType0x211_SubC2CType0x8$ReqGetList
  extends MessageMicro
{
  public static final int BYTES_COOKIE_FIELD_NUMBER = 4;
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int MSG_NEARFIELD_INFO_FIELD_NUMBER = 2;
  public static final int UINT32_SESSION_ID_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public C2CType0x211_SubC2CType0x8.BusiReqHead msg_head = new C2CType0x211_SubC2CType0x8.BusiReqHead();
  public C2CType0x211_SubC2CType0x8.NearfieldInfo msg_nearfield_info = new C2CType0x211_SubC2CType0x8.NearfieldInfo();
  public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg_head", "msg_nearfield_info", "uint32_session_id", "bytes_cookie" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, ReqGetList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.ReqGetList
 * JD-Core Version:    0.7.0.1
 */