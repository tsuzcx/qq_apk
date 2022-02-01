import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qav.ipc.QavState;

public final class ljk
  implements Parcelable.Creator
{
  public QavState a(Parcel paramParcel)
  {
    return new QavState(paramParcel);
  }
  
  public QavState[] a(int paramInt)
  {
    return new QavState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljk
 * JD-Core Version:    0.7.0.1
 */