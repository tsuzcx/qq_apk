package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.f;

public final class h$b
  implements f
{
  String cJG;
  boolean hoT;
  boolean hoU;
  String id;
  
  public final void e(Parcel paramParcel)
  {
    int j = 1;
    AppMethodBeat.i(10842);
    paramParcel.writeString(this.id);
    if (this.hoT)
    {
      i = 1;
      paramParcel.writeInt(i);
      paramParcel.writeString(this.cJG);
      if (!this.hoU) {
        break label64;
      }
    }
    label64:
    for (int i = j;; i = 0)
    {
      paramParcel.writeInt(i);
      AppMethodBeat.o(10842);
      return;
      i = 0;
      break;
    }
  }
  
  public final void readFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(10843);
    this.id = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.hoT = bool1;
      this.cJG = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hoU = bool1;
      AppMethodBeat.o(10843);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.h.b
 * JD-Core Version:    0.7.0.1
 */