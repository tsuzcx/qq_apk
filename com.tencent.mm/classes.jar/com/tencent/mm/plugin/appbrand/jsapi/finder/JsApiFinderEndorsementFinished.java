package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y;

public final class JsApiFinderEndorsementFinished
  extends c<y>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "endorsementFinished";
  
  static class FinderUserPageTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<FinderUserPageTask> CREATOR;
    private String username;
    
    static
    {
      AppMethodBeat.i(163944);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(163944);
    }
    
    private FinderUserPageTask(Parcel paramParcel)
    {
      AppMethodBeat.i(163940);
      h(paramParcel);
      AppMethodBeat.o(163940);
    }
    
    public FinderUserPageTask(String paramString)
    {
      this.username = paramString;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(163943);
      AppMethodBeat.o(163943);
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(163941);
      this.username = paramParcel.readString();
      AppMethodBeat.o(163941);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(163942);
      paramParcel.writeString(this.username);
      AppMethodBeat.o(163942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiFinderEndorsementFinished
 * JD-Core Version:    0.7.0.1
 */