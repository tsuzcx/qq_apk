package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class f
  extends JceStruct
{
  static byte[] c;
  static byte[] d;
  public byte[] a = null;
  public byte[] b = null;
  
  public f() {}
  
  public f(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.a = paramArrayOfByte1;
    this.b = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (c == null)
    {
      c = (byte[])new byte[1];
      ((byte[])c)[0] = 0;
    }
    this.a = ((byte[])paramJceInputStream.read(c, 0, true));
    if (d == null)
    {
      d = (byte[])new byte[1];
      ((byte[])d)[0] = 0;
    }
    this.b = ((byte[])paramJceInputStream.read(d, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.f
 * JD-Core Version:    0.7.0.1
 */