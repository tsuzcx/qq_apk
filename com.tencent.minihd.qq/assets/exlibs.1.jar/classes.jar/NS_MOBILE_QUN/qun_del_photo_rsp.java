package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class qun_del_photo_rsp
  extends JceStruct
{
  static ArrayList cache_failed_photo_list;
  public ArrayList failed_photo_list = null;
  
  public qun_del_photo_rsp() {}
  
  public qun_del_photo_rsp(ArrayList paramArrayList)
  {
    this.failed_photo_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_failed_photo_list == null)
    {
      cache_failed_photo_list = new ArrayList();
      cache_failed_photo_list.add("");
    }
    this.failed_photo_list = ((ArrayList)paramJceInputStream.read(cache_failed_photo_list, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.failed_photo_list, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_del_photo_rsp
 * JD-Core Version:    0.7.0.1
 */