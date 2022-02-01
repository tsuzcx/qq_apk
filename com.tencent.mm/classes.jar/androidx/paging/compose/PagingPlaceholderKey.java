package androidx.paging.compose;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/paging/compose/PagingPlaceholderKey;", "Landroid/os/Parcelable;", "index", "", "(I)V", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "paging-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
final class PagingPlaceholderKey
  implements Parcelable
{
  public static final Parcelable.Creator<PagingPlaceholderKey> CREATOR;
  public static final PagingPlaceholderKey.a bRY;
  private final int index;
  
  static
  {
    AppMethodBeat.i(197195);
    bRY = new PagingPlaceholderKey.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(197195);
  }
  
  public PagingPlaceholderKey(int paramInt)
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
      if (!(paramObject instanceof PagingPlaceholderKey)) {
        return false;
      }
      paramObject = (PagingPlaceholderKey)paramObject;
    } while (this.index == paramObject.index);
    return false;
  }
  
  public final int hashCode()
  {
    return this.index;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197217);
    String str = "PagingPlaceholderKey(index=" + this.index + ')';
    AppMethodBeat.o(197217);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(197203);
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(this.index);
    AppMethodBeat.o(197203);
  }
  
  @Metadata(d1={""}, d2={"androidx/paging/compose/PagingPlaceholderKey$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Landroidx/paging/compose/PagingPlaceholderKey;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Landroidx/paging/compose/PagingPlaceholderKey;", "paging-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<PagingPlaceholderKey>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.compose.PagingPlaceholderKey
 * JD-Core Version:    0.7.0.1
 */