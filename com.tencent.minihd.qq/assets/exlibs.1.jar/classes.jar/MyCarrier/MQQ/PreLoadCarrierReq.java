package MyCarrier.MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PreLoadCarrierReq
  extends JceStruct
{
  public String MQQVersion = "";
  public int bindType = 0;
  public String mobile = "";
  public int osType = 0;
  
  public PreLoadCarrierReq() {}
  
  public PreLoadCarrierReq(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.mobile = paramString1;
    this.bindType = paramInt1;
    this.osType = paramInt2;
    this.MQQVersion = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mobile = paramJceInputStream.readString(0, true);
    this.bindType = paramJceInputStream.read(this.bindType, 1, true);
    this.osType = paramJceInputStream.read(this.osType, 2, true);
    this.MQQVersion = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mobile, 0);
    paramJceOutputStream.write(this.bindType, 1);
    paramJceOutputStream.write(this.osType, 2);
    paramJceOutputStream.write(this.MQQVersion, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     MyCarrier.MQQ.PreLoadCarrierReq
 * JD-Core Version:    0.7.0.1
 */