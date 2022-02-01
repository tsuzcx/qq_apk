package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_comm
  extends JceStruct
{
  public int actiontype = 0;
  public String actionurl = "";
  public int appid = 0;
  public String clientkey = "";
  public String curlikekey = "";
  public int feedsattr = 0;
  public String feedskey = "";
  public int feedstype = 0;
  public int operatemask = 0;
  public String orglikekey = "";
  public int originaltype = 0;
  public String refer = "";
  public int shield = 0;
  public long show_mask = 0L;
  public int subid = 0;
  public int time = 0;
  public int uflag = 0;
  public String ugckey = "";
  public String ugcrightkey = "";
  
  public cell_comm() {}
  
  public cell_comm(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5, int paramInt6, String paramString3, String paramString4, String paramString5, int paramInt7, int paramInt8, String paramString6, String paramString7, long paramLong, int paramInt9, int paramInt10, String paramString8)
  {
    this.appid = paramInt1;
    this.subid = paramInt2;
    this.refer = paramString1;
    this.time = paramInt3;
    this.actiontype = paramInt4;
    this.actionurl = paramString2;
    this.originaltype = paramInt5;
    this.operatemask = paramInt6;
    this.feedskey = paramString3;
    this.orglikekey = paramString4;
    this.curlikekey = paramString5;
    this.feedstype = paramInt7;
    this.feedsattr = paramInt8;
    this.ugckey = paramString6;
    this.clientkey = paramString7;
    this.show_mask = paramLong;
    this.uflag = paramInt9;
    this.shield = paramInt10;
    this.ugcrightkey = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.subid = paramJceInputStream.read(this.subid, 1, false);
    this.refer = paramJceInputStream.readString(2, false);
    this.time = paramJceInputStream.read(this.time, 3, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 4, false);
    this.actionurl = paramJceInputStream.readString(5, false);
    this.originaltype = paramJceInputStream.read(this.originaltype, 6, false);
    this.operatemask = paramJceInputStream.read(this.operatemask, 7, false);
    this.feedskey = paramJceInputStream.readString(8, false);
    this.orglikekey = paramJceInputStream.readString(9, false);
    this.curlikekey = paramJceInputStream.readString(10, false);
    this.feedstype = paramJceInputStream.read(this.feedstype, 11, false);
    this.feedsattr = paramJceInputStream.read(this.feedsattr, 12, false);
    this.ugckey = paramJceInputStream.readString(13, false);
    this.clientkey = paramJceInputStream.readString(14, false);
    this.show_mask = paramJceInputStream.read(this.show_mask, 15, false);
    this.uflag = paramJceInputStream.read(this.uflag, 16, false);
    this.shield = paramJceInputStream.read(this.shield, 17, false);
    this.ugcrightkey = paramJceInputStream.readString(18, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.subid, 1);
    if (this.refer != null) {
      paramJceOutputStream.write(this.refer, 2);
    }
    paramJceOutputStream.write(this.time, 3);
    paramJceOutputStream.write(this.actiontype, 4);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 5);
    }
    paramJceOutputStream.write(this.originaltype, 6);
    paramJceOutputStream.write(this.operatemask, 7);
    if (this.feedskey != null) {
      paramJceOutputStream.write(this.feedskey, 8);
    }
    if (this.orglikekey != null) {
      paramJceOutputStream.write(this.orglikekey, 9);
    }
    if (this.curlikekey != null) {
      paramJceOutputStream.write(this.curlikekey, 10);
    }
    paramJceOutputStream.write(this.feedstype, 11);
    paramJceOutputStream.write(this.feedsattr, 12);
    if (this.ugckey != null) {
      paramJceOutputStream.write(this.ugckey, 13);
    }
    if (this.clientkey != null) {
      paramJceOutputStream.write(this.clientkey, 14);
    }
    paramJceOutputStream.write(this.show_mask, 15);
    paramJceOutputStream.write(this.uflag, 16);
    paramJceOutputStream.write(this.shield, 17);
    if (this.ugcrightkey != null) {
      paramJceOutputStream.write(this.ugcrightkey, 18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_comm
 * JD-Core Version:    0.7.0.1
 */