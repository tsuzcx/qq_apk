package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FaceInfo
  extends JceStruct
{
  static byte[] cache_vFaceID;
  public int uAddTimeStamp = 0;
  public byte[] vFaceID = null;
  
  public FaceInfo() {}
  
  public FaceInfo(byte[] paramArrayOfByte, int paramInt)
  {
    this.vFaceID = paramArrayOfByte;
    this.uAddTimeStamp = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vFaceID == null)
    {
      cache_vFaceID = (byte[])new byte[1];
      ((byte[])cache_vFaceID)[0] = 0;
    }
    this.vFaceID = ((byte[])paramJceInputStream.read(cache_vFaceID, 0, true));
    this.uAddTimeStamp = paramJceInputStream.read(this.uAddTimeStamp, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vFaceID, 0);
    paramJceOutputStream.write(this.uAddTimeStamp, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.FaceInfo
 * JD-Core Version:    0.7.0.1
 */