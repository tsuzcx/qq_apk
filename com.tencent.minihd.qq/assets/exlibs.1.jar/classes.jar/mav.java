import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsDataV2.GeoInfo;
import cooperation.qzone.LbsDataV2.GetGeoInfoRsp;
import cooperation.qzone.LbsDataV2.GpsInfo;

public final class mav
  implements Parcelable.Creator
{
  public LbsDataV2.GetGeoInfoRsp a(Parcel paramParcel)
  {
    LbsDataV2.GetGeoInfoRsp localGetGeoInfoRsp = new LbsDataV2.GetGeoInfoRsp();
    localGetGeoInfoRsp.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = ((LbsDataV2.GpsInfo)LbsDataV2.GpsInfo.CREATOR.createFromParcel(paramParcel));
    localGetGeoInfoRsp.jdField_a_of_type_CooperationQzoneLbsDataV2$GeoInfo = ((LbsDataV2.GeoInfo)LbsDataV2.GeoInfo.CREATOR.createFromParcel(paramParcel));
    return localGetGeoInfoRsp;
  }
  
  public LbsDataV2.GetGeoInfoRsp[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mav
 * JD-Core Version:    0.7.0.1
 */