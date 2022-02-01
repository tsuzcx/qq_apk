package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.finder.cgi.cr;

public final class JsApiDeclareOriginalFinished
  extends c<v>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "declareOriginalFinished";
  
  static class RefreshFinderUserpageTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RefreshFinderUserpageTask> CREATOR;
    
    static
    {
      AppMethodBeat.i(279603);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(279603);
    }
    
    public RefreshFinderUserpageTask() {}
    
    public RefreshFinderUserpageTask(Parcel paramParcel)
    {
      AppMethodBeat.i(279601);
      f(paramParcel);
      AppMethodBeat.o(279601);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(279602);
      cr localcr = new cr(z.bdh(), 0L, null, 0, null, 0, 0L);
      localcr.xer = true;
      h.aGY().a(localcr, 0);
      bPt();
      AppMethodBeat.o(279602);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeclareOriginalFinished
 * JD-Core Version:    0.7.0.1
 */