package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class share_outsite_rsp
  extends JceStruct
{
  public String msg = "";
  public int ret = 0;
  public String url = "";
  
  public share_outsite_rsp() {}
  
  public share_outsite_rsp(int paramInt, String paramString1, String paramString2)
  {
    this.ret = paramInt;
    this.msg = paramString1;
    this.url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.url = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.share_outsite_rsp
 * JD-Core Version:    0.7.0.1
 */