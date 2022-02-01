package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator() {};
  public int Kb;
  public int Kc;
  public int Kd;
  public int Ke;
  public int Kf;
  
  public ParcelableVolumeInfo(Parcel paramParcel)
  {
    this.Kb = paramParcel.readInt();
    this.Kd = paramParcel.readInt();
    this.Ke = paramParcel.readInt();
    this.Kf = paramParcel.readInt();
    this.Kc = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.Kb);
    paramParcel.writeInt(this.Kd);
    paramParcel.writeInt(this.Ke);
    paramParcel.writeInt(this.Kf);
    paramParcel.writeInt(this.Kc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.session.ParcelableVolumeInfo
 * JD-Core Version:    0.7.0.1
 */