import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsDataV2.WifiInfo;

public final class may
  implements Parcelable.Creator
{
  public LbsDataV2.WifiInfo a(Parcel paramParcel)
  {
    return new LbsDataV2.WifiInfo(paramParcel.readString(), paramParcel.readInt());
  }
  
  public LbsDataV2.WifiInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     may
 * JD-Core Version:    0.7.0.1
 */