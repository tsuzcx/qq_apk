import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.util.file.DLFileInfo;

public final class ed
  implements Parcelable.Creator
{
  public DLFileInfo a(Parcel paramParcel)
  {
    return new DLFileInfo(paramParcel, null);
  }
  
  public DLFileInfo[] a(int paramInt)
  {
    return new DLFileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ed
 * JD-Core Version:    0.7.0.1
 */