package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.iv;
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
  public final String lEv;
  public long lFQ;
  public final List<iv> lGe;
  public final List<kv_14609> lGf;
  public long lGg;
  public long lGh;
  public long lGi;
  public long lGj;
  public long lGk;
  public long lGl;
  public long lGm;
  public int lGn;
  public boolean lGo;
  public boolean lGp;
  
  static
  {
    AppMethodBeat.i(47157);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47157);
  }
  
  private AppStartupPerformanceReportBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(47156);
    this.lEv = paramParcel.readString();
    this.lGe = new LinkedList();
    int j = paramParcel.readInt();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        this.lGe.add(new iv(paramParcel.readString()));
        i += 1;
      }
    }
    this.lGf = paramParcel.createTypedArrayList(kv_14609.CREATOR);
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.lGo = bool1;
      this.lFQ = paramParcel.readLong();
      this.lGg = paramParcel.readLong();
      this.lGh = paramParcel.readLong();
      this.lGi = paramParcel.readLong();
      this.lGj = paramParcel.readLong();
      this.lGk = paramParcel.readLong();
      if (paramParcel.readByte() <= 0) {
        break label203;
      }
    }
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.lGp = bool1;
      this.lGl = paramParcel.readLong();
      this.lGm = paramParcel.readLong();
      this.lGn = paramParcel.readInt();
      AppMethodBeat.o(47156);
      return;
      bool1 = false;
      break;
    }
  }
  
  AppStartupPerformanceReportBundle(String paramString)
  {
    AppMethodBeat.i(47155);
    this.lEv = paramString;
    this.lGe = new LinkedList();
    this.lGf = new LinkedList();
    AppMethodBeat.o(47155);
  }
  
  public final boolean bqX()
  {
    AppMethodBeat.i(47153);
    if (this.lGf == null)
    {
      AppMethodBeat.o(47153);
      return false;
    }
    Iterator localIterator = this.lGf.iterator();
    while (localIterator.hasNext())
    {
      kv_14609 localkv_14609 = (kv_14609)localIterator.next();
      if ((localkv_14609 != null) && (localkv_14609.bqX()))
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
    paramParcel.writeString(this.lEv);
    if (bt.hj(this.lGe))
    {
      paramParcel.writeInt(-1);
      paramParcel.writeTypedList(this.lGf);
      if (!this.lGo) {
        break label200;
      }
      paramInt = 1;
      label47:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.lFQ);
      paramParcel.writeLong(this.lGg);
      paramParcel.writeLong(this.lGh);
      paramParcel.writeLong(this.lGi);
      paramParcel.writeLong(this.lGj);
      paramParcel.writeLong(this.lGk);
      if (!this.lGp) {
        break label205;
      }
    }
    label200:
    label205:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.lGl);
      paramParcel.writeLong(this.lGm);
      paramParcel.writeInt(this.lGn);
      AppMethodBeat.o(47154);
      return;
      paramParcel.writeInt(this.lGe.size());
      Iterator localIterator = this.lGe.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeString(((iv)localIterator.next()).RD());
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