package localpb.richMsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RichMsg$ForwardExtra
  extends MessageMicro
{
  public static final int FOWARD_ORGFILESIZETYPE_FIELD_NUMBER = 6;
  public static final int FOWARD_ORGID_FIELD_NUMBER = 1;
  public static final int FOWARD_ORGUINTYPE_FIELD_NUMBER = 3;
  public static final int FOWARD_ORGUIN_FIELD_NUMBER = 2;
  public static final int FOWARD_ORGURL_FIELD_NUMBER = 4;
  public static final int FOWARD_THUMBPATH_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48 }, new String[] { "foward_orgId", "foward_orgUin", "foward_orgUinType", "foward_orgUrl", "foward_thumbPath", "foward_orgFileSizeType" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), "", "", Integer.valueOf(0) }, ForwardExtra.class);
  public final PBInt32Field foward_orgFileSizeType = PBField.initInt32(0);
  public final PBUInt64Field foward_orgId = PBField.initUInt64(0L);
  public final PBStringField foward_orgUin = PBField.initString("");
  public final PBInt32Field foward_orgUinType = PBField.initInt32(0);
  public final PBStringField foward_orgUrl = PBField.initString("");
  public final PBStringField foward_thumbPath = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     localpb.richMsg.RichMsg.ForwardExtra
 * JD-Core Version:    0.7.0.1
 */