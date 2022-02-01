package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileUploadProgressRsp
  extends JceStruct
{
  public long iRecvDataLen = 0L;
  public long iTotalLen = 0L;
  
  public FileUploadProgressRsp() {}
  
  public FileUploadProgressRsp(long paramLong1, long paramLong2)
  {
    this.iTotalLen = paramLong1;
    this.iRecvDataLen = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTotalLen = paramJceInputStream.read(this.iTotalLen, 0, false);
    this.iRecvDataLen = paramJceInputStream.read(this.iRecvDataLen, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTotalLen, 0);
    paramJceOutputStream.write(this.iRecvDataLen, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     FileUpload.FileUploadProgressRsp
 * JD-Core Version:    0.7.0.1
 */