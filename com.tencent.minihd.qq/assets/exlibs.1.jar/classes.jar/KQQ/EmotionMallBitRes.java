package KQQ;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class EmotionMallBitRes
  extends JceStruct
  implements Cloneable
{
  public byte cEmotionMall = -1;
  
  static
  {
    if (!EmotionMallBitRes.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public EmotionMallBitRes() {}
  
  public EmotionMallBitRes(byte paramByte)
  {
    this.cEmotionMall = paramByte;
  }
  
  public String className()
  {
    return "KQQ.EmotionMallBitRes";
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
    new JceDisplayer(paramStringBuilder, paramInt).display(this.cEmotionMall, "cEmotionMall");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).displaySimple(this.cEmotionMall, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (EmotionMallBitRes)paramObject;
    return JceUtil.equals(this.cEmotionMall, paramObject.cEmotionMall);
  }
  
  public String fullClassName()
  {
    return "KQQ.EmotionMallBitRes";
  }
  
  public byte getCEmotionMall()
  {
    return this.cEmotionMall;
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
  }
  
  public void setCEmotionMall(byte paramByte)
  {
    this.cEmotionMall = paramByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cEmotionMall, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.EmotionMallBitRes
 * JD-Core Version:    0.7.0.1
 */