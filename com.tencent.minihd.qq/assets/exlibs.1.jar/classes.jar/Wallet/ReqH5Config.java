package Wallet;

import NearbyGroup.LBSInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ReqH5Config
  extends JceStruct
  implements Cloneable
{
  static LBSInfo cache_lbsInfo;
  public String MQOS = "";
  public String MQVersion = "";
  public LBSInfo lbsInfo = null;
  public String phoneModel = "";
  
  static
  {
    if (!ReqH5Config.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "Wallet.ReqH5Config";
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
      paramObject = (ReqH5Config)paramObject;
    } while ((!JceUtil.equals(this.lbsInfo, paramObject.lbsInfo)) || (!JceUtil.equals(this.MQVersion, paramObject.MQVersion)) || (!JceUtil.equals(this.MQOS, paramObject.MQOS)) || (!JceUtil.equals(this.phoneModel, paramObject.phoneModel)));
    return true;
  }
  
  public String fullClassName()
  {
    return "Wallet.ReqH5Config";
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
    if (cache_lbsInfo == null) {
      cache_lbsInfo = new LBSInfo();
    }
    this.lbsInfo = ((LBSInfo)paramJceInputStream.read(cache_lbsInfo, 0, true));
    this.MQVersion = paramJceInputStream.readString(1, false);
    this.MQOS = paramJceInputStream.readString(2, false);
    this.phoneModel = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lbsInfo, 0);
    if (this.MQVersion != null) {
      paramJceOutputStream.write(this.MQVersion, 1);
    }
    if (this.MQOS != null) {
      paramJceOutputStream.write(this.MQOS, 2);
    }
    if (this.phoneModel != null) {
      paramJceOutputStream.write(this.phoneModel, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     Wallet.ReqH5Config
 * JD-Core Version:    0.7.0.1
 */