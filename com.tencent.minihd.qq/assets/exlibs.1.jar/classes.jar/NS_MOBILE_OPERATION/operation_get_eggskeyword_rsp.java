package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class operation_get_eggskeyword_rsp
  extends JceStruct
{
  static Map cache_mapKeyWordEggs;
  public int ifOpenEntrance = 0;
  public Map mapKeyWordEggs = null;
  
  public operation_get_eggskeyword_rsp() {}
  
  public operation_get_eggskeyword_rsp(int paramInt, Map paramMap)
  {
    this.ifOpenEntrance = paramInt;
    this.mapKeyWordEggs = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ifOpenEntrance = paramJceInputStream.read(this.ifOpenEntrance, 0, true);
    if (cache_mapKeyWordEggs == null)
    {
      cache_mapKeyWordEggs = new HashMap();
      ImageSummaryList localImageSummaryList = new ImageSummaryList();
      cache_mapKeyWordEggs.put("", localImageSummaryList);
    }
    this.mapKeyWordEggs = ((Map)paramJceInputStream.read(cache_mapKeyWordEggs, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ifOpenEntrance, 0);
    if (this.mapKeyWordEggs != null) {
      paramJceOutputStream.write(this.mapKeyWordEggs, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_get_eggskeyword_rsp
 * JD-Core Version:    0.7.0.1
 */