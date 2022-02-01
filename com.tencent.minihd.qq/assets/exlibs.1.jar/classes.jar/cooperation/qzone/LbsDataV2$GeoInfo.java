package cooperation.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import mau;

public class LbsDataV2$GeoInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new mau();
  public int a;
  public LbsDataV2.GpsInfo a;
  public String a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  
  public LbsDataV2$GeoInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public LbsDataV2$GeoInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramString7;
    this.i = paramString8;
  }
  
  public GeoInfo a()
  {
    GeoInfo localGeoInfo = new GeoInfo();
    localGeoInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localGeoInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localGeoInfo.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localGeoInfo.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localGeoInfo.c = this.c;
    localGeoInfo.d = this.d;
    localGeoInfo.e = this.e;
    localGeoInfo.f = this.f;
    localGeoInfo.g = this.g;
    localGeoInfo.h = this.h;
    localGeoInfo.i = this.i;
    if (this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo != null) {
      localGeoInfo.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo.clone();
    }
    return localGeoInfo;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.c)) || (!TextUtils.isEmpty(this.d)) || (!TextUtils.isEmpty(this.e));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2.GeoInfo
 * JD-Core Version:    0.7.0.1
 */