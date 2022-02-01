package NS_MOBILE_TAGLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AddTagRsp
  extends JceStruct
{
  public long id = 0L;
  
  public AddTagRsp() {}
  
  public AddTagRsp(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_TAGLIST.AddTagRsp
 * JD-Core Version:    0.7.0.1
 */