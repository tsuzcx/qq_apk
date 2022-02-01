package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mt;
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
  public final String kEY;
  public long mSA;
  public long mSB;
  public long mSC;
  public long mSD;
  public long mSE;
  public int mSF;
  public boolean mSG;
  public boolean mSH;
  public long mSe;
  public final List<mt> mSw;
  public final List<kv_14609> mSx;
  public long mSy;
  public long mSz;
  
  static
  {
    AppMethodBeat.i(47157);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47157);
  }
  
  private AppStartupPerformanceReportBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(47156);
    this.kEY = paramParcel.readString();
    this.mSw = new LinkedList();
    int j = paramParcel.readInt();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        this.mSw.add(new mt(paramParcel.readString()));
        i += 1;
      }
    }
    this.mSx = paramParcel.createTypedArrayList(kv_14609.CREATOR);
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.mSG = bool1;
      this.mSe = paramParcel.readLong();
      this.mSy = paramParcel.readLong();
      this.mSz = paramParcel.readLong();
      this.mSA = paramParcel.readLong();
      this.mSB = paramParcel.readLong();
      this.mSC = paramParcel.readLong();
      if (paramParcel.readByte() <= 0) {
        break label203;
      }
    }
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mSH = bool1;
      this.mSD = paramParcel.readLong();
      this.mSE = paramParcel.readLong();
      this.mSF = paramParcel.readInt();
      AppMethodBeat.o(47156);
      return;
      bool1 = false;
      break;
    }
  }
  
  AppStartupPerformanceReportBundle(String paramString)
  {
    AppMethodBeat.i(47155);
    this.kEY = paramString;
    this.mSw = new LinkedList();
    this.mSx = new LinkedList();
    AppMethodBeat.o(47155);
  }
  
  public final boolean bNr()
  {
    AppMethodBeat.i(47153);
    if (this.mSx == null)
    {
      AppMethodBeat.o(47153);
      return false;
    }
    Iterator localIterator = this.mSx.iterator();
    while (localIterator.hasNext())
    {
      kv_14609 localkv_14609 = (kv_14609)localIterator.next();
      if ((localkv_14609 != null) && (localkv_14609.bNr()))
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
    paramParcel.writeString(this.kEY);
    if (Util.isNullOrNil(this.mSw))
    {
      paramParcel.writeInt(-1);
      paramParcel.writeTypedList(this.mSx);
      if (!this.mSG) {
        break label200;
      }
      paramInt = 1;
      label47:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.mSe);
      paramParcel.writeLong(this.mSy);
      paramParcel.writeLong(this.mSz);
      paramParcel.writeLong(this.mSA);
      paramParcel.writeLong(this.mSB);
      paramParcel.writeLong(this.mSC);
      if (!this.mSH) {
        break label205;
      }
    }
    label200:
    label205:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.mSD);
      paramParcel.writeLong(this.mSE);
      paramParcel.writeInt(this.mSF);
      AppMethodBeat.o(47154);
      return;
      paramParcel.writeInt(this.mSw.size());
      Iterator localIterator = this.mSw.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeString(((mt)localIterator.next()).abV());
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