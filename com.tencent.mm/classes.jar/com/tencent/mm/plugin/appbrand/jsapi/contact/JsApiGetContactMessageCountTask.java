package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;

class JsApiGetContactMessageCountTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetContactMessageCountTask> CREATOR;
  public int dla;
  public Runnable kuv;
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
    e(paramParcel);
    AppMethodBeat.o(46269);
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(46270);
    au localau = ((l)g.ab(l.class)).azL().aVa(this.username);
    if (localau == null)
    {
      this.dla = -1;
      biG();
      AppMethodBeat.o(46270);
      return;
    }
    this.dla = localau.field_unReadCount;
    biG();
    AppMethodBeat.o(46270);
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(46271);
    if (this.kuv != null) {
      this.kuv.run();
    }
    AppMethodBeat.o(46271);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(46272);
    this.username = paramParcel.readString();
    this.dla = paramParcel.readInt();
    AppMethodBeat.o(46272);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46273);
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.dla);
    AppMethodBeat.o(46273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiGetContactMessageCountTask
 * JD-Core Version:    0.7.0.1
 */