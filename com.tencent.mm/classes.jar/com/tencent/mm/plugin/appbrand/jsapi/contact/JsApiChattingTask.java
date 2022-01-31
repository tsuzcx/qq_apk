package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public class JsApiChattingTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiChattingTask> CREATOR;
  public Runnable hxp;
  public String nickname;
  public String sessionFrom;
  public String username;
  
  static
  {
    AppMethodBeat.i(130990);
    CREATOR = new JsApiChattingTask.2();
    AppMethodBeat.o(130990);
  }
  
  public JsApiChattingTask() {}
  
  public JsApiChattingTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130984);
    f(paramParcel);
    AppMethodBeat.o(130984);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130985);
    if (!g.RJ().eHg)
    {
      aBp();
      AppMethodBeat.o(130985);
      return;
    }
    ad localad = ((j)g.E(j.class)).YA().arw(this.username);
    ab.d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[] { this.sessionFrom, this.username, this.nickname });
    if ((localad == null) || ((int)localad.euF == 0))
    {
      localad = new ad(this.username);
      localad.setType(0);
      localad.jp(this.nickname);
      ((j)g.E(j.class)).YA().Y(localad);
      ab.i("MicroMsg.JsApiChattingTask", "%s save to contact_table", new Object[] { this.username });
    }
    ((i)g.E(i.class)).b(this.username, new JsApiChattingTask.1(this));
    AppMethodBeat.o(130985);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130986);
    if (this.hxp != null) {
      this.hxp.run();
    }
    AppMethodBeat.o(130986);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130987);
    this.sessionFrom = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    AppMethodBeat.o(130987);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130988);
    paramParcel.writeString(this.sessionFrom);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    AppMethodBeat.o(130988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask
 * JD-Core Version:    0.7.0.1
 */