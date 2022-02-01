package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_feeds_piece_list
  extends JceStruct
{
  static ArrayList cache_all_feeds_data;
  public ArrayList all_feeds_data = null;
  public long offset = 0L;
  public String tlv_attach_info = "";
  
  public mobile_feeds_piece_list() {}
  
  public mobile_feeds_piece_list(ArrayList paramArrayList, long paramLong, String paramString)
  {
    this.all_feeds_data = paramArrayList;
    this.offset = paramLong;
    this.tlv_attach_info = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_all_feeds_data == null)
    {
      cache_all_feeds_data = new ArrayList();
      single_feed localsingle_feed = new single_feed();
      cache_all_feeds_data.add(localsingle_feed);
    }
    this.all_feeds_data = ((ArrayList)paramJceInputStream.read(cache_all_feeds_data, 0, false));
    this.offset = paramJceInputStream.read(this.offset, 1, false);
    this.tlv_attach_info = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.all_feeds_data != null) {
      paramJceOutputStream.write(this.all_feeds_data, 0);
    }
    paramJceOutputStream.write(this.offset, 1);
    if (this.tlv_attach_info != null) {
      paramJceOutputStream.write(this.tlv_attach_info, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_feeds_piece_list
 * JD-Core Version:    0.7.0.1
 */