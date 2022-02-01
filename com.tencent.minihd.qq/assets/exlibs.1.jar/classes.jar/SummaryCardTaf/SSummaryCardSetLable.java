package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SSummaryCardSetLable
  extends JceStruct
{
  static int cache_cmd;
  static ArrayList cache_lables;
  public int cmd = 4;
  public ArrayList lables = null;
  public long platform = 0L;
  public long uin = 0L;
  public String version = "5.2.0";
  
  public SSummaryCardSetLable() {}
  
  public SSummaryCardSetLable(int paramInt, long paramLong1, String paramString, long paramLong2, ArrayList paramArrayList)
  {
    this.cmd = paramInt;
    this.uin = paramLong1;
    this.version = paramString;
    this.platform = paramLong2;
    this.lables = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cmd = paramJceInputStream.read(this.cmd, 0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    this.version = paramJceInputStream.readString(2, false);
    this.platform = paramJceInputStream.read(this.platform, 3, false);
    if (cache_lables == null)
    {
      cache_lables = new ArrayList();
      cache_lables.add(Long.valueOf(0L));
    }
    this.lables = ((ArrayList)paramJceInputStream.read(cache_lables, 4, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmd, 0);
    paramJceOutputStream.write(this.uin, 1);
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 2);
    }
    paramJceOutputStream.write(this.platform, 3);
    paramJceOutputStream.write(this.lables, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SummaryCardTaf.SSummaryCardSetLable
 * JD-Core Version:    0.7.0.1
 */