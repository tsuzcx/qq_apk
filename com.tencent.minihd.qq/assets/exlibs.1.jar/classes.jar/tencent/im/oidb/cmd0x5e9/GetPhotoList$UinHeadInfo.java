package tencent.im.oidb.cmd0x5e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetPhotoList$UinHeadInfo
  extends MessageMicro
{
  public static final int RPT_MSG_HEADINFO_FIELD_NUMBER = 4;
  public static final int UINT32_HEADCOUNT_FIELD_NUMBER = 3;
  public static final int UINT32_TIMESTAMP_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_uin", "uint32_timestamp", "uint32_headcount", "rpt_msg_headinfo" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null }, UinHeadInfo.class);
  public final PBRepeatMessageField rpt_msg_headinfo = PBField.initRepeatMessage(GetPhotoList.HeadInfo.class);
  public final PBUInt32Field uint32_headcount = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e9.GetPhotoList.UinHeadInfo
 * JD-Core Version:    0.7.0.1
 */