package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t142
  extends tlv_t
{
  int _t142_body_len = 0;
  int _version = 0;
  
  public tlv_t142()
  {
    this._cmd = 322;
  }
  
  public byte[] get_tlv_142(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    int i = limit_len(arrayOfByte, 32);
    this._t142_body_len = (i + 4);
    paramArrayOfByte = new byte[this._t142_body_len];
    util.int16_to_buf(paramArrayOfByte, 0, this._version);
    util.int16_to_buf(paramArrayOfByte, 2, i);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 4, i);
    fill_head(this._cmd);
    fill_body(paramArrayOfByte, paramArrayOfByte.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t142
 * JD-Core Version:    0.7.0.1
 */