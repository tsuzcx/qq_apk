package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class send_gift_item
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_info;
  public int arch = 0;
  public String audioUrl = "";
  public String backId = "";
  public String content = "";
  public long id = 0L;
  public ArrayList info = null;
  public boolean isBack = true;
  public boolean isPrivate = true;
  public String picUrl = "";
  
  static
  {
    if (!send_gift_item.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public send_gift_item() {}
  
  public send_gift_item(ArrayList paramArrayList, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    this.info = paramArrayList;
    this.id = paramLong;
    this.isBack = paramBoolean1;
    this.isPrivate = paramBoolean2;
    this.audioUrl = paramString1;
    this.picUrl = paramString2;
    this.content = paramString3;
    this.arch = paramInt;
    this.backId = paramString4;
  }
  
  public String className()
  {
    return "NS_MOBILE_TEMPLATE_GIFT.send_gift_item";
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
    paramStringBuilder.display(this.info, "info");
    paramStringBuilder.display(this.id, "id");
    paramStringBuilder.display(this.isBack, "isBack");
    paramStringBuilder.display(this.isPrivate, "isPrivate");
    paramStringBuilder.display(this.audioUrl, "audioUrl");
    paramStringBuilder.display(this.picUrl, "picUrl");
    paramStringBuilder.display(this.content, "content");
    paramStringBuilder.display(this.arch, "arch");
    paramStringBuilder.display(this.backId, "backId");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (send_gift_item)paramObject;
    } while ((!JceUtil.equals(this.info, paramObject.info)) || (!JceUtil.equals(this.id, paramObject.id)) || (!JceUtil.equals(this.isBack, paramObject.isBack)) || (!JceUtil.equals(this.isPrivate, paramObject.isPrivate)) || (!JceUtil.equals(this.audioUrl, paramObject.audioUrl)) || (!JceUtil.equals(this.picUrl, paramObject.picUrl)) || (!JceUtil.equals(this.content, paramObject.content)) || (!JceUtil.equals(this.arch, paramObject.arch)) || (!JceUtil.equals(this.backId, paramObject.backId)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NS_MOBILE_TEMPLATE_GIFT.send_gift_item";
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
    if (cache_info == null)
    {
      cache_info = new ArrayList();
      send_gift_info localsend_gift_info = new send_gift_info();
      cache_info.add(localsend_gift_info);
    }
    this.info = ((ArrayList)paramJceInputStream.read(cache_info, 0, true));
    this.id = paramJceInputStream.read(this.id, 1, true);
    this.isBack = paramJceInputStream.read(this.isBack, 2, true);
    this.isPrivate = paramJceInputStream.read(this.isPrivate, 3, true);
    this.audioUrl = paramJceInputStream.readString(4, true);
    this.picUrl = paramJceInputStream.readString(5, true);
    this.content = paramJceInputStream.readString(6, true);
    this.arch = paramJceInputStream.read(this.arch, 7, false);
    this.backId = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.info, 0);
    paramJceOutputStream.write(this.id, 1);
    paramJceOutputStream.write(this.isBack, 2);
    paramJceOutputStream.write(this.isPrivate, 3);
    paramJceOutputStream.write(this.audioUrl, 4);
    paramJceOutputStream.write(this.picUrl, 5);
    paramJceOutputStream.write(this.content, 6);
    paramJceOutputStream.write(this.arch, 7);
    if (this.backId != null) {
      paramJceOutputStream.write(this.backId, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.send_gift_item
 * JD-Core Version:    0.7.0.1
 */