package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import max;

public class LbsDataV2$PoiInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator CREATOR = new max();
  public String address;
  public String city = "";
  public String country = "";
  public String dianPingId = "";
  public int distance;
  public String district = "";
  public int districtCode = 0;
  public LbsDataV2.GpsInfo gpsInfo = new LbsDataV2.GpsInfo();
  public int hotValue = 0;
  public String phoneNumber = "";
  public String poiDefaultName;
  public String poiId;
  public String poiName;
  public int poiNum;
  public int poiOrderType;
  public int poiType;
  public String poiTypeName;
  public String province = "";
  
  public static PoiInfo clone(PoiInfo paramPoiInfo)
  {
    LbsDataV2.GpsInfo localGpsInfo = null;
    if (paramPoiInfo == null) {
      return null;
    }
    PoiInfo localPoiInfo = new PoiInfo();
    localPoiInfo.address = paramPoiInfo.address;
    localPoiInfo.dianPingId = paramPoiInfo.dianPingId;
    localPoiInfo.distance = paramPoiInfo.distance;
    localPoiInfo.districtCode = paramPoiInfo.districtCode;
    if (paramPoiInfo.gpsInfo != null) {
      localGpsInfo = paramPoiInfo.gpsInfo.clone();
    }
    localPoiInfo.gpsInfo = localGpsInfo;
    localPoiInfo.hotValue = paramPoiInfo.hotValue;
    localPoiInfo.phoneNumber = paramPoiInfo.phoneNumber;
    localPoiInfo.poiDefaultName = paramPoiInfo.poiDefaultName;
    localPoiInfo.poiId = paramPoiInfo.poiId;
    localPoiInfo.poiName = paramPoiInfo.poiName;
    localPoiInfo.poiNum = paramPoiInfo.poiNum;
    localPoiInfo.poiOrderType = paramPoiInfo.poiOrderType;
    localPoiInfo.poiType = paramPoiInfo.poiType;
    localPoiInfo.poiTypeName = paramPoiInfo.poiTypeName;
    return localPoiInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    return ((PoiInfo)paramObject).poiId.equals(this.poiId);
  }
  
  public String toString()
  {
    if (this.gpsInfo != null) {
      return " poiId: " + this.poiId + " poiName: " + this.poiName + " poiType: " + this.poiType + " poiTypeName: " + this.poiTypeName + " address: " + this.address + " districtCode: " + this.districtCode + " distance: " + this.distance + " phoneNumber: " + this.phoneNumber + "poiOrderType: " + this.poiOrderType + "poiNum: " + this.poiNum + " gpsInfo: " + this.gpsInfo.toString() + " ";
    }
    return "poiId: " + this.poiId + "poiName: " + this.poiName + "poiType: " + this.poiType + "poiTypeName: " + this.poiTypeName + "address: " + this.address + "districtCode: " + this.districtCode + "distance: " + this.distance + "phoneNumber: " + this.phoneNumber + "poiOrderType: " + this.poiOrderType + "poiNum: " + this.poiNum + " dianPingId:" + this.dianPingId;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.poiId);
    paramParcel.writeString(this.poiName);
    paramParcel.writeInt(this.poiType);
    paramParcel.writeString(this.poiTypeName);
    paramParcel.writeString(this.poiDefaultName);
    paramParcel.writeString(this.address);
    paramParcel.writeInt(this.districtCode);
    paramParcel.writeInt(this.distance);
    paramParcel.writeInt(this.hotValue);
    paramParcel.writeString(this.phoneNumber);
    paramParcel.writeInt(this.poiOrderType);
    paramParcel.writeInt(this.poiNum);
    paramParcel.writeString(this.dianPingId);
    paramParcel.writeParcelable(this.gpsInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.PoiInfo
 * JD-Core Version:    0.7.0.1
 */