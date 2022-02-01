package com.tencent.protofile.sdkauthorize;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SdkAuthorize$AuthItem
  extends MessageMicro
{
  public static final int API_LIST_FIELD_NUMBER = 4;
  public static final int DEFAULT_FLAG_FIELD_NUMBER = 1;
  public static final int ID_FIELD_NUMBER = 2;
  public static final int IS_NEW_FIELD_NUMBER = 5;
  public static final int LOGO_URL_FIELD_NUMBER = 6;
  public static final int TITLE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50 }, new String[] { "default_flag", "id", "title", "api_list", "is_new", "logo_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "" }, AuthItem.class);
  public final PBStringField api_list = PBField.initString("");
  public final PBSInt32Field default_flag = PBField.initSInt32(0);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBSInt32Field is_new = PBField.initSInt32(0);
  public final PBStringField logo_url = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthItem
 * JD-Core Version:    0.7.0.1
 */