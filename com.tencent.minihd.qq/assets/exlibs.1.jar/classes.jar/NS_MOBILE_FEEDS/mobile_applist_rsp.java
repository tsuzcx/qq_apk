package NS_MOBILE_FEEDS;

import NS_MOBILE_VIDEO.VideoSummary;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_applist_rsp
  extends JceStruct
{
  static ArrayList cache_all_applist_data;
  static single_feed cache_share_album;
  static VideoSummary cache_video_summary;
  public ArrayList all_applist_data = null;
  public String attach_info = "";
  public int auto_load = 0;
  public int hasmore = 0;
  public int remain_count = 0;
  public single_feed share_album = null;
  public VideoSummary video_summary = null;
  
  public mobile_applist_rsp() {}
  
  public mobile_applist_rsp(ArrayList paramArrayList, int paramInt1, int paramInt2, String paramString, int paramInt3, single_feed paramsingle_feed, VideoSummary paramVideoSummary)
  {
    this.all_applist_data = paramArrayList;
    this.hasmore = paramInt1;
    this.remain_count = paramInt2;
    this.attach_info = paramString;
    this.auto_load = paramInt3;
    this.share_album = paramsingle_feed;
    this.video_summary = paramVideoSummary;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_all_applist_data == null)
    {
      cache_all_applist_data = new ArrayList();
      single_feed localsingle_feed = new single_feed();
      cache_all_applist_data.add(localsingle_feed);
    }
    this.all_applist_data = ((ArrayList)paramJceInputStream.read(cache_all_applist_data, 0, false));
    this.hasmore = paramJceInputStream.read(this.hasmore, 1, false);
    this.remain_count = paramJceInputStream.read(this.remain_count, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    this.auto_load = paramJceInputStream.read(this.auto_load, 4, false);
    if (cache_share_album == null) {
      cache_share_album = new single_feed();
    }
    this.share_album = ((single_feed)paramJceInputStream.read(cache_share_album, 5, false));
    if (cache_video_summary == null) {
      cache_video_summary = new VideoSummary();
    }
    this.video_summary = ((VideoSummary)paramJceInputStream.read(cache_video_summary, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.all_applist_data != null) {
      paramJceOutputStream.write(this.all_applist_data, 0);
    }
    paramJceOutputStream.write(this.hasmore, 1);
    paramJceOutputStream.write(this.remain_count, 2);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
    paramJceOutputStream.write(this.auto_load, 4);
    if (this.share_album != null) {
      paramJceOutputStream.write(this.share_album, 5);
    }
    if (this.video_summary != null) {
      paramJceOutputStream.write(this.video_summary, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_applist_rsp
 * JD-Core Version:    0.7.0.1
 */