package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.tools.util;

public class i
  extends e
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public byte[] d = new byte[0];
  public byte[] e = new byte[0];
  public byte[] f = new byte[0];
  public byte[] g = new byte[0];
  
  public i()
  {
    this._type = 3;
  }
  
  public void parse()
  {
    int i = this._head_len;
    this.a = util.buf_to_int32(this._buf, i);
    i += 4;
    this.b = util.buf_to_int8(this._buf, i);
    int j = i + 1;
    i = util.buf_to_int16(this._buf, j);
    j += 2;
    this.d = new byte[i];
    System.arraycopy(this._buf, j, this.d, 0, i);
    j += i;
    i = util.buf_to_int16(this._buf, j);
    j += 2;
    this.e = new byte[i];
    System.arraycopy(this._buf, j, this.e, 0, i);
    j += i;
    i = util.buf_to_int16(this._buf, j);
    j += 2;
    this.f = new byte[i];
    System.arraycopy(this._buf, j, this.f, 0, i);
    i = j + i;
    this.c = util.buf_to_int16(this._buf, i);
    j = i + 2;
    i = util.buf_to_int16(this._buf, j);
    j += 2;
    this.g = new byte[i];
    System.arraycopy(this._buf, j, this.g, 0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.i
 * JD-Core Version:    0.7.0.1
 */