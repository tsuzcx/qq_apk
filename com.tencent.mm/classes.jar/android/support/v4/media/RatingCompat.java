package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat
  implements Parcelable
{
  public static final Parcelable.Creator<RatingCompat> CREATOR = new RatingCompat.1();
  private final int BZ;
  private final float Ca;
  
  RatingCompat(int paramInt, float paramFloat)
  {
    this.BZ = paramInt;
    this.Ca = paramFloat;
  }
  
  public final int describeContents()
  {
    return this.BZ;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Rating:style=").append(this.BZ).append(" rating=");
    if (this.Ca < 0.0F) {}
    for (String str = "unrated";; str = String.valueOf(this.Ca)) {
      return str;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.BZ);
    paramParcel.writeFloat(this.Ca);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.RatingCompat
 * JD-Core Version:    0.7.0.1
 */