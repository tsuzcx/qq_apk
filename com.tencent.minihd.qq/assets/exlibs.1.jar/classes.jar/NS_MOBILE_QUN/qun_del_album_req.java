package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class qun_del_album_req
  extends JceStruct
{
  public String albumid = "";
  public String qunid = "";
  
  public qun_del_album_req() {}
  
  public qun_del_album_req(String paramString1, String paramString2)
  {
    this.qunid = paramString1;
    this.albumid = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, true);
    this.albumid = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.qunid, 0);
    paramJceOutputStream.write(this.albumid, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_del_album_req
 * JD-Core Version:    0.7.0.1
 */