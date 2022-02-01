package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_detail_mqq_req
  extends JceStruct
{
  static Map cache_mqqinfo;
  public Map mqqinfo = null;
  
  public mobile_detail_mqq_req() {}
  
  public mobile_detail_mqq_req(Map paramMap)
  {
    this.mqqinfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_mqqinfo == null)
    {
      cache_mqqinfo = new HashMap();
      cache_mqqinfo.put("", "");
    }
    this.mqqinfo = ((Map)paramJceInputStream.read(cache_mqqinfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mqqinfo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_detail_mqq_req
 * JD-Core Version:    0.7.0.1
 */