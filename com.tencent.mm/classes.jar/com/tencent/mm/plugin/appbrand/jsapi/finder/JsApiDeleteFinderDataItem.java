package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.finder.cgi.bt;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class JsApiDeleteFinderDataItem
  extends c<y>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "deleteFinderDataItem";
  
  static class DeleteFinderTask
    extends MainProcessTask
    implements com.tencent.mm.am.h
  {
    public static final Parcelable.Creator<DeleteFinderTask> CREATOR;
    private y rYn;
    private String rYo;
    private String rYp;
    private String rYq;
    private int ror;
    
    static
    {
      AppMethodBeat.i(163925);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(163925);
    }
    
    public DeleteFinderTask(Parcel paramParcel)
    {
      AppMethodBeat.i(163919);
      h(paramParcel);
      AppMethodBeat.o(163919);
    }
    
    public DeleteFinderTask(y paramy, int paramInt, String paramString1, String paramString2)
    {
      this.rYn = paramy;
      this.ror = paramInt;
      this.rYo = paramString1;
      this.rYp = paramString2;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(163923);
      bt localbt = new bt(z.bAW(), Long.valueOf(this.rYo).longValue(), this.rYp, false);
      com.tencent.mm.kernel.h.aZW().a(3627, this);
      com.tencent.mm.kernel.h.aZW().a(localbt, 0);
      AppMethodBeat.o(163923);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(163922);
      Log.i("MicroMsg.Finder.JsApiDeleteFinderDataItem", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.rYn.getAppId(), this.rYq, Integer.valueOf(this.ror), Boolean.valueOf(this.rYn.isRunning()) });
      this.rYn.callback(this.ror, this.rYq);
      cpx();
      AppMethodBeat.o(163922);
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(163920);
      this.rYo = paramParcel.readString();
      this.rYp = paramParcel.readString();
      this.rYq = paramParcel.readString();
      AppMethodBeat.o(163920);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(163924);
      com.tencent.mm.kernel.h.aZW().b(3627, this);
      paramp = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (this.rYq = a.a("", 0, paramp);; this.rYq = a.a(paramString, paramInt2, paramp))
      {
        cpA();
        AppMethodBeat.o(163924);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163921);
      paramParcel.writeString(this.rYo);
      paramParcel.writeString(this.rYp);
      paramParcel.writeString(this.rYq);
      AppMethodBeat.o(163921);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeleteFinderDataItem
 * JD-Core Version:    0.7.0.1
 */