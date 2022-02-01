package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7c4$GetRecommendSNFrdListReq
  extends MessageMicro
{
  public static final int UINT32_REQ_NUM_FIELD_NUMBER = 4;
  public static final int UINT32_SEQUENCE_FIELD_NUMBER = 2;
  public static final int UINT32_START_IDX_FIELD_NUMBER = 3;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_uin", "uint32_sequence", "uint32_start_idx", "uint32_req_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetRecommendSNFrdListReq.class);
  public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_idx = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetRecommendSNFrdListReq
 * JD-Core Version:    0.7.0.1
 */