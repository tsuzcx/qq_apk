package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class TimeRangePhotoList
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_photo_list;
  public long begin_time = 0L;
  public long end_time = 0L;
  public ArrayList photo_list = null;
  public long total = 0L;
  
  public TimeRangePhotoList() {}
  
  public TimeRangePhotoList(long paramLong1, long paramLong2, long paramLong3, ArrayList paramArrayList)
  {
    this.begin_time = paramLong1;
    this.end_time = paramLong2;
    this.total = paramLong3;
    this.photo_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.begin_time = paramJceInputStream.read(this.begin_time, 0, true);
    this.end_time = paramJceInputStream.read(this.end_time, 1, true);
    this.total = paramJceInputStream.read(this.total, 2, true);
    if (cache_photo_list == null)
    {
      cache_photo_list = new ArrayList();
      s_picdata locals_picdata = new s_picdata();
      cache_photo_list.add(locals_picdata);
    }
    this.photo_list = ((ArrayList)paramJceInputStream.read(cache_photo_list, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.begin_time, 0);
    paramJceOutputStream.write(this.end_time, 1);
    paramJceOutputStream.write(this.total, 2);
    paramJceOutputStream.write(this.photo_list, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.TimeRangePhotoList
 * JD-Core Version:    0.7.0.1
 */