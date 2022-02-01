package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MsgType0x210SubMsgType0x13_MsgItem
  extends JceStruct
{
  static byte[] cache_bytes_text;
  public byte[] bytes_text = null;
  public long uint32_type = 0L;
  
  public MsgType0x210SubMsgType0x13_MsgItem() {}
  
  public MsgType0x210SubMsgType0x13_MsgItem(long paramLong, byte[] paramArrayOfByte)
  {
    this.uint32_type = paramLong;
    this.bytes_text = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uint32_type = paramJceInputStream.read(this.uint32_type, 0, false);
    if (cache_bytes_text == null)
    {
      cache_bytes_text = (byte[])new byte[1];
      ((byte[])cache_bytes_text)[0] = 0;
    }
    this.bytes_text = ((byte[])paramJceInputStream.read(cache_bytes_text, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uint32_type, 0);
    if (this.bytes_text != null) {
      paramJceOutputStream.write(this.bytes_text, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     IMMsgBodyPack.MsgType0x210SubMsgType0x13_MsgItem
 * JD-Core Version:    0.7.0.1
 */