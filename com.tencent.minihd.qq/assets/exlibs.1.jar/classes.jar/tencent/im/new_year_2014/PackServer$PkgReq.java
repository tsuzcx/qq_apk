package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackServer$PkgReq
  extends MessageMicro
{
  public static final int A8_FIELD_NUMBER = 21;
  public static final int APPID_FIELD_NUMBER = 22;
  public static final int CMDTYPE_FIELD_NUMBER = 1;
  public static final int FROM_ID_FIELD_NUMBER = 23;
  public static final int GET_NEW_PACK_FIELD_NUMBER = 3;
  public static final int GIVE_PACK_FIELD_NUMBER = 6;
  public static final int NET_TYPE_FIELD_NUMBER = 24;
  public static final int QUERY_LUCKY_USERS_FIELD_NUMBER = 9;
  public static final int QUERY_PACK_FIELD_NUMBER = 7;
  public static final int QUERY_PACK_LIST_FIELD_NUMBER = 4;
  public static final int QUERY_USER_HISTORY_FIELD_NUMBER = 8;
  public static final int SET_PACK_USED_FIELD_NUMBER = 5;
  public static final int SKEY_FIELD_NUMBER = 20;
  public static final int UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField a8 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt32Field cmdtype = PBField.initUInt32(0);
  public final PBUInt32Field from_id = PBField.initUInt32(0);
  public PackServer.GetNewPackReq get_new_pack = new PackServer.GetNewPackReq();
  public PackServer.GivePackReq give_pack = new PackServer.GivePackReq();
  public final PBUInt32Field net_type = PBField.initUInt32(0);
  public PackServer.QueryLuckyUsersReq query_lucky_users = new PackServer.QueryLuckyUsersReq();
  public PackServer.QueryPackReq query_pack = new PackServer.QueryPackReq();
  public PackServer.QueryPackListReq query_pack_list = new PackServer.QueryPackListReq();
  public PackServer.QueryUserHistoryReq query_user_history = new PackServer.QueryUserHistoryReq();
  public PackServer.SetPackUsedReq set_pack_used = new PackServer.SetPackUsedReq();
  public final PBBytesField skey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 162, 170, 176, 184, 192 }, new String[] { "cmdtype", "uin", "get_new_pack", "query_pack_list", "set_pack_used", "give_pack", "query_pack", "query_user_history", "query_lucky_users", "skey", "a8", "appid", "from_id", "net_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, null, null, null, null, null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PkgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer.PkgReq
 * JD-Core Version:    0.7.0.1
 */