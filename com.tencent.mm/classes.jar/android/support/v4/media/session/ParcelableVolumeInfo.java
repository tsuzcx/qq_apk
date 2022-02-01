package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator() {};
  public int MY;
  public int MZ;
  public int Na;
  public int Nb;
  public int Nc;
  
  public ParcelableVolumeInfo(Parcel paramParcel)
  {
    this.MY = paramParcel.readInt();
    this.Na = paramParcel.readInt();
    this.Nb = paramParcel.readInt();
    this.Nc = paramParcel.readInt();
    this.MZ = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.MY);
    paramParcel.writeInt(this.Na);
    paramParcel.writeInt(this.Nb);
    paramParcel.writeInt(this.Nc);
    paramParcel.writeInt(this.MZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.session.ParcelableVolumeInfo
 * JD-Core Version:    0.7.0.1
 */