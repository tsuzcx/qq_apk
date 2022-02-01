package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t196
  extends tlv_t
{
  byte[] _cn = new byte[0];
  byte[] _mobile = new byte[0];
  int _state = 0;
  
  public tlv_t196()
  {
    this._cmd = 406;
  }
  
  public String getBakMobile()
  {
    return new String(this._mobile);
  }
  
  public int getBakMobileState()
  {
    return this._state;
  }
  
  public String getCountryCode()
  {
    return new String(this._cn);
  }
  
  public Boolean verify()
  {
    if (this._body_len < 5) {
      return Boolean.valueOf(false);
    }
    int i = this._head_len;
    this._state = util.buf_to_int8(this._buf, i);
    int j = i + 1;
    i = util.buf_to_int16(this._buf, j);
    j += 2;
    if (j - this._head_len + i > this._body_len) {
      return Boolean.valueOf(false);
    }
    this._cn = new byte[i];
    System.arraycopy(this._buf, j, this._cn, 0, i);
    j += i;
    i = util.buf_to_int16(this._buf, j);
    j += 2;
    if (j - this._head_len + i > this._body_len) {
      return Boolean.valueOf(false);
    }
    this._mobile = new byte[i];
    System.arraycopy(this._buf, j, this._mobile, 0, i);
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t196
 * JD-Core Version:    0.7.0.1
 */