package com.tencent.sc.qzonepush.QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

public final class SvcMsgInfo
  extends JceStruct
{
  static Map cache_msgByteInfos;
  static Map cache_msgInfos;
  public int iMsgType = 0;
  public long lFromUin = 0L;
  public Map msgByteInfos = null;
  public Map msgInfos = null;
  public String strOther = "";
  public int tTimeStamp = 0;
  
  static
  {
    if (!SvcMsgInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SvcMsgInfo()
  {
    setLFromUin(this.lFromUin);
    setTTimeStamp(this.tTimeStamp);
    setIMsgType(this.iMsgType);
    setStrOther(this.strOther);
    setMsgInfos(this.msgInfos);
    setMsgByteInfos(this.msgByteInfos);
  }
  
  public SvcMsgInfo(long paramLong, int paramInt1, int paramInt2, String paramString, Map paramMap1, Map paramMap2)
  {
    setLFromUin(paramLong);
    setTTimeStamp(paramInt1);
    setIMsgType(paramInt2);
    setStrOther(paramString);
    setMsgInfos(paramMap1);
    setMsgByteInfos(paramMap2);
  }
  
  public String className()
  {
    return "QQService.SvcMsgInfo";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.lFromUin, "lFromUin");
    paramStringBuilder.display(this.tTimeStamp, "tTimeStamp");
    paramStringBuilder.display(this.iMsgType, "iMsgType");
    paramStringBuilder.display(this.strOther, "strOther");
    paramStringBuilder.display(this.msgInfos, "msgInfos");
    paramStringBuilder.display(this.msgByteInfos, "msgByteInfos");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (SvcMsgInfo)paramObject;
    return (JceUtil.equals(this.lFromUin, paramObject.lFromUin)) && (JceUtil.equals(this.tTimeStamp, paramObject.tTimeStamp)) && (JceUtil.equals(this.iMsgType, paramObject.iMsgType)) && (JceUtil.equals(this.strOther, paramObject.strOther)) && (JceUtil.equals(this.msgInfos, paramObject.msgInfos)) && (JceUtil.equals(this.msgByteInfos, paramObject.msgByteInfos));
  }
  
  public int getIMsgType()
  {
    return this.iMsgType;
  }
  
  public long getLFromUin()
  {
    return this.lFromUin;
  }
  
  public Map getMsgByteInfos()
  {
    return this.msgByteInfos;
  }
  
  public Map getMsgInfos()
  {
    return this.msgInfos;
  }
  
  public String getStrOther()
  {
    return this.strOther;
  }
  
  public int getTTimeStamp()
  {
    return this.tTimeStamp;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setLFromUin(paramJceInputStream.read(this.lFromUin, 0, true));
    setTTimeStamp(paramJceInputStream.read(this.tTimeStamp, 1, true));
    setIMsgType(paramJceInputStream.read(this.iMsgType, 2, true));
    setStrOther(paramJceInputStream.readString(3, true));
    if (cache_msgInfos == null)
    {
      cache_msgInfos = new HashMap();
      cache_msgInfos.put("", "");
    }
    setMsgInfos((Map)paramJceInputStream.read(cache_msgInfos, 4, false));
    if (cache_msgByteInfos == null)
    {
      cache_msgByteInfos = new HashMap();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_msgByteInfos.put("", arrayOfByte);
    }
    setMsgByteInfos((Map)paramJceInputStream.read(cache_msgByteInfos, 5, false));
  }
  
  public void setIMsgType(int paramInt)
  {
    this.iMsgType = paramInt;
  }
  
  public void setLFromUin(long paramLong)
  {
    this.lFromUin = paramLong;
  }
  
  public void setMsgByteInfos(Map paramMap)
  {
    this.msgByteInfos = paramMap;
  }
  
  public void setMsgInfos(Map paramMap)
  {
    this.msgInfos = paramMap;
  }
  
  public void setStrOther(String paramString)
  {
    this.strOther = paramString;
  }
  
  public void setTTimeStamp(int paramInt)
  {
    this.tTimeStamp = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUin, 0);
    paramJceOutputStream.write(this.tTimeStamp, 1);
    paramJceOutputStream.write(this.iMsgType, 2);
    paramJceOutputStream.write(this.strOther, 3);
    if (this.msgInfos != null) {
      paramJceOutputStream.write(this.msgInfos, 4);
    }
    if (this.msgByteInfos != null) {
      paramJceOutputStream.write(this.msgByteInfos, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.sc.qzonepush.QQService.SvcMsgInfo
 * JD-Core Version:    0.7.0.1
 */