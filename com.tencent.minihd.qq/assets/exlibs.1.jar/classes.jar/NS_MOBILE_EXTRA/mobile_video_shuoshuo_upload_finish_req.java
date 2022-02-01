package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_video_shuoshuo_upload_finish_req
  extends JceStruct
{
  public long iSize = 0L;
  public long iTimeLength = 0L;
  
  public mobile_video_shuoshuo_upload_finish_req() {}
  
  public mobile_video_shuoshuo_upload_finish_req(long paramLong1, long paramLong2)
  {
    this.iSize = paramLong1;
    this.iTimeLength = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iSize = paramJceInputStream.read(this.iSize, 0, false);
    this.iTimeLength = paramJceInputStream.read(this.iTimeLength, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iSize, 0);
    paramJceOutputStream.write(this.iTimeLength, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_EXTRA.mobile_video_shuoshuo_upload_finish_req
 * JD-Core Version:    0.7.0.1
 */