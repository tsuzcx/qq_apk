package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_addreply_req
  extends JceStruct
{
  static Map cache_busi_param;
  static MediaInfo cache_mediainfo;
  public int appid = 0;
  public Map busi_param = null;
  public String commentid = "";
  public long commentuin = 0L;
  public String content = "";
  public int isverified = 0;
  public int mediabittype = 0;
  public MediaInfo mediainfo = null;
  public long ownuin = 0L;
  public String srcId = "";
  public long uin = 0L;
  
  public operation_addreply_req() {}
  
  public operation_addreply_req(int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, int paramInt2, Map paramMap, MediaInfo paramMediaInfo, int paramInt3)
  {
    this.appid = paramInt1;
    this.uin = paramLong1;
    this.ownuin = paramLong2;
    this.commentuin = paramLong3;
    this.srcId = paramString1;
    this.commentid = paramString2;
    this.content = paramString3;
    this.isverified = paramInt2;
    this.busi_param = paramMap;
    this.mediainfo = paramMediaInfo;
    this.mediabittype = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.ownuin = paramJceInputStream.read(this.ownuin, 2, false);
    this.commentuin = paramJceInputStream.read(this.commentuin, 3, false);
    this.srcId = paramJceInputStream.readString(4, false);
    this.commentid = paramJceInputStream.readString(5, false);
    this.content = paramJceInputStream.readString(6, false);
    this.isverified = paramJceInputStream.read(this.isverified, 7, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 8, false));
    if (cache_mediainfo == null) {
      cache_mediainfo = new MediaInfo();
    }
    this.mediainfo = ((MediaInfo)paramJceInputStream.read(cache_mediainfo, 9, false));
    this.mediabittype = paramJceInputStream.read(this.mediabittype, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.ownuin, 2);
    paramJceOutputStream.write(this.commentuin, 3);
    if (this.srcId != null) {
      paramJceOutputStream.write(this.srcId, 4);
    }
    if (this.commentid != null) {
      paramJceOutputStream.write(this.commentid, 5);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 6);
    }
    paramJceOutputStream.write(this.isverified, 7);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 8);
    }
    if (this.mediainfo != null) {
      paramJceOutputStream.write(this.mediainfo, 9);
    }
    paramJceOutputStream.write(this.mediabittype, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_addreply_req
 * JD-Core Version:    0.7.0.1
 */