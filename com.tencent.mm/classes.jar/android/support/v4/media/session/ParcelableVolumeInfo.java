package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new ParcelableVolumeInfo.1();
  public int Dk;
  public int Dl;
  public int Dm;
  public int Dn;
  public int Do;
  
  public ParcelableVolumeInfo(Parcel paramParcel)
  {
    this.Dk = paramParcel.readInt();
    this.Dm = paramParcel.readInt();
    this.Dn = paramParcel.readInt();
    this.Do = paramParcel.readInt();
    this.Dl = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.Dk);
    paramParcel.writeInt(this.Dm);
    paramParcel.writeInt(this.Dn);
    paramParcel.writeInt(this.Do);
    paramParcel.writeInt(this.Dl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.session.ParcelableVolumeInfo
 * JD-Core Version:    0.7.0.1
 */