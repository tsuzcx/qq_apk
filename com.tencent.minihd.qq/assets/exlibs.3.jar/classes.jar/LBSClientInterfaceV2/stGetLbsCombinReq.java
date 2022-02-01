package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetLbsCombinReq
  extends JceStruct
{
  static stGPS cache_stGps;
  public int iAccuracy = 0;
  public int iForecastDay = 0;
  public int iLocateCostTime = 0;
  public int iReqNum = 30;
  public stGPS stGps = null;
  public String strClientIP = "";
  
  public stGetLbsCombinReq() {}
  
  public stGetLbsCombinReq(stGPS paramstGPS, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.stGps = paramstGPS;
    this.strClientIP = paramString;
    this.iReqNum = paramInt1;
    this.iAccuracy = paramInt2;
    this.iLocateCostTime = paramInt3;
    this.iForecastDay = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGps == null) {
      cache_stGps = new stGPS();
    }
    this.stGps = ((stGPS)paramJceInputStream.read(cache_stGps, 0, true));
    this.strClientIP = paramJceInputStream.readString(1, true);
    this.iReqNum = paramJceInputStream.read(this.iReqNum, 2, true);
    this.iAccuracy = paramJceInputStream.read(this.iAccuracy, 3, false);
    this.iLocateCostTime = paramJceInputStream.read(this.iLocateCostTime, 4, false);
    this.iForecastDay = paramJceInputStream.read(this.iForecastDay, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stGps, 0);
    paramJceOutputStream.write(this.strClientIP, 1);
    paramJceOutputStream.write(this.iReqNum, 2);
    paramJceOutputStream.write(this.iAccuracy, 3);
    paramJceOutputStream.write(this.iLocateCostTime, 4);
    paramJceOutputStream.write(this.iForecastDay, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     LBSClientInterfaceV2.stGetLbsCombinReq
 * JD-Core Version:    0.7.0.1
 */