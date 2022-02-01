import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.device.utils.LightAppSettingInfo;

public final class dbn
  implements Parcelable.Creator
{
  public LightAppSettingInfo a(Parcel paramParcel)
  {
    LightAppSettingInfo localLightAppSettingInfo = new LightAppSettingInfo();
    localLightAppSettingInfo.jdField_d_of_type_Int = paramParcel.readInt();
    localLightAppSettingInfo.jdField_e_of_type_Int = paramParcel.readInt();
    localLightAppSettingInfo.jdField_f_of_type_Int = paramParcel.readInt();
    localLightAppSettingInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localLightAppSettingInfo.jdField_a_of_type_JavaUtilArrayList = paramParcel.readArrayList(ClassLoader.getSystemClassLoader());
    localLightAppSettingInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.b = paramParcel.readString();
    localLightAppSettingInfo.jdField_g_of_type_Int = paramParcel.readInt();
    localLightAppSettingInfo.c = paramParcel.readString();
    localLightAppSettingInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.jdField_g_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.h = paramParcel.readInt();
    return localLightAppSettingInfo;
  }
  
  public LightAppSettingInfo[] a(int paramInt)
  {
    return new LightAppSettingInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbn
 * JD-Core Version:    0.7.0.1
 */