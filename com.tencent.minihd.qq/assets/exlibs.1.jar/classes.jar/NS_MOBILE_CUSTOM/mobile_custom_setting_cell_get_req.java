package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_custom_setting_cell_get_req
  extends JceStruct
{
  static Map cache_mapCellTimestamp;
  static Map cache_mapExtInfo;
  public Map mapCellTimestamp = null;
  public Map mapExtInfo = null;
  
  public mobile_custom_setting_cell_get_req() {}
  
  public mobile_custom_setting_cell_get_req(Map paramMap1, Map paramMap2)
  {
    this.mapCellTimestamp = paramMap1;
    this.mapExtInfo = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_mapCellTimestamp == null)
    {
      cache_mapCellTimestamp = new HashMap();
      cache_mapCellTimestamp.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    this.mapCellTimestamp = ((Map)paramJceInputStream.read(cache_mapCellTimestamp, 0, false));
    if (cache_mapExtInfo == null)
    {
      cache_mapExtInfo = new HashMap();
      cache_mapExtInfo.put("", "");
    }
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mapCellTimestamp != null) {
      paramJceOutputStream.write(this.mapCellTimestamp, 0);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.mobile_custom_setting_cell_get_req
 * JD-Core Version:    0.7.0.1
 */