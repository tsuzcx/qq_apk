package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.finder.cgi.be;

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
      AppMethodBeat.i(188406);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(188406);
    }
    
    public RefreshFinderUserpageTask() {}
    
    public RefreshFinderUserpageTask(Parcel paramParcel)
    {
      AppMethodBeat.i(188404);
      e(paramParcel);
      AppMethodBeat.o(188404);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(188405);
      be localbe = new be(u.aAu(), 0L, null, 0, null);
      localbe.rKg = true;
      g.aiU().a(localbe, 0);
      bhX();
      AppMethodBeat.o(188405);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeclareOriginalFinished
 * JD-Core Version:    0.7.0.1
 */