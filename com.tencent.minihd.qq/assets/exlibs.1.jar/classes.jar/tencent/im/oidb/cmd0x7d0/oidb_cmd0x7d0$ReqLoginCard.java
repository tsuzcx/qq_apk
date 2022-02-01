package tencent.im.oidb.cmd0x7d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x7d0$ReqLoginCard
  extends MessageMicro
{
  public static final int UINT32_REQ_INDEX_FIELD_NUMBER = 1;
  public static final int UINT32_REQ_NUM_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_req_index", "uint32_req_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ReqLoginCard.class);
  public final PBUInt32Field uint32_req_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7d0.oidb_cmd0x7d0.ReqLoginCard
 * JD-Core Version:    0.7.0.1
 */