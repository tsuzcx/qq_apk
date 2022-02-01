package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SSummaryCardSetReq
  extends JceStruct
{
  static int cache_cmd;
  public long bgid = 0L;
  public long cardid = 0L;
  public int cmd = 2;
  public long color = 0L;
  public long platform = 0L;
  public long styleid = 0L;
  public long uin = 0L;
  public String url = "";
  public String version = "4.7.0";
  
  public SSummaryCardSetReq() {}
  
  public SSummaryCardSetReq(int paramInt, long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, long paramLong5, String paramString2, long paramLong6)
  {
    this.cmd = paramInt;
    this.uin = paramLong1;
    this.cardid = paramLong2;
    this.version = paramString1;
    this.platform = paramLong3;
    this.styleid = paramLong4;
    this.bgid = paramLong5;
    this.url = paramString2;
    this.color = paramLong6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cmd = paramJceInputStream.read(this.cmd, 0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    this.cardid = paramJceInputStream.read(this.cardid, 2, true);
    this.version = paramJceInputStream.readString(3, false);
    this.platform = paramJceInputStream.read(this.platform, 4, false);
    this.styleid = paramJceInputStream.read(this.styleid, 5, false);
    this.bgid = paramJceInputStream.read(this.bgid, 6, false);
    this.url = paramJceInputStream.readString(7, false);
    this.color = paramJceInputStream.read(this.color, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmd, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.cardid, 2);
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 3);
    }
    paramJceOutputStream.write(this.platform, 4);
    paramJceOutputStream.write(this.styleid, 5);
    paramJceOutputStream.write(this.bgid, 6);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 7);
    }
    paramJceOutputStream.write(this.color, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SummaryCardTaf.SSummaryCardSetReq
 * JD-Core Version:    0.7.0.1
 */