package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class JsApiDeleteFinderDataItem
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.q>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "deleteFinderDataItem";
  
  static class DeleteFinderTask
    extends MainProcessTask
    implements com.tencent.mm.al.g
  {
    public static final Parcelable.Creator<DeleteFinderTask> CREATOR;
    private com.tencent.mm.plugin.appbrand.q jRd;
    private String jRe;
    private String jRf;
    private String jRg;
    private int joH;
    
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
      this.jRd = paramq;
      this.joH = paramInt;
      this.jRe = paramString1;
      this.jRf = paramString2;
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(163922);
      ad.i("MicroMsg.Finder.JsApiDeleteFinderDataItem", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.jRd.getAppId(), this.jRg, Integer.valueOf(this.joH), Boolean.valueOf(this.jRd.isRunning()) });
      this.jRd.h(this.joH, this.jRg);
      aXn();
      AppMethodBeat.o(163922);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(163923);
      m localm = new m(u.aqO(), Long.valueOf(this.jRe).longValue(), this.jRf);
      com.tencent.mm.kernel.g.aeS().a(3627, this);
      com.tencent.mm.kernel.g.aeS().a(localm, 0);
      AppMethodBeat.o(163923);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(163920);
      this.jRe = paramParcel.readString();
      this.jRf = paramParcel.readString();
      this.jRg = paramParcel.readString();
      AppMethodBeat.o(163920);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(163924);
      com.tencent.mm.kernel.g.aeS().b(3627, this);
      paramn = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (this.jRg = a.a("", 0, paramn);; this.jRg = a.a(paramString, paramInt2, paramn))
      {
        aXw();
        AppMethodBeat.o(163924);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163921);
      paramParcel.writeString(this.jRe);
      paramParcel.writeString(this.jRf);
      paramParcel.writeString(this.jRg);
      AppMethodBeat.o(163921);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeleteFinderDataItem
 * JD-Core Version:    0.7.0.1
 */