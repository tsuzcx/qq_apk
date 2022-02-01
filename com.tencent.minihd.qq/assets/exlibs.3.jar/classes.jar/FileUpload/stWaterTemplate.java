package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stWaterTemplate
  extends JceStruct
{
  public String sWaterContent = "";
  public String sWaterTemplateID = "";
  
  public stWaterTemplate() {}
  
  public stWaterTemplate(String paramString1, String paramString2)
  {
    this.sWaterTemplateID = paramString1;
    this.sWaterContent = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sWaterTemplateID = paramJceInputStream.readString(0, false);
    this.sWaterContent = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sWaterTemplateID != null) {
      paramJceOutputStream.write(this.sWaterTemplateID, 0);
    }
    if (this.sWaterContent != null) {
      paramJceOutputStream.write(this.sWaterContent, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     FileUpload.stWaterTemplate
 * JD-Core Version:    0.7.0.1
 */