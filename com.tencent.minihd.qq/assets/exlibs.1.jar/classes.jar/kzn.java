import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.widget.Workspace.SavedState;

public final class kzn
  implements Parcelable.Creator
{
  public Workspace.SavedState a(Parcel paramParcel)
  {
    return new Workspace.SavedState(paramParcel, null);
  }
  
  public Workspace.SavedState[] a(int paramInt)
  {
    return new Workspace.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kzn
 * JD-Core Version:    0.7.0.1
 */