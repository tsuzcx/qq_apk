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
  final int EK;
  final int EL;
  final int EP;
  final CharSequence EQ;
  final int ER;
  final CharSequence ES;
  final ArrayList<String> ET;
  final ArrayList<String> EU;
  final boolean EV;
  final int[] Fc;
  final int mIndex;
  final String mName;
  
  public BackStackState(Parcel paramParcel)
  {
    this.Fc = paramParcel.createIntArray();
    this.EK = paramParcel.readInt();
    this.EL = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.EP = paramParcel.readInt();
    this.EQ = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.ER = paramParcel.readInt();
    this.ES = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.ET = paramParcel.createStringArrayList();
    this.EU = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.EV = bool;
      return;
    }
  }
  
  public BackStackState(b paramb)
  {
    int k = paramb.EF.size();
    this.Fc = new int[k * 6];
    if (!paramb.EM) {
      throw new IllegalStateException("Not on back stack");
    }
    int i = 0;
    int j = 0;
    if (i < k)
    {
      b.a locala = (b.a)paramb.EF.get(i);
      int[] arrayOfInt = this.Fc;
      int m = j + 1;
      arrayOfInt[j] = locala.EX;
      arrayOfInt = this.Fc;
      int n = m + 1;
      if (locala.fragment != null) {}
      for (j = locala.fragment.mIndex;; j = -1)
      {
        arrayOfInt[m] = j;
        arrayOfInt = this.Fc;
        j = n + 1;
        arrayOfInt[n] = locala.EY;
        arrayOfInt = this.Fc;
        m = j + 1;
        arrayOfInt[j] = locala.EZ;
        arrayOfInt = this.Fc;
        n = m + 1;
        arrayOfInt[m] = locala.Fa;
        arrayOfInt = this.Fc;
        j = n + 1;
        arrayOfInt[n] = locala.Fb;
        i += 1;
        break;
      }
    }
    this.EK = paramb.EK;
    this.EL = paramb.EL;
    this.mName = paramb.mName;
    this.mIndex = paramb.mIndex;
    this.EP = paramb.EP;
    this.EQ = paramb.EQ;
    this.ER = paramb.ER;
    this.ES = paramb.ES;
    this.ET = paramb.ET;
    this.EU = paramb.EU;
    this.EV = paramb.EV;
  }
  
  public final b a(FragmentManagerImpl paramFragmentManagerImpl)
  {
    b localb = new b(paramFragmentManagerImpl);
    int i = 0;
    int j = 0;
    if (j < this.Fc.length)
    {
      b.a locala = new b.a();
      int[] arrayOfInt = this.Fc;
      int k = j + 1;
      locala.EX = arrayOfInt[j];
      if (FragmentManagerImpl.DEBUG) {
        new StringBuilder("Instantiate ").append(localb).append(" op #").append(i).append(" base fragment #").append(this.Fc[k]);
      }
      arrayOfInt = this.Fc;
      j = k + 1;
      k = arrayOfInt[k];
      if (k >= 0) {}
      for (locala.fragment = ((Fragment)paramFragmentManagerImpl.mActive.get(k));; locala.fragment = null)
      {
        arrayOfInt = this.Fc;
        k = j + 1;
        locala.EY = arrayOfInt[j];
        arrayOfInt = this.Fc;
        j = k + 1;
        locala.EZ = arrayOfInt[k];
        arrayOfInt = this.Fc;
        k = j + 1;
        locala.Fa = arrayOfInt[j];
        arrayOfInt = this.Fc;
        j = k + 1;
        locala.Fb = arrayOfInt[k];
        localb.EG = locala.EY;
        localb.EH = locala.EZ;
        localb.EI = locala.Fa;
        localb.EJ = locala.Fb;
        localb.a(locala);
        i += 1;
        break;
      }
    }
    localb.EK = this.EK;
    localb.EL = this.EL;
    localb.mName = this.mName;
    localb.mIndex = this.mIndex;
    localb.EM = true;
    localb.EP = this.EP;
    localb.EQ = this.EQ;
    localb.ER = this.ER;
    localb.ES = this.ES;
    localb.ET = this.ET;
    localb.EU = this.EU;
    localb.EV = this.EV;
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
    paramParcel.writeIntArray(this.Fc);
    paramParcel.writeInt(this.EK);
    paramParcel.writeInt(this.EL);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.EP);
    TextUtils.writeToParcel(this.EQ, paramParcel, 0);
    paramParcel.writeInt(this.ER);
    TextUtils.writeToParcel(this.ES, paramParcel, 0);
    paramParcel.writeStringList(this.ET);
    paramParcel.writeStringList(this.EU);
    if (this.EV) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */