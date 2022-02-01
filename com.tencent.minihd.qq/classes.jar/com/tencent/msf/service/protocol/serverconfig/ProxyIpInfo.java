package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ProxyIpInfo
  extends JceStruct
{
  public int uIp = 0;
  public int uPort = 0;
  public int uType = 0;
  
  public ProxyIpInfo() {}
  
  public ProxyIpInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.uType = paramInt1;
    this.uIp = paramInt2;
    this.uPort = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uType = paramJceInputStream.read(this.uType, 0, true);
    this.uIp = paramJceInputStream.read(this.uIp, 1, true);
    this.uPort = paramJceInputStream.read(this.uPort, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uType, 0);
    paramJceOutputStream.write(this.uIp, 1);
    paramJceOutputStream.write(this.uPort, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.ProxyIpInfo
 * JD-Core Version:    0.7.0.1
 */