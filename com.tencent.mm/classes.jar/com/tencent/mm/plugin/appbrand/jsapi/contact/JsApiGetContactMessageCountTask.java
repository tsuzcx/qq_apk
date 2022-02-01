package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;

class JsApiGetContactMessageCountTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetContactMessageCountTask> CREATOR;
  public int fuP;
  public Runnable otv;
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
    f(paramParcel);
    AppMethodBeat.o(46269);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(46270);
    az localaz = ((n)h.ae(n.class)).bbR().bwx(this.username);
    if (localaz == null)
    {
      this.fuP = -1;
      bPt();
      AppMethodBeat.o(46270);
      return;
    }
    this.fuP = localaz.field_unReadCount;
    bPt();
    AppMethodBeat.o(46270);
  }
  
  public final void bsK()
  {
    AppMethodBeat.i(46271);
    if (this.otv != null) {
      this.otv.run();
    }
    AppMethodBeat.o(46271);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(46272);
    this.username = paramParcel.readString();
    this.fuP = paramParcel.readInt();
    AppMethodBeat.o(46272);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46273);
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.fuP);
    AppMethodBeat.o(46273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiGetContactMessageCountTask
 * JD-Core Version:    0.7.0.1
 */