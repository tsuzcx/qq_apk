package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picurl;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_outshare
  extends JceStruct
{
  static Map cache_photourl;
  public Map photourl = null;
  public String qq_url = "";
  public String summary = "";
  public String title = "";
  public String weixin_url = "";
  
  public s_outshare() {}
  
  public s_outshare(String paramString1, String paramString2, String paramString3, String paramString4, Map paramMap)
  {
    this.weixin_url = paramString1;
    this.qq_url = paramString2;
    this.title = paramString3;
    this.summary = paramString4;
    this.photourl = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.weixin_url = paramJceInputStream.readString(0, false);
    this.qq_url = paramJceInputStream.readString(1, false);
    this.title = paramJceInputStream.readString(2, false);
    this.summary = paramJceInputStream.readString(3, false);
    if (cache_photourl == null)
    {
      cache_photourl = new HashMap();
      s_picurl locals_picurl = new s_picurl();
      cache_photourl.put(Integer.valueOf(0), locals_picurl);
    }
    this.photourl = ((Map)paramJceInputStream.read(cache_photourl, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.weixin_url != null) {
      paramJceOutputStream.write(this.weixin_url, 0);
    }
    if (this.qq_url != null) {
      paramJceOutputStream.write(this.qq_url, 1);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 2);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 3);
    }
    if (this.photourl != null) {
      paramJceOutputStream.write(this.photourl, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.s_outshare
 * JD-Core Version:    0.7.0.1
 */