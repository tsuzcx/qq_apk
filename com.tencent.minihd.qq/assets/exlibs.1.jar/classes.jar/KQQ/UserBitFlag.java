package KQQ;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class UserBitFlag
  extends JceStruct
  implements Cloneable
{
  public byte cEmotionMall = -1;
  public byte cSyncShuoShuo = -1;
  
  static
  {
    if (!UserBitFlag.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UserBitFlag() {}
  
  public UserBitFlag(byte paramByte1, byte paramByte2)
  {
    this.cEmotionMall = paramByte1;
    this.cSyncShuoShuo = paramByte2;
  }
  
  public String className()
  {
    return "KQQ.UserBitFlag";
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
    paramStringBuilder.display(this.cEmotionMall, "cEmotionMall");
    paramStringBuilder.display(this.cSyncShuoShuo, "cSyncShuoShuo");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.cEmotionMall, true);
    paramStringBuilder.displaySimple(this.cSyncShuoShuo, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (UserBitFlag)paramObject;
    } while ((!JceUtil.equals(this.cEmotionMall, paramObject.cEmotionMall)) || (!JceUtil.equals(this.cSyncShuoShuo, paramObject.cSyncShuoShuo)));
    return true;
  }
  
  public String fullClassName()
  {
    return "KQQ.UserBitFlag";
  }
  
  public byte getCEmotionMall()
  {
    return this.cEmotionMall;
  }
  
  public byte getCSyncShuoShuo()
  {
    return this.cSyncShuoShuo;
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
    this.cEmotionMall = paramJceInputStream.read(this.cEmotionMall, 0, false);
    this.cSyncShuoShuo = paramJceInputStream.read(this.cSyncShuoShuo, 1, false);
  }
  
  public void setCEmotionMall(byte paramByte)
  {
    this.cEmotionMall = paramByte;
  }
  
  public void setCSyncShuoShuo(byte paramByte)
  {
    this.cSyncShuoShuo = paramByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cEmotionMall, 0);
    paramJceOutputStream.write(this.cSyncShuoShuo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.UserBitFlag
 * JD-Core Version:    0.7.0.1
 */