package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_ugc_data_key
  extends JceStruct
{
  public long appid = 0L;
  public String dataid = "";
  public short platform = 0;
  public long uin = 0L;
  
  public s_ugc_data_key() {}
  
  public s_ugc_data_key(long paramLong1, long paramLong2, short paramShort, String paramString)
  {
    this.uin = paramLong1;
    this.appid = paramLong2;
    this.platform = paramShort;
    this.dataid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.appid = paramJceInputStream.read(this.appid, 1, true);
    this.platform = paramJceInputStream.read(this.platform, 2, true);
    this.dataid = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.platform, 2);
    paramJceOutputStream.write(this.dataid, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_ugc_data_key
 * JD-Core Version:    0.7.0.1
 */