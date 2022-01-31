package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.f;

final class g$a
  implements f
{
  String caM;
  String id;
  
  public final void d(Parcel paramParcel)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.caM);
  }
  
  public final void readFromParcel(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.caM = paramParcel.readString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.g.a
 * JD-Core Version:    0.7.0.1
 */