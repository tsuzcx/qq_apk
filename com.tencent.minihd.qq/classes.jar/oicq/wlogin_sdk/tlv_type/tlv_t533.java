package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t533
  extends tlv_t
{
  public tlv_t533()
  {
    this._cmd = 1331;
  }
  
  public byte[] get_tlv_533(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    int i = arrayOfByte.length + 4 + paramArrayOfByte1.length;
    paramArrayOfByte2 = new byte[i];
    util.int16_to_buf(paramArrayOfByte2, 0, arrayOfByte.length);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, 2, arrayOfByte.length);
    int j = arrayOfByte.length + 2;
    util.int16_to_buf(paramArrayOfByte2, j, paramArrayOfByte1.length);
    j += 2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, j, paramArrayOfByte1.length);
    j = paramArrayOfByte1.length;
    fill_head(this._cmd);
    fill_body(paramArrayOfByte2, i);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t533
 * JD-Core Version:    0.7.0.1
 */