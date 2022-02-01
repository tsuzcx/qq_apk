package NS_MOBILE_AIONewestFeed;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class NewestFeedInfo
  extends JceStruct
{
  public String strContent = "";
  public String strImgUrl = "";
  public String strJmpUrl = "";
  public String strLBSInfo = "";
  public String strSummary = "";
  public String strTitle = "";
  public long uAppid = 0L;
  public long uHostUin = 0L;
  public long uImgCount = 0L;
  public long uTime = 0L;
  
  public NewestFeedInfo() {}
  
  public NewestFeedInfo(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong4, String paramString6)
  {
    this.uAppid = paramLong1;
    this.uHostUin = paramLong2;
    this.uTime = paramLong3;
    this.strLBSInfo = paramString1;
    this.strSummary = paramString2;
    this.strTitle = paramString3;
    this.strContent = paramString4;
    this.strImgUrl = paramString5;
    this.uImgCount = paramLong4;
    this.strJmpUrl = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uAppid = paramJceInputStream.read(this.uAppid, 0, false);
    this.uHostUin = paramJceInputStream.read(this.uHostUin, 1, false);
    this.uTime = paramJceInputStream.read(this.uTime, 2, false);
    this.strLBSInfo = paramJceInputStream.readString(3, false);
    this.strSummary = paramJceInputStream.readString(4, false);
    this.strTitle = paramJceInputStream.readString(5, false);
    this.strContent = paramJceInputStream.readString(6, false);
    this.strImgUrl = paramJceInputStream.readString(7, false);
    this.uImgCount = paramJceInputStream.read(this.uImgCount, 8, false);
    this.strJmpUrl = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uAppid, 0);
    paramJceOutputStream.write(this.uHostUin, 1);
    paramJceOutputStream.write(this.uTime, 2);
    if (this.strLBSInfo != null) {
      paramJceOutputStream.write(this.strLBSInfo, 3);
    }
    if (this.strSummary != null) {
      paramJceOutputStream.write(this.strSummary, 4);
    }
    if (this.strTitle != null) {
      paramJceOutputStream.write(this.strTitle, 5);
    }
    if (this.strContent != null) {
      paramJceOutputStream.write(this.strContent, 6);
    }
    if (this.strImgUrl != null) {
      paramJceOutputStream.write(this.strImgUrl, 7);
    }
    paramJceOutputStream.write(this.uImgCount, 8);
    if (this.strJmpUrl != null) {
      paramJceOutputStream.write(this.strJmpUrl, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_AIONewestFeed.NewestFeedInfo
 * JD-Core Version:    0.7.0.1
 */