package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_detail_content
  extends JceStruct
{
  static ArrayList cache_detail_content;
  public ArrayList detail_content = null;
  
  public cell_detail_content() {}
  
  public cell_detail_content(ArrayList paramArrayList)
  {
    this.detail_content = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_detail_content == null)
    {
      cache_detail_content = new ArrayList();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_detail_content.add(arrayOfByte);
    }
    this.detail_content = ((ArrayList)paramJceInputStream.read(cache_detail_content, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.detail_content != null) {
      paramJceOutputStream.write(this.detail_content, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_detail_content
 * JD-Core Version:    0.7.0.1
 */