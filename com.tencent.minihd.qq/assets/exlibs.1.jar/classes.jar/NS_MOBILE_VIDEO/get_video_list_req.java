package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class get_video_list_req
  extends JceStruct
{
  public String attach_info_new = "";
  public String attach_info_old = "";
  public long uin = 0L;
  
  public get_video_list_req() {}
  
  public get_video_list_req(long paramLong, String paramString1, String paramString2)
  {
    this.uin = paramLong;
    this.attach_info_new = paramString1;
    this.attach_info_old = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.attach_info_new = paramJceInputStream.readString(1, false);
    this.attach_info_old = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.attach_info_new != null) {
      paramJceOutputStream.write(this.attach_info_new, 1);
    }
    if (this.attach_info_old != null) {
      paramJceOutputStream.write(this.attach_info_old, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_VIDEO.get_video_list_req
 * JD-Core Version:    0.7.0.1
 */