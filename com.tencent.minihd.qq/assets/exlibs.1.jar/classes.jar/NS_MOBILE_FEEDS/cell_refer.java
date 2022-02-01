package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_refer
  extends JceStruct
{
  public int actiontype = 0;
  public String actionurl = "";
  public String appid = "";
  public String appname = "";
  public String downloadurl = "";
  
  public cell_refer() {}
  
  public cell_refer(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.appname = paramString1;
    this.actionurl = paramString2;
    this.downloadurl = paramString3;
    this.appid = paramString4;
    this.actiontype = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appname = paramJceInputStream.readString(0, true);
    this.actionurl = paramJceInputStream.readString(1, true);
    this.downloadurl = paramJceInputStream.readString(2, false);
    this.appid = paramJceInputStream.readString(3, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appname, 0);
    paramJceOutputStream.write(this.actionurl, 1);
    if (this.downloadurl != null) {
      paramJceOutputStream.write(this.downloadurl, 2);
    }
    if (this.appid != null) {
      paramJceOutputStream.write(this.appid, 3);
    }
    paramJceOutputStream.write(this.actiontype, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_refer
 * JD-Core Version:    0.7.0.1
 */