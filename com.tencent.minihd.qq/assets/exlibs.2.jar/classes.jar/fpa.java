import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.ForwardUtils.Section_Pic;

public final class fpa
  implements Parcelable.Creator
{
  public ForwardUtils.Section_Pic a(Parcel paramParcel)
  {
    return new ForwardUtils.Section_Pic(paramParcel);
  }
  
  public ForwardUtils.Section_Pic[] a(int paramInt)
  {
    return new ForwardUtils.Section_Pic[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fpa
 * JD-Core Version:    0.7.0.1
 */