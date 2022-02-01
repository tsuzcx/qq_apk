package NearbyPubAcct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Attr
  extends JceStruct
{
  public String strImei = "";
  public String strImsi = "";
  public String strPhonenum = "";
  
  public Attr() {}
  
  public Attr(String paramString1, String paramString2, String paramString3)
  {
    this.strImei = paramString1;
    this.strImsi = paramString2;
    this.strPhonenum = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strImei = paramJceInputStream.readString(0, false);
    this.strImsi = paramJceInputStream.readString(1, false);
    this.strPhonenum = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strImei != null) {
      paramJceOutputStream.write(this.strImei, 0);
    }
    if (this.strImsi != null) {
      paramJceOutputStream.write(this.strImsi, 1);
    }
    if (this.strPhonenum != null) {
      paramJceOutputStream.write(this.strPhonenum, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NearbyPubAcct.Attr
 * JD-Core Version:    0.7.0.1
 */