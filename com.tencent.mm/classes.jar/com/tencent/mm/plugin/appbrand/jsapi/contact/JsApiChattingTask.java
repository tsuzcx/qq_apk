package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public class JsApiChattingTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiChattingTask> CREATOR = new JsApiChattingTask.2();
  public Runnable gfD;
  public String nickname;
  public String sessionFrom;
  public String username;
  
  public JsApiChattingTask() {}
  
  public JsApiChattingTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    ad localad = ((j)g.r(j.class)).Fw().abl(this.username);
    y.d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[] { this.sessionFrom, this.username, this.nickname });
    if ((localad == null) || ((int)localad.dBe == 0))
    {
      localad = new ad(this.username);
      localad.setType(0);
      localad.dk(this.nickname);
      ((j)g.r(j.class)).Fw().V(localad);
      y.i("MicroMsg.JsApiChattingTask", "%s save to contact_table", new Object[] { this.username });
    }
    ((c)g.r(c.class)).b(this.username, new JsApiChattingTask.1(this));
  }
  
  public final void Zv()
  {
    if (this.gfD != null) {
      this.gfD.run();
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.sessionFrom = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.sessionFrom);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask
 * JD-Core Version:    0.7.0.1
 */