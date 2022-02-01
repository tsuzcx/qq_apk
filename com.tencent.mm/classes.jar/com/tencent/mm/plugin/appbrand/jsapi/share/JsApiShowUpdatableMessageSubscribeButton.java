package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.c.d;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import junit.framework.Assert;

public final class JsApiShowUpdatableMessageSubscribeButton
  extends c<y>
{
  public static final int CTRL_INDEX = 465;
  public static final String NAME = "showUpdatableMessageSubscribeButton";
  
  static class ShowUpdatableMessageSubscribeButtonTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ShowUpdatableMessageSubscribeButtonTask> CREATOR;
    public String eoU;
    
    static
    {
      AppMethodBeat.i(46794);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46794);
    }
    
    public ShowUpdatableMessageSubscribeButtonTask() {}
    
    public ShowUpdatableMessageSubscribeButtonTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46790);
      h(paramParcel);
      AppMethodBeat.o(46790);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(46791);
      if (h.ax(m.class) == null)
      {
        Log.e("MicroMsg.ShowUpdatableMessageSubscribeButtonTask", "IWxaUpdateableMsgService is null, err, return");
        if (BuildInfo.IS_FLAVOR_RED) {
          Assert.assertTrue("IWxaUpdateableMsgService is null, err, @tummy", false);
        }
        AppMethodBeat.o(46791);
        return;
      }
      d locald = ((m)h.ax(m.class)).KL(this.eoU);
      if ((locald != null) && ((locald.field_btnState == 2) || (locald.field_msgState != 0)))
      {
        Log.e("MicroMsg.ShowUpdatableMessageSubscribeButtonTask", "shareKey:%s btnState:%d msgState:%d ingore already process", new Object[] { this.eoU, Integer.valueOf(locald.field_btnState), Integer.valueOf(locald.field_msgState) });
        AppMethodBeat.o(46791);
        return;
      }
      ((m)h.ax(m.class)).aR(this.eoU, 1);
      AppMethodBeat.o(46791);
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(46792);
      this.eoU = paramParcel.readString();
      AppMethodBeat.o(46792);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46793);
      paramParcel.writeString(this.eoU);
      AppMethodBeat.o(46793);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton
 * JD-Core Version:    0.7.0.1
 */