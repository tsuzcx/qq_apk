package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat
  implements Parcelable
{
  public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator() {};
  private final int Mi;
  private final float Mj;
  
  RatingCompat(int paramInt, float paramFloat)
  {
    this.Mi = paramInt;
    this.Mj = paramFloat;
  }
  
  public final int describeContents()
  {
    return this.Mi;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Rating:style=").append(this.Mi).append(" rating=");
    if (this.Mj < 0.0F) {}
    for (String str = "unrated";; str = String.valueOf(this.Mj)) {
      return str;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.Mi);
    paramParcel.writeFloat(this.Mj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.RatingCompat
 * JD-Core Version:    0.7.0.1
 */