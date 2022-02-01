package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator() {};
  public int dO;
  public int dP;
  public int dQ;
  public int dR;
  public int dS;
  
  public ParcelableVolumeInfo(Parcel paramParcel)
  {
    this.dO = paramParcel.readInt();
    this.dQ = paramParcel.readInt();
    this.dR = paramParcel.readInt();
    this.dS = paramParcel.readInt();
    this.dP = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.dO);
    paramParcel.writeInt(this.dQ);
    paramParcel.writeInt(this.dR);
    paramParcel.writeInt(this.dS);
    paramParcel.writeInt(this.dP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.session.ParcelableVolumeInfo
 * JD-Core Version:    0.7.0.1
 */