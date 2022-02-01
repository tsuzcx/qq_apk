package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_cover
  extends JceStruct
{
  public String cover_id = "";
  public int cover_ts = 0;
  
  public cell_cover() {}
  
  public cell_cover(String paramString, int paramInt)
  {
    this.cover_id = paramString;
    this.cover_ts = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cover_id = paramJceInputStream.readString(0, false);
    this.cover_ts = paramJceInputStream.read(this.cover_ts, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.cover_id != null) {
      paramJceOutputStream.write(this.cover_id, 0);
    }
    paramJceOutputStream.write(this.cover_ts, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_cover
 * JD-Core Version:    0.7.0.1
 */