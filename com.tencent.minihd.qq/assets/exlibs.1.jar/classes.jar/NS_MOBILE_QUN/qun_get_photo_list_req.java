package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class qun_get_photo_list_req
  extends JceStruct
{
  static Map cache_mqqinfo;
  public String albumid = "";
  public String attach_info = "";
  public int count = 0;
  public Map mqqinfo = null;
  public String qunid = "";
  
  public qun_get_photo_list_req() {}
  
  public qun_get_photo_list_req(String paramString1, String paramString2, int paramInt, String paramString3, Map paramMap)
  {
    this.qunid = paramString1;
    this.albumid = paramString2;
    this.count = paramInt;
    this.attach_info = paramString3;
    this.mqqinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.count = paramJceInputStream.read(this.count, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    if (cache_mqqinfo == null)
    {
      cache_mqqinfo = new HashMap();
      cache_mqqinfo.put("", "");
    }
    this.mqqinfo = ((Map)paramJceInputStream.read(cache_mqqinfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.qunid, 0);
    paramJceOutputStream.write(this.albumid, 1);
    paramJceOutputStream.write(this.count, 2);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
    if (this.mqqinfo != null) {
      paramJceOutputStream.write(this.mqqinfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_get_photo_list_req
 * JD-Core Version:    0.7.0.1
 */