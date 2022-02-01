package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.tl;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppStartupPerformanceReportBundle
  implements Parcelable, m
{
  public static final Parcelable.Creator<AppStartupPerformanceReportBundle> CREATOR;
  public final String eup;
  public long sXY;
  public long sYA;
  public long sYB;
  public long sYC;
  public long sYD;
  public long sYE;
  public int sYF;
  public boolean sYG;
  public boolean sYH;
  public boolean sYI;
  public final List<tl> sYu;
  public final List<kv_14609> sYv;
  public long sYw;
  public long sYx;
  public long sYy;
  public long sYz;
  
  static
  {
    AppMethodBeat.i(47157);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47157);
  }
  
  private AppStartupPerformanceReportBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(47156);
    this.eup = paramParcel.readString();
    this.sYu = new LinkedList();
    int j = paramParcel.readInt();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        this.sYu.add(new tl(paramParcel.readString()));
        i += 1;
      }
    }
    this.sYv = paramParcel.createTypedArrayList(kv_14609.CREATOR);
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.sYG = bool1;
      this.sXY = paramParcel.readLong();
      this.sYw = paramParcel.readLong();
      this.sYx = paramParcel.readLong();
      this.sYy = paramParcel.readLong();
      this.sYz = paramParcel.readLong();
      this.sYA = paramParcel.readLong();
      if (paramParcel.readByte() <= 0) {
        break label219;
      }
      bool1 = true;
      label160:
      this.sYH = bool1;
      if (paramParcel.readByte() <= 0) {
        break label225;
      }
    }
    label219:
    label225:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.sYI = bool1;
      this.sYB = paramParcel.readLong();
      this.sYC = paramParcel.readLong();
      this.sYF = paramParcel.readInt();
      AppMethodBeat.o(47156);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label160;
    }
  }
  
  AppStartupPerformanceReportBundle(String paramString)
  {
    AppMethodBeat.i(47155);
    this.eup = paramString;
    this.sYu = new LinkedList();
    this.sYv = new LinkedList();
    AppMethodBeat.o(47155);
  }
  
  public final boolean czT()
  {
    AppMethodBeat.i(47153);
    if (this.sYv == null)
    {
      AppMethodBeat.o(47153);
      return false;
    }
    Iterator localIterator = this.sYv.iterator();
    while (localIterator.hasNext())
    {
      kv_14609 localkv_14609 = (kv_14609)localIterator.next();
      if ((localkv_14609 != null) && (localkv_14609.czT()))
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
    paramParcel.writeString(this.eup);
    if (Util.isNullOrNil(this.sYu))
    {
      paramParcel.writeInt(-1);
      paramParcel.writeTypedList(this.sYv);
      if (!this.sYG) {
        break label215;
      }
      paramInt = 1;
      label47:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.sXY);
      paramParcel.writeLong(this.sYw);
      paramParcel.writeLong(this.sYx);
      paramParcel.writeLong(this.sYy);
      paramParcel.writeLong(this.sYz);
      paramParcel.writeLong(this.sYA);
      if (!this.sYH) {
        break label220;
      }
      paramInt = 1;
      label110:
      paramParcel.writeByte((byte)paramInt);
      if (!this.sYI) {
        break label225;
      }
    }
    label215:
    label220:
    label225:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.sYB);
      paramParcel.writeLong(this.sYC);
      paramParcel.writeInt(this.sYF);
      AppMethodBeat.o(47154);
      return;
      paramParcel.writeInt(this.sYu.size());
      Iterator localIterator = this.sYu.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeString(((tl)localIterator.next()).aIE());
      }
      break;
      paramInt = 0;
      break label47;
      paramInt = 0;
      break label110;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle
 * JD-Core Version:    0.7.0.1
 */