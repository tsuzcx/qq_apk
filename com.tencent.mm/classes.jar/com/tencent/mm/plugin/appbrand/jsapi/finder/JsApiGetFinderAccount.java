package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import org.json.JSONObject;

public final class JsApiGetFinderAccount
  extends com.tencent.mm.plugin.appbrand.jsapi.a<r>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getFinderAccount";
  
  static class GetFinderAccountTask
    extends MainProcessTask
    implements f
  {
    public static final Parcelable.Creator<GetFinderAccountTask> CREATOR;
    private r jFj;
    private String kQL;
    private int kmu;
    
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
    
    public GetFinderAccountTask(r paramr, int paramInt)
    {
      this.jFj = paramr;
      this.kmu = paramInt;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(163949);
      at localat = new at();
      g.ajj().a(localat.getType(), this);
      g.ajj().a(localat, 0);
      AppMethodBeat.o(163949);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(163948);
      ae.i("MicroMsg.Finder.JsApiGetFinderAccount", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.jFj.getAppId(), this.kQL, Integer.valueOf(this.kmu), Boolean.valueOf(this.jFj.isRunning()) });
      this.jFj.h(this.kmu, this.kQL);
      bix();
      AppMethodBeat.o(163948);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(163950);
      this.kQL = paramParcel.readString();
      AppMethodBeat.o(163950);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(163952);
      g.ajj().b(3930, this);
      JSONObject localJSONObject = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (;;)
      {
        try
        {
          paramString = ((at)paramn).rRP;
          if (!paramString.GGr.isEmpty())
          {
            a.a((FinderContact)paramString.GGr.get(0), localJSONObject);
            this.kQL = a.a("", 0, localJSONObject);
            biG();
            AppMethodBeat.o(163952);
            return;
          }
          this.kQL = a.a("not contact", -1, localJSONObject);
          continue;
        }
        catch (Exception paramString)
        {
          ae.printErrStackTrace("MicroMsg.Finder.JsApiGetFinderAccount", paramString, "GetFinderAccountTask runInMainProcess", new Object[0]);
          this.kQL = a.a(paramString.getMessage(), -1, localJSONObject);
          continue;
        }
        if (paramInt1 == 4) {
          this.kQL = a.a(paramString, paramInt2, localJSONObject);
        } else {
          this.kQL = a.a(paramString, -1, localJSONObject);
        }
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163951);
      paramParcel.writeString(this.kQL);
      AppMethodBeat.o(163951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiGetFinderAccount
 * JD-Core Version:    0.7.0.1
 */