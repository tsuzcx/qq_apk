package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.appbrand.service.s.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

public class JsApiChattingTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiChattingTask> CREATOR;
  public String nickname;
  public String rSr;
  public String rbO;
  public Runnable rxj;
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
    h(paramParcel);
    AppMethodBeat.o(46240);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(46241);
    if (!h.baC().mBZ)
    {
      cpA();
      AppMethodBeat.o(46241);
      return;
    }
    au localau = ((n)h.ax(n.class)).bzA().JE(this.username);
    Log.d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[] { this.rSr, this.username, this.nickname });
    if ((localau == null) || ((int)localau.maN == 0))
    {
      localau = new au(this.username);
      localau.setType(0);
      localau.setNickname(this.nickname);
      ((n)h.ax(n.class)).bzA().aB(localau);
      Log.i("MicroMsg.JsApiChattingTask", "%s save to contact_table", new Object[] { this.username });
    }
    if (!Util.isNullOrNil(this.rbO)) {
      ((s)h.ax(s.class)).c(this.rbO, new s.a()
      {
        public final void onGetWeAppInfo(WxaAttributes paramAnonymousWxaAttributes)
        {
          AppMethodBeat.i(46238);
          if (paramAnonymousWxaAttributes == null) {
            Log.w("MicroMsg.JsApiChattingTask", "privateUsername:%s info is null, err", new Object[] { JsApiChattingTask.this.rbO });
          }
          AppMethodBeat.o(46238);
        }
      });
    }
    ((s)h.ax(s.class)).c(this.username, new s.a()
    {
      public final void onGetWeAppInfo(WxaAttributes paramAnonymousWxaAttributes)
      {
        AppMethodBeat.i(327798);
        if (paramAnonymousWxaAttributes == null) {
          Log.w("MicroMsg.JsApiChattingTask", "info is null, err");
        }
        JsApiChattingTask.a(JsApiChattingTask.this);
        AppMethodBeat.o(327798);
      }
    });
    AppMethodBeat.o(46241);
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(46242);
    if (this.rxj != null) {
      this.rxj.run();
    }
    AppMethodBeat.o(46242);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(46243);
    this.rSr = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.rbO = paramParcel.readString();
    AppMethodBeat.o(46243);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46244);
    paramParcel.writeString(this.rSr);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.rbO);
    AppMethodBeat.o(46244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask
 * JD-Core Version:    0.7.0.1
 */