import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.ForwardUtils.Section_Text;

public final class fpb
  implements Parcelable.Creator
{
  public ForwardUtils.Section_Text a(Parcel paramParcel)
  {
    return new ForwardUtils.Section_Text(paramParcel);
  }
  
  public ForwardUtils.Section_Text[] a(int paramInt)
  {
    return new ForwardUtils.Section_Text[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fpb
 * JD-Core Version:    0.7.0.1
 */