import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.remote.SendMsg;

public final class mdb
  implements Parcelable.Creator
{
  public SendMsg a(Parcel paramParcel)
  {
    return new SendMsg(paramParcel);
  }
  
  public SendMsg[] a(int paramInt)
  {
    return new SendMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mdb
 * JD-Core Version:    0.7.0.1
 */