package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ix;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppStartupPerformanceReportBundle
  implements Parcelable, j
{
  public static final Parcelable.Creator<AppStartupPerformanceReportBundle> CREATOR;
  public final String lIU;
  public final List<ix> lKE;
  public final List<kv_14609> lKF;
  public long lKG;
  public long lKH;
  public long lKI;
  public long lKJ;
  public long lKK;
  public long lKL;
  public long lKM;
  public int lKN;
  public boolean lKO;
  public boolean lKP;
  public long lKp;
  
  static
  {
    AppMethodBeat.i(47157);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47157);
  }
  
  private AppStartupPerformanceReportBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(47156);
    this.lIU = paramParcel.readString();
    this.lKE = new LinkedList();
    int j = paramParcel.readInt();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        this.lKE.add(new ix(paramParcel.readString()));
        i += 1;
      }
    }
    this.lKF = paramParcel.createTypedArrayList(kv_14609.CREATOR);
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.lKO = bool1;
      this.lKp = paramParcel.readLong();
      this.lKG = paramParcel.readLong();
      this.lKH = paramParcel.readLong();
      this.lKI = paramParcel.readLong();
      this.lKJ = paramParcel.readLong();
      this.lKK = paramParcel.readLong();
      if (paramParcel.readByte() <= 0) {
        break label203;
      }
    }
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.lKP = bool1;
      this.lKL = paramParcel.readLong();
      this.lKM = paramParcel.readLong();
      this.lKN = paramParcel.readInt();
      AppMethodBeat.o(47156);
      return;
      bool1 = false;
      break;
    }
  }
  
  AppStartupPerformanceReportBundle(String paramString)
  {
    AppMethodBeat.i(47155);
    this.lIU = paramString;
    this.lKE = new LinkedList();
    this.lKF = new LinkedList();
    AppMethodBeat.o(47155);
  }
  
  public final boolean brH()
  {
    AppMethodBeat.i(47153);
    if (this.lKF == null)
    {
      AppMethodBeat.o(47153);
      return false;
    }
    Iterator localIterator = this.lKF.iterator();
    while (localIterator.hasNext())
    {
      kv_14609 localkv_14609 = (kv_14609)localIterator.next();
      if ((localkv_14609 != null) && (localkv_14609.brH()))
      {
        AppMethodBeat.o(47153);
        return true;
      }
    }
    AppMethodBeat.o(47153);
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(47154);
    paramParcel.writeString(this.lIU);
    if (bu.ht(this.lKE))
    {
      paramParcel.writeInt(-1);
      paramParcel.writeTypedList(this.lKF);
      if (!this.lKO) {
        break label200;
      }
      paramInt = 1;
      label47:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.lKp);
      paramParcel.writeLong(this.lKG);
      paramParcel.writeLong(this.lKH);
      paramParcel.writeLong(this.lKI);
      paramParcel.writeLong(this.lKJ);
      paramParcel.writeLong(this.lKK);
      if (!this.lKP) {
        break label205;
      }
    }
    label200:
    label205:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.lKL);
      paramParcel.writeLong(this.lKM);
      paramParcel.writeInt(this.lKN);
      AppMethodBeat.o(47154);
      return;
      paramParcel.writeInt(this.lKE.size());
      Iterator localIterator = this.lKE.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeString(((ix)localIterator.next()).RC());
      }
      break;
      paramInt = 0;
      break label47;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle
 * JD-Core Version:    0.7.0.1
 */