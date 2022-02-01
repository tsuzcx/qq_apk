package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentManagerState> CREATOR;
  FragmentState[] Wi;
  int[] Wj;
  BackStackState[] Wk;
  int Wl;
  int mNextFragmentIndex;
  
  static
  {
    AppMethodBeat.i(212833);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(212833);
  }
  
  public FragmentManagerState()
  {
    this.Wl = -1;
  }
  
  public FragmentManagerState(Parcel paramParcel)
  {
    AppMethodBeat.i(212831);
    this.Wl = -1;
    this.Wi = ((FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR));
    this.Wj = paramParcel.createIntArray();
    this.Wk = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
    this.Wl = paramParcel.readInt();
    this.mNextFragmentIndex = paramParcel.readInt();
    AppMethodBeat.o(212831);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(212832);
    paramParcel.writeTypedArray(this.Wi, paramInt);
    paramParcel.writeIntArray(this.Wj);
    paramParcel.writeTypedArray(this.Wk, paramInt);
    paramParcel.writeInt(this.Wl);
    paramParcel.writeInt(this.mNextFragmentIndex);
    AppMethodBeat.o(212832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.FragmentManagerState
 * JD-Core Version:    0.7.0.1
 */