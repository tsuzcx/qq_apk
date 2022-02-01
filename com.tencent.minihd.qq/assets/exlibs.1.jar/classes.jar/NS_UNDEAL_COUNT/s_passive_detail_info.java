package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_passive_detail_info
  extends JceStruct
{
  public String sPassiveMessage = "";
  public long uPassiveCount = 0L;
  public long uRecentPassvieTime = 0L;
  
  public s_passive_detail_info() {}
  
  public s_passive_detail_info(long paramLong1, String paramString, long paramLong2)
  {
    this.uPassiveCount = paramLong1;
    this.sPassiveMessage = paramString;
    this.uRecentPassvieTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uPassiveCount = paramJceInputStream.read(this.uPassiveCount, 0, false);
    this.sPassiveMessage = paramJceInputStream.readString(1, false);
    this.uRecentPassvieTime = paramJceInputStream.read(this.uRecentPassvieTime, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uPassiveCount, 0);
    if (this.sPassiveMessage != null) {
      paramJceOutputStream.write(this.sPassiveMessage, 1);
    }
    paramJceOutputStream.write(this.uRecentPassvieTime, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.s_passive_detail_info
 * JD-Core Version:    0.7.0.1
 */