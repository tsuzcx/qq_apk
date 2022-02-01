package tencent.im.nearfield_date;

import appoint.define.appoint_define.AppointInfo;
import appoint.define.appoint_define.PublisherInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearby_date$UserProfile
  extends MessageMicro
{
  public static final int MSG_APPOINTS_INFO_FIELD_NUMBER = 2;
  public static final int MSG_PUBLISHER_INFO_FIELD_NUMBER = 1;
  public static final int RPT_UINT64_UIN_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_publisher_info", "msg_appoints_info", "rpt_uint64_uin" }, new Object[] { null, null, Long.valueOf(0L) }, UserProfile.class);
  public appoint_define.AppointInfo msg_appoints_info = new appoint_define.AppointInfo();
  public appoint_define.PublisherInfo msg_publisher_info = new appoint_define.PublisherInfo();
  public final PBRepeatField rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.nearfield_date.nearby_date.UserProfile
 * JD-Core Version:    0.7.0.1
 */