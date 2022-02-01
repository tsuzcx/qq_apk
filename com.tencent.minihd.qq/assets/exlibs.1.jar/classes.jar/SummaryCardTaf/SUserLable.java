package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SUserLable
  extends JceStruct
{
  static Map cache_lable;
  public Map lable = null;
  
  public SUserLable() {}
  
  public SUserLable(Map paramMap)
  {
    this.lable = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_lable == null)
    {
      cache_lable = new HashMap();
      SLableInfo localSLableInfo = new SLableInfo();
      cache_lable.put(Long.valueOf(0L), localSLableInfo);
    }
    this.lable = ((Map)paramJceInputStream.read(cache_lable, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lable, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SummaryCardTaf.SUserLable
 * JD-Core Version:    0.7.0.1
 */