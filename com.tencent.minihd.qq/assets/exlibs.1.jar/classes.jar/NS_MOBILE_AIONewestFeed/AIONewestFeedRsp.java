package NS_MOBILE_AIONewestFeed;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AIONewestFeedRsp
  extends JceStruct
{
  static ArrayList cache_uFeedInfos;
  public ArrayList uFeedInfos = null;
  public long uOpuin = 0L;
  public long uTime = 0L;
  
  public AIONewestFeedRsp() {}
  
  public AIONewestFeedRsp(long paramLong1, long paramLong2, ArrayList paramArrayList)
  {
    this.uOpuin = paramLong1;
    this.uTime = paramLong2;
    this.uFeedInfos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uOpuin = paramJceInputStream.read(this.uOpuin, 0, false);
    this.uTime = paramJceInputStream.read(this.uTime, 1, false);
    if (cache_uFeedInfos == null)
    {
      cache_uFeedInfos = new ArrayList();
      NewestFeedInfo localNewestFeedInfo = new NewestFeedInfo();
      cache_uFeedInfos.add(localNewestFeedInfo);
    }
    this.uFeedInfos = ((ArrayList)paramJceInputStream.read(cache_uFeedInfos, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uOpuin, 0);
    paramJceOutputStream.write(this.uTime, 1);
    if (this.uFeedInfos != null) {
      paramJceOutputStream.write(this.uFeedInfos, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_AIONewestFeed.AIONewestFeedRsp
 * JD-Core Version:    0.7.0.1
 */