package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.f;

final class g$a
  implements f
{
  String cHB;
  String id;
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(10834);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.cHB);
    AppMethodBeat.o(10834);
  }
  
  public final void readFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(10835);
    this.id = paramParcel.readString();
    this.cHB = paramParcel.readString();
    AppMethodBeat.o(10835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.g.a
 * JD-Core Version:    0.7.0.1
 */