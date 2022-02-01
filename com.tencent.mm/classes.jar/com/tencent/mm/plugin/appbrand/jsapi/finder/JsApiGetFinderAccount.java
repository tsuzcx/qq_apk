package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONObject;

public final class JsApiGetFinderAccount
  extends c<v>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "getFinderAccount";
  
  static class GetFinderAccountTask
    extends MainProcessTask
    implements i
  {
    public static final Parcelable.Creator<GetFinderAccountTask> CREATOR;
    private v nAz;
    private String oSX;
    private int okO;
    
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
    
    public GetFinderAccountTask(v paramv, int paramInt)
    {
      this.nAz = paramv;
      this.okO = paramInt;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(163949);
      bx localbx = new bx();
      h.aGY().a(localbx.getType(), this);
      h.aGY().a(localbx, 0);
      AppMethodBeat.o(163949);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(163948);
      Log.i("MicroMsg.Finder.JsApiGetFinderAccount", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.nAz.getAppId(), this.oSX, Integer.valueOf(this.okO), Boolean.valueOf(this.nAz.isRunning()) });
      this.nAz.j(this.okO, this.oSX);
      bPk();
      AppMethodBeat.o(163948);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(163950);
      this.oSX = paramParcel.readString();
      AppMethodBeat.o(163950);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(163952);
      h.aGY().b(3930, this);
      JSONObject localJSONObject = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (;;)
      {
        try
        {
          paramString = ((bx)paramq).xdm;
          if (!paramString.SIy.isEmpty())
          {
            a.a((FinderContact)paramString.SIy.get(0), localJSONObject);
            this.oSX = a.a("", 0, localJSONObject);
            bPt();
            AppMethodBeat.o(163952);
            return;
          }
          this.oSX = a.a("not contact", -1, localJSONObject);
          continue;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.Finder.JsApiGetFinderAccount", paramString, "GetFinderAccountTask runInMainProcess", new Object[0]);
          this.oSX = a.a(paramString.getMessage(), -1, localJSONObject);
          continue;
        }
        if (paramInt1 == 4) {
          this.oSX = a.a(paramString, paramInt2, localJSONObject);
        } else {
          this.oSX = a.a(paramString, -1, localJSONObject);
        }
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163951);
      paramParcel.writeString(this.oSX);
      AppMethodBeat.o(163951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiGetFinderAccount
 * JD-Core Version:    0.7.0.1
 */