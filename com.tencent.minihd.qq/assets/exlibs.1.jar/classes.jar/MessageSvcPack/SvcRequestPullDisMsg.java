package MessageSvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class SvcRequestPullDisMsg
  extends JceStruct
  implements Cloneable
{
  public byte cGetPttUrl = 0;
  public byte cGetSmartRemark = 0;
  public byte cVerifyType = 0;
  public long dwLastGetTime = 0L;
  public long dwLastInfoSeq = 0L;
  public long lBeginSeq = 0L;
  public long lDisUin = 0L;
  public long lEndSeq = 0L;
  
  static
  {
    if (!SvcRequestPullDisMsg.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SvcRequestPullDisMsg() {}
  
  public SvcRequestPullDisMsg(byte paramByte1, long paramLong1, long paramLong2, long paramLong3, byte paramByte2, byte paramByte3, long paramLong4, long paramLong5)
  {
    this.cVerifyType = paramByte1;
    this.lDisUin = paramLong1;
    this.lBeginSeq = paramLong2;
    this.lEndSeq = paramLong3;
    this.cGetPttUrl = paramByte2;
    this.cGetSmartRemark = paramByte3;
    this.dwLastGetTime = paramLong4;
    this.dwLastInfoSeq = paramLong5;
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
    paramStringBuilder.display(this.cVerifyType, "cVerifyType");
    paramStringBuilder.display(this.lDisUin, "lDisUin");
    paramStringBuilder.display(this.lBeginSeq, "lBeginSeq");
    paramStringBuilder.display(this.lEndSeq, "lEndSeq");
    paramStringBuilder.display(this.cGetPttUrl, "cGetPttUrl");
    paramStringBuilder.display(this.cGetSmartRemark, "cGetSmartRemark");
    paramStringBuilder.display(this.dwLastGetTime, "dwLastGetTime");
    paramStringBuilder.display(this.dwLastInfoSeq, "dwLastInfoSeq");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (SvcRequestPullDisMsg)paramObject;
    } while ((!JceUtil.equals(this.cVerifyType, paramObject.cVerifyType)) || (!JceUtil.equals(this.lDisUin, paramObject.lDisUin)) || (!JceUtil.equals(this.lBeginSeq, paramObject.lBeginSeq)) || (!JceUtil.equals(this.lEndSeq, paramObject.lEndSeq)) || (!JceUtil.equals(this.cGetPttUrl, paramObject.cGetPttUrl)) || (!JceUtil.equals(this.cGetSmartRemark, paramObject.cGetSmartRemark)) || (!JceUtil.equals(this.dwLastGetTime, paramObject.dwLastGetTime)) || (!JceUtil.equals(this.dwLastInfoSeq, paramObject.dwLastInfoSeq)));
    return true;
  }
  
  public byte getCGetPttUrl()
  {
    return this.cGetPttUrl;
  }
  
  public byte getCGetSmartRemark()
  {
    return this.cGetSmartRemark;
  }
  
  public byte getCVerifyType()
  {
    return this.cVerifyType;
  }
  
  public long getDwLastGetTime()
  {
    return this.dwLastGetTime;
  }
  
  public long getDwLastInfoSeq()
  {
    return this.dwLastInfoSeq;
  }
  
  public long getLBeginSeq()
  {
    return this.lBeginSeq;
  }
  
  public long getLDisUin()
  {
    return this.lDisUin;
  }
  
  public long getLEndSeq()
  {
    return this.lEndSeq;
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
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 0, true);
    this.lDisUin = paramJceInputStream.read(this.lDisUin, 1, true);
    this.lBeginSeq = paramJceInputStream.read(this.lBeginSeq, 2, true);
    this.lEndSeq = paramJceInputStream.read(this.lEndSeq, 3, true);
    this.cGetPttUrl = paramJceInputStream.read(this.cGetPttUrl, 4, false);
    this.cGetSmartRemark = paramJceInputStream.read(this.cGetSmartRemark, 5, false);
    this.dwLastGetTime = paramJceInputStream.read(this.dwLastGetTime, 6, false);
    this.dwLastInfoSeq = paramJceInputStream.read(this.dwLastInfoSeq, 7, false);
  }
  
  public void setCGetPttUrl(byte paramByte)
  {
    this.cGetPttUrl = paramByte;
  }
  
  public void setCGetSmartRemark(byte paramByte)
  {
    this.cGetSmartRemark = paramByte;
  }
  
  public void setCVerifyType(byte paramByte)
  {
    this.cVerifyType = paramByte;
  }
  
  public void setDwLastGetTime(long paramLong)
  {
    this.dwLastGetTime = paramLong;
  }
  
  public void setDwLastInfoSeq(long paramLong)
  {
    this.dwLastInfoSeq = paramLong;
  }
  
  public void setLBeginSeq(long paramLong)
  {
    this.lBeginSeq = paramLong;
  }
  
  public void setLDisUin(long paramLong)
  {
    this.lDisUin = paramLong;
  }
  
  public void setLEndSeq(long paramLong)
  {
    this.lEndSeq = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cVerifyType, 0);
    paramJceOutputStream.write(this.lDisUin, 1);
    paramJceOutputStream.write(this.lBeginSeq, 2);
    paramJceOutputStream.write(this.lEndSeq, 3);
    paramJceOutputStream.write(this.cGetPttUrl, 4);
    paramJceOutputStream.write(this.cGetSmartRemark, 5);
    paramJceOutputStream.write(this.dwLastGetTime, 6);
    paramJceOutputStream.write(this.dwLastInfoSeq, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     MessageSvcPack.SvcRequestPullDisMsg
 * JD-Core Version:    0.7.0.1
 */