package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class RespGetApiList
  extends JceStruct
  implements Cloneable
{
  public String apiList = "";
  public String appId = "";
  public String domains = "";
  public String errMsg = "";
  public int ret = 0;
  
  static
  {
    if (!RespGetApiList.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "VIP.RespGetApiList";
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
      paramObject = (RespGetApiList)paramObject;
    } while ((!JceUtil.equals(this.ret, paramObject.ret)) || (!JceUtil.equals(this.errMsg, paramObject.errMsg)) || (!JceUtil.equals(this.appId, paramObject.appId)) || (!JceUtil.equals(this.apiList, paramObject.apiList)) || (!JceUtil.equals(this.domains, paramObject.domains)));
    return true;
  }
  
  public String fullClassName()
  {
    return "VIP.RespGetApiList";
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
    this.appId = paramJceInputStream.readString(2, true);
    this.apiList = paramJceInputStream.readString(3, true);
    this.domains = paramJceInputStream.readString(4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.errMsg != null) {
      paramJceOutputStream.write(this.errMsg, 1);
    }
    paramJceOutputStream.write(this.appId, 2);
    paramJceOutputStream.write(this.apiList, 3);
    paramJceOutputStream.write(this.domains, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     VIP.RespGetApiList
 * JD-Core Version:    0.7.0.1
 */