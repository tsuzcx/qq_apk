package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class JsApiDeleteFinderDataItem
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.q>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "deleteFinderDataItem";
  
  static class DeleteFinderTask
    extends MainProcessTask
    implements f
  {
    public static final Parcelable.Creator<DeleteFinderTask> CREATOR;
    private com.tencent.mm.plugin.appbrand.q kNl;
    private String kNm;
    private String kNn;
    private String kNo;
    private int kje;
    
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
      this.kNl = paramq;
      this.kje = paramInt;
      this.kNm = paramString1;
      this.kNn = paramString2;
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(163923);
      aa localaa = new aa(u.aAu(), Long.valueOf(this.kNm).longValue(), this.kNn);
      g.aiU().a(3627, this);
      g.aiU().a(localaa, 0);
      AppMethodBeat.o(163923);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(163922);
      ad.i("MicroMsg.Finder.JsApiDeleteFinderDataItem", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.kNl.getAppId(), this.kNo, Integer.valueOf(this.kje), Boolean.valueOf(this.kNl.isRunning()) });
      this.kNl.h(this.kje, this.kNo);
      bhO();
      AppMethodBeat.o(163922);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(163920);
      this.kNm = paramParcel.readString();
      this.kNn = paramParcel.readString();
      this.kNo = paramParcel.readString();
      AppMethodBeat.o(163920);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(163924);
      g.aiU().b(3627, this);
      paramn = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (this.kNo = a.a("", 0, paramn);; this.kNo = a.a(paramString, paramInt2, paramn))
      {
        bhX();
        AppMethodBeat.o(163924);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163921);
      paramParcel.writeString(this.kNm);
      paramParcel.writeString(this.kNn);
      paramParcel.writeString(this.kNo);
      AppMethodBeat.o(163921);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeleteFinderDataItem
 * JD-Core Version:    0.7.0.1
 */