package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_rec_photo_list
  extends JceStruct
{
  static ArrayList cache_rec_photo_list;
  public ArrayList rec_photo_list = null;
  
  public s_rec_photo_list() {}
  
  public s_rec_photo_list(ArrayList paramArrayList)
  {
    this.rec_photo_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_rec_photo_list == null)
    {
      cache_rec_photo_list = new ArrayList();
      s_recent_photo locals_recent_photo = new s_recent_photo();
      cache_rec_photo_list.add(locals_recent_photo);
    }
    this.rec_photo_list = ((ArrayList)paramJceInputStream.read(cache_rec_photo_list, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.rec_photo_list != null) {
      paramJceOutputStream.write(this.rec_photo_list, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_rec_photo_list
 * JD-Core Version:    0.7.0.1
 */