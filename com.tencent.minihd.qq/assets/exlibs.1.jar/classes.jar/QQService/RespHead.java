package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class RespHead
  extends JceStruct
  implements Cloneable
{
  public int iReplyCode = 0;
  public int iSeq = 0;
  public long lUIN = 0L;
  public short shVersion = 0;
  public String strResult = "";
  
  static
  {
    if (!RespHead.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RespHead() {}
  
  public RespHead(short paramShort, int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    this.shVersion = paramShort;
    this.iSeq = paramInt1;
    this.lUIN = paramLong;
    this.iReplyCode = paramInt2;
    this.strResult = paramString;
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
    paramStringBuilder.display(this.shVersion, "shVersion");
    paramStringBuilder.display(this.iSeq, "iSeq");
    paramStringBuilder.display(this.lUIN, "lUIN");
    paramStringBuilder.display(this.iReplyCode, "iReplyCode");
    paramStringBuilder.display(this.strResult, "strResult");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (RespHead)paramObject;
    } while ((!JceUtil.equals(this.shVersion, paramObject.shVersion)) || (!JceUtil.equals(this.iSeq, paramObject.iSeq)) || (!JceUtil.equals(this.lUIN, paramObject.lUIN)) || (!JceUtil.equals(this.iReplyCode, paramObject.iReplyCode)) || (!JceUtil.equals(this.strResult, paramObject.strResult)));
    return true;
  }
  
  public int getIReplyCode()
  {
    return this.iReplyCode;
  }
  
  public int getISeq()
  {
    return this.iSeq;
  }
  
  public long getLUIN()
  {
    return this.lUIN;
  }
  
  public short getShVersion()
  {
    return this.shVersion;
  }
  
  public String getStrResult()
  {
    return this.strResult;
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
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
    this.lUIN = paramJceInputStream.read(this.lUIN, 2, true);
    this.iReplyCode = paramJceInputStream.read(this.iReplyCode, 3, true);
    this.strResult = paramJceInputStream.readString(4, false);
  }
  
  public void setIReplyCode(int paramInt)
  {
    this.iReplyCode = paramInt;
  }
  
  public void setISeq(int paramInt)
  {
    this.iSeq = paramInt;
  }
  
  public void setLUIN(long paramLong)
  {
    this.lUIN = paramLong;
  }
  
  public void setShVersion(short paramShort)
  {
    this.shVersion = paramShort;
  }
  
  public void setStrResult(String paramString)
  {
    this.strResult = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.lUIN, 2);
    paramJceOutputStream.write(this.iReplyCode, 3);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.RespHead
 * JD-Core Version:    0.7.0.1
 */