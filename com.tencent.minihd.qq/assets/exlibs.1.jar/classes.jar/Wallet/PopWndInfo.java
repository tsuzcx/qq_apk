package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class PopWndInfo
  extends JceStruct
  implements Cloneable
{
  public long begin = 0L;
  public long end = 0L;
  public long freq = 0L;
  public long id = 0L;
  public String pic_android = "";
  public String pic_high = "";
  public String pic_ios = "";
  public String pic_low = "";
  public String pic_mid = "";
  public int type = 0;
  public String url = "";
  
  static
  {
    if (!PopWndInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "Wallet.PopWndInfo";
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
      paramObject = (PopWndInfo)paramObject;
    } while ((!JceUtil.equals(this.id, paramObject.id)) || (!JceUtil.equals(this.pic_low, paramObject.pic_low)) || (!JceUtil.equals(this.pic_mid, paramObject.pic_mid)) || (!JceUtil.equals(this.pic_high, paramObject.pic_high)) || (!JceUtil.equals(this.pic_ios, paramObject.pic_ios)) || (!JceUtil.equals(this.url, paramObject.url)) || (!JceUtil.equals(this.begin, paramObject.begin)) || (!JceUtil.equals(this.end, paramObject.end)) || (!JceUtil.equals(this.freq, paramObject.freq)) || (!JceUtil.equals(this.pic_android, paramObject.pic_android)) || (!JceUtil.equals(this.type, paramObject.type)));
    return true;
  }
  
  public String fullClassName()
  {
    return "Wallet.PopWndInfo";
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
    this.id = paramJceInputStream.read(this.id, 0, true);
    this.pic_low = paramJceInputStream.readString(1, false);
    this.pic_mid = paramJceInputStream.readString(2, false);
    this.pic_high = paramJceInputStream.readString(3, false);
    this.pic_ios = paramJceInputStream.readString(4, false);
    this.url = paramJceInputStream.readString(5, false);
    this.begin = paramJceInputStream.read(this.begin, 6, true);
    this.end = paramJceInputStream.read(this.end, 7, true);
    this.freq = paramJceInputStream.read(this.freq, 8, true);
    this.pic_android = paramJceInputStream.readString(9, false);
    this.type = paramJceInputStream.read(this.type, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    if (this.pic_low != null) {
      paramJceOutputStream.write(this.pic_low, 1);
    }
    if (this.pic_mid != null) {
      paramJceOutputStream.write(this.pic_mid, 2);
    }
    if (this.pic_high != null) {
      paramJceOutputStream.write(this.pic_high, 3);
    }
    if (this.pic_ios != null) {
      paramJceOutputStream.write(this.pic_ios, 4);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 5);
    }
    paramJceOutputStream.write(this.begin, 6);
    paramJceOutputStream.write(this.end, 7);
    paramJceOutputStream.write(this.freq, 8);
    if (this.pic_android != null) {
      paramJceOutputStream.write(this.pic_android, 9);
    }
    paramJceOutputStream.write(this.type, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     Wallet.PopWndInfo
 * JD-Core Version:    0.7.0.1
 */