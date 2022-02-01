package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_detail_actshuoshuo_rsp
  extends JceStruct
{
  static ArrayList cache_close_fri;
  public String act_content = "";
  public String act_content_after = "";
  public ArrayList close_fri = null;
  public String no_img_tips = "";
  public boolean require_img = true;
  
  public mobile_detail_actshuoshuo_rsp() {}
  
  public mobile_detail_actshuoshuo_rsp(String paramString1, ArrayList paramArrayList, String paramString2, boolean paramBoolean, String paramString3)
  {
    this.act_content = paramString1;
    this.close_fri = paramArrayList;
    this.act_content_after = paramString2;
    this.require_img = paramBoolean;
    this.no_img_tips = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.act_content = paramJceInputStream.readString(0, false);
    if (cache_close_fri == null)
    {
      cache_close_fri = new ArrayList();
      s_user locals_user = new s_user();
      cache_close_fri.add(locals_user);
    }
    this.close_fri = ((ArrayList)paramJceInputStream.read(cache_close_fri, 1, false));
    this.act_content_after = paramJceInputStream.readString(2, false);
    this.require_img = paramJceInputStream.read(this.require_img, 3, false);
    this.no_img_tips = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.act_content != null) {
      paramJceOutputStream.write(this.act_content, 0);
    }
    if (this.close_fri != null) {
      paramJceOutputStream.write(this.close_fri, 1);
    }
    if (this.act_content_after != null) {
      paramJceOutputStream.write(this.act_content_after, 2);
    }
    paramJceOutputStream.write(this.require_img, 3);
    if (this.no_img_tips != null) {
      paramJceOutputStream.write(this.no_img_tips, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_detail_actshuoshuo_rsp
 * JD-Core Version:    0.7.0.1
 */