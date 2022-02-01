package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RspTopic
  extends JceStruct
{
  static byte[] cache_strRspTopic;
  public short shShowPos = 4;
  public byte[] strRspTopic = null;
  
  public RspTopic() {}
  
  public RspTopic(short paramShort, byte[] paramArrayOfByte)
  {
    this.shShowPos = paramShort;
    this.strRspTopic = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shShowPos = paramJceInputStream.read(this.shShowPos, 0, true);
    if (cache_strRspTopic == null)
    {
      cache_strRspTopic = (byte[])new byte[1];
      ((byte[])cache_strRspTopic)[0] = 0;
    }
    this.strRspTopic = ((byte[])paramJceInputStream.read(cache_strRspTopic, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shShowPos, 0);
    paramJceOutputStream.write(this.strRspTopic, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NearbyGroup.RspTopic
 * JD-Core Version:    0.7.0.1
 */