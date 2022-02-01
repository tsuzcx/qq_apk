package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.service.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;

public class JsApiChattingTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiChattingTask> CREATOR;
  public String kJP;
  public Runnable krg;
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
  
  public final void aOA()
  {
    AppMethodBeat.i(46241);
    if (!g.ajA().gAD)
    {
      bhX();
      AppMethodBeat.o(46241);
      return;
    }
    am localam = ((l)g.ab(l.class)).azp().Bf(this.username);
    ad.d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[] { this.kJP, this.username, this.nickname });
    if ((localam == null) || ((int)localam.gfj == 0))
    {
      localam = new am(this.username);
      localam.setType(0);
      localam.sT(this.nickname);
      ((l)g.ab(l.class)).azp().ag(localam);
      ad.i("MicroMsg.JsApiChattingTask", "%s save to contact_table", new Object[] { this.username });
    }
    ((n)g.ab(n.class)).b(this.username, new n.a()
    {
      public final void b(WxaAttributes paramAnonymousWxaAttributes)
      {
        AppMethodBeat.i(46238);
        if (paramAnonymousWxaAttributes == null) {
          ad.w("MicroMsg.JsApiChattingTask", "info is null, err");
        }
        JsApiChattingTask.a(JsApiChattingTask.this);
        AppMethodBeat.o(46238);
      }
    });
    AppMethodBeat.o(46241);
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(46242);
    if (this.krg != null) {
      this.krg.run();
    }
    AppMethodBeat.o(46242);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(46243);
    this.kJP = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    AppMethodBeat.o(46243);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46244);
    paramParcel.writeString(this.kJP);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    AppMethodBeat.o(46244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask
 * JD-Core Version:    0.7.0.1
 */