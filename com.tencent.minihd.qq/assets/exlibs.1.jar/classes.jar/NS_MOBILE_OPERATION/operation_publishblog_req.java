package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_publishblog_req
  extends JceStruct
{
  static Map cache_busi_param;
  public Map busi_param = null;
  public String clientkey = "";
  public String content = "";
  public boolean isverified = true;
  public String title = "";
  public long uin = 0L;
  
  public operation_publishblog_req() {}
  
  public operation_publishblog_req(long paramLong, String paramString1, String paramString2, boolean paramBoolean, Map paramMap, String paramString3)
  {
    this.uin = paramLong;
    this.title = paramString1;
    this.content = paramString2;
    this.isverified = paramBoolean;
    this.busi_param = paramMap;
    this.clientkey = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.title = paramJceInputStream.readString(1, false);
    this.content = paramJceInputStream.readString(2, false);
    this.isverified = paramJceInputStream.read(this.isverified, 3, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 4, false));
    this.clientkey = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 1);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 2);
    }
    paramJceOutputStream.write(this.isverified, 3);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 4);
    }
    if (this.clientkey != null) {
      paramJceOutputStream.write(this.clientkey, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_publishblog_req
 * JD-Core Version:    0.7.0.1
 */