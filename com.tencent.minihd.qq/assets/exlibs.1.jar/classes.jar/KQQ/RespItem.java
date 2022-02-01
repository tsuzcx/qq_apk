package KQQ;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class RespItem
  extends JceStruct
  implements Cloneable
{
  static int cache_eServiceID;
  static byte[] cache_vecUpdate;
  public byte cResult = 0;
  public int eServiceID = 0;
  public byte[] vecUpdate = null;
  
  static
  {
    if (!RespItem.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RespItem() {}
  
  public RespItem(byte paramByte, int paramInt, byte[] paramArrayOfByte)
  {
    this.cResult = paramByte;
    this.eServiceID = paramInt;
    this.vecUpdate = paramArrayOfByte;
  }
  
  public String className()
  {
    return "KQQ.RespItem";
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
    paramStringBuilder.display(this.cResult, "cResult");
    paramStringBuilder.display(this.eServiceID, "eServiceID");
    paramStringBuilder.display(this.vecUpdate, "vecUpdate");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.cResult, true);
    paramStringBuilder.displaySimple(this.eServiceID, true);
    paramStringBuilder.displaySimple(this.vecUpdate, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (RespItem)paramObject;
    } while ((!JceUtil.equals(this.cResult, paramObject.cResult)) || (!JceUtil.equals(this.eServiceID, paramObject.eServiceID)) || (!JceUtil.equals(this.vecUpdate, paramObject.vecUpdate)));
    return true;
  }
  
  public String fullClassName()
  {
    return "KQQ.RespItem";
  }
  
  public byte getCResult()
  {
    return this.cResult;
  }
  
  public int getEServiceID()
  {
    return this.eServiceID;
  }
  
  public byte[] getVecUpdate()
  {
    return this.vecUpdate;
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
    this.cResult = paramJceInputStream.read(this.cResult, 0, true);
    this.eServiceID = paramJceInputStream.read(this.eServiceID, 1, true);
    if (cache_vecUpdate == null)
    {
      cache_vecUpdate = (byte[])new byte[1];
      ((byte[])cache_vecUpdate)[0] = 0;
    }
    this.vecUpdate = ((byte[])paramJceInputStream.read(cache_vecUpdate, 2, false));
  }
  
  public void setCResult(byte paramByte)
  {
    this.cResult = paramByte;
  }
  
  public void setEServiceID(int paramInt)
  {
    this.eServiceID = paramInt;
  }
  
  public void setVecUpdate(byte[] paramArrayOfByte)
  {
    this.vecUpdate = paramArrayOfByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cResult, 0);
    paramJceOutputStream.write(this.eServiceID, 1);
    if (this.vecUpdate != null) {
      paramJceOutputStream.write(this.vecUpdate, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.RespItem
 * JD-Core Version:    0.7.0.1
 */