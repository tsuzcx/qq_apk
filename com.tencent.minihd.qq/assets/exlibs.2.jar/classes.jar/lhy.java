import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.downloadnew.common.NoticeParam;

public final class lhy
  implements Parcelable.Creator
{
  public NoticeParam a(Parcel paramParcel)
  {
    return new NoticeParam(paramParcel);
  }
  
  public NoticeParam[] a(int paramInt)
  {
    return new NoticeParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lhy
 * JD-Core Version:    0.7.0.1
 */