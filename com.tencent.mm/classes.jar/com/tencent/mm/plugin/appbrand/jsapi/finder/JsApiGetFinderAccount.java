package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.finder.cgi.cv;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONObject;

public final class JsApiGetFinderAccount
  extends c<y>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getFinderAccount";
  
  static class GetFinderAccountTask
    extends MainProcessTask
    implements com.tencent.mm.am.h
  {
    public static final Parcelable.Creator<GetFinderAccountTask> CREATOR;
    private y qqV;
    private String rYq;
    private int ror;
    
    static
    {
      AppMethodBeat.i(163953);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(163953);
    }
    
    public GetFinderAccountTask(Parcel paramParcel)
    {
      AppMethodBeat.i(163947);
      h(paramParcel);
      AppMethodBeat.o(163947);
    }
    
    public GetFinderAccountTask(y paramy, int paramInt)
    {
      this.qqV = paramy;
      this.ror = paramInt;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(163949);
      cv localcv = new cv();
      com.tencent.mm.kernel.h.aZW().a(localcv.getType(), this);
      com.tencent.mm.kernel.h.aZW().a(localcv, 0);
      AppMethodBeat.o(163949);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(163948);
      Log.i("MicroMsg.Finder.JsApiGetFinderAccount", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.qqV.getAppId(), this.rYq, Integer.valueOf(this.ror), Boolean.valueOf(this.qqV.isRunning()) });
      this.qqV.callback(this.ror, this.rYq);
      cpx();
      AppMethodBeat.o(163948);
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(163950);
      this.rYq = paramParcel.readString();
      AppMethodBeat.o(163950);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(163952);
      com.tencent.mm.kernel.h.aZW().b(3930, this);
      JSONObject localJSONObject = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (;;)
      {
        try
        {
          paramString = ((cv)paramp).ACK;
          if (!paramString.ZMq.isEmpty())
          {
            a.a((FinderContact)paramString.ZMq.get(0), localJSONObject);
            this.rYq = a.a("", 0, localJSONObject);
            cpA();
            AppMethodBeat.o(163952);
            return;
          }
          this.rYq = a.a("not contact", -1, localJSONObject);
          continue;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.Finder.JsApiGetFinderAccount", paramString, "GetFinderAccountTask runInMainProcess", new Object[0]);
          this.rYq = a.a(paramString.getMessage(), -1, localJSONObject);
          continue;
        }
        if (paramInt1 == 4) {
          this.rYq = a.a(paramString, paramInt2, localJSONObject);
        } else {
          this.rYq = a.a(paramString, -1, localJSONObject);
        }
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163951);
      paramParcel.writeString(this.rYq);
      AppMethodBeat.o(163951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiGetFinderAccount
 * JD-Core Version:    0.7.0.1
 */