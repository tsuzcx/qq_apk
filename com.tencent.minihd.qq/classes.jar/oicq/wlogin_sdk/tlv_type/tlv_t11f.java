package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t11f
  extends tlv_t
{
  public tlv_t11f()
  {
    this._cmd = 287;
  }
  
  public int get_chg_time()
  {
    return util.buf_to_int32(this._buf, this._head_len);
  }
  
  public int get_tk_pri()
  {
    return util.buf_to_int32(this._buf, this._head_len + 4);
  }
  
  public Boolean verify()
  {
    if (this._body_len < 8) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t11f
 * JD-Core Version:    0.7.0.1
 */