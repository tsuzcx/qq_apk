package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class c$a<T>
  implements Parcelable.ClassLoaderCreator<T>
{
  private final d<T> DC;
  
  c$a(d<T> paramd)
  {
    this.DC = paramd;
  }
  
  public final T createFromParcel(Parcel paramParcel)
  {
    return this.DC.createFromParcel(paramParcel, null);
  }
  
  public final T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return this.DC.createFromParcel(paramParcel, paramClassLoader);
  }
  
  public final T[] newArray(int paramInt)
  {
    return this.DC.newArray(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.os.c.a
 * JD-Core Version:    0.7.0.1
 */