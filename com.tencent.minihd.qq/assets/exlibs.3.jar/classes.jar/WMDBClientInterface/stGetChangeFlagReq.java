package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetChangeFlagReq
  extends JceStruct
{
  public int changeVersion = 0;
  
  public stGetChangeFlagReq() {}
  
  public stGetChangeFlagReq(int paramInt)
  {
    this.changeVersion = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.changeVersion = paramJceInputStream.read(this.changeVersion, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.changeVersion, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     WMDBClientInterface.stGetChangeFlagReq
 * JD-Core Version:    0.7.0.1
 */