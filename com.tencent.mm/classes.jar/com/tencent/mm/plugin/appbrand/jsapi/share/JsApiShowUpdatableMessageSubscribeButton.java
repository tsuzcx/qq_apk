package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import junit.framework.Assert;

public final class JsApiShowUpdatableMessageSubscribeButton
  extends a<q>
{
  public static final int CTRL_INDEX = 465;
  public static final String NAME = "showUpdatableMessageSubscribeButton";
  
  static class ShowUpdatableMessageSubscribeButtonTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ShowUpdatableMessageSubscribeButtonTask> CREATOR;
    public String cmu;
    
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
      e(paramParcel);
      AppMethodBeat.o(46790);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(46791);
      if (g.ab(m.class) == null)
      {
        ad.e("MicroMsg.ShowUpdatableMessageSubscribeButtonTask", "IWxaUpdateableMsgService is null, err, return");
        if (i.IS_FLAVOR_RED) {
          Assert.assertTrue("IWxaUpdateableMsgService is null, err, @tummy", false);
        }
        AppMethodBeat.o(46791);
        return;
      }
      c localc = ((m)g.ab(m.class)).Cd(this.cmu);
      if ((localc != null) && ((localc.field_btnState == 2) || (localc.field_msgState != 0)))
      {
        ad.e("MicroMsg.ShowUpdatableMessageSubscribeButtonTask", "shareKey:%s btnState:%d msgState:%d ingore already process", new Object[] { this.cmu, Integer.valueOf(localc.field_btnState), Integer.valueOf(localc.field_msgState) });
        AppMethodBeat.o(46791);
        return;
      }
      ((m)g.ab(m.class)).aj(this.cmu, 1);
      AppMethodBeat.o(46791);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(46792);
      this.cmu = paramParcel.readString();
      AppMethodBeat.o(46792);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46793);
      paramParcel.writeString(this.cmu);
      AppMethodBeat.o(46793);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton
 * JD-Core Version:    0.7.0.1
 */