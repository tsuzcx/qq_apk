package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UploadVideoInfoReq
  extends JceStruct
{
  static byte[] cache_vBusiNessData;
  public int iBusiNessType = 0;
  public int iFlag = 0;
  public int iIsNew = 0;
  public int iPlayTime = 0;
  public long iUploadTime = 0L;
  public String sCoverUrl = "";
  public String sDesc = "";
  public String sTitle = "";
  public byte[] vBusiNessData = null;
  
  public UploadVideoInfoReq() {}
  
  public UploadVideoInfoReq(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte, int paramInt3, String paramString3, int paramInt4)
  {
    this.sTitle = paramString1;
    this.sDesc = paramString2;
    this.iFlag = paramInt1;
    this.iUploadTime = paramLong;
    this.iBusiNessType = paramInt2;
    this.vBusiNessData = paramArrayOfByte;
    this.iPlayTime = paramInt3;
    this.sCoverUrl = paramString3;
    this.iIsNew = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sTitle = paramJceInputStream.readString(0, false);
    this.sDesc = paramJceInputStream.readString(1, false);
    this.iFlag = paramJceInputStream.read(this.iFlag, 2, false);
    this.iUploadTime = paramJceInputStream.read(this.iUploadTime, 3, false);
    this.iBusiNessType = paramJceInputStream.read(this.iBusiNessType, 4, false);
    if (cache_vBusiNessData == null)
    {
      cache_vBusiNessData = new byte[1];
      cache_vBusiNessData[0] = 0;
    }
    this.vBusiNessData = paramJceInputStream.read(cache_vBusiNessData, 5, false);
    this.iPlayTime = paramJceInputStream.read(this.iPlayTime, 6, false);
    this.sCoverUrl = paramJceInputStream.readString(7, false);
    this.iIsNew = paramJceInputStream.read(this.iIsNew, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sTitle != null) {
      paramJceOutputStream.write(this.sTitle, 0);
    }
    if (this.sDesc != null) {
      paramJceOutputStream.write(this.sDesc, 1);
    }
    paramJceOutputStream.write(this.iFlag, 2);
    paramJceOutputStream.write(this.iUploadTime, 3);
    paramJceOutputStream.write(this.iBusiNessType, 4);
    if (this.vBusiNessData != null) {
      paramJceOutputStream.write(this.vBusiNessData, 5);
    }
    paramJceOutputStream.write(this.iPlayTime, 6);
    if (this.sCoverUrl != null) {
      paramJceOutputStream.write(this.sCoverUrl, 7);
    }
    paramJceOutputStream.write(this.iIsNew, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     FileUpload.UploadVideoInfoReq
 * JD-Core Version:    0.7.0.1
 */