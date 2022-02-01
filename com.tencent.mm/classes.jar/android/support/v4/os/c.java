package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

@Deprecated
public final class c
{
  @Deprecated
  public static <T> Parcelable.Creator<T> a(d<T> paramd)
  {
    return new a(paramd);
  }
  
  static final class a<T>
    implements Parcelable.ClassLoaderCreator<T>
  {
    private final d<T> Ne;
    
    a(d<T> paramd)
    {
      this.Ne = paramd;
    }
    
    public final T createFromParcel(Parcel paramParcel)
    {
      return this.Ne.createFromParcel(paramParcel, null);
    }
    
    public final T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      return this.Ne.createFromParcel(paramParcel, paramClassLoader);
    }
    
    public final T[] newArray(int paramInt)
    {
      return this.Ne.newArray(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.os.c
 * JD-Core Version:    0.7.0.1
 */