package tencent.im.mobiletips;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class MobileTips$MobileTipsPkg
  extends MessageMicro
{
  public static final int REQ_FIELD_NUMBER = 1;
  public static final int RSP_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "req", "rsp" }, new Object[] { null, null }, MobileTipsPkg.class);
  public MobileTips.ReqBody req = new MobileTips.ReqBody();
  public MobileTips.RspBody rsp = new MobileTips.RspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.mobiletips.MobileTips.MobileTipsPkg
 * JD-Core Version:    0.7.0.1
 */