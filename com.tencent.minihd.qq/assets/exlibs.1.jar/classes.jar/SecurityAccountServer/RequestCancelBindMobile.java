package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestCancelBindMobile
  extends JceStruct
{
  public String mobileNo = "";
  public String nationCode = "";
  
  public RequestCancelBindMobile() {}
  
  public RequestCancelBindMobile(String paramString1, String paramString2)
  {
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nationCode = paramJceInputStream.readString(0, true);
    this.mobileNo = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nationCode, 0);
    paramJceOutputStream.write(this.mobileNo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SecurityAccountServer.RequestCancelBindMobile
 * JD-Core Version:    0.7.0.1
 */