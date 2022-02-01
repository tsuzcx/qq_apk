import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.PhotoParam;

public final class mbz
  implements Parcelable.Creator
{
  public PhotoParam a(Parcel paramParcel)
  {
    boolean bool2 = true;
    PhotoParam localPhotoParam = new PhotoParam();
    localPhotoParam.jdField_a_of_type_Long = paramParcel.readLong();
    localPhotoParam.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localPhotoParam.jdField_b_of_type_Long = paramParcel.readLong();
    localPhotoParam.jdField_c_of_type_Long = paramParcel.readLong();
    localPhotoParam.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localPhotoParam.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localPhotoParam.jdField_b_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_c_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_d_of_type_Int = paramParcel.readInt();
    localPhotoParam.jdField_d_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localPhotoParam.jdField_a_of_type_Boolean = bool1;
      localPhotoParam.jdField_e_of_type_Int = paramParcel.readInt();
      localPhotoParam.jdField_f_of_type_Int = paramParcel.readInt();
      localPhotoParam.jdField_e_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_f_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_g_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.jdField_h_of_type_JavaLangString = paramParcel.readString();
      localPhotoParam.i = paramParcel.readString();
      localPhotoParam.jdField_g_of_type_Int = paramParcel.readInt();
      localPhotoParam.jdField_a_of_type_JavaUtilMap = paramParcel.readHashMap(getClass().getClassLoader());
      localPhotoParam.j = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label304;
      }
      bool1 = true;
      label224:
      localPhotoParam.jdField_b_of_type_Boolean = bool1;
      localPhotoParam.jdField_h_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label309;
      }
      bool1 = true;
      label249:
      localPhotoParam.jdField_c_of_type_Boolean = bool1;
      localPhotoParam.k = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label314;
      }
      bool1 = true;
      label274:
      localPhotoParam.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label319;
      }
    }
    label304:
    label309:
    label314:
    label319:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localPhotoParam.jdField_e_of_type_Boolean = bool1;
      return localPhotoParam;
      bool1 = false;
      break;
      bool1 = false;
      break label224;
      bool1 = false;
      break label249;
      bool1 = false;
      break label274;
    }
  }
  
  public PhotoParam[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbz
 * JD-Core Version:    0.7.0.1
 */