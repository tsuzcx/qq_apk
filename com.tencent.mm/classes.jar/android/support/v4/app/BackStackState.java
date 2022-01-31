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
  final boolean uA;
  final int[] uI;
  final int un;
  final int uo;
  final int uu;
  final CharSequence uv;
  final int uw;
  final CharSequence ux;
  final ArrayList<String> uy;
  final ArrayList<String> uz;
  
  public BackStackState(Parcel paramParcel)
  {
    this.uI = paramParcel.createIntArray();
    this.un = paramParcel.readInt();
    this.uo = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.uu = paramParcel.readInt();
    this.uv = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.uw = paramParcel.readInt();
    this.ux = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.uy = paramParcel.createStringArrayList();
    this.uz = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.uA = bool;
      return;
    }
  }
  
  public BackStackState(b paramb)
  {
    int k = paramb.uh.size();
    this.uI = new int[k * 6];
    if (!paramb.uq) {
      throw new IllegalStateException("Not on back stack");
    }
    int i = 0;
    int j = 0;
    if (i < k)
    {
      b.a locala = (b.a)paramb.uh.get(i);
      int[] arrayOfInt = this.uI;
      int m = j + 1;
      arrayOfInt[j] = locala.uC;
      arrayOfInt = this.uI;
      int n = m + 1;
      if (locala.uD != null) {}
      for (j = locala.uD.mIndex;; j = -1)
      {
        arrayOfInt[m] = j;
        arrayOfInt = this.uI;
        j = n + 1;
        arrayOfInt[n] = locala.uE;
        arrayOfInt = this.uI;
        m = j + 1;
        arrayOfInt[j] = locala.uF;
        arrayOfInt = this.uI;
        n = m + 1;
        arrayOfInt[m] = locala.uG;
        arrayOfInt = this.uI;
        j = n + 1;
        arrayOfInt[n] = locala.uH;
        i += 1;
        break;
      }
    }
    this.un = paramb.un;
    this.uo = paramb.uo;
    this.mName = paramb.mName;
    this.mIndex = paramb.mIndex;
    this.uu = paramb.uu;
    this.uv = paramb.uv;
    this.uw = paramb.uw;
    this.ux = paramb.ux;
    this.uy = paramb.uy;
    this.uz = paramb.uz;
    this.uA = paramb.uA;
  }
  
  public final b a(k paramk)
  {
    b localb = new b(paramk);
    int i = 0;
    int j = 0;
    if (j < this.uI.length)
    {
      b.a locala = new b.a();
      int[] arrayOfInt = this.uI;
      int k = j + 1;
      locala.uC = arrayOfInt[j];
      if (k.DEBUG) {
        new StringBuilder("Instantiate ").append(localb).append(" op #").append(i).append(" base fragment #").append(this.uI[k]);
      }
      arrayOfInt = this.uI;
      j = k + 1;
      k = arrayOfInt[k];
      if (k >= 0) {}
      for (locala.uD = ((Fragment)paramk.vr.get(k));; locala.uD = null)
      {
        arrayOfInt = this.uI;
        k = j + 1;
        locala.uE = arrayOfInt[j];
        arrayOfInt = this.uI;
        j = k + 1;
        locala.uF = arrayOfInt[k];
        arrayOfInt = this.uI;
        k = j + 1;
        locala.uG = arrayOfInt[j];
        arrayOfInt = this.uI;
        j = k + 1;
        locala.uH = arrayOfInt[k];
        localb.uj = locala.uE;
        localb.uk = locala.uF;
        localb.ul = locala.uG;
        localb.um = locala.uH;
        localb.a(locala);
        i += 1;
        break;
      }
    }
    localb.un = this.un;
    localb.uo = this.uo;
    localb.mName = this.mName;
    localb.mIndex = this.mIndex;
    localb.uq = true;
    localb.uu = this.uu;
    localb.uv = this.uv;
    localb.uw = this.uw;
    localb.ux = this.ux;
    localb.uy = this.uy;
    localb.uz = this.uz;
    localb.uA = this.uA;
    localb.X(1);
    return localb;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 0;
    paramParcel.writeIntArray(this.uI);
    paramParcel.writeInt(this.un);
    paramParcel.writeInt(this.uo);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.uu);
    TextUtils.writeToParcel(this.uv, paramParcel, 0);
    paramParcel.writeInt(this.uw);
    TextUtils.writeToParcel(this.ux, paramParcel, 0);
    paramParcel.writeStringList(this.uy);
    paramParcel.writeStringList(this.uz);
    if (this.uA) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */