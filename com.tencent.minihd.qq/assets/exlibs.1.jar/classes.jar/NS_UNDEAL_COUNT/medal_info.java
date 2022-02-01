package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class medal_info
  extends JceStruct
{
  public int level = 0;
  public int medalid = 0;
  public int updated = 0;
  
  public medal_info() {}
  
  public medal_info(int paramInt1, int paramInt2, int paramInt3)
  {
    this.updated = paramInt1;
    this.medalid = paramInt2;
    this.level = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.updated = paramJceInputStream.read(this.updated, 0, false);
    this.medalid = paramJceInputStream.read(this.medalid, 1, false);
    this.level = paramJceInputStream.read(this.level, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.updated, 0);
    paramJceOutputStream.write(this.medalid, 1);
    paramJceOutputStream.write(this.level, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.medal_info
 * JD-Core Version:    0.7.0.1
 */