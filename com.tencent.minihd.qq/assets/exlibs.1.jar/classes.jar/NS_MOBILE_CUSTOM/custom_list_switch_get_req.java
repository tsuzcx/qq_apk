package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class custom_list_switch_get_req
  extends JceStruct
{
  public long lUin = 0L;
  
  public custom_list_switch_get_req() {}
  
  public custom_list_switch_get_req(long paramLong)
  {
    this.lUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.custom_list_switch_get_req
 * JD-Core Version:    0.7.0.1
 */