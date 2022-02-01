package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileUploadControlReq
  extends JceStruct
{
  static byte[] cache_sData;
  public byte[] sData = null;
  
  public FileUploadControlReq() {}
  
  public FileUploadControlReq(byte[] paramArrayOfByte)
  {
    this.sData = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_sData == null)
    {
      cache_sData = new byte[1];
      cache_sData[0] = 0;
    }
    this.sData = paramJceInputStream.read(cache_sData, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sData != null) {
      paramJceOutputStream.write(this.sData, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     FileUpload.FileUploadControlReq
 * JD-Core Version:    0.7.0.1
 */