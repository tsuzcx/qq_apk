package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class structmsg$FlagInfo
  extends MessageMicro
{
  public static final int GRPMSG_HIDDENGRP_FIELD_NUMBER = 2;
  public static final int GRPMSG_KICK_ADMIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "GrpMsg_Kick_Admin", "GrpMsg_HiddenGrp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, FlagInfo.class);
  public final PBUInt32Field GrpMsg_HiddenGrp = PBField.initUInt32(0);
  public final PBUInt32Field GrpMsg_Kick_Admin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.FlagInfo
 * JD-Core Version:    0.7.0.1
 */