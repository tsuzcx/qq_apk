package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;

class JsApiGetContactMessageCountTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetContactMessageCountTask> CREATOR;
  public int dCm;
  public Runnable lyv;
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
  
  public final void bjj()
  {
    AppMethodBeat.i(46270);
    az localaz = ((l)g.af(l.class)).aST().bjY(this.username);
    if (localaz == null)
    {
      this.dCm = -1;
      bDU();
      AppMethodBeat.o(46270);
      return;
    }
    this.dCm = localaz.field_unReadCount;
    bDU();
    AppMethodBeat.o(46270);
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(46271);
    if (this.lyv != null) {
      this.lyv.run();
    }
    AppMethodBeat.o(46271);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(46272);
    this.username = paramParcel.readString();
    this.dCm = paramParcel.readInt();
    AppMethodBeat.o(46272);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46273);
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.dCm);
    AppMethodBeat.o(46273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiGetContactMessageCountTask
 * JD-Core Version:    0.7.0.1
 */