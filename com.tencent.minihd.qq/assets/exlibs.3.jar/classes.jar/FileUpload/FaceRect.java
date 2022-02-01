package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FaceRect
  extends JceStruct
{
  public int h = 0;
  public int w = 0;
  public int x = 0;
  public int y = 0;
  
  public FaceRect() {}
  
  public FaceRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.w = paramInt3;
    this.h = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.x = paramJceInputStream.read(this.x, 1, true);
    this.y = paramJceInputStream.read(this.y, 2, true);
    this.w = paramJceInputStream.read(this.w, 3, true);
    this.h = paramJceInputStream.read(this.h, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.x, 1);
    paramJceOutputStream.write(this.y, 2);
    paramJceOutputStream.write(this.w, 3);
    paramJceOutputStream.write(this.h, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     FileUpload.FaceRect
 * JD-Core Version:    0.7.0.1
 */