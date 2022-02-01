package Wallet;

import NearbyGroup.LBSInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ReqApplication
  extends JceStruct
  implements Cloneable
{
  static LBSInfo cache_lbsInfo;
  public String MQOS = "";
  public String MQVersion = "";
  public String backInfo = "";
  public String extraInfo = "";
  public LBSInfo lbsInfo = null;
  public String phoneModel = "";
  public int screenHeigth = 0;
  public int screenWidth = 0;
  
  static
  {
    if (!ReqApplication.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "Wallet.ReqApplication";
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
      paramObject = (ReqApplication)paramObject;
    } while ((!JceUtil.equals(this.lbsInfo, paramObject.lbsInfo)) || (!JceUtil.equals(this.MQVersion, paramObject.MQVersion)) || (!JceUtil.equals(this.MQOS, paramObject.MQOS)) || (!JceUtil.equals(this.phoneModel, paramObject.phoneModel)) || (!JceUtil.equals(this.extraInfo, paramObject.extraInfo)) || (!JceUtil.equals(this.backInfo, paramObject.backInfo)) || (!JceUtil.equals(this.screenWidth, paramObject.screenWidth)) || (!JceUtil.equals(this.screenHeigth, paramObject.screenHeigth)));
    return true;
  }
  
  public String fullClassName()
  {
    return "Wallet.ReqApplication";
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
    this.MQVersion = paramJceInputStream.readString(1, true);
    this.MQOS = paramJceInputStream.readString(2, true);
    this.phoneModel = paramJceInputStream.readString(3, true);
    this.extraInfo = paramJceInputStream.readString(4, true);
    this.backInfo = paramJceInputStream.readString(5, true);
    this.screenWidth = paramJceInputStream.read(this.screenWidth, 6, false);
    this.screenHeigth = paramJceInputStream.read(this.screenHeigth, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lbsInfo, 0);
    paramJceOutputStream.write(this.MQVersion, 1);
    paramJceOutputStream.write(this.MQOS, 2);
    paramJceOutputStream.write(this.phoneModel, 3);
    paramJceOutputStream.write(this.extraInfo, 4);
    paramJceOutputStream.write(this.backInfo, 5);
    paramJceOutputStream.write(this.screenWidth, 6);
    paramJceOutputStream.write(this.screenHeigth, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     Wallet.ReqApplication
 * JD-Core Version:    0.7.0.1
 */