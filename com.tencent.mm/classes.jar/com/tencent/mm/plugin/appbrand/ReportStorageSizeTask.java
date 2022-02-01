package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class ReportStorageSizeTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ReportStorageSizeTask> CREATOR;
  public String appId;
  
  static
  {
    AppMethodBeat.i(43984);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(43984);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(43981);
    h.ZvG.be(new ReportStorageSizeTask.1(this));
    AppMethodBeat.o(43981);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(43983);
    this.appId = paramParcel.readString();
    AppMethodBeat.o(43983);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(43982);
    paramParcel.writeString(this.appId);
    AppMethodBeat.o(43982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ReportStorageSizeTask
 * JD-Core Version:    0.7.0.1
 */