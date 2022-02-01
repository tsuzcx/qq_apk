package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class qun_add_comment_req
  extends JceStruct
{
  static Map cache_busi_param;
  public String albumId = "";
  public Map busi_param = null;
  public int comment_type = 0;
  public String content = "";
  public long ownuin = 0L;
  public String qunid = "";
  public String srcid = "";
  public long uin = 0L;
  
  public qun_add_comment_req() {}
  
  public qun_add_comment_req(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, int paramInt, String paramString4, Map paramMap)
  {
    this.qunid = paramString1;
    this.uin = paramLong1;
    this.ownuin = paramLong2;
    this.srcid = paramString2;
    this.content = paramString3;
    this.comment_type = paramInt;
    this.albumId = paramString4;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.ownuin = paramJceInputStream.read(this.ownuin, 2, false);
    this.srcid = paramJceInputStream.readString(3, false);
    this.content = paramJceInputStream.readString(4, false);
    this.comment_type = paramJceInputStream.read(this.comment_type, 5, false);
    this.albumId = paramJceInputStream.readString(6, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.qunid, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.ownuin, 2);
    if (this.srcid != null) {
      paramJceOutputStream.write(this.srcid, 3);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 4);
    }
    paramJceOutputStream.write(this.comment_type, 5);
    if (this.albumId != null) {
      paramJceOutputStream.write(this.albumId, 6);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_add_comment_req
 * JD-Core Version:    0.7.0.1
 */