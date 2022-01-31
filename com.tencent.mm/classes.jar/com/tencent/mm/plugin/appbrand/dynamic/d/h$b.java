package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.f;

public final class h$b
  implements f
{
  String cbd;
  boolean fVr;
  boolean fVs;
  String id;
  
  public final void d(Parcel paramParcel)
  {
    int j = 1;
    paramParcel.writeString(this.id);
    if (this.fVr)
    {
      i = 1;
      paramParcel.writeInt(i);
      paramParcel.writeString(this.cbd);
      if (!this.fVs) {
        break label52;
      }
    }
    label52:
    for (int i = j;; i = 0)
    {
      paramParcel.writeInt(i);
      return;
      i = 0;
      break;
    }
  }
  
  public final void readFromParcel(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.id = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.fVr = bool1;
      this.cbd = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label54;
      }
    }
    label54:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.fVs = bool1;
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