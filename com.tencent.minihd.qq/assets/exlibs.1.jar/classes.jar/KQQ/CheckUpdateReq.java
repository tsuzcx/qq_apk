package KQQ;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class CheckUpdateReq
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_vecReqPkg;
  public boolean isSupportSubPack = false;
  public ArrayList vecReqPkg = null;
  
  static
  {
    if (!CheckUpdateReq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public CheckUpdateReq() {}
  
  public CheckUpdateReq(ArrayList paramArrayList, boolean paramBoolean)
  {
    this.vecReqPkg = paramArrayList;
    this.isSupportSubPack = paramBoolean;
  }
  
  public String className()
  {
    return "KQQ.CheckUpdateReq";
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
    paramStringBuilder.display(this.vecReqPkg, "vecReqPkg");
    paramStringBuilder.display(this.isSupportSubPack, "isSupportSubPack");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.vecReqPkg, true);
    paramStringBuilder.displaySimple(this.isSupportSubPack, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (CheckUpdateReq)paramObject;
    } while ((!JceUtil.equals(this.vecReqPkg, paramObject.vecReqPkg)) || (!JceUtil.equals(this.isSupportSubPack, paramObject.isSupportSubPack)));
    return true;
  }
  
  public String fullClassName()
  {
    return "KQQ.CheckUpdateReq";
  }
  
  public boolean getIsSupportSubPack()
  {
    return this.isSupportSubPack;
  }
  
  public ArrayList getVecReqPkg()
  {
    return this.vecReqPkg;
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
    if (cache_vecReqPkg == null)
    {
      cache_vecReqPkg = new ArrayList();
      ReqItem localReqItem = new ReqItem();
      cache_vecReqPkg.add(localReqItem);
    }
    this.vecReqPkg = ((ArrayList)paramJceInputStream.read(cache_vecReqPkg, 0, true));
    this.isSupportSubPack = paramJceInputStream.read(this.isSupportSubPack, 1, false);
  }
  
  public void setIsSupportSubPack(boolean paramBoolean)
  {
    this.isSupportSubPack = paramBoolean;
  }
  
  public void setVecReqPkg(ArrayList paramArrayList)
  {
    this.vecReqPkg = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecReqPkg, 0);
    paramJceOutputStream.write(this.isSupportSubPack, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.CheckUpdateReq
 * JD-Core Version:    0.7.0.1
 */