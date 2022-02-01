package tencent.im.oidb.cmd0x897;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x897$VisitorInfo
  extends MessageMicro
{
  public static final int STRING_VISITOR_NICK_FIELD_NUMBER = 3;
  public static final int UINT32_VISITOR_FACEID_FIELD_NUMBER = 2;
  public static final int UINT64_VISITOR_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField string_visitor_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_visitor_faceid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_visitor_uin", "uint32_visitor_faceid", "string_visitor_nick" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, VisitorInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x897.cmd0x897.VisitorInfo
 * JD-Core Version:    0.7.0.1
 */