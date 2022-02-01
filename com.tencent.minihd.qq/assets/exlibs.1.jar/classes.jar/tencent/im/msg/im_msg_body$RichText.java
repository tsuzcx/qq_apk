package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class im_msg_body$RichText
  extends MessageMicro
{
  public static final int ATTR_FIELD_NUMBER = 1;
  public static final int ELEMS_FIELD_NUMBER = 2;
  public static final int NOT_ONLINE_FILE_FIELD_NUMBER = 3;
  public static final int PTT_FIELD_NUMBER = 4;
  public static final int TMP_PTT_FIELD_NUMBER = 5;
  public static final int TRANS_211_TMP_MSG_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "attr", "elems", "not_online_file", "ptt", "tmp_ptt", "trans_211_tmp_msg" }, new Object[] { null, null, null, null, null, null }, RichText.class);
  public im_msg_body.Attr attr = new im_msg_body.Attr();
  public final PBRepeatMessageField elems = PBField.initRepeatMessage(im_msg_body.Elem.class);
  public im_msg_body.NotOnlineFile not_online_file = new im_msg_body.NotOnlineFile();
  public im_msg_body.Ptt ptt = new im_msg_body.Ptt();
  public im_msg_body.TmpPtt tmp_ptt = new im_msg_body.TmpPtt();
  public im_msg_body.Trans211TmpMsg trans_211_tmp_msg = new im_msg_body.Trans211TmpMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.RichText
 * JD-Core Version:    0.7.0.1
 */