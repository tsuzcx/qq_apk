package com.tencent.pb.chatbgInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class chatbgInfo$Bg_CheckAuth_Req
  extends MessageMicro
{
  public static final int IDLIST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "IdList" }, new Object[] { Integer.valueOf(0) }, Bg_CheckAuth_Req.class);
  public final PBRepeatField IdList = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.chatbgInfo.chatbgInfo.Bg_CheckAuth_Req
 * JD-Core Version:    0.7.0.1
 */