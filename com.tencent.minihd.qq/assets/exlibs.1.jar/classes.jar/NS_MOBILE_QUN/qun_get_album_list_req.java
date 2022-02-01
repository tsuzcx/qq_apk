package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class qun_get_album_list_req
  extends JceStruct
{
  public String attach_info = "";
  public int count = 0;
  public String qunid = "";
  
  public qun_get_album_list_req() {}
  
  public qun_get_album_list_req(String paramString1, int paramInt, String paramString2)
  {
    this.qunid = paramString1;
    this.count = paramInt;
    this.attach_info = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, false);
    this.count = paramJceInputStream.read(this.count, 1, false);
    this.attach_info = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.qunid != null) {
      paramJceOutputStream.write(this.qunid, 0);
    }
    paramJceOutputStream.write(this.count, 1);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_get_album_list_req
 * JD-Core Version:    0.7.0.1
 */