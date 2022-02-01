package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.finder.cgi.bf;

public final class JsApiDeclareOriginalFinished
  extends a<r>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "declareOriginalFinished";
  
  static class RefreshFinderUserpageTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RefreshFinderUserpageTask> CREATOR;
    
    static
    {
      AppMethodBeat.i(222533);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(222533);
    }
    
    public RefreshFinderUserpageTask() {}
    
    public RefreshFinderUserpageTask(Parcel paramParcel)
    {
      AppMethodBeat.i(222531);
      e(paramParcel);
      AppMethodBeat.o(222531);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(222532);
      bf localbf = new bf(v.aAK(), 0L, null, 0, null);
      localbf.rSt = true;
      g.ajj().a(localbf, 0);
      biG();
      AppMethodBeat.o(222532);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeclareOriginalFinished
 * JD-Core Version:    0.7.0.1
 */