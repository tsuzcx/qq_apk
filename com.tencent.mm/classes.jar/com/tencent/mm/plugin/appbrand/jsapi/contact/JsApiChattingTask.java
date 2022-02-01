package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public class JsApiChattingTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiChattingTask> CREATOR;
  public String nickname;
  public String oOB;
  public String obc;
  public Runnable otv;
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
  
  public final void RW()
  {
    AppMethodBeat.i(46241);
    if (!h.aHE().kbT)
    {
      bPt();
      AppMethodBeat.o(46241);
      return;
    }
    as localas = ((n)h.ae(n.class)).bbL().RG(this.username);
    Log.d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[] { this.oOB, this.username, this.nickname });
    if ((localas == null) || ((int)localas.jxt == 0))
    {
      localas = new as(this.username);
      localas.setType(0);
      localas.setNickname(this.nickname);
      ((n)h.ae(n.class)).bbL().av(localas);
      Log.i("MicroMsg.JsApiChattingTask", "%s save to contact_table", new Object[] { this.username });
    }
    if (!Util.isNullOrNil(this.obc)) {
      ((q)h.ae(q.class)).c(this.obc, new q.a()
      {
        public final void b(WxaAttributes paramAnonymousWxaAttributes)
        {
          AppMethodBeat.i(46238);
          if (paramAnonymousWxaAttributes == null) {
            Log.w("MicroMsg.JsApiChattingTask", "privateUsername:%s info is null, err", new Object[] { JsApiChattingTask.this.obc });
          }
          AppMethodBeat.o(46238);
        }
      });
    }
    ((q)h.ae(q.class)).c(this.username, new q.a()
    {
      public final void b(WxaAttributes paramAnonymousWxaAttributes)
      {
        AppMethodBeat.i(266839);
        if (paramAnonymousWxaAttributes == null) {
          Log.w("MicroMsg.JsApiChattingTask", "info is null, err");
        }
        JsApiChattingTask.a(JsApiChattingTask.this);
        AppMethodBeat.o(266839);
      }
    });
    AppMethodBeat.o(46241);
  }
  
  public final void bsK()
  {
    AppMethodBeat.i(46242);
    if (this.otv != null) {
      this.otv.run();
    }
    AppMethodBeat.o(46242);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(46243);
    this.oOB = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.obc = paramParcel.readString();
    AppMethodBeat.o(46243);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46244);
    paramParcel.writeString(this.oOB);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.obc);
    AppMethodBeat.o(46244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask
 * JD-Core Version:    0.7.0.1
 */