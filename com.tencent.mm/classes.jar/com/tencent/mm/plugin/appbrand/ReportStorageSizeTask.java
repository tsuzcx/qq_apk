package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;

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
  
  public final void bjj()
  {
    AppMethodBeat.i(43981);
    com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
    {
      public final String getKey()
      {
        AppMethodBeat.i(226248);
        String str = "MicroMsg.AppBrand.ReportStorageSizeTask#" + ReportStorageSizeTask.b(ReportStorageSizeTask.this);
        AppMethodBeat.o(226248);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(226247);
        try
        {
          ReportStorageSizeTask.a(ReportStorageSizeTask.this);
          AppMethodBeat.o(226247);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.AppBrand.ReportStorageSizeTask", "doReport appId:%s, e:%s", new Object[] { ReportStorageSizeTask.b(ReportStorageSizeTask.this), localThrowable });
          AppMethodBeat.o(226247);
        }
      }
    });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ReportStorageSizeTask
 * JD-Core Version:    0.7.0.1
 */