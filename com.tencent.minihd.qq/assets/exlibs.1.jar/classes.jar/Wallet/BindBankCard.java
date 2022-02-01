package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class BindBankCard
  extends JceStruct
  implements Cloneable
{
  public String URL = "";
  public String text = "";
  public short type = 0;
  
  static
  {
    if (!BindBankCard.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "Wallet.BindBankCard";
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
      paramObject = (BindBankCard)paramObject;
    } while ((!JceUtil.equals(this.type, paramObject.type)) || (!JceUtil.equals(this.text, paramObject.text)) || (!JceUtil.equals(this.URL, paramObject.URL)));
    return true;
  }
  
  public String fullClassName()
  {
    return "Wallet.BindBankCard";
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
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.text = paramJceInputStream.readString(1, false);
    this.URL = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 1);
    }
    if (this.URL != null) {
      paramJceOutputStream.write(this.URL, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     Wallet.BindBankCard
 * JD-Core Version:    0.7.0.1
 */