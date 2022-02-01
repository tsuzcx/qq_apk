package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class get_parenting_photo_list_rsp
  extends JceStruct
  implements Cloneable
{
  static Album cache_albuminfo;
  static Map cache_busi_param;
  static ArrayList cache_photolist;
  static s_outshare cache_shareinfo;
  static ArrayList cache_timeline;
  public Album albuminfo = null;
  public int appid = 0;
  public String attach_info = "";
  public Map busi_param = null;
  public int hasmore = 0;
  public ArrayList photolist = null;
  public s_outshare shareinfo = null;
  public ArrayList timeline = null;
  
  public get_parenting_photo_list_rsp() {}
  
  public get_parenting_photo_list_rsp(Album paramAlbum, ArrayList paramArrayList1, String paramString, int paramInt1, ArrayList paramArrayList2, Map paramMap, int paramInt2, s_outshare params_outshare)
  {
    this.albuminfo = paramAlbum;
    this.photolist = paramArrayList1;
    this.attach_info = paramString;
    this.hasmore = paramInt1;
    this.timeline = paramArrayList2;
    this.busi_param = paramMap;
    this.appid = paramInt2;
    this.shareinfo = params_outshare;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_albuminfo == null) {
      cache_albuminfo = new Album();
    }
    this.albuminfo = ((Album)paramJceInputStream.read(cache_albuminfo, 0, true));
    Object localObject;
    if (cache_photolist == null)
    {
      cache_photolist = new ArrayList();
      localObject = new s_picdata();
      cache_photolist.add(localObject);
    }
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 1, true));
    this.attach_info = paramJceInputStream.readString(2, false);
    this.hasmore = paramJceInputStream.read(this.hasmore, 3, false);
    if (cache_timeline == null)
    {
      cache_timeline = new ArrayList();
      localObject = new TimeLine();
      cache_timeline.add(localObject);
    }
    this.timeline = ((ArrayList)paramJceInputStream.read(cache_timeline, 4, false));
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 5, false));
    this.appid = paramJceInputStream.read(this.appid, 6, false);
    if (cache_shareinfo == null) {
      cache_shareinfo = new s_outshare();
    }
    this.shareinfo = ((s_outshare)paramJceInputStream.read(cache_shareinfo, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albuminfo, 0);
    paramJceOutputStream.write(this.photolist, 1);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
    paramJceOutputStream.write(this.hasmore, 3);
    if (this.timeline != null) {
      paramJceOutputStream.write(this.timeline, 4);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 5);
    }
    paramJceOutputStream.write(this.appid, 6);
    if (this.shareinfo != null) {
      paramJceOutputStream.write(this.shareinfo, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_parenting_photo_list_rsp
 * JD-Core Version:    0.7.0.1
 */