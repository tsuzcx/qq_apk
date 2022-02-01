package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.finder.cgi.al;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import org.json.JSONObject;

public final class JsApiGetFinderAccount
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.q>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getFinderAccount";
  
  static class GetFinderAccountTask
    extends MainProcessTask
    implements com.tencent.mm.ak.g
  {
    public static final Parcelable.Creator<GetFinderAccountTask> CREATOR;
    private int jOT;
    private com.tencent.mm.plugin.appbrand.q jiP;
    private String krS;
    
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
      this.jiP = paramq;
      this.jOT = paramInt;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(163949);
      al localal = new al();
      com.tencent.mm.kernel.g.agi().a(localal.getType(), this);
      com.tencent.mm.kernel.g.agi().a(localal, 0);
      AppMethodBeat.o(163949);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(163948);
      ac.i("MicroMsg.Finder.JsApiGetFinderAccount", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.jiP.getAppId(), this.krS, Integer.valueOf(this.jOT), Boolean.valueOf(this.jiP.isRunning()) });
      this.jiP.h(this.jOT, this.krS);
      bek();
      AppMethodBeat.o(163948);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(163950);
      this.krS = paramParcel.readString();
      AppMethodBeat.o(163950);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(163952);
      com.tencent.mm.kernel.g.agi().b(3930, this);
      JSONObject localJSONObject = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (;;)
      {
        try
        {
          paramString = ((al)paramn).qYp;
          if (!paramString.EFf.isEmpty())
          {
            a.a((FinderContact)paramString.EFf.get(0), localJSONObject);
            this.krS = a.a("", 0, localJSONObject);
            bet();
            AppMethodBeat.o(163952);
            return;
          }
          this.krS = a.a("not contact", -1, localJSONObject);
          continue;
        }
        catch (Exception paramString)
        {
          ac.printErrStackTrace("MicroMsg.Finder.JsApiGetFinderAccount", paramString, "GetFinderAccountTask runInMainProcess", new Object[0]);
          this.krS = a.a(paramString.getMessage(), -1, localJSONObject);
          continue;
        }
        if (paramInt1 == 4) {
          this.krS = a.a(paramString, paramInt2, localJSONObject);
        } else {
          this.krS = a.a(paramString, -1, localJSONObject);
        }
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163951);
      paramParcel.writeString(this.krS);
      AppMethodBeat.o(163951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiGetFinderAccount
 * JD-Core Version:    0.7.0.1
 */