package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PanSocialInfo
  extends JceStruct
{
  public byte bAllowVindicate = 0;
  public long uCharmRank = 0L;
  
  public PanSocialInfo() {}
  
  public PanSocialInfo(long paramLong, byte paramByte)
  {
    this.uCharmRank = paramLong;
    this.bAllowVindicate = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uCharmRank = paramJceInputStream.read(this.uCharmRank, 0, false);
    this.bAllowVindicate = paramJceInputStream.read(this.bAllowVindicate, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uCharmRank, 0);
    paramJceOutputStream.write(this.bAllowVindicate, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SummaryCard.PanSocialInfo
 * JD-Core Version:    0.7.0.1
 */