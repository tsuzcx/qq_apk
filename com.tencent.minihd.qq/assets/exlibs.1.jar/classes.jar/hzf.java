import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.SecMsg;

public final class hzf
  implements Parcelable.Creator
{
  public SecMsg a(Parcel paramParcel)
  {
    return new SecMsg(paramParcel, null);
  }
  
  public SecMsg[] a(int paramInt)
  {
    return new SecMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hzf
 * JD-Core Version:    0.7.0.1
 */