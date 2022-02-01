package com.tencent.pb.ppcloginauth;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class PPCLoginAuth$req
  extends MessageMicro
{
  public static final int COMM_FIELD_NUMBER = 1;
  public static final int REQCMD_0X01_FIELD_NUMBER = 2;
  public static final int REQCMD_0X02_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "comm", "reqcmd_0x01", "reqcmd_0x02" }, new Object[] { null, null, null }, req.class);
  public PPCLoginAuth.plat_info comm = new PPCLoginAuth.plat_info();
  public PPCLoginAuth.comering_req reqcmd_0x01 = new PPCLoginAuth.comering_req();
  public PPCLoginAuth.backgound_req reqcmd_0x02 = new PPCLoginAuth.backgound_req();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.ppcloginauth.PPCLoginAuth.req
 * JD-Core Version:    0.7.0.1
 */