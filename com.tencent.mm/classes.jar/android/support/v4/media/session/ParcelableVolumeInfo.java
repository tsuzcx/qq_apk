package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator() {};
  public int KW;
  public int KX;
  public int KY;
  public int KZ;
  public int La;
  
  public ParcelableVolumeInfo(Parcel paramParcel)
  {
    this.KW = paramParcel.readInt();
    this.KY = paramParcel.readInt();
    this.KZ = paramParcel.readInt();
    this.La = paramParcel.readInt();
    this.KX = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.KW);
    paramParcel.writeInt(this.KY);
    paramParcel.writeInt(this.KZ);
    paramParcel.writeInt(this.La);
    paramParcel.writeInt(this.KX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.session.ParcelableVolumeInfo
 * JD-Core Version:    0.7.0.1
 */