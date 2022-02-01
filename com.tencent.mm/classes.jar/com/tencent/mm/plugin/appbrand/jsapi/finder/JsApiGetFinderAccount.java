package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.finder.cgi.as;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import org.json.JSONObject;

public final class JsApiGetFinderAccount
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.q>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getFinderAccount";
  
  static class GetFinderAccountTask
    extends MainProcessTask
    implements f
  {
    public static final Parcelable.Creator<GetFinderAccountTask> CREATOR;
    private com.tencent.mm.plugin.appbrand.q jCl;
    private String kNo;
    private int kje;
    
    static
    {
      AppMethodBeat.i(163953);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(163953);
    }
    
    public GetFinderAccountTask(Parcel paramParcel)
    {
      AppMethodBeat.i(163947);
      e(paramParcel);
      AppMethodBeat.o(163947);
    }
    
    public GetFinderAccountTask(com.tencent.mm.plugin.appbrand.q paramq, int paramInt)
    {
      this.jCl = paramq;
      this.kje = paramInt;
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(163949);
      as localas = new as();
      g.aiU().a(localas.getType(), this);
      g.aiU().a(localas, 0);
      AppMethodBeat.o(163949);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(163948);
      ad.i("MicroMsg.Finder.JsApiGetFinderAccount", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.jCl.getAppId(), this.kNo, Integer.valueOf(this.kje), Boolean.valueOf(this.jCl.isRunning()) });
      this.jCl.h(this.kje, this.kNo);
      bhO();
      AppMethodBeat.o(163948);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(163950);
      this.kNo = paramParcel.readString();
      AppMethodBeat.o(163950);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(163952);
      g.aiU().b(3930, this);
      JSONObject localJSONObject = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (;;)
      {
        try
        {
          paramString = ((as)paramn).rJB;
          if (!paramString.Gnl.isEmpty())
          {
            a.a((FinderContact)paramString.Gnl.get(0), localJSONObject);
            this.kNo = a.a("", 0, localJSONObject);
            bhX();
            AppMethodBeat.o(163952);
            return;
          }
          this.kNo = a.a("not contact", -1, localJSONObject);
          continue;
        }
        catch (Exception paramString)
        {
          ad.printErrStackTrace("MicroMsg.Finder.JsApiGetFinderAccount", paramString, "GetFinderAccountTask runInMainProcess", new Object[0]);
          this.kNo = a.a(paramString.getMessage(), -1, localJSONObject);
          continue;
        }
        if (paramInt1 == 4) {
          this.kNo = a.a(paramString, paramInt2, localJSONObject);
        } else {
          this.kNo = a.a(paramString, -1, localJSONObject);
        }
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163951);
      paramParcel.writeString(this.kNo);
      AppMethodBeat.o(163951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiGetFinderAccount
 * JD-Core Version:    0.7.0.1
 */