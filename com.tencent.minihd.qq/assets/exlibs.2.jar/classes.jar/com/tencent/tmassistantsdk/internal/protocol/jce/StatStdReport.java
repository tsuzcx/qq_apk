package com.tencent.tmassistantsdk.internal.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class StatStdReport
  extends JceStruct
  implements Cloneable
{
  public String extraData = "";
  public String name = "";
  public int scene = 0;
  public long time = 0L;
  public String traceId = "";
  public String versionInfo = "";
  
  static
  {
    if (!StatStdReport.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public StatStdReport() {}
  
  public StatStdReport(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    this.name = paramString1;
    this.scene = paramInt;
    this.extraData = paramString2;
    this.time = paramLong;
    this.versionInfo = paramString3;
    this.traceId = paramString4;
  }
  
  public String className()
  {
    return "jce.StatStdReport";
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
      while (a) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.name, "name");
    paramStringBuilder.display(this.scene, "scene");
    paramStringBuilder.display(this.extraData, "extraData");
    paramStringBuilder.display(this.time, "time");
    paramStringBuilder.display(this.versionInfo, "versionInfo");
    paramStringBuilder.display(this.traceId, "traceId");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.name, true);
    paramStringBuilder.displaySimple(this.scene, true);
    paramStringBuilder.displaySimple(this.extraData, true);
    paramStringBuilder.displaySimple(this.time, true);
    paramStringBuilder.displaySimple(this.versionInfo, true);
    paramStringBuilder.displaySimple(this.traceId, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (StatStdReport)paramObject;
    } while ((!JceUtil.equals(this.name, paramObject.name)) || (!JceUtil.equals(this.scene, paramObject.scene)) || (!JceUtil.equals(this.extraData, paramObject.extraData)) || (!JceUtil.equals(this.time, paramObject.time)) || (!JceUtil.equals(this.versionInfo, paramObject.versionInfo)) || (!JceUtil.equals(this.traceId, paramObject.traceId)));
    return true;
  }
  
  public String fullClassName()
  {
    return "com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport";
  }
  
  public String getExtraData()
  {
    return this.extraData;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getScene()
  {
    return this.scene;
  }
  
  public long getTime()
  {
    return this.time;
  }
  
  public String getTraceId()
  {
    return this.traceId;
  }
  
  public String getVersionInfo()
  {
    return this.versionInfo;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.name = paramJceInputStream.readString(0, true);
    this.scene = paramJceInputStream.read(this.scene, 1, false);
    this.extraData = paramJceInputStream.readString(2, false);
    this.time = paramJceInputStream.read(this.time, 3, false);
    this.versionInfo = paramJceInputStream.readString(4, false);
    this.traceId = paramJceInputStream.readString(5, false);
  }
  
  public void setExtraData(String paramString)
  {
    this.extraData = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setScene(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public void setTime(long paramLong)
  {
    this.time = paramLong;
  }
  
  public void setTraceId(String paramString)
  {
    this.traceId = paramString;
  }
  
  public void setVersionInfo(String paramString)
  {
    this.versionInfo = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.name, 0);
    paramJceOutputStream.write(this.scene, 1);
    if (this.extraData != null) {
      paramJceOutputStream.write(this.extraData, 2);
    }
    paramJceOutputStream.write(this.time, 3);
    if (this.versionInfo != null) {
      paramJceOutputStream.write(this.versionInfo, 4);
    }
    if (this.traceId != null) {
      paramJceOutputStream.write(this.traceId, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport
 * JD-Core Version:    0.7.0.1
 */