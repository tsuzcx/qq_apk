package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ImageSummary
  extends JceStruct
{
  public String imageId = "";
  public String url = "";
  
  public ImageSummary() {}
  
  public ImageSummary(String paramString1, String paramString2)
  {
    this.imageId = paramString1;
    this.url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imageId = paramJceInputStream.readString(0, true);
    this.url = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imageId, 0);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.ImageSummary
 * JD-Core Version:    0.7.0.1
 */