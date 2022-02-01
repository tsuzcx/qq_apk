package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppStartupPerformanceReportBundle
  implements Parcelable, j
{
  public static final Parcelable.Creator<AppStartupPerformanceReportBundle> CREATOR;
  public final String lht;
  public long liL;
  public final List<hr> liY;
  public final List<kv_14609> liZ;
  public long lja;
  public long ljb;
  public long ljc;
  public long ljd;
  public long lje;
  public long ljf;
  public long ljg;
  public boolean ljh;
  public boolean lji;
  
  static
  {
    AppMethodBeat.i(47157);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47157);
  }
  
  private AppStartupPerformanceReportBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(47156);
    this.lht = paramParcel.readString();
    this.liY = new LinkedList();
    int j = paramParcel.readInt();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        this.liY.add(new hr(paramParcel.readString()));
        i += 1;
      }
    }
    this.liZ = paramParcel.createTypedArrayList(kv_14609.CREATOR);
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.ljh = bool1;
      this.liL = paramParcel.readLong();
      this.lja = paramParcel.readLong();
      this.ljb = paramParcel.readLong();
      this.ljc = paramParcel.readLong();
      this.ljd = paramParcel.readLong();
      this.lje = paramParcel.readLong();
      if (paramParcel.readByte() <= 0) {
        break label195;
      }
    }
    label195:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.lji = bool1;
      this.ljf = paramParcel.readLong();
      this.ljg = paramParcel.readLong();
      AppMethodBeat.o(47156);
      return;
      bool1 = false;
      break;
    }
  }
  
  AppStartupPerformanceReportBundle(String paramString)
  {
    AppMethodBeat.i(47155);
    this.lht = paramString;
    this.liY = new LinkedList();
    this.liZ = new LinkedList();
    AppMethodBeat.o(47155);
  }
  
  public final boolean bnl()
  {
    AppMethodBeat.i(47153);
    if (this.liZ == null)
    {
      AppMethodBeat.o(47153);
      return false;
    }
    Iterator localIterator = this.liZ.iterator();
    while (localIterator.hasNext())
    {
      kv_14609 localkv_14609 = (kv_14609)localIterator.next();
      if ((localkv_14609 != null) && (localkv_14609.bnl()))
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
    paramParcel.writeString(this.lht);
    if (bs.gY(this.liY))
    {
      paramParcel.writeInt(-1);
      paramParcel.writeTypedList(this.liZ);
      if (!this.ljh) {
        break label192;
      }
      paramInt = 1;
      label47:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.liL);
      paramParcel.writeLong(this.lja);
      paramParcel.writeLong(this.ljb);
      paramParcel.writeLong(this.ljc);
      paramParcel.writeLong(this.ljd);
      paramParcel.writeLong(this.lje);
      if (!this.lji) {
        break label197;
      }
    }
    label192:
    label197:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.ljf);
      paramParcel.writeLong(this.ljg);
      AppMethodBeat.o(47154);
      return;
      paramParcel.writeInt(this.liY.size());
      Iterator localIterator = this.liY.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeString(((hr)localIterator.next()).PR());
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