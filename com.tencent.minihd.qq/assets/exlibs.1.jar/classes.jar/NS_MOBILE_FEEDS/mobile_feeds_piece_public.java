package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_feeds_piece_public
  extends JceStruct
{
  public String attach_info = "";
  public int hasmore = 0;
  public long host_imbitmap = 0L;
  public String hostnick = "";
  public long iFollowNum = 0L;
  public int iYellowLevel = 0;
  public int iYellowType = 0;
  public long newcount = 0L;
  public int no_update = 0;
  public long req_count = 0L;
  public String user_sid = "";
  
  public mobile_feeds_piece_public() {}
  
  public mobile_feeds_piece_public(int paramInt1, long paramLong1, String paramString1, String paramString2, int paramInt2, long paramLong2, int paramInt3, int paramInt4, long paramLong3, long paramLong4, String paramString3)
  {
    this.hasmore = paramInt1;
    this.newcount = paramLong1;
    this.hostnick = paramString1;
    this.attach_info = paramString2;
    this.no_update = paramInt2;
    this.req_count = paramLong2;
    this.iYellowType = paramInt3;
    this.iYellowLevel = paramInt4;
    this.iFollowNum = paramLong3;
    this.host_imbitmap = paramLong4;
    this.user_sid = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasmore = paramJceInputStream.read(this.hasmore, 0, false);
    this.newcount = paramJceInputStream.read(this.newcount, 1, false);
    this.hostnick = paramJceInputStream.readString(2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    this.no_update = paramJceInputStream.read(this.no_update, 4, false);
    this.req_count = paramJceInputStream.read(this.req_count, 5, false);
    this.iYellowType = paramJceInputStream.read(this.iYellowType, 6, false);
    this.iYellowLevel = paramJceInputStream.read(this.iYellowLevel, 7, false);
    this.iFollowNum = paramJceInputStream.read(this.iFollowNum, 8, false);
    this.host_imbitmap = paramJceInputStream.read(this.host_imbitmap, 9, false);
    this.user_sid = paramJceInputStream.readString(10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hasmore, 0);
    paramJceOutputStream.write(this.newcount, 1);
    if (this.hostnick != null) {
      paramJceOutputStream.write(this.hostnick, 2);
    }
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 3);
    }
    paramJceOutputStream.write(this.no_update, 4);
    paramJceOutputStream.write(this.req_count, 5);
    paramJceOutputStream.write(this.iYellowType, 6);
    paramJceOutputStream.write(this.iYellowLevel, 7);
    paramJceOutputStream.write(this.iFollowNum, 8);
    paramJceOutputStream.write(this.host_imbitmap, 9);
    if (this.user_sid != null) {
      paramJceOutputStream.write(this.user_sid, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.mobile_feeds_piece_public
 * JD-Core Version:    0.7.0.1
 */