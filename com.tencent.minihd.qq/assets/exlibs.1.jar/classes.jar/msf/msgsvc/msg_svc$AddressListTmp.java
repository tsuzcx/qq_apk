package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$AddressListTmp
  extends MessageMicro
{
  public static final int FROM_PHONE_FIELD_NUMBER = 1;
  public static final int SIG_FIELD_NUMBER = 4;
  public static final int TO_PHONE_FIELD_NUMBER = 2;
  public static final int TO_UIN_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField from_phone = PBField.initString("");
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField to_phone = PBField.initString("");
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "from_phone", "to_phone", "to_uin", "sig" }, new Object[] { "", "", Long.valueOf(0L), localByteStringMicro }, AddressListTmp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.AddressListTmp
 * JD-Core Version:    0.7.0.1
 */