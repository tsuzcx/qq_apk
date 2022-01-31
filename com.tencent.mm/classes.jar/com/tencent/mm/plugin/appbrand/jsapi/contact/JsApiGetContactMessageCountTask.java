package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;

class JsApiGetContactMessageCountTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetContactMessageCountTask> CREATOR;
  public int cmy;
  public Runnable hxp;
  public String username;
  
  static
  {
    AppMethodBeat.i(131018);
    CREATOR = new JsApiGetContactMessageCountTask.1();
    AppMethodBeat.o(131018);
  }
  
  public JsApiGetContactMessageCountTask() {}
  
  public JsApiGetContactMessageCountTask(Parcel paramParcel)
  {
    AppMethodBeat.i(131013);
    f(paramParcel);
    AppMethodBeat.o(131013);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(131014);
    ak localak = ((j)g.E(j.class)).YF().arH(this.username);
    if (localak == null)
    {
      this.cmy = -1;
      aBp();
      AppMethodBeat.o(131014);
      return;
    }
    this.cmy = localak.field_unReadCount;
    aBp();
    AppMethodBeat.o(131014);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(131015);
    if (this.hxp != null) {
      this.hxp.run();
    }
    AppMethodBeat.o(131015);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(131016);
    this.username = paramParcel.readString();
    this.cmy = paramParcel.readInt();
    AppMethodBeat.o(131016);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131017);
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.cmy);
    AppMethodBeat.o(131017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiGetContactMessageCountTask
 * JD-Core Version:    0.7.0.1
 */