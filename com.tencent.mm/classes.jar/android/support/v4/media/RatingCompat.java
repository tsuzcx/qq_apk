package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat
  implements Parcelable
{
  public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator() {};
  private final int Ks;
  private final float Kt;
  
  RatingCompat(int paramInt, float paramFloat)
  {
    this.Ks = paramInt;
    this.Kt = paramFloat;
  }
  
  public final int describeContents()
  {
    return this.Ks;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Rating:style=").append(this.Ks).append(" rating=");
    if (this.Kt < 0.0F) {}
    for (String str = "unrated";; str = String.valueOf(this.Kt)) {
      return str;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.Ks);
    paramParcel.writeFloat(this.Kt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.RatingCompat
 * JD-Core Version:    0.7.0.1
 */