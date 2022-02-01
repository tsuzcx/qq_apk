package androidx.compose.foundation.lazy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/DefaultLazyKey;", "Landroid/os/Parcelable;", "index", "", "(I)V", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class DefaultLazyKey
  implements Parcelable
{
  public static final Parcelable.Creator<DefaultLazyKey> CREATOR;
  public static final DefaultLazyKey.a aek;
  private final int index;
  
  static
  {
    AppMethodBeat.i(204250);
    aek = new DefaultLazyKey.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(204250);
  }
  
  public DefaultLazyKey(int paramInt)
  {
    this.index = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof DefaultLazyKey)) {
        return false;
      }
      paramObject = (DefaultLazyKey)paramObject;
    } while (this.index == paramObject.index);
    return false;
  }
  
  public final int hashCode()
  {
    return this.index;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204266);
    String str = "DefaultLazyKey(index=" + this.index + ')';
    AppMethodBeat.o(204266);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(204256);
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(this.index);
    AppMethodBeat.o(204256);
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/lazy/DefaultLazyKey$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/foundation/lazy/DefaultLazyKey;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Landroidx/compose/foundation/lazy/DefaultLazyKey;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<DefaultLazyKey>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.DefaultLazyKey
 * JD-Core Version:    0.7.0.1
 */