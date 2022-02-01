package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UploadVideoInfoRsp
  extends JceStruct
{
  static byte[] cache_vBusiNessData;
  public int iBusiNessType = 0;
  public String sVid = "";
  public byte[] vBusiNessData = null;
  
  public UploadVideoInfoRsp() {}
  
  public UploadVideoInfoRsp(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    this.sVid = paramString;
    this.iBusiNessType = paramInt;
    this.vBusiNessData = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sVid = paramJceInputStream.readString(0, false);
    this.iBusiNessType = paramJceInputStream.read(this.iBusiNessType, 1, false);
    if (cache_vBusiNessData == null)
    {
      cache_vBusiNessData = new byte[1];
      cache_vBusiNessData[0] = 0;
    }
    this.vBusiNessData = paramJceInputStream.read(cache_vBusiNessData, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sVid != null) {
      paramJceOutputStream.write(this.sVid, 0);
    }
    paramJceOutputStream.write(this.iBusiNessType, 1);
    if (this.vBusiNessData != null) {
      paramJceOutputStream.write(this.vBusiNessData, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     FileUpload.UploadVideoInfoRsp
 * JD-Core Version:    0.7.0.1
 */