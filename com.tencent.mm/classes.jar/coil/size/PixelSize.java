package coil.size;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/size/PixelSize;", "Lcoil/size/Size;", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PixelSize
  extends Size
{
  public static final Parcelable.Creator<PixelSize> CREATOR;
  public final int height;
  public final int width;
  
  static
  {
    AppMethodBeat.i(188217);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(188217);
  }
  
  public PixelSize(int paramInt1, int paramInt2)
  {
    super((byte)0);
    AppMethodBeat.i(188208);
    this.width = paramInt1;
    this.height = paramInt2;
    paramInt1 = i;
    if (this.width > 0)
    {
      paramInt1 = i;
      if (this.height > 0) {
        paramInt1 = 1;
      }
    }
    if (paramInt1 == 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("width and height must be > 0.".toString());
      AppMethodBeat.o(188208);
      throw localThrowable;
    }
    AppMethodBeat.o(188208);
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
      if (!(paramObject instanceof PixelSize)) {
        return false;
      }
      paramObject = (PixelSize)paramObject;
      if (this.width != paramObject.width) {
        return false;
      }
    } while (this.height == paramObject.height);
    return false;
  }
  
  public final int hashCode()
  {
    return this.width * 31 + this.height;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188226);
    String str = "PixelSize(width=" + this.width + ", height=" + this.height + ')';
    AppMethodBeat.o(188226);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(188256);
    s.u(paramParcel, "out");
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    AppMethodBeat.o(188256);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<PixelSize>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     coil.size.PixelSize
 * JD-Core Version:    0.7.0.1
 */