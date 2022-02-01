package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ReqTmpChatPicDownload
  extends JceStruct
  implements Cloneable
{
  public byte getPicSize = 0;
  public long lSeq = 0L;
  public long lUIN = 0L;
  public String strFlieKey = "";
  
  static
  {
    if (!ReqTmpChatPicDownload.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ReqTmpChatPicDownload() {}
  
  public ReqTmpChatPicDownload(long paramLong1, long paramLong2, String paramString, byte paramByte)
  {
    this.lUIN = paramLong1;
    this.lSeq = paramLong2;
    this.strFlieKey = paramString;
    this.getPicSize = paramByte;
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
    paramStringBuilder.display(this.lUIN, "lUIN");
    paramStringBuilder.display(this.lSeq, "lSeq");
    paramStringBuilder.display(this.strFlieKey, "strFlieKey");
    paramStringBuilder.display(this.getPicSize, "getPicSize");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ReqTmpChatPicDownload)paramObject;
    } while ((!JceUtil.equals(this.lUIN, paramObject.lUIN)) || (!JceUtil.equals(this.lSeq, paramObject.lSeq)) || (!JceUtil.equals(this.strFlieKey, paramObject.strFlieKey)) || (!JceUtil.equals(this.getPicSize, paramObject.getPicSize)));
    return true;
  }
  
  public byte getGetPicSize()
  {
    return this.getPicSize;
  }
  
  public long getLSeq()
  {
    return this.lSeq;
  }
  
  public long getLUIN()
  {
    return this.lUIN;
  }
  
  public String getStrFlieKey()
  {
    return this.strFlieKey;
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
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.lSeq = paramJceInputStream.read(this.lSeq, 1, true);
    this.strFlieKey = paramJceInputStream.readString(2, true);
    this.getPicSize = paramJceInputStream.read(this.getPicSize, 3, true);
  }
  
  public void setGetPicSize(byte paramByte)
  {
    this.getPicSize = paramByte;
  }
  
  public void setLSeq(long paramLong)
  {
    this.lSeq = paramLong;
  }
  
  public void setLUIN(long paramLong)
  {
    this.lUIN = paramLong;
  }
  
  public void setStrFlieKey(String paramString)
  {
    this.strFlieKey = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.lSeq, 1);
    paramJceOutputStream.write(this.strFlieKey, 2);
    paramJceOutputStream.write(this.getPicSize, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.ReqTmpChatPicDownload
 * JD-Core Version:    0.7.0.1
 */