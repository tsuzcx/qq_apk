package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zu;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class JsApiMakeVoIPCall
  extends c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 154;
  public static final String NAME = "makeVoIPCall";
  
  static class StartVoIPCall
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartVoIPCall> CREATOR;
    private int ror;
    private p rzh;
    private f rzi;
    private IListener rzj;
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
      this.rzj = new IListener(com.tencent.mm.app.f.hfK) {};
      h(paramParcel);
      AppMethodBeat.o(45544);
    }
    
    public StartVoIPCall(p paramp, f paramf, int paramInt)
    {
      AppMethodBeat.i(45543);
      this.rzj = new IListener(com.tencent.mm.app.f.hfK) {};
      this.rzh = paramp;
      this.rzi = paramf;
      this.ror = paramInt;
      AppMethodBeat.o(45543);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45545);
      this.rzj.alive();
      AppMethodBeat.o(45545);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(45546);
      cpx();
      Log.i("MicroMsg.JsApiMakeVoIPCall", "makeVoIPCall = %d", new Object[] { Integer.valueOf(this.status) });
      if (this.status == 1)
      {
        this.rzi.callback(this.ror, this.rzh.ZP("cancel"));
        AppMethodBeat.o(45546);
        return;
      }
      if (this.status == 2)
      {
        this.rzi.callback(this.ror, this.rzh.ZP("ok"));
        AppMethodBeat.o(45546);
        return;
      }
      if (this.status == 3)
      {
        this.rzi.callback(this.ror, this.rzh.ZP("fail:network error"));
        AppMethodBeat.o(45546);
        return;
      }
      if (this.status == 4)
      {
        this.rzi.callback(this.ror, this.rzh.ZP("fail:param not match"));
        AppMethodBeat.o(45546);
        return;
      }
      this.rzi.callback(this.ror, this.rzh.ZP("fail:unknow"));
      AppMethodBeat.o(45546);
    }
    
    public final void h(Parcel paramParcel)
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