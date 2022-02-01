package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.finder.cgi.aw;

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
      AppMethodBeat.i(186673);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(186673);
    }
    
    public RefreshFinderUserpageTask() {}
    
    public RefreshFinderUserpageTask(Parcel paramParcel)
    {
      AppMethodBeat.i(186671);
      e(paramParcel);
      AppMethodBeat.o(186671);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(186672);
      aw localaw = new aw(u.axE(), 0L, null, 0, null);
      localaw.qYP = true;
      g.agi().a(localaw, 0);
      bet();
      AppMethodBeat.o(186672);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeclareOriginalFinished
 * JD-Core Version:    0.7.0.1
 */