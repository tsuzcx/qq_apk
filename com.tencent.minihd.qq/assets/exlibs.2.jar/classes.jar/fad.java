import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity.TroopAdmin;

public final class fad
  implements Parcelable.Creator
{
  public SetTroopAdminsActivity.TroopAdmin a(Parcel paramParcel)
  {
    return new SetTroopAdminsActivity.TroopAdmin(paramParcel, null);
  }
  
  public SetTroopAdminsActivity.TroopAdmin[] a(int paramInt)
  {
    return new SetTroopAdminsActivity.TroopAdmin[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fad
 * JD-Core Version:    0.7.0.1
 */