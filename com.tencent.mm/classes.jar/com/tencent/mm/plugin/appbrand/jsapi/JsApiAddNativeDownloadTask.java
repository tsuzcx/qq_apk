package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.i;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class JsApiAddNativeDownloadTask
  extends d<s>
{
  private static final int CTRL_INDEX = 428;
  private static final String NAME = "addNativeDownloadTask";
  
  static class AddNativeDownloadTaskTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddNativeDownloadTaskTask> CREATOR;
    public int cSx = 0;
    public long dCa = 0L;
    private IListener lyu;
    Runnable lyv;
    
    static
    {
      AppMethodBeat.i(45448);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45448);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45441);
      Log.i("MicroMsg.JsApiAddNativeDownloadTask", "runInMainProcess flag:%d", new Object[] { Integer.valueOf(this.cSx) });
      this.lyu = new IListener() {};
      EventCenter.instance.add(this.lyu);
      AppMethodBeat.o(45441);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45442);
      if (this.lyv != null) {
        this.lyv.run();
      }
      AppMethodBeat.o(45442);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45443);
      this.cSx = paramParcel.readInt();
      this.dCa = paramParcel.readLong();
      AppMethodBeat.o(45443);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45444);
      paramParcel.writeInt(this.cSx);
      paramParcel.writeLong(this.dCa);
      AppMethodBeat.o(45444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask
 * JD-Core Version:    0.7.0.1
 */