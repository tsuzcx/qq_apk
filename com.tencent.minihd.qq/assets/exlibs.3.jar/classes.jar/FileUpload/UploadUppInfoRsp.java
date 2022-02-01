package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UploadUppInfoRsp
  extends JceStruct
{
  public String sUrl = "";
  
  public UploadUppInfoRsp() {}
  
  public UploadUppInfoRsp(String paramString)
  {
    this.sUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sUrl = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sUrl, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     FileUpload.UploadUppInfoRsp
 * JD-Core Version:    0.7.0.1
 */