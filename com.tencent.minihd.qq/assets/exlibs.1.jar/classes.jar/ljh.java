import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qav.ipc.QavMsgRecord;

public final class ljh
  implements Parcelable.Creator
{
  public QavMsgRecord a(Parcel paramParcel)
  {
    return new QavMsgRecord(paramParcel);
  }
  
  public QavMsgRecord[] a(int paramInt)
  {
    return new QavMsgRecord[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljh
 * JD-Core Version:    0.7.0.1
 */