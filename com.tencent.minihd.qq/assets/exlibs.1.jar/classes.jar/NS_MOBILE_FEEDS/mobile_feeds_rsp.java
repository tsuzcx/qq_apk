package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_feeds_rsp
  extends JceStruct
{
  static ArrayList cache_all_feeds_data;
  static s_cover cache_host_cover;
  static st_prefetch cache_prefetch_rsp;
  public ArrayList all_feeds_data = null;
  public String attach_info = "";
  public int auto_load = 0;
  public int hasmore = 0;
  public s_cover host_cover = null;
  public long host_imbitmap = 0L;
  public long iFollowNum = 0L;
  public int is_realname_succ = 0;
  public long newcount = 0L;
  public int no_update = 0;
  public st_prefetch prefetch_rsp = null;
  public long req_count = 0L;
  public String user_sid = "";
  
  public mobile_feeds_rsp() {}
  
  public mobile_feeds_rsp(int paramInt1, String paramString1, ArrayList paramArrayList, long paramLong1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, long paramLong4, String paramString2, st_prefetch paramst_prefetch, int paramInt4, s_cover params_cover)
  {
    this.hasmore = paramInt1;
    this.attach_info = paramString1;
    this.all_feeds_data = paramArrayList;
    this.newcount = paramLong1;
    this.auto_load = paramInt2;
    this.no_update = paramInt3;
    this.req_count = paramLong2;
    this.iFollowNum = paramLong3;
    this.host_imbitmap = paramLong4;
    this.user_sid = paramString2;
    this.prefetch_rsp = paramst_prefetch;
    this.is_realname_succ = paramInt4;
    this.host_cover = params_cover;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasmore = paramJceInputStream.read(this.hasmore, 0, false);
    this.attach_info = paramJceInputStream.readString(1, false);
    if (cache_all_feeds_data == null)
    {
      cache_all_feeds_data = new ArrayList();
      single_feed localsingle_feed = new single_feed();
      cache_all_feeds_data.add(localsingle_feed);
    }
    this.all_feeds_data = ((ArrayList)paramJceInputStream.read(cache_all_feeds_data, 2, false));
    this.newcount = paramJceInputStream.read(this.newcount, 3, false);
    this.auto_load = paramJceInputStream.read(this.auto_load, 4, false);
    this.no_update = paramJceInputStream.read(this.no_update, 5, false);
    this.req_count = paramJceInputStream.read(this.req_count, 6, false);
    this.iFollowNum = paramJceInputStream.read(this.iFollowNum, 7, false);
    this.host_imbitmap = paramJceInputStream.read(this.host_imbitmap, 8, false);
    this.user_sid = paramJceInputStream.readString(9, false);
    if (cache_prefetch_rsp == null) {
      cache_prefetch_rsp = new st_prefetch();
    }
    this.prefetch_rsp = ((st_prefetch)paramJceInputStream.read(cache_prefetch_rsp, 10, false));
    this.is_realname_succ = paramJceInputStream.read(this.is_realname_succ, 11, false);
    if (cache_host_cover == null) {
      cache_host_cover = new s_cover();
    }
    this.host_cover = ((s_cover)paramJceInputStream.read(cache_host_cover, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hasmore, 0);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 1);
    }
    if (this.all_feeds_data != null) {
      paramJceOutputStream.write(this.all_feeds_data, 2);
    }
    paramJceOutputStream.write(this.newcount, 3);
    paramJceOutputStream.write(this.auto_load, 4);
    paramJceOutputStream.write(this.no_update, 5);
    paramJceOutputStream.write(this.req_count, 6);
    paramJceOutputStream.write(this.iFollowNum, 7);
    paramJceOutputStream.write(this.host_imbitmap, 8);
    if (this.user_sid != null) {
      paramJceOutputStream.write(this.user_sid, 9);
    }
    if (this.prefetch_rsp != null) {
      paramJceOutputStream.write(this.prefetch_rsp, 10);
    }
    paramJceOutputStream.write(this.is_realname_succ, 11);
    if (this.host_cover != null) {
      paramJceOutputStream.write(this.host_cover, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_feeds_rsp
 * JD-Core Version:    0.7.0.1
 */