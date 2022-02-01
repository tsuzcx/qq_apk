package tencent.im.cs.cmd0x352;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x352$RspBody
  extends MessageMicro
{
  public static final int BOOL_NEW_BIGCHAN_FIELD_NUMBER = 4;
  public static final int BYTES_FAIL_MSG_FIELD_NUMBER = 10;
  public static final int RPT_MSG_GETIMG_URL_RSP_FIELD_NUMBER = 3;
  public static final int RPT_MSG_TRYUP_IMG_RSP_FIELD_NUMBER = 2;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_new_bigchan = PBField.initBool(false);
  public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_msg_getimg_url_rsp = PBField.initRepeatMessage(cmd0x352.GetImgUrlRsp.class);
  public final PBRepeatMessageField rpt_msg_tryup_img_rsp = PBField.initRepeatMessage(cmd0x352.TryUpImgRsp.class);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 82 }, new String[] { "uint32_subcmd", "rpt_msg_tryup_img_rsp", "rpt_msg_getimg_url_rsp", "bool_new_bigchan", "bytes_fail_msg" }, new Object[] { Integer.valueOf(0), null, null, Boolean.valueOf(false), localByteStringMicro }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x352.cmd0x352.RspBody
 * JD-Core Version:    0.7.0.1
 */