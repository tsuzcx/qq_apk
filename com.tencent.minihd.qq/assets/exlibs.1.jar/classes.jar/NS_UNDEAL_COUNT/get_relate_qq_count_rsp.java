package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class get_relate_qq_count_rsp
  extends JceStruct
{
  static Map cache_mapRelatePassiveInfo;
  public Map mapRelatePassiveInfo = null;
  
  public get_relate_qq_count_rsp() {}
  
  public get_relate_qq_count_rsp(Map paramMap)
  {
    this.mapRelatePassiveInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_mapRelatePassiveInfo == null)
    {
      cache_mapRelatePassiveInfo = new HashMap();
      s_passive_detail_info locals_passive_detail_info = new s_passive_detail_info();
      cache_mapRelatePassiveInfo.put(Long.valueOf(0L), locals_passive_detail_info);
    }
    this.mapRelatePassiveInfo = ((Map)paramJceInputStream.read(cache_mapRelatePassiveInfo, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mapRelatePassiveInfo != null) {
      paramJceOutputStream.write(this.mapRelatePassiveInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.get_relate_qq_count_rsp
 * JD-Core Version:    0.7.0.1
 */