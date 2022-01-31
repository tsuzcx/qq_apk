package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cr;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppStartupPerformanceReportBundle
  implements Parcelable, j
{
  public static final Parcelable.Creator<AppStartupPerformanceReportBundle> CREATOR;
  public final String ikX;
  public final List<cr> ikY;
  public final List<kv_14609> ikZ;
  public boolean ila;
  
  static
  {
    AppMethodBeat.i(131807);
    CREATOR = new AppStartupPerformanceReportBundle.1();
    AppMethodBeat.o(131807);
  }
  
  private AppStartupPerformanceReportBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(131806);
    this.ikX = paramParcel.readString();
    this.ikY = new LinkedList();
    int j = paramParcel.readInt();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        this.ikY.add(new cr(paramParcel.readString()));
        i += 1;
      }
    }
    this.ikZ = paramParcel.createTypedArrayList(kv_14609.CREATOR);
    if (paramParcel.readByte() > 0) {
      bool = true;
    }
    this.ila = bool;
    AppMethodBeat.o(131806);
  }
  
  public AppStartupPerformanceReportBundle(String paramString)
  {
    AppMethodBeat.i(131805);
    this.ikX = paramString;
    this.ikY = new LinkedList();
    this.ikZ = new LinkedList();
    AppMethodBeat.o(131805);
  }
  
  public final boolean aGR()
  {
    AppMethodBeat.i(131803);
    if (this.ikZ == null)
    {
      AppMethodBeat.o(131803);
      return false;
    }
    Iterator localIterator = this.ikZ.iterator();
    while (localIterator.hasNext())
    {
      kv_14609 localkv_14609 = (kv_14609)localIterator.next();
      if (localkv_14609 != null)
      {
        if (localkv_14609.iHT > 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(131803);
          return true;
        }
      }
    }
    AppMethodBeat.o(131803);
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131804);
    paramParcel.writeString(this.ikX);
    if (bo.es(this.ikY))
    {
      paramParcel.writeInt(-1);
      paramParcel.writeTypedList(this.ikZ);
      if (!this.ila) {
        break label108;
      }
    }
    label108:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(131804);
      return;
      paramParcel.writeInt(this.ikY.size());
      Iterator localIterator = this.ikY.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeString(((cr)localIterator.next()).Ff());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle
 * JD-Core Version:    0.7.0.1
 */