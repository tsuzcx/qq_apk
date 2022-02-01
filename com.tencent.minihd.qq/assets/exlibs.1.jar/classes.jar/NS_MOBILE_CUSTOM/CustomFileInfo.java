package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CustomFileInfo
  extends JceStruct
{
  static int cache_iFileType;
  public int iFileSize = 0;
  public int iFileType = 0;
  public int iImageHeight = 0;
  public int iImageWidth = 0;
  public String strFileMd5 = "";
  public String strFileUrl = "";
  
  public CustomFileInfo() {}
  
  public CustomFileInfo(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iFileType = paramInt1;
    this.strFileUrl = paramString1;
    this.strFileMd5 = paramString2;
    this.iFileSize = paramInt2;
    this.iImageWidth = paramInt3;
    this.iImageHeight = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iFileType = paramJceInputStream.read(this.iFileType, 0, false);
    this.strFileUrl = paramJceInputStream.readString(1, false);
    this.strFileMd5 = paramJceInputStream.readString(2, false);
    this.iFileSize = paramJceInputStream.read(this.iFileSize, 3, false);
    this.iImageWidth = paramJceInputStream.read(this.iImageWidth, 4, false);
    this.iImageHeight = paramJceInputStream.read(this.iImageHeight, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iFileType, 0);
    if (this.strFileUrl != null) {
      paramJceOutputStream.write(this.strFileUrl, 1);
    }
    if (this.strFileMd5 != null) {
      paramJceOutputStream.write(this.strFileMd5, 2);
    }
    paramJceOutputStream.write(this.iFileSize, 3);
    paramJceOutputStream.write(this.iImageWidth, 4);
    paramJceOutputStream.write(this.iImageHeight, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.CustomFileInfo
 * JD-Core Version:    0.7.0.1
 */