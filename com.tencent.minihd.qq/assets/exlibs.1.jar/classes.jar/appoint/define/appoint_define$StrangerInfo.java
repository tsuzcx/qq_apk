package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$StrangerInfo
  extends MessageMicro
{
  public static final int STR_CONSTELLATION_FIELD_NUMBER = 7;
  public static final int STR_NICKNAME_FIELD_NUMBER = 2;
  public static final int STR_VIPINFO_FIELD_NUMBER = 10;
  public static final int UINT32_AGE_FIELD_NUMBER = 3;
  public static final int UINT32_DATING_FIELD_NUMBER = 5;
  public static final int UINT32_GENDER_FIELD_NUMBER = 4;
  public static final int UINT32_LIST_IDX_FIELD_NUMBER = 6;
  public static final int UINT32_MARRIAGE_FIELD_NUMBER = 9;
  public static final int UINT32_PROFESSION_FIELD_NUMBER = 8;
  public static final int UINT32_RECOMMEND_FIELD_NUMBER = 11;
  public static final int UINT64_TINYID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58, 64, 72, 82, 88 }, new String[] { "uint64_tinyid", "str_nickname", "uint32_age", "uint32_gender", "uint32_dating", "uint32_list_idx", "str_constellation", "uint32_profession", "uint32_marriage", "str_vipinfo", "uint32_recommend" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, StrangerInfo.class);
  public final PBStringField str_constellation = PBField.initString("");
  public final PBStringField str_nickname = PBField.initString("");
  public final PBStringField str_vipinfo = PBField.initString("");
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dating = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_list_idx = PBField.initUInt32(0);
  public final PBUInt32Field uint32_marriage = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
  public final PBUInt32Field uint32_recommend = PBField.initUInt32(0);
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     appoint.define.appoint_define.StrangerInfo
 * JD-Core Version:    0.7.0.1
 */