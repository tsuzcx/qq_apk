package androidx.core.c;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class b
{
  @Deprecated
  public static <T> Parcelable.Creator<T> a(c<T> paramc)
  {
    AppMethodBeat.i(251043);
    paramc = new a(paramc);
    AppMethodBeat.o(251043);
    return paramc;
  }
  
  static final class a<T>
    implements Parcelable.ClassLoaderCreator<T>
  {
    private final c<T> Lf;
    
    a(c<T> paramc)
    {
      this.Lf = paramc;
    }
    
    public final T createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(251036);
      paramParcel = this.Lf.createFromParcel(paramParcel, null);
      AppMethodBeat.o(251036);
      return paramParcel;
    }
    
    public final T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      AppMethodBeat.i(251037);
      paramParcel = this.Lf.createFromParcel(paramParcel, paramClassLoader);
      AppMethodBeat.o(251037);
      return paramParcel;
    }
    
    public final T[] newArray(int paramInt)
    {
      AppMethodBeat.i(251038);
      Object[] arrayOfObject = this.Lf.newArray(paramInt);
      AppMethodBeat.o(251038);
      return arrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.c.b
 * JD-Core Version:    0.7.0.1
 */