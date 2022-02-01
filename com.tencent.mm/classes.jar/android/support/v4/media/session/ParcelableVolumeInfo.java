package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator() {};
  public int MO;
  public int MP;
  public int MQ;
  public int MR;
  public int MS;
  
  public ParcelableVolumeInfo(Parcel paramParcel)
  {
    this.MO = paramParcel.readInt();
    this.MQ = paramParcel.readInt();
    this.MR = paramParcel.readInt();
    this.MS = paramParcel.readInt();
    this.MP = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.MO);
    paramParcel.writeInt(this.MQ);
    paramParcel.writeInt(this.MR);
    paramParcel.writeInt(this.MS);
    paramParcel.writeInt(this.MP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.session.ParcelableVolumeInfo
 * JD-Core Version:    0.7.0.1
 */