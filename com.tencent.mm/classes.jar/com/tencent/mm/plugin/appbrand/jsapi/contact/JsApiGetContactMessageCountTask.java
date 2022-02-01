package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;

class JsApiGetContactMessageCountTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetContactMessageCountTask> CREATOR;
  public int hzj;
  public Runnable rxj;
  public String username;
  
  static
  {
    AppMethodBeat.i(46274);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46274);
  }
  
  public JsApiGetContactMessageCountTask() {}
  
  public JsApiGetContactMessageCountTask(Parcel paramParcel)
  {
    AppMethodBeat.i(46269);
    h(paramParcel);
    AppMethodBeat.o(46269);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(46270);
    bb localbb = ((n)h.ax(n.class)).bzG().bxM(this.username);
    if (localbb == null)
    {
      this.hzj = -1;
      cpA();
      AppMethodBeat.o(46270);
      return;
    }
    this.hzj = localbb.field_unReadCount;
    cpA();
    AppMethodBeat.o(46270);
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(46271);
    if (this.rxj != null) {
      this.rxj.run();
    }
    AppMethodBeat.o(46271);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(46272);
    this.username = paramParcel.readString();
    this.hzj = paramParcel.readInt();
    AppMethodBeat.o(46272);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46273);
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.hzj);
    AppMethodBeat.o(46273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiGetContactMessageCountTask
 * JD-Core Version:    0.7.0.1
 */