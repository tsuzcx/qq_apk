package cooperation.qzone;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GPS_V2;
import LBS_V2_PROTOCOL.GeoInfo_V2;
import LBS_V2_PROTOCOL.PoiInfo_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import NS_MOBILE_OPERATION.LbsInfo;
import android.text.TextUtils;

public class LbsDataV2
{
  public static int a;
  public static int b;
  public static int c = 12103;
  
  static
  {
    jdField_a_of_type_Int = 900000000;
    jdField_b_of_type_Int = 500;
  }
  
  public static Cell_V2 a(LbsDataV2.CellInfo paramCellInfo)
  {
    if (paramCellInfo == null) {
      return null;
    }
    Cell_V2 localCell_V2 = new Cell_V2();
    localCell_V2.shMcc = ((short)paramCellInfo.jdField_a_of_type_Int);
    localCell_V2.shMnc = ((short)paramCellInfo.jdField_b_of_type_Int);
    localCell_V2.iLac = paramCellInfo.c;
    localCell_V2.iCellId = paramCellInfo.d;
    localCell_V2.iRssi = paramCellInfo.e;
    localCell_V2.dStationLat = paramCellInfo.jdField_a_of_type_Double;
    localCell_V2.dStationLon = paramCellInfo.jdField_b_of_type_Double;
    return localCell_V2;
  }
  
  public static GPS_V2 a(LbsDataV2.GpsInfo paramGpsInfo)
  {
    GPS_V2 localGPS_V2 = new GPS_V2();
    if (paramGpsInfo != null)
    {
      localGPS_V2.eType = paramGpsInfo.gpsType;
      localGPS_V2.iAlt = paramGpsInfo.alt;
      localGPS_V2.iLat = paramGpsInfo.lat;
      localGPS_V2.iLon = paramGpsInfo.lon;
    }
    return localGPS_V2;
  }
  
  public static GeoInfo_V2 a(LbsDataV2.GeoInfo paramGeoInfo)
  {
    GeoInfo_V2 localGeoInfo_V2 = new GeoInfo_V2();
    if (paramGeoInfo != null)
    {
      localGeoInfo_V2.iDistrictCode = paramGeoInfo.jdField_a_of_type_Int;
      localGeoInfo_V2.iRange = paramGeoInfo.jdField_b_of_type_Int;
      localGeoInfo_V2.strCountry = paramGeoInfo.jdField_b_of_type_JavaLangString;
      localGeoInfo_V2.strProvince = paramGeoInfo.c;
      localGeoInfo_V2.strCity = paramGeoInfo.d;
      localGeoInfo_V2.strDistrict = paramGeoInfo.e;
      localGeoInfo_V2.strTown = paramGeoInfo.f;
      localGeoInfo_V2.strVillage = paramGeoInfo.g;
      localGeoInfo_V2.strRoad = paramGeoInfo.h;
      localGeoInfo_V2.strDefaultName = paramGeoInfo.i;
    }
    return localGeoInfo_V2;
  }
  
  public static Wifi_V2 a(LbsDataV2.WifiInfo paramWifiInfo)
  {
    if (paramWifiInfo == null) {
      return null;
    }
    Wifi_V2 localWifi_V2 = new Wifi_V2();
    localWifi_V2.strMac = paramWifiInfo.jdField_a_of_type_JavaLangString;
    localWifi_V2.iRssi = paramWifiInfo.jdField_a_of_type_Int;
    return localWifi_V2;
  }
  
  public static LbsInfo a(LbsDataV2.PoiInfo paramPoiInfo)
  {
    if (paramPoiInfo == null) {
      return null;
    }
    LbsInfo localLbsInfo = new LbsInfo();
    if (paramPoiInfo.gpsInfo != null)
    {
      localLbsInfo.lbs_x = String.valueOf(paramPoiInfo.gpsInfo.lat / 1000000.0D);
      localLbsInfo.lbs_y = String.valueOf(paramPoiInfo.gpsInfo.lon / 1000000.0D);
    }
    localLbsInfo.lbs_idnm = paramPoiInfo.poiDefaultName;
    if (TextUtils.isEmpty(localLbsInfo.lbs_idnm)) {
      localLbsInfo.lbs_idnm = paramPoiInfo.poiName;
    }
    localLbsInfo.lbs_nm = paramPoiInfo.address;
    localLbsInfo.s_lbs_id = paramPoiInfo.poiId;
    localLbsInfo.i_poi_num = paramPoiInfo.poiNum;
    localLbsInfo.i_poi_order_type = paramPoiInfo.poiOrderType;
    localLbsInfo.i_poi_type = paramPoiInfo.poiType;
    try
    {
      localLbsInfo.lbs_id = Integer.parseInt(paramPoiInfo.poiId);
      return localLbsInfo;
    }
    catch (Exception paramPoiInfo)
    {
      paramPoiInfo.printStackTrace();
    }
    return localLbsInfo;
  }
  
  public static LbsDataV2.CellInfo a(Cell_V2 paramCell_V2)
  {
    if (paramCell_V2 == null) {
      return null;
    }
    LbsDataV2.CellInfo localCellInfo = new LbsDataV2.CellInfo();
    localCellInfo.jdField_a_of_type_Int = paramCell_V2.shMcc;
    localCellInfo.jdField_b_of_type_Int = paramCell_V2.shMnc;
    localCellInfo.c = paramCell_V2.iLac;
    localCellInfo.d = paramCell_V2.iCellId;
    localCellInfo.e = paramCell_V2.iRssi;
    localCellInfo.jdField_a_of_type_Double = paramCell_V2.dStationLat;
    localCellInfo.jdField_b_of_type_Double = paramCell_V2.dStationLon;
    return localCellInfo;
  }
  
  public static LbsDataV2.GeoInfo a(GeoInfo_V2 paramGeoInfo_V2)
  {
    LbsDataV2.GeoInfo localGeoInfo = new LbsDataV2.GeoInfo();
    if (paramGeoInfo_V2 != null)
    {
      localGeoInfo.jdField_a_of_type_Int = paramGeoInfo_V2.iDistrictCode;
      localGeoInfo.jdField_b_of_type_Int = paramGeoInfo_V2.iRange;
      localGeoInfo.jdField_b_of_type_JavaLangString = paramGeoInfo_V2.strCountry;
      localGeoInfo.c = paramGeoInfo_V2.strProvince;
      localGeoInfo.d = paramGeoInfo_V2.strCity;
      localGeoInfo.e = paramGeoInfo_V2.strDistrict;
      localGeoInfo.f = paramGeoInfo_V2.strTown;
      localGeoInfo.g = paramGeoInfo_V2.strVillage;
      localGeoInfo.h = paramGeoInfo_V2.strRoad;
      localGeoInfo.i = paramGeoInfo_V2.strDefaultName;
    }
    return localGeoInfo;
  }
  
  public static LbsDataV2.GpsInfo a(GPS_V2 paramGPS_V2)
  {
    LbsDataV2.GpsInfo localGpsInfo = new LbsDataV2.GpsInfo();
    if (paramGPS_V2 != null)
    {
      localGpsInfo.gpsType = paramGPS_V2.eType;
      localGpsInfo.alt = paramGPS_V2.iAlt;
      localGpsInfo.lat = paramGPS_V2.iLat;
      localGpsInfo.lon = paramGPS_V2.iLon;
    }
    return localGpsInfo;
  }
  
  public static LbsDataV2.PoiInfo a(PoiInfo_V2 paramPoiInfo_V2)
  {
    LbsDataV2.PoiInfo localPoiInfo = new LbsDataV2.PoiInfo();
    if (paramPoiInfo_V2 != null)
    {
      localPoiInfo.address = paramPoiInfo_V2.strAddress;
      localPoiInfo.gpsInfo = a(paramPoiInfo_V2.stGps);
      localPoiInfo.city = paramPoiInfo_V2.strCity;
      localPoiInfo.country = paramPoiInfo_V2.strCity;
      localPoiInfo.districtCode = paramPoiInfo_V2.iDistrictCode;
      localPoiInfo.district = paramPoiInfo_V2.strDistrict;
      localPoiInfo.province = paramPoiInfo_V2.strProvince;
      localPoiInfo.distance = paramPoiInfo_V2.iDistance;
      localPoiInfo.poiId = paramPoiInfo_V2.strPoiId;
      localPoiInfo.poiName = paramPoiInfo_V2.strName;
      localPoiInfo.poiOrderType = paramPoiInfo_V2.iPoiOrderType;
      localPoiInfo.poiNum = paramPoiInfo_V2.iPoiNum;
      localPoiInfo.hotValue = paramPoiInfo_V2.iHotValue;
      localPoiInfo.phoneNumber = paramPoiInfo_V2.strPhone;
      localPoiInfo.poiDefaultName = paramPoiInfo_V2.strDefaultName;
      localPoiInfo.dianPingId = paramPoiInfo_V2.strDianPingId;
    }
    return localPoiInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2
 * JD-Core Version:    0.7.0.1
 */