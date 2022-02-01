package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_recent_photo
  extends JceStruct
{
  public String albumid = "";
  public String albumname = "";
  public int comment = 0;
  public String desc = "";
  public int height = 0;
  public String lloc = "";
  public int mheight = 0;
  public int modifytime = 0;
  public String murl = "";
  public int mwidth = 0;
  public String name = "";
  public int sheight = 0;
  public String sloc = "";
  public String surl = "";
  public int swidth = 0;
  public int type = 0;
  public int uploadtime = 0;
  public String url = "";
  public int width = 0;
  
  public s_recent_photo() {}
  
  public s_recent_photo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.lloc = paramString1;
    this.sloc = paramString2;
    this.name = paramString3;
    this.desc = paramString4;
    this.uploadtime = paramInt1;
    this.modifytime = paramInt2;
    this.comment = paramInt3;
    this.width = paramInt4;
    this.height = paramInt5;
    this.mwidth = paramInt6;
    this.mheight = paramInt7;
    this.swidth = paramInt8;
    this.sheight = paramInt9;
    this.type = paramInt10;
    this.url = paramString5;
    this.murl = paramString6;
    this.surl = paramString7;
    this.albumid = paramString8;
    this.albumname = paramString9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lloc = paramJceInputStream.readString(0, true);
    this.sloc = paramJceInputStream.readString(1, true);
    this.name = paramJceInputStream.readString(2, true);
    this.desc = paramJceInputStream.readString(3, true);
    this.uploadtime = paramJceInputStream.read(this.uploadtime, 4, true);
    this.modifytime = paramJceInputStream.read(this.modifytime, 5, true);
    this.comment = paramJceInputStream.read(this.comment, 6, true);
    this.width = paramJceInputStream.read(this.width, 7, true);
    this.height = paramJceInputStream.read(this.height, 8, true);
    this.mwidth = paramJceInputStream.read(this.mwidth, 9, true);
    this.mheight = paramJceInputStream.read(this.mheight, 10, true);
    this.swidth = paramJceInputStream.read(this.swidth, 11, true);
    this.sheight = paramJceInputStream.read(this.sheight, 12, true);
    this.type = paramJceInputStream.read(this.type, 13, true);
    this.url = paramJceInputStream.readString(14, true);
    this.murl = paramJceInputStream.readString(15, true);
    this.surl = paramJceInputStream.readString(16, true);
    this.albumid = paramJceInputStream.readString(17, true);
    this.albumname = paramJceInputStream.readString(18, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lloc, 0);
    paramJceOutputStream.write(this.sloc, 1);
    paramJceOutputStream.write(this.name, 2);
    paramJceOutputStream.write(this.desc, 3);
    paramJceOutputStream.write(this.uploadtime, 4);
    paramJceOutputStream.write(this.modifytime, 5);
    paramJceOutputStream.write(this.comment, 6);
    paramJceOutputStream.write(this.width, 7);
    paramJceOutputStream.write(this.height, 8);
    paramJceOutputStream.write(this.mwidth, 9);
    paramJceOutputStream.write(this.mheight, 10);
    paramJceOutputStream.write(this.swidth, 11);
    paramJceOutputStream.write(this.sheight, 12);
    paramJceOutputStream.write(this.type, 13);
    paramJceOutputStream.write(this.url, 14);
    paramJceOutputStream.write(this.murl, 15);
    paramJceOutputStream.write(this.surl, 16);
    paramJceOutputStream.write(this.albumid, 17);
    paramJceOutputStream.write(this.albumname, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_recent_photo
 * JD-Core Version:    0.7.0.1
 */