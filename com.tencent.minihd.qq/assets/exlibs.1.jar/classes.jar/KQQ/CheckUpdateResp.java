package KQQ;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class CheckUpdateResp
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_vecResPkg;
  public long dwSsoSeq = 0L;
  public boolean isEnd = true;
  public byte result = 0;
  public ArrayList vecResPkg = null;
  
  static
  {
    if (!CheckUpdateResp.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public CheckUpdateResp() {}
  
  public CheckUpdateResp(byte paramByte, ArrayList paramArrayList, boolean paramBoolean, long paramLong)
  {
    this.result = paramByte;
    this.vecResPkg = paramArrayList;
    this.isEnd = paramBoolean;
    this.dwSsoSeq = paramLong;
  }
  
  public String className()
  {
    return "KQQ.CheckUpdateResp";
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
    paramStringBuilder.display(this.result, "result");
    paramStringBuilder.display(this.vecResPkg, "vecResPkg");
    paramStringBuilder.display(this.isEnd, "isEnd");
    paramStringBuilder.display(this.dwSsoSeq, "dwSsoSeq");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.result, true);
    paramStringBuilder.displaySimple(this.vecResPkg, true);
    paramStringBuilder.displaySimple(this.isEnd, true);
    paramStringBuilder.displaySimple(this.dwSsoSeq, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (CheckUpdateResp)paramObject;
    } while ((!JceUtil.equals(this.result, paramObject.result)) || (!JceUtil.equals(this.vecResPkg, paramObject.vecResPkg)) || (!JceUtil.equals(this.isEnd, paramObject.isEnd)) || (!JceUtil.equals(this.dwSsoSeq, paramObject.dwSsoSeq)));
    return true;
  }
  
  public String fullClassName()
  {
    return "KQQ.CheckUpdateResp";
  }
  
  public long getDwSsoSeq()
  {
    return this.dwSsoSeq;
  }
  
  public boolean getIsEnd()
  {
    return this.isEnd;
  }
  
  public byte getResult()
  {
    return this.result;
  }
  
  public ArrayList getVecResPkg()
  {
    return this.vecResPkg;
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
    this.result = paramJceInputStream.read(this.result, 0, true);
    if (cache_vecResPkg == null)
    {
      cache_vecResPkg = new ArrayList();
      RespItem localRespItem = new RespItem();
      cache_vecResPkg.add(localRespItem);
    }
    this.vecResPkg = ((ArrayList)paramJceInputStream.read(cache_vecResPkg, 1, true));
    this.isEnd = paramJceInputStream.read(this.isEnd, 2, false);
    this.dwSsoSeq = paramJceInputStream.read(this.dwSsoSeq, 3, false);
  }
  
  public void setDwSsoSeq(long paramLong)
  {
    this.dwSsoSeq = paramLong;
  }
  
  public void setIsEnd(boolean paramBoolean)
  {
    this.isEnd = paramBoolean;
  }
  
  public void setResult(byte paramByte)
  {
    this.result = paramByte;
  }
  
  public void setVecResPkg(ArrayList paramArrayList)
  {
    this.vecResPkg = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.vecResPkg, 1);
    paramJceOutputStream.write(this.isEnd, 2);
    paramJceOutputStream.write(this.dwSsoSeq, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.CheckUpdateResp
 * JD-Core Version:    0.7.0.1
 */