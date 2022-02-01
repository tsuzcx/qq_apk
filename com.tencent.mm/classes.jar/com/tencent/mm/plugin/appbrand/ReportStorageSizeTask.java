package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ac;

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
  
  public final void aLq()
  {
    AppMethodBeat.i(43981);
    com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        AppMethodBeat.i(186276);
        String str = "MicroMsg.AppBrand.ReportStorageSizeTask#" + ReportStorageSizeTask.b(ReportStorageSizeTask.this);
        AppMethodBeat.o(186276);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(186275);
        try
        {
          ReportStorageSizeTask.a(ReportStorageSizeTask.this);
          AppMethodBeat.o(186275);
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("MicroMsg.AppBrand.ReportStorageSizeTask", "doReport appId:%s, e:%s", new Object[] { ReportStorageSizeTask.b(ReportStorageSizeTask.this), localThrowable });
          AppMethodBeat.o(186275);
        }
      }
    });
    AppMethodBeat.o(43981);
  }
  
  public final void e(Parcel paramParcel)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ReportStorageSizeTask
 * JD-Core Version:    0.7.0.1
 */