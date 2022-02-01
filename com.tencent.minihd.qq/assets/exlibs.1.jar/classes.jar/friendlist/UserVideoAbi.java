package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserVideoAbi
  extends JceStruct
{
  public byte bStatus = 0;
  public long uin = 0L;
  
  public UserVideoAbi() {}
  
  public UserVideoAbi(long paramLong, byte paramByte)
  {
    this.uin = paramLong;
    this.bStatus = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.bStatus = paramJceInputStream.read(this.bStatus, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.bStatus, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     friendlist.UserVideoAbi
 * JD-Core Version:    0.7.0.1
 */