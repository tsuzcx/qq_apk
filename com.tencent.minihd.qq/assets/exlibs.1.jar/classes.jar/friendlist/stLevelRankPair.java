package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stLevelRankPair
  extends JceStruct
{
  public long dwLevel = 0L;
  public String strRank = "";
  
  public stLevelRankPair() {}
  
  public stLevelRankPair(long paramLong, String paramString)
  {
    this.dwLevel = paramLong;
    this.strRank = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwLevel = paramJceInputStream.read(this.dwLevel, 0, false);
    this.strRank = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwLevel, 0);
    if (this.strRank != null) {
      paramJceOutputStream.write(this.strRank, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     friendlist.stLevelRankPair
 * JD-Core Version:    0.7.0.1
 */