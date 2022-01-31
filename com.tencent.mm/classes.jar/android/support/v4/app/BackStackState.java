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
  final int mIndex;
  final String mName;
  final int[] vF;
  final int vn;
  final int vo;
  final int vs;
  final CharSequence vt;
  final int vu;
  final CharSequence vv;
  final ArrayList<String> vw;
  final ArrayList<String> vx;
  final boolean vy;
  
  public BackStackState(Parcel paramParcel)
  {
    this.vF = paramParcel.createIntArray();
    this.vn = paramParcel.readInt();
    this.vo = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.vs = paramParcel.readInt();
    this.vt = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.vu = paramParcel.readInt();
    this.vv = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.vw = paramParcel.createStringArrayList();
    this.vx = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.vy = bool;
      return;
    }
  }
  
  public BackStackState(b paramb)
  {
    int k = paramb.vi.size();
    this.vF = new int[k * 6];
    if (!paramb.vp) {
      throw new IllegalStateException("Not on back stack");
    }
    int i = 0;
    int j = 0;
    if (i < k)
    {
      b.a locala = (b.a)paramb.vi.get(i);
      int[] arrayOfInt = this.vF;
      int m = j + 1;
      arrayOfInt[j] = locala.vA;
      arrayOfInt = this.vF;
      int n = m + 1;
      if (locala.fragment != null) {}
      for (j = locala.fragment.mIndex;; j = -1)
      {
        arrayOfInt[m] = j;
        arrayOfInt = this.vF;
        j = n + 1;
        arrayOfInt[n] = locala.vB;
        arrayOfInt = this.vF;
        m = j + 1;
        arrayOfInt[j] = locala.vC;
        arrayOfInt = this.vF;
        n = m + 1;
        arrayOfInt[m] = locala.vD;
        arrayOfInt = this.vF;
        j = n + 1;
        arrayOfInt[n] = locala.vE;
        i += 1;
        break;
      }
    }
    this.vn = paramb.vn;
    this.vo = paramb.vo;
    this.mName = paramb.mName;
    this.mIndex = paramb.mIndex;
    this.vs = paramb.vs;
    this.vt = paramb.vt;
    this.vu = paramb.vu;
    this.vv = paramb.vv;
    this.vw = paramb.vw;
    this.vx = paramb.vx;
    this.vy = paramb.vy;
  }
  
  public final b a(FragmentManagerImpl paramFragmentManagerImpl)
  {
    b localb = new b(paramFragmentManagerImpl);
    int i = 0;
    int j = 0;
    if (j < this.vF.length)
    {
      b.a locala = new b.a();
      int[] arrayOfInt = this.vF;
      int k = j + 1;
      locala.vA = arrayOfInt[j];
      if (FragmentManagerImpl.DEBUG) {
        new StringBuilder("Instantiate ").append(localb).append(" op #").append(i).append(" base fragment #").append(this.vF[k]);
      }
      arrayOfInt = this.vF;
      j = k + 1;
      k = arrayOfInt[k];
      if (k >= 0) {}
      for (locala.fragment = ((Fragment)paramFragmentManagerImpl.mActive.get(k));; locala.fragment = null)
      {
        arrayOfInt = this.vF;
        k = j + 1;
        locala.vB = arrayOfInt[j];
        arrayOfInt = this.vF;
        j = k + 1;
        locala.vC = arrayOfInt[k];
        arrayOfInt = this.vF;
        k = j + 1;
        locala.vD = arrayOfInt[j];
        arrayOfInt = this.vF;
        j = k + 1;
        locala.vE = arrayOfInt[k];
        localb.vj = locala.vB;
        localb.vk = locala.vC;
        localb.vl = locala.vD;
        localb.vm = locala.vE;
        localb.a(locala);
        i += 1;
        break;
      }
    }
    localb.vn = this.vn;
    localb.vo = this.vo;
    localb.mName = this.mName;
    localb.mIndex = this.mIndex;
    localb.vp = true;
    localb.vs = this.vs;
    localb.vt = this.vt;
    localb.vu = this.vu;
    localb.vv = this.vv;
    localb.vw = this.vw;
    localb.vx = this.vx;
    localb.vy = this.vy;
    localb.W(1);
    return localb;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 0;
    paramParcel.writeIntArray(this.vF);
    paramParcel.writeInt(this.vn);
    paramParcel.writeInt(this.vo);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.vs);
    TextUtils.writeToParcel(this.vt, paramParcel, 0);
    paramParcel.writeInt(this.vu);
    TextUtils.writeToParcel(this.vv, paramParcel, 0);
    paramParcel.writeStringList(this.vw);
    paramParcel.writeStringList(this.vx);
    if (this.vy) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */