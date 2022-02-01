package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetLbsCombinReq_V2
  extends JceStruct
{
  static ReqCommon_V2 cache_stCommon;
  static GeoInfo_V2 cache_stGeoInfo;
  static GPS_V2 cache_stGps;
  static Date cache_stUserDate;
  static ArrayList cache_vCellData;
  static ArrayList cache_vWifiData;
  public int iAccuracy = 0;
  public int iAppID = 0;
  public int iLocateCostTime = 0;
  public int iMood = 0;
  public int iReqNum = 10;
  public long iUserTime = 0L;
  public ReqCommon_V2 stCommon = null;
  public GeoInfo_V2 stGeoInfo = null;
  public GPS_V2 stGps = null;
  public Date stUserDate = null;
  public String strClientIP = "";
  public ArrayList vCellData = null;
  public ArrayList vWifiData = null;
  
  public GetLbsCombinReq_V2() {}
  
  public GetLbsCombinReq_V2(ReqCommon_V2 paramReqCommon_V2, String paramString, GPS_V2 paramGPS_V2, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, GeoInfo_V2 paramGeoInfo_V2, long paramLong, int paramInt5, Date paramDate)
  {
    this.stCommon = paramReqCommon_V2;
    this.strClientIP = paramString;
    this.stGps = paramGPS_V2;
    this.vCellData = paramArrayList1;
    this.vWifiData = paramArrayList2;
    this.iReqNum = paramInt1;
    this.iAccuracy = paramInt2;
    this.iLocateCostTime = paramInt3;
    this.iMood = paramInt4;
    this.stGeoInfo = paramGeoInfo_V2;
    this.iUserTime = paramLong;
    this.iAppID = paramInt5;
    this.stUserDate = paramDate;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stCommon == null) {
      cache_stCommon = new ReqCommon_V2();
    }
    this.stCommon = ((ReqCommon_V2)paramJceInputStream.read(cache_stCommon, 0, true));
    this.strClientIP = paramJceInputStream.readString(1, true);
    if (cache_stGps == null) {
      cache_stGps = new GPS_V2();
    }
    this.stGps = ((GPS_V2)paramJceInputStream.read(cache_stGps, 2, true));
    Object localObject;
    if (cache_vCellData == null)
    {
      cache_vCellData = new ArrayList();
      localObject = new Cell_V2();
      cache_vCellData.add(localObject);
    }
    this.vCellData = ((ArrayList)paramJceInputStream.read(cache_vCellData, 3, true));
    if (cache_vWifiData == null)
    {
      cache_vWifiData = new ArrayList();
      localObject = new Wifi_V2();
      cache_vWifiData.add(localObject);
    }
    this.vWifiData = ((ArrayList)paramJceInputStream.read(cache_vWifiData, 4, true));
    this.iReqNum = paramJceInputStream.read(this.iReqNum, 5, true);
    this.iAccuracy = paramJceInputStream.read(this.iAccuracy, 6, false);
    this.iLocateCostTime = paramJceInputStream.read(this.iLocateCostTime, 7, false);
    this.iMood = paramJceInputStream.read(this.iMood, 8, false);
    if (cache_stGeoInfo == null) {
      cache_stGeoInfo = new GeoInfo_V2();
    }
    this.stGeoInfo = ((GeoInfo_V2)paramJceInputStream.read(cache_stGeoInfo, 9, false));
    this.iUserTime = paramJceInputStream.read(this.iUserTime, 10, false);
    this.iAppID = paramJceInputStream.read(this.iAppID, 11, false);
    if (cache_stUserDate == null) {
      cache_stUserDate = new Date();
    }
    this.stUserDate = ((Date)paramJceInputStream.read(cache_stUserDate, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stCommon, 0);
    paramJceOutputStream.write(this.strClientIP, 1);
    paramJceOutputStream.write(this.stGps, 2);
    paramJceOutputStream.write(this.vCellData, 3);
    paramJceOutputStream.write(this.vWifiData, 4);
    paramJceOutputStream.write(this.iReqNum, 5);
    paramJceOutputStream.write(this.iAccuracy, 6);
    paramJceOutputStream.write(this.iLocateCostTime, 7);
    paramJceOutputStream.write(this.iMood, 8);
    if (this.stGeoInfo != null) {
      paramJceOutputStream.write(this.stGeoInfo, 9);
    }
    paramJceOutputStream.write(this.iUserTime, 10);
    paramJceOutputStream.write(this.iAppID, 11);
    if (this.stUserDate != null) {
      paramJceOutputStream.write(this.stUserDate, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     LBS_V2_PROTOCOL.GetLbsCombinReq_V2
 * JD-Core Version:    0.7.0.1
 */