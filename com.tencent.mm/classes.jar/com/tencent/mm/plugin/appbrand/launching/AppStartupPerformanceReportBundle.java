package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.h.b.a.an;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppStartupPerformanceReportBundle
  implements Parcelable, g
{
  public static final Parcelable.Creator<AppStartupPerformanceReportBundle> CREATOR = new AppStartupPerformanceReportBundle.1();
  public final String gKi;
  public final List<an> gKj;
  public final List<kv_14609> gKk;
  public boolean gKl;
  
  private AppStartupPerformanceReportBundle(Parcel paramParcel)
  {
    this.gKi = paramParcel.readString();
    this.gKj = new LinkedList();
    int j = paramParcel.readInt();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        this.gKj.add(new an(paramParcel.readString()));
        i += 1;
      }
    }
    this.gKk = paramParcel.createTypedArrayList(kv_14609.CREATOR);
    if (paramParcel.readByte() > 0) {
      bool = true;
    }
    this.gKl = bool;
  }
  
  public AppStartupPerformanceReportBundle(String paramString)
  {
    this.gKi = paramString;
    this.gKj = new LinkedList();
    this.gKk = new LinkedList();
  }
  
  public final boolean alH()
  {
    if (this.gKk == null) {
      return false;
    }
    Iterator localIterator = this.gKk.iterator();
    while (localIterator.hasNext())
    {
      kv_14609 localkv_14609 = (kv_14609)localIterator.next();
      if (localkv_14609 != null)
      {
        if (localkv_14609.gZD > 0) {}
        for (int i = 1; i != 0; i = 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.gKi);
    if (bk.dk(this.gKj))
    {
      paramParcel.writeInt(-1);
      paramParcel.writeTypedList(this.gKk);
      if (!this.gKl) {
        break label98;
      }
    }
    label98:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramParcel.writeInt(this.gKj.size());
      Iterator localIterator = this.gKj.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeString(((an)localIterator.next()).uI());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle
 * JD-Core Version:    0.7.0.1
 */