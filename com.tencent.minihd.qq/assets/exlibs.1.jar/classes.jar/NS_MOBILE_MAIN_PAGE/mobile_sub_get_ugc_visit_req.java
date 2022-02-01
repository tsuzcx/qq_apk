package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_FEEDS.cell_id;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_sub_get_ugc_visit_req
  extends JceStruct
{
  static Map cache_busi_param;
  static cell_id cache_ugcId;
  public int appid = 0;
  public Map busi_param = null;
  public String page = "";
  public cell_id ugcId = null;
  public long uin = 0L;
  
  public mobile_sub_get_ugc_visit_req() {}
  
  public mobile_sub_get_ugc_visit_req(long paramLong, int paramInt, cell_id paramcell_id, Map paramMap, String paramString)
  {
    this.uin = paramLong;
    this.appid = paramInt;
    this.ugcId = paramcell_id;
    this.busi_param = paramMap;
    this.page = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.appid = paramJceInputStream.read(this.appid, 1, false);
    if (cache_ugcId == null) {
      cache_ugcId = new cell_id();
    }
    this.ugcId = ((cell_id)paramJceInputStream.read(cache_ugcId, 2, false));
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 3, false));
    this.page = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.appid, 1);
    if (this.ugcId != null) {
      paramJceOutputStream.write(this.ugcId, 2);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 3);
    }
    if (this.page != null) {
      paramJceOutputStream.write(this.page, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_ugc_visit_req
 * JD-Core Version:    0.7.0.1
 */