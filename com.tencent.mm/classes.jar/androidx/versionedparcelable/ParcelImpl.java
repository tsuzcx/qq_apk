package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ParcelImpl
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelImpl> CREATOR;
  private final c cjw;
  
  static
  {
    AppMethodBeat.i(62409);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(62409);
  }
  
  protected ParcelImpl(Parcel paramParcel)
  {
    AppMethodBeat.i(62407);
    this.cjw = new b(paramParcel).Mo();
    AppMethodBeat.o(62407);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(62408);
    new b(paramParcel).b(this.cjw);
    AppMethodBeat.o(62408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.versionedparcelable.ParcelImpl
 * JD-Core Version:    0.7.0.1
 */