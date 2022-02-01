package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PicUploadControlInfo
  extends JceStruct
{
  static UploadPicInfoReq cache_picinfoReq;
  public int iAlbumTypeID = 0;
  public int iNeedCheckAlbum = 0;
  public UploadPicInfoReq picinfoReq = null;
  public String sAlbumID = "";
  
  public PicUploadControlInfo() {}
  
  public PicUploadControlInfo(String paramString, int paramInt1, UploadPicInfoReq paramUploadPicInfoReq, int paramInt2)
  {
    this.sAlbumID = paramString;
    this.iAlbumTypeID = paramInt1;
    this.picinfoReq = paramUploadPicInfoReq;
    this.iNeedCheckAlbum = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sAlbumID = paramJceInputStream.readString(0, false);
    this.iAlbumTypeID = paramJceInputStream.read(this.iAlbumTypeID, 1, false);
    if (cache_picinfoReq == null) {
      cache_picinfoReq = new UploadPicInfoReq();
    }
    this.picinfoReq = ((UploadPicInfoReq)paramJceInputStream.read(cache_picinfoReq, 2, false));
    this.iNeedCheckAlbum = paramJceInputStream.read(this.iNeedCheckAlbum, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sAlbumID != null) {
      paramJceOutputStream.write(this.sAlbumID, 0);
    }
    paramJceOutputStream.write(this.iAlbumTypeID, 1);
    if (this.picinfoReq != null) {
      paramJceOutputStream.write(this.picinfoReq, 2);
    }
    paramJceOutputStream.write(this.iNeedCheckAlbum, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     FileUpload.PicUploadControlInfo
 * JD-Core Version:    0.7.0.1
 */