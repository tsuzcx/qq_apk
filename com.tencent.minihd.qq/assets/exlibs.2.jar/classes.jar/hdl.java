import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.ProgressWheel.WheelSavedState;

public final class hdl
  implements Parcelable.Creator
{
  public ProgressWheel.WheelSavedState a(Parcel paramParcel)
  {
    return new ProgressWheel.WheelSavedState(paramParcel, null);
  }
  
  public ProgressWheel.WheelSavedState[] a(int paramInt)
  {
    return new ProgressWheel.WheelSavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdl
 * JD-Core Version:    0.7.0.1
 */