package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MsgType0x210SubMsgType0x20
  extends JceStruct
{
  public long dwOpType = 0L;
  public long dwType = 0L;
  public long dwUin = 0L;
  public String strRemaek = "";
  
  public MsgType0x210SubMsgType0x20() {}
  
  public MsgType0x210SubMsgType0x20(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    this.dwOpType = paramLong1;
    this.dwType = paramLong2;
    this.dwUin = paramLong3;
    this.strRemaek = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwOpType = paramJceInputStream.read(this.dwOpType, 0, false);
    this.dwType = paramJceInputStream.read(this.dwType, 1, false);
    this.dwUin = paramJceInputStream.read(this.dwUin, 2, false);
    this.strRemaek = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwOpType, 0);
    paramJceOutputStream.write(this.dwType, 1);
    paramJceOutputStream.write(this.dwUin, 2);
    if (this.strRemaek != null) {
      paramJceOutputStream.write(this.strRemaek, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     IMMsgBodyPack.MsgType0x210SubMsgType0x20
 * JD-Core Version:    0.7.0.1
 */