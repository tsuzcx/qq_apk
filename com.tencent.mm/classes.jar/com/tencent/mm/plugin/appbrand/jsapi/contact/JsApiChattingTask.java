package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.o.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;

public class JsApiChattingTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiChattingTask> CREATOR;
  public String kNe;
  public Runnable kuv;
  public String nickname;
  public String username;
  
  static
  {
    AppMethodBeat.i(46246);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46246);
  }
  
  public JsApiChattingTask() {}
  
  public JsApiChattingTask(Parcel paramParcel)
  {
    AppMethodBeat.i(46240);
    e(paramParcel);
    AppMethodBeat.o(46240);
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(46241);
    if (!g.ajP().gDk)
    {
      biG();
      AppMethodBeat.o(46241);
      return;
    }
    an localan = ((l)g.ab(l.class)).azF().BH(this.username);
    ae.d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[] { this.kNe, this.username, this.nickname });
    if ((localan == null) || ((int)localan.ght == 0))
    {
      localan = new an(this.username);
      localan.setType(0);
      localan.to(this.nickname);
      ((l)g.ab(l.class)).azF().an(localan);
      ae.i("MicroMsg.JsApiChattingTask", "%s save to contact_table", new Object[] { this.username });
    }
    ((o)g.ab(o.class)).b(this.username, new o.a()
    {
      public final void b(WxaAttributes paramAnonymousWxaAttributes)
      {
        AppMethodBeat.i(46238);
        if (paramAnonymousWxaAttributes == null) {
          ae.w("MicroMsg.JsApiChattingTask", "info is null, err");
        }
        JsApiChattingTask.a(JsApiChattingTask.this);
        AppMethodBeat.o(46238);
      }
    });
    AppMethodBeat.o(46241);
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(46242);
    if (this.kuv != null) {
      this.kuv.run();
    }
    AppMethodBeat.o(46242);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(46243);
    this.kNe = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    AppMethodBeat.o(46243);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46244);
    paramParcel.writeString(this.kNe);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    AppMethodBeat.o(46244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask
 * JD-Core Version:    0.7.0.1
 */