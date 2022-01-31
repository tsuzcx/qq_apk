package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

class JsApiBatchGetContact$JsApiBatchGetContactTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiBatchGetContactTask> CREATOR;
  private String errMsg;
  private int hry;
  private r hxb;
  public ArrayList<String> hxr;
  private m hxs;
  private String hxt;
  
  static
  {
    AppMethodBeat.i(130404);
    CREATOR = new JsApiBatchGetContact.JsApiBatchGetContactTask.2();
    AppMethodBeat.o(130404);
  }
  
  public JsApiBatchGetContact$JsApiBatchGetContactTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130395);
    f(paramParcel);
    AppMethodBeat.o(130395);
  }
  
  public JsApiBatchGetContact$JsApiBatchGetContactTask(m paramm, r paramr, int paramInt, ArrayList<String> paramArrayList)
  {
    this.hxs = paramm;
    this.hxb = paramr;
    this.hry = paramInt;
    this.hxr = paramArrayList;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130397);
    d.post(new JsApiBatchGetContact.JsApiBatchGetContactTask.1(this), "AppBrandJsApiBatchGetContact");
    AppMethodBeat.o(130397);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130396);
    ab.i("MicroMsg.JsApiBatchGetContact", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.hxb.getAppId(), this.hxt, Integer.valueOf(this.hry), Boolean.valueOf(this.hxb.isRunning()) });
    if (!bo.isNullOrNil(this.hxt)) {
      this.hxb.h(this.hry, this.hxt);
    }
    for (;;)
    {
      aBk();
      AppMethodBeat.o(130396);
      return;
      this.hxb.h(this.hry, this.hxs.j(this.errMsg, null));
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130398);
    this.hxr = paramParcel.readArrayList(getClass().getClassLoader());
    this.hxt = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    AppMethodBeat.o(130398);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130399);
    paramParcel.writeList(this.hxr);
    paramParcel.writeString(this.hxt);
    paramParcel.writeString(this.errMsg);
    AppMethodBeat.o(130399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact.JsApiBatchGetContactTask
 * JD-Core Version:    0.7.0.1
 */