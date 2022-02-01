package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class CreditInfo
  extends JceStruct
  implements Cloneable
{
  public long begin = 0L;
  public long end = 0L;
  public String entry = "";
  public String tips = "";
  
  static
  {
    if (!CreditInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "Wallet.CreditInfo";
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
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (CreditInfo)paramObject;
    } while ((!JceUtil.equals(this.entry, paramObject.entry)) || (!JceUtil.equals(this.tips, paramObject.tips)) || (!JceUtil.equals(this.begin, paramObject.begin)) || (!JceUtil.equals(this.end, paramObject.end)));
    return true;
  }
  
  public String fullClassName()
  {
    return "Wallet.CreditInfo";
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
    this.entry = paramJceInputStream.readString(0, true);
    this.tips = paramJceInputStream.readString(1, false);
    this.begin = paramJceInputStream.read(this.begin, 2, true);
    this.end = paramJceInputStream.read(this.end, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.entry, 0);
    if (this.tips != null) {
      paramJceOutputStream.write(this.tips, 1);
    }
    paramJceOutputStream.write(this.begin, 2);
    paramJceOutputStream.write(this.end, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     Wallet.CreditInfo
 * JD-Core Version:    0.7.0.1
 */