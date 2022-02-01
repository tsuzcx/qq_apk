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
    private final d<T> No;
    
    a(d<T> paramd)
    {
      this.No = paramd;
    }
    
    public final T createFromParcel(Parcel paramParcel)
    {
      return this.No.createFromParcel(paramParcel, null);
    }
    
    public final T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      return this.No.createFromParcel(paramParcel, paramClassLoader);
    }
    
    public final T[] newArray(int paramInt)
    {
      return this.No.newArray(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.os.c
 * JD-Core Version:    0.7.0.1
 */