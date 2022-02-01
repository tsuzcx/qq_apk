package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_feed_alert_req
  extends JceStruct
{
  static Map cache_mapTimeStamp;
  public Map mapTimeStamp = null;
  public long uMask = 0L;
  
  public mobile_feed_alert_req() {}
  
  public mobile_feed_alert_req(long paramLong, Map paramMap)
  {
    this.uMask = paramLong;
    this.mapTimeStamp = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uMask = paramJceInputStream.read(this.uMask, 0, false);
    if (cache_mapTimeStamp == null)
    {
      cache_mapTimeStamp = new HashMap();
      cache_mapTimeStamp.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    this.mapTimeStamp = ((Map)paramJceInputStream.read(cache_mapTimeStamp, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uMask, 0);
    if (this.mapTimeStamp != null) {
      paramJceOutputStream.write(this.mapTimeStamp, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.mobile_feed_alert_req
 * JD-Core Version:    0.7.0.1
 */