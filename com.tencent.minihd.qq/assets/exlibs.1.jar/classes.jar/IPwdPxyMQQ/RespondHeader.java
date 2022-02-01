package IPwdPxyMQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespondHeader
  extends JceStruct
{
  static byte[] cache_tips;
  public int cmd = 0;
  public long requestID = 0L;
  public int result = 0;
  public long svrSeqNo = 0L;
  public byte[] tips = null;
  public String uin = "";
  public int ver = 0;
  
  public RespondHeader() {}
  
  public RespondHeader(int paramInt1, int paramInt2, long paramLong1, String paramString, long paramLong2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.ver = paramInt1;
    this.cmd = paramInt2;
    this.requestID = paramLong1;
    this.uin = paramString;
    this.svrSeqNo = paramLong2;
    this.result = paramInt3;
    this.tips = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ver = paramJceInputStream.read(this.ver, 0, true);
    this.cmd = paramJceInputStream.read(this.cmd, 1, true);
    this.requestID = paramJceInputStream.read(this.requestID, 2, true);
    this.uin = paramJceInputStream.readString(3, true);
    this.svrSeqNo = paramJceInputStream.read(this.svrSeqNo, 4, true);
    this.result = paramJceInputStream.read(this.result, 5, true);
    if (cache_tips == null)
    {
      cache_tips = (byte[])new byte[1];
      ((byte[])cache_tips)[0] = 0;
    }
    this.tips = ((byte[])paramJceInputStream.read(cache_tips, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ver, 0);
    paramJceOutputStream.write(this.cmd, 1);
    paramJceOutputStream.write(this.requestID, 2);
    paramJceOutputStream.write(this.uin, 3);
    paramJceOutputStream.write(this.svrSeqNo, 4);
    paramJceOutputStream.write(this.result, 5);
    if (this.tips != null) {
      paramJceOutputStream.write(this.tips, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     IPwdPxyMQQ.RespondHeader
 * JD-Core Version:    0.7.0.1
 */