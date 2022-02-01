package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class qun_mainpage_rsp
  extends JceStruct
{
  public int album_count = 0;
  
  public qun_mainpage_rsp() {}
  
  public qun_mainpage_rsp(int paramInt)
  {
    this.album_count = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.album_count = paramJceInputStream.read(this.album_count, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.album_count, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_mainpage_rsp
 * JD-Core Version:    0.7.0.1
 */