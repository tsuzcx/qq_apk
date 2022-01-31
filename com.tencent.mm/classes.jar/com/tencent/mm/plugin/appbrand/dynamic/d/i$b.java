package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.f;

public final class i$b
  implements f
{
  String id;
  String url;
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(10848);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.url);
    AppMethodBeat.o(10848);
  }
  
  public final void readFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(10849);
    this.id = paramParcel.readString();
    this.url = paramParcel.readString();
    AppMethodBeat.o(10849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.i.b
 * JD-Core Version:    0.7.0.1
 */