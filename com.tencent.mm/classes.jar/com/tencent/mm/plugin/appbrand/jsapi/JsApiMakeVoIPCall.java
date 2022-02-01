package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ad;

public final class JsApiMakeVoIPCall
  extends a<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 154;
  public static final String NAME = "makeVoIPCall";
  
  static class StartVoIPCall
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartVoIPCall> CREATOR;
    private int kje;
    private m kry;
    private c ktc;
    private com.tencent.mm.sdk.b.c ktd;
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
      this.ktd = new com.tencent.mm.sdk.b.c() {};
      e(paramParcel);
      AppMethodBeat.o(45544);
    }
    
    public StartVoIPCall(m paramm, c paramc, int paramInt)
    {
      AppMethodBeat.i(45543);
      this.ktd = new com.tencent.mm.sdk.b.c() {};
      this.kry = paramm;
      this.ktc = paramc;
      this.kje = paramInt;
      AppMethodBeat.o(45543);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(45545);
      com.tencent.mm.sdk.b.a.IbL.c(this.ktd);
      AppMethodBeat.o(45545);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(45546);
      bhO();
      ad.i("MicroMsg.JsApiMakeVoIPCall", "makeVoIPCall = %d", new Object[] { Integer.valueOf(this.status) });
      if (this.status == 1)
      {
        this.ktc.h(this.kje, this.kry.e("cancel", null));
        AppMethodBeat.o(45546);
        return;
      }
      if (this.status == 2)
      {
        this.ktc.h(this.kje, this.kry.e("ok", null));
        AppMethodBeat.o(45546);
        return;
      }
      if (this.status == 3)
      {
        this.ktc.h(this.kje, this.kry.e("fail:network error", null));
        AppMethodBeat.o(45546);
        return;
      }
      if (this.status == 4)
      {
        this.ktc.h(this.kje, this.kry.e("fail:param not match", null));
        AppMethodBeat.o(45546);
        return;
      }
      this.ktc.h(this.kje, this.kry.e("fail:unknow", null));
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