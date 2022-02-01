package com.tencent.mm.plugin.appbrand.report.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class AdReportCgiHelper
{
  public static void a(int paramInt, String paramString, a parama)
  {
    AppMethodBeat.i(48080);
    if (MMApplicationContext.isMMProcess())
    {
      aI(paramInt, paramString);
      if (parama != null)
      {
        parama.onDone();
        AppMethodBeat.o(48080);
      }
    }
    else
    {
      AdReportCgiParams localAdReportCgiParams = new AdReportCgiParams();
      AdReportCgiParams.a(localAdReportCgiParams, paramInt);
      AdReportCgiParams.a(localAdReportCgiParams, paramString);
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localAdReportCgiParams, b.class, new f() {});
    }
    AppMethodBeat.o(48080);
  }
  
  static void aI(int paramInt, String paramString)
  {
    AppMethodBeat.i(48081);
    if (h.ax(com.tencent.mm.plugin.sns.c.a.class) != null) {
      ((com.tencent.mm.plugin.sns.c.a)h.ax(com.tencent.mm.plugin.sns.c.a.class)).y(paramInt, paramString, (int)Util.nowSecond());
    }
    AppMethodBeat.o(48081);
  }
  
  static final class AdReportCgiParams
    implements Parcelable
  {
    public static final Parcelable.Creator<AdReportCgiParams> CREATOR;
    private int mtI;
    private String tOW;
    
    static
    {
      AppMethodBeat.i(48078);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(48078);
    }
    
    AdReportCgiParams() {}
    
    protected AdReportCgiParams(Parcel paramParcel)
    {
      AppMethodBeat.i(48076);
      this.mtI = paramParcel.readInt();
      this.tOW = paramParcel.readString();
      AppMethodBeat.o(48076);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(48077);
      paramParcel.writeInt(this.mtI);
      paramParcel.writeString(this.tOW);
      AppMethodBeat.o(48077);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onDone();
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static final class b
    implements d<AdReportCgiHelper.AdReportCgiParams, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper
 * JD-Core Version:    0.7.0.1
 */