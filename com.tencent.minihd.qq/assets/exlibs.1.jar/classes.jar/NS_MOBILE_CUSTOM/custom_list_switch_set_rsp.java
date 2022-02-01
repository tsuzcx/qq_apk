package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class custom_list_switch_set_rsp
  extends JceStruct
{
  static Map cache_mapExtInfo;
  public int iCode = 0;
  public Map mapExtInfo = null;
  
  public custom_list_switch_set_rsp() {}
  
  public custom_list_switch_set_rsp(int paramInt, Map paramMap)
  {
    this.iCode = paramInt;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCode = paramJceInputStream.read(this.iCode, 0, false);
    if (cache_mapExtInfo == null)
    {
      cache_mapExtInfo = new HashMap();
      cache_mapExtInfo.put("", "");
    }
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCode, 0);
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.custom_list_switch_set_rsp
 * JD-Core Version:    0.7.0.1
 */