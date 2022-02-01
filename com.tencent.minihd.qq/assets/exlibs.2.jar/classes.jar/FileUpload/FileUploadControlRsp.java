package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileUploadControlRsp
  extends JceStruct
{
  static byte[] cache_vDescdata;
  public long iOffset = 0L;
  public int iRetCode = 0;
  public long iServerTime = 0L;
  public String sAlbumID = "";
  public String sAlbumName = "";
  public byte[] vDescdata = null;
  
  public FileUploadControlRsp() {}
  
  public FileUploadControlRsp(long paramLong1, int paramInt, byte[] paramArrayOfByte, long paramLong2, String paramString1, String paramString2)
  {
    this.iOffset = paramLong1;
    this.iRetCode = paramInt;
    this.vDescdata = paramArrayOfByte;
    this.iServerTime = paramLong2;
    this.sAlbumID = paramString1;
    this.sAlbumName = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iOffset = paramJceInputStream.read(this.iOffset, 0, false);
    this.iRetCode = paramJceInputStream.read(this.iRetCode, 1, false);
    if (cache_vDescdata == null)
    {
      cache_vDescdata = new byte[1];
      cache_vDescdata[0] = 0;
    }
    this.vDescdata = paramJceInputStream.read(cache_vDescdata, 2, false);
    this.iServerTime = paramJceInputStream.read(this.iServerTime, 3, false);
    this.sAlbumID = paramJceInputStream.readString(4, false);
    this.sAlbumName = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iOffset, 0);
    paramJceOutputStream.write(this.iRetCode, 1);
    if (this.vDescdata != null) {
      paramJceOutputStream.write(this.vDescdata, 2);
    }
    paramJceOutputStream.write(this.iServerTime, 3);
    if (this.sAlbumID != null) {
      paramJceOutputStream.write(this.sAlbumID, 4);
    }
    if (this.sAlbumName != null) {
      paramJceOutputStream.write(this.sAlbumName, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     FileUpload.FileUploadControlRsp
 * JD-Core Version:    0.7.0.1
 */