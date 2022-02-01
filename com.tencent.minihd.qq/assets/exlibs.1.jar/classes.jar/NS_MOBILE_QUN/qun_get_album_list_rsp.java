package NS_MOBILE_QUN;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class qun_get_album_list_rsp
  extends JceStruct
{
  static ArrayList cache_adminUin;
  static ArrayList cache_all_album_list_data;
  public ArrayList adminUin = null;
  public ArrayList all_album_list_data = null;
  public String attach_info = "";
  public int hasmore = 0;
  public long ownerUin = 0L;
  
  public qun_get_album_list_rsp() {}
  
  public qun_get_album_list_rsp(ArrayList paramArrayList1, int paramInt, String paramString, long paramLong, ArrayList paramArrayList2)
  {
    this.all_album_list_data = paramArrayList1;
    this.hasmore = paramInt;
    this.attach_info = paramString;
    this.ownerUin = paramLong;
    this.adminUin = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_all_album_list_data == null)
    {
      cache_all_album_list_data = new ArrayList();
      single_feed localsingle_feed = new single_feed();
      cache_all_album_list_data.add(localsingle_feed);
    }
    this.all_album_list_data = ((ArrayList)paramJceInputStream.read(cache_all_album_list_data, 0, false));
    this.hasmore = paramJceInputStream.read(this.hasmore, 1, false);
    this.attach_info = paramJceInputStream.readString(2, false);
    this.ownerUin = paramJceInputStream.read(this.ownerUin, 3, false);
    if (cache_adminUin == null)
    {
      cache_adminUin = new ArrayList();
      cache_adminUin.add(Long.valueOf(0L));
    }
    this.adminUin = ((ArrayList)paramJceInputStream.read(cache_adminUin, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.all_album_list_data != null) {
      paramJceOutputStream.write(this.all_album_list_data, 0);
    }
    paramJceOutputStream.write(this.hasmore, 1);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
    paramJceOutputStream.write(this.ownerUin, 3);
    if (this.adminUin != null) {
      paramJceOutputStream.write(this.adminUin, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_get_album_list_rsp
 * JD-Core Version:    0.7.0.1
 */