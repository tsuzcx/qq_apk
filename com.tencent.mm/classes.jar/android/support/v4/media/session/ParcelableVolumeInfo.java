package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new ParcelableVolumeInfo.1();
  public int CB;
  public int CC;
  public int CD;
  public int CE;
  public int CF;
  
  public ParcelableVolumeInfo(Parcel paramParcel)
  {
    this.CB = paramParcel.readInt();
    this.CD = paramParcel.readInt();
    this.CE = paramParcel.readInt();
    this.CF = paramParcel.readInt();
    this.CC = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.CB);
    paramParcel.writeInt(this.CD);
    paramParcel.writeInt(this.CE);
    paramParcel.writeInt(this.CF);
    paramParcel.writeInt(this.CC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.session.ParcelableVolumeInfo
 * JD-Core Version:    0.7.0.1
 */