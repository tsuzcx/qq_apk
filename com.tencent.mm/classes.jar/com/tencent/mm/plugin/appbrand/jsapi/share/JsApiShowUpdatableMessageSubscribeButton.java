package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.f;
import junit.framework.Assert;

public final class JsApiShowUpdatableMessageSubscribeButton
  extends a<r>
{
  public static final int CTRL_INDEX = 465;
  public static final String NAME = "showUpdatableMessageSubscribeButton";
  
  static class ShowUpdatableMessageSubscribeButtonTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ShowUpdatableMessageSubscribeButtonTask> CREATOR;
    public String bCZ;
    
    static
    {
      AppMethodBeat.i(131458);
      CREATOR = new JsApiShowUpdatableMessageSubscribeButton.ShowUpdatableMessageSubscribeButtonTask.1();
      AppMethodBeat.o(131458);
    }
    
    public ShowUpdatableMessageSubscribeButtonTask() {}
    
    public ShowUpdatableMessageSubscribeButtonTask(Parcel paramParcel)
    {
      AppMethodBeat.i(131454);
      f(paramParcel);
      AppMethodBeat.o(131454);
    }
    
    public final void ata()
    {
      AppMethodBeat.i(131455);
      if (g.E(k.class) == null)
      {
        ab.e("MicroMsg.ShowUpdatableMessageSubscribeButtonTask", "IWxaUpdateableMsgService is null, err, return");
        if (f.IS_FLAVOR_RED) {
          Assert.assertTrue("IWxaUpdateableMsgService is null, err, @tummy", false);
        }
        AppMethodBeat.o(131455);
        return;
      }
      b localb = ((k)g.E(k.class)).qj(this.bCZ);
      if ((localb != null) && ((localb.field_btnState == 2) || (localb.field_msgState != 0)))
      {
        ab.e("MicroMsg.ShowUpdatableMessageSubscribeButtonTask", "shareKey:%s btnState:%d msgState:%d ingore already process", new Object[] { this.bCZ, Integer.valueOf(localb.field_btnState), Integer.valueOf(localb.field_msgState) });
        AppMethodBeat.o(131455);
        return;
      }
      ((k)g.E(k.class)).T(this.bCZ, 1);
      AppMethodBeat.o(131455);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(131456);
      this.bCZ = paramParcel.readString();
      AppMethodBeat.o(131456);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(131457);
      paramParcel.writeString(this.bCZ);
      AppMethodBeat.o(131457);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton
 * JD-Core Version:    0.7.0.1
 */