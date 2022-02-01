package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class get_photo_list_2_rsp
  extends JceStruct
{
  static Album cache_albuminfo;
  static ArrayList cache_photolist;
  static s_outshare cache_shareinfo;
  public Album albuminfo = null;
  public int appid = 0;
  public int curindex = 0;
  public long finish = 0L;
  public ArrayList photolist = null;
  public s_outshare shareinfo = null;
  public long total = 0L;
  
  public get_photo_list_2_rsp() {}
  
  public get_photo_list_2_rsp(Album paramAlbum, ArrayList paramArrayList, int paramInt1, int paramInt2, long paramLong1, long paramLong2, s_outshare params_outshare)
  {
    this.albuminfo = paramAlbum;
    this.photolist = paramArrayList;
    this.curindex = paramInt1;
    this.appid = paramInt2;
    this.total = paramLong1;
    this.finish = paramLong2;
    this.shareinfo = params_outshare;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_albuminfo == null) {
      cache_albuminfo = new Album();
    }
    this.albuminfo = ((Album)paramJceInputStream.read(cache_albuminfo, 1, true));
    if (cache_photolist == null)
    {
      cache_photolist = new ArrayList();
      s_picdata locals_picdata = new s_picdata();
      cache_photolist.add(locals_picdata);
    }
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 2, true));
    this.curindex = paramJceInputStream.read(this.curindex, 3, false);
    this.appid = paramJceInputStream.read(this.appid, 4, false);
    this.total = paramJceInputStream.read(this.total, 5, false);
    this.finish = paramJceInputStream.read(this.finish, 6, false);
    if (cache_shareinfo == null) {
      cache_shareinfo = new s_outshare();
    }
    this.shareinfo = ((s_outshare)paramJceInputStream.read(cache_shareinfo, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albuminfo, 1);
    paramJceOutputStream.write(this.photolist, 2);
    paramJceOutputStream.write(this.curindex, 3);
    paramJceOutputStream.write(this.appid, 4);
    paramJceOutputStream.write(this.total, 5);
    paramJceOutputStream.write(this.finish, 6);
    if (this.shareinfo != null) {
      paramJceOutputStream.write(this.shareinfo, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_photo_list_2_rsp
 * JD-Core Version:    0.7.0.1
 */