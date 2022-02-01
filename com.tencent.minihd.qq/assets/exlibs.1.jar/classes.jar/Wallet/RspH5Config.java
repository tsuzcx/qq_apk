package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class RspH5Config
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_vecH5Info;
  public String msg = "";
  public int refreshPeriod = 0;
  public int ret = 0;
  public ArrayList vecH5Info = null;
  
  static
  {
    if (!RspH5Config.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "Wallet.RspH5Config";
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
      paramObject = (RspH5Config)paramObject;
    } while ((!JceUtil.equals(this.ret, paramObject.ret)) || (!JceUtil.equals(this.msg, paramObject.msg)) || (!JceUtil.equals(this.refreshPeriod, paramObject.refreshPeriod)) || (!JceUtil.equals(this.vecH5Info, paramObject.vecH5Info)));
    return true;
  }
  
  public String fullClassName()
  {
    return "Wallet.RspH5Config";
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
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.refreshPeriod = paramJceInputStream.read(this.refreshPeriod, 2, false);
    if (cache_vecH5Info == null)
    {
      cache_vecH5Info = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new H5Info());
      cache_vecH5Info.add(localArrayList);
    }
    this.vecH5Info = ((ArrayList)paramJceInputStream.read(cache_vecH5Info, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    paramJceOutputStream.write(this.refreshPeriod, 2);
    if (this.vecH5Info != null) {
      paramJceOutputStream.write(this.vecH5Info, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     Wallet.RspH5Config
 * JD-Core Version:    0.7.0.1
 */