package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetGeoInfoRsp_V2
  extends JceStruct
{
  static GeoInfo_V2 cache_stGeoInfo;
  static GPS_V2 cache_stGps;
  public GeoInfo_V2 stGeoInfo = null;
  public GPS_V2 stGps = null;
  
  public GetGeoInfoRsp_V2() {}
  
  public GetGeoInfoRsp_V2(GPS_V2 paramGPS_V2, GeoInfo_V2 paramGeoInfo_V2)
  {
    this.stGps = paramGPS_V2;
    this.stGeoInfo = paramGeoInfo_V2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGps == null) {
      cache_stGps = new GPS_V2();
    }
    this.stGps = ((GPS_V2)paramJceInputStream.read(cache_stGps, 0, true));
    if (cache_stGeoInfo == null) {
      cache_stGeoInfo = new GeoInfo_V2();
    }
    this.stGeoInfo = ((GeoInfo_V2)paramJceInputStream.read(cache_stGeoInfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stGps, 0);
    paramJceOutputStream.write(this.stGeoInfo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     LBS_V2_PROTOCOL.GetGeoInfoRsp_V2
 * JD-Core Version:    0.7.0.1
 */