package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_rank
  extends JceStruct
{
  public int half_star_num = 0;
  public int max = 0;
  
  public s_rank() {}
  
  public s_rank(int paramInt1, int paramInt2)
  {
    this.max = paramInt1;
    this.half_star_num = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.max = paramJceInputStream.read(this.max, 0, false);
    this.half_star_num = paramJceInputStream.read(this.half_star_num, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.max, 0);
    paramJceOutputStream.write(this.half_star_num, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_rank
 * JD-Core Version:    0.7.0.1
 */