import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.LocalImageShootInfo;

public final class mbw
  implements Parcelable.Creator
{
  public LocalImageShootInfo a(Parcel paramParcel)
  {
    return new LocalImageShootInfo(paramParcel);
  }
  
  public LocalImageShootInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbw
 * JD-Core Version:    0.7.0.1
 */