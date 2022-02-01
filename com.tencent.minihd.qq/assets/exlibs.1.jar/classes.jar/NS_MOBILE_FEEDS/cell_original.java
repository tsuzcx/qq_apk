package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_original
  extends JceStruct
{
  static Map cache_original_data;
  public Map original_data = null;
  
  public cell_original() {}
  
  public cell_original(Map paramMap)
  {
    this.original_data = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_original_data == null)
    {
      cache_original_data = new HashMap();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_original_data.put(Integer.valueOf(0), arrayOfByte);
    }
    this.original_data = ((Map)paramJceInputStream.read(cache_original_data, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.original_data != null) {
      paramJceOutputStream.write(this.original_data, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_original
 * JD-Core Version:    0.7.0.1
 */