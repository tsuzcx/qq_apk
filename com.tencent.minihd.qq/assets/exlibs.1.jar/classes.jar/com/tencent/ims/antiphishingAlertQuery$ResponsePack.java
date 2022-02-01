package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class antiphishingAlertQuery$ResponsePack
  extends MessageMicro
{
  public static final int STR_DIALOG_BTN_LEFT_FIELD_NUMBER = 7;
  public static final int STR_DIALOG_BTN_RIGHT_FIELD_NUMBER = 8;
  public static final int STR_DIALOG_TEXT_FIELD_NUMBER = 6;
  public static final int STR_DIALOG_TITLE_FIELD_NUMBER = 5;
  public static final int STR_DOWNLOAD_LINK_FIELD_NUMBER = 10;
  public static final int STR_HASH_FIELD_NUMBER = 11;
  public static final int STR_TOAST_FIELD_NUMBER = 4;
  public static final int U32_ALERT_TYPE_FIELD_NUMBER = 2;
  public static final int U32_APP_TYPE_FIELD_NUMBER = 1;
  public static final int U32_DEFAULT_WORDING_FIELD_NUMBER = 3;
  public static final int U32_SEQ_FIELD_NUMBER = 12;
  public static final int U32_SVR_URL_VER_FIELD_NUMBER = 9;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 72, 82, 90, 96 }, new String[] { "u32_app_type", "u32_alert_type", "u32_default_wording", "str_toast", "str_dialog_title", "str_dialog_text", "str_dialog_btn_left", "str_dialog_btn_right", "u32_svr_url_ver", "str_download_link", "str_hash", "u32_seq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), "", "", Integer.valueOf(0) }, ResponsePack.class);
  public final PBStringField str_dialog_btn_left = PBField.initString("");
  public final PBStringField str_dialog_btn_right = PBField.initString("");
  public final PBStringField str_dialog_text = PBField.initString("");
  public final PBStringField str_dialog_title = PBField.initString("");
  public final PBStringField str_download_link = PBField.initString("");
  public final PBStringField str_hash = PBField.initString("");
  public final PBStringField str_toast = PBField.initString("");
  public final PBUInt32Field u32_alert_type = PBField.initUInt32(0);
  public final PBUInt32Field u32_app_type = PBField.initUInt32(0);
  public final PBUInt32Field u32_default_wording = PBField.initUInt32(0);
  public final PBUInt32Field u32_seq = PBField.initUInt32(0);
  public final PBUInt32Field u32_svr_url_ver = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.ims.antiphishingAlertQuery.ResponsePack
 * JD-Core Version:    0.7.0.1
 */