package tencent.im.kqq.profilesvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GroupLocation$SetGroupLocationReq
  extends MessageMicro
{
  public static final int GROUPCODE_FIELD_NUMBER = 1;
  public static final int GROUPLOCATION_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "groupcode", "grouplocation" }, new Object[] { Integer.valueOf(0), "" }, SetGroupLocationReq.class);
  public final PBUInt32Field groupcode = PBField.initUInt32(0);
  public final PBStringField grouplocation = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.kqq.profilesvr.GroupLocation.SetGroupLocationReq
 * JD-Core Version:    0.7.0.1
 */