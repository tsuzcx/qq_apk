package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class RespGetOpenId
  extends JceStruct
  implements Cloneable
{
  public String errMsg = "";
  public String openId = "";
  public String openKey = "";
  public int ret = 0;
  
  static
  {
    if (!RespGetOpenId.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "VIP.RespGetOpenId";
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
      paramObject = (RespGetOpenId)paramObject;
    } while ((!JceUtil.equals(this.ret, paramObject.ret)) || (!JceUtil.equals(this.errMsg, paramObject.errMsg)) || (!JceUtil.equals(this.openId, paramObject.openId)) || (!JceUtil.equals(this.openKey, paramObject.openKey)));
    return true;
  }
  
  public String fullClassName()
  {
    return "VIP.RespGetOpenId";
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
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.errMsg = paramJceInputStream.readString(1, false);
    this.openId = paramJceInputStream.readString(2, true);
    this.openKey = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.errMsg != null) {
      paramJceOutputStream.write(this.errMsg, 1);
    }
    paramJceOutputStream.write(this.openId, 2);
    paramJceOutputStream.write(this.openKey, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     VIP.RespGetOpenId
 * JD-Core Version:    0.7.0.1
 */