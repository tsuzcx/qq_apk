package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class H5Info
  extends JceStruct
  implements Cloneable
{
  public String PV = "";
  public long beginDate = 0L;
  public String description = "";
  public long endDate = 0L;
  public int id = 0;
  public String title = "";
  public String url = "";
  
  static
  {
    if (!H5Info.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "Wallet.H5Info";
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
      paramObject = (H5Info)paramObject;
    } while ((!JceUtil.equals(this.id, paramObject.id)) || (!JceUtil.equals(this.beginDate, paramObject.beginDate)) || (!JceUtil.equals(this.endDate, paramObject.endDate)) || (!JceUtil.equals(this.title, paramObject.title)) || (!JceUtil.equals(this.url, paramObject.url)) || (!JceUtil.equals(this.PV, paramObject.PV)) || (!JceUtil.equals(this.description, paramObject.description)));
    return true;
  }
  
  public String fullClassName()
  {
    return "Wallet.H5Info";
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
    this.id = paramJceInputStream.read(this.id, 0, false);
    this.beginDate = paramJceInputStream.read(this.beginDate, 1, false);
    this.endDate = paramJceInputStream.read(this.endDate, 2, false);
    this.title = paramJceInputStream.readString(3, false);
    this.url = paramJceInputStream.readString(4, false);
    this.PV = paramJceInputStream.readString(5, false);
    this.description = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.beginDate, 1);
    paramJceOutputStream.write(this.endDate, 2);
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 3);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 4);
    }
    if (this.PV != null) {
      paramJceOutputStream.write(this.PV, 5);
    }
    if (this.description != null) {
      paramJceOutputStream.write(this.description, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     Wallet.H5Info
 * JD-Core Version:    0.7.0.1
 */