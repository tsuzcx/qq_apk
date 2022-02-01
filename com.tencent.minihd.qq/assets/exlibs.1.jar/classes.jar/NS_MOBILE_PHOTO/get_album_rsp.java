package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class get_album_rsp
  extends JceStruct
{
  static Album cache_album;
  public Album album = null;
  public int albumFaceNum = 0;
  public int albumLikeNum = 0;
  public String albumLikekey = "";
  public int albumVisitNum = 0;
  public boolean isMyLiked = false;
  public String largeCoverUrl = "";
  
  public get_album_rsp() {}
  
  public get_album_rsp(Album paramAlbum, int paramInt1, int paramInt2, String paramString1, int paramInt3, boolean paramBoolean, String paramString2)
  {
    this.album = paramAlbum;
    this.albumFaceNum = paramInt1;
    this.albumLikeNum = paramInt2;
    this.albumLikekey = paramString1;
    this.albumVisitNum = paramInt3;
    this.isMyLiked = paramBoolean;
    this.largeCoverUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_album == null) {
      cache_album = new Album();
    }
    this.album = ((Album)paramJceInputStream.read(cache_album, 0, true));
    this.albumFaceNum = paramJceInputStream.read(this.albumFaceNum, 1, false);
    this.albumLikeNum = paramJceInputStream.read(this.albumLikeNum, 2, false);
    this.albumLikekey = paramJceInputStream.readString(3, false);
    this.albumVisitNum = paramJceInputStream.read(this.albumVisitNum, 4, false);
    this.isMyLiked = paramJceInputStream.read(this.isMyLiked, 5, false);
    this.largeCoverUrl = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.album, 0);
    paramJceOutputStream.write(this.albumFaceNum, 1);
    paramJceOutputStream.write(this.albumLikeNum, 2);
    if (this.albumLikekey != null) {
      paramJceOutputStream.write(this.albumLikekey, 3);
    }
    paramJceOutputStream.write(this.albumVisitNum, 4);
    paramJceOutputStream.write(this.isMyLiked, 5);
    if (this.largeCoverUrl != null) {
      paramJceOutputStream.write(this.largeCoverUrl, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_album_rsp
 * JD-Core Version:    0.7.0.1
 */