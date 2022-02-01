package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tools.util;

public class j
  extends c
{
  public j()
  {
    this.b = 5;
  }
  
  public byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = a(paramArrayOfByte1, paramArrayOfByte2);
    this.d = (paramArrayOfByte1.length + 1 + 2 + arrayOfByte.length);
    paramArrayOfByte2 = new byte[this.d];
    util.int8_to_buf(paramArrayOfByte2, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 1, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length + 1;
    util.int16_to_buf(paramArrayOfByte2, i, arrayOfByte.length);
    i += 2;
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, i, arrayOfByte.length);
    i = arrayOfByte.length;
    paramArrayOfByte1 = new tlv_t544().get_tlv_544("", "812_5", paramArrayOfByte2);
    arrayOfByte = new byte[this.d + paramArrayOfByte1.length];
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 0, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, paramArrayOfByte2.length, paramArrayOfByte1.length);
    return a(arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.j
 * JD-Core Version:    0.7.0.1
 */