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
  final int BK;
  final int BL;
  final int BP;
  final CharSequence BQ;
  final int BR;
  final CharSequence BS;
  final ArrayList<String> BT;
  final ArrayList<String> BU;
  final boolean BV;
  final int[] Cc;
  final int mIndex;
  final String mName;
  
  public BackStackState(Parcel paramParcel)
  {
    this.Cc = paramParcel.createIntArray();
    this.BK = paramParcel.readInt();
    this.BL = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.BP = paramParcel.readInt();
    this.BQ = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.BR = paramParcel.readInt();
    this.BS = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.BT = paramParcel.createStringArrayList();
    this.BU = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.BV = bool;
      return;
    }
  }
  
  public BackStackState(b paramb)
  {
    int k = paramb.BF.size();
    this.Cc = new int[k * 6];
    if (!paramb.BM) {
      throw new IllegalStateException("Not on back stack");
    }
    int i = 0;
    int j = 0;
    if (i < k)
    {
      b.a locala = (b.a)paramb.BF.get(i);
      int[] arrayOfInt = this.Cc;
      int m = j + 1;
      arrayOfInt[j] = locala.BX;
      arrayOfInt = this.Cc;
      int n = m + 1;
      if (locala.fragment != null) {}
      for (j = locala.fragment.mIndex;; j = -1)
      {
        arrayOfInt[m] = j;
        arrayOfInt = this.Cc;
        j = n + 1;
        arrayOfInt[n] = locala.BY;
        arrayOfInt = this.Cc;
        m = j + 1;
        arrayOfInt[j] = locala.BZ;
        arrayOfInt = this.Cc;
        n = m + 1;
        arrayOfInt[m] = locala.Ca;
        arrayOfInt = this.Cc;
        j = n + 1;
        arrayOfInt[n] = locala.Cb;
        i += 1;
        break;
      }
    }
    this.BK = paramb.BK;
    this.BL = paramb.BL;
    this.mName = paramb.mName;
    this.mIndex = paramb.mIndex;
    this.BP = paramb.BP;
    this.BQ = paramb.BQ;
    this.BR = paramb.BR;
    this.BS = paramb.BS;
    this.BT = paramb.BT;
    this.BU = paramb.BU;
    this.BV = paramb.BV;
  }
  
  public final b a(FragmentManagerImpl paramFragmentManagerImpl)
  {
    b localb = new b(paramFragmentManagerImpl);
    int i = 0;
    int j = 0;
    if (j < this.Cc.length)
    {
      b.a locala = new b.a();
      int[] arrayOfInt = this.Cc;
      int k = j + 1;
      locala.BX = arrayOfInt[j];
      if (FragmentManagerImpl.DEBUG) {
        new StringBuilder("Instantiate ").append(localb).append(" op #").append(i).append(" base fragment #").append(this.Cc[k]);
      }
      arrayOfInt = this.Cc;
      j = k + 1;
      k = arrayOfInt[k];
      if (k >= 0) {}
      for (locala.fragment = ((Fragment)paramFragmentManagerImpl.mActive.get(k));; locala.fragment = null)
      {
        arrayOfInt = this.Cc;
        k = j + 1;
        locala.BY = arrayOfInt[j];
        arrayOfInt = this.Cc;
        j = k + 1;
        locala.BZ = arrayOfInt[k];
        arrayOfInt = this.Cc;
        k = j + 1;
        locala.Ca = arrayOfInt[j];
        arrayOfInt = this.Cc;
        j = k + 1;
        locala.Cb = arrayOfInt[k];
        localb.BG = locala.BY;
        localb.BH = locala.BZ;
        localb.BI = locala.Ca;
        localb.BJ = locala.Cb;
        localb.a(locala);
        i += 1;
        break;
      }
    }
    localb.BK = this.BK;
    localb.BL = this.BL;
    localb.mName = this.mName;
    localb.mIndex = this.mIndex;
    localb.BM = true;
    localb.BP = this.BP;
    localb.BQ = this.BQ;
    localb.BR = this.BR;
    localb.BS = this.BS;
    localb.BT = this.BT;
    localb.BU = this.BU;
    localb.BV = this.BV;
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
    paramParcel.writeIntArray(this.Cc);
    paramParcel.writeInt(this.BK);
    paramParcel.writeInt(this.BL);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.BP);
    TextUtils.writeToParcel(this.BQ, paramParcel, 0);
    paramParcel.writeInt(this.BR);
    TextUtils.writeToParcel(this.BS, paramParcel, 0);
    paramParcel.writeStringList(this.BT);
    paramParcel.writeStringList(this.BU);
    if (this.BV) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */