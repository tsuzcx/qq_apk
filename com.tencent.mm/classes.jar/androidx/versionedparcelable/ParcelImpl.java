package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ParcelImpl
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelImpl> CREATOR;
  private final c aqK;
  
  static
  {
    AppMethodBeat.i(145817);
    CREATOR = new ParcelImpl.1();
    AppMethodBeat.o(145817);
  }
  
  protected ParcelImpl(Parcel paramParcel)
  {
    AppMethodBeat.i(145815);
    this.aqK = new b(paramParcel).lk();
    AppMethodBeat.o(145815);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145816);
    new b(paramParcel).a(this.aqK);
    AppMethodBeat.o(145816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.versionedparcelable.ParcelImpl
 * JD-Core Version:    0.7.0.1
 */