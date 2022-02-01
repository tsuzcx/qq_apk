package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class JsApiDeleteFinderDataItem
  extends c<v>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "deleteFinderDataItem";
  
  static class DeleteFinderTask
    extends MainProcessTask
    implements i
  {
    public static final Parcelable.Creator<DeleteFinderTask> CREATOR;
    private v oSU;
    private String oSV;
    private String oSW;
    private String oSX;
    private int okO;
    
    static
    {
      AppMethodBeat.i(163925);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(163925);
    }
    
    public DeleteFinderTask(Parcel paramParcel)
    {
      AppMethodBeat.i(163919);
      f(paramParcel);
      AppMethodBeat.o(163919);
    }
    
    public DeleteFinderTask(v paramv, int paramInt, String paramString1, String paramString2)
    {
      this.oSU = paramv;
      this.okO = paramInt;
      this.oSV = paramString1;
      this.oSW = paramString2;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(163923);
      ay localay = new ay(z.bdh(), Long.valueOf(this.oSV).longValue(), this.oSW, false);
      h.aGY().a(3627, this);
      h.aGY().a(localay, 0);
      AppMethodBeat.o(163923);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(163922);
      Log.i("MicroMsg.Finder.JsApiDeleteFinderDataItem", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.oSU.getAppId(), this.oSX, Integer.valueOf(this.okO), Boolean.valueOf(this.oSU.isRunning()) });
      this.oSU.j(this.okO, this.oSX);
      bPk();
      AppMethodBeat.o(163922);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(163920);
      this.oSV = paramParcel.readString();
      this.oSW = paramParcel.readString();
      this.oSX = paramParcel.readString();
      AppMethodBeat.o(163920);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(163924);
      h.aGY().b(3627, this);
      paramq = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (this.oSX = a.a("", 0, paramq);; this.oSX = a.a(paramString, paramInt2, paramq))
      {
        bPt();
        AppMethodBeat.o(163924);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163921);
      paramParcel.writeString(this.oSV);
      paramParcel.writeString(this.oSW);
      paramParcel.writeString(this.oSX);
      AppMethodBeat.o(163921);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeleteFinderDataItem
 * JD-Core Version:    0.7.0.1
 */