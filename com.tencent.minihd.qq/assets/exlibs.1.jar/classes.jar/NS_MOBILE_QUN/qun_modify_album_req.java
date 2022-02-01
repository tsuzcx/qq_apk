package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class qun_modify_album_req
  extends JceStruct
{
  static Album cache_album;
  public Album album = null;
  
  public qun_modify_album_req() {}
  
  public qun_modify_album_req(Album paramAlbum)
  {
    this.album = paramAlbum;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_album == null) {
      cache_album = new Album();
    }
    this.album = ((Album)paramJceInputStream.read(cache_album, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.album, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_modify_album_req
 * JD-Core Version:    0.7.0.1
 */