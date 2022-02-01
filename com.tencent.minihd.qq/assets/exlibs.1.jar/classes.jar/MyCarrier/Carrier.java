package MyCarrier;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Carrier
  extends JceStruct
{
  public String carrierCity = "";
  public String carrierExtraInfo = "";
  public String carrierId = "";
  public String carrierLogo = "";
  public String carrierName = "";
  public String carrierProvince = "";
  public String carrierURL = "";
  public String redhotfilter = "";
  
  public Carrier() {}
  
  public Carrier(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.carrierName = paramString1;
    this.carrierId = paramString2;
    this.carrierProvince = paramString3;
    this.carrierCity = paramString4;
    this.carrierLogo = paramString5;
    this.carrierURL = paramString6;
    this.carrierExtraInfo = paramString7;
    this.redhotfilter = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.carrierName = paramJceInputStream.readString(0, true);
    this.carrierId = paramJceInputStream.readString(1, true);
    this.carrierProvince = paramJceInputStream.readString(2, true);
    this.carrierCity = paramJceInputStream.readString(3, true);
    this.carrierLogo = paramJceInputStream.readString(4, true);
    this.carrierURL = paramJceInputStream.readString(5, true);
    this.carrierExtraInfo = paramJceInputStream.readString(6, true);
    this.redhotfilter = paramJceInputStream.readString(7, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.carrierName, 0);
    paramJceOutputStream.write(this.carrierId, 1);
    paramJceOutputStream.write(this.carrierProvince, 2);
    paramJceOutputStream.write(this.carrierCity, 3);
    paramJceOutputStream.write(this.carrierLogo, 4);
    paramJceOutputStream.write(this.carrierURL, 5);
    paramJceOutputStream.write(this.carrierExtraInfo, 6);
    paramJceOutputStream.write(this.redhotfilter, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     MyCarrier.Carrier
 * JD-Core Version:    0.7.0.1
 */