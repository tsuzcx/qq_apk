package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MultiPicInfo
  extends JceStruct
{
  public int iBatUploadNum = 0;
  public int iCurUpload = 0;
  public int iFailNum = 0;
  public int iSuccNum = 0;
  
  public MultiPicInfo() {}
  
  public MultiPicInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iBatUploadNum = paramInt1;
    this.iCurUpload = paramInt2;
    this.iSuccNum = paramInt3;
    this.iFailNum = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iBatUploadNum = paramJceInputStream.read(this.iBatUploadNum, 0, false);
    this.iCurUpload = paramJceInputStream.read(this.iCurUpload, 1, false);
    this.iSuccNum = paramJceInputStream.read(this.iSuccNum, 2, false);
    this.iFailNum = paramJceInputStream.read(this.iFailNum, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iBatUploadNum, 0);
    paramJceOutputStream.write(this.iCurUpload, 1);
    paramJceOutputStream.write(this.iSuccNum, 2);
    paramJceOutputStream.write(this.iFailNum, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     FileUpload.MultiPicInfo
 * JD-Core Version:    0.7.0.1
 */