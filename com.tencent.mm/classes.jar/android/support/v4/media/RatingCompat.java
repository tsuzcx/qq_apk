package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat
  implements Parcelable
{
  public static final Parcelable.Creator<RatingCompat> CREATOR = new RatingCompat.1();
  private final int CH;
  private final float CI;
  
  RatingCompat(int paramInt, float paramFloat)
  {
    this.CH = paramInt;
    this.CI = paramFloat;
  }
  
  public final int describeContents()
  {
    return this.CH;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Rating:style=").append(this.CH).append(" rating=");
    if (this.CI < 0.0F) {}
    for (String str = "unrated";; str = String.valueOf(this.CI)) {
      return str;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.CH);
    paramParcel.writeFloat(this.CI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.RatingCompat
 * JD-Core Version:    0.7.0.1
 */