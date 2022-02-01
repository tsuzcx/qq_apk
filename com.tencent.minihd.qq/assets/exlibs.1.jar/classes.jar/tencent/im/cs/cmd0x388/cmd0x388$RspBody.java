package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x388$RspBody
  extends MessageMicro
{
  public static final int RPT_MSG_GETIMG_URL_RSP_FIELD_NUMBER = 4;
  public static final int RPT_MSG_GETPTT_URL_RSP_FIELD_NUMBER = 6;
  public static final int RPT_MSG_TRYUP_IMG_RSP_FIELD_NUMBER = 3;
  public static final int RPT_MSG_TRYUP_PTT_RSP_FIELD_NUMBER = 5;
  public static final int UINT32_CLIENT_IP_FIELD_NUMBER = 1;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "uint32_client_ip", "uint32_subcmd", "rpt_msg_tryup_img_rsp", "rpt_msg_getimg_url_rsp", "rpt_msg_tryup_ptt_rsp", "rpt_msg_getptt_url_rsp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null }, RspBody.class);
  public final PBRepeatMessageField rpt_msg_getimg_url_rsp = PBField.initRepeatMessage(cmd0x388.GetImgUrlRsp.class);
  public final PBRepeatMessageField rpt_msg_getptt_url_rsp = PBField.initRepeatMessage(cmd0x388.GetPttUrlRsp.class);
  public final PBRepeatMessageField rpt_msg_tryup_img_rsp = PBField.initRepeatMessage(cmd0x388.TryUpImgRsp.class);
  public final PBRepeatMessageField rpt_msg_tryup_ptt_rsp = PBField.initRepeatMessage(cmd0x388.TryUpPttRsp.class);
  public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.RspBody
 * JD-Core Version:    0.7.0.1
 */