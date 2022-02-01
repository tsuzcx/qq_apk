package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;

class JsApiGetContactMessageCountTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetContactMessageCountTask> CREATOR;
  public int dbk;
  public Runnable jwt;
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
  
  public final void aEA()
  {
    AppMethodBeat.i(46271);
    if (this.jwt != null) {
      this.jwt.run();
    }
    AppMethodBeat.o(46271);
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(46270);
    am localam = ((k)g.ab(k.class)).apR().aIn(this.username);
    if (localam == null)
    {
      this.dbk = -1;
      aXw();
      AppMethodBeat.o(46270);
      return;
    }
    this.dbk = localam.field_unReadCount;
    aXw();
    AppMethodBeat.o(46270);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(46272);
    this.username = paramParcel.readString();
    this.dbk = paramParcel.readInt();
    AppMethodBeat.o(46272);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46273);
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.dbk);
    AppMethodBeat.o(46273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiGetContactMessageCountTask
 * JD-Core Version:    0.7.0.1
 */