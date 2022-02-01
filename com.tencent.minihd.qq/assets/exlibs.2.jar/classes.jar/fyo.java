import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;

public final class fyo
  implements Parcelable.Creator
{
  public AIOImageData a(Parcel paramParcel)
  {
    boolean bool2 = true;
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.a = paramParcel.readLong();
    localAIOImageData.jdField_e_of_type_Int = paramParcel.readInt();
    localAIOImageData.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localAIOImageData.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localAIOImageData.jdField_f_of_type_JavaLangString = paramParcel.readString();
    localAIOImageData.g = paramParcel.readString();
    localAIOImageData.h = paramParcel.readString();
    localAIOImageData.b = paramParcel.readLong();
    localAIOImageData.c = paramParcel.readLong();
    localAIOImageData.jdField_d_of_type_Long = paramParcel.readLong();
    localAIOImageData.jdField_e_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      localAIOImageData.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label163;
      }
      bool1 = true;
      label134:
      localAIOImageData.jdField_e_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label168;
      }
    }
    label163:
    label168:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localAIOImageData.jdField_f_of_type_Boolean = bool1;
      return localAIOImageData;
      bool1 = false;
      break;
      bool1 = false;
      break label134;
    }
  }
  
  public AIOImageData[] a(int paramInt)
  {
    return new AIOImageData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fyo
 * JD-Core Version:    0.7.0.1
 */