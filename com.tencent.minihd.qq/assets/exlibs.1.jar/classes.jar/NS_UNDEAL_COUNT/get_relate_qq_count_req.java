package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class get_relate_qq_count_req
  extends JceStruct
{
  static ArrayList cache_vecRelateUserlist;
  public ArrayList vecRelateUserlist = null;
  
  public get_relate_qq_count_req() {}
  
  public get_relate_qq_count_req(ArrayList paramArrayList)
  {
    this.vecRelateUserlist = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecRelateUserlist == null)
    {
      cache_vecRelateUserlist = new ArrayList();
      cache_vecRelateUserlist.add(Long.valueOf(0L));
    }
    this.vecRelateUserlist = ((ArrayList)paramJceInputStream.read(cache_vecRelateUserlist, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecRelateUserlist != null) {
      paramJceOutputStream.write(this.vecRelateUserlist, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.get_relate_qq_count_req
 * JD-Core Version:    0.7.0.1
 */