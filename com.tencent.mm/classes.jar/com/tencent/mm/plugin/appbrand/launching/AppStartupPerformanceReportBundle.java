package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fz;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppStartupPerformanceReportBundle
  implements Parcelable, j
{
  public static final Parcelable.Creator<AppStartupPerformanceReportBundle> CREATOR;
  public final String kGa;
  public final List<fz> kHE;
  public final List<kv_14609> kHF;
  public long kHG;
  public long kHH;
  public long kHI;
  public long kHJ;
  public long kHK;
  public long kHL;
  public long kHM;
  public boolean kHN;
  public boolean kHO;
  public long kHr;
  
  static
  {
    AppMethodBeat.i(47157);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47157);
  }
  
  private AppStartupPerformanceReportBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(47156);
    this.kGa = paramParcel.readString();
    this.kHE = new LinkedList();
    int j = paramParcel.readInt();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        this.kHE.add(new fz(paramParcel.readString()));
        i += 1;
      }
    }
    this.kHF = paramParcel.createTypedArrayList(kv_14609.CREATOR);
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.kHN = bool1;
      this.kHr = paramParcel.readLong();
      this.kHG = paramParcel.readLong();
      this.kHH = paramParcel.readLong();
      this.kHI = paramParcel.readLong();
      this.kHJ = paramParcel.readLong();
      this.kHK = paramParcel.readLong();
      if (paramParcel.readByte() <= 0) {
        break label195;
      }
    }
    label195:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.kHO = bool1;
      this.kHL = paramParcel.readLong();
      this.kHM = paramParcel.readLong();
      AppMethodBeat.o(47156);
      return;
      bool1 = false;
      break;
    }
  }
  
  AppStartupPerformanceReportBundle(String paramString)
  {
    AppMethodBeat.i(47155);
    this.kGa = paramString;
    this.kHE = new LinkedList();
    this.kHF = new LinkedList();
    AppMethodBeat.o(47155);
  }
  
  public final boolean bgr()
  {
    AppMethodBeat.i(47153);
    if (this.kHF == null)
    {
      AppMethodBeat.o(47153);
      return false;
    }
    Iterator localIterator = this.kHF.iterator();
    while (localIterator.hasNext())
    {
      kv_14609 localkv_14609 = (kv_14609)localIterator.next();
      if ((localkv_14609 != null) && (localkv_14609.bgr()))
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
    paramParcel.writeString(this.kGa);
    if (bt.gL(this.kHE))
    {
      paramParcel.writeInt(-1);
      paramParcel.writeTypedList(this.kHF);
      if (!this.kHN) {
        break label192;
      }
      paramInt = 1;
      label47:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.kHr);
      paramParcel.writeLong(this.kHG);
      paramParcel.writeLong(this.kHH);
      paramParcel.writeLong(this.kHI);
      paramParcel.writeLong(this.kHJ);
      paramParcel.writeLong(this.kHK);
      if (!this.kHO) {
        break label197;
      }
    }
    label192:
    label197:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.kHL);
      paramParcel.writeLong(this.kHM);
      AppMethodBeat.o(47154);
      return;
      paramParcel.writeInt(this.kHE.size());
      Iterator localIterator = this.kHE.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeString(((fz)localIterator.next()).PV());
      }
      break;
      paramInt = 0;
      break label47;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle
 * JD-Core Version:    0.7.0.1
 */