package tencent.im.oidb.cmd0x5e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class GetPhotoList$RspBody
  extends MessageMicro
{
  public static final int RPT_MSG_UIN_HEADS_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_uin_heads" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField rpt_msg_uin_heads = PBField.initRepeatMessage(GetPhotoList.UinHeadInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e9.GetPhotoList.RspBody
 * JD-Core Version:    0.7.0.1
 */