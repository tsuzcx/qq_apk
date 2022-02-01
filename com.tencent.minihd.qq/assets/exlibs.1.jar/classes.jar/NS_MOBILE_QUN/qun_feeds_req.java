package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class qun_feeds_req
  extends JceStruct
{
  static Map cache_busi_param;
  public String attach_info = "";
  public Map busi_param = null;
  public String qunid = "";
  public int refresh_type = 0;
  public int relation_type = 0;
  public long uin = 0L;
  
  public qun_feeds_req() {}
  
  public qun_feeds_req(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, Map paramMap)
  {
    this.qunid = paramString1;
    this.uin = paramLong;
    this.refresh_type = paramInt1;
    this.relation_type = paramInt2;
    this.attach_info = paramString2;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    this.refresh_type = paramJceInputStream.read(this.refresh_type, 2, false);
    this.relation_type = paramJceInputStream.read(this.relation_type, 3, false);
    this.attach_info = paramJceInputStream.readString(4, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.qunid, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.refresh_type, 2);
    paramJceOutputStream.write(this.relation_type, 3);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 4);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_feeds_req
 * JD-Core Version:    0.7.0.1
 */