package NS_MOBILE_TAGLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ModTagReq
  extends JceStruct
{
  static TagInfo cache_tagInfo;
  public TagInfo tagInfo = null;
  public long uin = 0L;
  
  public ModTagReq() {}
  
  public ModTagReq(long paramLong, TagInfo paramTagInfo)
  {
    this.uin = paramLong;
    this.tagInfo = paramTagInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    if (cache_tagInfo == null) {
      cache_tagInfo = new TagInfo();
    }
    this.tagInfo = ((TagInfo)paramJceInputStream.read(cache_tagInfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.tagInfo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_TAGLIST.ModTagReq
 * JD-Core Version:    0.7.0.1
 */