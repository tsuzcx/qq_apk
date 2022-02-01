package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;

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
  
  public final void asn()
  {
    AppMethodBeat.i(43981);
    com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
    {
      public final String getKey()
      {
        AppMethodBeat.i(317219);
        String str = "MicroMsg.AppBrand.ReportStorageSizeTask#" + ReportStorageSizeTask.b(ReportStorageSizeTask.this);
        AppMethodBeat.o(317219);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(317216);
        try
        {
          ReportStorageSizeTask.a(ReportStorageSizeTask.this);
          AppMethodBeat.o(317216);
          return;
        }
        finally
        {
          Log.e("MicroMsg.AppBrand.ReportStorageSizeTask", "doReport appId:%s, e:%s", new Object[] { ReportStorageSizeTask.b(ReportStorageSizeTask.this), localObject });
          AppMethodBeat.o(317216);
        }
      }
    });
    AppMethodBeat.o(43981);
  }
  
  public final void h(Parcel paramParcel)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ReportStorageSizeTask
 * JD-Core Version:    0.7.0.1
 */