package NS_MOBILE_NEWEST_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class newest_feeds_rsp
  extends JceStruct
{
  static ArrayList cache_vec_feed_info;
  public int code = 0;
  public long last_feed_time = 0L;
  public String str_attach = "";
  public ArrayList vec_feed_info = null;
  
  public newest_feeds_rsp() {}
  
  public newest_feeds_rsp(int paramInt, ArrayList paramArrayList, long paramLong, String paramString)
  {
    this.code = paramInt;
    this.vec_feed_info = paramArrayList;
    this.last_feed_time = paramLong;
    this.str_attach = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, false);
    if (cache_vec_feed_info == null)
    {
      cache_vec_feed_info = new ArrayList();
      feed_info localfeed_info = new feed_info();
      cache_vec_feed_info.add(localfeed_info);
    }
    this.vec_feed_info = ((ArrayList)paramJceInputStream.read(cache_vec_feed_info, 1, false));
    this.last_feed_time = paramJceInputStream.read(this.last_feed_time, 2, false);
    this.str_attach = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
    if (this.vec_feed_info != null) {
      paramJceOutputStream.write(this.vec_feed_info, 1);
    }
    paramJceOutputStream.write(this.last_feed_time, 2);
    if (this.str_attach != null) {
      paramJceOutputStream.write(this.str_attach, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp
 * JD-Core Version:    0.7.0.1
 */