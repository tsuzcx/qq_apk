package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator() {};
  final int EA;
  final int EB;
  final int EF;
  final CharSequence EG;
  final int EH;
  final CharSequence EI;
  final ArrayList<String> EJ;
  final ArrayList<String> EK;
  final boolean EL;
  final int[] ES;
  final int mIndex;
  final String mName;
  
  public BackStackState(Parcel paramParcel)
  {
    this.ES = paramParcel.createIntArray();
    this.EA = paramParcel.readInt();
    this.EB = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.EF = paramParcel.readInt();
    this.EG = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.EH = paramParcel.readInt();
    this.EI = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.EJ = paramParcel.createStringArrayList();
    this.EK = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.EL = bool;
      return;
    }
  }
  
  public BackStackState(b paramb)
  {
    int k = paramb.Ev.size();
    this.ES = new int[k * 6];
    if (!paramb.EC) {
      throw new IllegalStateException("Not on back stack");
    }
    int i = 0;
    int j = 0;
    if (i < k)
    {
      b.a locala = (b.a)paramb.Ev.get(i);
      int[] arrayOfInt = this.ES;
      int m = j + 1;
      arrayOfInt[j] = locala.EN;
      arrayOfInt = this.ES;
      int n = m + 1;
      if (locala.fragment != null) {}
      for (j = locala.fragment.mIndex;; j = -1)
      {
        arrayOfInt[m] = j;
        arrayOfInt = this.ES;
        j = n + 1;
        arrayOfInt[n] = locala.EO;
        arrayOfInt = this.ES;
        m = j + 1;
        arrayOfInt[j] = locala.EP;
        arrayOfInt = this.ES;
        n = m + 1;
        arrayOfInt[m] = locala.EQ;
        arrayOfInt = this.ES;
        j = n + 1;
        arrayOfInt[n] = locala.ER;
        i += 1;
        break;
      }
    }
    this.EA = paramb.EA;
    this.EB = paramb.EB;
    this.mName = paramb.mName;
    this.mIndex = paramb.mIndex;
    this.EF = paramb.EF;
    this.EG = paramb.EG;
    this.EH = paramb.EH;
    this.EI = paramb.EI;
    this.EJ = paramb.EJ;
    this.EK = paramb.EK;
    this.EL = paramb.EL;
  }
  
  public final b a(FragmentManagerImpl paramFragmentManagerImpl)
  {
    b localb = new b(paramFragmentManagerImpl);
    int i = 0;
    int j = 0;
    if (j < this.ES.length)
    {
      b.a locala = new b.a();
      int[] arrayOfInt = this.ES;
      int k = j + 1;
      locala.EN = arrayOfInt[j];
      if (FragmentManagerImpl.DEBUG) {
        new StringBuilder("Instantiate ").append(localb).append(" op #").append(i).append(" base fragment #").append(this.ES[k]);
      }
      arrayOfInt = this.ES;
      j = k + 1;
      k = arrayOfInt[k];
      if (k >= 0) {}
      for (locala.fragment = ((Fragment)paramFragmentManagerImpl.mActive.get(k));; locala.fragment = null)
      {
        arrayOfInt = this.ES;
        k = j + 1;
        locala.EO = arrayOfInt[j];
        arrayOfInt = this.ES;
        j = k + 1;
        locala.EP = arrayOfInt[k];
        arrayOfInt = this.ES;
        k = j + 1;
        locala.EQ = arrayOfInt[j];
        arrayOfInt = this.ES;
        j = k + 1;
        locala.ER = arrayOfInt[k];
        localb.Ew = locala.EO;
        localb.Ex = locala.EP;
        localb.Ey = locala.EQ;
        localb.Ez = locala.ER;
        localb.a(locala);
        i += 1;
        break;
      }
    }
    localb.EA = this.EA;
    localb.EB = this.EB;
    localb.mName = this.mName;
    localb.mIndex = this.mIndex;
    localb.EC = true;
    localb.EF = this.EF;
    localb.EG = this.EG;
    localb.EH = this.EH;
    localb.EI = this.EI;
    localb.EJ = this.EJ;
    localb.EK = this.EK;
    localb.EL = this.EL;
    localb.aq(1);
    return localb;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 0;
    paramParcel.writeIntArray(this.ES);
    paramParcel.writeInt(this.EA);
    paramParcel.writeInt(this.EB);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.EF);
    TextUtils.writeToParcel(this.EG, paramParcel, 0);
    paramParcel.writeInt(this.EH);
    TextUtils.writeToParcel(this.EI, paramParcel, 0);
    paramParcel.writeStringList(this.EJ);
    paramParcel.writeStringList(this.EK);
    if (this.EL) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */