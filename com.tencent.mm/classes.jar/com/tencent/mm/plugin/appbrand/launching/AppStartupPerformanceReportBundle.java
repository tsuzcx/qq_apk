package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ps;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppStartupPerformanceReportBundle
  implements Parcelable, l
{
  public static final Parcelable.Creator<AppStartupPerformanceReportBundle> CREATOR;
  public final String cBH;
  public long pSY;
  public long pTA;
  public int pTB;
  public boolean pTC;
  public boolean pTD;
  public boolean pTE;
  public final List<ps> pTq;
  public final List<kv_14609> pTr;
  public long pTs;
  public long pTt;
  public long pTu;
  public long pTv;
  public long pTw;
  public long pTx;
  public long pTy;
  public long pTz;
  
  static
  {
    AppMethodBeat.i(47157);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47157);
  }
  
  private AppStartupPerformanceReportBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(47156);
    this.cBH = paramParcel.readString();
    this.pTq = new LinkedList();
    int j = paramParcel.readInt();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        this.pTq.add(new ps(paramParcel.readString()));
        i += 1;
      }
    }
    this.pTr = paramParcel.createTypedArrayList(kv_14609.CREATOR);
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.pTC = bool1;
      this.pSY = paramParcel.readLong();
      this.pTs = paramParcel.readLong();
      this.pTt = paramParcel.readLong();
      this.pTu = paramParcel.readLong();
      this.pTv = paramParcel.readLong();
      this.pTw = paramParcel.readLong();
      if (paramParcel.readByte() <= 0) {
        break label219;
      }
      bool1 = true;
      label160:
      this.pTD = bool1;
      if (paramParcel.readByte() <= 0) {
        break label225;
      }
    }
    label219:
    label225:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.pTE = bool1;
      this.pTx = paramParcel.readLong();
      this.pTy = paramParcel.readLong();
      this.pTB = paramParcel.readInt();
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
    this.cBH = paramString;
    this.pTq = new LinkedList();
    this.pTr = new LinkedList();
    AppMethodBeat.o(47155);
  }
  
  public final boolean bZI()
  {
    AppMethodBeat.i(47153);
    if (this.pTr == null)
    {
      AppMethodBeat.o(47153);
      return false;
    }
    Iterator localIterator = this.pTr.iterator();
    while (localIterator.hasNext())
    {
      kv_14609 localkv_14609 = (kv_14609)localIterator.next();
      if ((localkv_14609 != null) && (localkv_14609.bZI()))
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
    paramParcel.writeString(this.cBH);
    if (Util.isNullOrNil(this.pTq))
    {
      paramParcel.writeInt(-1);
      paramParcel.writeTypedList(this.pTr);
      if (!this.pTC) {
        break label215;
      }
      paramInt = 1;
      label47:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.pSY);
      paramParcel.writeLong(this.pTs);
      paramParcel.writeLong(this.pTt);
      paramParcel.writeLong(this.pTu);
      paramParcel.writeLong(this.pTv);
      paramParcel.writeLong(this.pTw);
      if (!this.pTD) {
        break label220;
      }
      paramInt = 1;
      label110:
      paramParcel.writeByte((byte)paramInt);
      if (!this.pTE) {
        break label225;
      }
    }
    label215:
    label220:
    label225:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.pTx);
      paramParcel.writeLong(this.pTy);
      paramParcel.writeInt(this.pTB);
      AppMethodBeat.o(47154);
      return;
      paramParcel.writeInt(this.pTq.size());
      Iterator localIterator = this.pTq.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeString(((ps)localIterator.next()).agH());
      }
      break;
      paramInt = 0;
      break label47;
      paramInt = 0;
      break label110;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle
 * JD-Core Version:    0.7.0.1
 */