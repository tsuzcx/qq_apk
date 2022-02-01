import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsDataV2.GeoInfo;
import cooperation.qzone.LbsDataV2.GpsInfo;

public final class mau
  implements Parcelable.Creator
{
  public LbsDataV2.GeoInfo a(Parcel paramParcel)
  {
    LbsDataV2.GeoInfo localGeoInfo = new LbsDataV2.GeoInfo();
    localGeoInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localGeoInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localGeoInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localGeoInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localGeoInfo.c = paramParcel.readString();
    localGeoInfo.d = paramParcel.readString();
    localGeoInfo.e = paramParcel.readString();
    localGeoInfo.f = paramParcel.readString();
    localGeoInfo.g = paramParcel.readString();
    localGeoInfo.h = paramParcel.readString();
    localGeoInfo.i = paramParcel.readString();
    localGeoInfo.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = ((LbsDataV2.GpsInfo)LbsDataV2.GpsInfo.CREATOR.createFromParcel(paramParcel));
    return localGeoInfo;
  }
  
  public LbsDataV2.GeoInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mau
 * JD-Core Version:    0.7.0.1
 */