package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class RequestCustomSig
  extends JceStruct
{
  static Map cache_customSigPara;
  static byte[] cache_reserved;
  public Map customSigPara = null;
  public long nlTestFlag = 0L;
  public byte[] reserved = null;
  public long ulCustumFlag = 0L;
  public long ulSType = 0L;
  
  public RequestCustomSig() {}
  
  public RequestCustomSig(long paramLong1, long paramLong2, byte[] paramArrayOfByte, Map paramMap, long paramLong3)
  {
    this.ulCustumFlag = paramLong1;
    this.ulSType = paramLong2;
    this.reserved = paramArrayOfByte;
    this.customSigPara = paramMap;
    this.nlTestFlag = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ulCustumFlag = paramJceInputStream.read(this.ulCustumFlag, 0, true);
    this.ulSType = paramJceInputStream.read(this.ulSType, 1, true);
    if (cache_reserved == null)
    {
      cache_reserved = (byte[])new byte[1];
      ((byte[])cache_reserved)[0] = 0;
    }
    this.reserved = ((byte[])paramJceInputStream.read(cache_reserved, 2, true));
    if (cache_customSigPara == null)
    {
      cache_customSigPara = new HashMap();
      cache_customSigPara.put("", "");
    }
    this.customSigPara = ((Map)paramJceInputStream.read(cache_customSigPara, 3, false));
    this.nlTestFlag = paramJceInputStream.read(this.nlTestFlag, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ulCustumFlag, 0);
    paramJceOutputStream.write(this.ulSType, 1);
    paramJceOutputStream.write(this.reserved, 2);
    if (this.customSigPara != null) {
      paramJceOutputStream.write(this.customSigPara, 3);
    }
    paramJceOutputStream.write(this.nlTestFlag, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.RequestCustomSig
 * JD-Core Version:    0.7.0.1
 */