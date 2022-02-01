package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x383$RspBody
  extends MessageMicro
{
  public static final int INT32_RET_CODE_FIELD_NUMBER = 1;
  public static final int MSG_COPY_TO_RSP_BODY_FIELD_NUMBER = 112;
  public static final int MSG_DEL_FILE_RSP_BODY_FIELD_NUMBER = 14;
  public static final int MSG_DOWNLOAD_RSP_BODY_FIELD_NUMBER = 13;
  public static final int MSG_FEED_MSG_V2_RSP_BODY_FIELD_NUMBER = 18;
  public static final int MSG_GET_FILE_LIST_RSP_BODY_FIELD_NUMBER = 113;
  public static final int MSG_GET_FILE_LIST_V2_RSP_BODY_FIELD_NUMBER = 117;
  public static final int MSG_RESEND_RSP_BODY_FIELD_NUMBER = 12;
  public static final int MSG_TRANS_FILE_RSP_BODY_FIELD_NUMBER = 16;
  public static final int MSG_UPLOAD_RSP_BODY_FIELD_NUMBER = 11;
  public static final int STR_CLIENT_WORDING_FIELD_NUMBER = 3;
  public static final int STR_RET_MSG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 90, 98, 106, 114, 130, 146, 898, 906, 938 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "msg_upload_rsp_body", "msg_resend_rsp_body", "msg_download_rsp_body", "msg_del_file_rsp_body", "msg_trans_file_rsp_body", "msg_feed_msg_v2_rsp_body", "msg_copy_to_rsp_body", "msg_get_file_list_rsp_body", "msg_get_file_list_v2_rsp_body" }, new Object[] { Integer.valueOf(0), "", "", null, null, null, null, null, null, null, null, null }, RspBody.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public cmd0x383.ApplyCopyToRspBody msg_copy_to_rsp_body = new cmd0x383.ApplyCopyToRspBody();
  public cmd0x383.ApplyDelFileRspBody msg_del_file_rsp_body = new cmd0x383.ApplyDelFileRspBody();
  public cmd0x383.ApplyDownloadRspBody msg_download_rsp_body = new cmd0x383.ApplyDownloadRspBody();
  public cmd0x383.ApplyFeedMsgV2RspBody msg_feed_msg_v2_rsp_body = new cmd0x383.ApplyFeedMsgV2RspBody();
  public cmd0x383.ApplyGetFileListRspBody msg_get_file_list_rsp_body = new cmd0x383.ApplyGetFileListRspBody();
  public cmd0x383.ApplyGetFileListV2RspBody msg_get_file_list_v2_rsp_body = new cmd0x383.ApplyGetFileListV2RspBody();
  public cmd0x383.ApplyResendRspBody msg_resend_rsp_body = new cmd0x383.ApplyResendRspBody();
  public cmd0x383.ApplyTransFileRspBody msg_trans_file_rsp_body = new cmd0x383.ApplyTransFileRspBody();
  public cmd0x383.ApplyUploadRspBody msg_upload_rsp_body = new cmd0x383.ApplyUploadRspBody();
  public final PBStringField str_client_wording = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.RspBody
 * JD-Core Version:    0.7.0.1
 */