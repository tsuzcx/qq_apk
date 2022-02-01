package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operat_data
  extends JceStruct
{
  static Map cache_mapExt;
  public int cmd = 0;
  public String desc = "";
  public Map mapExt = null;
  
  public operat_data() {}
  
  public operat_data(int paramInt, String paramString, Map paramMap)
  {
    this.cmd = paramInt;
    this.desc = paramString;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cmd = paramJceInputStream.read(this.cmd, 0, false);
    this.desc = paramJceInputStream.readString(1, false);
    if (cache_mapExt == null)
    {
      cache_mapExt = new HashMap();
      cache_mapExt.put("", "");
    }
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmd, 0);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 1);
    }
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.operat_data
 * JD-Core Version:    0.7.0.1
 */