package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class edit_album_req
  extends JceStruct
{
  static Album cache_album;
  static Map cache_busi_param;
  public Album album = null;
  public Map busi_param = null;
  public String newCoverId = "";
  
  public edit_album_req() {}
  
  public edit_album_req(Album paramAlbum, Map paramMap, String paramString)
  {
    this.album = paramAlbum;
    this.busi_param = paramMap;
    this.newCoverId = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_album == null) {
      cache_album = new Album();
    }
    this.album = ((Album)paramJceInputStream.read(cache_album, 0, true));
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 1, false));
    this.newCoverId = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.album, 0);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 1);
    }
    if (this.newCoverId != null) {
      paramJceOutputStream.write(this.newCoverId, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.edit_album_req
 * JD-Core Version:    0.7.0.1
 */