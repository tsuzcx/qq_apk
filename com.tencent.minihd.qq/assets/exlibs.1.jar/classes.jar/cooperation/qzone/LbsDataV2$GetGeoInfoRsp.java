package cooperation.qzone;

import LBS_V2_PROTOCOL.GetGeoInfoRsp_V2;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import mav;

public final class LbsDataV2$GetGeoInfoRsp
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new mav();
  public LbsDataV2.GeoInfo a;
  public LbsDataV2.GpsInfo a;
  
  public LbsDataV2$GetGeoInfoRsp()
  {
    this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = null;
    this.jdField_a_of_type_CooperationQzoneLbsDataV2$GeoInfo = null;
  }
  
  public LbsDataV2$GetGeoInfoRsp(LbsDataV2.GpsInfo paramGpsInfo, LbsDataV2.GeoInfo paramGeoInfo)
  {
    this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = null;
    this.jdField_a_of_type_CooperationQzoneLbsDataV2$GeoInfo = null;
    this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = paramGpsInfo;
    this.jdField_a_of_type_CooperationQzoneLbsDataV2$GeoInfo = paramGeoInfo;
  }
  
  public static GetGeoInfoRsp_V2 a(GetGeoInfoRsp paramGetGeoInfoRsp)
  {
    GetGeoInfoRsp_V2 localGetGeoInfoRsp_V2 = new GetGeoInfoRsp_V2();
    if (paramGetGeoInfoRsp != null)
    {
      localGetGeoInfoRsp_V2.stGeoInfo = LbsDataV2.a(paramGetGeoInfoRsp.jdField_a_of_type_CooperationQzoneLbsDataV2$GeoInfo);
      localGetGeoInfoRsp_V2.stGps = LbsDataV2.a(paramGetGeoInfoRsp.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo);
    }
    return localGetGeoInfoRsp_V2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo, paramInt);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneLbsDataV2$GeoInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.GetGeoInfoRsp
 * JD-Core Version:    0.7.0.1
 */