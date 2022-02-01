package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetWeatherReq
  extends JceStruct
{
  static stGPS cache_stGps;
  public int iForecastDay = 0;
  public stGPS stGps = null;
  public String strClientIP = "";
  public String strDate = "";
  
  public stGetWeatherReq() {}
  
  public stGetWeatherReq(stGPS paramstGPS, String paramString1, String paramString2, int paramInt)
  {
    this.stGps = paramstGPS;
    this.strClientIP = paramString1;
    this.strDate = paramString2;
    this.iForecastDay = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGps == null) {
      cache_stGps = new stGPS();
    }
    this.stGps = ((stGPS)paramJceInputStream.read(cache_stGps, 0, true));
    this.strClientIP = paramJceInputStream.readString(1, true);
    this.strDate = paramJceInputStream.readString(2, true);
    this.iForecastDay = paramJceInputStream.read(this.iForecastDay, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stGps, 0);
    paramJceOutputStream.write(this.strClientIP, 1);
    paramJceOutputStream.write(this.strDate, 2);
    paramJceOutputStream.write(this.iForecastDay, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     LBSClientInterfaceV2.stGetWeatherReq
 * JD-Core Version:    0.7.0.1
 */