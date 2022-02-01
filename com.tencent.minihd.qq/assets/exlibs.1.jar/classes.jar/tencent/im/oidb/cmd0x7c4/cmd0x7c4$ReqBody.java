package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x7c4$ReqBody
  extends MessageMicro
{
  public static final int MSG_GET_RECOMMEND_SN_FRD_LIST_REQ_FIELD_NUMBER = 1;
  public static final int MSG_GET_SN_FRD_LIST_REQ_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_get_recommend_sn_frd_list_req", "msg_get_sn_frd_list_req" }, new Object[] { null, null }, ReqBody.class);
  public cmd0x7c4.GetRecommendSNFrdListReq msg_get_recommend_sn_frd_list_req = new cmd0x7c4.GetRecommendSNFrdListReq();
  public cmd0x7c4.GetSNFrdListReq msg_get_sn_frd_list_req = new cmd0x7c4.GetSNFrdListReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7c4.cmd0x7c4.ReqBody
 * JD-Core Version:    0.7.0.1
 */