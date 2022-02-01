package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentManagerState> CREATOR;
  ArrayList<FragmentState> bDd;
  ArrayList<String> bDe;
  BackStackState[] bDf;
  int bDg;
  String bDh;
  ArrayList<String> bDi;
  ArrayList<Bundle> bDj;
  ArrayList<FragmentManager.LaunchedFragmentInfo> bDk;
  
  static
  {
    AppMethodBeat.i(193464);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(193464);
  }
  
  public FragmentManagerState()
  {
    AppMethodBeat.i(193438);
    this.bDh = null;
    this.bDi = new ArrayList();
    this.bDj = new ArrayList();
    AppMethodBeat.o(193438);
  }
  
  public FragmentManagerState(Parcel paramParcel)
  {
    AppMethodBeat.i(193449);
    this.bDh = null;
    this.bDi = new ArrayList();
    this.bDj = new ArrayList();
    this.bDd = paramParcel.createTypedArrayList(FragmentState.CREATOR);
    this.bDe = paramParcel.createStringArrayList();
    this.bDf = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
    this.bDg = paramParcel.readInt();
    this.bDh = paramParcel.readString();
    this.bDi = paramParcel.createStringArrayList();
    this.bDj = paramParcel.createTypedArrayList(Bundle.CREATOR);
    this.bDk = paramParcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    AppMethodBeat.o(193449);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(193479);
    paramParcel.writeTypedList(this.bDd);
    paramParcel.writeStringList(this.bDe);
    paramParcel.writeTypedArray(this.bDf, paramInt);
    paramParcel.writeInt(this.bDg);
    paramParcel.writeString(this.bDh);
    paramParcel.writeStringList(this.bDi);
    paramParcel.writeTypedList(this.bDj);
    paramParcel.writeTypedList(this.bDk);
    AppMethodBeat.o(193479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.FragmentManagerState
 * JD-Core Version:    0.7.0.1
 */