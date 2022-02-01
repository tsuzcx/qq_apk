package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CSRespPushStreamMsg
  extends JceStruct
{
  static StreamInfo cache_stStreamInfo;
  public int iSeq = 0;
  public long lKey = 0L;
  public short shResetSeq = 0;
  public short shVersion = 0;
  public StreamInfo stStreamInfo = null;
  
  public CSRespPushStreamMsg() {}
  
  public CSRespPushStreamMsg(short paramShort1, int paramInt, StreamInfo paramStreamInfo, short paramShort2, long paramLong)
  {
    this.shVersion = paramShort1;
    this.iSeq = paramInt;
    this.stStreamInfo = paramStreamInfo;
    this.shResetSeq = paramShort2;
    this.lKey = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
    if (cache_stStreamInfo == null) {
      cache_stStreamInfo = new StreamInfo();
    }
    this.stStreamInfo = ((StreamInfo)paramJceInputStream.read(cache_stStreamInfo, 2, true));
    this.shResetSeq = paramJceInputStream.read(this.shResetSeq, 3, true);
    this.lKey = paramJceInputStream.read(this.lKey, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.stStreamInfo, 2);
    paramJceOutputStream.write(this.shResetSeq, 3);
    paramJceOutputStream.write(this.lKey, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.CSRespPushStreamMsg
 * JD-Core Version:    0.7.0.1
 */