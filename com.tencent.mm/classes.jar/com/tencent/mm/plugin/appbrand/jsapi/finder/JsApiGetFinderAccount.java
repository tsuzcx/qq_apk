package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.finder.cgi.bt;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONObject;

public final class JsApiGetFinderAccount
  extends d<s>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getFinderAccount";
  
  static class GetFinderAccountTask
    extends MainProcessTask
    implements i
  {
    public static final Parcelable.Creator<GetFinderAccountTask> CREATOR;
    private s kGT;
    private String lVP;
    private int lqe;
    
    static
    {
      AppMethodBeat.i(163953);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(163953);
    }
    
    public GetFinderAccountTask(Parcel paramParcel)
    {
      AppMethodBeat.i(163947);
      f(paramParcel);
      AppMethodBeat.o(163947);
    }
    
    public GetFinderAccountTask(s params, int paramInt)
    {
      this.kGT = params;
      this.lqe = paramInt;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(163949);
      bt localbt = new bt();
      g.azz().a(localbt.getType(), this);
      g.azz().a(localbt, 0);
      AppMethodBeat.o(163949);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(163948);
      Log.i("MicroMsg.Finder.JsApiGetFinderAccount", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.kGT.getAppId(), this.lVP, Integer.valueOf(this.lqe), Boolean.valueOf(this.kGT.isRunning()) });
      this.kGT.i(this.lqe, this.lVP);
      bDK();
      AppMethodBeat.o(163948);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(163950);
      this.lVP = paramParcel.readString();
      AppMethodBeat.o(163950);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(163952);
      g.azz().b(3930, this);
      JSONObject localJSONObject = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (;;)
      {
        try
        {
          paramString = ((bt)paramq).tvE;
          if (!paramString.LEN.isEmpty())
          {
            a.a((FinderContact)paramString.LEN.get(0), localJSONObject);
            this.lVP = a.a("", 0, localJSONObject);
            bDU();
            AppMethodBeat.o(163952);
            return;
          }
          this.lVP = a.a("not contact", -1, localJSONObject);
          continue;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.Finder.JsApiGetFinderAccount", paramString, "GetFinderAccountTask runInMainProcess", new Object[0]);
          this.lVP = a.a(paramString.getMessage(), -1, localJSONObject);
          continue;
        }
        if (paramInt1 == 4) {
          this.lVP = a.a(paramString, paramInt2, localJSONObject);
        } else {
          this.lVP = a.a(paramString, -1, localJSONObject);
        }
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163951);
      paramParcel.writeString(this.lVP);
      AppMethodBeat.o(163951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiGetFinderAccount
 * JD-Core Version:    0.7.0.1
 */