package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t113
  extends tlv_t
{
  public tlv_t113()
  {
    this._cmd = 275;
  }
  
  public long get_uin()
  {
    return util.buf_to_int32(this._buf, this._head_len) & 0xFFFFFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t113
 * JD-Core Version:    0.7.0.1
 */