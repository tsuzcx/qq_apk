package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR;
  final int UU;
  final int UV;
  final int UZ;
  final CharSequence Va;
  final int Vb;
  final CharSequence Vc;
  final ArrayList<String> Vd;
  final ArrayList<String> Ve;
  final boolean Vf;
  final int[] Vm;
  final int mIndex;
  final String mName;
  
  static
  {
    AppMethodBeat.i(211902);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(211902);
  }
  
  public BackStackState(Parcel paramParcel)
  {
    AppMethodBeat.i(211897);
    this.Vm = paramParcel.createIntArray();
    this.UU = paramParcel.readInt();
    this.UV = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.UZ = paramParcel.readInt();
    this.Va = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Vb = paramParcel.readInt();
    this.Vc = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.Vd = paramParcel.createStringArrayList();
    this.Ve = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.Vf = bool;
      AppMethodBeat.o(211897);
      return;
    }
  }
  
  public BackStackState(a parama)
  {
    AppMethodBeat.i(211895);
    int k = parama.UO.size();
    this.Vm = new int[k * 6];
    if (!parama.UW)
    {
      parama = new IllegalStateException("Not on back stack");
      AppMethodBeat.o(211895);
      throw parama;
    }
    int i = 0;
    int j = 0;
    if (i < k)
    {
      a.a locala = (a.a)parama.UO.get(i);
      int[] arrayOfInt = this.Vm;
      int m = j + 1;
      arrayOfInt[j] = locala.Vh;
      arrayOfInt = this.Vm;
      int n = m + 1;
      if (locala.fragment != null) {}
      for (j = locala.fragment.mIndex;; j = -1)
      {
        arrayOfInt[m] = j;
        arrayOfInt = this.Vm;
        j = n + 1;
        arrayOfInt[n] = locala.Vi;
        arrayOfInt = this.Vm;
        m = j + 1;
        arrayOfInt[j] = locala.Vj;
        arrayOfInt = this.Vm;
        n = m + 1;
        arrayOfInt[m] = locala.Vk;
        arrayOfInt = this.Vm;
        j = n + 1;
        arrayOfInt[n] = locala.Vl;
        i += 1;
        break;
      }
    }
    this.UU = parama.UU;
    this.UV = parama.UV;
    this.mName = parama.mName;
    this.mIndex = parama.mIndex;
    this.UZ = parama.UZ;
    this.Va = parama.Va;
    this.Vb = parama.Vb;
    this.Vc = parama.Vc;
    this.Vd = parama.Vd;
    this.Ve = parama.Ve;
    this.Vf = parama.Vf;
    AppMethodBeat.o(211895);
  }
  
  public final a a(FragmentManagerImpl paramFragmentManagerImpl)
  {
    AppMethodBeat.i(211898);
    a locala = new a(paramFragmentManagerImpl);
    int i = 0;
    int j = 0;
    if (j < this.Vm.length)
    {
      a.a locala1 = new a.a();
      int[] arrayOfInt = this.Vm;
      int k = j + 1;
      locala1.Vh = arrayOfInt[j];
      if (FragmentManagerImpl.DEBUG) {
        new StringBuilder("Instantiate ").append(locala).append(" op #").append(i).append(" base fragment #").append(this.Vm[k]);
      }
      arrayOfInt = this.Vm;
      j = k + 1;
      k = arrayOfInt[k];
      if (k >= 0) {}
      for (locala1.fragment = ((Fragment)paramFragmentManagerImpl.mActive.get(k));; locala1.fragment = null)
      {
        arrayOfInt = this.Vm;
        k = j + 1;
        locala1.Vi = arrayOfInt[j];
        arrayOfInt = this.Vm;
        j = k + 1;
        locala1.Vj = arrayOfInt[k];
        arrayOfInt = this.Vm;
        k = j + 1;
        locala1.Vk = arrayOfInt[j];
        arrayOfInt = this.Vm;
        j = k + 1;
        locala1.Vl = arrayOfInt[k];
        locala.UQ = locala1.Vi;
        locala.UR = locala1.Vj;
        locala.US = locala1.Vk;
        locala.UT = locala1.Vl;
        locala.a(locala1);
        i += 1;
        break;
      }
    }
    locala.UU = this.UU;
    locala.UV = this.UV;
    locala.mName = this.mName;
    locala.mIndex = this.mIndex;
    locala.UW = true;
    locala.UZ = this.UZ;
    locala.Va = this.Va;
    locala.Vb = this.Vb;
    locala.Vc = this.Vc;
    locala.Vd = this.Vd;
    locala.Ve = this.Ve;
    locala.Vf = this.Vf;
    locala.bX(1);
    AppMethodBeat.o(211898);
    return locala;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 0;
    AppMethodBeat.i(211900);
    paramParcel.writeIntArray(this.Vm);
    paramParcel.writeInt(this.UU);
    paramParcel.writeInt(this.UV);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.UZ);
    TextUtils.writeToParcel(this.Va, paramParcel, 0);
    paramParcel.writeInt(this.Vb);
    TextUtils.writeToParcel(this.Vc, paramParcel, 0);
    paramParcel.writeStringList(this.Vd);
    paramParcel.writeStringList(this.Ve);
    if (this.Vf) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
    AppMethodBeat.o(211900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */