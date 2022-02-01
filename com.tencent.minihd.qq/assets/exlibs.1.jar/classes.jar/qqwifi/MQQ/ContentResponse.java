package qqwifi.MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ContentResponse
  extends JceStruct
{
  public String resource = "";
  public int ret = 0;
  
  public ContentResponse() {}
  
  public ContentResponse(int paramInt, String paramString)
  {
    this.ret = paramInt;
    this.resource = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.resource = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.resource, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     qqwifi.MQQ.ContentResponse
 * JD-Core Version:    0.7.0.1
 */