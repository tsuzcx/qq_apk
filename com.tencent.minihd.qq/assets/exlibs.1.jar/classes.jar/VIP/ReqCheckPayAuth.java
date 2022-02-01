package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ReqCheckPayAuth
  extends JceStruct
  implements Cloneable
{
  static BaseInfo cache_baseInfo;
  public String bargainorId = "";
  public BaseInfo baseInfo = null;
  public String p1 = "";
  public String p2 = "";
  public String p3 = "";
  public int payFrom = 0;
  public String pubAcc = "";
  public String tokenId = "";
  
  static
  {
    if (!ReqCheckPayAuth.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "VIP.ReqCheckPayAuth";
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
      paramObject = (ReqCheckPayAuth)paramObject;
    } while ((!JceUtil.equals(this.baseInfo, paramObject.baseInfo)) || (!JceUtil.equals(this.tokenId, paramObject.tokenId)) || (!JceUtil.equals(this.pubAcc, paramObject.pubAcc)) || (!JceUtil.equals(this.bargainorId, paramObject.bargainorId)) || (!JceUtil.equals(this.payFrom, paramObject.payFrom)) || (!JceUtil.equals(this.p1, paramObject.p1)) || (!JceUtil.equals(this.p2, paramObject.p2)) || (!JceUtil.equals(this.p3, paramObject.p3)));
    return true;
  }
  
  public String fullClassName()
  {
    return "VIP.ReqCheckPayAuth";
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
    if (cache_baseInfo == null) {
      cache_baseInfo = new BaseInfo();
    }
    this.baseInfo = ((BaseInfo)paramJceInputStream.read(cache_baseInfo, 0, true));
    this.tokenId = paramJceInputStream.readString(1, true);
    this.pubAcc = paramJceInputStream.readString(2, false);
    this.bargainorId = paramJceInputStream.readString(3, true);
    this.payFrom = paramJceInputStream.read(this.payFrom, 4, true);
    this.p1 = paramJceInputStream.readString(5, false);
    this.p2 = paramJceInputStream.readString(6, false);
    this.p3 = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.baseInfo, 0);
    paramJceOutputStream.write(this.tokenId, 1);
    if (this.pubAcc != null) {
      paramJceOutputStream.write(this.pubAcc, 2);
    }
    paramJceOutputStream.write(this.bargainorId, 3);
    paramJceOutputStream.write(this.payFrom, 4);
    if (this.p1 != null) {
      paramJceOutputStream.write(this.p1, 5);
    }
    if (this.p2 != null) {
      paramJceOutputStream.write(this.p2, 6);
    }
    if (this.p3 != null) {
      paramJceOutputStream.write(this.p3, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     VIP.ReqCheckPayAuth
 * JD-Core Version:    0.7.0.1
 */