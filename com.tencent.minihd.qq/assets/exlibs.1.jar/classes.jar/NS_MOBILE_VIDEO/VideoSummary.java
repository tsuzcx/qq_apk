package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class VideoSummary
  extends JceStruct
{
  static Map cache_cover;
  public Map cover = null;
  public int num = 0;
  
  public VideoSummary() {}
  
  public VideoSummary(int paramInt, Map paramMap)
  {
    this.num = paramInt;
    this.cover = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    if (cache_cover == null)
    {
      cache_cover = new HashMap();
      cache_cover.put(Integer.valueOf(0), "");
    }
    this.cover = ((Map)paramJceInputStream.read(cache_cover, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    if (this.cover != null) {
      paramJceOutputStream.write(this.cover, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_VIDEO.VideoSummary
 * JD-Core Version:    0.7.0.1
 */