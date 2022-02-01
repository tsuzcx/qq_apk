package coil.size;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/size/OriginalSize;", "Lcoil/size/Size;", "()V", "describeContents", "", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OriginalSize
  extends Size
{
  public static final Parcelable.Creator<OriginalSize> CREATOR;
  public static final OriginalSize cpS;
  
  static
  {
    AppMethodBeat.i(188179);
    cpS = new OriginalSize();
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(188179);
  }
  
  private OriginalSize()
  {
    super((byte)0);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return "coil.size.OriginalSize";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(188209);
    s.u(paramParcel, "out");
    paramParcel.writeInt(1);
    AppMethodBeat.o(188209);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<OriginalSize>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     coil.size.OriginalSize
 * JD-Core Version:    0.7.0.1
 */