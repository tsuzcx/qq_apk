package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_getspaceright_req
  extends JceStruct
{
  public int getDetail = 0;
  public long uin = 0L;
  
  public mobile_sub_getspaceright_req() {}
  
  public mobile_sub_getspaceright_req(long paramLong, int paramInt)
  {
    this.uin = paramLong;
    this.getDetail = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.getDetail = paramJceInputStream.read(this.getDetail, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.getDetail, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_getspaceright_req
 * JD-Core Version:    0.7.0.1
 */