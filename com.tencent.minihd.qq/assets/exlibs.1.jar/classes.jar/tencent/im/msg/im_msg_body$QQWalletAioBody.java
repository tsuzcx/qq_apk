package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$QQWalletAioBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_authkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_billno = PBField.initBytes(ByteStringMicro.EMPTY);
  public im_msg_body.QQWalletAioElem receiver = new im_msg_body.QQWalletAioElem();
  public im_msg_body.QQWalletAioElem sender = new im_msg_body.QQWalletAioElem();
  public final PBSInt32Field sint32_channelid = PBField.initSInt32(0);
  public final PBSInt32Field sint32_redtype = PBField.initSInt32(0);
  public final PBSInt32Field sint32_templateid = PBField.initSInt32(0);
  public final PBUInt32Field uint32_msg_priority = PBField.initUInt32(0);
  public final PBUInt32Field uint32_resend = PBField.initUInt32(0);
  public final PBUInt64Field uint64_senduin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 74, 82 }, new String[] { "uint64_senduin", "sender", "receiver", "sint32_channelid", "sint32_templateid", "uint32_resend", "uint32_msg_priority", "sint32_redtype", "bytes_billno", "bytes_authkey" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, QQWalletAioBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.QQWalletAioBody
 * JD-Core Version:    0.7.0.1
 */