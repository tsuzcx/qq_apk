package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ReqJoinDiscuss
  extends JceStruct
  implements Cloneable
{
  public int From = 0;
  public String Signature = "";
  
  static
  {
    if (!ReqJoinDiscuss.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ReqJoinDiscuss() {}
  
  public ReqJoinDiscuss(String paramString, int paramInt)
  {
    this.Signature = paramString;
    this.From = paramInt;
  }
  
  public String className()
  {
    return "QQService.ReqJoinDiscuss";
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
    paramStringBuilder.display(this.Signature, "Signature");
    paramStringBuilder.display(this.From, "From");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.Signature, true);
    paramStringBuilder.displaySimple(this.From, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ReqJoinDiscuss)paramObject;
    } while ((!JceUtil.equals(this.Signature, paramObject.Signature)) || (!JceUtil.equals(this.From, paramObject.From)));
    return true;
  }
  
  public String fullClassName()
  {
    return "QQService.ReqJoinDiscuss";
  }
  
  public int getFrom()
  {
    return this.From;
  }
  
  public String getSignature()
  {
    return this.Signature;
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
    this.Signature = paramJceInputStream.readString(0, false);
    this.From = paramJceInputStream.read(this.From, 1, false);
  }
  
  public void setFrom(int paramInt)
  {
    this.From = paramInt;
  }
  
  public void setSignature(String paramString)
  {
    this.Signature = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.Signature != null) {
      paramJceOutputStream.write(this.Signature, 0);
    }
    paramJceOutputStream.write(this.From, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.ReqJoinDiscuss
 * JD-Core Version:    0.7.0.1
 */