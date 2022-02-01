package tencent.im.sso.offlinpkg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class OfflinePkg$ReqBody
  extends MessageMicro
{
  public static final int ST_BID_PKG_FIELD_NUMBER = 3;
  public static final int UINT32_CMD_FIELD_NUMBER = 1;
  public static final int UINT32_PLATFORM_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_cmd", "uint32_platform", "st_bid_pkg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, ReqBody.class);
  public final PBRepeatMessageField st_bid_pkg = PBField.initRepeatMessage(OfflinePkg.BidPkg.class);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.sso.offlinpkg.OfflinePkg.ReqBody
 * JD-Core Version:    0.7.0.1
 */