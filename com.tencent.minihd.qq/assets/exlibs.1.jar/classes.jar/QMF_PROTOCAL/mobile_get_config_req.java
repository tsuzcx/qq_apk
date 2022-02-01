package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_get_config_req
  extends JceStruct
{
  public int appid = 0;
  public String cookies = "";
  public int scene = 0;
  
  public mobile_get_config_req() {}
  
  public mobile_get_config_req(int paramInt1, int paramInt2, String paramString)
  {
    this.appid = paramInt1;
    this.scene = paramInt2;
    this.cookies = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.scene = paramJceInputStream.read(this.scene, 1, false);
    this.cookies = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.scene, 1);
    if (this.cookies != null) {
      paramJceOutputStream.write(this.cookies, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QMF_PROTOCAL.mobile_get_config_req
 * JD-Core Version:    0.7.0.1
 */