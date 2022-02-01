package androidx.core.c;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class e
{
  @Deprecated
  public static <T> Parcelable.Creator<T> a(f<T> paramf)
  {
    AppMethodBeat.i(195444);
    paramf = new a(paramf);
    AppMethodBeat.o(195444);
    return paramf;
  }
  
  static final class a<T>
    implements Parcelable.ClassLoaderCreator<T>
  {
    private final f<T> brq;
    
    a(f<T> paramf)
    {
      this.brq = paramf;
    }
    
    public final T createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(195454);
      paramParcel = this.brq.createFromParcel(paramParcel, null);
      AppMethodBeat.o(195454);
      return paramParcel;
    }
    
    public final T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      AppMethodBeat.i(195461);
      paramParcel = this.brq.createFromParcel(paramParcel, paramClassLoader);
      AppMethodBeat.o(195461);
      return paramParcel;
    }
    
    public final T[] newArray(int paramInt)
    {
      AppMethodBeat.i(195471);
      Object[] arrayOfObject = this.brq.newArray(paramInt);
      AppMethodBeat.o(195471);
      return arrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.c.e
 * JD-Core Version:    0.7.0.1
 */