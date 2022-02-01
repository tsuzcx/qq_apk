import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.SecMsgSession;

public final class hzg
  implements Parcelable.Creator
{
  public SecMsgSession a(Parcel paramParcel)
  {
    return new SecMsgSession(paramParcel, null);
  }
  
  public SecMsgSession[] a(int paramInt)
  {
    return new SecMsgSession[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hzg
 * JD-Core Version:    0.7.0.1
 */