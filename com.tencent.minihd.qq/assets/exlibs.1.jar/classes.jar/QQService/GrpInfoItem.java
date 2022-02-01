package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GrpInfoItem
  extends JceStruct
{
  public long Content = 0L;
  public byte Type = 0;
  
  public GrpInfoItem() {}
  
  public GrpInfoItem(byte paramByte, long paramLong)
  {
    this.Type = paramByte;
    this.Content = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Type = paramJceInputStream.read(this.Type, 0, true);
    this.Content = paramJceInputStream.read(this.Content, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Type, 0);
    paramJceOutputStream.write(this.Content, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.GrpInfoItem
 * JD-Core Version:    0.7.0.1
 */