package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

public final class JsApiAddNativeDownloadTask
  extends a<q>
{
  private static final int CTRL_INDEX = 428;
  private static final String NAME = "addNativeDownloadTask";
  
  static class AddNativeDownloadTaskTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddNativeDownloadTaskTask> CREATOR;
    public long cYu = 0L;
    public int drx = 0;
    private c jWO;
    Runnable jWP;
    
    static
    {
      AppMethodBeat.i(45448);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45448);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45441);
      ac.i("MicroMsg.JsApiAddNativeDownloadTask", "runInMainProcess flag:%d", new Object[] { Integer.valueOf(this.drx) });
      this.jWO = new c() {};
      com.tencent.mm.sdk.b.a.GpY.b(this.jWO);
      AppMethodBeat.o(45441);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(45442);
      if (this.jWP != null) {
        this.jWP.run();
      }
      AppMethodBeat.o(45442);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45443);
      this.drx = paramParcel.readInt();
      this.cYu = paramParcel.readLong();
      AppMethodBeat.o(45443);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45444);
      paramParcel.writeInt(this.drx);
      paramParcel.writeLong(this.cYu);
      AppMethodBeat.o(45444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask
 * JD-Core Version:    0.7.0.1
 */