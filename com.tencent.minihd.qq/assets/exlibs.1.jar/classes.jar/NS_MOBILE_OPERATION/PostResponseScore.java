package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PostResponseScore
  extends JceStruct
{
  public int change = 0;
  public long total = 0L;
  
  public PostResponseScore() {}
  
  public PostResponseScore(long paramLong, int paramInt)
  {
    this.total = paramLong;
    this.change = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.total = paramJceInputStream.read(this.total, 0, false);
    this.change = paramJceInputStream.read(this.change, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.total, 0);
    paramJceOutputStream.write(this.change, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.PostResponseScore
 * JD-Core Version:    0.7.0.1
 */