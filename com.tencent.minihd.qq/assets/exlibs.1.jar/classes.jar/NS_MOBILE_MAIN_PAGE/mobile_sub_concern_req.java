package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_concern_req
  extends JceStruct
{
  public int isconcern = 0;
  public long objuin = 0L;
  
  public mobile_sub_concern_req() {}
  
  public mobile_sub_concern_req(long paramLong, int paramInt)
  {
    this.objuin = paramLong;
    this.isconcern = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.objuin = paramJceInputStream.read(this.objuin, 0, true);
    this.isconcern = paramJceInputStream.read(this.isconcern, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.objuin, 0);
    paramJceOutputStream.write(this.isconcern, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_concern_req
 * JD-Core Version:    0.7.0.1
 */