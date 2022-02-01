package NearbyGroup;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class RspGetGroupArea
  extends JceStruct
  implements Cloneable
{
  static GroupArea cache_stGroupArea;
  public GroupArea stGroupArea = null;
  
  static
  {
    if (!RspGetGroupArea.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RspGetGroupArea() {}
  
  public RspGetGroupArea(GroupArea paramGroupArea)
  {
    this.stGroupArea = paramGroupArea;
  }
  
  public String className()
  {
    return "NearbyGroup.RspGetGroupArea";
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
    new JceDisplayer(paramStringBuilder, paramInt).display(this.stGroupArea, "stGroupArea");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).displaySimple(this.stGroupArea, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (RspGetGroupArea)paramObject;
    return JceUtil.equals(this.stGroupArea, paramObject.stGroupArea);
  }
  
  public String fullClassName()
  {
    return "NearbyGroup.RspGetGroupArea";
  }
  
  public GroupArea getStGroupArea()
  {
    return this.stGroupArea;
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
    if (cache_stGroupArea == null) {
      cache_stGroupArea = new GroupArea();
    }
    this.stGroupArea = ((GroupArea)paramJceInputStream.read(cache_stGroupArea, 0, false));
  }
  
  public void setStGroupArea(GroupArea paramGroupArea)
  {
    this.stGroupArea = paramGroupArea;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stGroupArea != null) {
      paramJceOutputStream.write(this.stGroupArea, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NearbyGroup.RspGetGroupArea
 * JD-Core Version:    0.7.0.1
 */