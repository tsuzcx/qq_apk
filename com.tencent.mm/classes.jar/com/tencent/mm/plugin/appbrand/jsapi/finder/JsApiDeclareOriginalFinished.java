package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.finder.cgi.dt;

public final class JsApiDeclareOriginalFinished
  extends c<y>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "declareOriginalFinished";
  
  static class RefreshFinderUserpageTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RefreshFinderUserpageTask> CREATOR;
    
    static
    {
      AppMethodBeat.i(326617);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(326617);
    }
    
    public RefreshFinderUserpageTask() {}
    
    public RefreshFinderUserpageTask(Parcel paramParcel)
    {
      AppMethodBeat.i(326616);
      h(paramParcel);
      AppMethodBeat.o(326616);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(326620);
      dt localdt = new dt(z.bAW(), 0L, null, 0, null, 0, 0L, false, "", 0L, Integer.valueOf(0), Long.valueOf(0L), "");
      localdt.ADC = true;
      h.aZW().a(localdt, 0);
      cpA();
      AppMethodBeat.o(326620);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeclareOriginalFinished
 * JD-Core Version:    0.7.0.1
 */