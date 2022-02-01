package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class BaseInfo
  extends JceStruct
  implements Cloneable
{
  public String appId = "";
  public String nonce = "";
  public String phoneModel = "";
  public String phoneOS = "";
  public String qVersion = "";
  public String sig = "";
  public String sigType = "";
  public long timeStamp = 0L;
  
  static
  {
    if (!BaseInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "VIP.BaseInfo";
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
      paramObject = (BaseInfo)paramObject;
    } while ((!JceUtil.equals(this.appId, paramObject.appId)) || (!JceUtil.equals(this.nonce, paramObject.nonce)) || (!JceUtil.equals(this.timeStamp, paramObject.timeStamp)) || (!JceUtil.equals(this.sigType, paramObject.sigType)) || (!JceUtil.equals(this.sig, paramObject.sig)) || (!JceUtil.equals(this.qVersion, paramObject.qVersion)) || (!JceUtil.equals(this.phoneOS, paramObject.phoneOS)) || (!JceUtil.equals(this.phoneModel, paramObject.phoneModel)));
    return true;
  }
  
  public String fullClassName()
  {
    return "VIP.BaseInfo";
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
    this.appId = paramJceInputStream.readString(0, true);
    this.nonce = paramJceInputStream.readString(1, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 2, true);
    this.sigType = paramJceInputStream.readString(3, true);
    this.sig = paramJceInputStream.readString(4, true);
    this.qVersion = paramJceInputStream.readString(5, true);
    this.phoneOS = paramJceInputStream.readString(6, true);
    this.phoneModel = paramJceInputStream.readString(7, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appId, 0);
    paramJceOutputStream.write(this.nonce, 1);
    paramJceOutputStream.write(this.timeStamp, 2);
    paramJceOutputStream.write(this.sigType, 3);
    paramJceOutputStream.write(this.sig, 4);
    paramJceOutputStream.write(this.qVersion, 5);
    paramJceOutputStream.write(this.phoneOS, 6);
    paramJceOutputStream.write(this.phoneModel, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     VIP.BaseInfo
 * JD-Core Version:    0.7.0.1
 */