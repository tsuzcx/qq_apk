package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PhotoInfo
  extends JceStruct
{
  public String strPicUrl = "";
  public long uPhotoTimestamp = 0L;
  
  public PhotoInfo() {}
  
  public PhotoInfo(String paramString, long paramLong)
  {
    this.strPicUrl = paramString;
    this.uPhotoTimestamp = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPicUrl = paramJceInputStream.readString(0, true);
    this.uPhotoTimestamp = paramJceInputStream.read(this.uPhotoTimestamp, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPicUrl, 0);
    paramJceOutputStream.write(this.uPhotoTimestamp, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SummaryCard.PhotoInfo
 * JD-Core Version:    0.7.0.1
 */