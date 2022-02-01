package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_operation
  extends JceStruct
{
  static Map cache_busi_param;
  static Map cache_click_stream_report;
  static Map cache_recomm_cookie;
  static s_schema cache_schema_info;
  static s_outshare cache_share_info;
  public Map busi_param = null;
  public Map click_stream_report = null;
  public String qboss_trace = "";
  public String qq_url = "";
  public Map recomm_cookie = null;
  public s_schema schema_info = null;
  public s_outshare share_info = null;
  public String weixin_url = "";
  
  public cell_operation() {}
  
  public cell_operation(Map paramMap1, String paramString1, String paramString2, s_outshare params_outshare, s_schema params_schema, Map paramMap2, Map paramMap3, String paramString3)
  {
    this.busi_param = paramMap1;
    this.weixin_url = paramString1;
    this.qq_url = paramString2;
    this.share_info = params_outshare;
    this.schema_info = params_schema;
    this.recomm_cookie = paramMap2;
    this.click_stream_report = paramMap3;
    this.qboss_trace = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 0, false));
    this.weixin_url = paramJceInputStream.readString(1, false);
    this.qq_url = paramJceInputStream.readString(2, false);
    if (cache_share_info == null) {
      cache_share_info = new s_outshare();
    }
    this.share_info = ((s_outshare)paramJceInputStream.read(cache_share_info, 3, false));
    if (cache_schema_info == null) {
      cache_schema_info = new s_schema();
    }
    this.schema_info = ((s_schema)paramJceInputStream.read(cache_schema_info, 4, false));
    if (cache_recomm_cookie == null)
    {
      cache_recomm_cookie = new HashMap();
      cache_recomm_cookie.put(Integer.valueOf(0), "");
    }
    this.recomm_cookie = ((Map)paramJceInputStream.read(cache_recomm_cookie, 5, false));
    if (cache_click_stream_report == null)
    {
      cache_click_stream_report = new HashMap();
      HashMap localHashMap = new HashMap();
      localHashMap.put("", "");
      cache_click_stream_report.put(Integer.valueOf(0), localHashMap);
    }
    this.click_stream_report = ((Map)paramJceInputStream.read(cache_click_stream_report, 6, false));
    this.qboss_trace = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 0);
    }
    if (this.weixin_url != null) {
      paramJceOutputStream.write(this.weixin_url, 1);
    }
    if (this.qq_url != null) {
      paramJceOutputStream.write(this.qq_url, 2);
    }
    if (this.share_info != null) {
      paramJceOutputStream.write(this.share_info, 3);
    }
    if (this.schema_info != null) {
      paramJceOutputStream.write(this.schema_info, 4);
    }
    if (this.recomm_cookie != null) {
      paramJceOutputStream.write(this.recomm_cookie, 5);
    }
    if (this.click_stream_report != null) {
      paramJceOutputStream.write(this.click_stream_report, 6);
    }
    if (this.qboss_trace != null) {
      paramJceOutputStream.write(this.qboss_trace, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_operation
 * JD-Core Version:    0.7.0.1
 */