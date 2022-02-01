package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.finder.cgi.ae;

public final class JsApiDeclareOriginalFinished
  extends a<com.tencent.mm.plugin.appbrand.q>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "declareOriginalFinished";
  
  static class RefreshFinderUserpageTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RefreshFinderUserpageTask> CREATOR;
    
    static
    {
      AppMethodBeat.i(205040);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(205040);
    }
    
    public RefreshFinderUserpageTask() {}
    
    public RefreshFinderUserpageTask(Parcel paramParcel)
    {
      AppMethodBeat.i(205038);
      e(paramParcel);
      AppMethodBeat.o(205038);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(205039);
      ae localae = new ae(u.aqO(), 0L, null, 0, null);
      localae.qpJ = true;
      g.aeS().a(localae, 0);
      aXw();
      AppMethodBeat.o(205039);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeclareOriginalFinished
 * JD-Core Version:    0.7.0.1
 */