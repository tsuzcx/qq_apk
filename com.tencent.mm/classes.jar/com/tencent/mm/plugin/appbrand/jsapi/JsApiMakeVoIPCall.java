package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ae;

public final class JsApiMakeVoIPCall
  extends a<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 154;
  public static final String NAME = "makeVoIPCall";
  
  static class StartVoIPCall
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartVoIPCall> CREATOR;
    private int kmu;
    private m kuO;
    private c kws;
    private com.tencent.mm.sdk.b.c kwt;
    public int status;
    
    static
    {
      AppMethodBeat.i(45550);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45550);
    }
    
    public StartVoIPCall(Parcel paramParcel)
    {
      AppMethodBeat.i(45544);
      this.kwt = new com.tencent.mm.sdk.b.c() {};
      e(paramParcel);
      AppMethodBeat.o(45544);
    }
    
    public StartVoIPCall(m paramm, c paramc, int paramInt)
    {
      AppMethodBeat.i(45543);
      this.kwt = new com.tencent.mm.sdk.b.c() {};
      this.kuO = paramm;
      this.kws = paramc;
      this.kmu = paramInt;
      AppMethodBeat.o(45543);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45545);
      com.tencent.mm.sdk.b.a.IvT.c(this.kwt);
      AppMethodBeat.o(45545);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(45546);
      bix();
      ae.i("MicroMsg.JsApiMakeVoIPCall", "makeVoIPCall = %d", new Object[] { Integer.valueOf(this.status) });
      if (this.status == 1)
      {
        this.kws.h(this.kmu, this.kuO.e("cancel", null));
        AppMethodBeat.o(45546);
        return;
      }
      if (this.status == 2)
      {
        this.kws.h(this.kmu, this.kuO.e("ok", null));
        AppMethodBeat.o(45546);
        return;
      }
      if (this.status == 3)
      {
        this.kws.h(this.kmu, this.kuO.e("fail:network error", null));
        AppMethodBeat.o(45546);
        return;
      }
      if (this.status == 4)
      {
        this.kws.h(this.kmu, this.kuO.e("fail:param not match", null));
        AppMethodBeat.o(45546);
        return;
      }
      this.kws.h(this.kmu, this.kuO.e("fail:unknow", null));
      AppMethodBeat.o(45546);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45547);
      this.status = paramParcel.readInt();
      AppMethodBeat.o(45547);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45548);
      paramParcel.writeInt(this.status);
      AppMethodBeat.o(45548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall
 * JD-Core Version:    0.7.0.1
 */