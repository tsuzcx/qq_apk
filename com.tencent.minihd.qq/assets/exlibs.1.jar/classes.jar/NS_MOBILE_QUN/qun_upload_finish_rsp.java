package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class qun_upload_finish_rsp
  extends JceStruct
{
  public int retry_timeout = 0;
  
  public qun_upload_finish_rsp() {}
  
  public qun_upload_finish_rsp(int paramInt)
  {
    this.retry_timeout = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.retry_timeout = paramJceInputStream.read(this.retry_timeout, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retry_timeout, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_upload_finish_rsp
 * JD-Core Version:    0.7.0.1
 */