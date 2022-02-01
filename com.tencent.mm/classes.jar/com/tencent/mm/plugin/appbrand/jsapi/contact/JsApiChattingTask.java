package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public class JsApiChattingTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiChattingTask> CREATOR;
  public String lRW;
  public Runnable lyv;
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
    f(paramParcel);
    AppMethodBeat.o(46240);
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(46241);
    if (!g.aAf().hpY)
    {
      bDU();
      AppMethodBeat.o(46241);
      return;
    }
    as localas = ((l)g.af(l.class)).aSN().Kn(this.username);
    Log.d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[] { this.lRW, this.username, this.nickname });
    if ((localas == null) || ((int)localas.gMZ == 0))
    {
      localas = new as(this.username);
      localas.setType(0);
      localas.setNickname(this.nickname);
      ((l)g.af(l.class)).aSN().ap(localas);
      Log.i("MicroMsg.JsApiChattingTask", "%s save to contact_table", new Object[] { this.username });
    }
    ((q)g.af(q.class)).c(this.username, new q.a()
    {
      public final void b(WxaAttributes paramAnonymousWxaAttributes)
      {
        AppMethodBeat.i(46238);
        if (paramAnonymousWxaAttributes == null) {
          Log.w("MicroMsg.JsApiChattingTask", "info is null, err");
        }
        JsApiChattingTask.a(JsApiChattingTask.this);
        AppMethodBeat.o(46238);
      }
    });
    AppMethodBeat.o(46241);
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(46242);
    if (this.lyv != null) {
      this.lyv.run();
    }
    AppMethodBeat.o(46242);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(46243);
    this.lRW = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    AppMethodBeat.o(46243);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46244);
    paramParcel.writeString(this.lRW);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    AppMethodBeat.o(46244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask
 * JD-Core Version:    0.7.0.1
 */