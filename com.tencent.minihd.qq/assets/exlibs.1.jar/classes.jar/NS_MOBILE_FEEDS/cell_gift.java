package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_gift
  extends JceStruct
{
  static Map cache_gifturl;
  public String giftbackid = "";
  public String giftdesc = "";
  public String giftid = "";
  public String giftname = "";
  public String gifttype = "";
  public Map gifturl = null;
  
  public cell_gift() {}
  
  public cell_gift(String paramString1, String paramString2, String paramString3, Map paramMap, String paramString4, String paramString5)
  {
    this.giftname = paramString1;
    this.gifttype = paramString2;
    this.giftid = paramString3;
    this.gifturl = paramMap;
    this.giftdesc = paramString4;
    this.giftbackid = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.giftname = paramJceInputStream.readString(0, false);
    this.gifttype = paramJceInputStream.readString(1, false);
    this.giftid = paramJceInputStream.readString(2, false);
    if (cache_gifturl == null)
    {
      cache_gifturl = new HashMap();
      cache_gifturl.put(Integer.valueOf(0), "");
    }
    this.gifturl = ((Map)paramJceInputStream.read(cache_gifturl, 3, false));
    this.giftdesc = paramJceInputStream.readString(4, false);
    this.giftbackid = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.giftname != null) {
      paramJceOutputStream.write(this.giftname, 0);
    }
    if (this.gifttype != null) {
      paramJceOutputStream.write(this.gifttype, 1);
    }
    if (this.giftid != null) {
      paramJceOutputStream.write(this.giftid, 2);
    }
    if (this.gifturl != null) {
      paramJceOutputStream.write(this.gifturl, 3);
    }
    if (this.giftdesc != null) {
      paramJceOutputStream.write(this.giftdesc, 4);
    }
    if (this.giftbackid != null) {
      paramJceOutputStream.write(this.giftbackid, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_gift
 * JD-Core Version:    0.7.0.1
 */