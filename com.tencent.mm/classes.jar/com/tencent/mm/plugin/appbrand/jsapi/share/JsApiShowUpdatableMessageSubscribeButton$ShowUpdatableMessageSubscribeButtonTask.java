package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ae.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.y;

class JsApiShowUpdatableMessageSubscribeButton$ShowUpdatableMessageSubscribeButtonTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ShowUpdatableMessageSubscribeButtonTask> CREATOR = new JsApiShowUpdatableMessageSubscribeButton.ShowUpdatableMessageSubscribeButtonTask.1();
  public String dTX;
  
  public JsApiShowUpdatableMessageSubscribeButton$ShowUpdatableMessageSubscribeButtonTask() {}
  
  public JsApiShowUpdatableMessageSubscribeButton$ShowUpdatableMessageSubscribeButtonTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    b localb = ((k)g.r(k.class)).jv(this.dTX);
    if ((localb != null) && ((localb.field_btnState == 2) || (localb.field_msgState != 0)))
    {
      y.e("MicroMsg.ShowUpdatableMessageSubscribeButtonTask", "shareKey:%s btnState:%d msgState:%d ingore already process", new Object[] { this.dTX, Integer.valueOf(localb.field_btnState), Integer.valueOf(localb.field_msgState) });
      return;
    }
    ((k)g.r(k.class)).L(this.dTX, 1);
  }
  
  public final void e(Parcel paramParcel)
  {
    this.dTX = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.dTX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton.ShowUpdatableMessageSubscribeButtonTask
 * JD-Core Version:    0.7.0.1
 */