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
  final int CI;
  final int CJ;
  final int CN;
  final CharSequence CO;
  final int CQ;
  final CharSequence CR;
  final ArrayList<String> CS;
  final ArrayList<String> CT;
  final boolean CU;
  final int[] Db;
  final int mIndex;
  final String mName;
  
  public BackStackState(Parcel paramParcel)
  {
    this.Db = paramParcel.createIntArray();
    this.CI = paramParcel.readInt();
    this.CJ = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.CN = paramParcel.readInt();
    this.CO = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.CQ = paramParcel.readInt();
    this.CR = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.CS = paramParcel.createStringArrayList();
    this.CT = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.CU = bool;
      return;
    }
  }
  
  public BackStackState(b paramb)
  {
    int k = paramb.CD.size();
    this.Db = new int[k * 6];
    if (!paramb.CK) {
      throw new IllegalStateException("Not on back stack");
    }
    int i = 0;
    int j = 0;
    if (i < k)
    {
      b.a locala = (b.a)paramb.CD.get(i);
      int[] arrayOfInt = this.Db;
      int m = j + 1;
      arrayOfInt[j] = locala.CW;
      arrayOfInt = this.Db;
      int n = m + 1;
      if (locala.fragment != null) {}
      for (j = locala.fragment.mIndex;; j = -1)
      {
        arrayOfInt[m] = j;
        arrayOfInt = this.Db;
        j = n + 1;
        arrayOfInt[n] = locala.CX;
        arrayOfInt = this.Db;
        m = j + 1;
        arrayOfInt[j] = locala.CY;
        arrayOfInt = this.Db;
        n = m + 1;
        arrayOfInt[m] = locala.CZ;
        arrayOfInt = this.Db;
        j = n + 1;
        arrayOfInt[n] = locala.Da;
        i += 1;
        break;
      }
    }
    this.CI = paramb.CI;
    this.CJ = paramb.CJ;
    this.mName = paramb.mName;
    this.mIndex = paramb.mIndex;
    this.CN = paramb.CN;
    this.CO = paramb.CO;
    this.CQ = paramb.CQ;
    this.CR = paramb.CR;
    this.CS = paramb.CS;
    this.CT = paramb.CT;
    this.CU = paramb.CU;
  }
  
  public final b a(FragmentManagerImpl paramFragmentManagerImpl)
  {
    b localb = new b(paramFragmentManagerImpl);
    int i = 0;
    int j = 0;
    if (j < this.Db.length)
    {
      b.a locala = new b.a();
      int[] arrayOfInt = this.Db;
      int k = j + 1;
      locala.CW = arrayOfInt[j];
      if (FragmentManagerImpl.DEBUG) {
        new StringBuilder("Instantiate ").append(localb).append(" op #").append(i).append(" base fragment #").append(this.Db[k]);
      }
      arrayOfInt = this.Db;
      j = k + 1;
      k = arrayOfInt[k];
      if (k >= 0) {}
      for (locala.fragment = ((Fragment)paramFragmentManagerImpl.mActive.get(k));; locala.fragment = null)
      {
        arrayOfInt = this.Db;
        k = j + 1;
        locala.CX = arrayOfInt[j];
        arrayOfInt = this.Db;
        j = k + 1;
        locala.CY = arrayOfInt[k];
        arrayOfInt = this.Db;
        k = j + 1;
        locala.CZ = arrayOfInt[j];
        arrayOfInt = this.Db;
        j = k + 1;
        locala.Da = arrayOfInt[k];
        localb.CE = locala.CX;
        localb.CF = locala.CY;
        localb.CG = locala.CZ;
        localb.CH = locala.Da;
        localb.a(locala);
        i += 1;
        break;
      }
    }
    localb.CI = this.CI;
    localb.CJ = this.CJ;
    localb.mName = this.mName;
    localb.mIndex = this.mIndex;
    localb.CK = true;
    localb.CN = this.CN;
    localb.CO = this.CO;
    localb.CQ = this.CQ;
    localb.CR = this.CR;
    localb.CS = this.CS;
    localb.CT = this.CT;
    localb.CU = this.CU;
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
    paramParcel.writeIntArray(this.Db);
    paramParcel.writeInt(this.CI);
    paramParcel.writeInt(this.CJ);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.CN);
    TextUtils.writeToParcel(this.CO, paramParcel, 0);
    paramParcel.writeInt(this.CQ);
    TextUtils.writeToParcel(this.CR, paramParcel, 0);
    paramParcel.writeStringList(this.CS);
    paramParcel.writeStringList(this.CT);
    if (this.CU) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */