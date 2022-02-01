package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.lifecycle.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR;
  final int[] bBf;
  final ArrayList<String> bBg;
  final int[] bBh;
  final int[] bBi;
  final int bBj;
  final int bBk;
  final CharSequence bBl;
  final int bBm;
  final CharSequence bBn;
  final ArrayList<String> bBo;
  final ArrayList<String> bBp;
  final boolean bBq;
  final int mIndex;
  final String mName;
  
  static
  {
    AppMethodBeat.i(193904);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(193904);
  }
  
  public BackStackState(Parcel paramParcel)
  {
    AppMethodBeat.i(193900);
    this.bBf = paramParcel.createIntArray();
    this.bBg = paramParcel.createStringArrayList();
    this.bBh = paramParcel.createIntArray();
    this.bBi = paramParcel.createIntArray();
    this.bBj = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.bBk = paramParcel.readInt();
    this.bBl = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.bBm = paramParcel.readInt();
    this.bBn = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.bBo = paramParcel.createStringArrayList();
    this.bBp = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.bBq = bool;
      AppMethodBeat.o(193900);
      return;
    }
  }
  
  public BackStackState(a parama)
  {
    AppMethodBeat.i(193893);
    int k = parama.bDF.size();
    this.bBf = new int[k * 5];
    if (!parama.bDG)
    {
      parama = new IllegalStateException("Not on back stack");
      AppMethodBeat.o(193893);
      throw parama;
    }
    this.bBg = new ArrayList(k);
    this.bBh = new int[k];
    this.bBi = new int[k];
    int i = 0;
    int j = 0;
    if (i < k)
    {
      r.a locala = (r.a)parama.bDF.get(i);
      Object localObject = this.bBf;
      int m = j + 1;
      localObject[j] = locala.bDJ;
      ArrayList localArrayList = this.bBg;
      if (locala.bDv != null) {}
      for (localObject = locala.bDv.mWho;; localObject = null)
      {
        localArrayList.add(localObject);
        localObject = this.bBf;
        j = m + 1;
        localObject[m] = locala.bCa;
        localObject = this.bBf;
        m = j + 1;
        localObject[j] = locala.bCb;
        localObject = this.bBf;
        int n = m + 1;
        localObject[m] = locala.bCc;
        localObject = this.bBf;
        j = n + 1;
        localObject[n] = locala.bCd;
        this.bBh[i] = locala.bDK.ordinal();
        this.bBi[i] = locala.bDL.ordinal();
        i += 1;
        break;
      }
    }
    this.bBj = parama.bBj;
    this.mName = parama.mName;
    this.mIndex = parama.mIndex;
    this.bBk = parama.bBk;
    this.bBl = parama.bBl;
    this.bBm = parama.bBm;
    this.bBn = parama.bBn;
    this.bBo = parama.bBo;
    this.bBp = parama.bBp;
    this.bBq = parama.bBq;
    AppMethodBeat.o(193893);
  }
  
  public final a a(FragmentManager paramFragmentManager)
  {
    AppMethodBeat.i(193917);
    a locala = new a(paramFragmentManager);
    int i = 0;
    int j = 0;
    if (j < this.bBf.length)
    {
      r.a locala1 = new r.a();
      Object localObject = this.bBf;
      int k = j + 1;
      locala1.bDJ = localObject[j];
      if (FragmentManager.isLoggingEnabled(2)) {
        new StringBuilder("Instantiate ").append(locala).append(" op #").append(i).append(" base fragment #").append(this.bBf[k]);
      }
      localObject = (String)this.bBg.get(i);
      if (localObject != null) {}
      for (locala1.bDv = paramFragmentManager.findActiveFragment((String)localObject);; locala1.bDv = null)
      {
        locala1.bDK = j.b.values()[this.bBh[i]];
        locala1.bDL = j.b.values()[this.bBi[i]];
        localObject = this.bBf;
        j = k + 1;
        locala1.bCa = localObject[k];
        localObject = this.bBf;
        k = j + 1;
        locala1.bCb = localObject[j];
        localObject = this.bBf;
        int m = k + 1;
        locala1.bCc = localObject[k];
        localObject = this.bBf;
        j = m + 1;
        locala1.bCd = localObject[m];
        locala.bCa = locala1.bCa;
        locala.bCb = locala1.bCb;
        locala.bCc = locala1.bCc;
        locala.bCd = locala1.bCd;
        locala.b(locala1);
        i += 1;
        break;
      }
    }
    locala.bBj = this.bBj;
    locala.mName = this.mName;
    locala.mIndex = this.mIndex;
    locala.bDG = true;
    locala.bBk = this.bBk;
    locala.bBl = this.bBl;
    locala.bBm = this.bBm;
    locala.bBn = this.bBn;
    locala.bBo = this.bBo;
    locala.bBp = this.bBp;
    locala.bBq = this.bBq;
    locala.eS(1);
    AppMethodBeat.o(193917);
    return locala;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 0;
    AppMethodBeat.i(193933);
    paramParcel.writeIntArray(this.bBf);
    paramParcel.writeStringList(this.bBg);
    paramParcel.writeIntArray(this.bBh);
    paramParcel.writeIntArray(this.bBi);
    paramParcel.writeInt(this.bBj);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.bBk);
    TextUtils.writeToParcel(this.bBl, paramParcel, 0);
    paramParcel.writeInt(this.bBm);
    TextUtils.writeToParcel(this.bBn, paramParcel, 0);
    paramParcel.writeStringList(this.bBo);
    paramParcel.writeStringList(this.bBp);
    if (this.bBq) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
    AppMethodBeat.o(193933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */