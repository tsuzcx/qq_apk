package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_comm_data
  extends JceStruct
{
  static byte[] cache_vecData;
  public int iHasDataFlag = 0;
  public String strAttachInfo = "";
  public byte[] vecData = null;
  
  public s_comm_data() {}
  
  public s_comm_data(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.iHasDataFlag = paramInt;
    this.strAttachInfo = paramString;
    this.vecData = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iHasDataFlag = paramJceInputStream.read(this.iHasDataFlag, 0, false);
    this.strAttachInfo = paramJceInputStream.readString(1, false);
    if (cache_vecData == null)
    {
      cache_vecData = (byte[])new byte[1];
      ((byte[])cache_vecData)[0] = 0;
    }
    this.vecData = ((byte[])paramJceInputStream.read(cache_vecData, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iHasDataFlag, 0);
    if (this.strAttachInfo != null) {
      paramJceOutputStream.write(this.strAttachInfo, 1);
    }
    if (this.vecData != null) {
      paramJceOutputStream.write(this.vecData, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.s_comm_data
 * JD-Core Version:    0.7.0.1
 */