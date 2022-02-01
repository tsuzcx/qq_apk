package PushAdMsg;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AdMsgInfo
  extends JceStruct
{
  public String strMsgContent = "";
  public long uDstUin = 0L;
  public int uMsgType = 0;
  public long uSrcUin = 0L;
  public long utime = 0L;
  
  public AdMsgInfo() {}
  
  public AdMsgInfo(long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString)
  {
    this.uSrcUin = paramLong1;
    this.uDstUin = paramLong2;
    this.utime = paramLong3;
    this.uMsgType = paramInt;
    this.strMsgContent = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uSrcUin = paramJceInputStream.read(this.uSrcUin, 1, true);
    this.uDstUin = paramJceInputStream.read(this.uDstUin, 2, true);
    this.utime = paramJceInputStream.read(this.utime, 3, true);
    this.uMsgType = paramJceInputStream.read(this.uMsgType, 4, true);
    this.strMsgContent = paramJceInputStream.readString(5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uSrcUin, 1);
    paramJceOutputStream.write(this.uDstUin, 2);
    paramJceOutputStream.write(this.utime, 3);
    paramJceOutputStream.write(this.uMsgType, 4);
    paramJceOutputStream.write(this.strMsgContent, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     PushAdMsg.AdMsgInfo
 * JD-Core Version:    0.7.0.1
 */