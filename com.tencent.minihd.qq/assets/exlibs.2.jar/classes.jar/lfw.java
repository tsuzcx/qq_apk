import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.downloadnew.DownloadInfo;

public final class lfw
  implements Parcelable.Creator
{
  public DownloadInfo a(Parcel paramParcel)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localDownloadInfo.d = paramParcel.readString();
    localDownloadInfo.e = paramParcel.readString();
    localDownloadInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
    localDownloadInfo.a = paramParcel.readInt();
    localDownloadInfo.g = paramParcel.readString();
    localDownloadInfo.h = paramParcel.readString();
    localDownloadInfo.jdField_f_of_type_Int = paramParcel.readInt();
    localDownloadInfo.jdField_k_of_type_JavaLangString = paramParcel.readString();
    localDownloadInfo.j = paramParcel.readInt();
    localDownloadInfo.jdField_k_of_type_Int = paramParcel.readInt();
    localDownloadInfo.jdField_b_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localDownloadInfo.jdField_c_of_type_Boolean = bool;
      return localDownloadInfo;
    }
  }
  
  public DownloadInfo[] a(int paramInt)
  {
    return new DownloadInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lfw
 * JD-Core Version:    0.7.0.1
 */