package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class JsApiDeleteFinderDataItem
  extends com.tencent.mm.plugin.appbrand.jsapi.a<r>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "deleteFinderDataItem";
  
  static class DeleteFinderTask
    extends MainProcessTask
    implements f
  {
    public static final Parcelable.Creator<DeleteFinderTask> CREATOR;
    private r kQI;
    private String kQJ;
    private String kQK;
    private String kQL;
    private int kmu;
    
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
    
    public DeleteFinderTask(r paramr, int paramInt, String paramString1, String paramString2)
    {
      this.kQI = paramr;
      this.kmu = paramInt;
      this.kQJ = paramString1;
      this.kQK = paramString2;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(163923);
      ab localab = new ab(v.aAK(), Long.valueOf(this.kQJ).longValue(), this.kQK);
      g.ajj().a(3627, this);
      g.ajj().a(localab, 0);
      AppMethodBeat.o(163923);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(163922);
      ae.i("MicroMsg.Finder.JsApiDeleteFinderDataItem", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.kQI.getAppId(), this.kQL, Integer.valueOf(this.kmu), Boolean.valueOf(this.kQI.isRunning()) });
      this.kQI.h(this.kmu, this.kQL);
      bix();
      AppMethodBeat.o(163922);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(163920);
      this.kQJ = paramParcel.readString();
      this.kQK = paramParcel.readString();
      this.kQL = paramParcel.readString();
      AppMethodBeat.o(163920);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(163924);
      g.ajj().b(3627, this);
      paramn = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (this.kQL = a.a("", 0, paramn);; this.kQL = a.a(paramString, paramInt2, paramn))
      {
        biG();
        AppMethodBeat.o(163924);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163921);
      paramParcel.writeString(this.kQJ);
      paramParcel.writeString(this.kQK);
      paramParcel.writeString(this.kQL);
      AppMethodBeat.o(163921);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeleteFinderDataItem
 * JD-Core Version:    0.7.0.1
 */