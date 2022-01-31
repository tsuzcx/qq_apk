package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.f;

public final class a$a
  implements f
{
  public int height;
  public String id;
  public int width;
  
  public final void d(Parcel paramParcel)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
  }
  
  public final void readFromParcel(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.a.a
 * JD-Core Version:    0.7.0.1
 */