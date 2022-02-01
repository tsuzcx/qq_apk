package NearbyPubAcct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PubAcctInfo
  extends JceStruct
{
  public int cert_level = 0;
  public int iDistance = 0;
  public long lUin = 0L;
  public String strIntro = "";
  public String strLocation = "";
  public String strName = "";
  
  public PubAcctInfo() {}
  
  public PubAcctInfo(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.lUin = paramLong;
    this.strName = paramString1;
    this.strLocation = paramString2;
    this.strIntro = paramString3;
    this.cert_level = paramInt1;
    this.iDistance = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.strName = paramJceInputStream.readString(1, true);
    this.strLocation = paramJceInputStream.readString(2, true);
    this.strIntro = paramJceInputStream.readString(3, true);
    this.cert_level = paramJceInputStream.read(this.cert_level, 4, true);
    this.iDistance = paramJceInputStream.read(this.iDistance, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.strName, 1);
    paramJceOutputStream.write(this.strLocation, 2);
    paramJceOutputStream.write(this.strIntro, 3);
    paramJceOutputStream.write(this.cert_level, 4);
    paramJceOutputStream.write(this.iDistance, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NearbyPubAcct.PubAcctInfo
 * JD-Core Version:    0.7.0.1
 */