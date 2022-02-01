package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UploadPicInfoRsp
  extends JceStruct
{
  static byte[] cache_vBusiNessDataRsp;
  static stWaterTemplate cache_waterTemplate;
  public int iBusiNessType = 0;
  public int iHeight = 0;
  public int iOriHeight = 0;
  public int iOriWidth = 0;
  public int iPicType = 0;
  public int iWidth = 0;
  public String sAdaptUrl_1000 = "";
  public String sAdaptUrl_160 = "";
  public String sAdaptUrl_200 = "";
  public String sAdaptUrl_400 = "";
  public String sAdaptUrl_640 = "";
  public String sAlbumID = "";
  public String sBURL = "";
  public String sOriPhotoID = "";
  public String sOriUrl = "";
  public String sPhotoID = "";
  public String sSURL = "";
  public String sSloc = "";
  public byte[] vBusiNessDataRsp = null;
  public stWaterTemplate waterTemplate = null;
  
  public UploadPicInfoRsp() {}
  
  public UploadPicInfoRsp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, int paramInt3, int paramInt4, String paramString7, int paramInt5, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, stWaterTemplate paramstWaterTemplate, int paramInt6, byte[] paramArrayOfByte)
  {
    this.sSURL = paramString1;
    this.sBURL = paramString2;
    this.sAlbumID = paramString3;
    this.sPhotoID = paramString4;
    this.sSloc = paramString5;
    this.iWidth = paramInt1;
    this.iHeight = paramInt2;
    this.sOriUrl = paramString6;
    this.iOriWidth = paramInt3;
    this.iOriHeight = paramInt4;
    this.sOriPhotoID = paramString7;
    this.iPicType = paramInt5;
    this.sAdaptUrl_160 = paramString8;
    this.sAdaptUrl_200 = paramString9;
    this.sAdaptUrl_400 = paramString10;
    this.sAdaptUrl_640 = paramString11;
    this.sAdaptUrl_1000 = paramString12;
    this.waterTemplate = paramstWaterTemplate;
    this.iBusiNessType = paramInt6;
    this.vBusiNessDataRsp = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sSURL = paramJceInputStream.readString(0, false);
    this.sBURL = paramJceInputStream.readString(1, false);
    this.sAlbumID = paramJceInputStream.readString(2, false);
    this.sPhotoID = paramJceInputStream.readString(3, false);
    this.sSloc = paramJceInputStream.readString(4, false);
    this.iWidth = paramJceInputStream.read(this.iWidth, 5, false);
    this.iHeight = paramJceInputStream.read(this.iHeight, 6, false);
    this.sOriUrl = paramJceInputStream.readString(7, false);
    this.iOriWidth = paramJceInputStream.read(this.iOriWidth, 8, false);
    this.iOriHeight = paramJceInputStream.read(this.iOriHeight, 9, false);
    this.sOriPhotoID = paramJceInputStream.readString(10, false);
    this.iPicType = paramJceInputStream.read(this.iPicType, 11, false);
    this.sAdaptUrl_160 = paramJceInputStream.readString(12, false);
    this.sAdaptUrl_200 = paramJceInputStream.readString(13, false);
    this.sAdaptUrl_400 = paramJceInputStream.readString(14, false);
    this.sAdaptUrl_640 = paramJceInputStream.readString(15, false);
    this.sAdaptUrl_1000 = paramJceInputStream.readString(16, false);
    if (cache_waterTemplate == null) {
      cache_waterTemplate = new stWaterTemplate();
    }
    this.waterTemplate = ((stWaterTemplate)paramJceInputStream.read(cache_waterTemplate, 17, false));
    this.iBusiNessType = paramJceInputStream.read(this.iBusiNessType, 18, false);
    if (cache_vBusiNessDataRsp == null)
    {
      cache_vBusiNessDataRsp = new byte[1];
      cache_vBusiNessDataRsp[0] = 0;
    }
    this.vBusiNessDataRsp = paramJceInputStream.read(cache_vBusiNessDataRsp, 19, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sSURL != null) {
      paramJceOutputStream.write(this.sSURL, 0);
    }
    if (this.sBURL != null) {
      paramJceOutputStream.write(this.sBURL, 1);
    }
    if (this.sAlbumID != null) {
      paramJceOutputStream.write(this.sAlbumID, 2);
    }
    if (this.sPhotoID != null) {
      paramJceOutputStream.write(this.sPhotoID, 3);
    }
    if (this.sSloc != null) {
      paramJceOutputStream.write(this.sSloc, 4);
    }
    paramJceOutputStream.write(this.iWidth, 5);
    paramJceOutputStream.write(this.iHeight, 6);
    if (this.sOriUrl != null) {
      paramJceOutputStream.write(this.sOriUrl, 7);
    }
    paramJceOutputStream.write(this.iOriWidth, 8);
    paramJceOutputStream.write(this.iOriHeight, 9);
    if (this.sOriPhotoID != null) {
      paramJceOutputStream.write(this.sOriPhotoID, 10);
    }
    paramJceOutputStream.write(this.iPicType, 11);
    if (this.sAdaptUrl_160 != null) {
      paramJceOutputStream.write(this.sAdaptUrl_160, 12);
    }
    if (this.sAdaptUrl_200 != null) {
      paramJceOutputStream.write(this.sAdaptUrl_200, 13);
    }
    if (this.sAdaptUrl_400 != null) {
      paramJceOutputStream.write(this.sAdaptUrl_400, 14);
    }
    if (this.sAdaptUrl_640 != null) {
      paramJceOutputStream.write(this.sAdaptUrl_640, 15);
    }
    if (this.sAdaptUrl_1000 != null) {
      paramJceOutputStream.write(this.sAdaptUrl_1000, 16);
    }
    if (this.waterTemplate != null) {
      paramJceOutputStream.write(this.waterTemplate, 17);
    }
    paramJceOutputStream.write(this.iBusiNessType, 18);
    if (this.vBusiNessDataRsp != null) {
      paramJceOutputStream.write(this.vBusiNessDataRsp, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     FileUpload.UploadPicInfoRsp
 * JD-Core Version:    0.7.0.1
 */