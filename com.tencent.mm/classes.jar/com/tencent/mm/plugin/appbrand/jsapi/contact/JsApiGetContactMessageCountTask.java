package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.az;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;

class JsApiGetContactMessageCountTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetContactMessageCountTask> CREATOR;
  public int cYG;
  public Runnable jWP;
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
  
  public final void aLq()
  {
    AppMethodBeat.i(46270);
    ap localap = ((k)g.ab(k.class)).awG().aNI(this.username);
    if (localap == null)
    {
      this.cYG = -1;
      bet();
      AppMethodBeat.o(46270);
      return;
    }
    this.cYG = localap.field_unReadCount;
    bet();
    AppMethodBeat.o(46270);
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(46271);
    if (this.jWP != null) {
      this.jWP.run();
    }
    AppMethodBeat.o(46271);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(46272);
    this.username = paramParcel.readString();
    this.cYG = paramParcel.readInt();
    AppMethodBeat.o(46272);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46273);
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.cYG);
    AppMethodBeat.o(46273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiGetContactMessageCountTask
 * JD-Core Version:    0.7.0.1
 */