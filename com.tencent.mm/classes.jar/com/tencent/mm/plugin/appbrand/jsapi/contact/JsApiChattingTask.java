package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.m.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;

public class JsApiChattingTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiChattingTask> CREATOR;
  public String jOo;
  public Runnable jwt;
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
  
  public final void aEA()
  {
    AppMethodBeat.i(46242);
    if (this.jwt != null) {
      this.jwt.run();
    }
    AppMethodBeat.o(46242);
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(46241);
    if (!g.afz().gcn)
    {
      aXw();
      AppMethodBeat.o(46241);
      return;
    }
    af localaf = ((k)g.ab(k.class)).apM().aHY(this.username);
    ad.d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[] { this.jOo, this.username, this.nickname });
    if ((localaf == null) || ((int)localaf.fId == 0))
    {
      localaf = new af(this.username);
      localaf.setType(0);
      localaf.nd(this.nickname);
      ((k)g.ab(k.class)).apM().af(localaf);
      ad.i("MicroMsg.JsApiChattingTask", "%s save to contact_table", new Object[] { this.username });
    }
    ((m)g.ab(m.class)).b(this.username, new m.a()
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
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(46243);
    this.jOo = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    AppMethodBeat.o(46243);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46244);
    paramParcel.writeString(this.jOo);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    AppMethodBeat.o(46244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask
 * JD-Core Version:    0.7.0.1
 */