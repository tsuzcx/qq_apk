package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.finder.cgi.cn;

public final class JsApiDeclareOriginalFinished
  extends d<s>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "declareOriginalFinished";
  
  static class RefreshFinderUserpageTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RefreshFinderUserpageTask> CREATOR;
    
    static
    {
      AppMethodBeat.i(226837);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(226837);
    }
    
    public RefreshFinderUserpageTask() {}
    
    public RefreshFinderUserpageTask(Parcel paramParcel)
    {
      AppMethodBeat.i(226835);
      f(paramParcel);
      AppMethodBeat.o(226835);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(226836);
      cn localcn = new cn(z.aUg(), 0L, null, 0, null, 0, 0L);
      localcn.twC = true;
      g.azz().a(localcn, 0);
      bDU();
      AppMethodBeat.o(226836);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeclareOriginalFinished
 * JD-Core Version:    0.7.0.1
 */