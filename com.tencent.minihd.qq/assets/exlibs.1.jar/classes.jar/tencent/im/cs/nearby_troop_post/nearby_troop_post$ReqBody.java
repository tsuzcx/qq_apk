package tencent.im.cs.nearby_troop_post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby_troop_post$ReqBody
  extends MessageMicro
{
  public static final int MSG_SUBCMD0X1_REQ_NEARBYINFO_FIELD_NUMBER = 2;
  public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_sub_cmd", "msg_subcmd0x1_req_nearbyinfo" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
  public nearby_troop_post.ReqNearbyPostInfo msg_subcmd0x1_req_nearbyinfo = new nearby_troop_post.ReqNearbyPostInfo();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.nearby_troop_post.nearby_troop_post.ReqBody
 * JD-Core Version:    0.7.0.1
 */