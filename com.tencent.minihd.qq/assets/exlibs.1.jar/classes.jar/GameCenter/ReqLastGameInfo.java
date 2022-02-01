package GameCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqLastGameInfo
  extends JceStruct
{
  public byte iVersion = 1;
  public long lUin = 0L;
  
  public ReqLastGameInfo() {}
  
  public ReqLastGameInfo(byte paramByte, long paramLong)
  {
    this.iVersion = paramByte;
    this.lUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iVersion = paramJceInputStream.read(this.iVersion, 0, true);
    this.lUin = paramJceInputStream.read(this.lUin, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iVersion, 0);
    paramJceOutputStream.write(this.lUin, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     GameCenter.ReqLastGameInfo
 * JD-Core Version:    0.7.0.1
 */