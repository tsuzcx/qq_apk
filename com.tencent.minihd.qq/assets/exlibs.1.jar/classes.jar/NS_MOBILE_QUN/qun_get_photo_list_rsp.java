package NS_MOBILE_QUN;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class qun_get_photo_list_rsp
  extends JceStruct
{
  static ArrayList cache_adminUin;
  static Album cache_albuminfo;
  static ArrayList cache_photolist;
  public ArrayList adminUin = null;
  public Album albuminfo = null;
  public String attach_info = "";
  public int hasmore = 0;
  public int operationMask = 0;
  public long ownerUin = 0L;
  public ArrayList photolist = null;
  
  public qun_get_photo_list_rsp() {}
  
  public qun_get_photo_list_rsp(Album paramAlbum, ArrayList paramArrayList1, int paramInt1, String paramString, long paramLong, ArrayList paramArrayList2, int paramInt2)
  {
    this.albuminfo = paramAlbum;
    this.photolist = paramArrayList1;
    this.hasmore = paramInt1;
    this.attach_info = paramString;
    this.ownerUin = paramLong;
    this.adminUin = paramArrayList2;
    this.operationMask = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_albuminfo == null) {
      cache_albuminfo = new Album();
    }
    this.albuminfo = ((Album)paramJceInputStream.read(cache_albuminfo, 0, true));
    if (cache_photolist == null)
    {
      cache_photolist = new ArrayList();
      s_picdata locals_picdata = new s_picdata();
      cache_photolist.add(locals_picdata);
    }
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 1, true));
    this.hasmore = paramJceInputStream.read(this.hasmore, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    this.ownerUin = paramJceInputStream.read(this.ownerUin, 4, false);
    if (cache_adminUin == null)
    {
      cache_adminUin = new ArrayList();
      cache_adminUin.add(Long.valueOf(0L));
    }
    this.adminUin = ((ArrayList)paramJceInputStream.read(cache_adminUin, 5, false));
    this.operationMask = paramJceInputStream.read(this.operationMask, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albuminfo, 0);
    paramJceOutputStream.write(this.photolist, 1);
    paramJceOutputStream.write(this.hasmore, 2);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
    paramJceOutputStream.write(this.ownerUin, 4);
    if (this.adminUin != null) {
      paramJceOutputStream.write(this.adminUin, 5);
    }
    paramJceOutputStream.write(this.operationMask, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_get_photo_list_rsp
 * JD-Core Version:    0.7.0.1
 */