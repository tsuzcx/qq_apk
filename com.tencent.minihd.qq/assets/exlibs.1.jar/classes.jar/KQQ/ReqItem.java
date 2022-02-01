package KQQ;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ReqItem
  extends JceStruct
  implements Cloneable
{
  static int cache_eServiceID;
  static byte[] cache_vecParam;
  public byte cOperType = 1;
  public int eServiceID = 0;
  public byte[] vecParam = null;
  
  static
  {
    if (!ReqItem.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ReqItem() {}
  
  public ReqItem(byte paramByte, int paramInt, byte[] paramArrayOfByte)
  {
    this.cOperType = paramByte;
    this.eServiceID = paramInt;
    this.vecParam = paramArrayOfByte;
  }
  
  public String className()
  {
    return "KQQ.ReqItem";
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.cOperType, "cOperType");
    paramStringBuilder.display(this.eServiceID, "eServiceID");
    paramStringBuilder.display(this.vecParam, "vecParam");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.cOperType, true);
    paramStringBuilder.displaySimple(this.eServiceID, true);
    paramStringBuilder.displaySimple(this.vecParam, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ReqItem)paramObject;
    } while ((!JceUtil.equals(this.cOperType, paramObject.cOperType)) || (!JceUtil.equals(this.eServiceID, paramObject.eServiceID)) || (!JceUtil.equals(this.vecParam, paramObject.vecParam)));
    return true;
  }
  
  public String fullClassName()
  {
    return "KQQ.ReqItem";
  }
  
  public byte getCOperType()
  {
    return this.cOperType;
  }
  
  public int getEServiceID()
  {
    return this.eServiceID;
  }
  
  public byte[] getVecParam()
  {
    return this.vecParam;
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
    this.cOperType = paramJceInputStream.read(this.cOperType, 0, true);
    this.eServiceID = paramJceInputStream.read(this.eServiceID, 1, true);
    if (cache_vecParam == null)
    {
      cache_vecParam = (byte[])new byte[1];
      ((byte[])cache_vecParam)[0] = 0;
    }
    this.vecParam = ((byte[])paramJceInputStream.read(cache_vecParam, 2, false));
  }
  
  public void setCOperType(byte paramByte)
  {
    this.cOperType = paramByte;
  }
  
  public void setEServiceID(int paramInt)
  {
    this.eServiceID = paramInt;
  }
  
  public void setVecParam(byte[] paramArrayOfByte)
  {
    this.vecParam = paramArrayOfByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cOperType, 0);
    paramJceOutputStream.write(this.eServiceID, 1);
    if (this.vecParam != null) {
      paramJceOutputStream.write(this.vecParam, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.ReqItem
 * JD-Core Version:    0.7.0.1
 */