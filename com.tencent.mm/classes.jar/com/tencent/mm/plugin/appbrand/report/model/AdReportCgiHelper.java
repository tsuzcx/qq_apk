package com.tencent.mm.plugin.appbrand.report.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class AdReportCgiHelper
{
  public static void a(int paramInt, String paramString, a parama)
  {
    AppMethodBeat.i(48080);
    if (ak.cpe())
    {
      ar(paramInt, paramString);
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
      XIPCInvoker.a("com.tencent.mm", localAdReportCgiParams, b.class, new d() {});
    }
    AppMethodBeat.o(48080);
  }
  
  static void ar(int paramInt, String paramString)
  {
    AppMethodBeat.i(48081);
    if (g.ab(a.class) != null) {
      ((a)g.ab(a.class)).p(paramInt, paramString, (int)bu.aRi());
    }
    AppMethodBeat.o(48081);
  }
  
  static final class AdReportCgiParams
    implements Parcelable
  {
    public static final Parcelable.Creator<AdReportCgiParams> CREATOR;
    private int guD;
    private String mxd;
    
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
      this.guD = paramParcel.readInt();
      this.mxd = paramParcel.readString();
      AppMethodBeat.o(48076);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(48077);
      paramParcel.writeInt(this.guD);
      paramParcel.writeString(this.mxd);
      AppMethodBeat.o(48077);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onDone();
  }
  
  static final class b
    implements b<AdReportCgiHelper.AdReportCgiParams, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper
 * JD-Core Version:    0.7.0.1
 */