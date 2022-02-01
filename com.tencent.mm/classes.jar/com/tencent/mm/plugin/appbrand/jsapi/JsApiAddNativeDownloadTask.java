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
import com.tencent.mm.sdk.platformtools.ad;
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
    public int dDp = 0;
    public long djM = 0L;
    private c krf;
    Runnable krg;
    
    static
    {
      AppMethodBeat.i(45448);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45448);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(45441);
      ad.i("MicroMsg.JsApiAddNativeDownloadTask", "runInMainProcess flag:%d", new Object[] { Integer.valueOf(this.dDp) });
      this.krf = new c() {};
      com.tencent.mm.sdk.b.a.IbL.b(this.krf);
      AppMethodBeat.o(45441);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(45442);
      if (this.krg != null) {
        this.krg.run();
      }
      AppMethodBeat.o(45442);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45443);
      this.dDp = paramParcel.readInt();
      this.djM = paramParcel.readLong();
      AppMethodBeat.o(45443);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45444);
      paramParcel.writeInt(this.dDp);
      paramParcel.writeLong(this.djM);
      AppMethodBeat.o(45444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask
 * JD-Core Version:    0.7.0.1
 */