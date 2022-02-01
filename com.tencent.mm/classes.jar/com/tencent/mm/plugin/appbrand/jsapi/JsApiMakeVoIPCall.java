package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.yb;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.event.EventCenter;
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
    private int okO;
    private o ovN;
    private e ovO;
    private IListener ovP;
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
      this.ovP = new IListener() {};
      f(paramParcel);
      AppMethodBeat.o(45544);
    }
    
    public StartVoIPCall(o paramo, e parame, int paramInt)
    {
      AppMethodBeat.i(45543);
      this.ovP = new IListener() {};
      this.ovN = paramo;
      this.ovO = parame;
      this.okO = paramInt;
      AppMethodBeat.o(45543);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(45545);
      EventCenter.instance.addListener(this.ovP);
      AppMethodBeat.o(45545);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(45546);
      bPk();
      Log.i("MicroMsg.JsApiMakeVoIPCall", "makeVoIPCall = %d", new Object[] { Integer.valueOf(this.status) });
      if (this.status == 1)
      {
        this.ovO.j(this.okO, this.ovN.h("cancel", null));
        AppMethodBeat.o(45546);
        return;
      }
      if (this.status == 2)
      {
        this.ovO.j(this.okO, this.ovN.h("ok", null));
        AppMethodBeat.o(45546);
        return;
      }
      if (this.status == 3)
      {
        this.ovO.j(this.okO, this.ovN.h("fail:network error", null));
        AppMethodBeat.o(45546);
        return;
      }
      if (this.status == 4)
      {
        this.ovO.j(this.okO, this.ovN.h("fail:param not match", null));
        AppMethodBeat.o(45546);
        return;
      }
      this.ovO.j(this.okO, this.ovN.h("fail:unknow", null));
      AppMethodBeat.o(45546);
    }
    
    public final void f(Parcel paramParcel)
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