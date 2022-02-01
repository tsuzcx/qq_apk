package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class JsApiDeleteFinderDataItem
  extends d<s>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "deleteFinderDataItem";
  
  static class DeleteFinderTask
    extends MainProcessTask
    implements i
  {
    public static final Parcelable.Creator<DeleteFinderTask> CREATOR;
    private s lVM;
    private String lVN;
    private String lVO;
    private String lVP;
    private int lqe;
    
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
    
    public DeleteFinderTask(s params, int paramInt, String paramString1, String paramString2)
    {
      this.lVM = params;
      this.lqe = paramInt;
      this.lVN = paramString1;
      this.lVO = paramString2;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(163923);
      av localav = new av(z.aUg(), Long.valueOf(this.lVN).longValue(), this.lVO, false);
      g.azz().a(3627, this);
      g.azz().a(localav, 0);
      AppMethodBeat.o(163923);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(163922);
      Log.i("MicroMsg.Finder.JsApiDeleteFinderDataItem", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.lVM.getAppId(), this.lVP, Integer.valueOf(this.lqe), Boolean.valueOf(this.lVM.isRunning()) });
      this.lVM.i(this.lqe, this.lVP);
      bDK();
      AppMethodBeat.o(163922);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(163920);
      this.lVN = paramParcel.readString();
      this.lVO = paramParcel.readString();
      this.lVP = paramParcel.readString();
      AppMethodBeat.o(163920);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(163924);
      g.azz().b(3627, this);
      paramq = new JSONObject();
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (this.lVP = a.a("", 0, paramq);; this.lVP = a.a(paramString, paramInt2, paramq))
      {
        bDU();
        AppMethodBeat.o(163924);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163921);
      paramParcel.writeString(this.lVN);
      paramParcel.writeString(this.lVO);
      paramParcel.writeString(this.lVP);
      AppMethodBeat.o(163921);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeleteFinderDataItem
 * JD-Core Version:    0.7.0.1
 */