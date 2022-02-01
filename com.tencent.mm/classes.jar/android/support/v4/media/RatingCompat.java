package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat
  implements Parcelable
{
  public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator() {};
  private final int Jx;
  private final float Jy;
  
  RatingCompat(int paramInt, float paramFloat)
  {
    this.Jx = paramInt;
    this.Jy = paramFloat;
  }
  
  public final int describeContents()
  {
    return this.Jx;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Rating:style=").append(this.Jx).append(" rating=");
    if (this.Jy < 0.0F) {}
    for (String str = "unrated";; str = String.valueOf(this.Jy)) {
      return str;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.Jx);
    paramParcel.writeFloat(this.Jy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.RatingCompat
 * JD-Core Version:    0.7.0.1
 */