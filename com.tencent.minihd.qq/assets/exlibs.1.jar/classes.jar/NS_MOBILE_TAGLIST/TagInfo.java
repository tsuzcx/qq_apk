package NS_MOBILE_TAGLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class TagInfo
  extends JceStruct
{
  static ArrayList cache_uinList;
  public long id = 0L;
  public String name = "";
  public ArrayList uinList = null;
  
  public TagInfo() {}
  
  public TagInfo(long paramLong, String paramString, ArrayList paramArrayList)
  {
    this.id = paramLong;
    this.name = paramString;
    this.uinList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, true);
    this.name = paramJceInputStream.readString(1, true);
    if (cache_uinList == null)
    {
      cache_uinList = new ArrayList();
      cache_uinList.add(Long.valueOf(0L));
    }
    this.uinList = ((ArrayList)paramJceInputStream.read(cache_uinList, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.name, 1);
    paramJceOutputStream.write(this.uinList, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_TAGLIST.TagInfo
 * JD-Core Version:    0.7.0.1
 */