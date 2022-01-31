package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class d$a<T>
  implements Parcelable.ClassLoaderCreator<T>
{
  private final e<T> CT;
  
  d$a(e<T> parame)
  {
    this.CT = parame;
  }
  
  public final T createFromParcel(Parcel paramParcel)
  {
    return this.CT.createFromParcel(paramParcel, null);
  }
  
  public final T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return this.CT.createFromParcel(paramParcel, paramClassLoader);
  }
  
  public final T[] newArray(int paramInt)
  {
    return this.CT.newArray(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.os.d.a
 * JD-Core Version:    0.7.0.1
 */