package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class j
  extends JceStruct
{
  public String a = "";
  public int b = 0;
  public byte c = 0;
  public byte d = 0;
  public byte e = 0;
  public int f = 8;
  public byte g = 0;
  
  public j() {}
  
  public j(String paramString, int paramInt1, byte paramByte1, byte paramByte2, byte paramByte3, int paramInt2, byte paramByte4)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramByte1;
    this.d = paramByte2;
    this.e = paramByte3;
    this.f = paramInt2;
    this.g = paramByte4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(1, true);
    this.b = paramJceInputStream.read(this.b, 2, true);
    this.c = paramJceInputStream.read(this.c, 3, true);
    this.d = paramJceInputStream.read(this.d, 4, true);
    this.e = paramJceInputStream.read(this.e, 5, false);
    this.f = paramJceInputStream.read(this.f, 6, false);
    this.g = paramJceInputStream.read(this.g, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    paramJceOutputStream.write(this.d, 4);
    paramJceOutputStream.write(this.e, 5);
    paramJceOutputStream.write(this.f, 6);
    paramJceOutputStream.write(this.g, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.j
 * JD-Core Version:    0.7.0.1
 */