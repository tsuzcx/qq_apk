package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetLbsCombinRsp_V2
  extends JceStruct
{
  static GeoInfo_V2 cache_stGeoInfo;
  static GPS_V2 cache_stGps;
  static GetPoiInfoRsp_V2 cache_stPoiInfo;
  static WeatherInfo_V2 cache_stWeather;
  public int iMood = 0;
  public GeoInfo_V2 stGeoInfo = null;
  public GPS_V2 stGps = null;
  public GetPoiInfoRsp_V2 stPoiInfo = null;
  public WeatherInfo_V2 stWeather = null;
  
  public GetLbsCombinRsp_V2() {}
  
  public GetLbsCombinRsp_V2(GPS_V2 paramGPS_V2, GeoInfo_V2 paramGeoInfo_V2, GetPoiInfoRsp_V2 paramGetPoiInfoRsp_V2, WeatherInfo_V2 paramWeatherInfo_V2, int paramInt)
  {
    this.stGps = paramGPS_V2;
    this.stGeoInfo = paramGeoInfo_V2;
    this.stPoiInfo = paramGetPoiInfoRsp_V2;
    this.stWeather = paramWeatherInfo_V2;
    this.iMood = paramInt;
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
    if (cache_stPoiInfo == null) {
      cache_stPoiInfo = new GetPoiInfoRsp_V2();
    }
    this.stPoiInfo = ((GetPoiInfoRsp_V2)paramJceInputStream.read(cache_stPoiInfo, 2, true));
    if (cache_stWeather == null) {
      cache_stWeather = new WeatherInfo_V2();
    }
    this.stWeather = ((WeatherInfo_V2)paramJceInputStream.read(cache_stWeather, 3, true));
    this.iMood = paramJceInputStream.read(this.iMood, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stGps, 0);
    paramJceOutputStream.write(this.stGeoInfo, 1);
    paramJceOutputStream.write(this.stPoiInfo, 2);
    paramJceOutputStream.write(this.stWeather, 3);
    paramJceOutputStream.write(this.iMood, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     LBS_V2_PROTOCOL.GetLbsCombinRsp_V2
 * JD-Core Version:    0.7.0.1
 */