package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class RespCreateDiscuss
  extends JceStruct
{
  static Map cache_AddResult;
  public Map AddResult = null;
  public long DiscussUin = 0L;
  
  public RespCreateDiscuss() {}
  
  public RespCreateDiscuss(long paramLong, Map paramMap)
  {
    this.DiscussUin = paramLong;
    this.AddResult = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    if (cache_AddResult == null)
    {
      cache_AddResult = new HashMap();
      cache_AddResult.put(Long.valueOf(0L), Integer.valueOf(0));
    }
    this.AddResult = ((Map)paramJceInputStream.read(cache_AddResult, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.AddResult, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.RespCreateDiscuss
 * JD-Core Version:    0.7.0.1
 */