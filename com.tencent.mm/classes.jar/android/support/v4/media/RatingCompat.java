package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat
  implements Parcelable
{
  public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator() {};
  private final int dn;
  private final float jdField_do;
  
  RatingCompat(int paramInt, float paramFloat)
  {
    this.dn = paramInt;
    this.jdField_do = paramFloat;
  }
  
  public final int describeContents()
  {
    return this.dn;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Rating:style=").append(this.dn).append(" rating=");
    if (this.jdField_do < 0.0F) {}
    for (String str = "unrated";; str = String.valueOf(this.jdField_do)) {
      return str;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.dn);
    paramParcel.writeFloat(this.jdField_do);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.RatingCompat
 * JD-Core Version:    0.7.0.1
 */