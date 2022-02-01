package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class im_msg_body$Elem
  extends MessageMicro
{
  public static final int ANON_GROUP_MSG_FIELD_NUMBER = 21;
  public static final int BANKCODE_CTRL_INFO_FIELD_NUMBER = 29;
  public static final int CUSTOM_FACE_FIELD_NUMBER = 8;
  public static final int ELEM_FLAGS2_FIELD_NUMBER = 9;
  public static final int ELEM_FLAGS_FIELD_NUMBER = 7;
  public static final int EXTRA_INFO_FIELD_NUMBER = 16;
  public static final int FACE_FIELD_NUMBER = 2;
  public static final int FUN_FACE_FIELD_NUMBER = 10;
  public static final int GROUP_FILE_FIELD_NUMBER = 13;
  public static final int LIFE_ONLINE_FIELD_NUMBER = 23;
  public static final int MARKET_FACE_FIELD_NUMBER = 6;
  public static final int MARKET_TRANS_FIELD_NUMBER = 15;
  public static final int NOT_ONLINE_IMAGE_FIELD_NUMBER = 4;
  public static final int ONLINE_IMAGE_FIELD_NUMBER = 3;
  public static final int PUB_ACCOUNT_FIELD_NUMBER = 18;
  public static final int PUB_GROUP_FIELD_NUMBER = 14;
  public static final int QQWALLET_MSG_FIELD_NUMBER = 24;
  public static final int QQ_LIVE_OLD_FIELD_NUMBER = 22;
  public static final int RICH_MSG_FIELD_NUMBER = 12;
  public static final int SECRET_FILE_FIELD_NUMBER = 11;
  public static final int SHAKE_WINDOW_FIELD_NUMBER = 17;
  public static final int TEXT_FIELD_NUMBER = 1;
  public static final int TIPS_INFO_FIELD_NUMBER = 20;
  public static final int TRANS_ELEM_INFO_FIELD_NUMBER = 5;
  public static final int VIDEO_FILE_FIELD_NUMBER = 19;
  static final MessageMicro.FieldMap __fieldMap__;
  public im_msg_body.AnonymousGroupMsg anon_group_msg = new im_msg_body.AnonymousGroupMsg();
  public final PBBytesField bankcode_ctrl_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public im_msg_body.CustomFace custom_face = new im_msg_body.CustomFace();
  public im_msg_body.ElemFlags elem_flags = new im_msg_body.ElemFlags();
  public im_msg_body.ElemFlags2 elem_flags2 = new im_msg_body.ElemFlags2();
  public im_msg_body.ExtraInfo extra_info = new im_msg_body.ExtraInfo();
  public im_msg_body.Face face = new im_msg_body.Face();
  public im_msg_body.FunFace fun_face = new im_msg_body.FunFace();
  public im_msg_body.GroupFile group_file = new im_msg_body.GroupFile();
  public im_msg_body.LifeOnlineAccount life_online = new im_msg_body.LifeOnlineAccount();
  public im_msg_body.MarketFace market_face = new im_msg_body.MarketFace();
  public im_msg_body.MarketTrans market_trans = new im_msg_body.MarketTrans();
  public im_msg_body.NotOnlineImage not_online_image = new im_msg_body.NotOnlineImage();
  public im_msg_body.OnlineImage online_image = new im_msg_body.OnlineImage();
  public im_msg_body.PubAccount pub_account = new im_msg_body.PubAccount();
  public im_msg_body.PubGroup pub_group = new im_msg_body.PubGroup();
  public im_msg_body.QQLiveOld qq_live_old = new im_msg_body.QQLiveOld();
  public im_msg_body.QQWalletMsg qqwallet_msg = new im_msg_body.QQWalletMsg();
  public im_msg_body.RichMsg rich_msg = new im_msg_body.RichMsg();
  public im_msg_body.SecretFileMsg secret_file = new im_msg_body.SecretFileMsg();
  public im_msg_body.ShakeWindow shake_window = new im_msg_body.ShakeWindow();
  public im_msg_body.Text text = new im_msg_body.Text();
  public im_msg_body.TipsInfo tips_info = new im_msg_body.TipsInfo();
  public im_msg_body.TransElem trans_elem_info = new im_msg_body.TransElem();
  public im_msg_body.VideoFile video_file = new im_msg_body.VideoFile();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186, 194, 234 }, new String[] { "text", "face", "online_image", "not_online_image", "trans_elem_info", "market_face", "elem_flags", "custom_face", "elem_flags2", "fun_face", "secret_file", "rich_msg", "group_file", "pub_group", "market_trans", "extra_info", "shake_window", "pub_account", "video_file", "tips_info", "anon_group_msg", "qq_live_old", "life_online", "qqwallet_msg", "bankcode_ctrl_info" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, localByteStringMicro }, Elem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.Elem
 * JD-Core Version:    0.7.0.1
 */