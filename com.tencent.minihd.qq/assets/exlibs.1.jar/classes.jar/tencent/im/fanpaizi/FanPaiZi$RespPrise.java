package tencent.im.fanpaizi;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FanPaiZi$RespPrise
  extends MessageMicro
{
  public static final int BYTES_SIG_FIELD_NUMBER = 5;
  public static final int INT32_PRISE_EACH_OTHER_FIELD_NUMBER = 2;
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int UINT64_PEER_TINYID_FIELD_NUMBER = 3;
  public static final int UINT64_PEER_UIN_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_prise_each_other = PBField.initInt32(0);
  public FanPaiZi.BusiRespHead msg_head = new FanPaiZi.BusiRespHead();
  public final PBUInt64Field uint64_peer_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_peer_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "msg_head", "int32_prise_each_other", "uint64_peer_tinyid", "uint64_peer_uin", "bytes_sig" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, RespPrise.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.fanpaizi.FanPaiZi.RespPrise
 * JD-Core Version:    0.7.0.1
 */