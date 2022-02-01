package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.finder.cgi.v;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class JsApiDeleteFinderDataItem
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.q>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "deleteFinderDataItem";
  
  static class DeleteFinderTask
    extends MainProcessTask
    implements com.tencent.mm.ak.g
  {
    public static final Parcelable.Creator<DeleteFinderTask> CREATOR;
    private int jOT;
    private com.tencent.mm.plugin.appbrand.q krP;
    private String krQ;
    private String krR;
    private String krS;
    
    static
    {
      AppMethodBeat.i(163925);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(163925);
    }
    
    public DeleteFinderTask(Parcel paramParcel)
    {
      AppMethodBeat.i(163919);
      e(paramParcel);
      AppMethodBeat.o(163919);
    }
    
    public DeleteFinderTask(com.tencent.mm.plugin.appbrand.q paramq, int paramInt, String paramString1, String paramString2)
    {
      this.krP = paramq;
      this.jOT = paramInt;
      this.krQ = paramString1;
      this.krR = paramString2;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(163923);
      v localv = new v(u.axE(), Long.valueOf(this.krQ).longValue(), this.krR);
      com.tencent.mm.kernel.g.agi().a(3627, this);
      com.tencent.mm.kernel.g.agi().a(localv, 0);
      AppMethodBeat.o(163923);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(163922);
      ac.i("MicroMsg.Finder.JsApiDeleteFinderDataItem", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.krP.getAppId(), this.krS, Integer.valueOf(this.jOT), Boolean.valueOf(this.krP.isRunning()) });
      this.krP.h(this.jOT, this.krS);
      bek();
      AppMethodBeat.o(163922);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(163920);
      this.krQ = paramParcel.readString();
      this.krR = paramParcel.readString();
      this.krS = paramParcel.readString();
      AppMethodBeat.o(163920);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(163924);
      com.tencent.mm.kernel.g.agi().b(3627, this);
      paramn = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (this.krS = a.a("", 0, paramn);; this.krS = a.a(paramString, paramInt2, paramn))
      {
        bet();
        AppMethodBeat.o(163924);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163921);
      paramParcel.writeString(this.krQ);
      paramParcel.writeString(this.krR);
      paramParcel.writeString(this.krS);
      AppMethodBeat.o(163921);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeleteFinderDataItem
 * JD-Core Version:    0.7.0.1
 */