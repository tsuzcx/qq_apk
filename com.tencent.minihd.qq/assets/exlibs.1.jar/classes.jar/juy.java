import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.service.friendlist.remote.FriendGroupListInfo;

public final class juy
  implements Parcelable.Creator
{
  public FriendGroupListInfo a(Parcel paramParcel)
  {
    return new FriendGroupListInfo(paramParcel);
  }
  
  public FriendGroupListInfo[] a(int paramInt)
  {
    return new FriendGroupListInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     juy
 * JD-Core Version:    0.7.0.1
 */