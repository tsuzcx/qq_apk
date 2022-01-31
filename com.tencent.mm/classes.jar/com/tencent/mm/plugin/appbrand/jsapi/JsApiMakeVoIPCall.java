package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;

public final class JsApiMakeVoIPCall
  extends a<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 154;
  public static final String NAME = "makeVoIPCall";
  
  static class StartVoIPCall
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartVoIPCall> CREATOR;
    private int hry;
    private m hxs;
    private c hyO;
    private com.tencent.mm.sdk.b.c hyP;
    public int status;
    
    static
    {
      AppMethodBeat.i(130492);
      CREATOR = new JsApiMakeVoIPCall.StartVoIPCall.2();
      AppMethodBeat.o(130492);
    }
    
    public StartVoIPCall(Parcel paramParcel)
    {
      AppMethodBeat.i(130486);
      this.hyP = new JsApiMakeVoIPCall.StartVoIPCall.1(this);
      f(paramParcel);
      AppMethodBeat.o(130486);
    }
    
    public StartVoIPCall(m paramm, c paramc, int paramInt)
    {
      AppMethodBeat.i(130485);
      this.hyP = new JsApiMakeVoIPCall.StartVoIPCall.1(this);
      this.hxs = paramm;
      this.hyO = paramc;
      this.hry = paramInt;
      AppMethodBeat.o(130485);
    }
    
    public final void ata()
    {
      AppMethodBeat.i(130487);
      com.tencent.mm.sdk.b.a.ymk.c(this.hyP);
      AppMethodBeat.o(130487);
    }
    
    public final void atb()
    {
      AppMethodBeat.i(130488);
      aBk();
      ab.i("MicroMsg.JsApiMakeVoIPCall", "makeVoIPCall = %d", new Object[] { Integer.valueOf(this.status) });
      if (this.status == 1)
      {
        this.hyO.h(this.hry, this.hxs.j("cancel", null));
        AppMethodBeat.o(130488);
        return;
      }
      if (this.status == 2)
      {
        this.hyO.h(this.hry, this.hxs.j("ok", null));
        AppMethodBeat.o(130488);
        return;
      }
      if (this.status == 3)
      {
        this.hyO.h(this.hry, this.hxs.j("fail:network error", null));
        AppMethodBeat.o(130488);
        return;
      }
      if (this.status == 4)
      {
        this.hyO.h(this.hry, this.hxs.j("fail:param not match", null));
        AppMethodBeat.o(130488);
        return;
      }
      this.hyO.h(this.hry, this.hxs.j("fail:unknow", null));
      AppMethodBeat.o(130488);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(130489);
      this.status = paramParcel.readInt();
      AppMethodBeat.o(130489);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(130490);
      paramParcel.writeInt(this.status);
      AppMethodBeat.o(130490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall
 * JD-Core Version:    0.7.0.1
 */